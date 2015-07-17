
package criminal_identification;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connect {
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        new ConnectGUI().setVisible(true);
    }
    
    public static Connection  ConnectDB()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
            return conn;
        }catch(ClassNotFoundException | SQLException | HeadlessException e)
        {    
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
}
