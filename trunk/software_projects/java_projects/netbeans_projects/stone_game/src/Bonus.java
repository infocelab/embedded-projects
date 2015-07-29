
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

public class Bonus extends Stone {
  private ImageIcon bonusPic ;

  public Bonus( int x, int y ) {
    super() ;
    xCoor = x ;
    yCoor = y ;

    bonusPic = new ImageIcon("image\\bonus.jpg") ;
    setIcon(bonusPic) ;
    setPreferredSize( new Dimension( bonusPic.getIconWidth(), bonusPic.getIconHeight() ) ) ;
    setSize( getPreferredSize() ) ;
    setLocation( xCoor, yCoor ) ;

  }

  public void moveBonus() {
    setLocation( xCoor, yCoor+=10 ) ;
  }
}