import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class aboutDialog extends JDialog {

	JLabel title, author, email;
	JPanel mp,p1,p2,p3;
	JButton ok;
	
	public aboutDialog () {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception E) {}
		setSize(270,170);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screensize.width / 2) - (getSize().width  / 2),
						(screensize.height / 2) - (getSize().height / 2));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		title = new JLabel("TrackFinder version 1.0");
		title.setFont(new Font("Monospaced",Font.BOLD,16));
		title.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		p1.add(title);
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		author = new JLabel("\n\nAuthor: Prometheus\n");
		email = new JLabel("Contact: whoisprometheus@yahoo.com\n\n");
		author.setFont(new Font("Arial",Font.PLAIN,12));
		email.setFont(new Font("Arial",Font.PLAIN,12));
		p2.add(author);
		p2.add(email);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		ok = new JButton("OK");
		p3.add(ok);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent AE) {
				aboutDialog.this.dispose();
			}
		});
		
		mp = new JPanel();
		mp.setLayout(new GridLayout(2,1));
		mp.add(p2);
		mp.add(p3);
		
		setTitle("About");
		getContentPane().add(p1,BorderLayout.NORTH);
		getContentPane().add(mp,BorderLayout.CENTER);
	}
}