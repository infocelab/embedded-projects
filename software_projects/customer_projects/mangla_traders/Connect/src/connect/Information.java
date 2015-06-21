
package connect;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JTable;

//import java.util.Calendar;

/**
 *
 * @author celab-amit
 */
public class Information extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    static String user_type;
    
    
    public Information() 
    {
        initComponents();
        lbl_data_entry_welcome.setText("---------------- MANGLA TRADERS ---------------");
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
        lbl_data_entry_welcome = new javax.swing.JLabel();
        lbl_daily_data_entry_user_name = new javax.swing.JLabel();
        lbl_daily_data_entry_logged_user = new javax.swing.JLabel();
        tabpane_borrowers = new javax.swing.JTabbedPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        lbl_borrowers_city = new javax.swing.JLabel();
        btn_borrowers_add_new_firm = new javax.swing.JButton();
        combobox_borrowers_city = new javax.swing.JComboBox();
        lbl_borrowers_city1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_borrowers_borrower_name = new javax.swing.JTable();
        tabpane_creditors = new javax.swing.JTabbedPane();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        lbl_creditor_city = new javax.swing.JLabel();
        btn_creditor_add_new_firm = new javax.swing.JButton();
        combobox_creditors_city = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_creditor_firm_name = new javax.swing.JList();
        lbl_borrowers_creditor_name = new javax.swing.JLabel();
        tabpane_search_option = new javax.swing.JTabbedPane();
        lbl_search_option_firm_date1 = new javax.swing.JDesktopPane();
        txt_search_option_firm_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl_search_option_firm_date2 = new javax.swing.JDesktopPane();
        jLabel10 = new javax.swing.JLabel();
        btn_search_option_enter = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl_search_option = new javax.swing.JTable();
        lbl_search_option_firm_name1 = new javax.swing.JLabel();
        lbl_search_option_firm_date = new javax.swing.JLabel();
        txt_search_option_date = new javax.swing.JTextField();
        lbl_search_option_date = new javax.swing.JLabel();
        tabpane_user_account = new javax.swing.JTabbedPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        lbl1_user_account = new javax.swing.JLabel();
        lbl2_user_account = new javax.swing.JLabel();
        txt1_user_account_user_name = new javax.swing.JTextField();
        txt2_user_account_password = new javax.swing.JTextField();
        btn1_user_account_add = new javax.swing.JButton();
        btn2_user_account_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jDesktopPane1.setBackground(java.awt.SystemColor.controlHighlight);

        lbl_daily_data_entry_date.setText("Date:");

        lbl_daily_data_entry_firm_name.setText("Firm Name");

        lbl_daily_data_entry_credit.setText("Credit");

        lbl_daily_data_entry_debit.setText("Debit");

        lbl_daily_data_entry_comment.setText("Comment");

        txtarea_daily_data_entry_comment.setColumns(20);
        txtarea_daily_data_entry_comment.setRows(5);
        jScrollPane2.setViewportView(txtarea_daily_data_entry_comment);

        txt_daily_data_entry_firm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_daily_data_entry_firm_nameActionPerformed(evt);
            }
        });

        table_daily_data_entry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Firm Name", "Credit", "Debit", "Comment"
            }
        ));
        jScrollPane1.setViewportView(table_daily_data_entry);

        btn_daily_data_entry_save.setText("Save");
        btn_daily_data_entry_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daily_data_entry_saveActionPerformed(evt);
            }
        });

        lbl_data_entry_date1.setText("jLabel7");

        lbl_data_entry_welcome.setText("jLabel1");

        lbl_daily_data_entry_logged_user.setText("Logged User :");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lbl_daily_data_entry_date)
                                .addGap(40, 40, 40)
                                .addComponent(lbl_data_entry_date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_data_entry_welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_daily_data_entry_firm_name)
                            .addComponent(txt_daily_data_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_daily_data_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_daily_data_entry_credit))
                        .addGap(30, 30, 30)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_daily_data_entry_debit)
                            .addComponent(txt_daily_data_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_daily_data_entry_comment)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addComponent(btn_daily_data_entry_save, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(361, 361, 361))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_daily_data_entry_date)
                            .addComponent(lbl_data_entry_date1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_data_entry_welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
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
                        .addGap(6, 6, 6)
                        .addComponent(lbl_daily_data_entry_comment)
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_daily_data_entry_save)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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
        jDesktopPane1.setLayer(lbl_data_entry_welcome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_logged_user, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpan_daily_data_entry.addTab("Welcome on Daily Data Entry", jDesktopPane1);

        jTabbedPane1.addTab("Daily Data Entry", tabpan_daily_data_entry);

        jDesktopPane3.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDesktopPane3FocusGained(evt);
            }
        });

        lbl_borrowers_city.setText("City:-");

        btn_borrowers_add_new_firm.setText("Add New Firm");
        btn_borrowers_add_new_firm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrowers_add_new_firmActionPerformed(evt);
            }
        });

        combobox_borrowers_city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "City 1", "City 2", "City 3", "City 4" }));
        combobox_borrowers_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_borrowers_cityActionPerformed(evt);
            }
        });

        lbl_borrowers_city1.setText("City:-");

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

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(lbl_borrowers_city)
                        .addGap(95, 95, 95)
                        .addComponent(combobox_borrowers_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btn_borrowers_add_new_firm)))
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(lbl_borrowers_city1)
                    .addContainerGap(689, Short.MAX_VALUE)))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_borrowers_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_borrowers_city))
                        .addGap(59, 59, 59)
                        .addComponent(btn_borrowers_add_new_firm))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(lbl_borrowers_city1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(248, Short.MAX_VALUE)))
        );
        jDesktopPane3.setLayer(lbl_borrowers_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btn_borrowers_add_new_firm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(combobox_borrowers_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(lbl_borrowers_city1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_borrowers.addTab("Welcome on Borroers", jDesktopPane3);

        jTabbedPane1.addTab("Borrowers", tabpane_borrowers);

        jDesktopPane4.setBackground(new java.awt.Color(240, 240, 240));

        lbl_creditor_city.setText("City:-");

        btn_creditor_add_new_firm.setText("Add New Firm");
        btn_creditor_add_new_firm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creditor_add_new_firmActionPerformed(evt);
            }
        });

        combobox_creditors_city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "City 1", "City 2", "City 3", "City 4" }));

        jScrollPane3.setViewportView(list_creditor_firm_name);

        lbl_borrowers_creditor_name.setText("Creditor Name:");

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(btn_creditor_add_new_firm))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                                .addComponent(lbl_creditor_city)
                                .addGap(29, 29, 29)
                                .addComponent(combobox_creditors_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_borrowers_creditor_name, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btn_creditor_add_new_firm))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_borrowers_creditor_name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobox_creditors_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_creditor_city))
                .addGap(174, 174, 174))
        );
        jDesktopPane4.setLayer(lbl_creditor_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(btn_creditor_add_new_firm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(combobox_creditors_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(lbl_borrowers_creditor_name, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_creditors.addTab("Welcome on Creditors", jDesktopPane4);

        jTabbedPane1.addTab("Creditors", tabpane_creditors);

        lbl_search_option_firm_date1.setBackground(new java.awt.Color(240, 240, 240));

        lbl_search_option_firm_date2.setBackground(new java.awt.Color(240, 240, 240));

        btn_search_option_enter.setText("Search");
        btn_search_option_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_option_enterActionPerformed(evt);
            }
        });

        tbl_search_option.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_No", "Name", "Credit", "Debit", "Comment"
            }
        ));
        jScrollPane10.setViewportView(tbl_search_option);

        javax.swing.GroupLayout lbl_search_option_firm_date2Layout = new javax.swing.GroupLayout(lbl_search_option_firm_date2);
        lbl_search_option_firm_date2.setLayout(lbl_search_option_firm_date2Layout);
        lbl_search_option_firm_date2Layout.setHorizontalGroup(
            lbl_search_option_firm_date2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date2Layout.createSequentialGroup()
                .addGroup(lbl_search_option_firm_date2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_search_option_firm_date2Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(btn_search_option_enter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(lbl_search_option_firm_date2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(717, Short.MAX_VALUE))
        );
        lbl_search_option_firm_date2Layout.setVerticalGroup(
            lbl_search_option_firm_date2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date2Layout.createSequentialGroup()
                .addGroup(lbl_search_option_firm_date2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_search_option_firm_date2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel10))
                    .addGroup(lbl_search_option_firm_date2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btn_search_option_enter)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        lbl_search_option_firm_date2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date2.setLayer(btn_search_option_enter, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date2.setLayer(jScrollPane10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_search_option_firm_name1.setText("Firm Name");

        lbl_search_option_firm_date.setText("Date:-");

        lbl_search_option_date.setText("dd-mm-yyyy");

        javax.swing.GroupLayout lbl_search_option_firm_date1Layout = new javax.swing.GroupLayout(lbl_search_option_firm_date1);
        lbl_search_option_firm_date1.setLayout(lbl_search_option_firm_date1Layout);
        lbl_search_option_firm_date1Layout.setHorizontalGroup(
            lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_search_option_firm_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_search_option_firm_name1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_search_option_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbl_search_option_firm_date)
                .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9))
                    .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_search_option_date, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txt_search_option_date, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        lbl_search_option_firm_date1Layout.setVerticalGroup(
            lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_search_option_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_search_option_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_search_option_firm_name1)
                        .addComponent(lbl_search_option_firm_date)
                        .addComponent(txt_search_option_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_search_option_firm_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        lbl_search_option_firm_date1.setLayer(txt_search_option_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_date2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_name1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(txt_search_option_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_date, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_search_option.addTab("Welcome on Search Option", lbl_search_option_firm_date1);

        jTabbedPane1.addTab("Search Option", tabpane_search_option);

        jDesktopPane2.setBackground(new java.awt.Color(240, 240, 240));

        lbl1_user_account.setText("UserName");

        lbl2_user_account.setText("Password");

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
                            .addComponent(lbl2_user_account))
                        .addGap(117, 117, 117)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1_user_account)
                    .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2_user_account)
                    .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1_user_account_add)
                    .addComponent(btn2_user_account_delete))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jDesktopPane2.setLayer(lbl1_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbl2_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt1_user_account_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt2_user_account_password, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn1_user_account_add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn2_user_account_delete, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_user_account.addTab("Welcome on User Account", jDesktopPane2);

        jTabbedPane1.addTab("User Account", tabpane_user_account);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        
       
    }
    private void btn_daily_data_entry_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daily_data_entry_saveActionPerformed
        
        //String txt1 = txt_daily_data_entry_s_no.getText();
        String firm_name = txt_daily_data_entry_firm_name.getText();
        String credit  = txt_daily_data_entry_credit.getText();
        String debit = txt_daily_data_entry_debit.getText();
        String comment = txtarea_daily_data_entry_comment.getText();
                
        Object row[]={"1", firm_name, credit, debit, comment};
        table_daily_data_entry.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_daily_data_entry.getColumnModel().getColumn(0).setPreferredWidth(20);
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
        
           JOptionPane.showMessageDialog(null, "saved");
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
        
        //table_daily_data_entry.setAutoResizeMode(table_daily_data_entry.AUTO_RESIZE_LAST_COLUMN);
        DefaultTableModel model = (DefaultTableModel) table_daily_data_entry.getModel();
        model.addRow(row);

    }//GEN-LAST:event_btn_daily_data_entry_saveActionPerformed

    private void txt_daily_data_entry_firm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_daily_data_entry_firm_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_daily_data_entry_firm_nameActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

        // TODO add your handling code here:
       
        this.getContentPane().setBackground(Color.gray);
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        lbl_data_entry_date1.setText(date);
        
        lbl_daily_data_entry_user_name.setText(ConnectGUI.logged_user);
        
        String sql;
      sql = "SELECT * FROM table_daily_data_entry where date ='" +date+ "'";
            
      try
      {
        conn = Connect.ConnectDB();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            int count=1;
            do
            {
           Object row[]={count,  rs.getString("firm_name"), rs.getString("credit"), rs.getString("debit"), rs.getString("comment")};
        table_daily_data_entry.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_daily_data_entry.getColumnModel().getColumn(0).setPreferredWidth(20);
        table_daily_data_entry.getColumnModel().getColumn(1).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(4).setPreferredWidth(400);
        DefaultTableModel model = (DefaultTableModel) table_daily_data_entry.getModel();
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
        /////////////////////////////////////////////////////
      //Following section for borrowers tab
      
       sql = "SELECT * FROM firm_account WHERE user_type='b'";
            
      try
      {
        conn = Connect.ConnectDB();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            int count=1;
            do
            {
           Object row[]={ rs.getString("firm_name")};
        
         DefaultTableModel model = (DefaultTableModel) tbl_borrowers_borrower_name.getModel();
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
      
      
      
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void txt1_user_account_user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1_user_account_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1_user_account_user_nameActionPerformed
    
    private void btn_borrowers_add_new_firmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrowers_add_new_firmActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
        user_type = "b";
        this.setVisible(false);
         new FirmAccount1().setVisible(true);
         
         //this.setVisible(false);
        //new Information().setVisible(true);
    }//GEN-LAST:event_btn_borrowers_add_new_firmActionPerformed

    private void combobox_borrowers_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_borrowers_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_borrowers_cityActionPerformed

    private void btn1_user_account_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_user_account_addActionPerformed
        // TODO add your handling code here:
        
    
      String username = txt1_user_account_user_name.getText();
      String password = txt2_user_account_password.getText();
      
      String sql;
      sql = "Insert into tableUSERPASS (username,password) values ('" +  username + "','" + password + "')";
            
      try
      {
           conn = Connect.ConnectDB();
        pst = conn.prepareStatement(sql);
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "saved");
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
        // TODO add your handling code here:
      String username = txt1_user_account_user_name.getText();  
        
      String sql;
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
        // TODO add your handling code here:
        user_type="c";
        this.setVisible(false);
        new FirmAccount1().setVisible(true);
    }//GEN-LAST:event_btn_creditor_add_new_firmActionPerformed

    String anydate = "";
    String anyname = "";
    
    private void btn_search_option_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_option_enterActionPerformed
       
          anydate = txt_search_option_date.getText();
          anyname =  txt_search_option_firm_name.getText();
                 
      if( !anydate.equals("") )
      {
          DefaultTableModel model = (DefaultTableModel) tbl_search_option.getModel();
          
          for(int i=0;i< model.getRowCount() ; i++)
          {
              model.removeRow(i);
          }
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
                    tbl_search_option.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    tbl_search_option.getColumnModel().getColumn(0).setPreferredWidth(20);
                    tbl_search_option.getColumnModel().getColumn(1).setPreferredWidth(100);
                    tbl_search_option.getColumnModel().getColumn(2).setPreferredWidth(100);
                    tbl_search_option.getColumnModel().getColumn(3).setPreferredWidth(100);
                    tbl_search_option.getColumnModel().getColumn(4).setPreferredWidth(200);
                    model.addRow(row);
                    
                    count++;
                 }
                 while(rs.next());
                
            } 
            txt_search_option_firm_name.setText("");
            txt_search_option_date.setText("");
            conn.close();
         }
         catch(SQLException | HeadlessException e)
         {
            JOptionPane.showMessageDialog(null, e);          
         }
       }
        else if ( !anyname.equals("") )
           {   
            DefaultTableModel model = (DefaultTableModel) tbl_search_option.getModel();
          for(int i=0;i< model.getRowCount() ; i++)
          {
              model.removeRow(i);
          }
               String sql;
               sql = "SELECT * FROM table_daily_data_entry where firm_name ='" +anyname+ "'";            
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
                            tbl_search_option.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tbl_search_option.getColumnModel().getColumn(0).setPreferredWidth(30);
                            tbl_search_option.getColumnModel().getColumn(1).setPreferredWidth(100);
                            tbl_search_option.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tbl_search_option.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tbl_search_option.getColumnModel().getColumn(4).setPreferredWidth(200);
                            model.addRow(row);
                            count++;
                        }
                    while(rs.next());
                    }    
                    txt_search_option_firm_name.setText("");
                    txt_search_option_date.setText("");
                    conn.close();
                    }
                    catch(SQLException | HeadlessException e)
                    {
                        JOptionPane.showMessageDialog(null, e);          
                    }
            }
           else 
               if( anyname.equals("") && anydate.equals(""))
           {
               String sql;
               sql = "SELECT * FROM table_daily_data_entry where date ='" + anydate + "' AND firm_name='" + anyname + "'";
          
              
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
        // TODO add your handling code here:
        
        int row = tbl_borrowers_borrower_name.getSelectedRow();
        String firm_name =(String) tbl_borrowers_borrower_name.getValueAt(row, 0);
         String sql = "SELECT * FROM firm_account WHERE firm_name='" + firm_name + "'";
            
      try
      {
        conn = Connect.ConnectDB();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
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
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
      //  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
       // System.out.println(dateFormat.format(date));
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
    private javax.swing.JComboBox combobox_borrowers_city;
    private javax.swing.JComboBox combobox_creditors_city;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JLabel lbl_borrowers_creditor_name;
    private javax.swing.JLabel lbl_creditor_city;
    private javax.swing.JLabel lbl_daily_data_entry_comment;
    private javax.swing.JLabel lbl_daily_data_entry_credit;
    private javax.swing.JLabel lbl_daily_data_entry_date;
    private javax.swing.JLabel lbl_daily_data_entry_debit;
    private javax.swing.JLabel lbl_daily_data_entry_firm_name;
    private javax.swing.JLabel lbl_daily_data_entry_logged_user;
    private javax.swing.JLabel lbl_daily_data_entry_user_name;
    private javax.swing.JLabel lbl_data_entry_date1;
    private javax.swing.JLabel lbl_data_entry_welcome;
    private javax.swing.JLabel lbl_search_option_date;
    private javax.swing.JLabel lbl_search_option_firm_date;
    private javax.swing.JDesktopPane lbl_search_option_firm_date1;
    private javax.swing.JDesktopPane lbl_search_option_firm_date2;
    private javax.swing.JLabel lbl_search_option_firm_name1;
    private javax.swing.JList list_creditor_firm_name;
    private javax.swing.JTable table_daily_data_entry;
    private javax.swing.JTabbedPane tabpan_daily_data_entry;
    private javax.swing.JTabbedPane tabpane_borrowers;
    private javax.swing.JTabbedPane tabpane_creditors;
    private javax.swing.JTabbedPane tabpane_search_option;
    private javax.swing.JTabbedPane tabpane_user_account;
    private javax.swing.JTable tbl_borrowers_borrower_name;
    private javax.swing.JTable tbl_search_option;
    private javax.swing.JTextField txt1_user_account_user_name;
    private javax.swing.JTextField txt2_user_account_password;
    private javax.swing.JTextField txt_daily_data_entry_credit;
    private javax.swing.JTextField txt_daily_data_entry_debit;
    private javax.swing.JTextField txt_daily_data_entry_firm_name;
    private javax.swing.JTextField txt_search_option_date;
    private javax.swing.JTextField txt_search_option_firm_name;
    private javax.swing.JTextArea txtarea_daily_data_entry_comment;
    // End of variables declaration//GEN-END:variables
}
