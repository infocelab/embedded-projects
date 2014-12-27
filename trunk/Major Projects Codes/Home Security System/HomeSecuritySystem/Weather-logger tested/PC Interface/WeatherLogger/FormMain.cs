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
using Microsoft.Office.Core;
using Excel = Microsoft.Office.Interop.Excel;
using System.Reflection;


namespace WeatherLogger
{
    public partial class FormMain : Form
    {
        private const Int32 WM_DEVICECHANGE = 0x219;
        public FormMain()
        {
            InitializeComponent();
        }
        private void SetColor()
        {
        }
        private void EnableButtons()
        {
            tmrData.Enabled = true;
        }
        protected override void WndProc(ref Message m)
        {
            base.WndProc(ref m);
        }

        private void FormMain_FormClosed(object sender, FormClosedEventArgs e)
        {
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
            cbxPorts.SelectedIndex = 3;
        }

        private void FormMain_Load(object sender, EventArgs e)
        {
            GetSerialPorts();
        }
        #region Private Initialise Graph
        /**
         * Initialise ZedGraph
         */
        private void CreateGraph(ZedGraphControl zgc)
        {
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
        }
        /**
         * Redraw graph, See ZedGraph documents for more details
         */
        private void Redraw(int dPtr)
        {
        }
        #endregion
        #region Graph Size Control
        private void FormMain_Resize(object sender, EventArgs e)
        {
            SetSize();
        }
        private void SetSize()
        {
        }
        #endregion

       

        #region Timer 1
        private void tmrData_Tick(object sender, EventArgs e)
        {
            uint recLength;

            recLength = 25;
            // Get the Live data, to show in gauge
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
            if (dht.Length != 3)
                return;
        }
        #endregion 
        #region Menu Items
        /**
         * Exit
         */
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        /**
         * Zoom graph
         */
        private void zoomToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        /**
         * Open a data file, and display
         */
        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        /**
         * Open preference dialog
         */
        private void preferencesToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        /**
         * On prefenrece values chaged
         */
        private void pSettingsChanged(object sender, EventArgs e)
        {
        }
        /**
         * About box
         */
        private void softwareToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        /**
         * Go to live - display live data
         */
        private void goLiveToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        /**
         * Save data to file
         */
        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        /**
         * Zoom
         */
        private void zoomOutToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        /**
         * Zoom - reset
         */
        private void zoomOutAllToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }
        #endregion
        #region RTC Functions
        /**
         * Set RTC time 
         */
        private void rtcSetTime()
        {
        }
        #endregion
        private void savePriferences()
        {
        }

        private void cbxPorts_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btn_lab1_cfl_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text  + "," + "1,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
      
        }

        private void btn_lab1_cfl_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "1,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab1_tube_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "2,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab1_tube_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "2,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab1_fan_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "3,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab1_fan_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "3,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab1_plug_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "4,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab1_plug_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "4,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab2_cfl_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "1,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab2_cfl_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "1,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab2_tube_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "2,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab2_tube_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "2,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab2_fan_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "3,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab2_fan_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "3,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab2_plug_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "4,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab2_plug_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "4,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab3_cfl_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "1,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab3_cfl_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "1,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab3_tube_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "2,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab3_tube_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "2,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab3_fan_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "3,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab3_fan_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "3,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab3_plug_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "4,1,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void btn_lab3_plug_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "4,0,";
            string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            myPort.BaudRate = 9600;
            if (myPort.IsOpen == false) //if not open, open the port
                myPort.Open();
            //do your work here
            if (myPort.IsOpen == false) //if not open, open the port
                return;
            myPort.WriteLine(xml);
            myPort.Close();
        }

        private void tbx_home_code_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
