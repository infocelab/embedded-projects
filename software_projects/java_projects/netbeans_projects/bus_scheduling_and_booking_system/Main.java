import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.applet.Applet;
import javax.swing.*;
import java.lang.StringBuffer;
import java.io.IOException;
import java.io.*;
import java.text.*;
import java.sql.*;  
import java.awt.print.*;
public class Main extends JPanel implements Printable{
	Dimension screen 		= Toolkit.getDefaultToolkit().getScreenSize();
    JFrame JFParentFrame;
	private static JTable jTable;
	private JScrollPane jScrollPane;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JButton jButton1,Reload,close;
	private JButton jButton2;
	//private JButton jButton3;
	
	private JButton jButton4;
	private SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
	private static int rowCnt = 0;
	private static int selectedRow;
    private static JTextArea txtInfo=new JTextArea( 15, 40 );
	private Connection dbconn;
	private static String info;
	
	public Main() {
		jTable = new JTable(new AbstractTable());
		javax.swing.table.TableColumn column = null;
		for(int i = 0; i < 7; i++) {
			
			
			
			column = jTable.getColumnModel().getColumn(i);
		   if (i==4)
				sdf.format(i);
		   
		}
		
		jScrollPane = new JScrollPane(jTable);
		
		jPanel1 = new JPanel(new BorderLayout());
		jPanel1.add(jScrollPane, BorderLayout.CENTER);
		jButton1 = new JButton("ADD NEW",new ImageIcon("Icon/i16x16/contents.png"));
		jButton2 = new JButton("UPDATE",new ImageIcon("Icon/i16x16/reset.png"));
		Reload=new JButton("REFRESH",new ImageIcon("Icon/i16x16/reload.png"));
		close=new JButton("CLOSE",new ImageIcon("Icon/i16x16/exit.png"));
		jButton4 = new JButton("PRINT",new ImageIcon("Icon/i16x16/prints.png"));
		jPanel2 = new javax.swing.JPanel(new java.awt.FlowLayout());
		jPanel2.add(jButton1);
		jPanel2.add(jButton2);
		
		jPanel2.add(Reload);
		jPanel2.add(jButton4);
		jPanel2.add(close); 
			try

         {
	
                Statement s = Connect.getConnection().createStatement();
          }

     
      catch ( Exception excp )

        {
            excp.printStackTrace();
       	}       
     
		
        reloaded();
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
			new AddEntry().setVisible(true);
			
			}
		});
			close.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
						     setVisible(false);
			}
		});
		
          
            Reload.addActionListener (new ActionListener(){
            	public void actionPerformed(ActionEvent e){
            		setVisible(false);
            		reloaded();
            		setVisible(true);
            	}
            });
         
        
        jButton4.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
          /*PrinterJob pj=PrinterJob.getPrinterJob();
          pj.setPrintable(Main.this);
          pj.printDialog();
          try{ 
            pj.print();
          }catch (Exception PrintException) {}*/
          new Bus_Details().setVisible(true);
          }
        });

	   jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				new UpdateEntry(jTable.getValueAt(getSelectedRow(), 0).toString(),
								jTable.getValueAt(getSelectedRow(), 1).toString(),
								jTable.getValueAt(getSelectedRow(), 2).toString(),
								jTable.getValueAt(getSelectedRow(), 3).toString(),
								jTable.getValueAt(getSelectedRow(), 4).toString(),
								jTable.getValueAt(getSelectedRow(), 5).toString(),
								jTable.getValueAt(getSelectedRow(), 6).toString(),
								jTable.getValueAt(getSelectedRow(), 7).toString()).setVisible(true);
			}
		});
         
		jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);
		jPanel1.setPreferredSize(new java.awt.Dimension(1000, 300));
        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBounds(2,200,770,2);
		setSize(1000,400);
		add(jPanel1);
	}


	public static int getSelectedRow() {
		jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		javax.swing.ListSelectionModel rowSel = jTable.getSelectionModel();
		rowSel.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) return;

				javax.swing.ListSelectionModel sel = (ListSelectionModel)e.getSource();
				if (!sel.isSelectionEmpty()) {
					selectedRow = sel.getMinSelectionIndex();
				}
			}
		});

		return selectedRow;
	}

	class AbstractTable extends javax.swing.table.AbstractTableModel {
		private String[] columnNames = { "RegNo","BusNo","Model", "Capacity" ,
		"Date purchased","Insurance Status","Date Insured","Expiry Date"};
		private Object[][] data = new Object[50][50];

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}
	public void reloaded(){
			try
				{
					Statement statement =Connect.getConnection().createStatement();
					{
					  String temp = ("SELECT * FROM Buses ORDER BY BusNo");
					   int  Numrow = 0;
					   ResultSet result = statement.executeQuery(temp);
					   while (result.next()) {
                         jTable.setValueAt(result.getString(1).trim(),Numrow,0);
                         jTable.setValueAt(result.getString(2).trim(),Numrow,1);
                         jTable.setValueAt(result.getString(3).trim(),Numrow,2);
                         jTable.setValueAt(result.getString(4).trim(),Numrow,3);
                         jTable.setValueAt(result.getDate(5),Numrow,4);
                         jTable.setValueAt(result.getString(6).trim(),Numrow,5);
                         jTable.setValueAt(result.getDate(7),Numrow,6);
                         jTable.setValueAt(result.getDate(8),Numrow,7);
                         	sdf.format(7);
                         Numrow++;
                       
					   }	
				}
				
			}
			catch ( SQLException sqlex ) {
               
             }
		}
		public int print(Graphics g, PageFormat pageFormat, 
        int pageIndex) throws PrinterException {
     	Graphics2D  g2 = (Graphics2D) g;
     	g2.setColor(Color.black);
     	int fontHeight=g2.getFontMetrics().getHeight();
     	int fontDesent=g2.getFontMetrics().getDescent();

     	//leave room for page number
     	double pageHeight = pageFormat.getImageableHeight()-fontHeight;
     	double pageWidth = pageFormat.getImageableWidth();
     	double tableWidth = (double) jTable.getColumnModel().getTotalColumnWidth();
     	double scale = 1; 
     	if (tableWidth >= pageWidth) {
		scale =  pageWidth / tableWidth;
	       }

     	double headerHeightOnPage=
                      jTable.getTableHeader().getHeight()*scale;
     	double tableWidthOnPage=tableWidth*scale;

     	double oneRowHeight=(jTable.getRowHeight()+
                      jTable.getRowMargin())*scale;
     	int numRowsOnAPage=
                      (int)((pageHeight-headerHeightOnPage)/oneRowHeight);
     	double pageHeightForTable=oneRowHeight*numRowsOnAPage;
     	int totalNumPages= (int)Math.ceil((
                      (double)jTable.getRowCount())/numRowsOnAPage);
     	if(pageIndex>=totalNumPages) {
                      return NO_SUCH_PAGE;
     	}

     	g2.translate(pageFormat.getImageableX(), 
                       pageFormat.getImageableY());
     	g2.drawString("Page: "+(pageIndex+1),(int)pageWidth/2-35,
                      (int)(pageHeight+fontHeight-fontDesent));//bottom center

     	g2.translate(0f,headerHeightOnPage);
     	g2.translate(0f,-pageIndex*pageHeightForTable);
     	if (pageIndex + 1 == totalNumPages) {
                     int lastRowPrinted = numRowsOnAPage * pageIndex;
                     int numRowsLeft = jTable.getRowCount() - lastRowPrinted;
                     g2.setClip(0, (int)(pageHeightForTable * pageIndex),
                       (int) Math.ceil(tableWidthOnPage),
                       (int) Math.ceil(oneRowHeight * numRowsLeft));
     	}
     	
     	else{    
                     g2.setClip(0, (int)(pageHeightForTable*pageIndex), 
                     (int) Math.ceil(tableWidthOnPage),
                     (int) Math.ceil(pageHeightForTable));        
     	}
     	g2.scale(scale,scale);
     	jTable.paint(g2);
     	g2.scale(1/scale,1/scale);
     	g2.translate(0f,pageIndex*pageHeightForTable);
     	g2.translate(0f, -headerHeightOnPage);
     	g2.setClip(0, 0,(int) Math.ceil(tableWidthOnPage), 
                               (int)Math.ceil(headerHeightOnPage));
     	g2.scale(scale,scale);
     	jTable.getTableHeader().paint(g2);//paint header at top

     	return Printable.PAGE_EXISTS;
   }

	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new LoginScreen().setVisible(true);
	}
}