

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileFilter;

/////////////////////////////////////////////////////////////////////////////////////////////

public class Photoshot extends JFrame{

	int brSize = 10;
	int imgNum = -1;
	String imgName = new String("Untitled");
	Color BgColor = Color.WHITE,FgColor = Color.BLACK;
	JDesktopPane desktop = null;
										
	ColBar colbar = null;									
	ToolBar toolbar = null;								    
	InitToolBar initbar = null;							    
	StatusBar statusbar = null;								
	BrushSize brsiz = null;
	PaintWindow paintWin[] = new PaintWindow[10]; 			

	Photoshot(){									 
		initWindow("Photoshot");
	}
	
	public static void main(String[] args) {	
		new Photoshot();
	}
	
	public void initWindow(String title){	
		this.setTitle(title);
		this.setSize(800,600);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);	
		
		this.setJMenuBar(new Menu());
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
	
		this.desktop = new JDesktopPane();
		this.desktop.setBackground(Color.DARK_GRAY);
		c.add(this.desktop,BorderLayout.CENTER);
		
		this.initbar = new InitToolBar();
		c.add(this.initbar,BorderLayout.PAGE_START);
		
		this.statusbar = new StatusBar();
		c.add(this.statusbar,BorderLayout.PAGE_END);
		
		
		this.setVisible(true);		

		this.toolbar =new ToolBar();
		this.desktop.add(this.toolbar);
		
		this.colbar = new ColBar();
		this.desktop.add(this.colbar);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	public class Menu extends JMenuBar implements ActionListener{
		
		JMenu fileMen = null,editMen = null,imageMen = null,aboutMen = null;
		JMenuItem newSm = null,openSm = null,saveSm = null,exitSm = null,
		          unduSm = null,redoSm = null,
		          clearSm = null, vflipSm = null,hflipSm = null,
		          aboutSm = null;
		
		String fileType = null;
		
		Menu(){	
			this.fileType = new String("bmp");
			this.fileMen = new JMenu("File");							
			this.newSm 	= new JMenuItem("New");
			this.openSm = new JMenuItem("Open image"); 
			this.saveSm = new JMenuItem("Save image");
			this.exitSm = new JMenuItem("Exit");	
			this.fileMen.add(this.newSm);
			this.fileMen.add(this.openSm);
			this.fileMen.add(this.saveSm);
			this.fileMen.addSeparator();
			this.fileMen.add(this.exitSm);
			this.newSm.addActionListener(this);
			this.openSm.addActionListener(this);
			this.saveSm.addActionListener(this);
			this.exitSm.addActionListener(this);
			this.add(this.fileMen);
			
			this.editMen = new JMenu("Edit");	
			this.unduSm = new JMenuItem("Undo");
			this.redoSm = new JMenuItem("Redo");		
			this.editMen.add(this.unduSm);
			this.editMen.add(this.redoSm);		
			this.unduSm.addActionListener(this);
			this.redoSm.addActionListener(this);
			this.add(this.editMen);	
			
			this.imageMen = new JMenu("Image");	
			this.clearSm = new JMenuItem("Clear Image");
			this.vflipSm = new JMenuItem("Flip Vertical");
			this.hflipSm = new JMenuItem("Flip Horizontal");
			this.imageMen.add(this.clearSm);
			this.imageMen.addSeparator();
			this.imageMen.add(this.vflipSm);
			this.imageMen.add(this.hflipSm);
			this.clearSm.addActionListener(this);
			this.vflipSm.addActionListener(this);
			this.hflipSm.addActionListener(this);
			this.add(this.imageMen);	
			
			this.aboutMen = new JMenu("About");									
			this.aboutSm = new JMenuItem("About Photoshot");		
			this.aboutMen.add(this.aboutSm);	
			this.aboutSm.addActionListener(this);
			this.add(this.aboutMen);
		}

		
	    class ImageFilter extends FileFilter{  
	    	
	    	String type = new String("bmp");
	    	
	    	ImageFilter(String type){
	    		this.type=type;
	    	}
	    	
	        public boolean accept(File f)
	        { 
	        	if (this.type.equals("all"))
	        	{
	        		if(f.getName().toLowerCase().endsWith(".bmp")
	        				|| f.getName().toLowerCase().endsWith(".jpg")|| f.getName().toLowerCase().endsWith(".png")||  f.isDirectory())
	        			return true; 
	        		else 
	        			return false;  
	        	}
	        	else	        	
	        		if (type.equals("bmp"))
	        		{
	        			if(f.getName().toLowerCase().endsWith(".bmp")||  f.isDirectory())
	        			{
	        				fileType = "bmp";
	        				return true; 
	        			}
	        			else 
	        				return false;         
	        		}	
			        else	        	
			        	if (type.equals("jpg"))
			        	{
			        		if(f.getName().toLowerCase().endsWith(".jpg")||  f.isDirectory())
			        		{
			        			fileType = "jpg";
			        			return true; 
			        		}
			        		else 
			        			return false;         
			        	}	
				    else	        	
				        if (type.equals("png"))
				        {
				        	if(f.getName().toLowerCase().endsWith(".png")||  f.isDirectory())
				        	{
				        		fileType = "png";
				        		return true; 
				        	}
				        	else 
				        		return false;         
				        }	
	        		return false;
	        } 
	        
	        public String getDescription() { 
	        	if (!type.equals("all"))
	        		return new String("*."+this.type); 
	        	else
	        		return new String("All images");
	        }  
	    } 
	    
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == this.newSm)		
				new NewWindow();
			else
				if(e.getSource() == this.openSm)
				{					
					JFileChooser fc = new JFileChooser();

					fc.addChoosableFileFilter(new ImageFilter("bmp")); 
					fc.addChoosableFileFilter(new ImageFilter("jpg"));
					fc.addChoosableFileFilter(new ImageFilter("png"));
					fc.addChoosableFileFilter(new ImageFilter("all"));				
		            fc.setAcceptAllFileFilterUsed(false);
					fc.setDialogTitle("Open Image");

					
				    if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
				    	File file = fc.getSelectedFile();	 
				    	
				         for(int i=0; i<paintWin.length; i++)
				         if(paintWin[i] == null)
				         {
				         	paintWin[i] = new PaintWindow(file,i);				         	
				         	desktop.add(paintWin[i],i);
				         	desktop.getDesktopManager().activateFrame(paintWin[i]);
				         	break;
				         }				       				         
				      }
				}
			else
				if(e.getSource() == this.saveSm)
				{
					if (imgNum != -1)
					{
						JFileChooser fc =new JFileChooser(); 
						fc.setDialogTitle("Save Image");
						fc.addChoosableFileFilter(new ImageFilter("png"));
						fc.addChoosableFileFilter(new ImageFilter("jpg"));
						fc.addChoosableFileFilter(new ImageFilter("bmp")); 
						
			            fc.setAcceptAllFileFilterUsed(false);
			            
						if (imgName !=null)
							fc.setSelectedFile(new File(imgName)); 
						if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
							try 
							{
								File file = new File(fc.getSelectedFile().getAbsolutePath()+"."+fileType);
								ImageIO.write( paintWin[imgNum].getImage(),fileType, file);		
							} 
								catch (IOException ex) {}
						}
					}
				}
			else
				if(e.getSource() == this.unduSm)
					paintWin[imgNum].pb.undo();
			else
				if(e.getSource() == this.redoSm)
					paintWin[imgNum].pb.redo();	
			
			else
				if(e.getSource() == this.clearSm)
				{
					if(imgNum != -1)
						paintWin[imgNum].clearimage();
				}
			else
				if(e.getSource() == this.vflipSm)
				{
					if(imgNum != -1)
						paintWin[imgNum].imageFlip(-1);	
				}
			else
				if(e.getSource() == this.hflipSm)	
				{
					if(imgNum != -1)
						paintWin[imgNum].imageFlip(1);	
				}
			else
				if(e.getSource() == this.exitSm)
				{
					dispose();
					System.exit(0);
				}			
			else
				if(e.getSource() == this.aboutSm)
					JOptionPane.showMessageDialog(null, "         <<< Photoshot 2015 >>>\n\nMade by CELAB\ne-mail: info@computronicslab.com\n ", "About Photoshot", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public class InitToolBar extends JToolBar implements ChangeListener{
		
		JLabel tl1 = null, tl2 = null;
		JSlider brushSize = null;
		
		InitToolBar(){			
			this.setFloatable(false);
			
			this.tl1 = new JLabel(" Brush size: ");
			this.add(this.tl1);
			
			this.brushSize = new JSlider(JSlider.HORIZONTAL,0, 100, 10);		
			this.brushSize.setMajorTickSpacing(10);
			this.brushSize.setPaintTicks(true);
			this.brushSize.addChangeListener(this);
			this.brushSize.setPaintLabels(true);					
			this.add(this.brushSize);	
			
			this.tl2 = new JLabel(Integer.toString(brSize));		
			Font g = new Font ("Geneva", Font.PLAIN, 28);	
			this.tl2.setFont(g);
			this.add(this.tl2);		
		}	
		
		public void stateChanged(ChangeEvent e) {          
	        brSize= (int)this.brushSize.getValue();
	        brsiz.repaint();
	        this.tl2.setText(Integer.toString(brSize));	            
	    }
	}
	
	
	public class StatusBar extends JToolBar{	
		
		JLabel timeLab = null;
		
		StatusBar(){
			this.setFloatable(false);	
			this.timeLab = new JLabel(" ");
			new TimeThread().start();
			this.add(this.timeLab);
		}		
		
		public void updateTime(String time){
			this.timeLab.setText(time);
		}
	}
	
	
	public class ToolBar extends JInternalFrame implements ActionListener{
		
		JPanel toolPan = null;
		JButton brushBut = null, penBut = null,fillBut = null, lineBut = null,
			    recBut = null, cirBut = null,recButC = null, cirButC = null,
			    recFillBut = null, cirFillBut = null;
		
		int toolNum = 1;
		
		ToolBar(){	
			this.setTitle("Tools");
			brsiz = new BrushSize();

			this.setSize(150,400);
			this.setLayout(new BorderLayout());
			this.toolPan = new JPanel();
			this.toolPan.setLayout(new GridLayout(4,2));	
			
			this.brushBut = new JButton(new ImageIcon("Images/brush2s.jpg"));
			this.toolPan.add(this.brushBut);
			this.brushBut.addActionListener(this);
			
			this.penBut = new JButton(new ImageIcon("Images/pen1s.jpg"));
			this.toolPan.add(this.penBut);
			this.penBut.addActionListener(this);
			
			this.fillBut = new JButton(new ImageIcon("Images/fill1s.jpg"));
			this.toolPan.add(this.fillBut);
			this.fillBut.addActionListener(this);
			
			this.lineBut = new JButton(new ImageIcon("Images/line1s.jpg"));
			this.toolPan.add(this.lineBut);
			this.lineBut.addActionListener(this);
			
			this.recBut = new JButton(new ImageIcon("Images/kvad1s.jpg"));
			this.toolPan.add(this.recBut);
			this.recBut.addActionListener(this);
			
			this.recFillBut = new JButton(new ImageIcon("Images/kvadFill1s.jpg"));
			this.toolPan.add(this.recFillBut);
			this.recFillBut.addActionListener(this);
			
			this.cirBut = new JButton(new ImageIcon("Images/krog1s.jpg"));
			this.toolPan.add(this.cirBut);
			this.cirBut.addActionListener(this);
			
			this.cirFillBut = new JButton(new ImageIcon("Images/krogFill1s.jpg"));
			this.toolPan.add(this.cirFillBut);
			this.cirFillBut.addActionListener(this);
		
			this.add(this.toolPan,BorderLayout.PAGE_START);
			this.add(brsiz,BorderLayout.CENTER);
		    this.setVisible(true);
		    

		}

		public int getToolNum(){
			return toolNum;
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.brushBut)
			{
				brushBut.setIcon(new ImageIcon("Images/brush2s.jpg"));
				penBut.setIcon(new ImageIcon("Images/pen1s.jpg"));
				fillBut.setIcon(new ImageIcon("Images/fill1s.jpg"));
				lineBut.setIcon(new ImageIcon("Images/line1s.jpg"));
				recBut.setIcon(new ImageIcon("Images/kvad1s.jpg"));
				cirBut.setIcon(new ImageIcon("Images/krog1s.jpg"));
				recFillBut.setIcon(new ImageIcon("Images/kvadFill1s.jpg"));
				cirFillBut.setIcon(new ImageIcon("Images/krogFill1s.jpg"));
				toolNum = 1;
			}
			else
			if (e.getSource() == this.penBut)
			{
				brushBut.setIcon(new ImageIcon("Images/brush1s.jpg"));
				penBut.setIcon(new ImageIcon("Images/pen2s.jpg"));
				fillBut.setIcon(new ImageIcon("Images/fill1s.jpg"));
				lineBut.setIcon(new ImageIcon("Images/line1s.jpg"));
				recBut.setIcon(new ImageIcon("Images/kvad1s.jpg"));
				cirBut.setIcon(new ImageIcon("Images/krog1s.jpg"));
				recFillBut.setIcon(new ImageIcon("Images/kvadFill1s.jpg"));
				cirFillBut.setIcon(new ImageIcon("Images/krogFill1s.jpg"));
				toolNum = 2;
			}	
			else
			if (e.getSource() == this.fillBut)
			{
				brushBut.setIcon(new ImageIcon("Images/brush1s.jpg"));
				penBut.setIcon(new ImageIcon("Images/pen1s.jpg"));
				fillBut.setIcon(new ImageIcon("Images/fill2s.jpg"));
				lineBut.setIcon(new ImageIcon("Images/line1s.jpg"));
				recBut.setIcon(new ImageIcon("Images/kvad1s.jpg"));
				cirBut.setIcon(new ImageIcon("Images/krog1s.jpg"));
				recFillBut.setIcon(new ImageIcon("Images/kvadFill1s.jpg"));
				cirFillBut.setIcon(new ImageIcon("Images/krogFill1s.jpg"));
				toolNum = 3;
			}	
			else
			if (e.getSource() == this.lineBut)
			{
				brushBut.setIcon(new ImageIcon("Images/brush1s.jpg"));
				penBut.setIcon(new ImageIcon("Images/pen1s.jpg"));
				fillBut.setIcon(new ImageIcon("Images/fill1s.jpg"));
				lineBut.setIcon(new ImageIcon("Images/line2s.jpg"));
				recBut.setIcon(new ImageIcon("Images/kvad1s.jpg"));
				cirBut.setIcon(new ImageIcon("Images/krog1s.jpg"));
				recFillBut.setIcon(new ImageIcon("Images/kvadFill1s.jpg"));
				cirFillBut.setIcon(new ImageIcon("Images/krogFill1s.jpg"));
				toolNum = 4;
			}	
			else
			if (e.getSource() == this.recBut)
			{
				brushBut.setIcon(new ImageIcon("Images/brush1s.jpg"));
				penBut.setIcon(new ImageIcon("Images/pen1s.jpg"));
				fillBut.setIcon(new ImageIcon("Images/fill1s.jpg"));
				lineBut.setIcon(new ImageIcon("Images/line1s.jpg"));
				recBut.setIcon(new ImageIcon("Images/kvad2s.jpg"));
				cirBut.setIcon(new ImageIcon("Images/krog1s.jpg"));
				recFillBut.setIcon(new ImageIcon("Images/kvadFill1s.jpg"));
				cirFillBut.setIcon(new ImageIcon("Images/krogFill1s.jpg"));
				toolNum = 5;
			}	
			else
			if (e.getSource() == this.recFillBut)
			{
				brushBut.setIcon(new ImageIcon("Images/brush1s.jpg"));
				penBut.setIcon(new ImageIcon("Images/pen1s.jpg"));
				fillBut.setIcon(new ImageIcon("Images/fill1s.jpg"));
				lineBut.setIcon(new ImageIcon("Images/line1s.jpg"));
				recBut.setIcon(new ImageIcon("Images/kvad1s.jpg"));
				cirBut.setIcon(new ImageIcon("Images/krog1s.jpg"));
				recFillBut.setIcon(new ImageIcon("Images/kvadFill2s.jpg"));
				cirFillBut.setIcon(new ImageIcon("Images/krogFill1s.jpg"));
				toolNum = 6;
			}	
			
			else
			if (e.getSource() == this.cirBut)
			{
				brushBut.setIcon(new ImageIcon("Images/brush1s.jpg"));
				penBut.setIcon(new ImageIcon("Images/pen1s.jpg"));
				fillBut.setIcon(new ImageIcon("Images/fill1s.jpg"));
				lineBut.setIcon(new ImageIcon("Images/line1s.jpg"));
				recBut.setIcon(new ImageIcon("Images/kvad1s.jpg"));
				cirBut.setIcon(new ImageIcon("Images/krog2s.jpg"));
				recFillBut.setIcon(new ImageIcon("Images/kvadFill1s.jpg"));
				cirFillBut.setIcon(new ImageIcon("Images/krogFill1s.jpg"));
				toolNum = 7;
			}				
			else
			if (e.getSource() == this.cirFillBut)
			{
				brushBut.setIcon(new ImageIcon("Images/brush1s.jpg"));
				penBut.setIcon(new ImageIcon("Images/pen1s.jpg"));
				fillBut.setIcon(new ImageIcon("Images/fill1s.jpg"));
				lineBut.setIcon(new ImageIcon("Images/line1s.jpg"));
				recBut.setIcon(new ImageIcon("Images/kvad1s.jpg"));
				cirBut.setIcon(new ImageIcon("Images/krog1s.jpg"));
				recFillBut.setIcon(new ImageIcon("Images/kvadFill1s.jpg"));
				cirFillBut.setIcon(new ImageIcon("Images/krogFill2s.jpg"));
				toolNum = 8;
			}	
		}	
	}
	

	public class TimeThread extends Thread {		
	   
		public void run(){
	    	for(;;){
	    		try{Thread.sleep(900);} 
	    			catch (InterruptedException e){}
	    		statusbar.updateTime(new Date().toString());
	    	}
	    }
	}
	
	public class ColBar extends JInternalFrame implements ChangeListener{
		
		JColorChooser jcc = null;	
		
		ColBar(){
		    this.setTitle("Color chooser");
	    
			this.jcc = new JColorChooser();
			this.jcc.getSelectionModel().addChangeListener(this); 	    
		    this.add(this.jcc); 
		    
    		this.jcc.setBackground(FgColor);	
		    this.pack();
			this.setLocation(desktop.getWidth()- this.getWidth() - 10,10);	    
			this.setVisible(true);
		}
		
		public void stateChanged(ChangeEvent e) {
    		FgColor = this.jcc.getColor();
    		brsiz.repaint();
    		this.jcc.setBackground(FgColor);
		}
	}
	
	
	class PaintWindow extends JInternalFrame implements InternalFrameListener{
		
		int i = 0;
		BufferedImage bufImage = null;
		PaintBoard pb = null;
		String imName = null;
		
		PaintWindow(String title,Point pt,Color cl,int i){	
			this.i = i;
			this.imName =title;
			this.addInternalFrameListener(this);
			this.setLayout(null);
			this.setBackground(Color.GRAY);
			this.setMaximizable(true);
			this.setResizable(true);
			
			this.setLocation(20,20);			
			this.setClosable(true);
			this.setTitle(title);		
			
			this.pb = new PaintBoard(pt);
			
			if(pt.x < desktop.getWidth() || pt.y < desktop.getHeight())
				this.setSize(pt.x+10,pt.y+33);		
			else
				this.setSize(desktop.getWidth()-20,desktop.getHeight()-20);
			
			this.pb.setSize(pt.x,pt.y);
			
			this.add(this.pb);
			
			this.setVisible(true);	
		}  
		
		PaintWindow(java.io.File file,int i){
			this.i=i;
			this.imName = file.getName();
			
			this.setLayout(null);
			this.setBackground(	Color.GRAY);
			this.setMaximizable(true);
			this.setResizable(true);
			
			this.setLocation(20,20);
			this.setTitle(this.imName);			
			this.addInternalFrameListener(this);
			this.setClosable(true);
			
		    try {this.bufImage = ImageIO.read(file);} 
		    	catch (IOException e) {}		           
		    MediaTracker mt = new MediaTracker(this);
		    mt.addImage(this.bufImage,1);
		           
		    try{mt.waitForID(1);}
		    	catch(InterruptedException e){}		          
		    
		    this.setSize(this.bufImage.getWidth()+10 ,bufImage.getHeight()+ 33);		                  
			this.pb = new PaintBoard(this.bufImage);
			this.pb.setSize(this.bufImage.getWidth(),this.bufImage.getHeight());	
			this.add(this.pb);
			this.show();		
		}  

		public void imageFlip(int sel){
			this.pb.imageFlip(sel);
		}
		
		public void clearimage(){
			this.pb.clearImage();
		}
		
		public RenderedImage getImage(){
			return (RenderedImage) this.pb.getImg();
		}

		public void internalFrameOpened(InternalFrameEvent arg0){			
		}

		public void internalFrameClosing(InternalFrameEvent arg0){		
			this.bufImage = null;
			this.pb = null;	
			this.dispose();		
		}

		public void internalFrameClosed(InternalFrameEvent arg0){
			paintWin[i] = null;	
		}

		public void internalFrameIconified(InternalFrameEvent arg0){			
		}

		public void internalFrameDeiconified(InternalFrameEvent arg0){
		}

		public void internalFrameActivated(InternalFrameEvent arg0){
			imgName = this.imName;
			imgNum = i;	
		}

		public void internalFrameDeactivated(InternalFrameEvent arg0){
			imgNum = -1;		
		}
	}

	class NewWindow extends JFrame implements ActionListener{
		
		JPanel newPan = null;
		JLabel label = null,labW = null,labH = null;	
		JButton newOK = null,newColor = null,newCancel = null;
		JTextField newName = null,newH = null,newW = null;	
		Point velOkn;
		
		NewWindow()
		{
			this.setTitle("New image");
			this.setBounds(desktop.getWidth()/2 - 150 ,desktop.getHeight()/2 -50,300,100);
			this.setLayout(new GridLayout(4,2));	
			
			this.newPan=new JPanel();
			
			this.label = new JLabel(" Image name:  ");
			this.labW = new JLabel(" Image width:  ");
			this.labH = new JLabel(" Image height:  ");
			
			this.newOK = new JButton("OK");
			this.newCancel = new JButton("Cancel");	
			this.newColor = new JButton("Background Color");
			
			this.newName = new JTextField("Untitled");
			this.newW = new JTextField("800");
			this.newH = new JTextField("600");
					
			this.add(this.label);
			this.add(this.newName);
			this.add(this.labW);
			this.add(this.newW);			
			this.add(this.labH);
			this.add(this.newH);
			this.add(this.newColor);
			this.add(this.newPan);	
			
			this.newPan.add(this.newOK);
			this.newPan.add(this.newCancel);
			
			this.newColor.setBackground(BgColor);	
			this.newOK.addActionListener(this);
			this.newColor.addActionListener(this);
			this.newCancel.addActionListener(this);
			
			this.pack();
			this.setVisible(true);
		}	
		
		public void actionPerformed(ActionEvent e){		
			if(e.getSource() == this.newOK)
			{
				if (!newName.getText().equals(""))
				{
					imgName = newName.getText();
					this.velOkn = new Point();
					this.velOkn.x=Integer.parseInt(newW.getText());
					this.velOkn.y=Integer.parseInt(newH.getText());

					for(int i=0; i<paintWin.length; i++)
				        if(paintWin[i] == null)
				        {
				         	paintWin[i] = new PaintWindow(imgName,this.velOkn,BgColor,i);				         
				         	desktop.add(paintWin[i]);
				         	desktop.getDesktopManager().activateFrame(paintWin[i]);
				         	break;
				        }					 
					this.dispose();
				}
				else 
					JOptionPane.showMessageDialog(null, "Enter a valid image name!", "Invalid input", JOptionPane.ERROR_MESSAGE);
			}
			else
				if(e.getSource() == this.newColor)
				{
					BgColor = JColorChooser.showDialog(null,"Set Background Color",null);
					this.newColor.setBackground(BgColor);
				}
			else
				if(e.getSource() == this.newCancel)
					this.dispose();			
		}
	}

	class PaintBoard extends JPanel implements MouseListener,MouseMotionListener{
		
		int mxs=0;
		int mys=0;
		int mxe=0;
		int mye=0;
		int picnum = 0;
		int toolNum;
		boolean fillEnd= false;
	    int sCol;
	    int tCol;
	    
		int width = -1;
		int height = -1;
		
		BufferedImage pict[] = new BufferedImage[10];
		
	    PaintBoard(BufferedImage bufImage){
	    	this.width = bufImage.getWidth();
	    	this.height = bufImage.getHeight();
           	this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	        this.addMouseListener(this);
	        this.addMouseMotionListener(this);        	        
	        this.pict[0]=bufImage; 	        
	    }

	    PaintBoard(Point pt){
	    	this.width = pt.x;
	    	this.height = pt.y;
           	this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	        this.addMouseListener(this);
	        this.addMouseMotionListener(this);	       
	    }
	    
	    public void undo(){
	    	if (this.picnum != 0)
	    	{
	    		this.pict[this.picnum] = pict[this.picnum--];
	    		this.repaint();
	    	}
	    }
	    
	    public void redo(){
	    	if (pict[this.picnum+1] != null)
	    	{
	    		this.pict[this.picnum] = pict[this.picnum++];
	    		this.repaint();
	    	}
	    }
	    
	    public void paintComponent(Graphics g){
        	Graphics2D g2 = (Graphics2D)g; 
	        if (this.pict[picnum] == null) {		
	        	this.pict[picnum] = (BufferedImage) createImage(width,height);	        	
	        	g2 = this.pict[picnum].createGraphics();
	        	g2.setColor(BgColor);
	        	g2.fillRect(0,0,this.getWidth(),this.getHeight());
	        	this.repaint();	   
	       }
	       else	  
	    	   g2.drawImage(this.pict[this.picnum], 0, 0, null);
	    }    
	
	    public Image getImg(){
	    	return (Image)this.pict[this.picnum];
	    }
	  
	    public void saveImage(){
            BufferedImage temp=(BufferedImage) this.createImage(this.getWidth(),this.getHeight()); 
            temp.getGraphics().drawImage(this.pict[this.picnum],0,0,null); 
	        
            if (this.picnum == this.pict.length-1)		
	        {
	            for (int i=1;i<this.pict.length;i++)
	            	this.pict[i-1] = this.pict[i]; 	
	            this.picnum--; 
	        } 
	        this.picnum++; 	
	        this.pict[this.picnum] = temp;     	
	    }
	 


	    public void freePaint(MouseEvent event)
	    {
    		this.mxe = this.mxs;
    		this.mye = this.mys;	    		
    		this.mxs = event.getX();
    		this.mys = event.getY();
    		  		
            Graphics2D graph2d = this.pict[this.picnum].createGraphics();
            graph2d.setColor(FgColor);	           
            graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                       RenderingHints.VALUE_ANTIALIAS_ON);	            
	        graph2d.setStroke(new BasicStroke(brSize,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
	        graph2d.drawLine(this.mxs,this.mys,this.mxe,this.mye);
	        
	        this.repaint();
	        
	    }
	    
	    public void drawRec(MouseEvent event,boolean filled){	    	

	    	Graphics2D graph2d = this.pict[this.picnum].createGraphics();
	    	graph2d.setColor(FgColor);	           
	    	graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                   RenderingHints.VALUE_ANTIALIAS_ON);	            
        
	    	graph2d.drawImage(this.pict[this.picnum-1], 0, 0, null);
	    	graph2d.setStroke(new BasicStroke(brSize,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));	
	    	
	        if (filled){
	        	if(mxs < event.getX() && mys < event.getY())
	        		graph2d.fillRect(mxs,mys,event.getX()-mxs,event.getY()-mys);
	        	else
	        		if(mxs > event.getX() && mys < event.getY())
	        			graph2d.fillRect(event.getX(),mys,mxs-event.getX(),event.getY()-mys);
	        	else
	        		if(mxs < event.getX() && mys > event.getY())
	        			graph2d.fillRect(mxs,event.getY(),event.getX()-mxs,mys-event.getY());
	        	else
	        		if(mxs > event.getX() && mys > event.getY())
	        			graph2d.fillRect(event.getX(),event.getY(),mxs-event.getX(),mys-event.getY());
	        }
	        else
	        {
	            if(mxs < event.getX() && mys < event.getY())
	            	graph2d.drawRect(mxs,mys,event.getX()-mxs,event.getY()-mys);
	            else
	            	if(mxs > event.getX() && mys < event.getY())
	            		graph2d.drawRect(event.getX(),mys,mxs-event.getX(),event.getY()-mys);
	            else
	                if(mxs < event.getX() && mys > event.getY())
	                	graph2d.drawRect(mxs,event.getY(),event.getX()-mxs,mys-event.getY());
	            else
	                if(mxs > event.getX() && mys > event.getY())
	                	graph2d.drawRect(event.getX(),event.getY(),mxs-event.getX(),mys-event.getY());
		        }
	        
            this.repaint();
	    }
	    
	    public void drawCir(MouseEvent event,boolean filled){	    	
           
	    	Graphics2D graph2d = this.pict[this.picnum].createGraphics();
	    	graph2d.setColor(FgColor);	           
	    	graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                   RenderingHints.VALUE_ANTIALIAS_ON);	            
        
	    	graph2d.drawImage(this.pict[this.picnum-1], 0, 0, null);
	    	graph2d.setStroke(new BasicStroke(brSize,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));	
	    	
	        if(filled){
	        	if(mxs < event.getX() && mys < event.getY())
	        		graph2d.fillOval(mxs,mys,event.getX()-mxs,event.getY()-mys);
	        	else
	        		if(mxs > event.getX() && mys < event.getY())
	        			graph2d.fillOval(event.getX(),mys,mxs-event.getX(),event.getY()-mys);
	        	else
	        		if(mxs < event.getX() && mys > event.getY())
	        			graph2d.fillOval(mxs,event.getY(),event.getX()-mxs,mys-event.getY());
	        	else
	        		if(mxs > event.getX() && mys > event.getY())
	        			graph2d.fillOval(event.getX(),event.getY(),mxs-event.getX(),mys-event.getY());
	        }
	        else
	        {
	            if(mxs < event.getX() && mys < event.getY())
	            	graph2d.drawOval(mxs,mys,event.getX()-mxs,event.getY()-mys);
	            else
	            	if(mxs > event.getX() && mys < event.getY())
	            		graph2d.drawOval(event.getX(),mys,mxs-event.getX(),event.getY()-mys);
	            else
	                if(mxs < event.getX() && mys > event.getY())
	                	graph2d.drawOval(mxs,event.getY(),event.getX()-mxs,mys-event.getY());
	            else
	                if(mxs > event.getX() && mys > event.getY())
	                	graph2d.drawOval(event.getX(),event.getY(),mxs-event.getX(),mys-event.getY());
		        }
            this.repaint();
	    }


	    
	    public void fillColor(int ix, int iy){	    	
	
	    	//this method only works for very small areas, if enybody knows a better way of how to implement the method please email me!!!
	    	pict[this.picnum].setRGB(ix, iy, tCol);

	    	if (ix+1 < pict[this.picnum].getWidth() && pict[this.picnum].getRGB(ix+1,iy) == sCol) 
	    			fillColor(ix+1, iy);
	    	
	    	if (iy-1 > 0 && pict[this.picnum].getRGB(ix,iy-1) == sCol) 
	    			fillColor(ix, iy-1);
	    	
	    	if (ix-1 > 0 && pict[this.picnum].getRGB(ix-1,iy) == sCol) 
	    			fillColor(ix-1, iy);
	    	
	    	if (iy+1 < pict[this.picnum].getHeight() && pict[this.picnum].getRGB(ix,iy+1) == sCol) 
					fillColor(ix, iy+1);

	    }

	    public void drawLine(MouseEvent event){	    	
            Graphics2D graph2d = this.pict[this.picnum].createGraphics();
            graph2d.setColor(FgColor);	           
            graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                       RenderingHints.VALUE_ANTIALIAS_ON);	            
            
            graph2d.drawImage(this.pict[this.picnum-1], 0, 0, null);
	        graph2d.setStroke(new BasicStroke(brSize,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
	        
	        graph2d.drawLine(mxs,mys,event.getX(),event.getY());
	        
            this.repaint();
	    }
	    
	    public void penTool(MouseEvent event)    	
		    {
	    		this.mxe = this.mxs;
	    		this.mye = this.mys;	    		
	    		this.mxs = event.getX();
	    		this.mys = event.getY();
	    		  		
	            Graphics2D graph2d = this.pict[this.picnum].createGraphics();
	            graph2d.setColor(FgColor);	           
		        graph2d.drawLine(this.mxs,this.mys,this.mxe,this.mye);
		        
		        this.repaint();
		        
		    }
	  
	    public void resizeBoard(int nx,int ny)
	    {
	    	this.setSize(nx,ny);
	    	this.pict[this.picnum]=(BufferedImage) createImage(nx,ny);
	    }
	    
		public void clearImage(){
			saveImage();
			pict[picnum] = null;
			this.repaint();
		}    
		
	    public void imageFlip(int sel)
	    {
	    	this.saveImage();
	    	
	        AffineTransform tx = AffineTransform.getScaleInstance(sel, -sel);
	        if (sel == -1)
	        	tx.translate(-this.pict[this.picnum].getWidth(null), 0);
	        else
	        	tx.translate(0, -this.pict[this.picnum].getHeight());
	        
	        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

	    	this.pict[this.picnum] = op.filter(pict[this.picnum], null);
	    
	        this.repaint();
	    }

	    
	    public Graphics2D initShape()
	    {  
	    	Graphics2D graph2d = this.pict[this.picnum].createGraphics();
	    	graph2d.setColor(FgColor);	           
	    	graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                   RenderingHints.VALUE_ANTIALIAS_ON);	            
        
	    	graph2d.drawImage(this.pict[this.picnum-1], 0, 0, null);
	    	graph2d.setStroke(new BasicStroke(brSize,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));	
	    	return graph2d;
	    }
	    
	    public void mouseDragged(MouseEvent event){  
	       	    		
	    		if (this.toolNum == 1)
	    			freePaint(event);	
	    		else
		    	if (this.toolNum == 2)
		    		penTool(event);
	    		else
				if (this.toolNum == 4)
					drawLine(event);
		    	else
				if (this.toolNum == 5)
					drawRec(event,false);			
				else
				if (this.toolNum == 6)
					drawRec(event,true); 		
				else
				if (this.toolNum == 7)
					drawCir(event,false);  
				else
				if (this.toolNum == 8)
					drawCir(event,true);  
	    }
	    
	    public void mousePressed(MouseEvent event){  
	    	this.mxs = event.getX();
	    	this.mys = event.getY();
	    	this.mxe = this.mxs;
	    	this.mye = this.mys;
	 
	    	this.toolNum = toolbar.getToolNum();
	    	
	    	this.saveImage();
	    	
    		if (this.toolNum == 1)
    			freePaint(event);	
    		else
			if (this.toolNum == 2){
			    penTool(event); repaint();}
    		else
			if (this.toolNum == 3){
				sCol=this.pict[this.picnum].getRGB(mxs,mys);
				tCol = FgColor.getRGB();
				fillColor(mxs, mys);
				}
	    	else
			if (this.toolNum == 4)
				drawLine(event);  
    		
	    	this.repaint();    	    	
	    }
	    
	    
	    public void mouseClicked(MouseEvent event){ 
	    }  
	    
	    public void mouseReleased(MouseEvent event){
	    }
	    
	    public void mouseMoved(MouseEvent event){    	
		}
	    
	    public void mouseExited(MouseEvent event){	
		}
	    
	    public void mouseEntered(MouseEvent event){    	
		} 
	}
	
	public class BrushSize extends JPanel{	
		
		BrushSize()
		{
			repaint();
		}
		
	    public void paintComponent(Graphics g){
        	Graphics2D g2 = (Graphics2D)g; 
        	
	    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                   RenderingHints.VALUE_ANTIALIAS_ON);	
	        g2.setColor(Color.WHITE);
	        g2.fillRect(0,0,this.getWidth(),this.getHeight());
	        g2.setColor(FgColor);
	        g2.fillOval(this.getWidth()/2 -brSize/2,this.getHeight()/2 -brSize/2,brSize,brSize);
	    }    
	}
}




