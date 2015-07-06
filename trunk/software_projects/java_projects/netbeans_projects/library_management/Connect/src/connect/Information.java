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
        lbl_data_entry_welcome = new javax.swing.JLabel();
        btn_data_entry_logout = new javax.swing.JButton();
        btn_data_entry_return = new javax.swing.JButton();
        btn_data_entry_borrow = new javax.swing.JButton();
        btn_data_entry_search_books = new javax.swing.JButton();
        btn_data_entry_students = new javax.swing.JButton();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        lbl_add_book = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_add_books_author_name = new javax.swing.JTextField();
        txt_add_books_book_name = new javax.swing.JTextField();
        cmbox_add_books_category = new javax.swing.JComboBox();
        cmbox_add_books_language = new javax.swing.JComboBox();
        btn_add_books_save = new javax.swing.JButton();
        tabpane_user_account = new javax.swing.JTabbedPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        lbl1_user_account = new javax.swing.JLabel();
        lbl2_user_account = new javax.swing.JLabel();
        txt1_user_account_user_name = new javax.swing.JTextField();
        btn1_user_account_add = new javax.swing.JButton();
        btn2_user_account_delete = new javax.swing.JButton();
        txt2_user_account_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        lbl_update_user_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(97, 91, 130));

        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

        lbl_daily_data_entry_date.setText("Date:");

        lbl_data_entry_date1.setText("jLabel7");

        lbl_daily_data_entry_user_name.setText("logged user");

        lbl_daily_data_entry_logged_user.setText("Logged User :");

        lbl_data_entry_welcome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_data_entry_welcome.setForeground(new java.awt.Color(51, 51, 255));
        lbl_data_entry_welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_data_entry_welcome.setText("Welcome on Library Management");
        lbl_data_entry_welcome.setBorder(new javax.swing.border.MatteBorder(null));

        btn_data_entry_logout.setText("Logout");
        btn_data_entry_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_entry_logoutActionPerformed(evt);
            }
        });

        btn_data_entry_return.setText("Return");
        btn_data_entry_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_entry_returnActionPerformed(evt);
            }
        });

        btn_data_entry_borrow.setText("Borrow");
        btn_data_entry_borrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_entry_borrowActionPerformed(evt);
            }
        });

        btn_data_entry_search_books.setText("Search Books");
        btn_data_entry_search_books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_entry_search_booksActionPerformed(evt);
            }
        });

        btn_data_entry_students.setText("Students");
        btn_data_entry_students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_entry_studentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_daily_data_entry_date)
                .addGap(61, 61, 61)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_data_entry_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_data_entry_students, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addComponent(btn_data_entry_borrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(166, 166, 166)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_data_entry_search_books, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_data_entry_return, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGap(306, 306, 306)
                            .addComponent(btn_data_entry_logout))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGap(173, 173, 173)
                            .addComponent(lbl_data_entry_welcome))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_data_entry_welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_data_entry_date1)
                    .addComponent(lbl_daily_data_entry_date)
                    .addComponent(lbl_daily_data_entry_logged_user, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_daily_data_entry_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_data_entry_students)
                    .addComponent(btn_data_entry_search_books))
                .addGap(85, 85, 85)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_data_entry_return)
                    .addComponent(btn_data_entry_borrow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btn_data_entry_logout)
                .addGap(114, 114, 114))
        );
        jDesktopPane1.setLayer(lbl_daily_data_entry_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_data_entry_date1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_daily_data_entry_logged_user, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbl_data_entry_welcome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_data_entry_logout, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_data_entry_return, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_data_entry_borrow, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_data_entry_search_books, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btn_data_entry_students, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpan_daily_data_entry.addTab("Libray Management", jDesktopPane1);

        jTabbedPane1.addTab("Data Entry", tabpan_daily_data_entry);

        jDesktopPane3.setBackground(new java.awt.Color(240, 240, 240));

        lbl_add_book.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_add_book.setForeground(new java.awt.Color(51, 51, 255));
        lbl_add_book.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_add_book.setText("Add Books");
        lbl_add_book.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setText("Category : ");

        jLabel3.setText("Book Name :");

        jLabel4.setText("Author Name :");

        jLabel5.setText("Language :");

        cmbox_add_books_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----Select---", "Programming", "Multimedia", "Story", "Science", "History", "Other" }));

        cmbox_add_books_language.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select---", "Hindi", "English", "Other" }));

        btn_add_books_save.setText("save");
        btn_add_books_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_books_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_add_books_book_name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbox_add_books_category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_add_books_author_name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbox_add_books_language, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175))
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btn_add_books_save))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(lbl_add_book, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(576, Short.MAX_VALUE)))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_add_book, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_add_books_author_name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_add_books_book_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbox_add_books_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbox_add_books_language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(btn_add_books_save)
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane3Layout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(380, Short.MAX_VALUE)))
        );
        jDesktopPane3.setLayer(lbl_add_book, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(txt_add_books_author_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(txt_add_books_book_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cmbox_add_books_category, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cmbox_add_books_language, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(btn_add_books_save, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Add Books", jDesktopPane3);

        jDesktopPane2.setBackground(new java.awt.Color(204, 204, 255));

        lbl1_user_account.setText("UserName :");

        lbl2_user_account.setText("Password :");

        txt1_user_account_user_name.setBackground(new java.awt.Color(255, 204, 204));

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

        lbl_update_user_.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_update_user_.setForeground(new java.awt.Color(51, 51, 255));
        lbl_update_user_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_update_user_.setText("Update User");
        lbl_update_user_.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(443, 443, 443)
                .addComponent(lbl2_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn1_user_account_add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(lbl1_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btn2_user_account_delete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel1))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(lbl_update_user_, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_update_user_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2_user_account_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1_user_account_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1_user_account, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn2_user_account_delete)
                    .addComponent(btn1_user_account_add))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jDesktopPane2.setLayer(lbl1_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbl2_user_account, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt1_user_account_user_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn1_user_account_add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btn2_user_account_delete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txt2_user_account_password, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbl_update_user_, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabpane_user_account.addTab("Welcome on User Account", jDesktopPane2);

        jTabbedPane1.addTab("User Account", tabpane_user_account);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) 
    {
      
    }
   
    private void cal_search_option_dateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cal_search_option_dateInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cal_search_option_dateInputMethodTextChanged

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        lbl_data_entry_date1.setText(date);
        // lbl_mark_att_date.setText(date);
       // lbl_view_att_date.setText(date);

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

    private void btn_data_entry_studentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_entry_studentsActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                new student().setVisible(true);
    }//GEN-LAST:event_btn_data_entry_studentsActionPerformed

    private void btn_data_entry_search_booksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_entry_search_booksActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                new SearchBooks().setVisible(true);
    }//GEN-LAST:event_btn_data_entry_search_booksActionPerformed

    private void btn_data_entry_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_entry_returnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                new Return().setVisible(true);
    }//GEN-LAST:event_btn_data_entry_returnActionPerformed

    private void btn_data_entry_borrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_entry_borrowActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                new Borrow().setVisible(true);
    }//GEN-LAST:event_btn_data_entry_borrowActionPerformed

    private void btn_data_entry_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_entry_logoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                new ConnectGUI().setVisible(true);
    }//GEN-LAST:event_btn_data_entry_logoutActionPerformed

    private void btn_add_books_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_books_saveActionPerformed
        // TODO add your handling code here:
        
           String sql;
        String book_name = txt_add_books_book_name.getText();
        String author_name = txt_add_books_author_name.getText();
                
        String category= cmbox_add_books_category.getSelectedItem().toString();
        String language= cmbox_add_books_language.getSelectedItem().toString();
        
        if(book_name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Student ID cannot be Empty");
            return;
        }
        if(author_name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Student Name cannot be Empty");
            return;
        }
        if(category.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Address cannot be Empty");
            return;
        }
        if(language.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Email cannot be Empty");
            return;
        }
              
        
        sql = "Insert into add_books (book_name,author_name,category,language) values ('" +  book_name + "','" + author_name +"','" + category + "','" + language + "')";
         try
      {
           conn = Connect.ConnectDB();
           pst = conn.prepareStatement(sql);
           pst.executeUpdate();
        
           txt_add_books_book_name.setText("");
           txt_add_books_author_name.setText("");
          
           cmbox_add_books_category.removeAllItems();
           cmbox_add_books_language.removeAllItems();
           conn.close();
      }
     catch(SQLException | HeadlessException e)
     {
          JOptionPane.showMessageDialog(null, e);          
     }
        
    }//GEN-LAST:event_btn_add_books_saveActionPerformed

   // static int showFirmAccount=0;
  //  static String patient_name_temp= "";    static boolean toggle_value=true;  
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
    private javax.swing.JButton btn_add_books_save;
    private javax.swing.JButton btn_data_entry_borrow;
    private javax.swing.JButton btn_data_entry_logout;
    private javax.swing.JButton btn_data_entry_return;
    private javax.swing.JButton btn_data_entry_search_books;
    private javax.swing.JButton btn_data_entry_students;
    private javax.swing.JComboBox cmbox_add_books_category;
    private javax.swing.JComboBox cmbox_add_books_language;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel lbl_add_book;
    private javax.swing.JLabel lbl_daily_data_entry_date;
    private javax.swing.JLabel lbl_daily_data_entry_logged_user;
    private javax.swing.JLabel lbl_daily_data_entry_user_name;
    private javax.swing.JLabel lbl_data_entry_date1;
    private javax.swing.JLabel lbl_data_entry_welcome;
    private javax.swing.JLabel lbl_update_user_;
    private javax.swing.JTabbedPane tabpan_daily_data_entry;
    private javax.swing.JTabbedPane tabpane_user_account;
    private javax.swing.JTextField txt1_user_account_user_name;
    private javax.swing.JPasswordField txt2_user_account_password;
    private javax.swing.JTextField txt_add_books_author_name;
    private javax.swing.JTextField txt_add_books_book_name;
    // End of variables declaration//GEN-END:variables
}
