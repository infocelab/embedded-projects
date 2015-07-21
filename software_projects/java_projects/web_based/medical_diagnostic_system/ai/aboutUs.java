import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

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

public class aboutUs extends JPanel
{
	public JEditorPane editor;
	public aboutUs() 
	{
		this.setLayout(null);
		setSize(400,600);
		setBackground(Color.gray);
		launch();
		
	}
	
	public void launch()
		{
		try
		{
			URL url = null;
			try 
			{
				url = getClass().getResource("about.htm");
            } 
            catch (Exception e) 
            {
				System.err.println("Failed to open ");
				url = null;
            }
            
	            if(url != null) 
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        add(scroller);
			     }
		        
		   } 
		   catch (MalformedURLException e) 
		   {
		       System.out.println("Malformed URL: " + e);
		   } 
		   catch (IOException e) 
		   {
		       System.out.println("IOException: " + e);
		   }
		}
	
}
		
		