using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using ZedGraph;

namespace WeatherLogger
{
    class FileHandler
    {
        public void writeFile(WeatherLogger.FormMain.Weather[] w, int wIndex)
        {
            bool overWrite = false;
            int i;

            string fileName;    // = DateTime.Now.ToString("ddMMyyyy") + ".wlg";
            string strLineContent, strTime;
            XDate writeLineTime = new XDate();

            if(!(Directory.Exists("log"))) Directory.CreateDirectory("log");
            
            // Set wIndex to a very first valid data
            for (i = 0; i < w.Length; i++)
            {
                if(++wIndex >= w.Length) wIndex = 0;
                if (w[wIndex].time != new XDate(1970, 1, 1)) break;
            }
            // Set Max time as the next day
            XDate writeLineMaxTime = new XDate(w[wIndex].time.DateTime.Year, w[wIndex].time.DateTime.Month,
                (w[wIndex].time.DateTime.Day)).DateTime.AddDays(1);

            // Write as many files required for each date
            i = 0;
            while (i < w.Length)
            {

                // Create a file name
                fileName = @"log\" + w[wIndex].time.DateTime.ToString("ddMMyyyy") + ".wlg";

                if (File.Exists(fileName)) overWrite = true;            // File Exists
                else overWrite = false;

                if (overWrite) File.Move(fileName, fileName + ".~orig");    // Rename existing file
                StreamWriter objFile = new StreamWriter(fileName);      // New file

                if (overWrite)
                {
                    // Read the existing file and write the data to the new file
                    StreamReader objReadFile = new StreamReader(fileName + ".~orig");
                    while ((strLineContent = objReadFile.ReadLine()) != null)
                    {
                        strLineContent = strLineContent.Trim();
                        strTime = strLineContent.Split("  ".ToCharArray())[0];
                        writeLineTime = DateTime.FromBinary(Convert.ToInt64(strTime));
                        if (writeLineTime >= w[wIndex].time.DateTime) break;
                        objFile.WriteLine(strLineContent);
                    }
                    objReadFile.Close();
                    objReadFile.Dispose();
                    File.Delete(fileName + ".~orig");
                }
                // Writes new data to the file
                while (i < w.Length)
                {
                    if (w[wIndex].time >= writeLineMaxTime)
                    {
                        writeLineMaxTime = writeLineMaxTime.DateTime.AddDays(1); // Write next date datas to a new file
                        break;
                    }
                    if (w[wIndex].time != new XDate(1970, 1, 1))
                    {
                        strLineContent = w[wIndex].time.DateTime.ToBinary() + "  " + w[wIndex].humidity.ToString()
                                    + "  " + w[wIndex].pressure.ToString() + "  " + w[wIndex].temp.ToString();
                        objFile.WriteLine(strLineContent);
                    }
                    if (++wIndex >= w.Length) wIndex = 0;
                    i++;
                }
                objFile.Close();
                objFile.Dispose();
            }
        }

        public void readFile(string fileName, ref WeatherLogger.FormMain.Weather[] w)
        {
            int index = 0;
            string strLine;
            //string[] strData = new string[];
            if (File.Exists(fileName))
            {
                StreamReader objFile = new StreamReader(fileName);
                while ((strLine = objFile.ReadLine()) != null)
                {
                    string[] strData = strLine.Split("  ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
                    w[index].time = new XDate(DateTime.FromBinary(Convert.ToInt64(strData[0])));
                    w[index].humidity = (float)Convert.ToDouble(strData[1]);
                    w[index].pressure = (float)Convert.ToDouble(strData[2]);
                    w[index].temp = (float)Convert.ToDouble(strData[3]);
                    if (++index >= w.Length) break;
                }
                while (index < w.Length)
                {
                    w[index++].time = new XDate(1970, 1, 1);
                }
                objFile.Close();
                objFile.Dispose();
            }
        }
    }
}
