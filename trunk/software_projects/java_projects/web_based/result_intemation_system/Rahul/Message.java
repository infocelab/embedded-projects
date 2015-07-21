import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.plaf.metal.*;
class Message extends Thread
{
    SplashWindow sw;
    String imagename;
    Message(String in)
    {
		imagename=in;
	//	sw = new SplashWindow(this,imagename);
    //   try
    //   {
	//  		Thread.sleep(5000);
    //   }
    //   catch(InterruptedException ie){}
    //   sw.close();
//
    //   sw.dispose();

     }
     public void run()
     {
		 sw = new SplashWindow(imagename);
		 try
		 {
		  		Thread.sleep(5000);
		 }
		 catch(InterruptedException ie){}
		synchronized(sw)
		{
			sw.close();
		}

       sw.dispose();
	 }
     public static void main(String args[])
     {
	   Message m=new Message("Msg.jpg");
	   m.start();
	 }
}

class SplashWindow extends JWindow
{
	Dimension screenDim;
    SplashWindow(final String imagename)
    {
		setAlwaysOnTop(true);
		setFocusableWindowState(true);
		screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	  	setLocation(screenDim.width - 200,screenDim.height - 20);
		JPanel ps=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				MediaTracker mt = new MediaTracker(this);
				Image splashIm = Toolkit.getDefaultToolkit().getImage(imagename);
				mt.addImage(splashIm,0);
				while(true)
				{
					try
					{
						  mt.waitForID(0);
						  break;
					}
					catch(InterruptedException ie){}
				}
				g.drawImage(splashIm,0,0,200,200,null);
			}
		};
		add(ps);
		ps.setBorder(new MatteBorder(5,5,5,5,new Color(204,204,255)) );
		//for(int i=0; i<200;i++)
		//{
	    //	setSize(i, getHeight());
		//}
		//for(int j=0;j<200;j++)
		//{
		//	setSize(getWidth(),j);
		//}
		setSize(200,200);
		setVisible(true);
		for(int j=0;j<200;j++)
		{
			try
			{
				Thread.sleep(5);
			}
			catch(Exception es){}
			setLocation(screenDim.width - 200,(screenDim.height-30) - j);
		}
	}
	synchronized public void close()
	{
		for(int j=0;j<200;j++)
		{
			setLocation(screenDim.width - 200,(screenDim.height-200) + j);
			try
			{
				Thread.sleep(5);
			}
			catch(Exception es){}

		}
	}
}
