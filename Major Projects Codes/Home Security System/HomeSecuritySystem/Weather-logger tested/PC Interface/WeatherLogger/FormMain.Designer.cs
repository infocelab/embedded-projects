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
            this.cbxPorts = new System.Windows.Forms.ComboBox();
            this.gb_lab1 = new System.Windows.Forms.GroupBox();
            this.label15 = new System.Windows.Forms.Label();
            this.tbx_lab1_unit_code = new System.Windows.Forms.TextBox();
            this.btn_lab1_plug_off = new System.Windows.Forms.Button();
            this.btn_lab1_plug_on = new System.Windows.Forms.Button();
            this.btn_lab1_fan_off = new System.Windows.Forms.Button();
            this.btn_lab1_fan_on = new System.Windows.Forms.Button();
            this.btn_lab1_tube_off = new System.Windows.Forms.Button();
            this.btn_lab1_tube_on = new System.Windows.Forms.Button();
            this.btn_lab1_cfl_off = new System.Windows.Forms.Button();
            this.btn_lab1_cfl_on = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.gb_lab2 = new System.Windows.Forms.GroupBox();
            this.label16 = new System.Windows.Forms.Label();
            this.tbx_lab2_unit_code = new System.Windows.Forms.TextBox();
            this.btn_lab2_plug_off = new System.Windows.Forms.Button();
            this.btn_lab2_plug_on = new System.Windows.Forms.Button();
            this.btn_lab2_fan_off = new System.Windows.Forms.Button();
            this.btn_lab2_fan_on = new System.Windows.Forms.Button();
            this.btn_lab2_tube_off = new System.Windows.Forms.Button();
            this.btn_lab2_tube_on = new System.Windows.Forms.Button();
            this.btn_lab2_cfl_off = new System.Windows.Forms.Button();
            this.btn_lab2_cfl_on = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.gb_lab3 = new System.Windows.Forms.GroupBox();
            this.label17 = new System.Windows.Forms.Label();
            this.tbx_lab3_unit_code = new System.Windows.Forms.TextBox();
            this.btn_lab3_plug_off = new System.Windows.Forms.Button();
            this.btn_lab3_plug_on = new System.Windows.Forms.Button();
            this.btn_lab3_fan_off = new System.Windows.Forms.Button();
            this.btn_lab3_fan_on = new System.Windows.Forms.Button();
            this.btn_lab3_tube_off = new System.Windows.Forms.Button();
            this.btn_lab3_tube_on = new System.Windows.Forms.Button();
            this.btn_lab3_cfl_off = new System.Windows.Forms.Button();
            this.btn_lab3_cfl_on = new System.Windows.Forms.Button();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.gb_controls = new System.Windows.Forms.GroupBox();
            this.tbx_unit_code = new System.Windows.Forms.TextBox();
            this.label14 = new System.Windows.Forms.Label();
            this.tbx_home_code = new System.Windows.Forms.TextBox();
            this.label13 = new System.Windows.Forms.Label();
            this.menuStrip.SuspendLayout();
            this.gb_lab1.SuspendLayout();
            this.gb_lab2.SuspendLayout();
            this.gb_lab3.SuspendLayout();
            this.gb_controls.SuspendLayout();
            this.SuspendLayout();
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
            this.statusStrip1.Location = new System.Drawing.Point(0, 478);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(792, 22);
            this.statusStrip1.TabIndex = 13;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // cbxPorts
            // 
            this.cbxPorts.FormattingEnabled = true;
            this.cbxPorts.Location = new System.Drawing.Point(150, 3);
            this.cbxPorts.Name = "cbxPorts";
            this.cbxPorts.Size = new System.Drawing.Size(147, 21);
            this.cbxPorts.TabIndex = 20;
            this.cbxPorts.SelectedIndexChanged += new System.EventHandler(this.cbxPorts_SelectedIndexChanged);
            // 
            // gb_lab1
            // 
            this.gb_lab1.Controls.Add(this.label15);
            this.gb_lab1.Controls.Add(this.tbx_lab1_unit_code);
            this.gb_lab1.Controls.Add(this.btn_lab1_plug_off);
            this.gb_lab1.Controls.Add(this.btn_lab1_plug_on);
            this.gb_lab1.Controls.Add(this.btn_lab1_fan_off);
            this.gb_lab1.Controls.Add(this.btn_lab1_fan_on);
            this.gb_lab1.Controls.Add(this.btn_lab1_tube_off);
            this.gb_lab1.Controls.Add(this.btn_lab1_tube_on);
            this.gb_lab1.Controls.Add(this.btn_lab1_cfl_off);
            this.gb_lab1.Controls.Add(this.btn_lab1_cfl_on);
            this.gb_lab1.Controls.Add(this.label4);
            this.gb_lab1.Controls.Add(this.label3);
            this.gb_lab1.Controls.Add(this.label2);
            this.gb_lab1.Controls.Add(this.label1);
            this.gb_lab1.Location = new System.Drawing.Point(27, 46);
            this.gb_lab1.Name = "gb_lab1";
            this.gb_lab1.Size = new System.Drawing.Size(312, 190);
            this.gb_lab1.TabIndex = 21;
            this.gb_lab1.TabStop = false;
            this.gb_lab1.Text = "LAB-1";
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Location = new System.Drawing.Point(19, 18);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(54, 13);
            this.label15.TabIndex = 13;
            this.label15.Text = "Unit Code";
            // 
            // tbx_lab1_unit_code
            // 
            this.tbx_lab1_unit_code.Location = new System.Drawing.Point(107, 12);
            this.tbx_lab1_unit_code.Name = "tbx_lab1_unit_code";
            this.tbx_lab1_unit_code.Size = new System.Drawing.Size(100, 20);
            this.tbx_lab1_unit_code.TabIndex = 12;
            // 
            // btn_lab1_plug_off
            // 
            this.btn_lab1_plug_off.Location = new System.Drawing.Point(195, 148);
            this.btn_lab1_plug_off.Name = "btn_lab1_plug_off";
            this.btn_lab1_plug_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab1_plug_off.TabIndex = 11;
            this.btn_lab1_plug_off.Text = "OFF";
            this.btn_lab1_plug_off.UseVisualStyleBackColor = true;
            this.btn_lab1_plug_off.Click += new System.EventHandler(this.btn_lab1_plug_off_Click);
            // 
            // btn_lab1_plug_on
            // 
            this.btn_lab1_plug_on.Location = new System.Drawing.Point(107, 149);
            this.btn_lab1_plug_on.Name = "btn_lab1_plug_on";
            this.btn_lab1_plug_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab1_plug_on.TabIndex = 10;
            this.btn_lab1_plug_on.Text = "ON";
            this.btn_lab1_plug_on.UseVisualStyleBackColor = true;
            this.btn_lab1_plug_on.Click += new System.EventHandler(this.btn_lab1_plug_on_Click);
            // 
            // btn_lab1_fan_off
            // 
            this.btn_lab1_fan_off.Location = new System.Drawing.Point(195, 112);
            this.btn_lab1_fan_off.Name = "btn_lab1_fan_off";
            this.btn_lab1_fan_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab1_fan_off.TabIndex = 9;
            this.btn_lab1_fan_off.Text = "OFF";
            this.btn_lab1_fan_off.UseVisualStyleBackColor = true;
            this.btn_lab1_fan_off.Click += new System.EventHandler(this.btn_lab1_fan_off_Click);
            // 
            // btn_lab1_fan_on
            // 
            this.btn_lab1_fan_on.Location = new System.Drawing.Point(107, 112);
            this.btn_lab1_fan_on.Name = "btn_lab1_fan_on";
            this.btn_lab1_fan_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab1_fan_on.TabIndex = 8;
            this.btn_lab1_fan_on.Text = "ON";
            this.btn_lab1_fan_on.UseVisualStyleBackColor = true;
            this.btn_lab1_fan_on.Click += new System.EventHandler(this.btn_lab1_fan_on_Click);
            // 
            // btn_lab1_tube_off
            // 
            this.btn_lab1_tube_off.Location = new System.Drawing.Point(195, 77);
            this.btn_lab1_tube_off.Name = "btn_lab1_tube_off";
            this.btn_lab1_tube_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab1_tube_off.TabIndex = 7;
            this.btn_lab1_tube_off.Text = "OFF";
            this.btn_lab1_tube_off.UseVisualStyleBackColor = true;
            this.btn_lab1_tube_off.Click += new System.EventHandler(this.btn_lab1_tube_off_Click);
            // 
            // btn_lab1_tube_on
            // 
            this.btn_lab1_tube_on.Location = new System.Drawing.Point(107, 77);
            this.btn_lab1_tube_on.Name = "btn_lab1_tube_on";
            this.btn_lab1_tube_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab1_tube_on.TabIndex = 6;
            this.btn_lab1_tube_on.Text = "ON";
            this.btn_lab1_tube_on.UseVisualStyleBackColor = true;
            this.btn_lab1_tube_on.Click += new System.EventHandler(this.btn_lab1_tube_on_Click);
            // 
            // btn_lab1_cfl_off
            // 
            this.btn_lab1_cfl_off.Location = new System.Drawing.Point(195, 41);
            this.btn_lab1_cfl_off.Name = "btn_lab1_cfl_off";
            this.btn_lab1_cfl_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab1_cfl_off.TabIndex = 5;
            this.btn_lab1_cfl_off.Text = "OFF";
            this.btn_lab1_cfl_off.UseVisualStyleBackColor = true;
            this.btn_lab1_cfl_off.Click += new System.EventHandler(this.btn_lab1_cfl_off_Click);
            // 
            // btn_lab1_cfl_on
            // 
            this.btn_lab1_cfl_on.Location = new System.Drawing.Point(107, 41);
            this.btn_lab1_cfl_on.Name = "btn_lab1_cfl_on";
            this.btn_lab1_cfl_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab1_cfl_on.TabIndex = 4;
            this.btn_lab1_cfl_on.Text = "ON";
            this.btn_lab1_cfl_on.UseVisualStyleBackColor = true;
            this.btn_lab1_cfl_on.Click += new System.EventHandler(this.btn_lab1_cfl_on_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(19, 158);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(28, 13);
            this.label4.TabIndex = 3;
            this.label4.Text = "Plug";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(19, 112);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(25, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Fan";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(19, 77);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(58, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Tube Light";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(19, 46);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(26, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "CFL";
            // 
            // gb_lab2
            // 
            this.gb_lab2.Controls.Add(this.label16);
            this.gb_lab2.Controls.Add(this.tbx_lab2_unit_code);
            this.gb_lab2.Controls.Add(this.btn_lab2_plug_off);
            this.gb_lab2.Controls.Add(this.btn_lab2_plug_on);
            this.gb_lab2.Controls.Add(this.btn_lab2_fan_off);
            this.gb_lab2.Controls.Add(this.btn_lab2_fan_on);
            this.gb_lab2.Controls.Add(this.btn_lab2_tube_off);
            this.gb_lab2.Controls.Add(this.btn_lab2_tube_on);
            this.gb_lab2.Controls.Add(this.btn_lab2_cfl_off);
            this.gb_lab2.Controls.Add(this.btn_lab2_cfl_on);
            this.gb_lab2.Controls.Add(this.label5);
            this.gb_lab2.Controls.Add(this.label6);
            this.gb_lab2.Controls.Add(this.label7);
            this.gb_lab2.Controls.Add(this.label8);
            this.gb_lab2.Location = new System.Drawing.Point(374, 46);
            this.gb_lab2.Name = "gb_lab2";
            this.gb_lab2.Size = new System.Drawing.Size(312, 190);
            this.gb_lab2.TabIndex = 22;
            this.gb_lab2.TabStop = false;
            this.gb_lab2.Text = "LAB-2";
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Location = new System.Drawing.Point(19, 16);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(54, 13);
            this.label16.TabIndex = 14;
            this.label16.Text = "Unit Code";
            // 
            // tbx_lab2_unit_code
            // 
            this.tbx_lab2_unit_code.Location = new System.Drawing.Point(107, 11);
            this.tbx_lab2_unit_code.Name = "tbx_lab2_unit_code";
            this.tbx_lab2_unit_code.Size = new System.Drawing.Size(100, 20);
            this.tbx_lab2_unit_code.TabIndex = 13;
            // 
            // btn_lab2_plug_off
            // 
            this.btn_lab2_plug_off.Location = new System.Drawing.Point(195, 144);
            this.btn_lab2_plug_off.Name = "btn_lab2_plug_off";
            this.btn_lab2_plug_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab2_plug_off.TabIndex = 11;
            this.btn_lab2_plug_off.Text = "OFF";
            this.btn_lab2_plug_off.UseVisualStyleBackColor = true;
            this.btn_lab2_plug_off.Click += new System.EventHandler(this.btn_lab2_plug_off_Click);
            // 
            // btn_lab2_plug_on
            // 
            this.btn_lab2_plug_on.Location = new System.Drawing.Point(107, 145);
            this.btn_lab2_plug_on.Name = "btn_lab2_plug_on";
            this.btn_lab2_plug_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab2_plug_on.TabIndex = 10;
            this.btn_lab2_plug_on.Text = "ON";
            this.btn_lab2_plug_on.UseVisualStyleBackColor = true;
            this.btn_lab2_plug_on.Click += new System.EventHandler(this.btn_lab2_plug_on_Click);
            // 
            // btn_lab2_fan_off
            // 
            this.btn_lab2_fan_off.Location = new System.Drawing.Point(195, 112);
            this.btn_lab2_fan_off.Name = "btn_lab2_fan_off";
            this.btn_lab2_fan_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab2_fan_off.TabIndex = 9;
            this.btn_lab2_fan_off.Text = "OFF";
            this.btn_lab2_fan_off.UseVisualStyleBackColor = true;
            this.btn_lab2_fan_off.Click += new System.EventHandler(this.btn_lab2_fan_off_Click);
            // 
            // btn_lab2_fan_on
            // 
            this.btn_lab2_fan_on.Location = new System.Drawing.Point(107, 112);
            this.btn_lab2_fan_on.Name = "btn_lab2_fan_on";
            this.btn_lab2_fan_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab2_fan_on.TabIndex = 8;
            this.btn_lab2_fan_on.Text = "ON";
            this.btn_lab2_fan_on.UseVisualStyleBackColor = true;
            this.btn_lab2_fan_on.Click += new System.EventHandler(this.btn_lab2_fan_on_Click);
            // 
            // btn_lab2_tube_off
            // 
            this.btn_lab2_tube_off.Location = new System.Drawing.Point(195, 77);
            this.btn_lab2_tube_off.Name = "btn_lab2_tube_off";
            this.btn_lab2_tube_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab2_tube_off.TabIndex = 7;
            this.btn_lab2_tube_off.Text = "OFF";
            this.btn_lab2_tube_off.UseVisualStyleBackColor = true;
            this.btn_lab2_tube_off.Click += new System.EventHandler(this.btn_lab2_tube_off_Click);
            // 
            // btn_lab2_tube_on
            // 
            this.btn_lab2_tube_on.Location = new System.Drawing.Point(107, 77);
            this.btn_lab2_tube_on.Name = "btn_lab2_tube_on";
            this.btn_lab2_tube_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab2_tube_on.TabIndex = 6;
            this.btn_lab2_tube_on.Text = "ON";
            this.btn_lab2_tube_on.UseVisualStyleBackColor = true;
            this.btn_lab2_tube_on.Click += new System.EventHandler(this.btn_lab2_tube_on_Click);
            // 
            // btn_lab2_cfl_off
            // 
            this.btn_lab2_cfl_off.Location = new System.Drawing.Point(195, 41);
            this.btn_lab2_cfl_off.Name = "btn_lab2_cfl_off";
            this.btn_lab2_cfl_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab2_cfl_off.TabIndex = 5;
            this.btn_lab2_cfl_off.Text = "OFF";
            this.btn_lab2_cfl_off.UseVisualStyleBackColor = true;
            this.btn_lab2_cfl_off.Click += new System.EventHandler(this.btn_lab2_cfl_off_Click);
            // 
            // btn_lab2_cfl_on
            // 
            this.btn_lab2_cfl_on.Location = new System.Drawing.Point(107, 41);
            this.btn_lab2_cfl_on.Name = "btn_lab2_cfl_on";
            this.btn_lab2_cfl_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab2_cfl_on.TabIndex = 4;
            this.btn_lab2_cfl_on.Text = "ON";
            this.btn_lab2_cfl_on.UseVisualStyleBackColor = true;
            this.btn_lab2_cfl_on.Click += new System.EventHandler(this.btn_lab2_cfl_on_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(19, 154);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(28, 13);
            this.label5.TabIndex = 3;
            this.label5.Text = "Plug";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(19, 112);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(25, 13);
            this.label6.TabIndex = 2;
            this.label6.Text = "Fan";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(19, 77);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(58, 13);
            this.label7.TabIndex = 1;
            this.label7.Text = "Tube Light";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(19, 43);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(26, 13);
            this.label8.TabIndex = 0;
            this.label8.Text = "CFL";
            // 
            // gb_lab3
            // 
            this.gb_lab3.Controls.Add(this.label17);
            this.gb_lab3.Controls.Add(this.tbx_lab3_unit_code);
            this.gb_lab3.Controls.Add(this.btn_lab3_plug_off);
            this.gb_lab3.Controls.Add(this.btn_lab3_plug_on);
            this.gb_lab3.Controls.Add(this.btn_lab3_fan_off);
            this.gb_lab3.Controls.Add(this.btn_lab3_fan_on);
            this.gb_lab3.Controls.Add(this.btn_lab3_tube_off);
            this.gb_lab3.Controls.Add(this.btn_lab3_tube_on);
            this.gb_lab3.Controls.Add(this.btn_lab3_cfl_off);
            this.gb_lab3.Controls.Add(this.btn_lab3_cfl_on);
            this.gb_lab3.Controls.Add(this.label9);
            this.gb_lab3.Controls.Add(this.label10);
            this.gb_lab3.Controls.Add(this.label11);
            this.gb_lab3.Controls.Add(this.label12);
            this.gb_lab3.Location = new System.Drawing.Point(27, 263);
            this.gb_lab3.Name = "gb_lab3";
            this.gb_lab3.Size = new System.Drawing.Size(312, 190);
            this.gb_lab3.TabIndex = 22;
            this.gb_lab3.TabStop = false;
            this.gb_lab3.Text = "LAB-3";
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.Location = new System.Drawing.Point(19, 16);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(54, 13);
            this.label17.TabIndex = 15;
            this.label17.Text = "Unit Code";
            // 
            // tbx_lab3_unit_code
            // 
            this.tbx_lab3_unit_code.Location = new System.Drawing.Point(107, 11);
            this.tbx_lab3_unit_code.Name = "tbx_lab3_unit_code";
            this.tbx_lab3_unit_code.Size = new System.Drawing.Size(100, 20);
            this.tbx_lab3_unit_code.TabIndex = 14;
            // 
            // btn_lab3_plug_off
            // 
            this.btn_lab3_plug_off.Location = new System.Drawing.Point(195, 144);
            this.btn_lab3_plug_off.Name = "btn_lab3_plug_off";
            this.btn_lab3_plug_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab3_plug_off.TabIndex = 11;
            this.btn_lab3_plug_off.Text = "OFF";
            this.btn_lab3_plug_off.UseVisualStyleBackColor = true;
            this.btn_lab3_plug_off.Click += new System.EventHandler(this.btn_lab3_plug_off_Click);
            // 
            // btn_lab3_plug_on
            // 
            this.btn_lab3_plug_on.Location = new System.Drawing.Point(107, 145);
            this.btn_lab3_plug_on.Name = "btn_lab3_plug_on";
            this.btn_lab3_plug_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab3_plug_on.TabIndex = 10;
            this.btn_lab3_plug_on.Text = "ON";
            this.btn_lab3_plug_on.UseVisualStyleBackColor = true;
            this.btn_lab3_plug_on.Click += new System.EventHandler(this.btn_lab3_plug_on_Click);
            // 
            // btn_lab3_fan_off
            // 
            this.btn_lab3_fan_off.Location = new System.Drawing.Point(195, 112);
            this.btn_lab3_fan_off.Name = "btn_lab3_fan_off";
            this.btn_lab3_fan_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab3_fan_off.TabIndex = 9;
            this.btn_lab3_fan_off.Text = "OFF";
            this.btn_lab3_fan_off.UseVisualStyleBackColor = true;
            this.btn_lab3_fan_off.Click += new System.EventHandler(this.btn_lab3_fan_off_Click);
            // 
            // btn_lab3_fan_on
            // 
            this.btn_lab3_fan_on.Location = new System.Drawing.Point(107, 112);
            this.btn_lab3_fan_on.Name = "btn_lab3_fan_on";
            this.btn_lab3_fan_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab3_fan_on.TabIndex = 8;
            this.btn_lab3_fan_on.Text = "ON";
            this.btn_lab3_fan_on.UseVisualStyleBackColor = true;
            this.btn_lab3_fan_on.Click += new System.EventHandler(this.btn_lab3_fan_on_Click);
            // 
            // btn_lab3_tube_off
            // 
            this.btn_lab3_tube_off.Location = new System.Drawing.Point(195, 77);
            this.btn_lab3_tube_off.Name = "btn_lab3_tube_off";
            this.btn_lab3_tube_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab3_tube_off.TabIndex = 7;
            this.btn_lab3_tube_off.Text = "OFF";
            this.btn_lab3_tube_off.UseVisualStyleBackColor = true;
            this.btn_lab3_tube_off.Click += new System.EventHandler(this.btn_lab3_tube_off_Click);
            // 
            // btn_lab3_tube_on
            // 
            this.btn_lab3_tube_on.Location = new System.Drawing.Point(107, 77);
            this.btn_lab3_tube_on.Name = "btn_lab3_tube_on";
            this.btn_lab3_tube_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab3_tube_on.TabIndex = 6;
            this.btn_lab3_tube_on.Text = "ON";
            this.btn_lab3_tube_on.UseVisualStyleBackColor = true;
            this.btn_lab3_tube_on.Click += new System.EventHandler(this.btn_lab3_tube_on_Click);
            // 
            // btn_lab3_cfl_off
            // 
            this.btn_lab3_cfl_off.Location = new System.Drawing.Point(195, 41);
            this.btn_lab3_cfl_off.Name = "btn_lab3_cfl_off";
            this.btn_lab3_cfl_off.Size = new System.Drawing.Size(75, 23);
            this.btn_lab3_cfl_off.TabIndex = 5;
            this.btn_lab3_cfl_off.Text = "OFF";
            this.btn_lab3_cfl_off.UseVisualStyleBackColor = true;
            this.btn_lab3_cfl_off.Click += new System.EventHandler(this.btn_lab3_cfl_off_Click);
            // 
            // btn_lab3_cfl_on
            // 
            this.btn_lab3_cfl_on.Location = new System.Drawing.Point(107, 41);
            this.btn_lab3_cfl_on.Name = "btn_lab3_cfl_on";
            this.btn_lab3_cfl_on.Size = new System.Drawing.Size(75, 23);
            this.btn_lab3_cfl_on.TabIndex = 4;
            this.btn_lab3_cfl_on.Text = "ON";
            this.btn_lab3_cfl_on.UseVisualStyleBackColor = true;
            this.btn_lab3_cfl_on.Click += new System.EventHandler(this.btn_lab3_cfl_on_Click);
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(19, 154);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(28, 13);
            this.label9.TabIndex = 3;
            this.label9.Text = "Plug";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(19, 112);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(25, 13);
            this.label10.TabIndex = 2;
            this.label10.Text = "Fan";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(19, 77);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(58, 13);
            this.label11.TabIndex = 1;
            this.label11.Text = "Tube Light";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(19, 43);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(26, 13);
            this.label12.TabIndex = 0;
            this.label12.Text = "CFL";
            // 
            // gb_controls
            // 
            this.gb_controls.Controls.Add(this.tbx_unit_code);
            this.gb_controls.Controls.Add(this.label14);
            this.gb_controls.Controls.Add(this.tbx_home_code);
            this.gb_controls.Controls.Add(this.label13);
            this.gb_controls.Location = new System.Drawing.Point(374, 263);
            this.gb_controls.Name = "gb_controls";
            this.gb_controls.Size = new System.Drawing.Size(312, 190);
            this.gb_controls.TabIndex = 23;
            this.gb_controls.TabStop = false;
            this.gb_controls.Text = "Controls";
            // 
            // tbx_unit_code
            // 
            this.tbx_unit_code.Location = new System.Drawing.Point(150, 74);
            this.tbx_unit_code.Name = "tbx_unit_code";
            this.tbx_unit_code.Size = new System.Drawing.Size(100, 20);
            this.tbx_unit_code.TabIndex = 3;
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(38, 77);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(54, 13);
            this.label14.TabIndex = 2;
            this.label14.Text = "Unit Code";
            // 
            // tbx_home_code
            // 
            this.tbx_home_code.Location = new System.Drawing.Point(150, 32);
            this.tbx_home_code.Name = "tbx_home_code";
            this.tbx_home_code.Size = new System.Drawing.Size(100, 20);
            this.tbx_home_code.TabIndex = 1;
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(38, 32);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(63, 13);
            this.label13.TabIndex = 0;
            this.label13.Text = "Home Code";
            // 
            // FormMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(792, 500);
            this.Controls.Add(this.gb_controls);
            this.Controls.Add(this.gb_lab3);
            this.Controls.Add(this.gb_lab2);
            this.Controls.Add(this.gb_lab1);
            this.Controls.Add(this.cbxPorts);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.menuStrip);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip;
            this.MinimumSize = new System.Drawing.Size(800, 480);
            this.Name = "FormMain";
            this.Text = " ::: Home Automation";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.FormMain_FormClosed);
            this.Load += new System.EventHandler(this.FormMain_Load);
            this.Resize += new System.EventHandler(this.FormMain_Resize);
            this.menuStrip.ResumeLayout(false);
            this.menuStrip.PerformLayout();
            this.gb_lab1.ResumeLayout(false);
            this.gb_lab1.PerformLayout();
            this.gb_lab2.ResumeLayout(false);
            this.gb_lab2.PerformLayout();
            this.gb_lab3.ResumeLayout(false);
            this.gb_lab3.PerformLayout();
            this.gb_controls.ResumeLayout(false);
            this.gb_controls.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

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
        private System.Windows.Forms.ToolStripMenuItem zoomOutAllToolStripMenuItem;
        private System.Windows.Forms.ComboBox cbxPorts;
        private System.Windows.Forms.GroupBox gb_lab1;
        private System.Windows.Forms.Button btn_lab1_plug_off;
        private System.Windows.Forms.Button btn_lab1_plug_on;
        private System.Windows.Forms.Button btn_lab1_fan_off;
        private System.Windows.Forms.Button btn_lab1_fan_on;
        private System.Windows.Forms.Button btn_lab1_tube_off;
        private System.Windows.Forms.Button btn_lab1_tube_on;
        private System.Windows.Forms.Button btn_lab1_cfl_off;
        private System.Windows.Forms.Button btn_lab1_cfl_on;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox gb_lab2;
        private System.Windows.Forms.Button btn_lab2_plug_off;
        private System.Windows.Forms.Button btn_lab2_plug_on;
        private System.Windows.Forms.Button btn_lab2_fan_off;
        private System.Windows.Forms.Button btn_lab2_fan_on;
        private System.Windows.Forms.Button btn_lab2_tube_off;
        private System.Windows.Forms.Button btn_lab2_tube_on;
        private System.Windows.Forms.Button btn_lab2_cfl_off;
        private System.Windows.Forms.Button btn_lab2_cfl_on;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.GroupBox gb_lab3;
        private System.Windows.Forms.Button btn_lab3_plug_off;
        private System.Windows.Forms.Button btn_lab3_plug_on;
        private System.Windows.Forms.Button btn_lab3_fan_off;
        private System.Windows.Forms.Button btn_lab3_fan_on;
        private System.Windows.Forms.Button btn_lab3_tube_off;
        private System.Windows.Forms.Button btn_lab3_tube_on;
        private System.Windows.Forms.Button btn_lab3_cfl_off;
        private System.Windows.Forms.Button btn_lab3_cfl_on;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.GroupBox gb_controls;
        private System.Windows.Forms.TextBox tbx_unit_code;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.TextBox tbx_home_code;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.TextBox tbx_lab1_unit_code;
        private System.Windows.Forms.TextBox tbx_lab2_unit_code;
        private System.Windows.Forms.TextBox tbx_lab3_unit_code;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.Label label17;

    }
}

