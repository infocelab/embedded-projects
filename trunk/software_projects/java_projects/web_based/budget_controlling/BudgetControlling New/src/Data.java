/** 
 * @author kusno
 */

import javax.swing.*;
import java.sql.*;
import java.util.Calendar; 
import java.util.ArrayList;

public class Data 
{    
    Connection cnExecute = null;
    int rowNgefek = 0; 
    Statement stExecute;
             
    public enum typeOfAction
    {
        View, Add , Modify, Delete
    }   
    
    public Data() {

    }   
    
    private static String UserID;
    private static String UserName;
    
    public void setUserID(String userid) 
    {
      this.UserID = userid;
    }

    public String getUserID()
    {
      return UserID;
    } 
    
    public void setUserName(String username) 
    {
      this.UserName = username;
    }

    public String getUserName()
    {
      return UserName;
    } 
    
    public boolean UserRight(String UserID, String FunctionID, typeOfAction act)            
    {        
        String SQL="";
        if(act==typeOfAction.View)
        {
            SQL = "SELECT CanView FROM masterfunctiondetail WHERE FunctionID = '" + FunctionID + "' AND UserID = '" + UserID + "'";
        }else
        if(act==typeOfAction.Add)
        {
            SQL = "SELECT CanAdd FROM masterfunctiondetail WHERE FunctionID = '" + FunctionID + "' AND UserID = '" + UserID + "'";
        }
        else
        if(act==typeOfAction.Modify)
        {
            SQL = "SELECT CanModify FROM masterfunctiondetail WHERE FunctionID = '" + FunctionID + "' AND UserID = '" + UserID + "'";
        }
        else
        if(act==typeOfAction.Delete)
        {
            SQL = "SELECT CanDelete FROM masterfunctiondetail WHERE FunctionID = '" + FunctionID + "' AND UserID = '" + UserID + "'";
        }          
        
        try
        {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next())
            {               
                if(rs.getInt(1)==1)
                {
                    closingConnection (cn,st,rs);
                    return true;    
                }
                else
                {
                    closingConnection (cn,st,rs);
                    return false;    
                }                     
            }
            else
            {
                return false;    
            }
        }
        catch(SQLException e)
        {
            return false;    
        }         
    }
        
    public String UserOK(String UserID, String Password){
        String SQL = "SELECT UserID, Password, Status FROM MasterUser WHERE UserID = '" + UserID + "'";
        String tempResult = "";
        try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next())
            {               
                if(rs.getString("Status").trim().equals("I"))
                {
                    tempResult = "User ID is not active.";
                }else
                if(!rs.getString("Password").trim().equals(Password))
                {
                    tempResult = "Password is wrong.";
                }
                else
                {
                    tempResult = "";
                }
            }
            else
            {
                tempResult = "User ID is not found.";
            }
            closingConnection (cn,st,rs);
        }
        catch(SQLException e)
        {
            
        }
        return tempResult;   
    }

    public void FillComboBox(String SQL, javax.swing.JComboBox cbo, String FirstItem) {
        try {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            cbo.removeAllItems();
            while (rs.next()) {
                cbo.addItem(rs.getString(1));
            }
            if (!FirstItem.equals("")) {
                cbo.insertItemAt(FirstItem, 0);
            }
            cbo.setSelectedIndex(0);
        } catch (SQLException e) 
        {

        }
    }
    
    public void ExecuteSQL(String SQL)
    {
         DBConnection getCn = new DBConnection();
         rowNgefek = 0;
         try {
            cnExecute = getCn.getConnection();           
            stExecute = cnExecute.createStatement();
            cnExecute.setAutoCommit(false);            
            rowNgefek = stExecute.executeUpdate(SQL); 
            cnExecute.commit();            
            closingConnection (cnExecute,stExecute);           
        }
        catch (SQLException e)                 
        {          
            System.out.println(e.toString());  
            JOptionPane.showMessageDialog(null, e.toString(),"Warning",JOptionPane.OK_OPTION);
        }      
     }
     
    public void ExecuteSQL(ArrayList<String>  SQLArray)
    {
         DBConnection getCn = new DBConnection();
         String SQL;      
         rowNgefek = 0;
         try {
            cnExecute = getCn.getConnection();                                 
            stExecute = cnExecute.createStatement();
            cnExecute.setAutoCommit(false);
            for (int i=0;i <= SQLArray.size()-1; i++)
            {
                SQL = SQLArray.get(i).toString().trim();    
                rowNgefek = stExecute.executeUpdate(SQL);                    
            }            
            cnExecute.commit(); 
        }
        catch (SQLException e) 
        {              
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(),"Warning",JOptionPane.OK_OPTION);
        } 
    }

    public void closingConnection(Connection cnClose, Statement stClose, ResultSet rsClose)
    {   
        try
        {
            cnClose.close();  stClose.close(); rsClose.close();
        }
        catch(SQLException e)
        {
            
        }   
    }
    
    public void closingConnection(Connection cnClose, Statement stClose)
    {   
        try
        {
            cnClose.close();  stClose.close();
        }
        catch(SQLException e)
        {
            
        }   
    }
    
    public String getFieldStringValue(String FieldTable, String FieldName, String Value, String FieldResult) {
        String SQL = "SELECT " + FieldResult + " FROM " + FieldTable + " WHERE " + FieldName + " = '" + Value + "'";
        String tempResult = "";
        try {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next())
            {
                tempResult = rs.getString(1).trim();
            }
            closingConnection (cn,st,rs);
        } catch (SQLException e) {
            System.out.println(e);
            tempResult = "";
        }
        return tempResult;
    }
    
    public String getActivePeriod()
    {
        String SQL = "SELECT Year FROM trxperiod where Status = '0'";   
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String tempResult = Integer.toString(year);
        try {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next())
            {
                tempResult = rs.getString(1).trim();
            }
            closingConnection (cn,st,rs);
        } catch (SQLException e) {
           
        }
        return tempResult;
    }
}
 

