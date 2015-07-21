import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.text.*;

public class LcdClockPanel extends JPanel{
  private SimpleDateFormat formatter = new SimpleDateFormat();
  private Date currentDate;
  private LcdTable lcdTable = new LcdTable();  
  private javax.swing.Timer timer;
  private String paramFormat;
  private StringBuffer clockString;
  private boolean colonShow = true;
  private String paramColor;
  private String paramBlinking;
  private static final int clockUpdateDelay = 10;
  private static final int blinkingDelay = 1000;

  public class LcdClockUpdate extends Thread{
    public void run() {
      while(true){
        drawTime();
        try{sleep(clockUpdateDelay);} catch(InterruptedException e){}
      }
    }      
  }

  public class BlinkingUpdate extends Thread{
    public void run() {
      while(true){
        colonShow = !colonShow;
        try{sleep(blinkingDelay);} catch(InterruptedException e){}
      }
    }      
  }
  
  public LcdClockPanel(String paramFormat,String paramColor,String paramBlinking){
    this.paramFormat = paramFormat;
    this.paramColor = paramColor;
    this.paramBlinking = paramBlinking;
    setLayout(new BorderLayout());
    add(lcdTable,BorderLayout.CENTER);
    LcdClockUpdate lcdClockUpdate = new LcdClockUpdate();
    lcdClockUpdate.start();
    BlinkingUpdate blinkingUpdate = new BlinkingUpdate();
    if (paramBlinking.equalsIgnoreCase("true")) blinkingUpdate.start();
  }

  public void drawTime(){
    currentDate = new Date();
    formatter.applyPattern(paramFormat);
    clockString = new StringBuffer(formatter.format(currentDate).toString());
    for (int i=0;i<clockString.length();i++){
      if (paramFormat.charAt(i) == ':'){
        if (colonShow == true) clockString.setCharAt(i,':'); 
        else clockString.setCharAt(i,'a');
      }
    }
    lcdTable.lcdString = clockString.toString();
    lcdTable.backColor = new Color(Integer.parseInt(paramColor,16));
  }
}