import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LcdTable extends JPanel{
  private Image digits=new ImageIcon(ImageDigits.digits).getImage();     
  private Image colon=new ImageIcon(ImageColon.colon).getImage();     
  private Image slash=new ImageIcon(ImageSlash.slash).getImage();     
  private Image space=new ImageIcon(ImageSpace.space).getImage();     
  private Image leftBorder=new ImageIcon(ImageLeftBorder.leftBorder).getImage();     
  private Image rightBorder=new ImageIcon(ImageRightBorder.rightBorder).getImage();     
  private int digitWidth;
  private int colonWidth;
  private int slashWidth;
  private int spaceWidth;
  private int leftBorderWidth;
  private int rightBorderWidth;
  private int lcdWidth;
  private int lcdHeight;
  public int coordinateX=0;
  public int coordinateY=0;
  public String lcdString = "";
  public Color backColor = Color.WHITE;
  private static final int updateDelay = 10;
  
  public class LcdTableUpdate extends Thread{
    public void run() {
      while(true){
        if (getParent() != null) getParent().repaint();
        repaint();  
        try{sleep(updateDelay);} catch(InterruptedException e){}
      }
    }      
  }
  public LcdTable(){
    LcdTableInit();
  }
  public void LcdTableInit(){
    digitWidth = digits.getWidth(this)/10;  
    colonWidth = colon.getWidth(this)/2;  
    slashWidth = slash.getWidth(this)/2;  
    spaceWidth = space.getWidth(this);  
    leftBorderWidth = leftBorder.getWidth(this);  
    rightBorderWidth = rightBorder.getWidth(this);  
    lcdHeight = digits.getHeight(this);
    setBounds(0,0,1,1);    
    LcdTableUpdate lcdUpdate = new LcdTableUpdate();
    lcdUpdate.start();
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    drawLcdTable(g);
  }
  public void drawLcdTable(Graphics g){
    int currentWidthPoint = 0;  
    
    lcdWidth = leftBorderWidth;
    for (int i=0;i<lcdString.length();i++){    
      if (Character.isDigit(lcdString.charAt(i))) lcdWidth += digitWidth;        
      if (lcdString.charAt(i) == ':') lcdWidth += colonWidth;
      if (lcdString.charAt(i) == 'a') lcdWidth += colonWidth;
      if (lcdString.charAt(i) == '/') lcdWidth += slashWidth;
      if (lcdString.charAt(i) == 'b') lcdWidth += slashWidth;
      if (lcdString.charAt(i) == ' ') lcdWidth += spaceWidth;
    }
    lcdWidth += rightBorderWidth;
    
    setPreferredSize(new Dimension(lcdWidth,lcdHeight));
    setBounds(coordinateX,coordinateY,lcdWidth,lcdHeight);
    setBackground(backColor);
    
    g.drawImage(leftBorder,
                 currentWidthPoint, 
                 0,
                 currentWidthPoint + leftBorderWidth,
                 lcdHeight,
                 0,
                 0,
                 leftBorderWidth,
                 lcdHeight,                   
                 this);
    currentWidthPoint += leftBorderWidth;
    for (int i=0;i<lcdString.length();i++){
      if (Character.isDigit(lcdString.charAt(i))){
        g.drawImage(digits,
                     currentWidthPoint + 0, 
                     0,
                     currentWidthPoint + digitWidth,
                     lcdHeight,
                     digitWidth*(lcdString.charAt(i)-'0'),
                     0,
                     digitWidth*(lcdString.charAt(i)-'0') + digitWidth,
                     lcdHeight,                   
                     this);
        currentWidthPoint += digitWidth;        
      }
      if (lcdString.charAt(i) == ':'){
        g.drawImage(colon,
                     currentWidthPoint + 0, 
                     0,
                     currentWidthPoint + colonWidth,
                     lcdHeight,
                     0,
                     0,
                     colonWidth,
                     lcdHeight,                   
                     this);
        currentWidthPoint += colonWidth;
      }
      if (lcdString.charAt(i) == 'a'){
        g.drawImage(colon,
                     currentWidthPoint + 0, 
                     0,
                     currentWidthPoint + colonWidth,
                     lcdHeight,
                     colonWidth,
                     0,
                     colonWidth*2,
                     lcdHeight,                   
                     this);
        currentWidthPoint += colonWidth;
      }
      if (lcdString.charAt(i) == '/'){
        g.drawImage(slash,
                     currentWidthPoint + 0, 
                     0,
                     currentWidthPoint + slashWidth,
                     lcdHeight,
                     0,
                     0,
                     slashWidth,
                     lcdHeight,                   
                     this);
        currentWidthPoint += slashWidth;
      }
      if (lcdString.charAt(i) == 'b'){
        g.drawImage(slash,
                     currentWidthPoint + 0, 
                     0,
                     currentWidthPoint + slashWidth,
                     lcdHeight,
                     slashWidth,
                     0,
                     slashWidth*2,
                     lcdHeight,                   
                     this);
        currentWidthPoint += slashWidth;
      }
      if (lcdString.charAt(i) == ' '){
        g.drawImage(space,
                     currentWidthPoint + 0, 
                     0,
                     currentWidthPoint + spaceWidth,
                     lcdHeight,
                     0,
                     0,
                     spaceWidth,
                     lcdHeight,                   
                     this);
        currentWidthPoint += spaceWidth;
      }
    }
    g.drawImage(rightBorder,
                 currentWidthPoint, 
                 0,
                 currentWidthPoint + leftBorderWidth,
                 lcdHeight,
                 0,
                 0,
                 leftBorderWidth,
                 lcdHeight,                   
                 this);
  }
}