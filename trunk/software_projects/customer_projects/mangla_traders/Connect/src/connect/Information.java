
package connect;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
//import java.util.Calendar;

/**
 *
 * @author celab-amit
 */
public class Information extends javax.swing.JFrame {

    /**
     * Creates new form Information
     */
    public Information() {
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
        lbl_daily_data_entry_time = new javax.swing.JLabel();
        lbl_daily_data_entry_s_no = new javax.swing.JLabel();
        lbl_daily_data_entry_firm_name = new javax.swing.JLabel();
        lbl_daily_data_entry_credit = new javax.swing.JLabel();
        lbl_daily_data_entry_debit = new javax.swing.JLabel();
        lbl_daily_data_entry_comment = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_daily_data_entry_comment = new javax.swing.JTextArea();
        txt_daily_data_entry_s_no = new javax.swing.JTextField();
        txt_daily_data_entry_firm_name = new javax.swing.JTextField();
        txt_daily_data_entry_credit = new javax.swing.JTextField();
        txt_daily_data_entry_debit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_daily_data_entry = new javax.swing.JTable();
        btn_daily_data_entry_save = new javax.swing.JButton();
        lbl_data_entry_date = new javax.swing.JLabel();
        tabpane_borrowers = new javax.swing.JTabbedPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        lbl_borrowers_city = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl1_borrowers = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl2_borrowers = new javax.swing.JTable();
        btn_borrowers_add_new_form = new javax.swing.JButton();
        combobox_borrowers_city = new javax.swing.JComboBox();
        tabpane_creditors = new javax.swing.JTabbedPane();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        lbl_creditor_city = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl1_creditors = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl2_creditors = new javax.swing.JTable();
        btn_creditor_add_new_form = new javax.swing.JButton();
        combobox_creditors_city = new javax.swing.JComboBox();
        tabpane_search_option = new javax.swing.JTabbedPane();
        lbl_search_option_firm_date1 = new javax.swing.JDesktopPane();
        lbl_search_option_firm_name = new javax.swing.JLabel();
        lbl_search_option_firm_date = new javax.swing.JLabel();
        txt_search_option_firm_name1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_search_option_firm_date1 = new javax.swing.JTextField();
        btnl_search_option_enter = new javax.swing.JButton();
        jTabbedPane16 = new javax.swing.JTabbedPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        lbl1_user_account = new javax.swing.JLabel();
        lbl2_user_account = new javax.swing.JLabel();
        txt1_user_account = new javax.swing.JTextField();
        txt2_user_account = new javax.swing.JTextField();
        btn1_user_account = new javax.swing.JButton();
        btn2_user_account = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));

        lbl_daily_data_entry_time.setText("Time:");

        lbl_daily_data_entry_s_no.setText("S. No.");

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

        lbl_data_entry_date.setText("jLabel7");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_daily_data_entry_s_no, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daily_data_entry_s_no, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_daily_data_entry_time))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(txt_daily_data_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(btn_daily_data_entry_save, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE))
                                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_daily_data_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbl_daily_data_entry_credit))
                                                .addGap(50, 50, 50)
                                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_daily_data_entry_debit)
                                                    .addComponent(txt_daily_data_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29))))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(lbl_daily_data_entry_firm_name)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(lbl_data_entry_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_daily_data_entry_comment))))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_daily_data_entry_time)
                    .addComponent(lbl_data_entry_date))
                .addGap(38, 38, 38)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_daily_data_entry_firm_name)
                    .addComponent(lbl_daily_data_entry_credit)
                    .addComponent(lbl_daily_data_entry_debit)
                    .addComponent(lbl_daily_data_entry_comment)
                    .addComponent(lbl_daily_data_entry_s_no))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_daily_data_entry_s_no, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daily_data_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daily_data_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daily_data_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_daily_data_entry_save))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jDesktopPane1.setLayer(lbl_daily_data_entry_time, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_s_no, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_credit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_debit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_comment, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_s_no, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_credit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_debit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_daily_data_entry_save, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_data_entry_date, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpan_daily_data_entry.addTab("Welcome on Daily Data Entry", jDesktopPane1);

        jTabbedPane1.addTab("Daily Data Entry", tabpan_daily_data_entry);

        jDesktopPane3.setBackground(new java.awt.Color(240, 240, 240));

        lbl_borrowers_city.setText("City:-");

        tbl1_borrowers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Firm Name", "Contact Name", "Address", "City", "Mobile Number"
            }
        ));
        tbl1_borrowers.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tbl1_borrowers);
        tbl1_borrowers.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        tbl2_borrowers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Debit", "Credit", "Date"
            }
        ));
        jScrollPane4.setViewportView(tbl2_borrowers);

        btn_borrowers_add_new_form.setText("Add New Firm");
        btn_borrowers_add_new_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrowers_add_new_formActionPerformed(evt);
            }
        });

        combobox_borrowers_city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "City 1", "City 2", "City 3", "City 4" }));
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
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_borrowers_city)
                                .addGap(33, 33, 33)
                                .addComponent(combobox_borrowers_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(btn_borrowers_add_new_form)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_borrowers_city)
                    .addComponent(combobox_borrowers_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_borrowers_add_new_form)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jDesktopPane3.setLayer(lbl_borrowers_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btn_borrowers_add_new_form, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(combobox_borrowers_city, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_borrowers.addTab("Welcome on Borroers", jDesktopPane3);

        jTabbedPane1.addTab("Borrowers", tabpane_borrowers);

        jDesktopPane4.setBackground(new java.awt.Color(240, 240, 240));

        lbl_creditor_city.setText("City:-");

        tbl1_creditors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Firm Name", "Contact Name", "Address", "City", "Mobile Number"
            }
        ));
        tbl1_creditors.setColumnSelectionAllowed(true);
        jScrollPane5.setViewportView(tbl1_creditors);
        tbl1_creditors.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        tbl2_creditors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Debit", "Credit", "Date"
            }
        ));
        jScrollPane6.setViewportView(tbl2_creditors);

        btn_creditor_add_new_form.setText("Add New Firm");

        combobox_creditors_city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "City 1", "City 2", "City 3", "City 4" }));

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_creditor_city)
                                .addGap(18, 18, 18)
                                .addComponent(combobox_creditors_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane4Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(btn_creditor_add_new_form)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_creditor_city)
                    .addComponent(combobox_creditors_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_creditor_add_new_form)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jDesktopPane4.setLayer(lbl_creditor_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(btn_creditor_add_new_form, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(combobox_creditors_city, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_creditors.addTab("Welcome on Creditors", jDesktopPane4);

        jTabbedPane1.addTab("Creditors", tabpane_creditors);

        lbl_search_option_firm_date1.setBackground(new java.awt.Color(240, 240, 240));

        lbl_search_option_firm_name.setText("Firm Name");

        lbl_search_option_firm_date.setText("Date:-");

        btnl_search_option_enter.setText("Enter");

        javax.swing.GroupLayout lbl_search_option_firm_date1Layout = new javax.swing.GroupLayout(lbl_search_option_firm_date1);
        lbl_search_option_firm_date1.setLayout(lbl_search_option_firm_date1Layout);
        lbl_search_option_firm_date1Layout.setHorizontalGroup(
            lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lbl_search_option_firm_name)
                        .addGap(18, 18, 18)
                        .addComponent(txt_search_option_firm_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel9))
                            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(lbl_search_option_firm_date)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search_option_firm_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(btnl_search_option_enter)))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        lbl_search_option_firm_date1Layout.setVerticalGroup(
            lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_search_option_firm_name)
                    .addComponent(lbl_search_option_firm_date)
                    .addComponent(txt_search_option_firm_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_search_option_firm_date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnl_search_option_enter)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(txt_search_option_firm_name1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(txt_search_option_firm_date1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(btnl_search_option_enter, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_search_option.addTab("Welcome on Search Option", lbl_search_option_firm_date1);

        jTabbedPane1.addTab("Search Option", tabpane_search_option);

        jDesktopPane2.setBackground(new java.awt.Color(240, 240, 240));

        lbl1_user_account.setText("UserName");

        lbl2_user_account.setText("Password");

        txt1_user_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1_user_accountActionPerformed(evt);
            }
        });

        btn1_user_account.setText("Add");

        btn2_user_account.setText("Delete");

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(btn1_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn2_user_account)
                        .addGap(57, 57, 57))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl1_user_account)
                            .addComponent(lbl2_user_account))
                        .addGap(117, 117, 117)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt1_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1_user_account)
                    .addComponent(txt1_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2_user_account)
                    .addComponent(txt2_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1_user_account)
                    .addComponent(btn2_user_account))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jDesktopPane2.setLayer(lbl1_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbl2_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt1_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt2_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn1_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn2_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane16.addTab("Welcome on User Account", jDesktopPane2);

        jTabbedPane1.addTab("User Account", jTabbedPane16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_daily_data_entry_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daily_data_entry_saveActionPerformed

        String txt1 = txt_daily_data_entry_s_no.getText();
        String txt2 = txt_daily_data_entry_firm_name.getText();
        String txt3 = txt_daily_data_entry_credit.getText();
        String txt4 = txt_daily_data_entry_debit.getText();
        String txt5 = txtarea_daily_data_entry_comment.getText();
                
        Object row[]={txt1, txt2, txt3, txt4, txt5};
        table_daily_data_entry.setAutoResizeMode(table_daily_data_entry.AUTO_RESIZE_OFF);
        table_daily_data_entry.getColumnModel().getColumn(0).setPreferredWidth(50);
        table_daily_data_entry.getColumnModel().getColumn(1).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(4).setPreferredWidth(400);
        
        //table_daily_data_entry.setAutoResizeMode(table_daily_data_entry.AUTO_RESIZE_LAST_COLUMN);
        DefaultTableModel model = (DefaultTableModel) table_daily_data_entry.getModel();
        model.addRow(row);

    }//GEN-LAST:event_btn_daily_data_entry_saveActionPerformed

    private void txt_daily_data_entry_firm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_daily_data_entry_firm_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_daily_data_entry_firm_nameActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
        Date date = new Date();
        lbl_data_entry_date.setText(date.toString());
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void txt1_user_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1_user_accountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1_user_accountActionPerformed

    private void btn_borrowers_add_new_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrowers_add_new_formActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_btn_borrowers_add_new_formActionPerformed

    private void combobox_borrowers_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_borrowers_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_borrowers_cityActionPerformed

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
    private javax.swing.JButton btn1_user_account;
    private javax.swing.JButton btn2_user_account;
    private javax.swing.JButton btn_borrowers_add_new_form;
    private javax.swing.JButton btn_creditor_add_new_form;
    private javax.swing.JButton btn_daily_data_entry_save;
    private javax.swing.JButton btnl_search_option_enter;
    private javax.swing.JComboBox combobox_borrowers_city;
    private javax.swing.JComboBox combobox_creditors_city;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane11;
    private javax.swing.JTabbedPane jTabbedPane13;
    private javax.swing.JTabbedPane jTabbedPane16;
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
    private javax.swing.JLabel lbl_creditor_city;
    private javax.swing.JLabel lbl_daily_data_entry_comment;
    private javax.swing.JLabel lbl_daily_data_entry_credit;
    private javax.swing.JLabel lbl_daily_data_entry_debit;
    private javax.swing.JLabel lbl_daily_data_entry_firm_name;
    private javax.swing.JLabel lbl_daily_data_entry_s_no;
    private javax.swing.JLabel lbl_daily_data_entry_time;
    private javax.swing.JLabel lbl_data_entry_date;
    private javax.swing.JLabel lbl_search_option_firm_date;
    private javax.swing.JDesktopPane lbl_search_option_firm_date1;
    private javax.swing.JLabel lbl_search_option_firm_name;
    private javax.swing.JTable table_daily_data_entry;
    private javax.swing.JTabbedPane tabpan_daily_data_entry;
    private javax.swing.JTabbedPane tabpane_borrowers;
    private javax.swing.JTabbedPane tabpane_creditors;
    private javax.swing.JTabbedPane tabpane_search_option;
    private javax.swing.JTable tbl1_borrowers;
    private javax.swing.JTable tbl1_creditors;
    private javax.swing.JTable tbl2_borrowers;
    private javax.swing.JTable tbl2_creditors;
    private javax.swing.JTextField txt1_user_account;
    private javax.swing.JTextField txt2_user_account;
    private javax.swing.JTextField txt_daily_data_entry_credit;
    private javax.swing.JTextField txt_daily_data_entry_debit;
    private javax.swing.JTextField txt_daily_data_entry_firm_name;
    private javax.swing.JTextField txt_daily_data_entry_s_no;
    private javax.swing.JTextField txt_search_option_firm_date1;
    private javax.swing.JTextField txt_search_option_firm_name1;
    private javax.swing.JTextArea txtarea_daily_data_entry_comment;
    // End of variables declaration//GEN-END:variables
}
