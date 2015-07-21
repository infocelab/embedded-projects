import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LcdClock extends JApplet{
  private Container container = getContentPane();  
  private LcdClockPanel lcdClockPanel;
  public void init(){
    lcdClockPanel = new LcdClockPanel(getParameter("paramFormat"),getParameter("paramColor"),getParameter("paramBlinking"));
    container.add(lcdClockPanel,BorderLayout.CENTER);
  }
}