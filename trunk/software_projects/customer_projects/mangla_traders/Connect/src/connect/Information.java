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
        lbl_daily_data_entry_firm_name = new javax.swing.JLabel();
        lbl_daily_data_entry_credit = new javax.swing.JLabel();
        lbl_daily_data_entry_debit = new javax.swing.JLabel();
        lbl_daily_data_entry_comment = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_daily_data_entry_comment = new javax.swing.JTextArea();
        txt_daily_data_entry_firm_name = new javax.swing.JTextField();
        txt_daily_data_entry_credit = new javax.swing.JTextField();
        txt_daily_data_entry_debit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_daily_data_entry = new javax.swing.JTable();
        btn_daily_data_entry_save = new javax.swing.JButton();
        lbl_data_entry_date1 = new javax.swing.JLabel();
        lbl_daily_data_entry_user_name = new javax.swing.JLabel();
        lbl_daily_data_entry_logged_user = new javax.swing.JLabel();
        tabpane_borrowers = new javax.swing.JTabbedPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        lbl_borrowers_city = new javax.swing.JLabel();
        btn_borrowers_add_new_firm = new javax.swing.JButton();
        lbl_borrowers_city1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_borrowers_borrower_name = new javax.swing.JTable();
        combobox_borrowers_city = new javax.swing.JComboBox();
        tabpane_creditors = new javax.swing.JTabbedPane();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        lbl_creditor_city = new javax.swing.JLabel();
        btn_creditor_add_new_firm = new javax.swing.JButton();
        combobox_creditors_city = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_creditor_firm_name = new javax.swing.JTable();
        tabpane_search_option = new javax.swing.JTabbedPane();
        lbl_search_option_firm_date1 = new javax.swing.JDesktopPane();
        jLabel9 = new javax.swing.JLabel();
        lbl_search_option_firm_name1 = new javax.swing.JLabel();
        lbl_search_option_firm_date = new javax.swing.JLabel();
        lbl_search_option_date = new javax.swing.JLabel();
        cmb_search_option_firm_name = new javax.swing.JComboBox();
        spin_search_dd = new javax.swing.JSpinner();
        spin_search_mm = new javax.swing.JSpinner();
        spin_search_yyyy = new javax.swing.JSpinner();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl_search_option = new javax.swing.JTable();
        btn_search_option_enter = new javax.swing.JButton();
        tabpane_user_account = new javax.swing.JTabbedPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        lbl1_user_account = new javax.swing.JLabel();
        lbl2_user_account = new javax.swing.JLabel();
        txt1_user_account_user_name = new javax.swing.JTextField();
        btn1_user_account_add = new javax.swing.JButton();
        btn2_user_account_delete = new javax.swing.JButton();
        txt2_user_account_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

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

        lbl_daily_data_entry_firm_name.setText("Firm Name");

        lbl_daily_data_entry_credit.setText("Credit");

        lbl_daily_data_entry_debit.setText("Debit");

        lbl_daily_data_entry_comment.setText("Comment");

        txtarea_daily_data_entry_comment.setBackground(new java.awt.Color(255, 204, 204));
        txtarea_daily_data_entry_comment.setColumns(20);
        txtarea_daily_data_entry_comment.setLineWrap(true);
        txtarea_daily_data_entry_comment.setRows(5);
        jScrollPane2.setViewportView(txtarea_daily_data_entry_comment);

        txt_daily_data_entry_firm_name.setBackground(new java.awt.Color(255, 204, 204));
        txt_daily_data_entry_firm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_daily_data_entry_firm_nameActionPerformed(evt);
            }
        });

        txt_daily_data_entry_credit.setBackground(new java.awt.Color(255, 204, 204));
        txt_daily_data_entry_credit.setToolTipText("");

        txt_daily_data_entry_debit.setBackground(new java.awt.Color(255, 204, 204));

        table_daily_data_entry.setBackground(new java.awt.Color(153, 204, 255));
        table_daily_data_entry.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table_daily_data_entry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Firm Name", "Credit", "Debit", "Comment"
            }
        ));
        table_daily_data_entry.setGridColor(new java.awt.Color(153, 204, 255));
        table_daily_data_entry.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jScrollPane1.setViewportView(table_daily_data_entry);

        btn_daily_data_entry_save.setText("Save");
        btn_daily_data_entry_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daily_data_entry_saveActionPerformed(evt);
            }
        });

        lbl_data_entry_date1.setText("jLabel7");

        lbl_daily_data_entry_logged_user.setText("Logged User :");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_daily_data_entry_date)
                .addGap(40, 40, 40)
                .addComponent(lbl_data_entry_date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(201, 201, 201)
                .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_daily_data_entry_comment)
                    .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(227, 227, 227))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_daily_data_entry_firm_name)
                            .addComponent(txt_daily_data_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_daily_data_entry_credit)
                            .addComponent(txt_daily_data_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_daily_data_entry_debit)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(txt_daily_data_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_daily_data_entry_save, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_daily_data_entry_date)
                                    .addComponent(lbl_data_entry_date1)))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(45, 45, 45)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_daily_data_entry_firm_name)
                            .addComponent(lbl_daily_data_entry_credit)
                            .addComponent(lbl_daily_data_entry_debit))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_daily_data_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daily_data_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daily_data_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lbl_daily_data_entry_comment)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(btn_daily_data_entry_save)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(lbl_daily_data_entry_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_credit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_debit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_comment, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_credit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_debit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_daily_data_entry_save, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_data_entry_date1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_logged_user, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpan_daily_data_entry.addTab("Welcome on Daily Data Entry", jDesktopPane1);

        jTabbedPane1.addTab("Daily Data Entry", tabpan_daily_data_entry);

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

        lbl_borrowers_city.setText("City:-");

        btn_borrowers_add_new_firm.setText("Add New Firm");
        btn_borrowers_add_new_firm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrowers_add_new_firmActionPerformed(evt);
            }
        });

        lbl_borrowers_city1.setText("City:-");

        tbl_borrowers_borrower_name.setBackground(new java.awt.Color(204, 204, 255));
        tbl_borrowers_borrower_name.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Firm Name"
            }
        ));
        tbl_borrowers_borrower_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_borrowers_borrower_nameMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_borrowers_borrower_name);

        combobox_borrowers_city.setBackground(new java.awt.Color(204, 204, 255));
        combobox_borrowers_city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL" }));
        combobox_borrowers_city.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_borrowers_cityItemStateChanged(evt);
            }
        });
        combobox_borrowers_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_borrowers_cityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lbl_borrowers_city)
                .addGap(28, 28, 28)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_borrowers_add_new_firm, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(combobox_borrowers_city, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(490, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(lbl_borrowers_city1)
                    .addContainerGap(883, Short.MAX_VALUE)))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_borrowers_city)
                            .addComponent(combobox_borrowers_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(btn_borrowers_add_new_firm)))
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(lbl_borrowers_city1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(548, Short.MAX_VALUE)))
        );
        jDesktopPane3.setLayer(lbl_borrowers_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btn_borrowers_add_new_firm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(lbl_borrowers_city1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(combobox_borrowers_city, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_borrowers.addTab("Welcome on Borrowers", jDesktopPane3);

        jTabbedPane1.addTab("Borrowers", tabpane_borrowers);

        jDesktopPane4.setBackground(new java.awt.Color(204, 204, 255));

        lbl_creditor_city.setText("City:-");

        btn_creditor_add_new_firm.setText("Add New Firm");
        btn_creditor_add_new_firm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creditor_add_new_firmActionPerformed(evt);
            }
        });

        combobox_creditors_city.setBackground(new java.awt.Color(204, 204, 255));
        combobox_creditors_city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL" }));
        combobox_creditors_city.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_creditors_cityItemStateChanged(evt);
            }
        });
        combobox_creditors_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_creditors_cityActionPerformed(evt);
            }
        });

        tbl_creditor_firm_name.setBackground(new java.awt.Color(204, 204, 255));
        tbl_creditor_firm_name.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Firm Name"
            }
        ));
        tbl_creditor_firm_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_creditor_firm_nameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_creditor_firm_nameMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_creditor_firm_name);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(lbl_creditor_city)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_creditor_add_new_firm, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(combobox_creditors_city, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(488, Short.MAX_VALUE))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_creditor_city)
                            .addComponent(combobox_creditors_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(btn_creditor_add_new_firm))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jDesktopPane4.setLayer(lbl_creditor_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(btn_creditor_add_new_firm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(combobox_creditors_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_creditors.addTab("Welcome on Creditors", jDesktopPane4);

        jTabbedPane1.addTab("Creditors", tabpane_creditors);

        tabpane_search_option.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabpane_search_optionFocusGained(evt);
            }
        });

        lbl_search_option_firm_date1.setBackground(new java.awt.Color(204, 204, 255));

        lbl_search_option_firm_name1.setText("Firm Name");

        lbl_search_option_firm_date.setText("Date:-");

        lbl_search_option_date.setText("dd-mm-yyyy");

        cmb_search_option_firm_name.setBackground(new java.awt.Color(204, 204, 255));
        cmb_search_option_firm_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        cmb_search_option_firm_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_search_option_firm_nameItemStateChanged(evt);
            }
        });

        spin_search_dd.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        spin_search_mm.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spin_search_yyyy.setModel(new javax.swing.SpinnerNumberModel(2015, 2015, 2030, 1));

        tbl_search_option.setBackground(new java.awt.Color(204, 204, 255));
        tbl_search_option.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_No", "Name", "Credit", "Debit", "Comment"
            }
        ));
        jScrollPane10.setViewportView(tbl_search_option);

        btn_search_option_enter.setText("Search");
        btn_search_option_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_option_enterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbl_search_option_firm_date1Layout = new javax.swing.GroupLayout(lbl_search_option_firm_date1);
        lbl_search_option_firm_date1.setLayout(lbl_search_option_firm_date1Layout);
        lbl_search_option_firm_date1Layout.setHorizontalGroup(
            lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel9))
                    .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane10)
                            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                                .addComponent(lbl_search_option_firm_name1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_search_option_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_search_option_firm_date)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_search_option_date, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spin_search_dd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spin_search_mm, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spin_search_yyyy, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btn_search_option_enter)))))
                .addGap(0, 339, Short.MAX_VALUE))
        );
        lbl_search_option_firm_date1Layout.setVerticalGroup(
            lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_search_option_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spin_search_dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spin_search_mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spin_search_yyyy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_search_option_enter))
                    .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_search_option_firm_name1)
                        .addComponent(lbl_search_option_firm_date)
                        .addComponent(cmb_search_option_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        lbl_search_option_firm_date1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_name1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(cmb_search_option_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(spin_search_dd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(spin_search_mm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(spin_search_yyyy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(jScrollPane10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(btn_search_option_enter, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_search_option.addTab("Welcome on Search Option", lbl_search_option_firm_date1);

        jTabbedPane1.addTab("Search Option", tabpane_search_option);

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

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(btn1_user_account_add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn2_user_account_delete)
                        .addGap(57, 57, 57))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl1_user_account)
                            .addComponent(lbl2_user_account)
                            .addComponent(jLabel1))
                        .addGap(116, 116, 116)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(txt2_user_account_password))))
                .addContainerGap(468, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1_user_account)
                    .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2_user_account)
                    .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1_user_account_add)
                    .addComponent(btn2_user_account_delete))
                .addContainerGap(553, Short.MAX_VALUE))
        );
        jDesktopPane2.setLayer(lbl1_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbl2_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt1_user_account_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn1_user_account_add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn2_user_account_delete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt2_user_account_password, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
    int data_entry_count=0;
    private void btn_daily_data_entry_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daily_data_entry_saveActionPerformed
        String firm_name = txt_daily_data_entry_firm_name.getText();
        String credit  = txt_daily_data_entry_credit.getText();
        String debit = txt_daily_data_entry_debit.getText();
        String comment = txtarea_daily_data_entry_comment.getText();
        if(firm_name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Firm Name Cannot be Empty"); 
            return;
        }

        try 
        {
            // if is number
            if(!credit.equals(""))
            {
                Float.parseFloat(credit);
            }
        } 
        catch (NumberFormatException e) 
        {
            // else then do blah
            JOptionPane.showMessageDialog(null, "Credit Should be Number only"); 
            return;
        }
        
         try 
        {
            // if is number
            if(!debit.equals(""))
            {
                Float.parseFloat(debit);
            }
        } 
        catch (NumberFormatException e) 
        {
            // else then do blah
            JOptionPane.showMessageDialog(null, "Debit Should be Number only"); 
            return;
        }

        Object row[]={data_entry_count, firm_name, credit, debit, comment};
        data_entry_count = data_entry_count + 1;
        table_daily_data_entry.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_daily_data_entry.getColumnModel().getColumn(0).setPreferredWidth(40);
        table_daily_data_entry.getColumnModel().getColumn(1).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(4).setPreferredWidth(600);
        
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        lbl_data_entry_date1.setText(date);
        String log = ConnectGUI.logged_user;
        
        String sql;
        sql = "Insert into table_daily_data_entry (firm_name,credit,debit,comment,date,logged_user) values ('" +  firm_name + "','" + credit + "','" + debit + "','" + comment + "','" + date + "','"+ log +"')";
            
        try
        {
           conn = Connect.ConnectDB();
           pst = conn.prepareStatement(sql);
           pst.executeUpdate();
        
           //JOptionPane.showMessageDialog(null, "saved");
           txt_daily_data_entry_firm_name.setText("");
           txt_daily_data_entry_credit.setText("");
           txt_daily_data_entry_debit.setText("");
           txtarea_daily_data_entry_comment.setText("");
           conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
          JOptionPane.showMessageDialog(null, e);          
        }
        
        DefaultTableModel model = (DefaultTableModel) table_daily_data_entry.getModel();
        model.addRow(row);
    }//GEN-LAST:event_btn_daily_data_entry_saveActionPerformed

    private void txt_daily_data_entry_firm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_daily_data_entry_firm_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_daily_data_entry_firm_nameActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

        tbl_borrowers_borrower_name.removeAll();

        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        lbl_data_entry_date1.setText(date);
        
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
        sql = "SELECT * FROM table_daily_data_entry where date ='" +date+ "'";
            
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                int count=1;
                do
                {
                    Object row[]={count,  rs.getString("firm_name"), rs.getString("credit"), rs.getString("debit"), rs.getString("comment")};
                    table_daily_data_entry.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    table_daily_data_entry.getColumnModel().getColumn(0).setPreferredWidth(40);
                    table_daily_data_entry.getColumnModel().getColumn(1).setPreferredWidth(100);
                    table_daily_data_entry.getColumnModel().getColumn(2).setPreferredWidth(100);
                    table_daily_data_entry.getColumnModel().getColumn(3).setPreferredWidth(100);
                    table_daily_data_entry.getColumnModel().getColumn(4).setPreferredWidth(600);
                    DefaultTableModel model = (DefaultTableModel) table_daily_data_entry.getModel();
                    model.addRow(row);
                    count++;
                }while(rs.next());
                data_entry_count = count;
            }
        
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }
        /////////////////////////////////////////////////////
        //Following section for borrowers tab
      
        sql = "SELECT * FROM firm_account WHERE user_type='b'";
        DefaultTableModel tbl = (DefaultTableModel) tbl_borrowers_borrower_name.getModel();
        tbl.setRowCount(0);
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                int count=1;
                do
                {
                    Object row[]={ rs.getString("firm_name")};
                    DefaultTableModel model = (DefaultTableModel) tbl_borrowers_borrower_name.getModel();
                    model.addRow(row);
                    Object item[]={ rs.getString("city")};
                    if(((DefaultComboBoxModel)combobox_borrowers_city.getModel()).getIndexOf(item[0].toString()) == -1 ) 
                    {
                        combobox_borrowers_city.addItem(item[0].toString());
                    }
                    count++;
                }while(rs.next());
           }
           conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }
        //////////////////////////////////////////////////
        //This Section for creditor tab      
          
        sql = "SELECT * FROM firm_account WHERE user_type='c'";
        DefaultTableModel tbl_c = (DefaultTableModel) tbl_creditor_firm_name.getModel();
        tbl_c.setRowCount(0);
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                int count=1;
                do
                {
                    Object row[]={ rs.getString("firm_name")};
                    DefaultTableModel model = (DefaultTableModel) tbl_creditor_firm_name.getModel();
                    model.addRow(row);
                    Object item[]={ rs.getString("city")};
                    if(((DefaultComboBoxModel)combobox_creditors_city.getModel()).getIndexOf(item[0].toString()) == -1 ) 
                    {
                        combobox_creditors_city.addItem(item[0].toString());
                    }
                }while(rs.next());
            }
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }
      
        /////////////////////////////////////////
        // for Search option firm name
      
        tbl_search_option.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl_search_option.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_search_option.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl_search_option.getColumnModel().getColumn(2).setPreferredWidth(130);
        tbl_search_option.getColumnModel().getColumn(3).setPreferredWidth(130);
        tbl_search_option.getColumnModel().getColumn(4).setPreferredWidth(200);
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        spin_search_dd.setValue(day);
        spin_search_mm.setValue(month);
        spin_search_yyyy.setValue(year);
        sql = "SELECT * FROM firm_account";
            
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                do
                {
                    Object row[]={ rs.getString("firm_name")};
                    if(((DefaultComboBoxModel)cmb_search_option_firm_name.getModel()).getIndexOf(row[0].toString()) == -1 ) 
                    {
                        cmb_search_option_firm_name.addItem(row[0].toString());
                    }
                }while(rs.next());
            }
           conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void txt1_user_account_user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1_user_account_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1_user_account_user_nameActionPerformed
    
    private void btn_borrowers_add_new_firmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrowers_add_new_firmActionPerformed
        user_type = "b";
        this.setVisible(false);
        new FirmAccount1().setVisible(true);
    }//GEN-LAST:event_btn_borrowers_add_new_firmActionPerformed
    
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

    
    private void btn_creditor_add_new_firmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creditor_add_new_firmActionPerformed
        user_type="c";
        this.setVisible(false);
        new FirmAccount1().setVisible(true);
    }//GEN-LAST:event_btn_creditor_add_new_firmActionPerformed

    String anyname = "";
 
    private void btn_search_option_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_option_enterActionPerformed
        String dd="";
        String mon;
        mon = "";
        if(Integer.parseInt(spin_search_dd.getValue().toString()) < 10 )
        {
            dd="0";
        }
        if(Integer.parseInt(spin_search_mm.getValue().toString()) < 10 )
        {
            mon="0";
        }
        
        String anydate= dd + spin_search_dd.getValue().toString() + "-" + mon + spin_search_mm.getValue().toString() + "-" + spin_search_yyyy.getValue().toString();

        if( !anydate.equals("") )
        {
            DefaultTableModel model = (DefaultTableModel) tbl_search_option.getModel();
            model.setRowCount(0);
           
            String sql;
            sql = "SELECT * FROM table_daily_data_entry where date ='" +anydate+ "'";
            
            try
            {
                conn = Connect.ConnectDB();
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())
                {  
                    int count=1;
                    do
                    {
                        Object row[]={count,  rs.getString("firm_name"), rs.getString("credit"), rs.getString("debit"), rs.getString("comment")};
                        model.addRow(row);
                        count++;
                    }
                    while(rs.next());
                } 
                conn.close();
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);          
            }
        }
        else
        {
            System.out.println("Please enter valid entry");    
    }//GEN-LAST:event_btn_search_option_enterActionPerformed
    }
    private void jDesktopPane3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDesktopPane3FocusGained
        // TODO add your handling code here 
    }//GEN-LAST:event_jDesktopPane3FocusGained
    static int showFirmAccount=0;
    static String firm_name_temp= "";

    private void tbl_borrowers_borrower_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_borrowers_borrower_nameMouseClicked
        int row = tbl_borrowers_borrower_name.getSelectedRow();
        String firm_name =(String) tbl_borrowers_borrower_name.getValueAt(row, 0);
        String sql = "SELECT * FROM firm_account WHERE firm_name='" + firm_name + "'";
            
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                showFirmAccount=1;
                firm_name_temp = firm_name;
                this.setVisible(false);
                new FirmAccount1().setVisible(true);
            }        
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }       
    }//GEN-LAST:event_tbl_borrowers_borrower_nameMouseClicked

    private void jDesktopPane3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPane3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jDesktopPane3MouseEntered
   
    private void tbl_creditor_firm_nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_creditor_firm_nameMouseEntered
        // TODO add your handling code here:      
    }//GEN-LAST:event_tbl_creditor_firm_nameMouseEntered
    static int showFirmAccountCreditor=0;
    static String firm_name_temp_creditor= "";
    private void tbl_creditor_firm_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_creditor_firm_nameMouseClicked
        int row = tbl_creditor_firm_name.getSelectedRow();
        String firm_name =(String) tbl_creditor_firm_name.getValueAt(row, 0);
        String sql = "SELECT * FROM firm_account WHERE firm_name='" + firm_name + "'";
            
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                showFirmAccountCreditor=1;
                firm_name_temp_creditor = firm_name;
                this.setVisible(false);
                new FirmAccount1().setVisible(true);
            }
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }      
    }//GEN-LAST:event_tbl_creditor_firm_nameMouseClicked

    private void combobox_creditors_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_creditors_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_creditors_cityActionPerformed

    private void combobox_borrowers_cityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_borrowers_cityItemStateChanged
        Object city = combobox_borrowers_city.getSelectedItem();
        String sql="";
        if(city.equals("ALL"))
        {
            sql = "SELECT * FROM firm_account WHERE user_type='b'";
        }
        else
        {
            sql = "SELECT * FROM firm_account WHERE city='" + city + "' and user_type='b'";
        }
        
            
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                DefaultTableModel tbl = (DefaultTableModel) tbl_borrowers_borrower_name.getModel();
                tbl.setRowCount(0); 
                do
                {
                    Object row[]={ rs.getString("firm_name")};
     
                    DefaultTableModel model = (DefaultTableModel) tbl_borrowers_borrower_name.getModel();
                    model.addRow(row);
                }while(rs.next());
            }
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }
    }//GEN-LAST:event_combobox_borrowers_cityItemStateChanged

    private void combobox_creditors_cityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_creditors_cityItemStateChanged
        Object city = combobox_creditors_city.getSelectedItem();
        String sql="";
        if(city.equals("ALL"))
        {
            sql = "SELECT * FROM firm_account WHERE user_type='c'";
        }
        else
        {
            sql = "SELECT * FROM firm_account WHERE city='" + city + "' and user_type='c'";
        }
    
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                DefaultTableModel tbl = (DefaultTableModel) tbl_creditor_firm_name.getModel();
                tbl.setRowCount(0);
                do
                {
                    Object row[]={ rs.getString("firm_name")};
                    DefaultTableModel model = (DefaultTableModel) tbl_creditor_firm_name.getModel();
                    model.addRow(row);
                }while(rs.next());
            }
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }       
    }//GEN-LAST:event_combobox_creditors_cityItemStateChanged

    private void combobox_borrowers_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_borrowers_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_borrowers_cityActionPerformed

    private void cal_search_option_dateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cal_search_option_dateInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cal_search_option_dateInputMethodTextChanged

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void tabpane_search_optionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabpane_search_optionFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tabpane_search_optionFocusGained

    private void cmb_search_option_firm_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_search_option_firm_nameItemStateChanged
        String   firm_name = cmb_search_option_firm_name.getSelectedItem().toString();
        if ( !firm_name.equals("") )
        {   
            DefaultTableModel model = (DefaultTableModel) tbl_search_option.getModel();
            model.setRowCount(0);
            String sql;
            sql = "SELECT * FROM table_daily_data_entry where firm_name ='" +firm_name+ "'";            
            try
            {
                conn = Connect.ConnectDB();
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())
                {       
                    int count=1;
                    do
                    {
                        Object row[]={count,  rs.getString("firm_name"), rs.getString("credit"), rs.getString("debit"), rs.getString("comment")};
                        model.addRow(row);
                        count++;
                    }while(rs.next());
                }    
                conn.close();
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);          
            }
        }
    }//GEN-LAST:event_cmb_search_option_firm_nameItemStateChanged
  
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
    private javax.swing.JButton btn_borrowers_add_new_firm;
    private javax.swing.JButton btn_creditor_add_new_firm;
    private javax.swing.JButton btn_daily_data_entry_save;
    private javax.swing.JButton btn_search_option_enter;
    private javax.swing.JComboBox cmb_search_option_firm_name;
    private javax.swing.JComboBox combobox_borrowers_city;
    private javax.swing.JComboBox combobox_creditors_city;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
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
    private javax.swing.JLabel lbl_borrowers_city;
    private javax.swing.JLabel lbl_borrowers_city1;
    private javax.swing.JLabel lbl_creditor_city;
    private javax.swing.JLabel lbl_daily_data_entry_comment;
    private javax.swing.JLabel lbl_daily_data_entry_credit;
    private javax.swing.JLabel lbl_daily_data_entry_date;
    private javax.swing.JLabel lbl_daily_data_entry_debit;
    private javax.swing.JLabel lbl_daily_data_entry_firm_name;
    private javax.swing.JLabel lbl_daily_data_entry_logged_user;
    private javax.swing.JLabel lbl_daily_data_entry_user_name;
    private javax.swing.JLabel lbl_data_entry_date1;
    private javax.swing.JLabel lbl_search_option_date;
    private javax.swing.JLabel lbl_search_option_firm_date;
    private javax.swing.JDesktopPane lbl_search_option_firm_date1;
    private javax.swing.JLabel lbl_search_option_firm_name1;
    private javax.swing.JSpinner spin_search_dd;
    private javax.swing.JSpinner spin_search_mm;
    private javax.swing.JSpinner spin_search_yyyy;
    private javax.swing.JTable table_daily_data_entry;
    private javax.swing.JTabbedPane tabpan_daily_data_entry;
    private javax.swing.JTabbedPane tabpane_borrowers;
    private javax.swing.JTabbedPane tabpane_creditors;
    private javax.swing.JTabbedPane tabpane_search_option;
    private javax.swing.JTabbedPane tabpane_user_account;
    private javax.swing.JTable tbl_borrowers_borrower_name;
    private javax.swing.JTable tbl_creditor_firm_name;
    private javax.swing.JTable tbl_search_option;
    private javax.swing.JTextField txt1_user_account_user_name;
    private javax.swing.JPasswordField txt2_user_account_password;
    private javax.swing.JTextField txt_daily_data_entry_credit;
    private javax.swing.JTextField txt_daily_data_entry_debit;
    private javax.swing.JTextField txt_daily_data_entry_firm_name;
    private javax.swing.JTextArea txtarea_daily_data_entry_comment;
    // End of variables declaration//GEN-END:variables
}
