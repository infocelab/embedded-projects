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
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.util.Arrays;

public class Information extends javax.swing.JFrame 
{
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    static String user_type=null;
    
    
    public Information() 
    {
        initComponents();
        lbl_copyright_1.setText("Copyright@Computronics Lab");
        lbl_copyright_2.setText("Copyright@Computronics Lab");
        lbl_copyright_3.setText("Copyright@Computronics Lab");
        lbl_copyright_4.setText("Copyright@Computronics Lab");
        lbl_copyright_5.setText("Copyright@Computronics Lab");
        this.setResizable(false);
        if(user_type != null)
        {
            if(user_type.equals("b"))
            {
                this.jTabbedPane1.setSelectedIndex(1);
                user_type=null;
            }
            else if(user_type.equals("c"))
            {
                this.jTabbedPane1.setSelectedIndex(2);
                user_type=null;
            }
        }
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
        txt_daily_data_entry_credit = new javax.swing.JTextField();
        txt_daily_data_entry_debit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_daily_data_entry = new javax.swing.JTable();
        btn_daily_data_entry_save = new javax.swing.JButton();
        lbl_data_entry_date1 = new javax.swing.JLabel();
        lbl_daily_data_entry_user_name = new javax.swing.JLabel();
        lbl_daily_data_entry_logged_user = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_daily_data_entry_firm_name = new javax.swing.JComboBox();
        lbl_copyright_1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_daily_data_entry_total = new javax.swing.JTable();
        tabpane_borrowers = new javax.swing.JTabbedPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        lbl_borrowers_city = new javax.swing.JLabel();
        btn_borrowers_add_new_firm = new javax.swing.JButton();
        lbl_borrowers_city1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_borrowers_borrower_name = new javax.swing.JTable();
        combobox_borrowers_city = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        lbl_copyright_2 = new javax.swing.JLabel();
        tabpane_creditors = new javax.swing.JTabbedPane();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        lbl_creditor_city = new javax.swing.JLabel();
        btn_creditor_add_new_firm = new javax.swing.JButton();
        combobox_creditors_city = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_creditor_firm_name = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbl_copyright_3 = new javax.swing.JLabel();
        tabpane_search_option = new javax.swing.JTabbedPane();
        lbl_search_option_firm_date1 = new javax.swing.JDesktopPane();
        jLabel9 = new javax.swing.JLabel();
        lbl_search_option_firm_name1 = new javax.swing.JLabel();
        lbl_search_option_firm_date = new javax.swing.JLabel();
        cmb_search_option_firm_name = new javax.swing.JComboBox();
        spin_search_dd = new javax.swing.JSpinner();
        spin_search_mm = new javax.swing.JSpinner();
        spin_search_yyyy = new javax.swing.JSpinner();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl_search_option = new javax.swing.JTable();
        btn_search_option_enter = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbl_copyright_4 = new javax.swing.JLabel();
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
        lbl_copyright_5 = new javax.swing.JLabel();

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
        txtarea_daily_data_entry_comment.setNextFocusableComponent(btn_daily_data_entry_save);
        jScrollPane2.setViewportView(txtarea_daily_data_entry_comment);

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_daily_data_entry.setGridColor(new java.awt.Color(153, 204, 255));
        table_daily_data_entry.setRowSelectionAllowed(false);
        table_daily_data_entry.setSelectionBackground(new java.awt.Color(153, 204, 255));
        table_daily_data_entry.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_daily_data_entry);
        if (table_daily_data_entry.getColumnModel().getColumnCount() > 0) {
            table_daily_data_entry.getColumnModel().getColumn(0).setResizable(false);
            table_daily_data_entry.getColumnModel().getColumn(1).setResizable(false);
            table_daily_data_entry.getColumnModel().getColumn(2).setResizable(false);
            table_daily_data_entry.getColumnModel().getColumn(3).setResizable(false);
            table_daily_data_entry.getColumnModel().getColumn(4).setResizable(false);
        }

        btn_daily_data_entry_save.setText("Save");
        btn_daily_data_entry_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daily_data_entry_saveActionPerformed(evt);
            }
        });

        lbl_data_entry_date1.setText("jLabel7");

        lbl_daily_data_entry_logged_user.setText("Logged User :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mangla Traders");
        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));

        cmb_daily_data_entry_firm_name.setAutoscrolls(true);
        cmb_daily_data_entry_firm_name.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmb_daily_data_entry_firm_nameInputMethodTextChanged(evt);
            }
        });
        cmb_daily_data_entry_firm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_daily_data_entry_firm_nameActionPerformed(evt);
            }
        });
        cmb_daily_data_entry_firm_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmb_daily_data_entry_firm_nameKeyTyped(evt);
            }
        });

        lbl_copyright_1.setText("Copyright to Computronics Lab");

        table_daily_data_entry_total.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "Total Credit", "Total Debit", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_daily_data_entry_total.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(table_daily_data_entry_total);
        if (table_daily_data_entry_total.getColumnModel().getColumnCount() > 0) {
            table_daily_data_entry_total.getColumnModel().getColumn(0).setResizable(false);
            table_daily_data_entry_total.getColumnModel().getColumn(1).setResizable(false);
            table_daily_data_entry_total.getColumnModel().getColumn(2).setResizable(false);
            table_daily_data_entry_total.getColumnModel().getColumn(3).setResizable(false);
            table_daily_data_entry_total.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_copyright_1))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbl_daily_data_entry_firm_name)
                                                .addComponent(cmb_daily_data_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(25, 25, 25)
                                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbl_daily_data_entry_credit)
                                                .addComponent(txt_daily_data_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(61, 61, 61)
                                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_daily_data_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_daily_data_entry_debit)))
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(lbl_daily_data_entry_date)
                                            .addGap(35, 35, 35)
                                            .addComponent(lbl_data_entry_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(62, 62, 62))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(btn_daily_data_entry_save, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(135, 135, 135)))
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_daily_data_entry_comment)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGap(315, 315, 315)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_daily_data_entry_date)
                        .addComponent(lbl_data_entry_date1)
                        .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_daily_data_entry_firm_name)
                    .addComponent(lbl_daily_data_entry_credit)
                    .addComponent(lbl_daily_data_entry_debit)
                    .addComponent(lbl_daily_data_entry_comment))
                .addGap(32, 32, 32)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_daily_data_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daily_data_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_daily_data_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_daily_data_entry_save)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_copyright_1))
        );
        jDesktopPane1.setLayer(lbl_daily_data_entry_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_credit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_debit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_comment, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_credit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txt_daily_data_entry_debit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_daily_data_entry_save, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_data_entry_date1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_logged_user, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cmb_daily_data_entry_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_copyright_1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mangla Traders");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));

        lbl_copyright_2.setText("Copyright to Computronics Lab");

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lbl_borrowers_city)
                .addGap(29, 29, 29)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(combobox_borrowers_city, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_borrowers_add_new_firm, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(428, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_copyright_2))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(lbl_borrowers_city1)
                    .addContainerGap(864, Short.MAX_VALUE)))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_borrowers_city)
                            .addComponent(combobox_borrowers_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(btn_borrowers_add_new_firm))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(lbl_copyright_2))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(lbl_borrowers_city1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE)))
        );
        jDesktopPane3.setLayer(lbl_borrowers_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btn_borrowers_add_new_firm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(lbl_borrowers_city1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(combobox_borrowers_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(lbl_copyright_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mangla Traders");
        jLabel5.setBorder(new javax.swing.border.MatteBorder(null));

        lbl_copyright_3.setText("Copyright to Computronics Lab");

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lbl_creditor_city)
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_creditor_add_new_firm, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(combobox_creditors_city, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel5)))
                .addContainerGap(445, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_copyright_3))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_creditors_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_creditor_city))
                        .addGap(62, 62, 62)
                        .addComponent(btn_creditor_add_new_firm))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(lbl_copyright_3))
        );
        jDesktopPane4.setLayer(lbl_creditor_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(btn_creditor_add_new_firm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(combobox_creditors_city, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(lbl_copyright_3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_creditors.addTab("Welcome on Creditors", jDesktopPane4);

        jTabbedPane1.addTab("Creditors", tabpane_creditors);

        tabpane_search_option.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabpane_search_optionFocusGained(evt);
            }
        });

        lbl_search_option_firm_date1.setBackground(new java.awt.Color(204, 204, 255));

        lbl_search_option_firm_name1.setText("Firm Name");

        lbl_search_option_firm_date.setText("Date (dd-mm-yyyy):");

        cmb_search_option_firm_name.setBackground(new java.awt.Color(204, 204, 255));
        cmb_search_option_firm_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        cmb_search_option_firm_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_search_option_firm_nameItemStateChanged(evt);
            }
        });
        cmb_search_option_firm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_search_option_firm_nameActionPerformed(evt);
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
                "S_No", "Date", "Name", "Credit", "Debit", "Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tbl_search_option);

        btn_search_option_enter.setText("Search by date");
        btn_search_option_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_option_enterActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mangla Traders");
        jLabel6.setBorder(new javax.swing.border.MatteBorder(null));

        lbl_copyright_4.setText("Copyright to Computronics Lab");

        javax.swing.GroupLayout lbl_search_option_firm_date1Layout = new javax.swing.GroupLayout(lbl_search_option_firm_date1);
        lbl_search_option_firm_date1.setLayout(lbl_search_option_firm_date1Layout);
        lbl_search_option_firm_date1Layout.setHorizontalGroup(
            lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel9)
                .addGap(0, 581, Short.MAX_VALUE))
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                                .addComponent(lbl_search_option_firm_name1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_search_option_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_search_option_firm_date)
                                .addGap(18, 18, 18)
                                .addComponent(spin_search_dd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spin_search_mm, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spin_search_yyyy, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btn_search_option_enter)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_copyright_4))
        );
        lbl_search_option_firm_date1Layout.setVerticalGroup(
            lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_search_option_firm_date1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addGroup(lbl_search_option_firm_date1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search_option_enter)
                    .addComponent(spin_search_dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spin_search_mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spin_search_yyyy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_search_option_firm_date)
                    .addComponent(cmb_search_option_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_search_option_firm_name1))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(lbl_copyright_4))
        );
        lbl_search_option_firm_date1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_name1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_search_option_firm_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(cmb_search_option_firm_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(spin_search_dd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(spin_search_mm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(spin_search_yyyy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(jScrollPane10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(btn_search_option_enter, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_search_option_firm_date1.setLayer(lbl_copyright_4, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mangla Traders");
        jLabel7.setBorder(new javax.swing.border.MatteBorder(null));

        lbl_copyright_5.setText("Copyright to Computronics Lab");

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel1))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(btn1_user_account_add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(146, 146, 146)
                                .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(lbl1_user_account)
                        .addGap(228, 228, 228)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn2_user_account_delete)
                            .addComponent(lbl2_user_account))))
                .addContainerGap(294, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_copyright_5))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl2_user_account)
                    .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1_user_account))
                .addGap(46, 46, 46)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1_user_account_add)
                    .addComponent(btn2_user_account_delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addComponent(lbl_copyright_5))
        );
        jDesktopPane2.setLayer(lbl1_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbl2_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt1_user_account_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn1_user_account_add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn2_user_account_delete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt2_user_account_password, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbl_copyright_5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_user_account.addTab("Welcome on User Account", jDesktopPane2);

        jTabbedPane1.addTab("User Account", tabpane_user_account);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) 
    {
      
    }
    int data_entry_count=1;
    int credit_total=0;
    int debit_total=0;
    
    private void btn_daily_data_entry_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daily_data_entry_saveActionPerformed
        String firm_name = cmb_daily_data_entry_firm_name.getSelectedItem().toString();
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
        
        if(!credit.equals("") && !debit.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Both Credit and Debit cannot be Accepted"); 
            return;
        }
        
        if(credit.equals("") && debit.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Both Credit and Debit cannot be Empty"); 
            return;
        }
        
        Object row[]={data_entry_count, firm_name, credit, debit, comment};
        data_entry_count = data_entry_count + 1;

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
        
           //cmb_daily_data_entry_firm_name.setSelectedIndex(0);

           
           conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
          JOptionPane.showMessageDialog(null, e);          
        }
        
        DefaultTableModel model = (DefaultTableModel) table_daily_data_entry.getModel();
        model.addRow(row);
        

        if(!credit.equals(""))
        {
            credit_total += Integer.parseInt(credit);
        }
        if(!debit.equals(""))
        {
            debit_total += Integer.parseInt(debit);
        }
        
        DefaultTableModel model_total = (DefaultTableModel) table_daily_data_entry_total.getModel();
        model_total.setRowCount(0);
        Object row_t[]={"","" , String.valueOf(credit_total),String.valueOf(debit_total),String.valueOf(credit_total - debit_total)};
        model_total.addRow(row_t);
                   
        txt_daily_data_entry_credit.setText("");
        txt_daily_data_entry_debit.setText("");
        txtarea_daily_data_entry_comment.setText("");
        
        
    }//GEN-LAST:event_btn_daily_data_entry_saveActionPerformed

    
    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

        tbl_borrowers_borrower_name.removeAll();

        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        lbl_data_entry_date1.setText(date);
        
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(today);
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH) + 1;
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
        
        if(month1 > 7 || day1 > 25)
        {
            JOptionPane.showMessageDialog(null, "Software Expired Please call ComputronicLab and make Payment");    
            this.setVisible(false);
            return;
        }
        
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
        
        //populate daily data entry firm name combo box with existing firm names
        //sql = "SELECT * FROM firm_account ORDER BY LOWER(firm_name)";
        sql = "SELECT * FROM firm_account";
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                boolean added = false;
                Object obj;
                String name = "";
                int count = 0;
                int compare = 0;
                do
                {
                    added = false;
                    name = rs.getString("firm_name");
                    count = cmb_daily_data_entry_firm_name.getItemCount();
                    for (int i = 0; i < count; i++) 
                    {
                        obj = cmb_daily_data_entry_firm_name.getItemAt(i);
                        compare = name.compareToIgnoreCase(obj.toString());
                        if (compare <= 0) 
                        { 
                            if(((DefaultComboBoxModel)cmb_daily_data_entry_firm_name.getModel()).getIndexOf(name) == -1 ) 
                            {
                                cmb_daily_data_entry_firm_name.insertItemAt(name, i);
                            }
                            added = true;
                            break;
                        }
                    }
                    if (!added) 
                    {
                        if(((DefaultComboBoxModel)cmb_daily_data_entry_firm_name.getModel()).getIndexOf(name) == -1 ) 
                        {
                            cmb_daily_data_entry_firm_name.addItem(name);
                        }
                    }
                }while (rs.next()) ;
                
                cmb_daily_data_entry_firm_name.setSelectedIndex(0);
                /*
                
                do
                {
                    Object row[]={rs.getString("firm_name")};
                    
                    if(((DefaultComboBoxModel)cmb_daily_data_entry_firm_name.getModel()).getIndexOf(row[0].toString()) == -1 ) 
                    {
                        cmb_daily_data_entry_firm_name.addItem(row[0].toString());
                    }
                }while(rs.next());
                */
            }
        
            conn.close();
            
            
            
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }
        
        // fill daily data entry table with existing data for today
        table_daily_data_entry.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_daily_data_entry.getColumnModel().getColumn(0).setPreferredWidth(40);
        table_daily_data_entry.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_daily_data_entry.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_daily_data_entry.getColumnModel().getColumn(4).setPreferredWidth(375);
                    
        table_daily_data_entry_total.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_daily_data_entry_total.getColumnModel().getColumn(0).setPreferredWidth(40);
        table_daily_data_entry_total.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_daily_data_entry_total.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_daily_data_entry_total.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_daily_data_entry_total.getColumnModel().getColumn(4).setPreferredWidth(375);
               
        sql = "SELECT * FROM table_daily_data_entry where date ='" +date+ "'";
        DefaultTableModel model_t = (DefaultTableModel) table_daily_data_entry.getModel();
        model_t.setRowCount(0);
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                credit_total=0;
                debit_total=0;
                int count=1;
                do
                {
                    Object row[]={count,  rs.getString("firm_name"), rs.getString("credit"), rs.getString("debit"), rs.getString("comment")};
                    
                
                    if(!rs.getString("credit").equals(""))
                    {
                        credit_total += Integer.parseInt(rs.getString("credit"));
                    }
                    if(!rs.getString("debit").equals(""))
                    {
                        debit_total += Integer.parseInt(rs.getString("debit"));
                    }
                   
                    model_t.addRow(row);
                             
                    count++;
                    
                    DefaultTableModel model_total = (DefaultTableModel) table_daily_data_entry_total.getModel();
                    model_total.setRowCount(0);
                    Object row_t[]={"","" , String.valueOf(credit_total),String.valueOf(debit_total),String.valueOf(credit_total - debit_total)};
                    
                    model_total.addRow(row_t);
                 
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
      
        sql = "SELECT * FROM firm_account WHERE user_type='b' ORDER BY LOWER(firm_name)";
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
        
        
        sql = "SELECT * FROM firm_account WHERE user_type='c' ORDER BY LOWER(city)";
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                do
                {
                    Object item[]={ rs.getString("city")};
                    if(((DefaultComboBoxModel)combobox_borrowers_city.getModel()).getIndexOf(item[0].toString()) == -1 ) 
                    {
                        combobox_borrowers_city.addItem(item[0].toString());
                    }
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
          
        sql = "SELECT * FROM firm_account WHERE user_type='c' ORDER BY LOWER(firm_name)";
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
      
        
        sql = "SELECT * FROM firm_account WHERE user_type='c' ORDER BY LOWER(city)";
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                do
                {
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
        tbl_search_option.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_search_option.getColumnModel().getColumn(2).setPreferredWidth(150);
        tbl_search_option.getColumnModel().getColumn(3).setPreferredWidth(130);
        tbl_search_option.getColumnModel().getColumn(4).setPreferredWidth(130);
        tbl_search_option.getColumnModel().getColumn(5).setPreferredWidth(300);
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        spin_search_dd.setValue(day);
        spin_search_mm.setValue(month);
        spin_search_yyyy.setValue(year);
        sql = "SELECT * FROM table_daily_data_entry ORDER BY LOWER(firm_name)";
            
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
        firm_name_temp="";
        showFirmAccount=0;
        this.setVisible(false);
        new FirmAccount1_1().setVisible(true);
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
        firm_name_temp="";
        showFirmAccount=0;
        this.setVisible(false);
        new FirmAccount1_1().setVisible(true);
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
                        Object row[]={count, rs.getString("date"), rs.getString("firm_name"), rs.getString("credit"), rs.getString("debit"), rs.getString("comment")};
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
        user_type="b";    
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
 
    private void tbl_creditor_firm_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_creditor_firm_nameMouseClicked
        int row = tbl_creditor_firm_name.getSelectedRow();
        String firm_name =(String) tbl_creditor_firm_name.getValueAt(row, 0);
        String sql = "SELECT * FROM firm_account WHERE firm_name='" + firm_name + "'";
        user_type="c"; 
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
                        Object row[]={count,rs.getString("date"),  rs.getString("firm_name"), rs.getString("credit"), rs.getString("debit"), rs.getString("comment")};
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

    private void cmb_search_option_firm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_search_option_firm_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_search_option_firm_nameActionPerformed

    private void cmb_daily_data_entry_firm_nameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmb_daily_data_entry_firm_nameInputMethodTextChanged
        // TODO add your handling code here:
        
        //cmb_daily_data_entry_firm_name.showPopup();
    }//GEN-LAST:event_cmb_daily_data_entry_firm_nameInputMethodTextChanged

    private void cmb_daily_data_entry_firm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_daily_data_entry_firm_nameActionPerformed
        // TODO add your handling code here:
         //cmb_daily_data_entry_firm_name.showPopup();
    }//GEN-LAST:event_cmb_daily_data_entry_firm_nameActionPerformed

    private void cmb_daily_data_entry_firm_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_daily_data_entry_firm_nameKeyTyped
        // TODO add your handling code here:
        //cmb_daily_data_entry_firm_name.showPopup();
    }//GEN-LAST:event_cmb_daily_data_entry_firm_nameKeyTyped
  
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
    private javax.swing.JComboBox cmb_daily_data_entry_firm_name;
    private javax.swing.JComboBox cmb_search_option_firm_name;
    private javax.swing.JComboBox combobox_borrowers_city;
    private javax.swing.JComboBox combobox_creditors_city;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JLabel lbl_copyright_1;
    private javax.swing.JLabel lbl_copyright_2;
    private javax.swing.JLabel lbl_copyright_3;
    private javax.swing.JLabel lbl_copyright_4;
    private javax.swing.JLabel lbl_copyright_5;
    private javax.swing.JLabel lbl_creditor_city;
    private javax.swing.JLabel lbl_daily_data_entry_comment;
    private javax.swing.JLabel lbl_daily_data_entry_credit;
    private javax.swing.JLabel lbl_daily_data_entry_date;
    private javax.swing.JLabel lbl_daily_data_entry_debit;
    private javax.swing.JLabel lbl_daily_data_entry_firm_name;
    private javax.swing.JLabel lbl_daily_data_entry_logged_user;
    private javax.swing.JLabel lbl_daily_data_entry_user_name;
    private javax.swing.JLabel lbl_data_entry_date1;
    private javax.swing.JLabel lbl_search_option_firm_date;
    private javax.swing.JDesktopPane lbl_search_option_firm_date1;
    private javax.swing.JLabel lbl_search_option_firm_name1;
    private javax.swing.JSpinner spin_search_dd;
    private javax.swing.JSpinner spin_search_mm;
    private javax.swing.JSpinner spin_search_yyyy;
    private javax.swing.JTable table_daily_data_entry;
    private javax.swing.JTable table_daily_data_entry_total;
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
    private javax.swing.JTextArea txtarea_daily_data_entry_comment;
    // End of variables declaration//GEN-END:variables
}
