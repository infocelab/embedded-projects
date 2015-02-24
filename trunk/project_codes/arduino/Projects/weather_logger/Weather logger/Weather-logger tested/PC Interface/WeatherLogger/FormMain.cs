/******************************************************************************

    Weather Logger
        Log pressure, humidity and temperature in a microcontroller and
        read it via USB to display/save in a PC
 
    Copyright (C) 2010  Niras C. V.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

*******************************************************************************/
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using usbInterface;
using ZedGraph;
using WeatherLogger.Properties;
using System.IO.Ports;

using System;
using System.Collections.Generic;
//using System.Linq;
using System.Text;
using Microsoft.Office.Core;
using Excel = Microsoft.Office.Interop.Excel;
using System.Reflection;


namespace WeatherLogger
{
    public partial class FormMain : Form
    {
        MPUSB USB = new MPUSB();
        FileHandler fHandler = new FileHandler();
        DateSelector dateSel = new DateSelector();
        Preferences Pref = new Preferences();
        AboutBox About = new AboutBox();
        
        #region Private Variables
        byte[] txBuf = new byte[32];
        byte[] rxBuf = new byte[64];

        private const Int32 WM_DEVICECHANGE = 0x219;
        private IntPtr deviceNotificationHandle;
        private enum CMD : byte
        {
            READ_VERSION = 0x00,
            ID_BOARD = 0x31,
            TOGGLE_LED = 0x32,
            GET_FIRST_DATA = 0x33,
            GET_NEXT_DATA = 0x34,
            GET_CURR_DATA = 0x35,
            GET_LIVE_DATA = 0x40,
            SET_TIME = 0x41,
            SET_EEPROM = 0x42,
            RESET = 0xFF
        }
        internal class Data
        {
            internal byte[] humidity = new byte[2];
            internal byte[] temp = new byte[2];
            internal byte[] pressure = new byte[2];
        }
        internal class UserSettings
        {
            internal Color humidColor;
            internal Color tempColor;
            internal Color preColor;
            internal byte dataPtr;
            internal byte interval;
            internal Color dialColor;
            internal bool t12HrFormat;
            internal bool saveOnExit;
            internal bool showPointValuesInGraph;
        }
        internal struct Weather
        {
            internal XDate time;
            internal float temp;
            internal float pressure;
            internal float humidity;
        }
           
        Weather[] w = new Weather[1000];         // Weather structure array

        Weather currData = new Weather();
        internal UserSettings s = new UserSettings();
        internal int wIndex;
        internal int stt=0;
        internal Excel.Application oXL;
        internal Excel._Workbook oWB;
        internal Excel._Worksheet oSheet;
        internal Excel.Range oRng;

        internal bool goLive = true;
        #endregion 
        #region Form Area
        public FormMain()
        {
            InitializeComponent();
            s.humidColor = Settings.Default.HumidColor;
            s.preColor = Settings.Default.PreColor;
            s.tempColor = Settings.Default.TempColor;
            s.saveOnExit = Settings.Default.SaveOnExit;
            s.showPointValuesInGraph = Settings.Default.ShowPointValues;
            s.dialColor = ControlPaint.LightLight(Color.Honeydew);
            USB.RegisterForDeviceNotification(this.Handle, ref deviceNotificationHandle);
            USB.OpenUSB();
            if (USB.AttachedState == true) EnableButtons();
            else DisableButtons();
            ledYellow.Active = false;
            ResetW();
        }
        private void SetColor()
        {
            gHumid.NeedleColor = s.humidColor;
            gPressure.NeedleColor = s.preColor;
            gTemp.NeedleColor = s.tempColor;
            gHumid.DialColor = s.dialColor;
            gTemp.DialColor = s.dialColor;
            gPressure.DialColor = s.dialColor;
            // Graph Colours
            zgc.GraphPane.YAxis.Scale.FontSpec.FontColor = s.humidColor;
            zgc.GraphPane.YAxis.Title.FontSpec.FontColor = s.humidColor;
            zgc.GraphPane.CurveList[0].Color = s.humidColor;
            zgc.GraphPane.Y2Axis.Scale.FontSpec.FontColor = s.tempColor;
            zgc.GraphPane.Y2Axis.Title.FontSpec.FontColor = s.tempColor;
            zgc.GraphPane.CurveList[1].Color = s.tempColor;
            zgc.GraphPane.YAxisList[1].Scale.FontSpec.FontColor = s.preColor;
            zgc.GraphPane.YAxisList[1].Title.FontSpec.FontColor = s.preColor;
            zgc.GraphPane.CurveList[2].Color = s.preColor;
            zgc.IsShowPointValues = s.showPointValuesInGraph;
            zgc.Invalidate();
        }
        /**
         * Reset the struct w, by setting time value to Jan 1, 1970
        */
        private void ResetW()
        {
            for (wIndex = 0; wIndex < w.Length; wIndex++)
            {
                w[wIndex].time = new XDate(1970, 1, 1);
            }
            wIndex = w.Length - 1;
        }
        private void EnableButtons()
        {
            ledRed.Active = false;
            ledGreen.Active = true;
            tmrData.Enabled = true;
        }
        private void DisableButtons()
        {
            tmrData.Enabled = true;
            ledGreen.Active = false;
            ledRed.Active = true;
            gPressure.Value = gPressure.MinValue;
            gHumid.Value = gHumid.MinValue;
            gTemp.Value = gTemp.MinValue;
        }
        protected override void WndProc(ref Message m)
        {
            if (m.Msg == WM_DEVICECHANGE)
            {
                USB.OnDeviceChange(m);
                if (USB.AttachedState == true)
                {
                    EnableButtons();
                }
                else
                {
                    DisableButtons();
                }
            }
            base.WndProc(ref m);
        }

        private void FormMain_FormClosed(object sender, FormClosedEventArgs e)
        {
            USB.StopReceivingDeviceNotifications(deviceNotificationHandle);
            savePriferences();
        }

        private void GetSerialPorts()
        {
            string[] ArrayComPortsNames = null;
            int index = -1;
            string ComPortName = null;

            ArrayComPortsNames = SerialPort.GetPortNames();
            do
            {
                index += 1;
                cbxPorts.Items.Add(ArrayComPortsNames[index]);
            }
            while (!((ArrayComPortsNames[index] == ComPortName) ||
                                (index == ArrayComPortsNames.GetUpperBound(0))));
            cbxPorts.SelectedIndex = 0;
        }

        private void FormMain_Load(object sender, EventArgs e)
        {
            CreateGraph(zgc);
            SetSize();
            SetColor();
            Pref.SettingsChanged += new Preferences.SettingsChangedHandler(pSettingsChanged);
            GetSerialPorts();
        }
        #endregion
        #region Private Initialise Graph
        /**
         * Initialise ZedGraph
         */
        private void CreateGraph(ZedGraphControl zgc)
        {
            GraphPane myPane = zgc.GraphPane;
            myPane.Title.Text = "Weather Reports";
            myPane.XAxis.Title.Text = "Time";
            myPane.YAxis.Title.Text = "Relative Humidity, %";
            myPane.Y2Axis.Title.Text = "Temperature";

            PointPairList hList = new PointPairList();
            PointPairList tList = new PointPairList();
            PointPairList pList = new PointPairList();

            // Generate a red curve with diamond symbols, and "Humidity" in the legend
            LineItem myCurve = myPane.AddCurve("Humidity", hList, s.humidColor, SymbolType.Diamond);
            // Fill the symbols with white
            myCurve.Symbol.Fill = new Fill(Color.White);
            myCurve.Symbol.Size = 2;

            // Generate a blue curve with circle symbols, and "Temperature" in the legend
            myCurve = myPane.AddCurve("Temperature", tList, s.tempColor, SymbolType.Circle);
            // Fill the symbols with white
            myCurve.Symbol.Fill = new Fill(Color.White);
            // Associate this curve with the Y2 axis
            myCurve.IsY2Axis = true;
            myCurve.Symbol.Size = 2;

            // Generate a green curve with square symbols, and "Pressure" in the legend
            myCurve = myPane.AddCurve("Pressure", pList, s.preColor, SymbolType.Diamond);
            // Fill the symbols with white
            myCurve.Symbol.Fill = new Fill(Color.White);
            // Associate this curve with the second Y axis
            myCurve.YAxisIndex = 1;
            myCurve.Symbol.Size = 2;

            // Show the x axis grid
            myPane.XAxis.MajorGrid.IsVisible = true;

            // Make the Y axis scale red
            myPane.YAxis.Scale.FontSpec.FontColor = s.humidColor;
            myPane.YAxis.Title.FontSpec.FontColor = s.humidColor;
            // turn off the opposite tics so the Y tics don't show up on the Y2 axis
            myPane.YAxis.MajorTic.IsOpposite = false;
            myPane.YAxis.MinorTic.IsOpposite = false;
            // Don't display the Y zero line
            myPane.YAxis.MajorGrid.IsZeroLine = false;
            // Align the Y axis labels so they are flush to the axis
            myPane.YAxis.Scale.Align = AlignP.Inside;

            // Enable the Y2 axis display
            myPane.Y2Axis.IsVisible = true;
            // Make the Y2 axis scale blue
            myPane.Y2Axis.Scale.FontSpec.FontColor = s.tempColor;
            myPane.Y2Axis.Title.FontSpec.FontColor = s.tempColor;
            // turn off the opposite tics so the Y2 tics don't show up on the Y axis
            myPane.Y2Axis.MajorTic.IsOpposite = false;
            myPane.Y2Axis.MinorTic.IsOpposite = false;
            // Display the Y2 axis grid lines
            myPane.Y2Axis.MajorGrid.IsVisible = true;
            // Align the Y2 axis labels so they are flush to the axis
            myPane.Y2Axis.Scale.Align = AlignP.Inside;

            // Create a second Y Axis, green
            YAxis yAxis3 = new YAxis("WindSpeed , RPM");
            myPane.YAxisList.Add(yAxis3);
            yAxis3.Scale.FontSpec.FontColor = s.preColor;
            yAxis3.Title.FontSpec.FontColor = s.preColor;
            //yAxis3.Color = s.pressure;
            // turn off the opposite tics so the Y2 tics don't show up on the Y axis
            yAxis3.MajorTic.IsInside = false;
            yAxis3.MinorTic.IsInside = false;
            yAxis3.MajorTic.IsOpposite = false;
            yAxis3.MinorTic.IsOpposite = false;
            // Align the Y2 axis labels so they are flush to the axis
            yAxis3.Scale.Align = AlignP.Inside;
            // Fill the axis background with a gradient
            myPane.Chart.Fill = new Fill(Color.White, Color.LightGoldenrodYellow, 45.0f);
            myPane.XAxis.Type = AxisType.Date;
            myPane.XAxis.Scale.Format = "HH:mm";
            yAxis3.Scale.MajorStep = 1;
            yAxis3.Scale.MinorStep = 0.1;
            myPane.Y2Axis.Scale.MajorStep = 0.5;
            myPane.Y2Axis.Scale.MinorStep = 0.1;
            //myPane.YAxis.Scale.MajorStep = 1;
            //myPane.YAxis.Scale.MinorStep = 0.1;
            //myPane.XAxis.Scale.MajorStep = 10;
            //myPane.XAxis.Scale.MinGrace = 0.05;
            zgc.AxisChange();
        }
        #endregion 
        #region Private Graph Create
        /**
         * The function called from Timer Tick event handler
         * This in turn called the converData function to convert raw data from uC
         * In microcontroller only last read time is saved in each Weather data struct
         * It saves whole data for the current date to a file, when date changes while connected to uC
         */
        private void loadData(int points)
        {
            int index = 4;
            int hour;
            // rxBuf[0] and rxbuf[1] are DS1337 time registers (last read time)
            int min = (int)((rxBuf[0] >> 4) * 10); 

            min += (int)(rxBuf[0] & 0x0F);
            hour = (int) (rxBuf[1] & 0x0F);
            if ((rxBuf[1] & 0x40) == 0x40)      // 12 hr bit
            {
                if ((rxBuf[1] & 0x10) == 0x10)  //10 hr bit
                    hour += 10;
                if ((rxBuf[1] & 0x20) == 0x20)  // PM
                    hour += 12;
            }
            else
            {
                hour += (int)((rxBuf[1] >> 4) * 10);
            }
            // rxBuf[2] is the date
            // FirstReadTime = (hour * 60 + min) - (9 *rxBuf[3]);
            if (rxBuf[3] != 0)
            {
                DateTime timeNow = DateTime.Now;
                DateTime time = new DateTime(timeNow.Year, timeNow.Month, 
                    Convert.ToInt32(rxBuf[2].ToString("X2")), hour, min, 0); // BCD -> Hex -> Bin
                TimeSpan diff = new TimeSpan(0, rxBuf[3] * points, 0);
                time = time.Subtract(diff);
                s.interval = rxBuf[3];
                for (int i = 0; i < points; i++)
                {
                    //w[i].time = FirstReadTime + (rxBuf[3] * i);
                    time = time.AddMinutes(rxBuf[3]);
                    if (time > w[wIndex].time)
                    {
                        if (++wIndex >= w.Length)
                        {
                            // Save data When it overflows (Only save if dynamic updates running)
                            if (goLive && tmrData.Enabled) fHandler.writeFile(w, wIndex); 
                            wIndex = 0;
                        }

                        w[wIndex].time = time.ToOADate();
                        convertData(ref w[wIndex], ref index);
                        Redraw(wIndex);
                    }
                    if (index >= 64) index = 4; // First 4 bytes are other data
                    //if (index >= (6 * rxBuf[3])) break;
                }
            }

        }
        /**
         * Redraw graph, See ZedGraph documents for more details
         */
        private void Redraw(int dPtr)
        {
            int i, dMin;
            if (zgc.GraphPane.CurveList.Count <= 0)
                return;
            // Get the first CurveItem in the graph
            LineItem curve1 = zgc.GraphPane.CurveList["Humidity"] as LineItem;
            LineItem curve2 = zgc.GraphPane.CurveList["Temperature"] as LineItem;
            LineItem curve3 = zgc.GraphPane.CurveList["Pressure"] as LineItem;
            if (curve3 == null)
                return;
            // Get the PointPairList
            IPointListEdit list1 = curve1.Points as IPointListEdit;
            IPointListEdit list2 = curve2.Points as IPointListEdit;
            IPointListEdit list3 = curve3.Points as IPointListEdit;
            list1.Clear();
            list2.Clear();
            list3.Clear();
            // If this is null, it means the reference at curve.Points does not
            // support IPointListEdit, so we won't be able to modify it
            for (i = 0; i < w.Length; i++)
            {
                if (++dPtr >= w.Length) dPtr = 0;
                if (w[dPtr].time != new XDate(1970, 1, 1)) break;
            }
            dMin = dPtr;
            zgc.GraphPane.XAxis.Title.Text = "Date " + w[dMin].time.ToString("dd/MM/yyyy");
            for(i =0; i < w.Length; i++)
            {
                if (w[dPtr].time != new XDate(1970, 1, 1))
                {
                    list1.Add(w[dPtr].time, w[dPtr].humidity);
                    list2.Add(w[dPtr].time, w[dPtr].temp);
                    list3.Add(w[dPtr].time, w[dPtr].pressure);
                    wIndex = dPtr;
                }
                else break;
                if (++dPtr >= w.Length) dPtr = 0;
            }
            if(w[wIndex].time.DateTime.DayOfYear != w[dMin].time.DateTime.DayOfYear)
                zgc.GraphPane.XAxis.Title.Text += " - " + w[wIndex].time.ToString("dd/MM/yy");
            //zgc.GraphPane.XAxis.Scale.MajorStep = s.interval * 10;
            // Make sure the Y axis is rescaled to accommodate actual data
            zgc.AxisChange();
            // Force a redraw
            zgc.Invalidate();
        }
        #endregion
        #region Graph Size Control
        private void FormMain_Resize(object sender, EventArgs e)
        {
            SetSize();
        }
        private void SetSize()
        {
            //zgc.Location = new Point(150, 15);
            //zgc.Size = new Size(ClientRectangle.Width  - 175,
                //ClientRectangle.Height - 30);
            // Control is always 10 pixels inset from the client rectangle of the form
            int space;
            Rectangle formRect = this.ClientRectangle;
            if (formRect.Width < 800)
            {
                formRect.X += 150;
                formRect.Width -= 160;
                formRect.Height -= 60;
                formRect.Y += 25;
                gHumid.Size = new Size(125, 125);
                gTemp.Size = new Size(125, 125);
                gPressure.Size = new Size(125, 125);
            }
            else
            {
                formRect.X += 175;
                formRect.Width -= 185;
                formRect.Height -= 60;
                formRect.Y += 25;
                gHumid.Size = new Size(150, 150);
                gTemp.Size = new Size(150, 150);
                gPressure.Size = new Size(150, 150);
            }

            if (zgc.Size != formRect.Size)
            {
                zgc.Location = formRect.Location;
                zgc.Size = formRect.Size;
                space = (formRect.Height - 3 * gHumid.Size.Height) / 6;
                gHumid.Location = new Point(10, formRect.Y + space);
                gTemp.Location = new Point(10, formRect.Y + 3 * space + gHumid.Size.Height);
                gPressure.Location = new Point(10, formRect.Y + 5 * space + 2 * gHumid.Size.Height);
            }
        }
        #endregion

       

        #region Timer 1
        private void tmrData_Tick(object sender, EventArgs e)
        {
            int i;
            uint recLength;

            recLength = 25;
            // Get the Live data, to show in gauge
            txBuf[0] = (byte)CMD.GET_LIVE_DATA;
            txBuf[1] = 2;
            //USB.SendReceivePacket(txBuf, 2, rxBuf, ref recLength);
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            String data;
            data = myPort.ReadLine();
            myPort.Close();
            string [] dht=data.Split(',');
            //s.dataPtr = rxBuf[18];
            //i = 19;
            //convertData(ref currData, ref i);
            //gTemp.Value = currData.temp;
            //gPressure.Value = currData.pressure;
            //gHumid.Value = currData.humidity;
            if (dht.Length != 3)
                return;
            gHumid.Value = float.Parse(dht[0]);
            gTemp.Value = float.Parse(dht[1]);
            gPressure.Value = int.Parse(dht[2]);
            
            if (stt == 0)
            {
                //Start Excel and get Application object.
                oXL = new Excel.Application();
                oXL.Visible = true;

                //Get a new workbook.
                oWB = (Excel._Workbook)(oXL.Workbooks.Add(Missing.Value));
                oSheet = (Excel._Worksheet)oWB.ActiveSheet;
            }    
                //Add table headers going cell by cell.
                oSheet.Cells[stt + 1, 1] = gTemp.Value.ToString();
                oSheet.Cells[stt + 1, 2] = gPressure.Value.ToString();
                oSheet.Cells[stt + 1, 3] = gHumid.Value.ToString();
                //oSheet.Cells[1, 4] = "Salary";


            DateTime timeNow = DateTime.Now;
            w[stt].humidity = gHumid.Value;
            w[stt].temp = gTemp.Value;
            w[stt].pressure = gPressure.Value;
            w[stt++].time = timeNow;
            if (stt == 999)
                stt = 0;
            Redraw(0);

            goLive = false;
            if (goLive) // Only load data to w if graph shows live data from PIC
            {
                recLength = 64;
                txBuf[0] = (byte)CMD.GET_FIRST_DATA;
                txBuf[1] = 2;
                USB.SendReceivePacket(txBuf, 2, rxBuf, ref recLength);
                loadData(10);
                for (i = 0; i < 5; i++)
                {
                    txBuf[0] = (byte)CMD.GET_NEXT_DATA;
                    txBuf[1] = 2;
                    USB.SendReceivePacket(txBuf, 2, rxBuf, ref recLength);
                    loadData(10);
                }

                txBuf[0] = (byte)CMD.GET_CURR_DATA;
                txBuf[1] = 2;
                USB.SendReceivePacket(txBuf, 2, rxBuf, ref recLength);
                loadData((int)s.dataPtr);
            }
        }
        /**
         * The humidity and temp data saved in uC as raw data - Find real values from it
         */
        private void convertData(ref Weather d, ref int index)
        {
            const float C1 = 3.95F;
            const float C2 = 0.0405F;
            const float C3 = 2.8e-6F;
            d.humidity = (int)rxBuf[index++];
            d.humidity += ((int)rxBuf[index++] << 8);
            d.humidity = (C2 * d.humidity) - (d.humidity * d.humidity * C3) - C1;

            // Find temp
            d.temp = (int)rxBuf[index++] >> 3;
            d.temp += ((int)rxBuf[index++] << 5);
            d.temp = d.temp * 0.0625F;
            d.pressure = (int)rxBuf[index++];
            d.pressure += ((int)rxBuf[index++] << 8);
            d.pressure = d.pressure / 10.0F;
        }
        #endregion 
        #region Menu Items
        /**
         * Exit
         */
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            USB.StopReceivingDeviceNotifications(deviceNotificationHandle);
            if (s.saveOnExit)
            {
                if (goLive && tmrData.Enabled) fHandler.writeFile(w, wIndex); // Only save if dynamic updates running
            }
            Application.Exit();
        }
        /**
         * Zoom graph
         */
        private void zoomToolStripMenuItem_Click(object sender, EventArgs e)
        {
            int wMin, i;
            bool overflow = false;
            wMin = wIndex;
            // manually set the scroll range
            do
            {
                wMin++;
                if (wMin >= w.Length)
                    wMin = 0;
                if (wMin == wIndex)
                {
                    overflow = true;
                    break;
                }
            } while (w[wMin].time == new XDate(1970, 1, 1));
            // show the horizontal scroll bar
            zgc.IsShowHScrollBar = true;
            // Zoom only when we have enough points, i.e atleast greater than 25
            if (!overflow && (((wIndex - wMin) > 25 )|| ((wIndex - wMin) < 0)))
            {
                zgc.ScrollMinX = (double)w[wMin].time;
                zgc.ScrollMaxX = (double)w[wIndex].time;

                // Disable the AutoScrollRange option (because we have set the scroll range manually)
                zgc.IsAutoScrollRange = false;

                // Horizontal pan and zoom allowed
                zgc.IsEnableHPan = true;
                zgc.IsEnableHZoom = true;
                // Vertical pan and zoom not allowed
                zgc.IsEnableVPan = false;
                zgc.IsEnableVZoom = false;

                // Set the initial viewed range
                // Set start point to a few point advanced
                for (i = 0; i < 10; i++)
                {
                    wMin++;
                    if (wMin >= w.Length) wMin -= w.Length;
                    if (w[wMin].time == new XDate(1970, 1, 1))
                    {
                        wMin--;
                        break;
                    }
                }
                zgc.GraphPane.XAxis.Scale.Min = (double)w[wMin].time;
                zgc.GraphPane.XAxis.Scale.Max = (double)w[wIndex].time;
                Redraw(wIndex);
            }

        }
        /**
         * Open a data file, and display
         */
        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string fName;
            // Check the directory exists, if not skip open dialog
            if (System.IO.Directory.Exists(@"log\"))
            {
                dateSel.ShowDialog();
                if (dateSel.openFile)
                {
                    fName = dateSel.fileName;
                    if (System.IO.File.Exists(fName))
                    {
                        goLive = false;
                        fHandler.readFile(fName, ref w);
                        ledYellow.Active = true;
                        zgc.ZoomOutAll(zgc.GraphPane);
                        Redraw(w.Length - 1);
                    }
                    else
                        MessageBox.Show("Data for the selected date doesn't exists", "Weather Logger",
                                MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
            }
            else
                MessageBox.Show("No Data Saved Yet", "Weather Logger",
                    MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
        /**
         * Open preference dialog
         */
        private void preferencesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Pref.rb12hr.Checked = s.t12HrFormat;
            Pref.rb24hr.Checked = !s.t12HrFormat;
            if (s.interval < Pref.nudInterval.Minimum) s.interval = 15;
            if (s.interval > Pref.nudInterval.Maximum) s.interval = 255;
            Pref.nudInterval.Value = (int)s.interval;
            Pref.btnHumidColor.BackColor = s.humidColor;
            Pref.btnPreColor.BackColor = s.preColor;
            Pref.btnTempColor.BackColor = s.tempColor;
            Pref.cbSaveOnExit.Checked = s.saveOnExit;
            Pref.cbShowPointValues.Checked = s.showPointValuesInGraph;
            Pref.ShowDialog();
        }
        /**
         * On prefenrece values chaged
         */
        private void pSettingsChanged(object sender, EventArgs e)
        {
            uint recLength = 3;
                        
            s.t12HrFormat = Pref.rb12hr.Checked;
            s.interval = (byte)Pref.nudInterval.Value;
            txBuf[0] = (byte)CMD.SET_EEPROM;
            txBuf[1] = 6;
            txBuf[2 + 3] = (byte)Pref.nudInterval.Value;
            USB.SendReceivePacket(txBuf, 6, rxBuf, ref recLength);
            s.humidColor = Pref.btnHumidColor.BackColor;
            s.tempColor = Pref.btnTempColor.BackColor;
            s.preColor = Pref.btnPreColor.BackColor;
            s.saveOnExit = Pref.cbSaveOnExit.Checked;
            s.showPointValuesInGraph = Pref.cbShowPointValues.Checked;
            SetColor();
        }
        /**
         * About box
         */
        private void softwareToolStripMenuItem_Click(object sender, EventArgs e)
        {
            About.ShowDialog();
        }
        /**
         * Go to live - display live data
         */
        private void goLiveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ResetW();
            goLive = true;
            ledYellow.Active = false;
        }
        /**
         * Save data to file
         */
        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(goLive && tmrData.Enabled) fHandler.writeFile(w, wIndex); // Only save if dynamic updates running
        }
        /**
         * Zoom
         */
        private void zoomOutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zgc.ZoomOut(zgc.GraphPane);
        }
        /**
         * Zoom - reset
         */
        private void zoomOutAllToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zgc.ZoomOutAll(zgc.GraphPane);
        }
        #endregion
        #region RTC Functions
        /**
         * Set RTC time 
         */
        private void rtcSetTime()
        {
            uint recLength = 3;
            DateTime time = DateTime.Now;
            string[] strTime = new string[6];
            strTime[0] = time.ToString("ss mm HH dd MM yy");
            strTime = strTime[0].Split(" ".ToCharArray());
            
            txBuf[0] = (byte)CMD.SET_TIME;
            txBuf[1] = 9;
            // RTC data
            txBuf[2] = Convert.ToByte(strTime[0], 16);  // Seconds
            txBuf[3] = Convert.ToByte(strTime[1], 16);  // Minutes
            txBuf[4] = Convert.ToByte(strTime[2], 16);  // Hours
            txBuf[5] = (byte)time.DayOfWeek;            // Day of the week
            txBuf[6] = Convert.ToByte(strTime[3], 16);  // Date
            txBuf[7] = Convert.ToByte(strTime[4], 16);  // Month
            txBuf[8] = Convert.ToByte(strTime[5], 16);  // Year
            USB.SendReceivePacket(txBuf, 2, rxBuf, ref recLength);
        }
        #endregion
        private void savePriferences()
        {
            Settings.Default.HumidColor = s.humidColor;
            Settings.Default.TempColor = s.tempColor;
            Settings.Default.PreColor = s.preColor;
            Settings.Default.SaveOnExit = s.saveOnExit;
            Settings.Default.ShowPointValues = s.showPointValuesInGraph;
            Settings.Default.Save();
        }
    }
}
