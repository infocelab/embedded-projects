import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class Damas extends JFrame {
	
	private boolean flServidor = false;
	private boolean flCliente = false;
	private JogoRemoto jogo;
	private int intPorta = 5000;
	public Damas() {
		
		super("Jogo de damas conectando dois micros");
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		final JMenuItem mItemMensagem = new JMenuItem("Enviar Mensagem");
		
		//setagens de JDesktopPane
		final JDesktopPane mdiDamas = new JDesktopPane();
		getContentPane().add(mdiDamas);
		
		JMenu menuJogo = new JMenu("Jogo");
		menuJogo.setMnemonic('J');
		
		JMenuItem mItemSobre = new JMenuItem("Sobre");
		
		mItemSobre.setMnemonic('e');
		mItemSobre.addActionListener( 
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
					//Mostra a tela de About
					JOptionPane.showMessageDialog( jogo.tabuleiro,
	                	"DamasJ \n\n Jogo de Damas implementado para a disciplina de Prog V\n" +
	                	"- Profesor Rolf F. Molz\nDiscentes:\n  => Eduardo Shoedles\n  => Marcelo Ivan Martin",
	                    "Sobre", JOptionPane.INFORMATION_MESSAGE);			
				}
			}
		); 
		menuJogo.add(mItemSobre);
		
		menuJogo.addSeparator();
		
		JMenuItem mItemNovo = new JMenuItem("Jogo Local");
		
		mItemNovo.setMnemonic('N');
		mItemNovo.addActionListener( 
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
				Tabuleiro tabuleiro = new Tabuleiro(' ');
		      	tabuleiro.resetaTabuleiro();
		      	tabuleiro.posicionaJogador('A',0);
		      	tabuleiro.posicionaJogador('B',40);
		      	tabuleiro.mostra(mdiDamas);
				}
			}
		);
		menuJogo.add(mItemNovo);
		
		
		menuJogo.addSeparator();

		JMenuItem mItemSair = new JMenuItem("Sair");
		
		mItemSair.setMnemonic('S');
		mItemSair.addActionListener( 
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
					dispose();
					System.exit(0);
				}
			}
		);
		menuJogo.add(mItemSair);
		
		menu.add(menuJogo);

		JMenu menuConexao = new JMenu("Conexão");
		menuJogo.setMnemonic('C');
		
		JMenuItem mItemServidor = new JMenuItem("Iniciar Servidor");
		mItemServidor.setMnemonic('S');
		mItemServidor.addActionListener( 
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
					jogo = new JogoRemoto();
					jogo.setModoServidor(true);
					try{
						intPorta = Integer.parseInt(JOptionPane.showInputDialog(null,
						                            "Informe a porta para estabelecer a comunicação?",
						                            "Porta do Servidor",
													JOptionPane.QUESTION_MESSAGE));
					}
					catch ( NumberFormatException nfe ) {
						JOptionPane.showMessageDialog(jogo.tabuleiro, "Porta Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
						intPorta = -1;
						//nfe.printStackTrace();
		            }
					
					if (intPorta > 0){
						jogo.inicializar(mdiDamas, intPorta);
						jogo.start();
						System.out.println("Servidor iniciado...");
						System.out.println("Aguardando Conexao na porta " + intPorta + " ...");
						mItemMensagem.setEnabled(true);
					}
				}
			}
		); 
		menuConexao.add(mItemServidor);

		JMenuItem mItemCliente = new JMenuItem("Iniciar Cliente");
		mItemCliente.setMnemonic('C');
		mItemCliente.addActionListener( 
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
					jogo = new JogoRemoto();
					jogo.setModoServidor(false);
					try{
						intPorta = Integer.parseInt(JOptionPane.showInputDialog(null,
						                            "Informe a porta para estabelecer a comunicação com o Servidor",
						                            "Porta do Servidor",
													JOptionPane.QUESTION_MESSAGE));
					}
					catch ( NumberFormatException nfe ) {
						JOptionPane.showMessageDialog(jogo.tabuleiro, "Porta Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
						intPorta = -1;
						//nfe.printStackTrace();
		            }
					if (intPorta > 0){
						jogo.ip = JOptionPane.showInputDialog(null,
			                            "Informe o IP do Servidor",
			                            "Endereço do Servidor",
										JOptionPane.QUESTION_MESSAGE);
						jogo.inicializar(mdiDamas, intPorta);
						jogo.start();
						System.out.println("Aguardando Conexao...");
						mItemMensagem.setEnabled(true);
					}
				}
			}
		); 
		menuConexao.add(mItemCliente);
		
		menuConexao.addSeparator();

		mItemMensagem.setMnemonic('M');
		mItemMensagem.addActionListener( 
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
					jogo.enviarMensagem(JOptionPane.showInputDialog(null,
			                            "Digite o texto",
			                            "Enviar Mensagem",
										JOptionPane.INFORMATION_MESSAGE));
				}
			}
		);
			
		menuConexao.add(mItemMensagem);
		
		mItemMensagem.setEnabled(false);

		menu.add(menuConexao);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		show();
	}


	public static void main(String args[]) {
		System.out.println("Iniciando Damas");
		Damas mainFrame = new Damas();
		mainFrame.setSize(640, 480);
		mainFrame.setVisible(true);
	}
}



class JogoRemoto extends Thread {

	public Tabuleiro tabuleiro;
	public ServerSocket servidor;
	private Socket conexao;
	private Thread transmissao;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private boolean flag = true;
	private int porta;
	private String mensagem = "";
	private boolean serv;
	public String ip = "127.0.0.1";

	public void JogoRemoto(){
		
	}
		
	public void setModoServidor(boolean modoServidor){
		serv=modoServidor;
		if (serv){
			tabuleiro	= new Tabuleiro('A');}
		else{
			tabuleiro	= new Tabuleiro('B');
		}
		tabuleiro.modoRede(true);
		tabuleiro.bloq = true;
	}

	public void inicializar(JDesktopPane mdiForm, int iPorta){
		tabuleiro.mostra(mdiForm);
		porta = iPorta;
	}

	public void inicializar(JDesktopPane mdiForm, int iPorta, String sIp){
		tabuleiro.mostra(mdiForm);
		porta = iPorta;
		ip = sIp;
	}
	
	public void enviarMensagem(String msg){
		try{
			output.writeObject((String) "MENSAGEM");
			output.flush();
			output.writeObject((String) msg);
			output.flush();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public void run(){
		
		int xo;
		int yo;
		int xd;
		int yd;
		
		try {
			if (serv){
	        	servidor = new ServerSocket( porta, 100 );			
	     	}
	        while( flag ){
	        	if (serv){
	        		System.out.println("Servidor");
					conexao = servidor.accept();
				}
				else{
					System.out.println("Aguardando Servidor no local informado...");
					conexao = new Socket(InetAddress.getByName(ip),porta);
				}
				System.out.println("Conectado com: " + conexao.getLocalAddress().getHostName());
				tabuleiro.bloq = false;
				output = new ObjectOutputStream(conexao.getOutputStream());
				output.flush();
				input = new ObjectInputStream(conexao.getInputStream());
				output.writeObject(mensagem);
				output.flush();
		  		tabuleiro.setOutput(output);
	  			do{
		        	try {
   	 		            mensagem = (String) input.readObject();
   	 		            if (mensagem.compareTo("MOVIMENTO") == 0){
   	 		            	mensagem = (String) input.readObject();
   	 		            	xo = Integer.parseInt(mensagem.substring(0,1));
   	 		            	yo = Integer.parseInt(mensagem.substring(2,3));
   	 		            	xd = Integer.parseInt(mensagem.substring(4,5));
   	 		            	yd = Integer.parseInt(mensagem.substring(6,7));
   	 		            	tabuleiro.movePeca(xo,yo,xd,yd,false);
   	 		            	tabuleiro.trocaVez();
   	 		            }
   	 		            else if (mensagem.compareTo("COME") == 0){
   	 		            	mensagem = (String) input.readObject();
   	 		            	xo = Integer.parseInt(mensagem.substring(0,1));
   	 		            	yo = Integer.parseInt(mensagem.substring(2,3));
							tabuleiro.comePeca(xo, yo);
   	 		            }
   	 		            else if (mensagem.compareTo("MENSAGEM") == 0){
   	 		            	mensagem = (String) input.readObject();
							JOptionPane.showMessageDialog( null,
			                	mensagem, "Mensagem Recebida", JOptionPane.INFORMATION_MESSAGE);			
   	 		            }
   	 		            
		            }
		            catch ( ClassNotFoundException cnfe ) {
		                System.out.println("Objeto desconhecido recebido");
		                flag = false;
		            }
					catch ( NumberFormatException nfe ) {
						//nfe.printStackTrace();
		            }
		            //System.out.println(mensagem);
	  			} while (flag);
	  			
	  			output.close();
	  			input.close();
	  			conexao.close();
				if (serv)
				{
					servidor.close();
				}
	        }
		}
		catch (OptionalDataException ode){
			System.out.println("Erro de dado opcional");
			flag = false;
		}
		catch (IOException ioe){
			ioe.printStackTrace();
			flag = false;
		}
		
	}
}