import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class DBConnection 
{
    public String PROP_FILE = "initial.ini";
    
    public DBConnection() {
    }

    public Connection getConnection() throws SQLException {
        Connection cn = null;
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            Properties p2 = new Properties();
            p2 = loadProperties(PROP_FILE);             
            String server;
            String database;
            String userID;
            String password;
            String url;
            
            server = p2.getProperty("Server");
            database = p2.getProperty("Database");
            userID = p2.getProperty("UserID");
            password = p2.getProperty("Password");
            
            url = "jdbc:mysql://" + server + "/" + database;
            cn = DriverManager.getConnection (url, userID, password);                        
            return cn;
        }
        catch (SQLException se) 
        {
            System.out.println(se.toString());
            return null;
        } catch (Exception ex) 
        {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public static Properties loadProperties(String sFile) {
        Properties p = new Properties();
            try {
            FileInputStream in = new FileInputStream(sFile);
            p.load(in);            
            in.close();
        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, iOException);
        }
        return p;        
    }
}
