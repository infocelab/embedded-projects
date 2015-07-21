import java.awt.*;
import sun.net.smtp.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;

public class MailClient extends JFrame{

protected SmtpClient sc;
protected JTextField sender,adresses,subject,server;
protected JTextArea message;
protected JButton sendButton;
protected JLabel l1,l2,l3,l4;
protected PrintStream ps;
protected JDialog dialogBox;
protected String toName="";

public MailClient(){

/*******************************Graphical interface**************************/

super("SMTP Mail Client");
getContentPane().setLayout(new BorderLayout());

JPanel header = new JPanel();

JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
l1=new JLabel(" To:          ");
l1.setForeground(Color.black);
p1.add(l1);
adresses=new JTextField(40);

adresses.addFocusListener(new FocusAdapter(){
public void focusGained(FocusEvent e){
l1.setForeground(new Color(98,156,245));
}
});

adresses.addFocusListener(new FocusAdapter(){
public void focusLost(FocusEvent e){
l1.setForeground(Color.black);
}
});

p1.add(adresses);

JPanel p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
l2=new JLabel(" From:      ");
l2.setForeground(Color.black);
p2.add(l2);
sender=new JTextField(40);
sender.addFocusListener(new FocusAdapter(){
public void focusGained(FocusEvent e){
l2.setForeground(new Color(98,156,245));
}
});

sender.addFocusListener(new FocusAdapter(){
public void focusLost(FocusEvent e){
l2.setForeground(Color.black);
}
});

p2.add(sender);

JPanel p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
l3=new JLabel(" Subject:   ");
l3.setForeground(Color.black);
p3.add(l3);
subject=new JTextField(40);
subject.addFocusListener(new FocusAdapter(){
public void focusGained(FocusEvent e){
l3.setForeground(new Color(98,156,245));
}
});

subject.addFocusListener(new FocusAdapter(){
public void focusLost(FocusEvent e){
l3.setForeground(Color.black);
}
});

p3.add(subject);

JPanel p=new JPanel(new FlowLayout(FlowLayout.LEFT));
l4=new JLabel(" Server:   ");
l4.setForeground(Color.black);
p.add(l4);
server=new JTextField(40);
server.addFocusListener(new FocusAdapter(){
public void focusGained(FocusEvent e){
l4.setForeground(new Color(98,156,245));
}
});

server.addFocusListener(new FocusAdapter(){
public void focusLost(FocusEvent e){
l4.setForeground(Color.black);
}
});

p.add(server);


JLabel label=new JLabel("JAVA MAIL CLIENT APPLICATION");
label.setFont(new Font("TimesRoman",Font.BOLD,20));
label.setForeground(Color.blue);
label.setSize(250,30);
label.setHorizontalAlignment(JLabel.CENTER);

header.setLayout(new GridLayout(5,1));
header.add(label);
header.add(p1);
header.add(p2);
header.add(p3);
header.add(p);

message=new JTextArea(70,50);
message.setFont(new Font("SansSerif",Font.BOLD,14));
JScrollPane pScroll=new JScrollPane(message);
pScroll.setBorder(new TitledBorder(new
EtchedBorder(),"Mail Message"));

JPanel p4=new JPanel(new FlowLayout());
sendButton=new JButton("SEND MESSAGE");
sendButton.setMnemonic('e');
sendButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){

if(adresses.getText().equals(""))
dialogMessage("  To:     field empty!!!  ");
else if(sender.getText().equals(""))
dialogMessage("  From:     field empty!!!  ");
else if(server.getText().equals(""))
dialogMessage("  Server:     field empty!!!  ");

else
{
sendMail();

int index=0;
toName=adresses.getText();
index=toName.indexOf('@');
toName=toName.substring(0,index);

dialogMessage("  Your message has been sent to "+toName+"  ");
}


}
});
p4.add(sendButton);


getContentPane().add(header,BorderLayout.NORTH);
getContentPane().add(pScroll,BorderLayout.CENTER);
getContentPane().add(p4,BorderLayout.SOUTH);

/********************************************************************/

addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
System.exit(0);
}
});


setSize(600,500);
setResizable(false);
setVisible(true);


}

/*********************************MAILING********************/
public void sendMail(){

try{
sc = new SmtpClient(server.getText());

sc.from(sender.getText());
sc.to(adresses.getText());
ps=sc.startMessage();

ps.println("Subject: "+subject.getText());
ps.println();

ps.println(message.getText());

sc.closeServer();

adresses.setText("");
sender.setText("");
subject.setText("");
server.setText("");
message.setText("");
}
catch(Exception e){dialogMessage(" Some Error has occured while sending mail. ");}
}

/**********************************MESSAGE***********************/
public void dialogMessage(String str){

dialogBox=new JDialog(new JFrame(),"Message",true);
dialogBox.getContentPane().setLayout(new
BorderLayout());


JPanel p1=new JPanel(new FlowLayout());
JButton okBtn=new JButton("OK");
okBtn.setForeground(Color.black);
okBtn.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
dialogBox.setVisible(false);
}
});

p1.add(okBtn);
JLabel l=new JLabel(str,JLabel.CENTER);
l.setFont(new Font("Courier",Font.BOLD,14));
l.setForeground(Color.black);

dialogBox.getContentPane().add(l,BorderLayout.CENTER);
dialogBox.getContentPane().add(p1,BorderLayout.SOUTH);
dialogBox.setResizable(false);
dialogBox.setLocation(270,200);
dialogBox.pack();
dialogBox.show();
}




/**************************************MAIN**********************/
public static void main(String args[]){
new MailClient();
}

}//end of class

