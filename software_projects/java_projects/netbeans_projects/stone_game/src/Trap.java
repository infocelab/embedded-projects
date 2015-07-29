
import java.awt.* ;
import javax.swing.* ;

public class Trap extends Stone{
  private ImageIcon trapPic ;

  public Trap( int x, int y ) {
    xCoor = x ;
    yCoor = y ;

    trapPic = new ImageIcon("image\\trap.jpg") ;
    setIcon(trapPic) ;
    setPreferredSize( new Dimension( trapPic.getIconWidth(), trapPic.getIconHeight() ) ) ;
    setSize( getPreferredSize() ) ;
    setLocation( xCoor, yCoor ) ;

  }

  public void moveTrap() {
    setLocation( xCoor, yCoor+=10 ) ;
  }
}