import java.awt.*;
import javax.swing.*;
import java.util.Date;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.SwingUtilities;
import javax.swing.plaf.metal.MetalLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PPProgressBar extends JFrame //implements ActionListener
{
//////////////////////////////////DECLARATIONS////////////////////////////////////////////
    public final static int ONE_SECOND = 1000;

//////////////////////////	PROGRESS BAR 	declarations	////////////////////////////

    private JProgressBar progressBar;
    private Timer timer;
    private JButton startButton;
    private LongTask task;
    private String newline = "\n";

  

JPanel new_proj_prog_panel;


public PPProgressBar()
{



	 new_proj_prog_panel = new JPanel();




////////////////////////////// ADDING PROGRESS BAR /////////////////////////////////////////
        task = new LongTask();

        //Create the demo's UI.
        startButton = new JButton("Start");
        startButton.setActionCommand("start");
        startButton.addActionListener(new ButtonListener());

        progressBar = new JProgressBar(0, task.getLengthOfTask());
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        JPanel panel = new JPanel();
        new_proj_prog_panel.add(startButton);
        new_proj_prog_panel.add(progressBar);

        //Create a timer.
        timer = new Timer(ONE_SECOND, new ActionListener()
		{
            public void actionPerformed(ActionEvent evt) 
			{
                progressBar.setValue(task.getCurrent());
                if (task.done())
				{
					Toolkit.getDefaultToolkit().beep();
                    timer.stop();
                    startButton.setEnabled(true);
                    progressBar.setValue(progressBar.getMinimum());
                }
            }
        });
        }

     //////////////  Button Listener class for PROGRESS BAR  ///////////////////////////////////
   class ButtonListener implements ActionListener 
   {
        public void actionPerformed(ActionEvent evt)
		{
            startButton.setEnabled(false);
            task.go();
            timer.start();
        }
    }	
	public static void main(String a[])//throws Exception
	{
		ProgressBarDemo progress = new ProgressBarDemo();	
		JFrame mf=new PPProgressBar();
		progress.setVisible(true);
		mf.setBounds(0,0,800,600);
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.setVisible(true);
		mf.setResizable(true);
	}
	









}