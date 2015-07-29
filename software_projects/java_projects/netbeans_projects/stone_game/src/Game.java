
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import java.io.* ;

public class Game extends JPanel implements ActionListener, KeyListener {
  private Ball ball ;
  private Block block ;
  private Shoot[] shoot ;
  private Stone[] stone ;
  private int nostone, speed=100 ;
  private Timer timer ;
  private GUI gu ;
  private int[] no, stonex, stoney ;
  private boolean hitStone=false ;
  private int level ;
  private int counter=0 ;
  private static final int bonusscore=75, trapscore=-100, stonescore=50, shootscore=15;
  private static final int stonenum1=10, stonenum2=15, stonenum3=20, stonenum4=25, stonenum5=30 ;
  private int givenBonus=0 ;
  private Record record ;

  public Game( GUI g, int l ) {
    setLayout(null) ;
    setPreferredSize( new Dimension(500,500) ) ;
    setSize( getPreferredSize() ) ;
    setLocation( 10, 10 ) ;
    record = new Record("", 0) ;

    gu = g ;
    level = l ;

    ball = new Ball() ;
    block = new Block() ;
    initialize() ;
    shoot = new Shoot[10] ;
    giveShoot( 3 ) ;

    gu.addKeyListener(this) ;

    timer = new Timer(speed,this) ;
  }

  public void initialize() {
    add(block) ;
    add(ball) ;

    setLevel(level) ;
    stone = new Stone[nostone] ;
    for( int i=0; i<nostone; i++ ) {
      stone[i] = new Stone( (int)(Math.random()*14)*35, (int)(Math.random()*30)*10, (int)(Math.random()*3+1) ) ;
      add(stone[i]) ;
    }
  }

  public void keyPressed(KeyEvent e) {
    String key = e.getKeyText( e.getKeyCode() ) ;

    if( key.equals("Left") ) {
      block.moveLeft() ;
    }
    if( key.equals("Right") ) {
      block.moveRight() ;
    }
    if( key.equals("Up") ) {
      for( int i=0; i<shoot.length; i++ ) {
        if( shoot[i]!=null && !shoot[i].getShot() ) {
          shoot[i].shot( block.getX()+block.getWidth()/2, block.getY() );
          add(shoot[i]) ;
          return ;
        }
      }
    }
    validate() ;
    repaint() ;
  }
  public void keyReleased(KeyEvent e) {}
  public void keyTyped(KeyEvent e) {}

  public void actionPerformed( ActionEvent e ) {
    if( e.getSource()==timer ) {
      ball.moveBall() ;
      moveShoots() ;
      moveBonus() ;
      moveTrap() ;
      hitStone() ;
      checkCrash() ;
      validate() ;
      shootHitStone() ;
      repaint() ;
    }
  }

  private void checkCrash() {
    if( ball.getX()<=0 ) {
      ball.crashLeft() ; 
    }
    else if( ball.getX()>=this.getWidth()-ball.getWidth() ) {
      ball.crashRight() ;   
    }
    else if( ball.getY()<=0 ) {
      ball.crashTop();
    }
    else if( ball.getY()>=this.getHeight() ) {
      lost() ;
      gu.table() ;
    }
    else if( ball.getY()+ball.getHeight() >= block.getY() && ball.getY()+ball.getHeight() < block.getY()+block.getHeight() && ball.getRight() > block.getX() && ball.getX() < block.getX()+block.getWidth() ) {
      if( ball.getMidPoint() < block.getX()+(double)(block.getWidth()/3) ) {
        ball.crashBlockLeft();
      }
      else if( ball.getMidPoint() > block.getX()+(double)(block.getWidth()/3) && ball.getMidPoint() < block.getX()+block.getWidth()*((double)2/3)  ) {
        ball.crashBlockMid();
      }
      else {  
        ball.crashBlockRight();
      }
    }
    ball.setPlace() ;
  }

  private void hitStone() {
    counter= 0 ;
    for( int i=0; i<nostone; i++ ) {
      if( stone[i]!=null ) {
        if( stone[i] instanceof Bonus ) {
          takeBonus(i) ;
          continue ;
        }
        if( stone[i] instanceof Trap ) {
          takeTrap(i) ;
          continue ;
        }
        //crashed from left
        if( ball.getRight() >= stone[i].getX() && ball.getX() <= stone[i].getMidX() ) {
          //crashed from up
          if( ball.getDown() >= stone[i].getY() && ball.getDown() <= stone[i].getMidY() ) {
            record.incScore(stonescore);
            checkScore() ;
            ball.crashStoneLeft( ball.getOldX() ) ;
            ball.crashStoneUp( ball.getOldY() ) ;
            crashLastStone( i ) ;
          }
          //crashed from down
          if( ball.getY() <= stone[i].getDown() && ball.getY() >= stone[i].getMidY() ) {
            record.incScore(stonescore);
            checkScore() ;
            ball.crashStoneLeft( ball.getOldX() ) ;
            ball.crashStoneDown( ball.getOldY() ) ;
            crashLastStone( i ) ;
          }
        }
        //crashed from right
        if( ball.getX() <= stone[i].getRight() && ball.getX() >= stone[i].getMidX() ) {
          //crashed from up
          if( ball.getDown() >= stone[i].getY() && ball.getDown() <= stone[i].getMidY() ) {
            record.incScore(stonescore);
            checkScore() ;
            ball.crashStoneRight( ball.getOldX() ) ;
            ball.crashStoneUp( ball.getOldY() ) ;
            crashLastStone( i ) ;
          }
          //crashed from down
          if( ball.getY() <= stone[i].getDown() && ball.getY() >= stone[i].getMidY() ) {
            record.incScore(stonescore);
            checkScore() ;
            ball.crashStoneRight( ball.getOldX() ) ;
            ball.crashStoneUp( ball.getOldY() ) ;
            crashLastStone( i ) ;
          }
        }
        ball.setPlace() ;
      }
      else counter++ ;
    }    
    if( counter >= nostone ) {
      win() ;
    }
  }

  private void checkScore() {
    gu.setScore(record.getScore());
    if( (record.getScore()-givenBonus*1000)>=1000 ) {
      giveShoot( ++givenBonus+2 ) ;
    }
  }

  private void moveShoots() {
    for( int i=0; i<shoot.length; i++ ) {
      if( shoot[i]!=null && shoot[i].getShot() ) {
        shoot[i].moveShoot() ;
        if( shoot[i].getY() <= 0 ) {
          remove(shoot[i]) ;
          shoot[i] = null ;
        }
      }
    }
  }

  private void moveBonus() {
    for( int i = 0; i < stone.length; i++ ) {
      if( stone[i] != null ) {
        if( stone[i] instanceof Bonus ) {
          ((Bonus)stone[i]).moveBonus() ;
          if( stone[i].getY()>500 ) {
            remove(stone[i]) ;
            stone[i] = null ;
          }
        }
      }
    }
  }

  private void moveTrap() {
    for( int i=0; i<stone.length; i++ ) {
      if( stone[i]!=null ) {
        if( stone[i] instanceof Trap ) {
          ((Trap)stone[i]).moveTrap() ;
          if( stone[i].getY()>500 ) {
            remove(stone[i]) ;
            stone[i] = null ;
          }
        }
      }
    }
  }

  private void crashLastStone( int i ) {
    stone[i].decreasePower() ;
    if( stone[i].getPower()==0 ) {
      remove(stone[i]) ;
      int r = (int)(Math.random()*3) ;
      if( r==0 ){
        stone[i] = new Trap( stone[i].getX(), stone[i].getY() ) ;
        add( stone[i] ) ;
      }
      else{
        stone[i] = new Bonus( stone[i].getX(), stone[i].getY() ) ;
        add( stone[i] ) ;
      }
    }
  }

  public void takeBonus( int i ) {
    if( stone[i].getX()+stone[i].getWidth() >= block.getX() && stone[i].getX() <= block.getWidth()+block.getX() ) {
      if( stone[i].getY() >= block.getY() && stone[i].getY() < block.getY()+block.getHeight()/3 ) {
        record.incScore(bonusscore);
        checkScore() ;
        System.out.println("YOU TAKE THE BONUS") ;
      }
    }
  }

  public void takeTrap( int i ) {
    if( stone[i].getX()+stone[i].getWidth() >= block.getX() && stone[i].getX() <= block.getWidth()+block.getX() ) {
      if( stone[i].getY() >= block.getY() && stone[i].getY() < block.getY()+block.getHeight()/3 ) {
        record.incScore(trapscore); ;
        checkScore() ;
        System.out.println("YOU TAKE THE TRAP") ;
      }
    }
  }

  public void startTimer() {
    timer.start() ;
  }

  public void stopTimer() {
    timer.stop() ;
  }

  private void giveShoot( int num ) {
    int j = 0 ;
    for( int i = 0; (i < shoot.length) && (j < num); i++ ) {
      if( shoot[i] == null ) {
        shoot[i] = new Shoot( block.getX()+block.getWidth()/2, block.getY() ) ;
        j++ ;
      }
    }
  }

  private void shootHitStone() {
    for( int i=0; i<shoot.length; i++ ) {
      for( int j=0; j<nostone; j++ ) {
        if( shoot[i]!=null && stone[j]!=null && !(stone[j] instanceof Bonus) && !(stone[j] instanceof Trap) ) {
          if( shoot[i].getY()<=stone[j].getY()+stone[j].getHeight() && shoot[i].getX()+shoot[i].getWidth() > stone[j].getX() && shoot[i].getX() < stone[j].getX()+stone[j].getWidth() ) {
            record.incScore(shootscore);
            checkScore() ;
            crashLastStone(j) ;
            remove(shoot[i]) ;
            shoot[i]=null ;
          }
        }
      }
    }

  }

  public void setLevel( int lvl ) {
    switch(lvl) {
      case 1 : speed = 160 ; nostone = stonenum1 ; break ;
      case 2 : speed = 140 ; nostone = stonenum2 ; break ;
      case 3 : speed = 120 ; nostone = stonenum3 ; break ;
      case 4 : speed = 90 ; nostone = stonenum4 ; break ;
      case 5 : speed = 65 ;  nostone = stonenum5 ; break ;
    }
    block.setLevel( lvl ) ;
  }

  public void lost() {
    System.out.println( "YOU LOST" ) ;
    stopTimer() ;
    gu.setFalseContinue();
    String strName = JOptionPane.showInputDialog("Enter your name") ;
    if( strName==null ) strName="----" ;
    record.setName(strName) ;
    saveGame() ;
    gu.endGame() ;
  }

  public void win() {
    System.out.println("YOU WON") ;
    gu.con();
    this.stopTimer();
    JOptionPane.showMessageDialog( null, "YOU WON( CONTINUE or RESTART )") ;
  }

  public void finishGame() {
    String strName = JOptionPane.showInputDialog("Enter your name") ;
    if( strName==null ) strName="----" ;
    record.setName(strName) ;
    saveGame() ;
  }

  public void saveGame() {
    int num=0, index=0;
    File file = null ;
    ObjectOutputStream out = null ;
    ObjectInputStream in = null ;
    Record records[] = new Record[10] ;

    try{
      file = new File("records\\records.txt") ;
      in = new ObjectInputStream( new FileInputStream(file) ) ;
      for( int i=0; i<records.length; i++ ) {
        records[i] = (Record)in.readObject() ;
        num++;
      }

    } catch( NullPointerException npe ) {
        try {
          if( in!=null ) {
            in.close();
            file = null ;
          }
        } catch(Exception e) {}

    } catch(FileNotFoundException fe) {System.out.println("Fil");}
      catch(Exception e) {System.out.println("Exc");}

    try {
      for( int i = 0; i < num; i++ ) {
        if( records[i] != null ) {
          if( records[i].getScore()<record.getScore()) {
            break ; }
          else index++ ;
        }
      }

      try {
        (new File("records\\records.txt")).delete() ;
      } catch( Exception e ) {}

      file = new File("records\\records.txt") ;
      out = new ObjectOutputStream( new FileOutputStream(file) ) ;


      for( int i = 0; i<records.length-1; i++ ) {
        if( i == index ) {
          out.writeObject( (Record)record ) ;
          index = --i ;
          continue ;
        }
        if( records[i] == null ) break ;
        out.writeObject((Record)records[i]) ;
      }
    }
    catch(Exception e) { System.out.println("errorhere") ; }
    finally {
      try {
        out.close();
        file = null ;
      } catch(Exception fel) {}
    }
  }

  public int getScore() {
    return record.getScore() ;
  }

  public void setScore( int s ) {
    record.incScore(s);
  }
}
