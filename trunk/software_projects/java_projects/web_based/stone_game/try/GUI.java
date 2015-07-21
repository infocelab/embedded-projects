
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import java.io.* ;

public class GUI extends JFrame implements ActionListener {
  private JPanel pan1, pan2, pan ;
  private JButton startBut ;
  private Game mainPanel ;
  private Block block ;
  private JComboBox level ;
  private int lvl = 1 ;
  private JButton stopBut, restartBut, continueBut ;
  private JLabel information, scoreLabel ;
  private ImageIcon logo1, java, javaman ;
  private JMenuBar bar ;
  private JMenu file, help ;
  private JMenuItem scoreItem, helpItem, exitItem, aboutItem ;
  private JTextArea area ;
  private JToggleButton pause ;

  public GUI() {
    super("::::GAME::::by Erol KOCAMAN") ;

    Image im = getToolkit().getImage("image\\logo.jpg")  ;
    this.setIconImage(im);

    Container c = getContentPane() ;
    c.setLayout(null) ;
    c.setBackground(Color.green);

    pan = new JPanel() ;
    pan.setLayout(new FlowLayout()) ;
    pan.setBackground(Color.black) ;
    pan.setPreferredSize( new Dimension( 480, 480 ) ) ;
    pan.setSize( pan.getPreferredSize() ) ;
    pan.setLocation( 20, 20 ) ;
    c.add(pan) ;

    pan1 = new JPanel() ;
    pan1.setLayout(new FlowLayout()) ;
    pan1.setBackground(Color.orange) ;
    pan1.setPreferredSize( new Dimension( 200, 700 ) ) ;
    pan1.setSize( pan1.getPreferredSize() ) ;
    pan1.setLocation( 520,0 ) ;
    c.add(pan1) ;

    pan2 = new JPanel() ;
    pan2.setLayout(new FlowLayout()) ;
    pan2.setBackground(Color.orange) ;
    pan2.setPreferredSize( new Dimension( 700, 200 ) ) ;
    pan2.setSize( pan2.getPreferredSize() ) ;
    pan2.setLocation( 0, 520 ) ;
    c.add(pan2) ;

    startBut = new JButton("Start") ;
    startBut.setPreferredSize( new Dimension( 150, 30 ) ) ;
    startBut.setSize( startBut.getPreferredSize() ) ;
    startBut.setLocation( 520, 50 ) ;
    startBut.addActionListener(this);
    pan1.add(startBut) ;

    level = new JComboBox();
    level.addItem("level 1");
    level.addItem("level 2");
    level.addItem("level 3");
    level.addItem("level 4");
    level.addItem("level 5");
    level.setPreferredSize( new Dimension(150,30) );
    level.setSize( level.getPreferredSize() ) ;
    level.setLocation( 520, 100 );
    level.addActionListener(this);
    level.setBackground(Color.orange);
    pan1.add(level) ;

    stopBut = new JButton("Finish") ;
    stopBut.setEnabled(false);
    stopBut.setPreferredSize( new Dimension( 150, 30 ) ) ;
    stopBut.setSize( stopBut.getPreferredSize() ) ;
    stopBut.setLocation( 520, 150 ) ;
    stopBut.addActionListener(this);
    pan1.add(stopBut) ;

    restartBut = new JButton("Restart",java) ;
    restartBut.setEnabled(false);
    restartBut.setPreferredSize( new Dimension( 150, 30 ) ) ;
    restartBut.setSize( restartBut.getPreferredSize() ) ;
    restartBut.setLocation( 520, 200 ) ;
    restartBut.addActionListener(this);
    pan1.add(restartBut) ;

    continueBut = new JButton("Continue",java) ;
    continueBut.setEnabled(false);
    continueBut.setPreferredSize( new Dimension( 150, 30 ) ) ;
    continueBut.setSize( continueBut.getPreferredSize() ) ;
    continueBut.setLocation( 520, 200 ) ;
    continueBut.addActionListener(this);
    pan1.add(continueBut) ;

    java = new ImageIcon("image\\dukeWave.gif") ;
    javaman = new ImageIcon("image\\dukesnooze.gif") ;
    pause = new JToggleButton( "Pause", java, false ) ;
    pause.setForeground(Color.blue);
    pause.setEnabled(false);
    pause.setPreferredSize( new Dimension(150,80) );
    pause.setSize( pause.getPreferredSize() ) ;
    pause.addActionListener(this) ;
    pan1.add(pause) ;

    logo1 = new ImageIcon("image\\steam.gif") ;
    information = new JLabel(logo1) ;
    information.setPreferredSize(new Dimension(500,500));
    information.setSize( information.getPreferredSize() ) ;
    information.setLocation(0,0);
    pan.add(information) ;

    scoreLabel = new JLabel("Score : ") ;
    scoreLabel.setFont( new Font( "Times Roman", 3, 20 ) ) ;
    scoreLabel.setForeground(Color.red);
    scoreLabel.setPreferredSize(new Dimension(150,30));
    scoreLabel.setSize( scoreLabel.getPreferredSize() ) ;
    scoreLabel.setLocation(520,250);
    pan1.add(scoreLabel) ;
    
    JLabel duke = new JLabel(java) ;
    pan1.add(duke) ;

    bar = new JMenuBar() ;

    file = new JMenu("File") ;
    file.setForeground(Color.red) ;
    file.setBackground(Color.yellow) ;
    file.setMnemonic('F') ;
    scoreItem = new JMenuItem("Score Table") ;
    scoreItem.addActionListener(this);
    exitItem = new JMenuItem("EXIT") ;
    exitItem.addActionListener(this);
    exitItem.setForeground(Color.red) ;
    file.add(scoreItem) ;
    file.add(exitItem) ;

    help = new JMenu("Help") ;
    help.setForeground(Color.red) ;
    help.setBackground(Color.yellow) ;
    help.setMnemonic('H');
    aboutItem = new JMenuItem("About") ;
    aboutItem.addActionListener(this);
    helpItem = new JMenuItem("Help Topics") ;
    helpItem.addActionListener(this);
    help.add(aboutItem) ;
    help.add(helpItem) ;

    bar.add(file) ;
    bar.add(help) ;

    this.setJMenuBar(bar) ;

    setSize( 725, 700 ) ;
    setResizable(false) ;
    show() ;


    JOptionPane.showMessageDialog( c, ": : : : : <<< WELCOME STONE GAME >>> : : : : :" , "STONE GAME", JOptionPane.INFORMATION_MESSAGE, javaman  ) ;
  }

  public void actionPerformed( ActionEvent e ) {
    if( e.getSource()==startBut ) {
      restartGame() ;
    }
    if( e.getSource()==level ) {
      int lev = level.getSelectedIndex() ;
      System.out.println("level"+(lev+1)) ;
      lvl = (lev+1) ;
    }
    if( e.getSource()==stopBut ) {
      mainPanel.stopTimer();
      mainPanel.finishGame();
      table();
      endGame() ;
    }
    if( e.getSource()==restartBut ) {
      restartGame() ;
    }
    if( e.getSource()==scoreItem ) {
      table() ;
    }
    if( e.getSource()==continueBut ) {
      int sc = mainPanel.getScore() ;
      getContentPane().remove(mainPanel) ;
      mainPanel = null ;
      if( lvl!=5 ) {
        lvl++ ;
        level.setSelectedIndex(lvl-1);
      }
      restartGame() ;
      mainPanel.setScore(sc);
      continueBut.setEnabled(false);
    }
    if( e.getSource()==pause ) {
      if( pause.isSelected() ) {
        pause.setForeground(Color.red);
        pause.setIcon(javaman);
        mainPanel.stopTimer();
      }
      else {
        pause.setIcon(java) ;
        pause.setForeground(Color.blue);
        mainPanel.startTimer();
      }
    }
    if( e.getSource()==exitItem ) {
      String ex = JOptionPane.showInputDialog( null, "Are you sure? Y / N" ) ;
      if( ex==null ) return ;
      System.exit(0);
    }
    if( e.getSource()==aboutItem ) {
      JFrame f = new JFrame("ABOUT ME") ;
      Container con = f.getContentPane() ;
      con.setLayout( new FlowLayout() ) ;
      con.setBackground(Color.red);
      ImageIcon dukePic = new ImageIcon("image\\about.gif") ;
      JLabel l = new JLabel(dukePic) ;
      con.add(l) ;
      Font font = new Font( "Times Romans", 3, 25 ) ;
      JLabel a = new JLabel("This is produced by Erol KOCAMAN  :::::STONE GAME::::::") ;
      a.setFont(font) ;
      a.setForeground(Color.black) ;
      con.add(a) ;
      f.setSize(700,150) ;
      f.setLocation(250,250) ;
      f.show() ;
    }
    if( e.getSource()==helpItem ) {
      JFrame f = new JFrame("HELP") ;
      Container con = f.getContentPane() ;
      con.setLayout( new GridLayout(6,1,5,5) ) ;
      con.setBackground(Color.black);
      ImageIcon trap = new ImageIcon("image\\trap.jpg") ;
      JLabel trapl = new JLabel(trap) ;
      JLabel trapi = new JLabel("trap. DO NOT crash it") ;
      ImageIcon bonus = new ImageIcon("image\\bonus.jpg") ;
      JLabel bonusl = new JLabel(bonus) ;
      JLabel bonusi = new JLabel("bonus. get it to have extra score") ;
      ImageIcon block = new ImageIcon("image\\block.jpg") ;
      JLabel blockl = new JLabel(block) ;
      JLabel blocki = new JLabel("block. move it left and right to hit ball") ;
      ImageIcon stone = new ImageIcon("image\\stoneblue.jpg") ;
      JLabel stonel = new JLabel(stone) ;
      JLabel stonei = new JLabel("stone. destroy them") ;
      ImageIcon ball = new ImageIcon("image\\ball.gif") ;
      JLabel balll = new JLabel(ball) ;
      JLabel balli = new JLabel("ball. DO NOT miss it") ;
      JLabel about = new JLabel("You will have some shoots after 1000 score") ;

      con.add(trapl) ;
      con.add(trapi) ;
      con.add(bonusl) ;
      con.add(bonusi) ;
      con.add(blockl) ;
      con.add(blocki) ;
      con.add(stonel) ;
      con.add(stonei) ;
      con.add(balll) ;
      con.add(balli) ;
      con.add(about) ;

      f.setSize(600,300) ;
      f.show() ;

    }
  }

  public void restartGame() {
    if( mainPanel!=null ) {
      getContentPane().remove(mainPanel);
    }
    mainPanel = new Game(this, lvl) ;
    mainPanel.setBackground(Color.white);
    getContentPane().add(mainPanel) ;
    mainPanel.startTimer();
    getResPos() ;
  }

  public void endGame() {
    mainPanel.stopTimer();
    getContentPane().remove(mainPanel);
    mainPanel = null ;
    repaint() ;
    getLostPos() ;
  }

  public void getLostPos() {
    stopBut.setEnabled(false);
    restartBut.setEnabled(true) ;
    level.setEnabled(true);
    pause.setEnabled(false);
  }

  public void getResPos() {
    stopBut.setEnabled(true);
    restartBut.setEnabled(false);
    level.setEnabled(false);
    startBut.setEnabled(false);
    pause.setEnabled(true);
  }

  public void con() {
    getLostPos() ;
    continueBut.setEnabled(true);
  }

  public void setFalseContinue() {
    continueBut.setEnabled(false);
  }

  public void setScore( int sc ) {
    scoreLabel.setText("Score : "+sc);
  }

  public void table() {
    JFrame frame = new JFrame(":::::::::SCORE TABLE::::::::::") ;
    Container co = frame.getContentPane() ;
    co.setLayout( new FlowLayout() ) ;
    co.setBackground(Color.black) ;

    area = new JTextArea(15,25) ;
    area.setEditable(false) ;
    area.setBackground(Color.black) ;
    area.setForeground(Color.red) ;
    area.setText( readScore() ) ;
    co.add( new JScrollPane(area) ) ;

    JButton reset = new JButton("Reset") ;
    reset.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String yn = javax.swing.JOptionPane.showInputDialog( null, "Do you want to clear score table" ) ;
          if( yn==null ) return ;
          area.setText("       <<<--SCORE TABLE-->>>");
          try {
            File file = new File("records\\records.txt") ;
            file.delete() ;
          } catch(Exception ex) {}
        }
      }
    );
    reset.setBackground(Color.red);
    co.add(reset) ;

    frame.setSize(300,330) ;
    frame.setResizable(false) ;
    frame.show() ;
  }

  public String readScore() {
    File f = null ;
    ObjectInputStream i = null ;
    String scorestr="       <<<--SCORE TABLE-->>>" ;

    try{
      f = new File("records\\records.txt") ;
      i = new ObjectInputStream( new FileInputStream(f) ) ;
      for( int j=0; j<10; j++ ) {
        scorestr += "\n---------------------------------------------------" ;
        scorestr +="\n" +(j+1)+" Player --> "+ i.readObject() ;
      }
      i.close();
    } catch(Exception e) {}
    return scorestr ;
  }    

  public static void main( String args[] ) {
    GUI guý = new GUI() ; 
    guý.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
  }
}
