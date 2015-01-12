using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace WeatherLogger
{
    public partial class Preferences : Form
    {
        // A delegate type for hooking up change notifications.
        internal delegate void SettingsChangedHandler(object sender, EventArgs e);
        // An event that clients can use to be notified
        internal event SettingsChangedHandler SettingsChanged;
        internal bool tSettingsChanged = false;
        public Preferences()
        {
            InitializeComponent();
            //btnHumidColor.BackColor = WeatherLogger.FormMain.
        }

        private void Preferences_Load(object sender, EventArgs e)
        {
            //tbPref.Location = new Point(10, 10);
            tSettingsChanged = false;
        }

        private void btnCancell_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnOK_Click(object sender, EventArgs e)
        {
            if (SettingsChanged != null)
                SettingsChanged(this, e);
            this.Close();
        }

        private void btnApply_Click(object sender, EventArgs e)
        {
            if (SettingsChanged != null)
                SettingsChanged(this, e);
        }

        private void btnHumidColor_Click(object sender, EventArgs e)
        {
            colorDialog.Color = btnHumidColor.BackColor;
            if (colorDialog.ShowDialog() == DialogResult.OK)
                btnHumidColor.BackColor = colorDialog.Color;
        }

        private void btnTempColor_Click(object sender, EventArgs e)
        {
            colorDialog.Color = btnTempColor.BackColor;
            if (colorDialog.ShowDialog() == DialogResult.OK)
                btnTempColor.BackColor = colorDialog.Color;
        }

        private void btnPreColor_Click(object sender, EventArgs e)
        {
            colorDialog.Color = btnPreColor.BackColor;
            if (colorDialog.ShowDialog() == DialogResult.OK)
                btnPreColor.BackColor = colorDialog.Color;
        }
    }
}
