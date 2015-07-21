/**
 * @author kusno
 */
import java.sql.*;
import java.io.*;
import java.util.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer.*;
import net.sf.jasperreports.view.JRViewer;
import javax.swing.*;
import java.awt.*;

public class Report extends javax.swing.JDialog{   
     
    public void loadReport(String fileName, ResultSet rs, HashMap hm)
    {
        try
        {            
            File file = new File(".");
            String absolutePath = file.getAbsolutePath();            
            String temp = absolutePath.replace(".","");
            temp = temp.replace("\\", "/");            
            String reportFile = temp + "reports/" + fileName;                                  
            
            JasperPrint jasperPrint;       
            JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportFile);          
            if(hm != null)
            {
                jasperPrint = JasperFillManager.fillReport (jasperReport, hm, jrRS);               
            }                   
            else
            {
                jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrRS);
            }              
            JRViewer aViewer = new JRViewer(jasperPrint);                  
            JDialog viewer = new JDialog(); 	
            viewer.setTitle(".: Jasper Report :.");             
            viewer.setAlwaysOnTop(true);
            viewer.getContentPane().add(aViewer);                  
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
            viewer.setBounds(0,0,screenSize.width, screenSize.height);
            viewer.setVisible(true);
        }
        catch(JRException e)
        {
               JOptionPane.showMessageDialog(null, e.toString(),"Warning",JOptionPane.OK_OPTION);
        }       
    }
    
    public Report()
    {
        
    }
}
