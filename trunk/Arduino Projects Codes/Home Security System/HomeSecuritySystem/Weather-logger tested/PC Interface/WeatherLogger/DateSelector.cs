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
using System.IO;

namespace WeatherLogger
{
    public partial class DateSelector : Form
    {
        internal string fileName;
        internal bool openFile = false;
        public DateSelector()
        {
            InitializeComponent();
            mCalendar.MaxSelectionCount = 1;
        }

        private void btnOpen_Click(object sender, EventArgs e)
        {
            fileName = @"log\" + mCalendar.SelectionStart.ToString("ddMMyyyy") + ".wlg";
            openFile = true;
            this.Close();
        }

        private void btnCancell_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void DateSelector_Load(object sender, EventArgs e)
        {
            int i = 0;
            mCalendar.MaxDate = DateTime.Now;
            string[] fileNames = Directory.GetFiles(@"log\");
            DateTime[] days = new DateTime[fileNames.Length];
            foreach(string fi in fileNames)
            {
                string fName = fi.Substring(4, 8);  // Get the substring that show the date
                days[i++] = DateTime.ParseExact(fName, "ddMMyyyy", null); // Get date from file name
            }
            Array.Sort(days);
            mCalendar.ShowToday = false;
            mCalendar.BoldedDates = days;   // Show bolded dates
            mCalendar.MinDate = days[0];    // Set the min value
            openFile = false;
        }
    }
}
