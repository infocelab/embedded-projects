package connect;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class Information extends javax.swing.JFrame 
{
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    static String user_type;
    
    
    public Information() 
    {
        initComponents();
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jTabbedPane13 = new javax.swing.JTabbedPane();
        jTabbedPane11 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabpan_daily_data_entry = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lbl_daily_data_entry_date = new javax.swing.JLabel();
        lbl_data_entry_date1 = new javax.swing.JLabel();
        lbl_daily_data_entry_user_name = new javax.swing.JLabel();
        lbl_daily_data_entry_logged_user = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_add_doctor = new javax.swing.JButton();
        txt_add_doctor_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmd_add_doctor_spec = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_doctors_list = new javax.swing.JTable();
        tabpane_borrowers = new javax.swing.JTabbedPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        lbl_borrowers_city1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_mark_att_date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmd_appointment_spec = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cmd_appointment_doctor = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_appointment = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tabpane_user_account = new javax.swing.JTabbedPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        lbl1_user_account = new javax.swing.JLabel();
        lbl2_user_account = new javax.swing.JLabel();
        txt1_user_account_user_name = new javax.swing.JTextField();
        btn1_user_account_add = new javax.swing.JButton();
        btn2_user_account_delete = new javax.swing.JButton();
        txt2_user_account_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

        lbl_daily_data_entry_date.setText("Date:");

        lbl_data_entry_date1.setText("jLabel7");

        lbl_daily_data_entry_user_name.setText("logged user");

        lbl_daily_data_entry_logged_user.setText("Logged User :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manage Doctor's");
        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));

        btn_add_doctor.setText("Add Doctor");
        btn_add_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_doctorActionPerformed(evt);
            }
        });

        txt_add_doctor_name.setBackground(new java.awt.Color(255, 204, 204));

        jLabel5.setText("Doctor Name");

        jLabel6.setText("Specialization");

        tbl_doctors_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor", "Specialization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_doctors_list);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(lbl_daily_data_entry_date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_data_entry_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_add_doctor_name, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cmd_add_doctor_spec, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_add_doctor))))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_daily_data_entry_date)
                    .addComponent(lbl_data_entry_date1)
                    .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_add_doctor_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmd_add_doctor_spec, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(btn_add_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(lbl_daily_data_entry_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_data_entry_date1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_logged_user, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_add_doctor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_add_doctor_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cmd_add_doctor_spec, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpan_daily_data_entry.addTab("Welcome on Doctor's List", jDesktopPane1);

        jTabbedPane1.addTab("Manage Doctor's", tabpan_daily_data_entry);

        jDesktopPane3.setBackground(new java.awt.Color(204, 204, 255));
        jDesktopPane3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDesktopPane3FocusGained(evt);
            }
        });
        jDesktopPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDesktopPane3MouseEntered(evt);
            }
        });

        lbl_borrowers_city1.setText("City:-");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Schedule Appointment");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel11.setText("Date");

        lbl_mark_att_date.setText("jLabel12");

        jLabel2.setText("Select Specialization ");

        cmd_appointment_spec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        cmd_appointment_spec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmd_appointment_specItemStateChanged(evt);
            }
        });

        jLabel8.setText("Select Doctor");

        cmd_appointment_doctor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmd_appointment_doctorItemStateChanged(evt);
            }
        });

        tbl_appointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_appointment);
        if (tbl_appointment.getColumnModel().getColumnCount() > 0) {
            tbl_appointment.getColumnModel().getColumn(0).setResizable(false);
            tbl_appointment.getColumnModel().getColumn(1).setResizable(false);
            tbl_appointment.getColumnModel().getColumn(2).setResizable(false);
            tbl_appointment.getColumnModel().getColumn(3).setResizable(false);
            tbl_appointment.getColumnModel().getColumn(4).setResizable(false);
            tbl_appointment.getColumnModel().getColumn(5).setResizable(false);
            tbl_appointment.getColumnModel().getColumn(6).setResizable(false);
            tbl_appointment.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel9.setText("Weekly Appointment");

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(60, 60, 60)
                        .addComponent(lbl_mark_att_date)
                        .addGap(187, 187, 187)
                        .addComponent(jLabel4))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(45, 45, 45)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmd_appointment_spec, 0, 156, Short.MAX_VALUE)
                            .addComponent(cmd_appointment_doctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(lbl_borrowers_city1)
                    .addContainerGap(883, Short.MAX_VALUE)))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lbl_mark_att_date))
                        .addGap(46, 46, 46)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmd_appointment_spec, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmd_appointment_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(537, Short.MAX_VALUE))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(522, 522, 522))))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(lbl_borrowers_city1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(548, Short.MAX_VALUE)))
        );
        jDesktopPane3.setLayer(lbl_borrowers_city1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(lbl_mark_att_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cmd_appointment_spec, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cmd_appointment_doctor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_borrowers.addTab("Welcome on Doctor's Appointment", jDesktopPane3);

        jTabbedPane1.addTab("Schedule Appointment", tabpane_borrowers);

        jDesktopPane2.setBackground(new java.awt.Color(204, 204, 255));

        lbl1_user_account.setText("UserName");

        lbl2_user_account.setText("Password");

        txt1_user_account_user_name.setBackground(new java.awt.Color(255, 204, 204));
        txt1_user_account_user_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1_user_account_user_nameActionPerformed(evt);
            }
        });

        btn1_user_account_add.setText("Add");
        btn1_user_account_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1_user_account_addActionPerformed(evt);
            }
        });

        btn2_user_account_delete.setText("Delete");
        btn2_user_account_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_user_account_deleteActionPerformed(evt);
            }
        });

        txt2_user_account_password.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setText("Please Log in as Admin to Add or Delete User");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Students Attendance");
        jLabel7.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jDesktopPane2Layout.createSequentialGroup()
                            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl2_user_account)
                                .addComponent(lbl1_user_account)
                                .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(btn1_user_account_add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(60, 60, 60)
                            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn2_user_account_delete)
                                .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(658, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1_user_account)
                    .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2_user_account)
                    .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn2_user_account_delete)
                    .addComponent(btn1_user_account_add))
                .addContainerGap(496, Short.MAX_VALUE))
        );
        jDesktopPane2.setLayer(lbl1_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbl2_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt1_user_account_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn1_user_account_add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn2_user_account_delete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt2_user_account_password, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_user_account.addTab("Welcome on User Account", jDesktopPane2);

        jTabbedPane1.addTab("User Account", tabpane_user_account);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) 
    {
      
    }
   
    private void cal_search_option_dateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cal_search_option_dateInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cal_search_option_dateInputMethodTextChanged

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        lbl_data_entry_date1.setText(date);
        lbl_mark_att_date.setText(date);
        
        lbl_daily_data_entry_user_name.setText(ConnectGUI.logged_user);
        if(ConnectGUI.logged_user.equals("admin"))
        {
            txt1_user_account_user_name.setEnabled(true);
            txt2_user_account_password.setEnabled(true);
            btn1_user_account_add.setEnabled(true);
            btn2_user_account_delete.setEnabled(true);
        }
        else
        {
            txt1_user_account_user_name.setEnabled(false);
            txt2_user_account_password.setEnabled(false);
            btn1_user_account_add.setEnabled(false);
            btn2_user_account_delete.setEnabled(false);
        }
 
        String sql;
        sql = "select * from doctors";
        conn = Connect.ConnectDB();
        try
        {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                DefaultTableModel model = (DefaultTableModel) tbl_doctors_list.getModel();
                model.setRowCount(0);
                do
                {
                    Object [] row= {rs.getString("doctor_name"),rs.getString("specialization")};
                    model.addRow(row);
                }while(rs.next());
            }
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Information.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object [] row = {"Eye", "Heart", "ENT", "Physician", "Ortho", "Kidney", "Lungs"};
        for(int i=0; i < row.length ; i++)
        {
            if(((DefaultComboBoxModel)cmd_add_doctor_spec.getModel()).getIndexOf(row[i].toString()) == -1 ) 
            {       
                cmd_add_doctor_spec.addItem(row[i]);
            }
            if(((DefaultComboBoxModel)cmd_appointment_spec.getModel()).getIndexOf(row[i].toString()) == -1 ) 
            {       
                cmd_appointment_spec.addItem(row[i]);
            }
        }
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void btn2_user_account_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_user_account_deleteActionPerformed
        String username = txt1_user_account_user_name.getText();
        if(username.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter Valid User name to Delete");
            return;
        }
        if(username.equals("admin"))
        {
            JOptionPane.showMessageDialog(null, "Admin User Cannot be Deleted");
            return;
        }

        String sql;
        sql = "select * from tableUSERPASS where username='" +  username + "'";
        conn = Connect.ConnectDB();
        try
        {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(!rs.next())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Valid User name to Delete");
                conn.close();
                return;
            }
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Information.class.getName()).log(Level.SEVERE, null, ex);
        }

        sql = "delete from tableUSERPASS where username='" +  username + "'";
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Delete successful");
            txt1_user_account_user_name.setText("");
            txt2_user_account_password.setText("");
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn2_user_account_deleteActionPerformed

    private void btn1_user_account_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_user_account_addActionPerformed
        String username = txt1_user_account_user_name.getText();
        String password = txt2_user_account_password.getText();

        if(username.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username cannot be Empty");
            return;
        }
        if(password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Password cannot be Empty");
            return;
        }

        String sql;
        sql = "Insert into tableUSERPASS (username,password) values ('" +  username + "','" + password + "')";

        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "user added successfully");
            txt1_user_account_user_name.setText("");
            txt2_user_account_password.setText("");

            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn1_user_account_addActionPerformed

    private void txt1_user_account_user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1_user_account_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1_user_account_user_nameActionPerformed

    private void jDesktopPane3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPane3MouseEntered
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jDesktopPane3MouseEntered

    private void jDesktopPane3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDesktopPane3FocusGained
        // TODO add your handling code here
    }//GEN-LAST:event_jDesktopPane3FocusGained

    private void btn_add_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_doctorActionPerformed
        // TODO add your handling code here:
        String doctor = txt_add_doctor_name.getText();
        String spec = cmd_add_doctor_spec.getSelectedItem().toString();
        
        if(doctor.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Doctor Name cannot be Empty");
            return;
        }
 
        
        String sql;
        sql = "Insert into doctors (doctor_name,specialization) values ('" +  doctor  + "','" + spec  +  "')";

        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doctor Added Successfully");
            txt_add_doctor_name.setText("");
            DefaultTableModel model = (DefaultTableModel) tbl_doctors_list.getModel();
            Object [] row= {doctor,spec};
            model.addRow(row);
            
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_add_doctorActionPerformed

    private void cmd_appointment_specItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmd_appointment_specItemStateChanged
        String sql;
        String spec = cmd_appointment_spec.getSelectedItem().toString();
        
        sql = "select * from doctors where specialization='" + spec + "'";
        conn = Connect.ConnectDB();
        try
        {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                do
                {
                    Object row= rs.getString("doctor_name");
                    if(((DefaultComboBoxModel)cmd_appointment_doctor.getModel()).getIndexOf(row.toString()) == -1 ) 
                    {       
                        cmd_appointment_doctor.addItem(row);
                    }
                }while(rs.next());
            }
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Information.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_cmd_appointment_specItemStateChanged

    private void cmd_appointment_doctorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmd_appointment_doctorItemStateChanged
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tbl_appointment.getModel();
        model.setRowCount(0);
        Object [] row1= {"10:30 AM"};
        model.addRow(row1);
            
        Object [] row2= {"11:30 AM"};
        model.addRow(row2);
        
        Object [] row3= {"12:30 PM"};
        model.addRow(row3);
        
        Object [] row4= {"2:30 PM"};
        model.addRow(row4);
        
        Object [] row5= {"3:30 PM"};
        model.addRow(row5);
        
        Object [] row6= {"4:30 PM"};
        model.addRow(row6);   
        
        
    }//GEN-LAST:event_cmd_appointment_doctorItemStateChanged
    public static void main(String args[]) 
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //FirmAccount fa=new FirmAccount();
        
       
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                new Information().setVisible(true);
            }
 
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1_user_account_add;
    private javax.swing.JButton btn2_user_account_delete;
    private javax.swing.JButton btn_add_doctor;
    private javax.swing.JComboBox cmd_add_doctor_spec;
    private javax.swing.JComboBox cmd_appointment_doctor;
    private javax.swing.JComboBox cmd_appointment_spec;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane11;
    private javax.swing.JTabbedPane jTabbedPane13;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JLabel lbl1_user_account;
    private javax.swing.JLabel lbl2_user_account;
    private javax.swing.JLabel lbl_borrowers_city1;
    private javax.swing.JLabel lbl_daily_data_entry_date;
    private javax.swing.JLabel lbl_daily_data_entry_logged_user;
    private javax.swing.JLabel lbl_daily_data_entry_user_name;
    private javax.swing.JLabel lbl_data_entry_date1;
    private javax.swing.JLabel lbl_mark_att_date;
    private javax.swing.JTabbedPane tabpan_daily_data_entry;
    private javax.swing.JTabbedPane tabpane_borrowers;
    private javax.swing.JTabbedPane tabpane_user_account;
    private javax.swing.JTable tbl_appointment;
    private javax.swing.JTable tbl_doctors_list;
    private javax.swing.JTextField txt1_user_account_user_name;
    private javax.swing.JPasswordField txt2_user_account_password;
    private javax.swing.JTextField txt_add_doctor_name;
    // End of variables declaration//GEN-END:variables
}
