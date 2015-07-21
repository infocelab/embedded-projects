package chatclient;

import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import protocols.*;

public class ClientInterface extends JFrame
{
	private ChatClient client;

	//Have to create a new object each time so that ObjectStream will read it
	//private protocols.Message msg = new protocols.Message();

	JList lstClients;
	
	//Holds references to all message windows
	protected Vector messageWindows;
	
	//Provides mapping of tab number to clientId
	protected Vector tabToClient;

	protected JButton bSend;
	protected JTextField tfMessage;

	protected JScrollPane scrlClients;

	protected JMenuBar menuBar;
	protected JMenu hlpMenu;
	protected JMenu tabMenu;
	protected JMenu fileMenu;
	protected JMenuItem exitFMenu;
	protected JMenuItem webHlpMenu;
	protected JMenuItem	helpHlpMenu;
	protected JMenuItem aboutHlpMenu;
	protected JMenuItem closeTabMenu;
	protected JMenuItem connectFMenu;
	protected JMenuItem configureFMenu;
	protected JMenuItem	disconnectFMenu;
	protected JMenuItem closeAllTabsMenu;

	protected JTabbedPane tbChatWindows;
	

	ClientInterface( ChatClient client )
	{
		super( "Fruit Cha(a)t Plate" );
		//this.setIconImage( new ImageIcon("Icons/dukeWaveRed.gif") );
		this.client = client;

		setUpMenu();
		setUpMainInterface();
		
		setVisible(true);
		tfMessage.requestFocus();
	}

	protected void setUpMenu()
	{
		exitFMenu = new JMenuItem("Exit",KeyEvent.VK_X);
		webHlpMenu = new JMenuItem("Fruit Cha(a)t on the WEB");
		helpHlpMenu = new JMenuItem("Help",KeyEvent.VK_H);
		connectFMenu = new JMenuItem("Connect",KeyEvent.VK_C);
		aboutHlpMenu = new JMenuItem("About",KeyEvent.VK_A);
		closeTabMenu = new JMenuItem( "Close Tab",KeyEvent.VK_C );
		configureFMenu = new JMenuItem("Configure");
		disconnectFMenu = new JMenuItem("Disconnect",KeyEvent.VK_D);
		closeAllTabsMenu = new JMenuItem( "Close All Tabs",KeyEvent.VK_A );

		/*
		connectFMenu.setIcon( new ImageIcon("icons/lan.gif") );
		configureFMenu.setIcon( new ImageIcon("icons/log.gif") );
		helpHlpMenu.setIcon( new ImageIcon("icons/about.gif") );
		aboutHlpMenu.setIcon( new ImageIcon("icons/about.gif") );
		webHlpMenu.setIcon( new ImageIcon("icons/internet.gif") );
		*/
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.add(connectFMenu);
		fileMenu.add(disconnectFMenu);
		fileMenu.add(configureFMenu);
		fileMenu.addSeparator();
		fileMenu.add(exitFMenu);

		tabMenu = new JMenu( "Tabs" );
		tabMenu.setMnemonic( KeyEvent.VK_T );
		tabMenu.add( closeTabMenu );
		tabMenu.add( closeAllTabsMenu );
		
		hlpMenu = new JMenu("Help");
		hlpMenu.setMnemonic(KeyEvent.VK_H);
		hlpMenu.add(helpHlpMenu);
		hlpMenu.addSeparator();
		hlpMenu.add(aboutHlpMenu);
		hlpMenu.add(webHlpMenu);
		
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add( tabMenu );
		menuBar.add(hlpMenu);
		setJMenuBar(menuBar);
	}
	
	protected void setUpListeners()
	{
		configureFMenu.addActionListener( new ConfigureFMenu() );
		exitFMenu.addActionListener( new ExitButton() );
		helpHlpMenu.addActionListener( new HelpHlpMenu() );
		aboutHlpMenu.addActionListener( new AboutHlpMenu() );
		webHlpMenu.addActionListener( new WebHlpMenu() );
		connectFMenu.addActionListener( new ConnectFMenu() );
		disconnectFMenu.addActionListener( new DisconnectFMenu() );
		closeTabMenu.addActionListener( new CloseTabButton() );
		closeAllTabsMenu.addActionListener( new CloseAllTabsMenu() );

		bSend.addActionListener( new SendButton() );
		tfMessage.addActionListener( new SendMessage() );
		//tfMessage.addFocusListener( new FocusMessageField() );

		lstClients.addMouseListener( new SelectClient() );
		addWindowListener( new OnExit() );
	}
	
	protected void setUpProperties()
	{
		setSize(475,280);
		setResizable(false);

		bSend.setEnabled( false );
		bSend.setToolTipText( "Send Your Message" );
		
		tfMessage.setEnabled( false );
		tfMessage.setToolTipText( "Enter Your Message Here" );
		
		disconnectFMenu.setEnabled( false );
		tabMenu.setEnabled( false );
		closeTabMenu.setEnabled( false );
		closeAllTabsMenu.setEnabled( false );

		lstClients.setFixedCellWidth(101);
		lstClients.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		lstClients.setToolTipText( "Double Click To Chat Privately" );

		scrlClients = new JScrollPane( lstClients );
		scrlClients.setColumnHeaderView( new JLabel("Online Users" ) );
		
		tbChatWindows.setToolTipText( "Conversation Windows. Choose Recipient" );
		
		setUpListeners();
	}
		
	protected void setUpMainInterface()
	{
 		bSend = new JButton("       Send       ");

		tfMessage = new JTextField(32);		
		lstClients = new JList();
		
		setUpTabs();
		setUpProperties();
		
		Box displayBox = Box.createHorizontalBox();
		displayBox.add( tbChatWindows );
		displayBox.add( Box.createHorizontalStrut(3) );
		displayBox.add( scrlClients );

		Box commandBox = Box.createHorizontalBox();
		commandBox.add( tfMessage );
		commandBox.add( Box.createHorizontalStrut(3) );
		commandBox.add( bSend );

		Container cp = this.getContentPane();
		cp.setLayout( new FlowLayout(FlowLayout.LEFT) );
		cp.add( displayBox );
		cp.add( commandBox );
	}
	
	protected void setUpTabs()
	{
		messageWindows = new Vector(5,2);
		tabToClient = new Vector(5,2);
		tbChatWindows = new JTabbedPane( JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
		
		//Set up the main room tab. This tab cannot be closed
		messageWindows.addElement( new JTextArea(10,30) );
		((JTextArea)messageWindows.elementAt(0)).setLineWrap(true);
		((JTextArea)messageWindows.elementAt(0)).setEditable(false);		
		
		tbChatWindows.addTab( "Main",new JScrollPane( (JTextArea)
							messageWindows.elementAt(0),
							JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
							JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		
		tbChatWindows.setIconAt( 0,new ImageIcon( "icons/usmenu.gif" ) );
		//tbChatWindows.setForegroundAt( 0, Color.BLUE );
	}
	
	//Open a tab to chat with specified friend
	void openNewTab( int friendId )
	{
		//Check if a conversation tab is already open for the friend
		//If yes then set focus to that tab
		int index = tabToClient.indexOf( new Integer( friendId ) );
		if( index != -1 )
		{
			tbChatWindows.setSelectedIndex( index );
			return;
		}
		
		//Open a new conversation tab. Add a new message window to
		//list, map the client to tab, set properties and add tab
		messageWindows.addElement( new JTextArea(10,30) );
		tabToClient.addElement( new Integer(friendId) );
		((JTextArea)messageWindows.lastElement()).setLineWrap(true);
		((JTextArea)messageWindows.lastElement()).setEditable(false);		
		lstClients.setSelectedIndex( friendId );
		tbChatWindows.addTab( (String)lstClients.getSelectedValue(),(new JScrollPane( (JTextArea)messageWindows.lastElement() ) ) );
		tbChatWindows.setIconAt( tabToClient.size(),new ImageIcon( "icons/aol.gif" ) );

		tabMenu.setEnabled( true );
		closeTabMenu.setEnabled( true );
		closeAllTabsMenu.setEnabled( true );
	}

	private void showMessage( int tabSelected, String message )
	{
		((JTextArea)messageWindows.elementAt(tabSelected)).append( message );
	}
		
	void showMessage( Message userMsg )
	{
		int tabIndex = 0;

		//If message is public show in main room tab else sort the
		//the message to a tab using mappin in tabToClient
		if( ((Message)userMsg).audience == true )
		{
			((JTextArea)messageWindows.elementAt(tabIndex)).append( ((Message)userMsg).message + "\n");
		}
		else
		{
			tabIndex = tabToClient.indexOf( new Integer(((Message)userMsg).senderId) );
			//if( tabIndex == -1 )
				//JOptionPane.showMessageDialog( client.window, "Index Not Found", "Index Error", JOptionPane.INFORMATION_MESSAGE );				
			((JTextArea)messageWindows.elementAt(tabIndex+1)).append( ((Message)userMsg).message + "\n");
		}
		//JScrollBar hBar = scrlMessages.getVerticalScrollBar();
		//hBar.setValue( hBar.getMaximum() );
	}
	
	protected void sendMessage()
	{
		String str = tfMessage.getText();
		int tabSelected = tbChatWindows.getSelectedIndex();

		if( str.length() != 0 )
		{
			try
			{
				if( tabSelected == 0 )
				{
					client.sendPublicMessage( str );
				}
				else
				{
					Integer clientIndex = (Integer)tabToClient.elementAt( tabSelected-1 );
					client.sendPrivateMessage( clientIndex.intValue(),str );
					((JTextArea)messageWindows.elementAt( tabSelected )).append(client.Name + " says > " + str + "\n");
				}
			}
			catch( IOException io_ex )
			{
				showMessage( tabSelected,"\n\nCannot Send Message...\n\n" );
			}
			tfMessage.setText("");
		}
	}
	
	//Close all conversation tabs except the main chat room
	protected void closeAllTabs()
	{
		int index = 1;
		while( index != tbChatWindows.getTabCount() )
		{
			tbChatWindows.removeTabAt( index );
			messageWindows.removeElementAt( index );
		}
		tabToClient.clear();

		tabMenu.setEnabled( false );
		closeTabMenu.setEnabled( false );
		closeAllTabsMenu.setEnabled( false );
	}
	
	//Show effects of disconnection on the interface
	synchronized void notifyDisconnect()
	{
		connectFMenu.setEnabled( true );
		disconnectFMenu.setEnabled( false );
		tfMessage.setEnabled( false );
		bSend.setEnabled( false );
		closeAllTabs();
		//lstClients.updateUI();
		lstClients.setEnabled( false );
	}

	//If this client was in a conversation with the user then close
	//tab and inform the user that his friend has left
	void notifyUserLeft( String clientName )
	{
		int friendId = client.clientList.indexOf( clientName );
		int index = tabToClient.indexOf( new Integer( friendId ) );
	
		//If no conversation tab for the specified user
		if( index == -1 )
			return;
		
		JOptionPane.showMessageDialog( client.window,clientName+" Has Logged Out",
										"User Left",JOptionPane.INFORMATION_MESSAGE );
										
		tbChatWindows.removeTabAt( index+1 );
		messageWindows.removeElementAt( index+1 );
		tabToClient.removeElementAt( index );

		//If only the main room tab is left disable the tab menu
		if( tbChatWindows.getTabCount() == 1 )
		{
			tabMenu.setEnabled( false );
			closeTabMenu.setEnabled( false );
			closeAllTabsMenu.setEnabled( false );
		}					
	}
	
	class OnExit extends WindowAdapter implements WindowListener
	{
		public void windowClosing( WindowEvent we )
		{
			client.shutDown();
		}

		//Make textField get the focus whenever frame is activated.
		public void windowActivated(WindowEvent e)
		{
	        tfMessage.requestFocus();
    	}
	}

	class CloseTabButton implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			int index = tbChatWindows.getSelectedIndex();
			if( index !=0 )
			{
				tbChatWindows.removeTabAt( index );
				messageWindows.removeElementAt( index );
				tabToClient.removeElementAt( index-1 );
				
				if( tbChatWindows.getTabCount() == 1 )
				{
					tabMenu.setEnabled( false );
					closeTabMenu.setEnabled( false );
					closeAllTabsMenu.setEnabled( false );
				}					
			}
		}
	}
	
	class CloseAllTabsMenu implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			closeAllTabs();
		}
	}
	
	class ExitButton implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			client.shutDown();
		}
	}

	class SendButton implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			sendMessage();
			tfMessage.requestFocus();
		}
	}

	class SendMessage implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			sendMessage();
		}
	}

	class SelectClient extends MouseAdapter implements MouseListener
	{
	     public void mouseClicked(MouseEvent e)
	     {
     		if( !lstClients.isSelectionEmpty() )
     		{
	     		if ( e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1 )
    	 		{
					openNewTab( lstClients.getSelectedIndex() );
					client.sendChatRequest( lstClients.getSelectedIndex() );
      			}
      		}
		}
	}

	class ConfigureFMenu implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			ConfigureServerInfo serverDialog = new ConfigureServerInfo();
		}
	}
	
	class AboutHlpMenu implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			JOptionPane.showMessageDialog( client.window, "Fruit Cha(a)t Server" 
			+"\nVersion 0.7 \nThis software is distributed under the GPL Liscence",
			"About Fruit Cha(a)t", JOptionPane.INFORMATION_MESSAGE );
		}
	}
		
	class HelpHlpMenu implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			JOptionPane.showMessageDialog( client.window,
			"1) To connect to server go to File|Connect\n\n"+
			"2) To Configure go to File|Configure\n"+
			"   2a)Enter the host name of computer,server is on,\n"+
			"      set to localhost if on same machine\n"+
			"   2b)Don't change port unless you changed the port on server\n\n"+
			"3)Enter you message in the text field at the bottom\n"+
			"  and press enter(return key) or the send button\n\n"+
			"4)To start a private conversation, double click a name\n"+
			"  in the online users list",
			"General Information",JOptionPane.INFORMATION_MESSAGE);
		}
	}
				
	class WebHlpMenu implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			JOptionPane.showMessageDialog( client.window, "For free source code visist www.akbani.20m.com.", "Fruit Cha(a)t on the WEB", JOptionPane.INFORMATION_MESSAGE );
		}
	}
	
	class ConnectFMenu implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			do
			{
				client.Name = JOptionPane.showInputDialog( client.window,"Enter Login Name ?");
			}
			while( (client.Name==null || client.Name.length()==0) );
			
			if( client.connectToServer() )
			{
				client.window.setTitle( "Fruit Cha(a)t Plate <--> " + client.Name );

				if( lstClients.getModel() != client.clientList )
				{
					lstClients.setModel( client.clientList );
				}
			
				connectFMenu.setEnabled( false );
				disconnectFMenu.setEnabled( true );			
				tfMessage.setEnabled( true );
				bSend.setEnabled( true );
				lstClients.setEnabled( true );
				((JTextArea)messageWindows.elementAt(0)).setText("");
				tfMessage.requestFocus();
			}
		}
	}

	
	class DisconnectFMenu implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			client.disconnectFromServer( true );
			notifyDisconnect();
		}
	}
	/*
	class FocusMessageField extends FocusAdapter implements FocusListener
	{
		public void focusLost( FocusEvent fe )
		{
			if(!( fe.getOppositeComponent() instanceof JMenuItem ))
			{
				tfMessage.requestFocus();
			}
		}
	}
	*/
	//DISPLAYS AND SETS CONFIGURATION OPTIONS
	class ConfigureServerInfo extends JDialog
	{
		JButton bSave = new JButton("Save");
		JButton bCancel = new JButton("Cancel");
		JLabel lbServer = new JLabel("Server Name : ");
		JTextField tfServerName = new JTextField(10);
		JLabel lbPort = new JLabel("Port No :            ");
		JTextField tfPortNo = new JTextField(6);
		
		ConfigureServerInfo()
		{
			super(client.window,"Configure Connection",true);

			Box buttonBox = Box.createHorizontalBox();
			buttonBox.add( Box.createHorizontalStrut(50) );
			buttonBox.add(bSave);
			//buttonBox.add( Box.createHorizontalStrut(10) );
			buttonBox.add(bCancel);
			
			Container jcp = this.getContentPane();
			jcp.setLayout( new FlowLayout(FlowLayout.LEFT) );
			jcp.add(lbServer);
			jcp.add(tfServerName);
			jcp.add(lbPort);
			jcp.add(tfPortNo);
			//jcp.add( commandBox );
			jcp.add( buttonBox );

			bSave.addActionListener( new SaveButton() );
			bCancel.addActionListener( new CancelButton() );
			
			client.getConfiguration();
			
			tfServerName.setText( client.serverAddress );
			tfPortNo.setText( Integer.toString( client.serverSocketNumber ) );
			
			this.setSize(230,115);
					
			//Position the dialog in the center of the interface
			Point position = client.window.getLocation();
			position.x = position.x + (client.window.getWidth()/2) - (this.getWidth()/2);
			position.y = position.y + (client.window.getHeight()/2) - (this.getHeight()/2);
			this.setLocation( position );

			this.setVisible(true);
			this.setResizable( false );			
		}

		class SaveButton implements ActionListener
		{
			public void actionPerformed( ActionEvent e )
			{
				client.setConfiguration( tfServerName.getText(), Integer.parseInt(tfPortNo.getText()) );
				dispose();
			}
		}
		
		class CancelButton implements ActionListener
		{
			public void actionPerformed( ActionEvent e )
			{
				dispose();
			}
		}
		
	}
}