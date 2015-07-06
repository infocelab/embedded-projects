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
        btn_add_branch = new javax.swing.JButton();
        txt_add_branch = new javax.swing.JTextField();
        cmb_all_branches = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_year = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txt_add_student_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_add_roll_number = new javax.swing.JTextField();
        btn_add_student = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_view_students = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btn_view_students = new javax.swing.JButton();
        tabpane_borrowers = new javax.swing.JTabbedPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        lbl_borrowers_city1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_mark_att_branch = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cmb_mark_att_year = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_mark_att_students_record = new javax.swing.JTable();
        btn_mark_att_save = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lbl_mark_att_date = new javax.swing.JLabel();
        btn_mark_att_get_record = new javax.swing.JButton();
        btn_mark_att_toggle_all = new javax.swing.JButton();
        tabpane_borrowers1 = new javax.swing.JTabbedPane();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        lbl_borrowers_city2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmb_view_att_branch = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        cmb_view_att_year = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_view_att_students_record = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        lbl_view_att_date = new javax.swing.JLabel();
        btn_view_att_get_record = new javax.swing.JButton();
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
        jLabel3.setText("Students Admission");
        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));

        btn_add_branch.setText("Add Branch");
        btn_add_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_branchActionPerformed(evt);
            }
        });

        txt_add_branch.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setText("All Branches ");

        jLabel5.setText("Select Year");

        cmb_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        jLabel6.setText("Student Name");

        txt_add_student_name.setBackground(new java.awt.Color(255, 204, 204));

        jLabel8.setText("Roll Number");

        txt_add_roll_number.setBackground(new java.awt.Color(255, 204, 204));

        btn_add_student.setText("Add Student");
        btn_add_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_studentActionPerformed(evt);
            }
        });

        tbl_view_students.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "Roll Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_view_students);
        if (tbl_view_students.getColumnModel().getColumnCount() > 0) {
            tbl_view_students.getColumnModel().getColumn(0).setResizable(false);
            tbl_view_students.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel12.setText("View Students Record");

        btn_view_students.setText("View Students");
        btn_view_students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_studentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(txt_add_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btn_add_branch)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_add_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_all_branches, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_add_roll_number, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_add_student)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(cmb_year, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(btn_view_students)
                                        .addGap(0, 0, 0))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(lbl_daily_data_entry_date)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_data_entry_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_daily_data_entry_date)
                    .addComponent(lbl_data_entry_date1)
                    .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(35, 35, 35)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_add_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_all_branches, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmb_year, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_view_students))
                        .addGap(26, 26, 26)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_add_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_add_roll_number, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addComponent(btn_add_student, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(lbl_daily_data_entry_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_data_entry_date1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_logged_user, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_add_branch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_add_branch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cmb_all_branches, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cmb_year, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_add_student_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_add_roll_number, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_add_student, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_view_students, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpan_daily_data_entry.addTab("Welcome on Students Admission", jDesktopPane1);

        jTabbedPane1.addTab("Data Entry", tabpan_daily_data_entry);

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
        jLabel4.setText("Mark Students Attendance");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel9.setText("Select Branch");

        cmb_mark_att_branch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_mark_att_branchItemStateChanged(evt);
            }
        });

        jLabel10.setText("Select Year");

        cmb_mark_att_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        tbl_mark_att_students_record.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "Roll Number", "Attendance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_mark_att_students_record.setColumnSelectionAllowed(true);
        tbl_mark_att_students_record.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_mark_att_students_record);
        tbl_mark_att_students_record.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btn_mark_att_save.setText("Save");
        btn_mark_att_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mark_att_saveActionPerformed(evt);
            }
        });

        jLabel11.setText("Date");

        lbl_mark_att_date.setText("jLabel12");

        btn_mark_att_get_record.setText("Get Record");
        btn_mark_att_get_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mark_att_get_recordActionPerformed(evt);
            }
        });

        btn_mark_att_toggle_all.setText("Toggle All");
        btn_mark_att_toggle_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mark_att_toggle_allActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10))
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_mark_att_date)
                    .addComponent(cmb_mark_att_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(cmb_mark_att_year, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_mark_att_get_record, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_mark_att_save, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_mark_att_toggle_all)))
                .addContainerGap(89, Short.MAX_VALUE))
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
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbl_mark_att_date))
                .addGap(36, 36, 36)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_mark_att_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(35, 35, 35)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_mark_att_year, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(btn_mark_att_get_record, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(btn_mark_att_save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mark_att_toggle_all))
                .addContainerGap(220, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(lbl_borrowers_city1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(548, Short.MAX_VALUE)))
        );
        jDesktopPane3.setLayer(lbl_borrowers_city1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cmb_mark_att_branch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cmb_mark_att_year, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btn_mark_att_save, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(lbl_mark_att_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btn_mark_att_get_record, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btn_mark_att_toggle_all, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_borrowers.addTab("Welcome on Students Attendance", jDesktopPane3);

        jTabbedPane1.addTab("Mark Attendance", tabpane_borrowers);

        jDesktopPane4.setBackground(new java.awt.Color(204, 204, 255));
        jDesktopPane4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDesktopPane4FocusGained(evt);
            }
        });
        jDesktopPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDesktopPane4MouseEntered(evt);
            }
        });

        lbl_borrowers_city2.setText("City:-");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("View Students Attendance");
        jLabel13.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel14.setText("Select Branch");

        cmb_view_att_branch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_view_att_branchItemStateChanged(evt);
            }
        });

        jLabel15.setText("Select Year");

        cmb_view_att_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        tbl_view_att_students_record.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "Roll Number", "Attendance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_view_att_students_record.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbl_view_att_students_record);
        tbl_view_att_students_record.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel16.setText("Date");

        lbl_view_att_date.setText("jLabel12");

        btn_view_att_get_record.setText("Get Record");
        btn_view_att_get_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_att_get_recordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15))
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_view_att_date)
                    .addComponent(cmb_view_att_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addComponent(cmb_view_att_year, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_view_att_get_record, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel13))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane4Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(lbl_borrowers_city2)
                    .addContainerGap(883, Short.MAX_VALUE)))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbl_view_att_date))
                .addGap(36, 36, 36)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_view_att_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(35, 35, 35)
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_view_att_year, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(btn_view_att_get_record, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(220, Short.MAX_VALUE))
            .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane4Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(lbl_borrowers_city2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(548, Short.MAX_VALUE)))
        );
        jDesktopPane4.setLayer(lbl_borrowers_city2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(cmb_view_att_branch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(cmb_view_att_year, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(lbl_view_att_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(btn_view_att_get_record, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_borrowers1.addTab("Welcome on View Students Attendance", jDesktopPane4);

        jTabbedPane1.addTab("View Attendance", tabpane_borrowers1);

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
        lbl_view_att_date.setText(date);
        
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
        
        /////////////////////////////////////////
        // view all branches
        String sql;
        sql = "select * from branch";
        conn = Connect.ConnectDB();
        try
        {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                do
                {
                    Object branch = rs.getString("branch_name");
                    if(((DefaultComboBoxModel)cmb_all_branches.getModel()).getIndexOf(branch.toString()) == -1 ) 
                    {
                        cmb_all_branches.addItem(branch.toString());
                    }
                    if(((DefaultComboBoxModel)cmb_mark_att_branch.getModel()).getIndexOf(branch.toString()) == -1 ) 
                    {
                        cmb_mark_att_branch.addItem(branch.toString());
                    }
                    if(((DefaultComboBoxModel)cmb_view_att_branch.getModel()).getIndexOf(branch.toString()) == -1 ) 
                    {
                        cmb_view_att_branch.addItem(branch.toString());
                    }
                    
                }while(rs.next());
            }
            
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Information.class.getName()).log(Level.SEVERE, null, ex);
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

    private void btn_add_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_branchActionPerformed
        // TODO add your handling code here:
        String branch = txt_add_branch.getText();
        
        if(branch.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Branch cannot be Empty");
            return;
        }
 
        String sql;
        sql = "Insert into branch (branch_name) values ('" +  branch  + "')";

        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Branch Added Successfully");
            txt_add_branch.setText("");
            if(((DefaultComboBoxModel)cmb_all_branches.getModel()).getIndexOf(branch) == -1 ) 
            {
                cmb_all_branches.addItem(branch);
            }
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_add_branchActionPerformed

    private void btn_add_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_studentActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        String branch = cmb_all_branches.getSelectedItem().toString();
        String year = cmb_year.getSelectedItem().toString();
        String student_name = txt_add_student_name.getText();
        String roll_number = txt_add_roll_number.getText();
        
        if(branch.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Branch cannot be Empty");
            return;
        }
 
        if(year.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Year cannot be Empty");
            return;
        }
 
        if(student_name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Student Name cannot be Empty");
            return;
        }
 
        if(roll_number.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Roll Number Name cannot be Empty");
            return;
        }
        
        String sql;
        sql = "Insert into students (student_name,roll_number,branch_name,year) values ('" +  student_name  + "','" +  roll_number  + "','" + branch + "','" +  year + "')";

        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Student Added Successfully");
            txt_add_student_name.setText("");
            txt_add_roll_number.setText("");

            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }      
    }//GEN-LAST:event_btn_add_studentActionPerformed

    private void btn_mark_att_get_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mark_att_get_recordActionPerformed
        // TODO add your handling code here:
        
        String branch = cmb_mark_att_branch.getSelectedItem().toString();
        String year = cmb_mark_att_year.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) tbl_mark_att_students_record.getModel();
        model.setRowCount(0);
              
        String sql;
        sql = "select * from students where branch_name='" + branch + "' and year='" + year + "'";
        conn = Connect.ConnectDB();
        try
        {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                do
                {
                    Object row[]={ rs.getString("student_name"), rs.getString("roll_number"), true};
                    model.addRow(row);
                }while(rs.next());
            }
            
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Information.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_btn_mark_att_get_recordActionPerformed

    private void btn_mark_att_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mark_att_saveActionPerformed
        // TODO add your handling code here:
        String branch = cmb_mark_att_branch.getSelectedItem().toString();
        String year = cmb_mark_att_year.getSelectedItem().toString();
        String date = lbl_mark_att_date.getText();
        
        DefaultTableModel model = (DefaultTableModel) tbl_mark_att_students_record.getModel();
        try
        {
            conn = Connect.ConnectDB();
            for (int count = 0; count < model.getRowCount(); count++)
            {
                String student_name = model.getValueAt(count, 0).toString();
                String roll_number = model.getValueAt(count, 1).toString();
                boolean attendance = (boolean) model.getValueAt(count, 2);
            
                String sql;
                sql = "Insert into attendance_record (date,branch_name,year,student_name,roll_number,attendance) values ('" + date  + "','" +  branch  + "','" + year + "','" +  student_name +  "','" +  roll_number +  "','" +  attendance +  "')";
                
                pst = conn.prepareStatement(sql);
                pst.executeUpdate();
            }
        
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_btn_mark_att_saveActionPerformed

    private void btn_view_studentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_studentsActionPerformed
        String branch = cmb_all_branches.getSelectedItem().toString();
        String year = cmb_year.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) tbl_view_students.getModel();
        model.setRowCount(0);
        String sql;
        sql = "select * from students where branch_name='" + branch + "' and year='" + year + "'";
        conn = Connect.ConnectDB();
        try
        {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                do
                {
                    Object row[]={ rs.getString("student_name"), rs.getString("roll_number"), true};
                    model.addRow(row);
                }while(rs.next());
            }
            
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Information.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_view_studentsActionPerformed
    static boolean toggle_value=true;
    private void btn_mark_att_toggle_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mark_att_toggle_allActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbl_mark_att_students_record.getModel();
        try
        {
            if(model.getRowCount()< 0)
                return;
            if(toggle_value == true)
                toggle_value=false;
            else if(toggle_value == false)
                 toggle_value = true;
            
            for (int count = 0; count < model.getRowCount(); count++)
            {
                model.setValueAt(toggle_value,count,2);
            }
        }
        catch(HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_btn_mark_att_toggle_allActionPerformed

    private void cmb_mark_att_branchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_mark_att_branchItemStateChanged
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_mark_att_students_record.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_cmb_mark_att_branchItemStateChanged

    private void cmb_view_att_branchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_view_att_branchItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_view_att_branchItemStateChanged

    private void btn_view_att_get_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_att_get_recordActionPerformed
        String branch = cmb_view_att_branch.getSelectedItem().toString();
        String year = cmb_view_att_year.getSelectedItem().toString();
        String date = lbl_view_att_date.getText();
        DefaultTableModel model = (DefaultTableModel) tbl_view_att_students_record.getModel();
        model.setRowCount(0);
        
        String sql;
        sql = "select * from attendance_record where date ='" + date  + "' and branch_name='" + branch + "' and year='" + year + "'";
        conn = Connect.ConnectDB();
        try
        {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                do
                {
                    boolean att=false;
                    
                    if(rs.getString("attendance").equals("true"))
                        att=true;
                    
                    
                    Object row[]={ rs.getString("student_name"), rs.getString("roll_number"),att};
                    model.addRow(row);
                }while(rs.next());
            }
            
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Information.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_view_att_get_recordActionPerformed

    private void jDesktopPane4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDesktopPane4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jDesktopPane4FocusGained

    private void jDesktopPane4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPane4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jDesktopPane4MouseEntered
  
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
    private javax.swing.JButton btn_add_branch;
    private javax.swing.JButton btn_add_student;
    private javax.swing.JButton btn_mark_att_get_record;
    private javax.swing.JButton btn_mark_att_save;
    private javax.swing.JButton btn_mark_att_toggle_all;
    private javax.swing.JButton btn_view_att_get_record;
    private javax.swing.JButton btn_view_students;
    private javax.swing.JComboBox cmb_all_branches;
    private javax.swing.JComboBox cmb_mark_att_branch;
    private javax.swing.JComboBox cmb_mark_att_year;
    private javax.swing.JComboBox cmb_view_att_branch;
    private javax.swing.JComboBox cmb_view_att_year;
    private javax.swing.JComboBox cmb_year;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JLabel lbl_borrowers_city2;
    private javax.swing.JLabel lbl_daily_data_entry_date;
    private javax.swing.JLabel lbl_daily_data_entry_logged_user;
    private javax.swing.JLabel lbl_daily_data_entry_user_name;
    private javax.swing.JLabel lbl_data_entry_date1;
    private javax.swing.JLabel lbl_mark_att_date;
    private javax.swing.JLabel lbl_view_att_date;
    private javax.swing.JTabbedPane tabpan_daily_data_entry;
    private javax.swing.JTabbedPane tabpane_borrowers;
    private javax.swing.JTabbedPane tabpane_borrowers1;
    private javax.swing.JTabbedPane tabpane_user_account;
    private javax.swing.JTable tbl_mark_att_students_record;
    private javax.swing.JTable tbl_view_att_students_record;
    private javax.swing.JTable tbl_view_students;
    private javax.swing.JTextField txt1_user_account_user_name;
    private javax.swing.JPasswordField txt2_user_account_password;
    private javax.swing.JTextField txt_add_branch;
    private javax.swing.JTextField txt_add_roll_number;
    private javax.swing.JTextField txt_add_student_name;
    // End of variables declaration//GEN-END:variables
}
