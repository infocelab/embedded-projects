import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class trackfinder extends JFrame implements ListSelectionListener,ActionListener{
	
	JMenuBar menuBar;
	JTextArea textArea;
	JMenu menuFile, menuEdit, menuView, menuHelp;
	JMenuItem itemAdd, itemOpen, itemClose, itemSave, itemExit, itemAbout, itemCont;
	JTextField textArtist, textSong;
	JLabel lblArtist , lblSong, lblResults;
	JScrollPane scrollpane,listscroll;
	JPanel cp,tp,mp,p1,p2,p3, p4, p5;
	JButton btnSearch, btnReset;
	JCheckBox casesens;
	DefaultListModel model;
	JList list;
	JFileChooser fc;
	int offset, offset2, flag, flag2;
	int filecnt; //file counter
	String strngArtist, strngSong;
	SimpleFilter filtertxt = new SimpleFilter("txt","Text Files");
	java.net.URL logo = this.getClass().getClassLoader().getResource("images/Cd.gif");
	Image icon = Toolkit.getDefaultToolkit().getImage(logo);

	public trackfinder () {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(700,380);
		setLocation((screensize.width / 2) - (getSize().width / 2),
							(screensize.height / 2) - (getSize().height / 2));
	 	
		createGUI();			
		getContentPane().add(cp,BorderLayout.CENTER);
		getContentPane().add(scrollpane, BorderLayout.LINE_END);
	}
	
	public void createGUI() {
		setIconImage(icon);
		createMenu();
		createTextArea();
		createSearchArea();
	}
	
	public void createMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuFile = new JMenu("File");
		itemAdd = new JMenuItem("Add New CD");
		itemOpen = new JMenuItem("Open CD");
		itemSave = new JMenuItem("Save CD");
		itemClose = new JMenuItem("Close CD");
		itemExit = new JMenuItem("Exit");
		itemAdd.addActionListener(this);
		itemSave.addActionListener(this);
		itemOpen.addActionListener(this);
		itemClose.addActionListener(this);
		itemExit.addActionListener(this);
		menuFile.add(itemOpen);	
		menuFile.add(itemAdd);
		menuFile.addSeparator();
		menuFile.add(itemSave);
		itemSave.setEnabled(false);
		menuFile.add(itemClose);
		itemClose.setEnabled(false);
		menuFile.addSeparator();
		menuFile.add(itemExit);
		menuBar.add(menuFile);	
		menuHelp = new JMenu("Help");
		itemAbout = new JMenuItem("About..");
		itemCont = new JMenuItem("Help Contents");
		menuHelp.add(itemAbout);
		menuHelp.add(itemCont);
		menuBar.add(menuHelp);
		itemAbout.addActionListener(this);
		itemCont.addActionListener(this);
		
	}
	
	public void createTextArea() {
		textArea = new JTextArea(10,50);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollpane = new JScrollPane(textArea);
		scrollpane.setBorder(new TitledBorder(new EtchedBorder(),""));
		disableTextArea();
	}
	
	public void disableTextArea() {
		textArea.setBackground(Color.gray);
	}
	
	public void enableTextArea() {
		textArea.setBackground(Color.white);
	}

	public void createSearchArea() {
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblArtist = new JLabel("Artist:");
		textArtist = new JTextField(20);
		p1.add(lblArtist);
		p1.add(textArtist);
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblSong = new JLabel("Song:");
		textSong = new JTextField(20);
		textSong.setText("");
		p2.add(lblSong);
		p2.add(textSong);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnReset = new JButton("Clear");
		btnReset.addActionListener(this);
		btnSearch = new JButton("Find");
		btnSearch.addActionListener(this);
		p3.add(btnReset);
		p3.add(btnSearch);
		
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		casesens = new JCheckBox("Case Sensitive");
		p4.add(casesens);
		
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		model = new DefaultListModel();
		list = new JList(model);
		list.addListSelectionListener(this);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listscroll = new JScrollPane(list);
		lblResults = new JLabel("Search Results:");
		p5.add(lblResults);
		p5.add(listscroll);
		
		mp = new JPanel();
		mp.setLayout(new GridLayout(4,1));
		mp.add(p1);
		mp.add(p2);
		mp.add(p3);
		mp.add(p4);
		
		tp = new JPanel();
		tp.setLayout(new FlowLayout(FlowLayout.LEFT));
		tp.add(mp);
		
		cp = new JPanel();
		cp.setLayout(new GridLayout(2,1));
		cp.add(tp);
		cp.add(p5);
	}
	
	public String newTitle() {
		String title ="";
		int n;
		File dir = new File("c:\\track finder");
		n = countFiles(dir);
		title = "Track Finder - CD " + n;	
		return title;
	}
	public int directoryCount() {
		int num = 0;
		File dir = new File("c:\\track finder");
		File[] filearray = dir.listFiles();
		for(int i=0; i<filearray.length; i++) {
		if(filearray[i].isFile())
			num++;
		else
			countFiles(filearray[i]);
		}
		return num;
	}
	
	public int countFiles(File dir) {
		int ctr = 0;
		File[] filearray = dir.listFiles();
		for(int i=0; i<filearray.length; i++) {
			if (filearray[i].isFile())
				ctr++;
			else
				countFiles(filearray[i]);
		}
		return ctr;
	}

	public void searchFiles(File dir) {
		enableTextArea();
		File[] filearray = dir.listFiles();
		for(int i=0; i<filearray.length; i++) {
			if (filearray[i].isFile()) {
				String mypath = filearray[i].getPath().toString();
				readTxtFile(mypath);
			}
		}
	}
	
	public String readTxtFile(String filename) {
		BufferedReader inFile;
		String line,s = "";
		int numfiles;
		numfiles = directoryCount();
		try {
			inFile = new BufferedReader(new FileReader(filename));
			while((line = inFile.readLine()) != null) {
				strngArtist = textArtist.getText();
				strngSong = textSong.getText();
			
				s = s + line;
				boolean foundone = false;
				boolean empty3 = false;
				boolean empty = strngArtist.equals("");
				if(!empty) {
					empty3 = true;
					offset = s.indexOf(strngArtist);
					if (offset > -1){
						model.addElement(filename);
						foundone = true;
						flag = 1;
						flag2 = 1;			
					}
				}
				boolean empty2 = strngSong.equals("");
				if(!empty2) {
					empty3 = true;
					offset = s.indexOf(strngSong);
					if (offset > -1) {
						model.addElement(filename);
						foundone = true;
						flag = 1;
						flag2=1;
					}
				}
			}
			inFile.close();
			filecnt++;
		}
		catch (IOException e){
		}
			System.out.println("filecnt = " +filecnt);
			System.out.println("numfiles = " +numfiles);		
			System.out.println("Offset1 = " +offset);
			System.out.println("Flag1 = " +flag);
			System.out.println("Flag2 = " +flag2);
			if(filecnt == numfiles) {
			
			
			if((offset < 0)) {
				if ((flag2 == 0) && (flag != 1)) {
					model.addElement("Search is complete. No results to display.");
					flag2 = 1;
				}
			}
			}
		return s;
	}
	
	public void displayTxtFile(String Filename) {
		BufferedReader inFile;
		String line;
		try {
			inFile = new BufferedReader(new FileReader(Filename));
			while((line = inFile.readLine()) != null) 
				textArea.append(line+"\n");
			inFile.close();
		}
		
		catch(IOException e){
			System.out.println("Error: " +e);
		}
	}
	
	public void clear() {
		textArtist.setText("");
		textSong.setText("");
		textArea.setText("");
		model.removeAllElements();
	}
	
	private void save_entry() {	
		try {
			fc = new JFileChooser("c:\\track finder");
			fc.addChoosableFileFilter(filtertxt);
			int returnVal = fc.showSaveDialog(this);
			File file = fc.getSelectedFile();
			while (file.exists() && (returnVal != JFileChooser.CANCEL_OPTION)) {
				JOptionPane.showMessageDialog(null,"File Already Exists! Please choose another name!","File Exists",JOptionPane.INFORMATION_MESSAGE,null);
				returnVal=fc.showSaveDialog(this);
				file=fc.getSelectedFile();
			}
			FileWriter out = new FileWriter(file+".txt");   
			String body = textArea.getText();   	
			out.write(body);		
			out.close();
			textArea.setEditable(false);
		}
		catch(IOException E) {}
	}

	public void actionPerformed(ActionEvent E) {
			if(E.getSource() == btnSearch) {
				flag = 0;
				offset = -1;
				flag2 = 0;
				filecnt = 0;
				model.removeAllElements();
				textArea.setText("");
				File file = new File("c:\\track finder");
				searchFiles(file);
			}
			
			if(E.getSource() == btnReset) 
				clear();
			
			if(E.getSource() == itemOpen) {
				fc = new JFileChooser("c:\\track finder");
				fc.addChoosableFileFilter(filtertxt);
				int returnVal = fc.showOpenDialog(this);
				enableTextArea();
				itemClose.setEnabled(true);
				File file = fc.getSelectedFile();
				displayTxtFile(file.toString());
					
			}
			
			if(E.getSource() == itemAdd) {
				enableTextArea();
				itemClose.setEnabled(true);
				itemSave.setEnabled(true);
				textArea.setEditable(true);
				String title = newTitle();
				setTitle(title);
			}
			
			if(E.getSource() == itemSave) {
				save_entry();
				
			}
			
			if(E.getSource() == itemClose) {
				disableTextArea();
				itemClose.setEnabled(false);
				itemSave.setEnabled(false);
				setTitle("TrackFinder v1.0");
				textArea.setText("");
			}
			
			if(E.getSource() == itemExit) 
				System.exit(0);
			
			if(E.getSource() == itemAbout) {
				aboutDialog about = new aboutDialog();
				about.setVisible(true);
			}
			
			if(E.getSource() == itemCont) {
				enableTextArea();
				displayTxtFile("images/ReadMe.txt");
			}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		if ((e.getValueIsAdjusting() == false) || (e.getFirstIndex() == -1))
			return;
		textArea.setText("");
		displayTxtFile(list.getSelectedValue().toString());
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception E){}
		trackfinder trkfndr = new trackfinder();
		trkfndr.setVisible(true);
		File dir = new File("c:\\track finder");
		if(!dir.exists())
			dir.mkdir();
		trkfndr.setResizable(false);
		trkfndr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		trkfndr.setTitle("Audio Track Finder v1.0");
		trkfndr.directoryCount();
	}

}