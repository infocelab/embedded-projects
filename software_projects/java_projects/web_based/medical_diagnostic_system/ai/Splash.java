import javax.swing.*;
import java.awt.*;

/**
 This program has been solely programmed for an AI project and not meant for any business means.
 If you intend to you the code please do so freely on condition you acknowledge us.
 Created by Group 13 - CyberVision softwares.
 The ODBC datasource name is AI please do not forget to set that before running then program.
 Please do not hesitate to submit any bug to us.
 you can mail us on dh002211@ex.apiit.edu.my

 @author Asrar Ahmed Makrani
 @version 1.4.0 build 3
 */

public class Splash implements Runnable, mainInterface{
private String initMsg;

public Splash(String initMsg) {
this.initMsg = initMsg; 
}

public void run() {
splashWindow.getContentPane().add(l, BorderLayout.CENTER);
splashWindow.pack();
splashWindow.setSize(splashWindow.getSize().width, splashWindow.getSize().height);
splashWindow.setLocation(dim.width/2 - splashWindow.getWidth() /2,dim.height/2 -
splashWindow.getHeight()/2);
splashWindow.toFront();
splashWindow.show(); } 

public JWindow getWindow()
{ 
return splashWindow;
}

}