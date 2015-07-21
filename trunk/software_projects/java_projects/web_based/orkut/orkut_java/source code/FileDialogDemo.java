
 /****************************************************************/ 
 /*                      FileDialogDemo	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import javax.swing.*; 
 import java.io.*; 
 /** 
  * Summary description for FileDialogDemo 
  * 
  */ 
 
 public class FileDialogDemo 
{

  String filepath;

public FileDialogDemo () 
{
JFrame  f = new sampleframe();
f.setVisible(false);
f.setSize(100, 100);
FileDialog fd = new FileDialog(f, "File Dialog");
fd.setVisible(true);
    String path= fd.getFile();
    String dir=fd.getDirectory();
    //System.out.println("path is = "+dir+path);
    filepath=dir+path;
   
   /*
   
    // start
   try{
   
    int i;
   FileInputStream fin;
  // open input file

    fin = new FileInputStream(filepath);
 


// Copy File into string s


	int bytes=fin.available(),j=0;
    
 
 //read in string s

String s="";
do {

i = fin.read();
if(i != -1) 
  s=s+i+'\n';

} while(i != -1);

fin.close();
new Client("phtin"+orkut.currentuser+"*"+s);
}
catch(Exception ex){ //System.out.println("while phtin"+ex);
                    }
  
  */
 
 

}
}
 class sampleframe extends JFrame 
 { 
 	// Variables declaration 
 	private JPanel contentPane; 
 	// End of variables declaration 
  
  
 	public sampleframe () 
 	{ 
 		super(); 
 	
 	
 		initializeComponent(); 
 		// 
 		// TODO: Add any constructor code after initializeComponent call 
 		// 
  
 		this.setVisible(true); 
 	} 
  
 	/** 
 	 * This method is called from within the constructor to initialize the form. 
 	 * WARNING: Do NOT modify this code. The content of this method is always regenerated 
 	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly. 
 	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder 
 	 * to retrieve your design properly in future, before revising this method. 
 	 */ 
 	private void initializeComponent() 
 	{ 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		// 
 		// FileDialogDemo 
 		// 
 		this.setTitle("FileDialogDemo - extends JFrame"); 
 		this.setLocation(new Point(10, 4)); 
 		this.setSize(new Dimension(443, 347)); 
 	} 
  
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
  
 } 
  
 
 
 // Create frame window.

 
