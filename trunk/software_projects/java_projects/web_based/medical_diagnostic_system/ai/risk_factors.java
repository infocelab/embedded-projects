import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

public class risk_factors extends JPanel
{
	public JLabel title = new JLabel("Calculate your Angina risk factor");
	public JLabel result = new JLabel("Results");
	
	public JLabel age = new JLabel("1. What is your age? ");
	public JLabel gender = new JLabel("2. What is your gender? ");
	public JLabel history = new JLabel("3. Did anyone in your family have cardiac disease?");
	public JLabel smoke = new JLabel("4. Do you smoke? ");
	public JLabel obes = new JLabel("5. Do you suffer from obessity? ");
	public JLabel diab = new JLabel("6. Do you suffer from Diabetes? ");
	public JLabel hyper = new JLabel("7. Do you suffer from hypertension?");
	public JLabel chol = new JLabel("8. Is your cholestoral level high?");
	public JLabel stress = new JLabel("9. Do you face any kind of stress?");
	public JLabel work = new JLabel("10. What is the nature of your work?");
	
	public JTextField age2 = new JTextField(20);
	public JTextField gender2 = new JTextField(20);
	public JTextField history2 = new JTextField(20);
	public JTextField smoke2 = new JTextField(20);
	public JTextField obes2 = new JTextField(20);
	public JTextField diab2 = new JTextField(20);
	public JTextField hyper2 = new JTextField(20);
	public JTextField chol2 = new JTextField(20);
	public JTextField stress2 = new JTextField(20);
	public JTextField work2 = new JTextField(20);
	
	public String yes_no[] = {"Yes","No"};
	public String ageString[] = {"Below 40","Above 40"};
	public String genderString[] = {"Male","Female"};
	public String workString[] = {"Excessive excersise","Normal"};
	
	public JComboBox cb1 = new JComboBox(ageString);
	public JComboBox cb2 = new JComboBox(genderString);
	public JComboBox cb3 = new JComboBox(yes_no);
	public JComboBox cb4 = new JComboBox(yes_no);
	public JComboBox cb5 = new JComboBox(yes_no);
	public JComboBox cb6 = new JComboBox(yes_no);
	public JComboBox cb7 = new JComboBox(yes_no);
	public JComboBox cb8 = new JComboBox(yes_no);
	public JComboBox cb9 = new JComboBox(yes_no);
	public JComboBox cb10 = new JComboBox(workString);
	
	public JTextField ageOutput, genderOutput, historyOutput, smokeOutput,
					obesOutput, diabOutput, hyperOutput, cholOutput, stressOutput, workOutput;

	
	public JButton submit = new JButton("Submit");
	public JButton back = new JButton("Back");
	
	public JLabel outPut;
	
	public int ctr = 0;
	
	public int risk_level = 0;
	
	public JEditorPane editor;
	
	public risk_factors()
	{
		setLayout(null);
		setSize(400,600);
		setBackground(Color.gray);
		launch2();
				
		
		submit.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	ctr = 0;
            	risk_level = 0;
            	
            	if((cb1.getSelectedItem().toString()).equals("Above 40"))
            	{
            		ctr++;
            	}
            	if((cb2.getSelectedItem().toString()).equals("Male"))
            	{
            		ctr++;
            	}
            	if((cb3.getSelectedItem().toString()).equals("Yes"))
            	{
            		ctr++;
            	} 
            	if((cb4.getSelectedItem().toString()).equals("Yes"))
            	{
            		ctr++;
            	} 
            	if((cb5.getSelectedItem().toString()).equals("Yes"))
            	{
            		ctr++;
            	} 
            	if((cb6.getSelectedItem().toString()).equals("Yes"))
            	{
            		ctr++;
            	} 
            	if((cb7.getSelectedItem().toString()).equals("Yes"))
            	{
            		ctr++;
            	} 
            	if((cb8.getSelectedItem().toString()).equals("Yes"))
            	{
            		ctr++;
            	} 
            	if((cb9.getSelectedItem().toString()).equals("Yes"))
            	{
            		ctr++;
            	} 
            	if((cb10.getSelectedItem().toString()).equals("Excessive excersise"))
            	{
            		ctr++;
            	}      
            	
            	risk_level = ctr*10;
            			
            			removeAll();
            			repaint();
            			
            			ageOutput = new JTextField(20);
            			ageOutput.setText((cb1.getSelectedItem().toString()));
            			ageOutput.setEditable(false);
						
						genderOutput = new JTextField(20);
						genderOutput.setText((cb2.getSelectedItem().toString()));
						genderOutput.setEditable(false);
						
						historyOutput = new JTextField(20);
						historyOutput.setText((cb3.getSelectedItem().toString()));
						historyOutput.setEditable(false);
						
						smokeOutput = new JTextField(20);
						smokeOutput.setText((cb4.getSelectedItem().toString()));
						smokeOutput.setEditable(false);
						
						obesOutput = new JTextField(20);
						obesOutput.setText((cb5.getSelectedItem().toString()));
						obesOutput.setEditable(false);
						
						diabOutput = new JTextField(20);
						diabOutput.setText((cb6.getSelectedItem().toString()));
						diabOutput.setEditable(false);
						
						hyperOutput = new JTextField(20);
						hyperOutput.setText((cb7.getSelectedItem().toString()));
						hyperOutput.setEditable(false);
						
						cholOutput = new JTextField(20);
						cholOutput.setText((cb8.getSelectedItem().toString()));
						cholOutput.setEditable(false);
						
						stressOutput = new JTextField(20);
						stressOutput.setText((cb9.getSelectedItem().toString()));
						stressOutput.setEditable(false);
						
						workOutput = new JTextField(20);
						workOutput.setText((cb10.getSelectedItem().toString()));
						workOutput.setEditable(false);
						
						launch();
            }
        });	
        
	}
	
	public void launch()
	{
		age2.setText("1. What is your age? ");
		gender2.setText("2. What is your gender? ");
		history2.setText("3. Did anyone in your family have cardiac disease?");
		smoke2.setText("4. Do you smoke? ");
		obes2.setText("5. Do you suffer from obessity? ");
		diab2.setText("6. Do you suffer from Diabetes? ");
		hyper2.setText("7. Do you suffer from hypertension?");
		chol2.setText("8. Is your cholestoral level high?");
		stress2.setText("9. Do you face any kind of stress?");
		work2.setText("10. What is the nature of your work?");
		
		result.setBounds(150,10,100,20);
		result.setFont(new Font ("Roman", Font.BOLD, 14));
		result.setForeground(Color.BLUE);
		add(result);
		
		age2.setBounds(10,40,300,20);
		age2.setEditable(false);
		age2.setBackground(new Color(230, 210, 5));
		add(age2);
		
		ageOutput.setBounds(310,40,150,20);
		ageOutput.setEditable(false);
		ageOutput.setBackground(new Color(100, 210, 53));
		add(ageOutput);
		
		gender2.setBounds(10,60,300,20);
		gender2.setEditable(false);
		gender2.setBackground(new Color(230, 210, 5));
		add(gender2);
		
		genderOutput.setBounds(310,60,150,20);
		genderOutput.setEditable(false);
		genderOutput.setBackground(new Color(100, 210, 53));
		add(genderOutput);
		
		history2.setBounds(10,80,300,20);
		history2.setEditable(false);
		history2.setBackground(new Color(230, 210, 5));
		add(history2);
		
		historyOutput.setBounds(310,80,150,20);
		historyOutput.setEditable(false);
		historyOutput.setBackground(new Color(100, 210, 53));
		add(historyOutput);
		
		smoke2.setBounds(10,100,300,20);
		smoke2.setEditable(false);
		smoke2.setBackground(new Color(230, 210, 5));
		add(smoke2);
		
		smokeOutput.setBounds(310,100,150,20);
		smokeOutput.setEditable(false);
		smokeOutput.setBackground(new Color(100, 210, 53));
		add(smokeOutput);
		
		obes2.setBounds(10,120,300,20);
		obes2.setEditable(false);
		obes2.setBackground(new Color(230, 210, 5));
		add(obes2);
		
		obesOutput.setBounds(310,120,150,20);
		obesOutput.setEditable(false);
		obesOutput.setBackground(new Color(100, 210, 53));
		add(obesOutput);
		
		diab2.setBounds(10,140,300,20);
		diab2.setEditable(false);
		diab2.setBackground(new Color(230, 210, 5));
		add(diab2);
		
		diabOutput.setBounds(310,140,150,20);
		diabOutput.setEditable(false);
		diabOutput.setBackground(new Color(100, 210, 53));
		add(diabOutput);
		
		hyper2.setBounds(10,160,300,20);
		hyper2.setEditable(false);
		hyper2.setBackground(new Color(230, 210, 5));
		add(hyper2);
		
		hyperOutput.setBounds(310,160,150,20);
		hyperOutput.setEditable(false);
		hyperOutput.setBackground(new Color(100, 210, 53));
		add(hyperOutput);
		
		chol2.setBounds(10,180,300,20);
		chol2.setEditable(false);
		chol2.setBackground(new Color(230, 210, 5));
		add(chol2);
		
		cholOutput.setBounds(310,180,150,20);
		cholOutput.setEditable(false);
		cholOutput.setBackground(new Color(100, 210, 53));
		add(cholOutput);
		
		stress2.setBounds(10,200,300,20);
		stress2.setEditable(false);
		stress2.setBackground(new Color(230, 210, 5));
		add(stress2);
		
		stressOutput.setBounds(310,200,150,20);
		stressOutput.setEditable(false);
		stressOutput.setBackground(new Color(100, 210, 53));
		add(stressOutput);
		
		work2.setBounds(10,220,270,20);
		work2.setEditable(false);
		work2.setBackground(new Color(230, 210, 5));
		add(work2);
		
		workOutput.setBounds(280,220,150,20);
		workOutput.setEditable(false);
		workOutput.setBackground(new Color(100, 210, 53));
		add(workOutput);
		
		outPut = new JLabel("*Risk Score: Your estimated risk level is "+String.valueOf(risk_level)+"%");
		outPut.setBounds(10, 260, 300, 20);
		outPut.setBackground(Color.gray);
		add(outPut);
		
		launchWarning();
		
		back.setBounds(100,550,100,20);
		back.setBackground(Color.gray);
		add(back);
		
		back.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	removeAll();
            	repaint();
            	launch2();
            }
        });
		
		validate();
	}
	
	public void launch2()
	{
				
		title.setBounds(50,10,300,20);
		title.setFont(new Font ("Roman", Font.BOLD, 14));
		title.setForeground(Color.BLUE);
		add(title);
		
		age.setBounds(10,50,200,20);
		add(age);
		
		cb1.setBounds(170,48,80,20);
		cb1.setBackground(Color.gray);
		add(cb1);
		
		gender.setBounds(10,80,200,20);
		add(gender);
		
		cb2.setBounds(170,78,80,20);
		cb2.setBackground(Color.gray);
		add(cb2);
		
		history.setBounds(10,110,300,20);
		add(history);
		
		cb3.setBounds(310,108,50,20);
		cb3.setBackground(Color.gray);
		add(cb3);
		
		smoke.setBounds(10,140,200,20);
		add(smoke);
		
		cb4.setBounds(170,138,50,20);
		cb4.setBackground(Color.gray);
		add(cb4);
		
		obes.setBounds(10,170,200,20);
		add(obes);
		
		cb5.setBounds(220,168,50,20);
		cb5.setBackground(Color.gray);
		add(cb5);
		
		diab.setBounds(10,200,200,20);
		add(diab);
		
		cb6.setBounds(220,198,50,20);
		cb6.setBackground(Color.gray);
		add(cb6);
		
		hyper.setBounds(10,230,350,20);
		add(hyper);
		
		cb7.setBounds(220,228,50,20);
		cb7.setBackground(Color.gray);
		add(cb7);
		
		chol.setBounds(10,260,200,20);
		add(chol);
		
		cb8.setBounds(220,258,50,20);
		cb8.setBackground(Color.gray);
		add(cb8);
		
		stress.setBounds(10,290,200,20);
		add(stress);
		
		cb9.setBounds(220,288,50,20);
		cb9.setBackground(Color.gray);
		add(cb9);
		
		work.setBounds(10,320,250,20);
		add(work);
		
		cb10.setBounds(220,318,150,20);
		cb10.setBackground(Color.gray);
		add(cb10);
		
		submit.setBounds(100,350,100,20);
		submit.setBackground(Color.gray);
		add(submit);
		
		validate();
	}
	
	public void launchWarning()
		{
		try
		{
			URL url = null;
			try 
			{
				url = getClass().getResource("warning.htm");
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
	                scroller.setBorder(null);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(10,280,390,250);
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