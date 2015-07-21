
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

public class Stone extends JLabel {
  private int width=30, height=15 ;
  protected int xCoor, yCoor ;
  private int power ;
  private ImageIcon stoneredPic, stonebluePic, stoneyellowPic ;

  public Stone() {
    super() ;
  }

  public Stone( int x, int y, int count ) {
    this() ;
    power = count ;
    xCoor = x ;
    yCoor = y ;

    stonebluePic = new ImageIcon("image\\stoneblue.jpg") ;
    stoneredPic = new ImageIcon("image\\stonered.jpg") ;
    stoneyellowPic = new ImageIcon("image\\stoneyellow.jpg") ;

    this.setPreferredSize( new Dimension( width, height ) ) ;
    this.setSize( this.getPreferredSize() ) ;
    this.setBackground(Color.blue);
    this.setLocation( xCoor, yCoor );
    setPhase( power ) ;
  }

  public void setPhase( int power ) {
    if( power==3 ) {
      setIcon(stonebluePic) ;
    }
    else if( power==2 ) {
      setIcon(stoneredPic) ;
    }
    else if( power==1 ) {
      setIcon(stoneyellowPic) ;
    }
  }

  public int getPower() {
    return power ;
  }

  public void decreasePower() {
    power-- ;
    setPhase(power) ;
  }

  public void setPower( int i ) {
    power = i ;
  }

  public int getX() { return xCoor ;  }
  public int getY() { return yCoor ;  }
  public int getWidth() { return width ; }
  public int getHeight() { return height ; }
  public int getRight() { return xCoor+width ; }
  public int getDown() { return yCoor+height ; }
  public int getMidX() { return (int)(xCoor+(float)width/2) ; }
  public int getMidY() { return (int)(yCoor+(float)height/2) ; }
  public void removed() {
    xCoor = yCoor = -100 ;
  }
}
