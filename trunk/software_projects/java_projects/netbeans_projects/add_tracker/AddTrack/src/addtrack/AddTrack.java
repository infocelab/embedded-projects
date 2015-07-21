package addtrack;

import java.io.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class AddTrack extends JFrame implements Runnable {
    public final static String DB_CLASS = "sun.jdbc.odbc.JdbcOdbcDriver";
    
    public final static int WIN_WIDTH = 500;
    public final static int WIN_HEIGHT = 600;
    
    public final static String WIN_TITLE = "AddTrack 1.0v";
    
    public final static String WIN_ICON = "icon.gif";
    public final static String M_LOGO = "mlogo.jpg";
    public final static String NEW_LOGO = "newlogo.jpg";
    
    private final static String U_NAME = "";
    private final static String U_PASS = "";
    
    public final static String DEV_IMG = "developer.jpg";
    
    public final static Color BK_CLR = new Color(230, 255, 255);
    
    public final static String DB_CON = "jdbc:odbc:AddTrackData";
    
    private JTabbedPane mainWin;
    
    private JPanel logPanel, manPanel, delType, serPanel, serType, devPanel, 
            pnl;
    
    private JLabel logHead, logTitle, logMLogo, logNewLogo, logName, logPass,
            addMKLabel, addDateLabel, addTypeLabel, addIDLabel, addPriceLabel,
            addDescLabel, delIDLabel, serIDLabel, serDateLabel, serPriceLabel,
            serDescLabel, devImage, devHead, devSub, devTitle, devName,
            devMobile, devEmail1, devEmail2, serMKLabel, serRecLabel;
    
    private JTextField uName, addMK, addDay, addMonth, addYear, addID, addPrice,
            delID, serID, serDay, serMonth, serYear, serPrice;
    
    private JPasswordField uPass;
    
    private JButton login, add, addReset, delete, search, save, clear, exit;
    
    private JComboBox addType;
    
    private JTextArea addDesc, serDesc;
    
    private JScrollPane addDescScroll, serDescScroll;
    
    private JRadioButton delMK, delME, delAN, serMK, serME, serAN;
    
    private ButtonGroup delGrp, serGrp;
    
    private JDialog dialog;
    
    private String searchMK, searchID;
    
    public void run() {
        prepareMainWindow();
    }
    
    private void prepareMainWindow() {
        setSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        setTitle(WIN_TITLE);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        setIconImage(new ImageIcon(WIN_ICON).getImage());
        
        mainWin = new JTabbedPane(JTabbedPane.TOP,
                JTabbedPane.SCROLL_TAB_LAYOUT);
        mainWin.setBackground(Color.WHITE);
        
        logPanel = makeLoginPanel();
        mainWin.addTab("Login", logPanel);
        
        manPanel = makeManagePanel();
        mainWin.addTab("Manage", manPanel);
        
        serPanel = makeSearchPanel();
        mainWin.addTab("Search", serPanel);
        
        devPanel = makeDeveloperPanel();
        mainWin.addTab("Developer", devPanel);
        
        mainWin.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                int index = mainWin.getSelectedIndex();
                
                //Jumping between tabs means the data on the screen elemets are
                //lost.
                switch (index) {
                    case 1:
                        addType.setSelectedIndex(0);
                        addMK.setText("");
                        addID.setText("");
                        addDay.setText("");
                        addMonth.setText("");
                        addYear.setText("");
                        addPrice.setText("");
                        addDesc.setText("");
                        delMK.setSelected(true);
                        delME.setSelected(false);
                        delAN.setSelected(false);
                        delID.setText("");
                        addMK.requestFocus();
                        break;
                        
                    case 2:
                        serMK.setSelected(true);
                        serME.setSelected(false);
                        serAN.setSelected(false);
                        serID.setText("");
                        serDay.setText("");
                        serMonth.setText("");
                        serYear.setText("");
                        serPrice.setText("");
                        serDesc.setText("");
                        serMKLabel.setText("");
                        serMKLabel.setSize(serMKLabel.getPreferredSize().width,
                                serMKLabel.getPreferredSize().height);
                        serRecLabel.setText("");
                        serRecLabel.setSize(
                                serRecLabel.getPreferredSize().width,
                                serRecLabel.getPreferredSize().height);
                        searchMK = "";
                        searchID = "";
                        serID.requestFocus();
                        break;
                }
            }
        });
        
        mainWin.setEnabledAt(0, true);
        mainWin.setEnabledAt(1, false);
        mainWin.setEnabledAt(2, false);
        mainWin.setEnabledAt(3, true); 
        mainWin.setSelectedIndex(0);
                
        add(mainWin);
        
        setVisible(true);
        
        uName.requestFocus();
    }
    
    private JPanel makeLoginPanel() {
        JPanel pan = new JPanel();
        pan.setBackground(Color.WHITE);
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createTitledBorder("System Login"));
        
        logHead = new JLabel("Mobitel AddTrack");
        logHead.setBackground(Color.WHITE);
        logHead.setFont(logHead.getFont().deriveFont(Font.BOLD, 45f));
        logHead.setBounds((WIN_WIDTH - logHead.getPreferredSize().width) / 2,
                40, logHead.getPreferredSize().width,
                logHead.getPreferredSize().height);
        pan.add(logHead);
        
        logTitle = new JLabel("Copyright \u00A9 2008");
        logTitle.setBackground(Color.WHITE);
        logTitle.setFont(logTitle.getFont().deriveFont(Font.PLAIN, 14f));
        logTitle.setBounds((WIN_WIDTH - logTitle.getPreferredSize().width) / 2,
                100, logTitle.getPreferredSize().width,
                logTitle.getPreferredSize().height);
        pan.add(logTitle);
        
        logName = new JLabel("User Name           :");
        logName.setBackground(Color.WHITE);
        logName.setBounds(100, 200, logName.getPreferredSize().width,
                logName.getPreferredSize().height);
        pan.add(logName);
        
        uName = new JTextField(10);
        uName.setBackground(Color.WHITE);
        uName.setBounds(250, 200, uName.getPreferredSize().width,
                uName.getPreferredSize().height);
        uName.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                uName.setBackground(BK_CLR);
                uName.selectAll();
                uPass.setText("");
            }
            
            public void focusLost(FocusEvent fe) {
                uName.setBackground(Color.WHITE);
            }
        });
        uName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    uPass.requestFocus();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    uName.setText("");
                }
            }
        });
        pan.add(uName);
        
        logPass = new JLabel("User Password   :");
        logPass.setBackground(Color.WHITE);
        logPass.setBounds(100, 270, logPass.getPreferredSize().width,
                logPass.getPreferredSize().height);
        pan.add(logPass);
        
        uPass = new JPasswordField(10);
        uPass.setBackground(Color.WHITE);
        uPass.setBounds(250, 270, uPass.getPreferredSize().width,
                uPass.getPreferredSize().height);
        uPass.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                uPass.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                uPass.setBackground(Color.WHITE);
            }
        });
        uPass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    login.doClick();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    uPass.setText("");
                }
            }
        });
        pan.add(uPass);
        
        login = new JButton("            Login            ");
        login.setBounds((WIN_WIDTH - login.getPreferredSize().width) / 2, 370,
                login.getPreferredSize().width,
                login.getPreferredSize().height);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = uName.getText();
                String pass = new String(uPass.getPassword());
                String curName = "";
                String curPass = "";
                
                try {
                    FileReader fin = new FileReader("fksystfk.sys");
                    BufferedReader bin = new BufferedReader(fin);
                    curName = bin.readLine();
                    curPass = bin.readLine();
                } catch (FileNotFoundException exc) {
                } catch (IOException exc) {
                }
                
                if (name.equals(curName) && pass.equals(curPass)) {
                    mainWin.setEnabledAt(0, false);
                    mainWin.setEnabledAt(1, true);
                    mainWin.setEnabledAt(2, true);
                    mainWin.setSelectedIndex(3);
                } else {
                    showInvalidPassword();
                    uName.setText("");
                    uPass.setText("");
                    uName.requestFocus();
                }
            }
        });
        pan.add(login);
                
        logMLogo = new JLabel(new ImageIcon(M_LOGO));
        logMLogo.setBackground(Color.WHITE);
        logMLogo.setBounds(35, 450, logMLogo.getPreferredSize().width,
                logMLogo.getPreferredSize().height);
        pan.add(logMLogo);
        
        logNewLogo = new JLabel(new ImageIcon(NEW_LOGO));
        logNewLogo.setBackground(Color.WHITE);
        logNewLogo.setBounds(360, 430, logNewLogo.getPreferredSize().width,
                logNewLogo.getPreferredSize().height);
        pan.add(logNewLogo);
        
        return pan;
    }
    
    private JPanel makeManagePanel() {
        JPanel pan = new JPanel();
        pan.setBackground(Color.WHITE);
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createTitledBorder("System Manage"));
        
        JPanel addPanel = makeAddPanel();
        pan.add(addPanel);
        
        JPanel delPanel = makeDeletePanel();
        pan.add(delPanel);
        
        return pan;
    }
    
    private JPanel makeAddPanel() {
        JPanel pan = new JPanel();
        pan.setBackground(Color.WHITE);
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createTitledBorder("Add Record"));
        pan.setBounds(15, 20, WIN_WIDTH - 40, WIN_HEIGHT / 2);
        
        addMKLabel = new JLabel("MK Number   :");
        addMKLabel.setBackground(Color.WHITE);
        addMKLabel.setBounds(20, 25, addMKLabel.getPreferredSize().width,
                addMKLabel.getPreferredSize().height);
        pan.add(addMKLabel);
        
        addMK = new JTextField(10);
        addMK.setBackground(Color.WHITE);
        addMK.setBounds(100, 25, addMK.getPreferredSize().width,
                addMK.getPreferredSize().height);
        addMK.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    addDay.requestFocus();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    addMK.setText("");
                }
            }
        });
        addMK.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                addMK.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                addMK.setBackground(Color.WHITE);
            }
        });
        pan.add(addMK);
        
        addDateLabel = new JLabel("Date   :         dd              mm       " +
                "            yyyy");
        addDateLabel.setBackground(Color.WHITE);
        addDateLabel.setBounds(230, 25, addDateLabel.getPreferredSize().width,
                addDateLabel.getPreferredSize().height);
        pan.add(addDateLabel);
        
        addDay = new JTextField(2);
        addDay.setBackground(Color.WHITE);
        addDay.setBounds(270, 25, addDay.getPreferredSize().width,
                addDay.getPreferredSize().height);
        addDay.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    addMonth.requestFocus();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    addDay.setText("");
                }
            }
        });
        addDay.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                addDay.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                addDay.setBackground(Color.WHITE);
            }
        });
        pan.add(addDay);
        
        addMonth = new JTextField(2);
        addMonth.setBackground(Color.WHITE);
        addMonth.setBounds(325, 25, addMonth.getPreferredSize().width,
                addMonth.getPreferredSize().height);
        addMonth.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    addYear.requestFocus();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    addMonth.setText("");
                }
            }
        });
        addMonth.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                addMonth.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                addMonth.setBackground(Color.WHITE);
            }
        });
        pan.add(addMonth);
        
        addYear = new JTextField(4);
        addYear.setBackground(Color.WHITE);
        addYear.setBounds(380, 25, addYear.getPreferredSize().width,
                addYear.getPreferredSize().height);
        addYear.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    addType.requestFocus();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    addYear.setText("");
                }
            }
        });
        addYear.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                addYear.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                addYear.setBackground(Color.WHITE);
            }
        });
        pan.add(addYear);
        
        
        addTypeLabel = new JLabel("Record Type :");
        addTypeLabel.setBackground(Color.WHITE);
        addTypeLabel.setBounds(20, 65, addTypeLabel.getPreferredSize().width,
                addTypeLabel.getPreferredSize().height);
        pan.add(addTypeLabel);
        
        addType = new JComboBox();
        addType.setBackground(Color.WHITE);
        addType.addItem("");
        addType.addItem("Artwork");
        addType.addItem("Media Estimate");
        addType.setEditable(false);
        addType.setBounds(100, 60, addType.getPreferredSize().width,
                addType.getPreferredSize().height);
        addType.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    addID.requestFocus();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    addType.setSelectedIndex(0);
                }
            }
        });
        addType.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                addType.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                addType.setBackground(Color.WHITE);
            }
        });
        pan.add(addType);
        
        addIDLabel = new JLabel("ID        :");
        addIDLabel.setBackground(Color.WHITE);
        addIDLabel.setBounds(230, 60, addIDLabel.getPreferredSize().width,
                addIDLabel.getPreferredSize().height);
        pan.add(addIDLabel);
        
        addID = new JTextField(10);
        addID.setBackground(Color.WHITE);
        addID.setBounds(270, 60, addID.getPreferredSize().width,
                addID.getPreferredSize().height);
        addID.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    addPrice.requestFocus();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    addID.setText("");
                }
            }
        });
        addID.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                addID.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                addID.setBackground(Color.WHITE);
            }
        });
        pan.add(addID);
        
        addPriceLabel = new JLabel("Price               :");
        addPriceLabel.setBackground(Color.WHITE);
        addPriceLabel.setBounds(20, 100, addPriceLabel.getPreferredSize().width,
                addPriceLabel.getPreferredSize().height);
        pan.add(addPriceLabel);
        
        addPrice = new JTextField(10);
        addPrice.setBackground(Color.WHITE);
        addPrice.setBounds(100, 100, addPrice.getPreferredSize().width,
                addPrice.getPreferredSize().height);
        addPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    addDesc.requestFocus();
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    addPrice.setText("");
                }
            }
        });
        addPrice.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                addPrice.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                addPrice.setBackground(Color.WHITE);
            }
        });
        pan.add(addPrice);
        
        addDescLabel = new JLabel("Description   :");
        addDescLabel.setBackground(Color.WHITE);
        addDescLabel.setBounds(20, 140, addDescLabel.getPreferredSize().width,
                addDescLabel.getPreferredSize().height);
        
        pan.add(addDescLabel);
        
        addDesc = new JTextArea(10, 30);
        addDesc.setBackground(Color.WHITE);
        addDesc.setEditable(true);
        addDesc.setLineWrap(true);
        addDesc.setWrapStyleWord(true);
        addDesc.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    addDesc.setText("");
                }
            }
        });
        addDesc.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                addDesc.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                addDesc.setBackground(Color.WHITE);
            }
        });
        
        addDescScroll = new JScrollPane(addDesc);
        addDescScroll.setBackground(Color.WHITE);
        addDescScroll.setBounds(100, 140,
                addDescScroll.getPreferredSize().width, 100);
        
        pan.add(addDescScroll);
        
        add = new JButton("Add Record");
        add.setBounds(100, 255, add.getPreferredSize().width,
                add.getPreferredSize().height);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String mkNumber = "MK";
                mkNumber += addMK.getText();
                
                try {
                    Connection con = DriverManager.getConnection(DB_CON);
                    Statement stmt = con.createStatement();
                    
                    ResultSet rslt = stmt.executeQuery("SELECT * FROM " +
                            "order_data WHERE mk_number = \'" + mkNumber + 
                            "\';");
                    
                    if (!rslt.next()) {
                        String recNumber = "";
                        
                        switch (addType.getSelectedIndex()) {
                            case 1:
                                recNumber = "AWEST";
                                break;
                            case 2:
                                recNumber = "PE";
                                break;
                        }
                        
                        recNumber += addID.getText();
                        
                        String recDate = "";
                        recDate += addDay.getText();
                        recDate += "-";
                        recDate += addMonth.getText();
                        recDate += "-";
                        recDate += addYear.getText();
                        
                        String recPrice = addPrice.getText();
                        
                        String recDesc = addDesc.getText();
                        
                        stmt.executeUpdate("INSERT INTO order_data VALUES (\'" +
                                mkNumber + "\', \'" + recNumber + "\', \'" +
                                recDate + "\', \'" + recPrice + "\', \'" +
                                recDesc + "\');");
                        
                        showRecordAdded();
                    } else {
                        showDuplicateRecord();
                        addReset.doClick();
                    }
                    
                    System.out.println("Before stmt");
                    stmt.close();
                    System.out.println("Before con");
                    con.close();
                } catch (SQLException exc) {
                    showDatabaseError();
                    addReset.doClick();
                }
            }
        });
        pan.add(add);
        
        addReset = new JButton("       Reset       ");
        addReset.setBounds(325, 255, addReset.getPreferredSize().width,
                addReset.getPreferredSize().height);
        addReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                addMK.setText("");
                addType.setSelectedIndex(0);
                addID.setText("");
                addPrice.setText("");
                addDay.setText("");
                addMonth.setText("");
                addYear.setText("");
                addDesc.setText("");
                addMK.requestFocus();
            }
        });
        pan.add(addReset);
        
        return pan;
    }
    
    private JPanel makeDeletePanel() {
        JPanel pan = new JPanel();        
        pan.setBackground(Color.WHITE);
        pan.setBorder(BorderFactory.createTitledBorder("Delete Record"));
        pan.setLayout(null);
        pan.setBounds(15, 330, WIN_WIDTH - 40, 200);
        
        delIDLabel = new JLabel("Record ID:");
        delIDLabel.setBackground(Color.WHITE);
        delIDLabel.setBounds(30, 50, delIDLabel.getPreferredSize().width,
                delIDLabel.getPreferredSize().height);
        pan.add(delIDLabel);
        
        delID = new JTextField(8);
        delID.setBackground(Color.WHITE);
        delID.setBounds(120, 50, delID.getPreferredSize().width,
                delID.getPreferredSize().height);
        delID.setToolTipText("ID of the record to be deleted.");
        delID.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    delID.setText("");
                }
            }
        });
        delID.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                delID.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                delID.setBackground(Color.WHITE);
            }
        });
        pan.add(delID);
        
        delete = new JButton("            Delete Record            ");
        delete.setBounds(30, 130, delete.getPreferredSize().width,
                delete.getPreferredSize().height);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Connection con = DriverManager.getConnection(DB_CON);
                    Statement stmt = con.createStatement();
                    String recID = "";
                    String query = "";
                    
                    if (delMK.isSelected()) {
                        recID = "MK";
                        recID += delID.getText();
                        query = "SELECT * FROM order_data WHERE mk_number = \'"
                                + recID + "\';";
                    } else if (delME.isSelected()) {
                        recID = "PE";
                        recID += delID.getText();
                        query = "SELECT * FROM order_data WHERE rec_id = \'" +
                                recID + "\';";
                    } else {
                        recID = "AWEST";
                        recID += delID.getText();
                        query = "SELECT * FROM order_data WHERE rec_id = \'" +
                                recID + "\';";
                    }
                    
                    ResultSet rslt = stmt.executeQuery(query);
                    
                    if (rslt.next()) {
                        if (delMK.isSelected()) {
                            query = "DELETE FROM order_data WHERE mk_number = "
                                    + "\'" + recID + "\';";
                        } else {
                            query = "DELETE FROM order_data WHERE rec_id = \'" +
                                    recID + "\';";
                        }
                        
                        stmt.executeUpdate(query);
                        showRecordDeleted();
                        delID.setText("");
                        delMK.setSelected(true);
                        delID.requestFocus();
                    } else {
                        showInvalidRecord();
                        delID.setText("");
                        delMK.setSelected(true);
                        delID.requestFocus();
                    }
                    
                    stmt.close();
                    con.close();
                } catch (SQLException exc) {
                    showDatabaseError();
                    delID.setText("");
                    delMK.setSelected(true);
                    delID.requestFocus();
                }
            }
        });
        pan.add(delete);
        
        delType = makeDelTypePanel();
        pan.add(delType);
        
        return pan;
    }
    
    private JPanel makeDelTypePanel() {
        JPanel pan = new JPanel();
        pan.setBackground(Color.WHITE);
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createTitledBorder("Record ID Type"));
        pan.setBounds(230, 20, 215, 160);
        
        delMK = new JRadioButton("MK Number", true);
        delMK.setBackground(Color.WHITE);
        delMK.setBounds(20, 30, delMK.getPreferredSize().width,
                delMK.getPreferredSize().height);
        pan.add(delMK);
        
        delME = new JRadioButton("Media Estimate Number", false);
        delME.setBackground(Color.WHITE);
        delME.setBounds(20, 70, delME.getPreferredSize().width,
                delME.getPreferredSize().height);
        pan.add(delME);
        
        delAN = new JRadioButton("Artwork Number", false);
        delAN.setBackground(Color.WHITE);
        delAN.setBounds(20, 110, delAN.getPreferredSize().width,
                delAN.getPreferredSize().height);
        pan.add(delAN);
        
        delGrp = new ButtonGroup();
        delGrp.add(delMK);
        delGrp.add(delME);
        delGrp.add(delAN);
        
        return pan;
    }
    
    private JPanel makeSearchPanel() {
        JPanel pan = new JPanel();
        pan.setBackground(Color.WHITE);
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createTitledBorder("Search Record"));
        
        serType = makeSerTypePanel();
        pan.add(serType);
        
        serIDLabel = new JLabel("Record ID:");
        serIDLabel.setBackground(Color.WHITE);
        serIDLabel.setBounds(265, 25, serIDLabel.getPreferredSize().width,
                serIDLabel.getPreferredSize().height);
        pan.add(serIDLabel);
        
        serID = new JTextField(10);
        serID.setBackground(Color.WHITE);
        serID.setBounds(340, 25, serID.getPreferredSize().width,
                serID.getPreferredSize().height);
        serID.setToolTipText("ID of the record to search.");
        serID.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                serID.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                serID.setBackground(Color.WHITE);
            }
        });
        pan.add(serID);
        
        serMKLabel = new JLabel("");
        serMKLabel.setBackground(Color.WHITE);
        serMKLabel.setBounds(340, 65, serMKLabel.getPreferredSize().width,
                serMKLabel.getPreferredSize().height);
        pan.add(serMKLabel);
        
        serRecLabel = new JLabel("");
        serRecLabel.setBackground(Color.WHITE);
        serRecLabel.setBounds(340, 105, serRecLabel.getPreferredSize().width,
                serRecLabel.getPreferredSize().height);
        pan.add(serRecLabel);
        
        search = new JButton("Search Record");
        search.setBounds(305, 150, search.getPreferredSize().width,
                search.getPreferredSize().height);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Connection con = DriverManager.getConnection(DB_CON);
                    Statement stmt = con.createStatement();
                    String recID = "";
                    String query = "";
                    
                    if (serMK.isSelected()) {
                        recID = "MK";
                        recID += serID.getText();
                        query = "SELECT * FROM order_data WHERE mk_number = \'"
                                + recID + "\';";
                    } else if (serME.isSelected()) {
                        recID = "PE";
                        recID += serID.getText();
                        query = "SELECT * FROM order_data WHERE rec_id = \'" +
                                recID + "\';";
                    } else {
                        recID = "AWEST";
                        recID += serID.getText();
                        query = "SELECT * FROM order_data WHERE rec_id = \'" +
                                recID + "\';";
                    }
                    
                    ResultSet rslt = stmt.executeQuery(query);
                    
                    if (rslt.next()) {
                        searchMK = rslt.getString("mk_number");
                        serMKLabel.setText("MK: " + searchMK);
                        serMKLabel.setSize(serMKLabel.getPreferredSize().width,
                                serMKLabel.getPreferredSize().height);
                        
                        searchID = rslt.getString("rec_id");
                        serRecLabel.setText("ID: " + searchID);
                        serRecLabel.setSize(
                                serRecLabel.getPreferredSize().width,
                                serRecLabel.getPreferredSize().height);
                        
                        String [] date = rslt.getString("rec_date").split("-");
                        serDay.setText(date[0]);
                        serMonth.setText(date[1]);
                        serYear.setText(date[2]);
                        
                        serPrice.setText(rslt.getString("rec_price"));
                        
                        serDesc.setText(rslt.getString("rec_desc"));
                    } else {
                        showInvalidRecord();
                        clear.doClick();
                    }
                    
                    rslt.close();
                    stmt.close();
                    con.close();
                } catch (SQLException exc) {
                    showDatabaseError();
                    clear.doClick();
                }
            }
        });
        pan.add(search);
        
        serDateLabel = new JLabel("Date:                        /           " +
                "        /");
        serDateLabel.setBackground(Color.WHITE);
        serDateLabel.setBounds(20, 220, serDateLabel.getPreferredSize().width,
                serDateLabel.getPreferredSize().height);
        pan.add(serDateLabel);
        
        serDay = new JTextField(2);
        serDay.setBackground(Color.WHITE);
        serDay.setBounds(80, 220, serDay.getPreferredSize().width,
                serDay.getPreferredSize().height);
        serDay.setToolTipText("Day of the month.");
        serDay.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                serDay.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                serDay.setBackground(Color.WHITE);
            }
        });
        pan.add(serDay);
        
        serMonth = new JTextField(2);
        serMonth.setBackground(Color.WHITE);
        serMonth.setBounds(140, 220, serMonth.getPreferredSize().width,
                serMonth.getPreferredSize().height);
        serMonth.setToolTipText("Month of the year.");
        serMonth.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                serMonth.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                serMonth.setBackground(Color.WHITE);
            }
        });
        pan.add(serMonth);
        
        serYear = new JTextField(4);
        serYear.setBackground(Color.WHITE);
        serYear.setBounds(195, 220, serYear.getPreferredSize().width,
                serYear.getPreferredSize().height);
        serYear.setToolTipText("Enter year.");
        serYear.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                serYear.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                serYear.setBackground(Color.WHITE);
            }
        });
        pan.add(serYear);
        
        serPriceLabel = new JLabel("Price:                                   " +
                "      LKR");
        serPriceLabel.setBackground(Color.WHITE);
        serPriceLabel.setBounds(275, 220, 
                serPriceLabel.getPreferredSize().width,
                serPriceLabel.getPreferredSize().height);
        pan.add(serPriceLabel);
        
        serPrice = new JTextField(10);
        serPrice.setBackground(Color.WHITE);
        serPrice.setBounds(315, 220, serPrice.getPreferredSize().width,
                serPrice.getPreferredSize().height);
        serPrice.setToolTipText("Price in Lankan Rupees.");
        serPrice.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                serPrice.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                serPrice.setBackground(Color.WHITE);
            }
        });
        pan.add(serPrice);
        
        serDescLabel = new JLabel("Description:");
        serDescLabel.setBackground(Color.WHITE);
        serDescLabel.setBounds(20, 280, serDescLabel.getPreferredSize().width,
                serDescLabel.getPreferredSize().height);
        pan.add(serDescLabel);
        
        serDesc = new JTextArea(10, 30);
        serDesc.setBackground(Color.WHITE);
        serDesc.setEditable(true);
        serDesc.setLineWrap(true);
        serDesc.setWrapStyleWord(true);
        serDesc.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                serDesc.setBackground(BK_CLR);
            }
            
            public void focusLost(FocusEvent fe) {
                serDesc.setBackground(Color.WHITE);
            }
        });
        
        serDescScroll = new JScrollPane(serDesc);
        serDescScroll.setBackground(Color.WHITE);
        serDescScroll.setBounds(100, 280,
                serDescScroll.getPreferredSize().width, 120);
        pan.add(serDescScroll);
        
        save = new JButton("Save Record");
        save.setBounds(90, 470, save.getPreferredSize().width,
                save.getPreferredSize().height);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String query = "";
                query += "UPDATE order_data SET mk_number = \'";
                query += searchMK;
                query += "\', rec_id = \'";
                query += searchID;
                query += "\', rec_date = \'";
                query += serDay.getText();
                query += "-";
                query += serMonth.getText();
                query += "-";
                query += serYear.getText();
                query += "\', rec_price = \'";
                query += serPrice.getText();
                query += "\', rec_desc = \'";
                query += serDesc.getText();
                query += "\';";
                
                if (searchMK.equals("") || searchID.equals("")) {
                    showInvalidRecord();
                    clear.doClick();
                } else {
                    try {
                        Connection con = DriverManager.getConnection(DB_CON);
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(query);
                        stmt.close();
                        con.close();
                        showRecordUpdated();
                    } catch (SQLException exc) {
                        showDatabaseError();
                        clear.doClick();
                    }
                }
            }
        });
        pan.add(save);
        
        clear = new JButton("Clear Record");
        clear.setBounds(290, 470, clear.getPreferredSize().width,
                clear.getPreferredSize().height);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                serMK.setSelected(true);
                serID.setText("");
                
                serMKLabel.setText("");
                serMKLabel.setSize(serMKLabel.getPreferredSize().width,
                        serMKLabel.getPreferredSize().height);
                searchMK = "";
                
                serRecLabel.setText("");
                serRecLabel.setSize(serRecLabel.getPreferredSize().width,
                        serRecLabel.getPreferredSize().height);
                searchID = "";
                
                serDay.setText("");
                serMonth.setText("");
                serYear.setText("");
                serPrice.setText("");
                serDesc.setText("");
                
                serID.requestFocus();
            }
        });
        pan.add(clear);        
                
        return pan;
    }
    
    private JPanel makeSerTypePanel() {
        JPanel pan = new JPanel();
        pan.setBackground(Color.WHITE);
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createTitledBorder("Record ID Type"));
        pan.setBounds(20, 20, 215, 160);
        
        serMK = new JRadioButton("MK Number", true);
        serMK.setBackground(Color.WHITE);
        serMK.setBounds(20, 30, serMK.getPreferredSize().width,
                serMK.getPreferredSize().height);
        pan.add(serMK);
        
        serME = new JRadioButton("Media Estimate Number", false);
        serME.setBackground(Color.WHITE);
        serME.setBounds(20, 70, serME.getPreferredSize().width,
                serME.getPreferredSize().height);
        pan.add(serME);
        
        serAN = new JRadioButton("Artwork Number", false);
        serAN.setBackground(Color.WHITE);
        serAN.setBounds(20, 110, serAN.getPreferredSize().width,
                serAN.getPreferredSize().height);
        pan.add(serAN);
        
        serGrp = new ButtonGroup();
        serGrp.add(serMK);
        serGrp.add(serME);
        serGrp.add(serAN);
                
        return pan;
    }
    
    private JPanel makeDeveloperPanel() {
        JPanel pan = new JPanel();
        pan.setBackground(Color.WHITE);
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createTitledBorder(
                "Developer Information"));
        
        devImage = new JLabel(new ImageIcon(DEV_IMG));
        devImage.setBackground(Color.WHITE);
        devImage.setBounds(40, 50, devImage.getPreferredSize().width,
                devImage.getPreferredSize().height);
        
        pan.add(devImage);
        
        devHead = new JLabel("AddTrack 1.0v");
        devHead.setFont(devHead.getFont().deriveFont(Font.BOLD, 40.0f));
        devHead.setBackground(Color.WHITE);
        devHead.setBounds(185, 90, devHead.getPreferredSize().width,
                devHead.getPreferredSize().height);
        pan.add(devHead);
        
        devSub = new JLabel("Copyright \u00A9 2008");
        devSub.setFont(devSub.getFont().deriveFont(Font.BOLD, 15.0f));
        devSub.setBackground(Color.WHITE);
        devSub.setBounds(185, 150, devSub.getPreferredSize().width,
                devSub.getPreferredSize().height);
        pan.add(devSub);
        
        devTitle = new JLabel("Freedom to a Hacker is Salvation to a Soul!");
        devTitle.setFont(devTitle.getFont().deriveFont(Font.BOLD, 13.0f));
        devTitle.setBackground(Color.WHITE);
        devTitle.setBounds(110, 500, devTitle.getPreferredSize().width,
                devTitle.getPreferredSize().height);
        pan.add(devTitle);
        
        devName = new JLabel("Sandeep Lakmal Ellawala");
        devName.setFont(devName.getFont().deriveFont(Font.BOLD, 18.0f));
        devName.setBackground(Color.WHITE);
        devName.setBounds(130, 260, devName.getPreferredSize().width,
                devName.getPreferredSize().height);
        pan.add(devName);
        
        devMobile = new JLabel("+94(0)774055644");
        devMobile.setFont(devMobile.getFont().deriveFont(Font.PLAIN, 16.0f));
        devMobile.setBackground(Color.WHITE);
        devMobile.setBounds(130, 300, devMobile.getPreferredSize().width,
                devMobile.getPreferredSize().height);
        pan.add(devMobile);
        
        devEmail1 = new JLabel("sandeep.ellawala@gmail.com");
        devEmail1.setFont(devEmail1.getFont().deriveFont(Font.PLAIN, 16.0f));
        devEmail1.setBackground(Color.WHITE);
        devEmail1.setBounds(130, 325, devEmail1.getPreferredSize().width,
                devEmail1.getPreferredSize().height);
        pan.add(devEmail1);
        
        devEmail2 = new JLabel("sandeep.ellawala@ymail.com");
        devEmail2.setFont(devEmail2.getFont().deriveFont(Font.PLAIN, 16.0f));
        devEmail2.setBackground(Color.WHITE);
        devEmail2.setBounds(130, 350, devEmail2.getPreferredSize().width,
                devEmail2.getPreferredSize().height);
        pan.add(devEmail2);
        
        return pan;
    }
    
    private void showInvalidPassword() {
        dialog = new JDialog((Frame)null, "Access Denied", true);
        dialog.setBackground(Color.WHITE);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(250, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        
        pnl = new JPanel();
        pnl.setBackground(Color.WHITE);
        pnl.setLayout(null);
        
        JLabel head = new JLabel("Access Denied!");
        head.setBackground(Color.WHITE);
        head.setFont(head.getFont().deriveFont(Font.BOLD, 20.0f));
        head.setBounds((250 - head.getPreferredSize().width)/2, 20,
                head.getPreferredSize().width, head.getPreferredSize().height);
        head.setForeground(Color.RED);
        
        pnl.add(head);
        
        exit = new JButton("OK");
        exit.setBounds((250 - exit.getPreferredSize().width)/2, 75,
                exit.getPreferredSize().width, exit.getPreferredSize().height);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        
        pnl.add(exit);
        
        dialog.add(pnl);
        dialog.setVisible(true);
    }
    
    private void showDuplicateRecord() {
        dialog = new JDialog((Frame)null, "Duplicate Record", true);
        dialog.setBackground(Color.WHITE);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(250, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        
        pnl = new JPanel();
        pnl.setBackground(Color.WHITE);
        pnl.setLayout(null);
        
        JLabel head = new JLabel("Record Duplicated!");
        head.setBackground(Color.WHITE);
        head.setFont(head.getFont().deriveFont(Font.BOLD, 20.0f));
        head.setBounds((250 - head.getPreferredSize().width)/2, 20,
                head.getPreferredSize().width, head.getPreferredSize().height);
        head.setForeground(Color.RED);
        
        pnl.add(head);
        
        exit = new JButton("OK");
        exit.setBounds((250 - exit.getPreferredSize().width)/2, 75,
                exit.getPreferredSize().width, exit.getPreferredSize().height);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        
        pnl.add(exit);
        
        dialog.add(pnl);
        dialog.setVisible(true);
    }
    
    private void showDatabaseError() {
        dialog = new JDialog((Frame)null, "Database Error", true);
        dialog.setBackground(Color.WHITE);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(250, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        
        pnl = new JPanel();
        pnl.setBackground(Color.WHITE);
        pnl.setLayout(null);
        
        JLabel head = new JLabel("Database Access Error!");
        head.setBackground(Color.WHITE);
        head.setFont(head.getFont().deriveFont(Font.BOLD, 20.0f));
        head.setBounds((250 - head.getPreferredSize().width)/2, 20,
                head.getPreferredSize().width, head.getPreferredSize().height);
        head.setForeground(Color.RED);
        
        pnl.add(head);
        
        exit = new JButton("OK");
        exit.setBounds((250 - exit.getPreferredSize().width)/2, 75,
                exit.getPreferredSize().width, exit.getPreferredSize().height);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        
        pnl.add(exit);
        
        dialog.add(pnl);
        dialog.setVisible(true);
    }
    
    private void showInvalidRecord() {
        dialog = new JDialog((Frame)null, "Invalid Record", true);
        dialog.setBackground(Color.WHITE);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(250, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        
        pnl = new JPanel();
        pnl.setBackground(Color.WHITE);
        pnl.setLayout(null);
        
        JLabel head = new JLabel("Record ID Invalid!");
        head.setBackground(Color.WHITE);
        head.setFont(head.getFont().deriveFont(Font.BOLD, 20.0f));
        head.setBounds((250 - head.getPreferredSize().width)/2, 20,
                head.getPreferredSize().width, head.getPreferredSize().height);
        head.setForeground(Color.RED);
        
        pnl.add(head);
        
        exit = new JButton("OK");
        exit.setBounds((250 - exit.getPreferredSize().width)/2, 75,
                exit.getPreferredSize().width, exit.getPreferredSize().height);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        
        pnl.add(exit);
        
        dialog.add(pnl);
        dialog.setVisible(true);
    }
    
    private void showRecordAdded() {
        dialog = new JDialog((Frame)null, "Record Added", true);
        dialog.setBackground(Color.WHITE);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        
        pnl = new JPanel();
        pnl.setBackground(Color.WHITE);
        pnl.setLayout(null);
        
        JLabel head = new JLabel("Record Successfully Added!");
        head.setBackground(Color.WHITE);
        head.setFont(head.getFont().deriveFont(Font.BOLD, 20.0f));
        head.setBounds((300 - head.getPreferredSize().width)/2, 20,
                head.getPreferredSize().width, head.getPreferredSize().height);
        head.setForeground(Color.GREEN);
        
        pnl.add(head);
        
        exit = new JButton("OK");
        exit.setBounds((300 - exit.getPreferredSize().width)/2, 75,
                exit.getPreferredSize().width, exit.getPreferredSize().height);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        
        pnl.add(exit);
        
        dialog.add(pnl);
        dialog.setVisible(true);
    }
    
    private void showRecordDeleted() {
        dialog = new JDialog((Frame)null, "Record Deleted", true);
        dialog.setBackground(Color.WHITE);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        
        pnl = new JPanel();
        pnl.setBackground(Color.WHITE);
        pnl.setLayout(null);
        
        JLabel head = new JLabel("Record Successfully Deleted!");
        head.setBackground(Color.WHITE);
        head.setFont(head.getFont().deriveFont(Font.BOLD, 20.0f));
        head.setBounds((300 - head.getPreferredSize().width)/2, 20,
                head.getPreferredSize().width, head.getPreferredSize().height);
        head.setForeground(Color.GREEN);
        
        pnl.add(head);
        
        exit = new JButton("OK");
        exit.setBounds((300 - exit.getPreferredSize().width)/2, 75,
                exit.getPreferredSize().width, exit.getPreferredSize().height);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        
        pnl.add(exit);
        
        dialog.add(pnl);
        dialog.setVisible(true);
    }
    
    private void showRecordUpdated() {
        dialog = new JDialog((Frame)null, "Record Updated", true);
        dialog.setBackground(Color.WHITE);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        
        pnl = new JPanel();
        pnl.setBackground(Color.WHITE);
        pnl.setLayout(null);
        
        JLabel head = new JLabel("Record Successfully Updated!");
        head.setBackground(Color.WHITE);
        head.setFont(head.getFont().deriveFont(Font.BOLD, 20.0f));
        head.setBounds((300 - head.getPreferredSize().width)/2, 20,
                head.getPreferredSize().width, head.getPreferredSize().height);
        head.setForeground(Color.GREEN);
        
        pnl.add(head);
        
        exit = new JButton("OK");
        exit.setBounds((300 - exit.getPreferredSize().width)/2, 75,
                exit.getPreferredSize().width, exit.getPreferredSize().height);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        
        pnl.add(exit);
        
        dialog.add(pnl);
        dialog.setVisible(true);
    }
    
    public static void main(String [] args) {
        try {
            Class.forName(DB_CLASS);
        } catch (ClassNotFoundException exc) {
            System.err.println("Error Loading DB Driver!");
            System.exit(-1);
        }
        
        SwingUtilities.invokeLater(new AddTrack());
    }
}