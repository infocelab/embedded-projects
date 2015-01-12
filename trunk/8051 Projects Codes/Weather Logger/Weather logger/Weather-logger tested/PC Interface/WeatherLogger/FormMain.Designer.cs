namespace WeatherLogger
{
    partial class FormMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormMain));
            this.gPressure = new AquaControls.AquaGauge();
            this.gTemp = new AquaControls.AquaGauge();
            this.zgc = new ZedGraph.ZedGraphControl();
            this.gHumid = new AquaControls.AquaGauge();
            this.menuStrip = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.openToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saveToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.goLiveToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.editToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.zoomToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.zoomOutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.zoomOutAllToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.preferencesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.aboutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.softwareToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.boardToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tmrData = new System.Windows.Forms.Timer(this.components);
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.ledRed = new LED.LEDControl();
            this.ledYellow = new LED.LEDControl();
            this.ledGreen = new LED.LEDControl();
            this.cbxPorts = new System.Windows.Forms.ComboBox();
            this.menuStrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // gPressure
            // 
            this.gPressure.BackColor = System.Drawing.Color.Transparent;
            this.gPressure.DialColor = System.Drawing.Color.Lavender;
            this.gPressure.DialText = "RPM";
            this.gPressure.Glossiness = 11.36364F;
            this.gPressure.Location = new System.Drawing.Point(12, 305);
            this.gPressure.MaxValue = 5000F;
            this.gPressure.MinValue = 0F;
            this.gPressure.Name = "gPressure";
            this.gPressure.NeedleColor = System.Drawing.Color.Red;
            this.gPressure.NoOfDivisions = 6;
            this.gPressure.NoOfSubDivisions = 4;
            this.gPressure.RecommendedValue = 0F;
            this.gPressure.Size = new System.Drawing.Size(125, 125);
            this.gPressure.TabIndex = 11;
            this.gPressure.ThresholdPercent = 0F;
            this.gPressure.Value = 0F;
            // 
            // gTemp
            // 
            this.gTemp.BackColor = System.Drawing.Color.Transparent;
            this.gTemp.DialColor = System.Drawing.Color.Lavender;
            this.gTemp.DialText = "°C";
            this.gTemp.Glossiness = 11.36364F;
            this.gTemp.Location = new System.Drawing.Point(12, 182);
            this.gTemp.MaxValue = 80F;
            this.gTemp.MinValue = -40F;
            this.gTemp.Name = "gTemp";
            this.gTemp.NeedleColor = System.Drawing.Color.Red;
            this.gTemp.NoOfDivisions = 12;
            this.gTemp.NoOfSubDivisions = 4;
            this.gTemp.RecommendedValue = 0F;
            this.gTemp.Size = new System.Drawing.Size(125, 125);
            this.gTemp.TabIndex = 10;
            this.gTemp.ThresholdPercent = 0F;
            this.gTemp.Value = 0F;
            // 
            // zgc
            // 
            this.zgc.Location = new System.Drawing.Point(150, 25);
            this.zgc.Name = "zgc";
            this.zgc.ScrollGrace = 0D;
            this.zgc.ScrollMaxX = 0D;
            this.zgc.ScrollMaxY = 0D;
            this.zgc.ScrollMaxY2 = 0D;
            this.zgc.ScrollMinX = 0D;
            this.zgc.ScrollMinY = 0D;
            this.zgc.ScrollMinY2 = 0D;
            this.zgc.Size = new System.Drawing.Size(642, 389);
            this.zgc.TabIndex = 8;
            // 
            // gHumid
            // 
            this.gHumid.BackColor = System.Drawing.Color.Transparent;
            this.gHumid.DialColor = System.Drawing.Color.Lavender;
            this.gHumid.DialText = "% RH";
            this.gHumid.Glossiness = 11.36364F;
            this.gHumid.Location = new System.Drawing.Point(12, 57);
            this.gHumid.MaxValue = 100F;
            this.gHumid.MinValue = 0F;
            this.gHumid.Name = "gHumid";
            this.gHumid.NeedleColor = System.Drawing.Color.Red;
            this.gHumid.NoOfSubDivisions = 4;
            this.gHumid.RecommendedValue = 0F;
            this.gHumid.Size = new System.Drawing.Size(125, 125);
            this.gHumid.TabIndex = 9;
            this.gHumid.ThresholdPercent = 0F;
            this.gHumid.Value = 0F;
            // 
            // menuStrip
            // 
            this.menuStrip.AllowDrop = true;
            this.menuStrip.BackColor = System.Drawing.SystemColors.ControlLight;
            this.menuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.editToolStripMenuItem,
            this.aboutToolStripMenuItem});
            this.menuStrip.Location = new System.Drawing.Point(0, 0);
            this.menuStrip.Name = "menuStrip";
            this.menuStrip.Size = new System.Drawing.Size(792, 24);
            this.menuStrip.TabIndex = 12;
            this.menuStrip.Text = "menuStrip";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.BackColor = System.Drawing.SystemColors.ControlLight;
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.openToolStripMenuItem,
            this.saveToolStripMenuItem,
            this.goLiveToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // openToolStripMenuItem
            // 
            this.openToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("openToolStripMenuItem.Image")));
            this.openToolStripMenuItem.Name = "openToolStripMenuItem";
            this.openToolStripMenuItem.Size = new System.Drawing.Size(113, 22);
            this.openToolStripMenuItem.Text = "Open";
            this.openToolStripMenuItem.Click += new System.EventHandler(this.openToolStripMenuItem_Click);
            // 
            // saveToolStripMenuItem
            // 
            this.saveToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("saveToolStripMenuItem.Image")));
            this.saveToolStripMenuItem.Name = "saveToolStripMenuItem";
            this.saveToolStripMenuItem.Size = new System.Drawing.Size(113, 22);
            this.saveToolStripMenuItem.Text = "Save";
            this.saveToolStripMenuItem.Click += new System.EventHandler(this.saveToolStripMenuItem_Click);
            // 
            // goLiveToolStripMenuItem
            // 
            this.goLiveToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("goLiveToolStripMenuItem.Image")));
            this.goLiveToolStripMenuItem.Name = "goLiveToolStripMenuItem";
            this.goLiveToolStripMenuItem.Size = new System.Drawing.Size(113, 22);
            this.goLiveToolStripMenuItem.Text = "Go Live";
            this.goLiveToolStripMenuItem.Click += new System.EventHandler(this.goLiveToolStripMenuItem_Click);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("exitToolStripMenuItem.Image")));
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(113, 22);
            this.exitToolStripMenuItem.Text = "Exit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
            // 
            // editToolStripMenuItem
            // 
            this.editToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.zoomToolStripMenuItem,
            this.zoomOutToolStripMenuItem,
            this.zoomOutAllToolStripMenuItem,
            this.preferencesToolStripMenuItem});
            this.editToolStripMenuItem.Name = "editToolStripMenuItem";
            this.editToolStripMenuItem.Size = new System.Drawing.Size(39, 20);
            this.editToolStripMenuItem.Text = "Edit";
            // 
            // zoomToolStripMenuItem
            // 
            this.zoomToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("zoomToolStripMenuItem.Image")));
            this.zoomToolStripMenuItem.Name = "zoomToolStripMenuItem";
            this.zoomToolStripMenuItem.Size = new System.Drawing.Size(146, 22);
            this.zoomToolStripMenuItem.Text = "Zoom In";
            this.zoomToolStripMenuItem.Click += new System.EventHandler(this.zoomToolStripMenuItem_Click);
            // 
            // zoomOutToolStripMenuItem
            // 
            this.zoomOutToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("zoomOutToolStripMenuItem.Image")));
            this.zoomOutToolStripMenuItem.Name = "zoomOutToolStripMenuItem";
            this.zoomOutToolStripMenuItem.Size = new System.Drawing.Size(146, 22);
            this.zoomOutToolStripMenuItem.Text = "Zoom Out";
            this.zoomOutToolStripMenuItem.Click += new System.EventHandler(this.zoomOutToolStripMenuItem_Click);
            // 
            // zoomOutAllToolStripMenuItem
            // 
            this.zoomOutAllToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("zoomOutAllToolStripMenuItem.Image")));
            this.zoomOutAllToolStripMenuItem.Name = "zoomOutAllToolStripMenuItem";
            this.zoomOutAllToolStripMenuItem.Size = new System.Drawing.Size(146, 22);
            this.zoomOutAllToolStripMenuItem.Text = "Zoom Out All";
            this.zoomOutAllToolStripMenuItem.Click += new System.EventHandler(this.zoomOutAllToolStripMenuItem_Click);
            // 
            // preferencesToolStripMenuItem
            // 
            this.preferencesToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("preferencesToolStripMenuItem.Image")));
            this.preferencesToolStripMenuItem.Name = "preferencesToolStripMenuItem";
            this.preferencesToolStripMenuItem.Size = new System.Drawing.Size(146, 22);
            this.preferencesToolStripMenuItem.Text = "Preferences";
            this.preferencesToolStripMenuItem.Click += new System.EventHandler(this.preferencesToolStripMenuItem_Click);
            // 
            // aboutToolStripMenuItem
            // 
            this.aboutToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.softwareToolStripMenuItem,
            this.boardToolStripMenuItem});
            this.aboutToolStripMenuItem.Name = "aboutToolStripMenuItem";
            this.aboutToolStripMenuItem.Size = new System.Drawing.Size(52, 20);
            this.aboutToolStripMenuItem.Text = "About";
            // 
            // softwareToolStripMenuItem
            // 
            this.softwareToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("softwareToolStripMenuItem.Image")));
            this.softwareToolStripMenuItem.Name = "softwareToolStripMenuItem";
            this.softwareToolStripMenuItem.Size = new System.Drawing.Size(120, 22);
            this.softwareToolStripMenuItem.Text = "Software";
            this.softwareToolStripMenuItem.Click += new System.EventHandler(this.softwareToolStripMenuItem_Click);
            // 
            // boardToolStripMenuItem
            // 
            this.boardToolStripMenuItem.Name = "boardToolStripMenuItem";
            this.boardToolStripMenuItem.Size = new System.Drawing.Size(120, 22);
            this.boardToolStripMenuItem.Text = "Board";
            // 
            // tmrData
            // 
            this.tmrData.Interval = 15000;
            this.tmrData.Tick += new System.EventHandler(this.tmrData_Tick);
            // 
            // statusStrip1
            // 
            this.statusStrip1.Location = new System.Drawing.Point(0, 431);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(792, 22);
            this.statusStrip1.TabIndex = 13;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // ledRed
            // 
            this.ledRed.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.ledRed.BackColor = System.Drawing.Color.Transparent;
            this.ledRed.LEDColor = System.Drawing.Color.Red;
            this.ledRed.LEDOffColor = System.Drawing.SystemColors.ControlLight;
            this.ledRed.Location = new System.Drawing.Point(6, 434);
            this.ledRed.Name = "ledRed";
            this.ledRed.Size = new System.Drawing.Size(17, 17);
            this.ledRed.TabIndex = 17;
            // 
            // ledYellow
            // 
            this.ledYellow.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.ledYellow.BackColor = System.Drawing.Color.Transparent;
            this.ledYellow.LEDColor = System.Drawing.Color.Gold;
            this.ledYellow.LEDOffColor = System.Drawing.SystemColors.ControlLight;
            this.ledYellow.Location = new System.Drawing.Point(29, 434);
            this.ledYellow.Name = "ledYellow";
            this.ledYellow.Size = new System.Drawing.Size(17, 17);
            this.ledYellow.TabIndex = 18;
            // 
            // ledGreen
            // 
            this.ledGreen.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.ledGreen.BackColor = System.Drawing.Color.Transparent;
            this.ledGreen.LEDColor = System.Drawing.Color.Lime;
            this.ledGreen.LEDOffColor = System.Drawing.SystemColors.ControlLight;
            this.ledGreen.Location = new System.Drawing.Point(52, 434);
            this.ledGreen.Name = "ledGreen";
            this.ledGreen.Size = new System.Drawing.Size(17, 17);
            this.ledGreen.TabIndex = 19;
            // 
            // cbxPorts
            // 
            this.cbxPorts.FormattingEnabled = true;
            this.cbxPorts.Location = new System.Drawing.Point(150, 3);
            this.cbxPorts.Name = "cbxPorts";
            this.cbxPorts.Size = new System.Drawing.Size(147, 21);
            this.cbxPorts.TabIndex = 20;
            // 
            // FormMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(792, 453);
            this.Controls.Add(this.cbxPorts);
            this.Controls.Add(this.ledGreen);
            this.Controls.Add(this.ledYellow);
            this.Controls.Add(this.ledRed);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.gPressure);
            this.Controls.Add(this.gTemp);
            this.Controls.Add(this.zgc);
            this.Controls.Add(this.gHumid);
            this.Controls.Add(this.menuStrip);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip;
            this.MinimumSize = new System.Drawing.Size(800, 480);
            this.Name = "FormMain";
            this.Text = " ::: Weather Logger";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.FormMain_FormClosed);
            this.Load += new System.EventHandler(this.FormMain_Load);
            this.Resize += new System.EventHandler(this.FormMain_Resize);
            this.menuStrip.ResumeLayout(false);
            this.menuStrip.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private AquaControls.AquaGauge gPressure;
        private AquaControls.AquaGauge gTemp;
        private ZedGraph.ZedGraphControl zgc;
        private AquaControls.AquaGauge gHumid;
        private System.Windows.Forms.MenuStrip menuStrip;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem openToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem saveToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem editToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem aboutToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem softwareToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem boardToolStripMenuItem;
        private System.Windows.Forms.Timer tmrData;
        private System.Windows.Forms.ToolStripMenuItem zoomToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem zoomOutToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem preferencesToolStripMenuItem;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripMenuItem goLiveToolStripMenuItem;
        private LED.LEDControl ledRed;
        private LED.LEDControl ledYellow;
        private LED.LEDControl ledGreen;
        private System.Windows.Forms.ToolStripMenuItem zoomOutAllToolStripMenuItem;
        private System.Windows.Forms.ComboBox cbxPorts;

    }
}

