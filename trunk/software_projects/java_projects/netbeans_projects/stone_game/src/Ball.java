
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

public class Ball extends JLabel {
  private ImageIcon ballPic ;
  private int ballx, bally, kx=5, ky=8 ;
  private int width, height ;

  public Ball() {
    super() ;

    ballx = (int)(Math.random()*500+1) ;
    bally = (int)(Math.random()*200+1) ;

    ballPic = new ImageIcon("image\\ball.gif") ;
    width = ballPic.getIconWidth() ;
    height = ballPic.getIconHeight() ;
    this.setIcon(ballPic) ;
    this.setPreferredSize( new Dimension( width, height ) ) ;
    this.setSize( this.getPreferredSize() );
    setLocation(ballx,bally) ;
  }

  public void moveBall() {
    ballx += kx ;
    bally += ky ;
    this.setLocation( ballx, bally ) ;
  }

  public void crashLeft() {
    kx = 5 ;
  }

  public void crashRight() {
    kx = -5 ;
  }

  public void crashTop() {
    ky = 8 ;
  }

  public void setPlace() {
    setLocation( ballx, bally ) ;
  }

  public void crashStoneUp( int y ) {
    bally = y ;
    ky = -Math.abs(ky) ;
  }

  public void crashStoneDown( int y ) {
    bally = y ;
    ky = Math.abs(ky) ;
  }

  public void crashStoneRight( int x ) {
    ballx = x ;
    kx = Math.abs(kx) ;
  }

  public void crashStoneLeft( int x ) {
    ballx = x ;
    kx = -Math.abs(kx) ;
  }

  public void crashBlockMid() {
    ky = -8 ;
    kx = (int)(Math.random()*6-3) ;
  }

  public void crashBlockLeft() {
    crashRight() ;
    ky = -8 ;
  }

  public void crashBlockRight() {
    crashLeft() ;
    ky = -8 ;
  }

  public void place( int x, int y ) {
    setLocation(x,y) ;
  }
  public int getOldX() { return ballx-kx ; }
  public int getOldY() { return bally-ky ; }
  public int getX() { return ballx ;  }
  public int getY() { return bally ;  }
  public int getMidPoint() { return (int)(ballx+(double)width/2) ; }
  public int getRight() { return ballx+width ; }
  public int getDown() { return bally+height ; }
}
