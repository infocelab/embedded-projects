
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

public class Shoot extends JLabel {
  private boolean shot = false ;
  private ImageIcon shootPic ;
  private int xCoor, yCoor ;

  public Shoot( int x, int y ) {
    xCoor= x ;
    yCoor = y ;

    shootPic = new ImageIcon("image\\shoot.jpg") ;
    setIcon(shootPic) ;
    setPreferredSize( new Dimension( shootPic.getIconWidth(), shootPic.getIconHeight() ) ) ;
    setSize( getPreferredSize() ) ;
    setLocation( xCoor, yCoor ) ;

  }

  public void moveShoot() {
    setLocation( xCoor, yCoor-=10 ) ;
  }

  public void shot( int x, int y ) {
    xCoor = x ;
    yCoor = y ;
    shot = true ;
  }

  public boolean getShot() {
    return shot ;
  }

  public int getY() {
    return yCoor ;
  }

  public int getX() {
    return xCoor ;
  }
}