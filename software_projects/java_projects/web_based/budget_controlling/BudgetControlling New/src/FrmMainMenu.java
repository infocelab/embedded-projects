/*
 * FrmMainMenu.java
 * Created on April 7, 2008, 5:12 PM
 * @author  kusno
 */
import javax.swing.JOptionPane;
import javax.swing.*; 
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FrmMainMenu extends javax.swing.JFrame {
    private Date activeDate = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
    private String date = sdf.format(activeDate) ;    
    private String PROP_FILE = "initial.ini";
    
    int top = 70;
    int left = 150;
   
    private static Properties loadProperties(String sFile) {
        Properties p = new Properties();
            try {
            FileInputStream in = new FileInputStream(sFile);
            p.load(in);            
            in.close();
        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, iOException);
        }
        return p;        
    }
         
    void setLookAndFeel()
    {
        Properties p2 = new Properties();
        p2 = loadProperties(PROP_FILE);
        String skin = p2.getProperty("Skin");
        if(skin==null)
        {
            skin = "0";
        }        
        int skinInt = Integer.valueOf(skin).intValue();
        try                   
        {
           if(skinInt==0)
           {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  
           }else
           if(skinInt==1)
           {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); 
           }  
           else
           {
               UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");                
           }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }       
    }  

    public FrmMainMenu() {
        Data user = new Data(); 
        String UserID;
        String UserName;       
        UserID = user.getUserID().trim();
        UserName = user.getUserName().trim();  
       
        setLookAndFeel();
        initComponents();  
        txtUserID.setText(UserID.toString().trim());
        txtUserName.setText(UserName.toString().trim());             
        lbDate.setText(date);    
        setTime();
        lbYear.setText(user.getActivePeriod());
        checkUserAuthorization();
    }   
    
    void checkUserAuthorization()
    {
        Data User = new Data();         
        mnMasterUser.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-001",Data.typeOfAction.View));
        mnUserFunction.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-002",Data.typeOfAction.View));
        mnMasterBudgetGroup.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-003",Data.typeOfAction.View));
        mnMasterBudgetDetail.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-004",Data.typeOfAction.View));
        mnMasterTitle.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-005",Data.typeOfAction.View));
        mnMasterEmployee.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-006",Data.typeOfAction.View));
        
        mnTransactionBeginningBalance.setEnabled(User.UserRight(txtUserID.getText().trim(), "TSK-001",Data.typeOfAction.View));
        mnTransactionBudgetUsage.setEnabled(User.UserRight(txtUserID.getText().trim(), "TSK-002",Data.typeOfAction.View));
        mnTransactionBudgetTransfer.setEnabled(User.UserRight(txtUserID.getText().trim(), "TSK-003",Data.typeOfAction.View));               
        mnTransactionEndofYear.setEnabled(User.UserRight(txtUserID.getText().trim(), "TSK-004",Data.typeOfAction.View));               
        
        mnRptMasterBudget.setEnabled(User.UserRight(txtUserID.getText().trim(), "RPT-001",Data.typeOfAction.View));
        mnRptBudgetUsage.setEnabled(User.UserRight(txtUserID.getText().trim(), "RPT-002",Data.typeOfAction.View));
        mnRptTrxBudgetUsage.setEnabled(User.UserRight(txtUserID.getText().trim(), "RPT-003",Data.typeOfAction.View));               
        mnRptTrxBudgetTransfer.setEnabled(User.UserRight(txtUserID.getText().trim(), "RPT-004",Data.typeOfAction.View));                               
    }
    
    void setTime() 
    {
	ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            String zero_hour = "", zero_minute = "", zero_second = "";    	   
            Date dateTime = new Date();
            int int_hour = dateTime.getHours();
            int int_minute = dateTime.getMinutes();
	    int int_second = dateTime.getSeconds();    	    
            if (int_hour <= 9) zero_hour = "0";
            if (int_minute <= 9) zero_minute = "0";     
            if (int_second <= 9) zero_second = "0";        
	    String hour = zero_hour + Integer.toString(int_hour);
            String minute = zero_minute + Integer.toString(int_minute);
            String second = zero_second + Integer.toString(int_second);        
            lbHour.setText(hour + ":" + minute + ":" + second + " ");
            }
   	};
    	new Timer(1000, taskPerformer).start();
    }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        txtUserID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lbHour = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbYear = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnMaster = new javax.swing.JMenu();
        mnMasterTitle = new javax.swing.JMenuItem();
        mnMasterEmployee = new javax.swing.JMenuItem();
        mnMasterBudgetGroup = new javax.swing.JMenuItem();
        mnMasterBudgetDetail = new javax.swing.JMenuItem();
        mnTransaction = new javax.swing.JMenu();
        mnTransactionBeginningBalance = new javax.swing.JMenuItem();
        mnTransactionBudgetUsage = new javax.swing.JMenuItem();
        mnTransactionBudgetTransfer = new javax.swing.JMenuItem();
        mnTransactionEndofYear = new javax.swing.JMenuItem();
        mnLaporan = new javax.swing.JMenu();
        mnRptMasterBudget = new javax.swing.JMenuItem();
        mnRptBudgetUsage = new javax.swing.JMenuItem();
        mnRptTrxBudgetUsage = new javax.swing.JMenuItem();
        mnRptTrxBudgetTransfer = new javax.swing.JMenuItem();
        mnUser = new javax.swing.JMenu();
        mnMasterUser = new javax.swing.JMenuItem();
        mnUserFunction = new javax.swing.JMenuItem();
        mnChangePassword = new javax.swing.JMenuItem();
        mnExit = new javax.swing.JMenu();
        mnLogOff = new javax.swing.JMenuItem();
        mnExitExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OPC Budget Controlling Program");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                FrmMainMenu.this.windowClosing(evt);
            }
        });

        jToolBar1.setRollover(true);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        txtUserID.setBackground(new java.awt.Color(204, 255, 204));
        txtUserID.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtUserID.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        txtUserID.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("User ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("User Name");

        txtUserName.setBackground(new java.awt.Color(204, 255, 204));
        txtUserName.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtUserName.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        txtUserName.setEnabled(false);

        lbHour.setBackground(new java.awt.Color(51, 51, 255));
        lbHour.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbHour.setForeground(new java.awt.Color(51, 255, 51));

        lbDate.setBackground(new java.awt.Color(51, 51, 255));
        lbDate.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbDate.setForeground(new java.awt.Color(51, 255, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Budget Year");

        lbYear.setBackground(new java.awt.Color(51, 51, 255));
        lbYear.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbYear.setForeground(new java.awt.Color(51, 255, 51));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtUserID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(26, 26, 26)
                .add(lbDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lbHour, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(75, 75, 75)
                .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lbYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(txtUserID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabel1)
                .add(txtUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabel2)
                .add(lbDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(lbHour, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(lbYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabel3))
        );

        jToolBar1.add(jPanel1);

        mnMaster.setBackground(new java.awt.Color(204, 255, 255));
        mnMaster.setText("Master");
        mnMaster.setFont(new java.awt.Font("Tahoma", 1, 12));

        mnMasterTitle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mnMasterTitle.setBackground(new java.awt.Color(255, 255, 204));
        mnMasterTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnMasterTitle.setText("Title");
        mnMasterTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMasterTitleActionPerformed(evt);
            }
        });
        mnMaster.add(mnMasterTitle);

        mnMasterEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        mnMasterEmployee.setBackground(new java.awt.Color(255, 255, 204));
        mnMasterEmployee.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnMasterEmployee.setText("Employee");
        mnMasterEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMasterEmployeeActionPerformed(evt);
            }
        });
        mnMaster.add(mnMasterEmployee);

        mnMasterBudgetGroup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mnMasterBudgetGroup.setBackground(new java.awt.Color(255, 255, 204));
        mnMasterBudgetGroup.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnMasterBudgetGroup.setText("Budget Group");
        mnMasterBudgetGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMasterBudgetGroupActionPerformed(evt);
            }
        });
        mnMaster.add(mnMasterBudgetGroup);

        mnMasterBudgetDetail.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mnMasterBudgetDetail.setBackground(new java.awt.Color(255, 255, 204));
        mnMasterBudgetDetail.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnMasterBudgetDetail.setText("Budget Detail");
        mnMasterBudgetDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMasterBudgetDetailActionPerformed(evt);
            }
        });
        mnMaster.add(mnMasterBudgetDetail);

        jMenuBar1.add(mnMaster);

        mnTransaction.setBackground(new java.awt.Color(204, 255, 255));
        mnTransaction.setText("Transaction");
        mnTransaction.setFont(new java.awt.Font("Tahoma", 1, 12));

        mnTransactionBeginningBalance.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnTransactionBeginningBalance.setBackground(new java.awt.Color(255, 255, 204));
        mnTransactionBeginningBalance.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnTransactionBeginningBalance.setText("Beginning Balance");
        mnTransactionBeginningBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransactionBeginningBalanceActionPerformed(evt);
            }
        });
        mnTransaction.add(mnTransactionBeginningBalance);

        mnTransactionBudgetUsage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnTransactionBudgetUsage.setBackground(new java.awt.Color(255, 255, 204));
        mnTransactionBudgetUsage.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnTransactionBudgetUsage.setText("Budget Usage");
        mnTransactionBudgetUsage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransactionBudgetUsageActionPerformed(evt);
            }
        });
        mnTransaction.add(mnTransactionBudgetUsage);

        mnTransactionBudgetTransfer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mnTransactionBudgetTransfer.setBackground(new java.awt.Color(255, 255, 204));
        mnTransactionBudgetTransfer.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnTransactionBudgetTransfer.setText("Budget Transfer");
        mnTransactionBudgetTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransactionBudgetTransferActionPerformed(evt);
            }
        });
        mnTransaction.add(mnTransactionBudgetTransfer);

        mnTransactionEndofYear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mnTransactionEndofYear.setBackground(new java.awt.Color(255, 255, 204));
        mnTransactionEndofYear.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnTransactionEndofYear.setText("End of Year");
        mnTransactionEndofYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransactionEndofYearActionPerformed(evt);
            }
        });
        mnTransaction.add(mnTransactionEndofYear);

        jMenuBar1.add(mnTransaction);

        mnLaporan.setBackground(new java.awt.Color(204, 255, 255));
        mnLaporan.setText("Report");
        mnLaporan.setFont(new java.awt.Font("Tahoma", 1, 12));

        mnRptMasterBudget.setBackground(new java.awt.Color(255, 255, 204));
        mnRptMasterBudget.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnRptMasterBudget.setText("Master Budget");
        mnRptMasterBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRptMasterBudgetActionPerformed(evt);
            }
        });
        mnLaporan.add(mnRptMasterBudget);

        mnRptBudgetUsage.setBackground(new java.awt.Color(255, 255, 204));
        mnRptBudgetUsage.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnRptBudgetUsage.setText("Budget Detail Per Month");
        mnRptBudgetUsage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRptBudgetUsageActionPerformed(evt);
            }
        });
        mnLaporan.add(mnRptBudgetUsage);

        mnRptTrxBudgetUsage.setBackground(new java.awt.Color(255, 255, 204));
        mnRptTrxBudgetUsage.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnRptTrxBudgetUsage.setText("Trx. Budget Usage");
        mnRptTrxBudgetUsage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRptTrxBudgetUsageActionPerformed(evt);
            }
        });
        mnLaporan.add(mnRptTrxBudgetUsage);

        mnRptTrxBudgetTransfer.setBackground(new java.awt.Color(255, 255, 204));
        mnRptTrxBudgetTransfer.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnRptTrxBudgetTransfer.setText("Trx. Budget Transfer");
        mnRptTrxBudgetTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRptTrxBudgetTransferActionPerformed(evt);
            }
        });
        mnLaporan.add(mnRptTrxBudgetTransfer);

        jMenuBar1.add(mnLaporan);

        mnUser.setBackground(new java.awt.Color(204, 255, 255));
        mnUser.setText("Users Management");
        mnUser.setFont(new java.awt.Font("Tahoma", 1, 12));

        mnMasterUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_MASK));
        mnMasterUser.setBackground(new java.awt.Color(255, 255, 204));
        mnMasterUser.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnMasterUser.setText("User");
        mnMasterUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMasterUserActionPerformed(evt);
            }
        });
        mnUser.add(mnMasterUser);

        mnUserFunction.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.CTRL_MASK));
        mnUserFunction.setBackground(new java.awt.Color(255, 255, 204));
        mnUserFunction.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnUserFunction.setText("User Functions");
        mnUserFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUserFunctionActionPerformed(evt);
            }
        });
        mnUser.add(mnUserFunction);

        mnChangePassword.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, java.awt.event.InputEvent.CTRL_MASK));
        mnChangePassword.setBackground(new java.awt.Color(255, 255, 204));
        mnChangePassword.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnChangePassword.setText("Change Password");
        mnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnChangePasswordActionPerformed(evt);
            }
        });
        mnUser.add(mnChangePassword);

        jMenuBar1.add(mnUser);

        mnExit.setBackground(new java.awt.Color(204, 255, 255));
        mnExit.setText("Exit");
        mnExit.setFont(new java.awt.Font("Tahoma", 1, 12));

        mnLogOff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnLogOff.setBackground(new java.awt.Color(255, 255, 204));
        mnLogOff.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnLogOff.setText("Log Off");
        mnLogOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLogOffActionPerformed(evt);
            }
        });
        mnExit.add(mnLogOff);

        mnExitExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnExitExit.setBackground(new java.awt.Color(255, 255, 204));
        mnExitExit.setFont(new java.awt.Font("Tahoma", 1, 12));
        mnExitExit.setText("Exit");
        mnExitExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnExitExitActionPerformed(evt);
            }
        });
        mnExit.add(mnExitExit);

        jMenuBar1.add(mnExit);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(649, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void mnMasterUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMasterUserActionPerformed
        FrmMasterUser frmUser = new FrmMasterUser();
        frmUser.setBounds(left,top,450,565);
        frmUser.setVisible(true);
    }//GEN-LAST:event_mnMasterUserActionPerformed

    private void mnMasterBudgetGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMasterBudgetGroupActionPerformed
        FrmMasterBudgetGroup frm = new FrmMasterBudgetGroup();
        frm.setBounds(left,top,520,580);
        frm.setVisible(true);
}//GEN-LAST:event_mnMasterBudgetGroupActionPerformed

    private void mnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnChangePasswordActionPerformed
        FrmChangePassword frmPassword = new FrmChangePassword();
        frmPassword.setBounds(left,top,290,180);
        frmPassword.setVisible(true);                
}//GEN-LAST:event_mnChangePasswordActionPerformed

    private void mnMasterBudgetDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMasterBudgetDetailActionPerformed
        FrmMasterBudget frmBudget = new FrmMasterBudget();
        frmBudget.setBounds(left,top,610,630);
        frmBudget.setVisible(true);
}//GEN-LAST:event_mnMasterBudgetDetailActionPerformed

    private void mnUserFunctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUserFunctionActionPerformed
        FrmMasterUserFunction frmFunction = new FrmMasterUserFunction();
        frmFunction.setBounds(left,top,660,400);
        frmFunction.setVisible(true);
}//GEN-LAST:event_mnUserFunctionActionPerformed

    private void mnTransactionBeginningBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransactionBeginningBalanceActionPerformed
        FrmTrxBeginningBalance frmTrx = new FrmTrxBeginningBalance();
        frmTrx.setBounds(left,top,560,580);
        frmTrx.setVisible(true);
}//GEN-LAST:event_mnTransactionBeginningBalanceActionPerformed

    private void mnTransactionBudgetUsageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransactionBudgetUsageActionPerformed
        FrmTrxBudgetUsage frmTrx = new FrmTrxBudgetUsage();
        frmTrx.setBounds(left,top,560,540);
        frmTrx.setVisible(true);
}//GEN-LAST:event_mnTransactionBudgetUsageActionPerformed

    private void mnTransactionEndofYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransactionEndofYearActionPerformed
        FrmTrxEndofYear frmTrx = new FrmTrxEndofYear();
        frmTrx.setBounds(left,top,360,250);
        frmTrx.setVisible(true);
}//GEN-LAST:event_mnTransactionEndofYearActionPerformed

    private void mnTransactionBudgetTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransactionBudgetTransferActionPerformed
        FrmTrxBudgetTransfer frmTrx = new FrmTrxBudgetTransfer();
        frmTrx.setBounds(left,top,570,460);
        frmTrx.setVisible(true);
}//GEN-LAST:event_mnTransactionBudgetTransferActionPerformed

    private void mnRptMasterBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRptMasterBudgetActionPerformed
        FrmRptMasterBudget frmRpt = new FrmRptMasterBudget("RPT-001");
        frmRpt.setBounds(left,top,400,210);
        frmRpt.setVisible(true);
}//GEN-LAST:event_mnRptMasterBudgetActionPerformed

    private void mnRptBudgetUsageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRptBudgetUsageActionPerformed
        FrmRptMasterBudget frmRpt = new FrmRptMasterBudget("RPT-002");
        frmRpt.setBounds(left,top,400,210);
        frmRpt.setVisible(true);
}//GEN-LAST:event_mnRptBudgetUsageActionPerformed

    private void mnLogOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLogOffActionPerformed
       int reply=JOptionPane.showConfirmDialog(this,"Do you want to re-login ?","Budget",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
         if(reply==JOptionPane.YES_OPTION)
         {  
            setVisible(false);
            dispose();
            FrmLogin login = new FrmLogin();        
            login.setVisible(true);
            login.pack();
         }
    }//GEN-LAST:event_mnLogOffActionPerformed

    private void mnExitExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnExitExitActionPerformed
        int reply=JOptionPane.showConfirmDialog(this,"Do you want to exit from the System ?","Budget",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(reply==JOptionPane.YES_OPTION)
        {
            dispose();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);         
        }
}//GEN-LAST:event_mnExitExitActionPerformed

    private void mnRptTrxBudgetUsageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRptTrxBudgetUsageActionPerformed
        FrmRptBudgetUsage frmRpt = new FrmRptBudgetUsage();
        frmRpt.setBounds(left,top,400,190);
        frmRpt.setVisible(true);
}//GEN-LAST:event_mnRptTrxBudgetUsageActionPerformed

    private void mnRptTrxBudgetTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRptTrxBudgetTransferActionPerformed
        FrmRptBudgetTransfer frmRpt = new FrmRptBudgetTransfer();
        frmRpt.setBounds(left,top,260,160);
        frmRpt.setVisible(true);
}//GEN-LAST:event_mnRptTrxBudgetTransferActionPerformed

    private void windowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosing
       System.exit(0);            
    }//GEN-LAST:event_windowClosing

    private void mnMasterEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMasterEmployeeActionPerformed
       FrmMasterEmployee frm = new FrmMasterEmployee();
       frm.setBounds(left,top,610,580);
       frm.setVisible(true);
    }//GEN-LAST:event_mnMasterEmployeeActionPerformed

    private void mnMasterTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMasterTitleActionPerformed
       FrmMasterTitle frm = new FrmMasterTitle();
       frm.setBounds(left,top,550,550);
       frm.setVisible(true);
    }//GEN-LAST:event_mnMasterTitleActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbHour;
    private javax.swing.JLabel lbYear;
    private javax.swing.JMenuItem mnChangePassword;
    private javax.swing.JMenu mnExit;
    private javax.swing.JMenuItem mnExitExit;
    private javax.swing.JMenu mnLaporan;
    private javax.swing.JMenuItem mnLogOff;
    private javax.swing.JMenu mnMaster;
    private javax.swing.JMenuItem mnMasterBudgetDetail;
    private javax.swing.JMenuItem mnMasterBudgetGroup;
    private javax.swing.JMenuItem mnMasterEmployee;
    private javax.swing.JMenuItem mnMasterTitle;
    private javax.swing.JMenuItem mnMasterUser;
    private javax.swing.JMenuItem mnRptBudgetUsage;
    private javax.swing.JMenuItem mnRptMasterBudget;
    private javax.swing.JMenuItem mnRptTrxBudgetTransfer;
    private javax.swing.JMenuItem mnRptTrxBudgetUsage;
    private javax.swing.JMenu mnTransaction;
    private javax.swing.JMenuItem mnTransactionBeginningBalance;
    private javax.swing.JMenuItem mnTransactionBudgetTransfer;
    private javax.swing.JMenuItem mnTransactionBudgetUsage;
    private javax.swing.JMenuItem mnTransactionEndofYear;
    private javax.swing.JMenu mnUser;
    private javax.swing.JMenuItem mnUserFunction;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
