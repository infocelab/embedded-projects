package com.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SearchDialog
{
	/*parameter of showMyDialog 
	 *student=1
	 *staff(teacher,accountant,registra)=2
	 */
	JPanel myComponent;
	JComboBox choice;
	String student[]={"Subject","SubjectID","Teacher"};
	String officer[]={"Staff_name","Staff_id","Salary"};
	String teacher[]={"Subject"};
	String btnName[]={"Search Now","Dismiss"};
	JScrollPane bb;
	public String showMyDialog(Object parent,int status)
	{
		String sql;//sql statement
		String searchBy[];
		if(status==1)//student
			searchBy=student;
		else if(status==2)//teacher
			searchBy=teacher;
		else//officer
			searchBy=officer;
		choice.addItem(searchBy);
		JOptionPane searchDialog=new JOptionPane();
		if(searchDialog.showOptionDialog(null,myComponent,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,btnName,btnName[0])==0)
		
		return sql;
	}
	private void createSearchDialog()
	{
		myComponent=new JPanel(false);
		choice=new JComboBox();
		JPanel labelPanel=new JPanel(false),
				optionPanel=new JPanel(false);
		JTextField keyWord=new JTextField();
		JLabel choiceLabel=new JLabel("Search by : ",SwingConstants.RIGHT),
				keyLabel=new JLabel("Search by : ",SwingConstants.RIGHT);
		labelPanel.add(choiceLabel);
		labelPanel.add(keyLabel);
		optionPanel.add(choice);
		optionPanel.add(keyWord);
		myComponent.setLayout(new BoxLayout(myComponent,BoxLayout.X_AXIS));
		myComponent.add(labelPanel);
		myComponent.add(optionPanel);	
	}

}
class Main
{
	public static void main(String args[])
	{
		JFrame my=new JFrame();
		my.setSize(200,200);
		my.setVisible(true);
		SearchDialog m=new SearchDialog();
		m.showMyDialog(my,1);
	}
}