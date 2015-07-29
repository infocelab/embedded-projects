
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

public class Block extends JLabel {
  public static final int level1 = 60 ;
  public static final int level2 = 50 ;
  public static final int level3 = 40 ;
  public static final int level4 = 35 ;
  public static final int level5 = 30 ;
  private int blockx=100, blocky=490, height=10, width ;

  public Block() {
    super() ;

    ImageIcon blockPic = new ImageIcon("image\\block.jpg") ;
    this.setBackground(Color.red) ;
    setIcon(blockPic) ;
    setLevel( 1 ) ;
    setLocation( blockx, blocky );
  }

  public void setLevel( int level ) {
    switch(level) {
      case 1:
        width = level1 ; break ;
      case 2:
        width = level2 ; break ;
      case 3:
        width = level3 ; break ;
      case 4:
        width = level4 ; break ;
      case 5:
        width = level5 ; break ;
      default : break ;
    }
    this.setPreferredSize( new Dimension( width, height ) ) ;
    this.setSize( this.getPreferredSize() ) ;
  }

  public void moveLeft() {
    if( blockx <= 0) return ;
    blockx -= 10 ;
    setLocation( blockx, blocky ) ;
  }

  public void moveRight() {
    if( blockx + width  >= 500 ) return ;
    blockx += 10 ;
    setLocation( blockx, blocky ) ;
  }

  public int getWidth() {
    return width ;
  }

  public int getX() {
    return blockx ;
  }

  public int getY() {
    return blocky ;
  }

  public void setX( int x ) {  blockx = x ; }
  public void setY( int y ) {  blocky = y ; }
}