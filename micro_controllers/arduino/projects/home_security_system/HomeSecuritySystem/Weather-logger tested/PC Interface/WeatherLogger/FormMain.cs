﻿using System;
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
using System.Threading;


namespace WeatherLogger
{
    public partial class FormMain : Form
    {
        private const Int32 WM_DEVICECHANGE = 0x219;
        static SerialPort _serialPort;// = new SerialPort("COM1", 19200, Parity.None, 8, StopBits.One);
        static bool _continue=true;
        Thread readThread = new Thread(Read);
           
        public FormMain()
        {
            InitializeComponent();
            //tmrData.Enabled = true;
        }
        private void SetColor()
        {
        }
        private void EnableButtons()
        {
            //tmrData.Enabled = true;
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
            cbxPorts.SelectedIndex = 1;
        }

        static void _serialPort_DataReceived(object sender, SerialDataReceivedEventArgs e)
        {
            SerialPort _serialPort = (SerialPort)sender;
            //Console.WriteLine(_serialPort.ReadExisting());
        }


        public static void Read()
        {
            while (true)
            {
                try
                {
                    string message = _serialPort.ReadLine();
                    string[] fff = message.Split(',');
                    //tbx_room_temp.Text = fff[5];
           
                    //Console.WriteLine(message);
                }
                catch (TimeoutException) { }
            }
        }

        private void FormMain_Load(object sender, EventArgs e)
        {
            GetSerialPorts();
            // "sp_DataReceived" is a custom method that I have created
            //_serialPort.DataReceived += new SerialDataReceivedEventHandler(sp_DataReceived);
           string port = cbxPorts.SelectedItem.ToString();
            if (port == "")
                return;
            
           _serialPort = new SerialPort(port, 9600, Parity.None, 8, StopBits.One);
           _serialPort.ReadTimeout = 500;
            _serialPort.WriteTimeout = 500;
            _serialPort.Handshake = Handshake.None;
  
            _serialPort.Open();
            readThread.Start();
            _serialPort.DataReceived += new SerialDataReceivedEventHandler(_serialPort_DataReceived);
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
            String data;
            //data = myPort.ReadExisting();
            data = myPort.ReadLine() ;
            myPort.Close();
            //tmrData.Enabled = true;
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
        private void sendData(string xml)
        {
            //string port = cbxPorts.SelectedItem.ToString();
            //if (port == "")
            //    return;
            //System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            //myPort.BaudRate = 9600;
            //if (myPort.IsOpen == false) //if not open, open the port
            //    myPort.Open();
            ////do your work here
            //if (myPort.IsOpen == false) //if not open, open the port
            //    return;
            //myPort.WriteLine(xml);
            //myPort.Close();
            _serialPort.WriteLine(xml);
        }
        private void cbxPorts_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btn_lab1_cfl_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text  + "," + "1,1,";
            sendData(xml);    
        }

        private void btn_lab1_cfl_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "1,2,";
            sendData(xml);
        }

        private void btn_lab1_tube_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "2,1,";
            sendData(xml);
        }

        private void btn_lab1_tube_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "2,2,";
            sendData(xml);
        }

        private void btn_lab1_fan_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "3,1,";
            sendData(xml);
        }

        private void btn_lab1_fan_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "3,2,";
            sendData(xml);
        }

        private void btn_lab1_plug_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "4,1,";
            sendData(xml);
        }

        private void btn_lab1_plug_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "4,2,";
            sendData(xml);
        }

        private void btn_lab2_cfl_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "1,1,";
            sendData(xml);
        }

        private void btn_lab2_cfl_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "1,2,";
            sendData(xml);
        }

        private void btn_lab2_tube_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "2,1,";
            sendData(xml);
        }

        private void btn_lab2_tube_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "2,2,";
            sendData(xml);
        }

        private void btn_lab2_fan_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "3,1,";
            sendData(xml);
        }

        private void btn_lab2_fan_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "3,2";
            sendData(xml);
        }

        private void btn_lab2_plug_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "4,1,";
            sendData(xml);
        }

        private void btn_lab2_plug_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab2_unit_code.Text + "," + "4,2,";
            sendData(xml);
        }

        private void btn_lab3_cfl_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "1,1,";
            sendData(xml);
        }

        private void btn_lab3_cfl_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "1,2,";
            sendData(xml);
        }

        private void btn_lab3_tube_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "2,1,";
            sendData(xml);
        }

        private void btn_lab3_tube_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "2,2,";
            sendData(xml);
        }

        private void btn_lab3_fan_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "3,1,";
            sendData(xml);
        }

        private void btn_lab3_fan_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "3,2,";
            sendData(xml);
        }

        private void btn_lab3_plug_on_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "4,1,";
            sendData(xml);
        }

        private void btn_lab3_plug_off_Click(object sender, EventArgs e)
        {
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab3_unit_code.Text + "," + "4,2,";
            sendData(xml);
        }

        private void tbx_home_code_TextChanged(object sender, EventArgs e)
        {

        }

 
        //Handler as indicatted above will be run when the event is triggered.
        private void ProcessReceivedData(object sender, SerialDataReceivedEventArgs e)
        {
            //Byte [2048] ReceiveBuffer;
            //int offset = 0;
            //int toRead = sp.BytesToRead;
            //sp.Read(ReceiveBuffer, offset, toRead);
            //offset += toRead;

        //Received data will be in placed into ReceiveBuffer at location offset.
        //You will have to handle buffer overflow conditions and clean up the 
        //buffer when the data when you are finished recovering the data.
        }


        private void btn_get_room_temp_Click(object sender, EventArgs e)
        {
           
            string xml = "#," + tbx_home_code.Text + "," + tbx_unit_code.Text + "," + tbx_lab1_unit_code.Text + "," + "5,3,";
            //tmrData.Enabled = true;
            //sendData(xml);
            //sp.DataReceived += new SerialDataReceivedEventHandler(ProcessReceivedData);

            _serialPort.WriteLine(xml);
      
            
  
            //string port = cbxPorts.SelectedItem.ToString();
            //if (port == "")
            //    return;
            //System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            //myPort.BaudRate = 9600;
            //if (myPort.IsOpen == false) //if not open, open the port
            //    myPort.Open();
            ////do your work here
            //if (myPort.IsOpen == false) //if not open, open the port
            //    return;
            //myPort.WriteLine(xml);
            //myPort.Close();
            ////myPort.ReadTimeout = 500;


            //string port = cbxPorts.SelectedItem.ToString();
            //if (port == "")
            //    return;
            //System.IO.Ports.SerialPort myPort = new System.IO.Ports.SerialPort(port);
            //myPort.BaudRate = 9600;
            //if (myPort.IsOpen == false) //if not open, open the port
            //    myPort.Open();
            //do your work here
            //if (myPort.IsOpen == false) //if not open, open the port
            //    return;
            //try
            //{
            //    String data = "" ;
            //    data = myPort.ReadLine();
            //    myPort.Close();
            //    string[] fff = data.Split(',');
            //    tbx_room_temp.Text = fff[5];
            //}
            //catch (TimeoutException)
            //{
            //    myPort.Close();
            //}
            //catch (InvalidOperationException)
            //{
            //    myPort.Close();
            //}
            //catch
            //{
            //    myPort.Close();
            //}
            //finally
            //{
            //    myPort.Close();
            //}
            
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }
    }
}
