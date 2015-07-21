 import javax.swing.*;
   import javax.swing.tree.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.sql.*;
   import javax.swing.JOptionPane;
   import javax.swing.border.*;
   import javax.swing.ImageIcon.*;
   import java.util.*;
   import java.io.*;
   import javax.swing.JTree;
   import javax.swing.tree.DefaultMutableTreeNode;
   import javax.swing.tree.TreeSelectionModel;
   import javax.swing.event.TreeSelectionEvent;
   import javax.swing.event.TreeSelectionListener;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
     import java.net.URL;
   import java.io.IOException;
   import java.awt.Dimension;
import java.awt.GridLayout;
public class MainDatabase
{
	ResultSet resultSet_;
	public DatabaseManager database;
   	Hashtable DATABASE;
   	 void getCollection()
	{
		DATABASE = new Hashtable();
		//database = new DatabaseManager(this,"mes/dbase/DBMaster.mdb");
		database = new DatabaseManager(this,"AppServ/mysql/data/dbmaster");//,"c:/AppServ/mysql/data/dbmaster");
	 try
	   {
		DATABASE.put("studentmaster",database.executeQuery("SELECT * FROM studentmaster ORDER BY IDNumber ASC"));
		DATABASE.put("temp",database.executeQuery("SELECT * FROM temp ORDER BY IDNumber ASC"));
		DATABASE.put("FacultyMaster",database.executeQuery("SELECT * FROM FacultyMaster ORDER BY EmployeeNo ASC"));
		DATABASE.put("enrollment_data",database.executeQuery("SELECT * FROM enrollment_data ORDER BY IDNumber ASC"));
		DATABASE.put("facultyloading_data",database.executeQuery("SELECT * FROM facultyloading_data ORDER BY EmployeeNo ASC"));
		DATABASE.put("class_schedule",database.executeQuery("SELECT * FROM class_schedule ORDER BY ClassNo ASC"));
		DATABASE.put("Courses",database.executeQuery("SELECT * FROM Courses ORDER BY CourseCode ASC"));
		DATABASE.put("classAttendance_data",database.executeQuery("SELECT * FROM classAttendance_data ORDER BY ClassNo ASC"));


		}
		catch(Exception ex)
		{
		System.out.println("DATABASE QUERY ERROR "+ex.getMessage());
	   // System.err.println(ex);
		}
	  }
	public DataCollection getCollection(String key)
	{
		DataCollection col = (DataCollection)DATABASE.get(key);
		if(col == null)
		{
			return new DataCollection();
		}
		return col;
	}
	//code patch 07/10/2006
		public ResultSet getResultSet() {
			ResultSet rs = null;
			//try {
				rs = database.getStockMasterResultSet2();
		//} catch ( SQLException sqle ) {
				//System.out.println ( sqle.getMessage() );
			//}

			return rs;
		}


	public ResultSet getResultSet2() {
			ResultSet rs = null;
			//try {
				rs = database.getStockMasterResultSet();
		//} catch ( SQLException sqle ) {
				//System.out.println ( sqle.getMessage() );
			//}

			return rs;
		}

	public ResultSet getResultSet3() {
			ResultSet rs = null;
			//try {
				rs = database.getStockMasterResultSet3();
		//} catch ( SQLException sqle ) {
				//System.out.println ( sqle.getMessage() );
			//}

			return rs;
	}
}
