import java.sql.*;
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

public class patientSQL
{
	public Connection con;
	public String id, name, sex, age, contact, history;

	
	public patientSQL(String id, String name, String sex, String age, String contact, String history)
	{
		String url = "jdbc:odbc:AI";
		
		//Load the driver to allow connection to the database
		try {
 			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 			con = DriverManager.getConnection(url);
 		}
 		catch(ClassNotFoundException cnfex)  {
 			System.err.println("Failed to load driver");
 			cnfex.printStackTrace();
 			System.exit(1);
 		}
 		catch(SQLException sqlex){
 			System.err.println("unable to connect");
 			sqlex.printStackTrace();
 		}
 		
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.contact = contact;
		this.history = history;		
 		
 	}
		
	
 	public void add()
 	{
 		try
 		{
 					
 			Statement statement = con.createStatement();
 					
 					
 			String query = "INSERT INTO patient (patient_id, name, sex, age, contact, history" + 
 							") VALUES ('" +
 					id +"','" +
 					name +"','" +
 					sex +"','" +
 					age +"','" +
 					contact +"','" +
 					history +"')";
 				
 			int result = statement.executeUpdate(query);
 				
 			if (result == 1)
 			{
 				JOptionPane.showMessageDialog(null, "Insertion succesfull");	
 			}
 				
 			else 
 			{
 				JOptionPane.showMessageDialog(null, "Insertion Failed");
 			}
 			statement.close();
 		}
 		catch(SQLException sqlex) 
 		{
 		}
 	}
 			
 	public void update()
 	{
 		try
 		{
 			Statement statement = con.createStatement();
			String query1 = "UPDATE patient SET " +
			"name ='" + name +
			"', sex ='" + sex +
			"', age ='" + age +
			"', contact ='" + contact +
			"', history ='" + history +
			"' WHERE patient_id LIKE '%" + id + "%'";
														
			int result = statement.executeUpdate(query1);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Update Succesfull");
			}
			statement.close();
			}
			catch (SQLException sqlex) 
			{
				sqlex.printStackTrace();							 			
			}
 				
	}
		
	public void delete()
	{
		try
 		{
	 		Statement statement = con.createStatement();
	 		int rs = JOptionPane.showConfirmDialog(null, "WARNING!! Record once deleted cannot be retrieved!! Continue with delete?", "CONFIRM", JOptionPane.YES_NO_OPTION);
	 		if (rs == JOptionPane.YES_OPTION)
	 		{
		 		String query3 = "delete * from patient "+
 							"where patient_id = '" + id + "'";
		 		int result = statement.executeUpdate(query3);
		 				
				if (result == 1)
				{
					JOptionPane.showMessageDialog(null, "del Succesful");
				}
				statement.close();
		 	}
 		}
 		catch (SQLException sqlex) 
 		{
 			sqlex.printStackTrace();
 		}
	}
}