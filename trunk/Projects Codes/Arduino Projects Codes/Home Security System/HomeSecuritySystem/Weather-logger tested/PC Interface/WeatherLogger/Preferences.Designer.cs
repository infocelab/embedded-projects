namespace WeatherLogger
{
    partial class Preferences
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
            this.tbPref = new System.Windows.Forms.TabControl();
            this.tpTime = new System.Windows.Forms.TabPage();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.rbCopySysTime = new System.Windows.Forms.RadioButton();
            this.gbTimeFormat = new System.Windows.Forms.GroupBox();
            this.rb12hr = new System.Windows.Forms.RadioButton();
            this.rb24hr = new System.Windows.Forms.RadioButton();
            this.gbInterval = new System.Windows.Forms.GroupBox();
            this.nudInterval = new System.Windows.Forms.NumericUpDown();
            this.tbColor = new System.Windows.Forms.TabPage();
            this.gbColours = new System.Windows.Forms.GroupBox();
            this.btnPreColor = new System.Windows.Forms.Button();
            this.btnTempColor = new System.Windows.Forms.Button();
            this.btnHumidColor = new System.Windows.Forms.Button();
            this.tpMisc = new System.Windows.Forms.TabPage();
            this.btnOK = new System.Windows.Forms.Button();
            this.btnCancell = new System.Windows.Forms.Button();
            this.btnApply = new System.Windows.Forms.Button();
            this.colorDialog = new System.Windows.Forms.ColorDialog();
            this.gbMisc = new System.Windows.Forms.GroupBox();
            this.cbShowPointValues = new System.Windows.Forms.CheckBox();
            this.cbSaveOnExit = new System.Windows.Forms.CheckBox();
            this.tbPref.SuspendLayout();
            this.tpTime.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.gbTimeFormat.SuspendLayout();
            this.gbInterval.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudInterval)).BeginInit();
            this.tbColor.SuspendLayout();
            this.gbColours.SuspendLayout();
            this.tpMisc.SuspendLayout();
            this.gbMisc.SuspendLayout();
            this.SuspendLayout();
            // 
            // tbPref
            // 
            this.tbPref.Controls.Add(this.tpTime);
            this.tbPref.Controls.Add(this.tbColor);
            this.tbPref.Controls.Add(this.tpMisc);
            this.tbPref.Location = new System.Drawing.Point(8, 9);
            this.tbPref.Name = "tbPref";
            this.tbPref.SelectedIndex = 0;
            this.tbPref.Size = new System.Drawing.Size(378, 213);
            this.tbPref.TabIndex = 0;
            // 
            // tpTime
            // 
            this.tpTime.Controls.Add(this.groupBox1);
            this.tpTime.Controls.Add(this.gbTimeFormat);
            this.tpTime.Controls.Add(this.gbInterval);
            this.tpTime.Location = new System.Drawing.Point(4, 22);
            this.tpTime.Name = "tpTime";
            this.tpTime.Padding = new System.Windows.Forms.Padding(3);
            this.tpTime.Size = new System.Drawing.Size(370, 187);
            this.tpTime.TabIndex = 0;
            this.tpTime.Text = "Time";
            this.tpTime.UseVisualStyleBackColor = true;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.rbCopySysTime);
            this.groupBox1.Location = new System.Drawing.Point(18, 118);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(135, 50);
            this.groupBox1.TabIndex = 4;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Set Time";
            // 
            // rbCopySysTime
            // 
            this.rbCopySysTime.AutoSize = true;
            this.rbCopySysTime.Location = new System.Drawing.Point(20, 14);
            this.rbCopySysTime.Name = "rbCopySysTime";
            this.rbCopySysTime.Size = new System.Drawing.Size(99, 30);
            this.rbCopySysTime.TabIndex = 0;
            this.rbCopySysTime.TabStop = true;
            this.rbCopySysTime.Text = "Set Time\r\nas System Time";
            this.rbCopySysTime.UseVisualStyleBackColor = true;
            // 
            // gbTimeFormat
            // 
            this.gbTimeFormat.Controls.Add(this.rb12hr);
            this.gbTimeFormat.Controls.Add(this.rb24hr);
            this.gbTimeFormat.Location = new System.Drawing.Point(18, 6);
            this.gbTimeFormat.Name = "gbTimeFormat";
            this.gbTimeFormat.Size = new System.Drawing.Size(135, 50);
            this.gbTimeFormat.TabIndex = 3;
            this.gbTimeFormat.TabStop = false;
            this.gbTimeFormat.Text = "Time Format";
            // 
            // rb12hr
            // 
            this.rb12hr.AutoSize = true;
            this.rb12hr.Location = new System.Drawing.Point(73, 19);
            this.rb12hr.Name = "rb12hr";
            this.rb12hr.Size = new System.Drawing.Size(56, 17);
            this.rb12hr.TabIndex = 1;
            this.rb12hr.TabStop = true;
            this.rb12hr.Text = "12 HR";
            this.rb12hr.UseVisualStyleBackColor = true;
            // 
            // rb24hr
            // 
            this.rb24hr.AutoSize = true;
            this.rb24hr.Location = new System.Drawing.Point(11, 19);
            this.rb24hr.Name = "rb24hr";
            this.rb24hr.Size = new System.Drawing.Size(56, 17);
            this.rb24hr.TabIndex = 0;
            this.rb24hr.TabStop = true;
            this.rb24hr.Text = "24 HR";
            this.rb24hr.UseVisualStyleBackColor = true;
            // 
            // gbInterval
            // 
            this.gbInterval.Controls.Add(this.nudInterval);
            this.gbInterval.Location = new System.Drawing.Point(18, 62);
            this.gbInterval.Name = "gbInterval";
            this.gbInterval.Size = new System.Drawing.Size(135, 50);
            this.gbInterval.TabIndex = 2;
            this.gbInterval.TabStop = false;
            this.gbInterval.Text = "Sampling Rate (Minute)";
            // 
            // nudInterval
            // 
            this.nudInterval.Location = new System.Drawing.Point(35, 19);
            this.nudInterval.Maximum = new decimal(new int[] {
            255,
            0,
            0,
            0});
            this.nudInterval.Minimum = new decimal(new int[] {
            15,
            0,
            0,
            0});
            this.nudInterval.Name = "nudInterval";
            this.nudInterval.Size = new System.Drawing.Size(50, 20);
            this.nudInterval.TabIndex = 1;
            this.nudInterval.Value = new decimal(new int[] {
            15,
            0,
            0,
            0});
            // 
            // tbColor
            // 
            this.tbColor.Controls.Add(this.gbColours);
            this.tbColor.Location = new System.Drawing.Point(4, 22);
            this.tbColor.Name = "tbColor";
            this.tbColor.Size = new System.Drawing.Size(370, 187);
            this.tbColor.TabIndex = 2;
            this.tbColor.Text = "Color";
            this.tbColor.UseVisualStyleBackColor = true;
            // 
            // gbColours
            // 
            this.gbColours.Controls.Add(this.btnPreColor);
            this.gbColours.Controls.Add(this.btnTempColor);
            this.gbColours.Controls.Add(this.btnHumidColor);
            this.gbColours.Location = new System.Drawing.Point(15, 44);
            this.gbColours.Name = "gbColours";
            this.gbColours.Size = new System.Drawing.Size(342, 61);
            this.gbColours.TabIndex = 1;
            this.gbColours.TabStop = false;
            this.gbColours.Text = "Graph Color";
            // 
            // btnPreColor
            // 
            this.btnPreColor.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnPreColor.Location = new System.Drawing.Point(251, 19);
            this.btnPreColor.Name = "btnPreColor";
            this.btnPreColor.Size = new System.Drawing.Size(75, 23);
            this.btnPreColor.TabIndex = 2;
            this.btnPreColor.Text = "Pressure";
            this.btnPreColor.UseVisualStyleBackColor = true;
            this.btnPreColor.Click += new System.EventHandler(this.btnPreColor_Click);
            // 
            // btnTempColor
            // 
            this.btnTempColor.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnTempColor.Location = new System.Drawing.Point(134, 19);
            this.btnTempColor.Name = "btnTempColor";
            this.btnTempColor.Size = new System.Drawing.Size(75, 23);
            this.btnTempColor.TabIndex = 1;
            this.btnTempColor.Text = "Temperature";
            this.btnTempColor.UseVisualStyleBackColor = true;
            this.btnTempColor.Click += new System.EventHandler(this.btnTempColor_Click);
            // 
            // btnHumidColor
            // 
            this.btnHumidColor.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnHumidColor.Location = new System.Drawing.Point(19, 19);
            this.btnHumidColor.Name = "btnHumidColor";
            this.btnHumidColor.Size = new System.Drawing.Size(75, 23);
            this.btnHumidColor.TabIndex = 0;
            this.btnHumidColor.Text = "Humidity";
            this.btnHumidColor.UseVisualStyleBackColor = true;
            this.btnHumidColor.Click += new System.EventHandler(this.btnHumidColor_Click);
            // 
            // tpMisc
            // 
            this.tpMisc.Controls.Add(this.gbMisc);
            this.tpMisc.Location = new System.Drawing.Point(4, 22);
            this.tpMisc.Name = "tpMisc";
            this.tpMisc.Padding = new System.Windows.Forms.Padding(3);
            this.tpMisc.Size = new System.Drawing.Size(370, 187);
            this.tpMisc.TabIndex = 1;
            this.tpMisc.Text = "Misc";
            this.tpMisc.UseVisualStyleBackColor = true;
            // 
            // btnOK
            // 
            this.btnOK.Location = new System.Drawing.Point(149, 228);
            this.btnOK.Name = "btnOK";
            this.btnOK.Size = new System.Drawing.Size(75, 23);
            this.btnOK.TabIndex = 1;
            this.btnOK.Text = "OK";
            this.btnOK.UseVisualStyleBackColor = true;
            this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
            // 
            // btnCancell
            // 
            this.btnCancell.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnCancell.Location = new System.Drawing.Point(230, 228);
            this.btnCancell.Name = "btnCancell";
            this.btnCancell.Size = new System.Drawing.Size(75, 23);
            this.btnCancell.TabIndex = 2;
            this.btnCancell.Text = "Cancell";
            this.btnCancell.UseVisualStyleBackColor = true;
            this.btnCancell.Click += new System.EventHandler(this.btnCancell_Click);
            // 
            // btnApply
            // 
            this.btnApply.Location = new System.Drawing.Point(311, 228);
            this.btnApply.Name = "btnApply";
            this.btnApply.Size = new System.Drawing.Size(75, 23);
            this.btnApply.TabIndex = 3;
            this.btnApply.Text = "Apply";
            this.btnApply.UseVisualStyleBackColor = true;
            this.btnApply.Click += new System.EventHandler(this.btnApply_Click);
            // 
            // gbMisc
            // 
            this.gbMisc.Controls.Add(this.cbSaveOnExit);
            this.gbMisc.Controls.Add(this.cbShowPointValues);
            this.gbMisc.Location = new System.Drawing.Point(12, 6);
            this.gbMisc.Name = "gbMisc";
            this.gbMisc.Size = new System.Drawing.Size(352, 175);
            this.gbMisc.TabIndex = 1;
            this.gbMisc.TabStop = false;
            // 
            // cbShowPointValues
            // 
            this.cbShowPointValues.AutoSize = true;
            this.cbShowPointValues.Location = new System.Drawing.Point(21, 31);
            this.cbShowPointValues.Name = "cbShowPointValues";
            this.cbShowPointValues.Size = new System.Drawing.Size(158, 17);
            this.cbShowPointValues.TabIndex = 0;
            this.cbShowPointValues.Text = "Show Point Values in Graph";
            this.cbShowPointValues.UseVisualStyleBackColor = true;
            // 
            // cbSaveOnExit
            // 
            this.cbSaveOnExit.AutoSize = true;
            this.cbSaveOnExit.Location = new System.Drawing.Point(21, 67);
            this.cbSaveOnExit.Name = "cbSaveOnExit";
            this.cbSaveOnExit.Size = new System.Drawing.Size(139, 17);
            this.cbSaveOnExit.TabIndex = 1;
            this.cbSaveOnExit.Text = "Auto Save Data On Exit";
            this.cbSaveOnExit.UseVisualStyleBackColor = true;
            // 
            // Preferences
            // 
            this.AcceptButton = this.btnOK;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.btnCancell;
            this.ClientSize = new System.Drawing.Size(394, 258);
            this.ControlBox = false;
            this.Controls.Add(this.btnApply);
            this.Controls.Add(this.btnCancell);
            this.Controls.Add(this.btnOK);
            this.Controls.Add(this.tbPref);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "Preferences";
            this.ShowInTaskbar = false;
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Preferences";
            this.Load += new System.EventHandler(this.Preferences_Load);
            this.tbPref.ResumeLayout(false);
            this.tpTime.ResumeLayout(false);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.gbTimeFormat.ResumeLayout(false);
            this.gbTimeFormat.PerformLayout();
            this.gbInterval.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.nudInterval)).EndInit();
            this.tbColor.ResumeLayout(false);
            this.gbColours.ResumeLayout(false);
            this.tpMisc.ResumeLayout(false);
            this.gbMisc.ResumeLayout(false);
            this.gbMisc.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tbPref;
        private System.Windows.Forms.TabPage tpTime;
        private System.Windows.Forms.TabPage tpMisc;
        private System.Windows.Forms.GroupBox gbInterval;
        private System.Windows.Forms.GroupBox gbTimeFormat;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TabPage tbColor;
        private System.Windows.Forms.Button btnOK;
        private System.Windows.Forms.Button btnCancell;
        private System.Windows.Forms.RadioButton rbCopySysTime;
        internal System.Windows.Forms.NumericUpDown nudInterval;
        internal System.Windows.Forms.RadioButton rb12hr;
        internal System.Windows.Forms.RadioButton rb24hr;
        private System.Windows.Forms.Button btnApply;
        private System.Windows.Forms.GroupBox gbColours;
        internal System.Windows.Forms.Button btnHumidColor;
        internal System.Windows.Forms.Button btnPreColor;
        internal System.Windows.Forms.Button btnTempColor;
        private System.Windows.Forms.ColorDialog colorDialog;
        private System.Windows.Forms.GroupBox gbMisc;
        internal System.Windows.Forms.CheckBox cbSaveOnExit;
        internal System.Windows.Forms.CheckBox cbShowPointValues;
    }
}