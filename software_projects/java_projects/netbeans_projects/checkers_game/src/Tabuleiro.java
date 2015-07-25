import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Tabuleiro extends JInternalFrame 
	implements MouseListener, MouseMotionListener { 
   	private Container container;
   	private GridBagLayout gbLayout;
   	private GridBagConstraints gbConstraints; 
   	private Casa casa[][] = new Casa[8][8];
   	private char tabuleiro[][] = new char[8][8];
    private int selx = -1;
    private int sely = -1;
    private Color corA = new Color(26,189,79);
    private Color corB = new Color(34,87,225);
    private byte pecasA = 0;
    private byte pecasB = 0;
    private char vez = 'A';
    private char eu = ' ';
    public boolean bloq = false;
    private String jogadorA = "";
    private String jogadorB = "";
    private ObjectOutputStream output;
    private boolean rede = false;
    
   	public Tabuleiro(char me)
	{

		super("Teste",true, true);
		
		eu = me;
		
		int lin;
		int col;

		setTitle( "Checkers" );

		addMouseListener( this );
		addMouseMotionListener( this );
		
		container = getContentPane();
		gbLayout = new GridBagLayout();
		container.setLayout(gbLayout);   
		// instantiate gridbag constraints
		gbConstraints = new GridBagConstraints();
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.weightx = 1;
		gbConstraints.weighty = 1;
      	for (lin = 0; lin < 8; lin++)
      	{
			for (col = 0; col < 8; col++)      	
      		{
				//inicializa a casa
      			casa[lin][col] = new Casa();      			
      			addComponent(casa[lin][col],lin,col,1,1);
      		}
        }

      	resetaTabuleiro();
      	
      	posicionaJogador('A',0);
      	posicionaJogador('B',40);
      		
      	setSize(400,400);
     	
    }

	public void setOutput(ObjectOutputStream oos){
		output = oos;
		try {
			output.flush();
	    }
	    catch ( IOException io ) {
	        io.printStackTrace();
	    }

	}

	public void modoRede(boolean r)
	{
		rede = r;
	}

    public void resetaTabuleiro()
    {
		int posX = 0;
      	int posY = 0;
	
	  	//for para definir as posi��es validas do tabuleiro
      	for (posX = 0; posX < 8; posX++)
      	{
      		for (posY = 0; posY < 8; posY++)
      		{
      			
      			if (posX % 2 == 0)
      			{
      				if (posY % 2 == 0)
      					tabuleiro[posX][posY] = ' ';
      				else
      					tabuleiro[posX][posY] = '*';
      			}
      			else
      			{
      				if (posY % 2 != 0)
      					tabuleiro[posX][posY] = ' ';
      				else
      					tabuleiro[posX][posY] = '*';
      			}
      			
      			if (tabuleiro[posX][posY] == '*')
      			{
					casa[posX][posY].setBackground(Color.black);
					casa[posX][posY].setForeground(Color.black);
	  			}
      			else
      			{
      				casa[posX][posY].setBackground(Color.white);
      				casa[posX][posY].setForeground(Color.white);
      			}
      		}
      	}
	}

	public void posicionaJogador(char jogador, int posInicial)
	{
		int cont;
		int pos = 0;
		
		if (jogador == 'A' || jogador == 'B')
		{
			for (cont = 0; cont < 12; cont++)
			{
				while(pos < 32)
				{
					if (tabuleiro[(pos + posInicial) / 8][(int)((pos + posInicial) % 8)] == ' ')
					{	
						tabuleiro[(pos + posInicial) / 8][(int)((pos + posInicial) % 8)] = jogador;
						if (jogador == 'A')
						{
							casa[(pos + posInicial) / 8][(int)((pos + posInicial) % 8)].setForeground(corA);
							pecasA++;
						}
						else if (jogador == 'B')
						{
							casa[(pos + posInicial) / 8][(int)((pos + posInicial) % 8)].setForeground(corB);
							pecasB++;
						}
						break;
					}
					pos++;
				}
			}
		}
	}

	public void mostra(JDesktopPane main)
	{
		main.add(this);
        setOpaque(true);
        show();
	}

	private void desPossibilita()
	{
		
		int posX = 0;
      	int posY = 0;
	
	  	//for para definir as posi��es validas do tabuleiro
      	for (posX = 0; posX < 8; posX++)
      	{
      		for (posY = 0; posY < 8; posY++)
      		{
      			casa[posY][posX].setPossivel(false, Color.cyan);
      		}
      	}
	}
	
	private void desSeleciona()
	{
		
		int posX = 0;
      	int posY = 0;
	
	  	//for para definir as posi��es validas do tabuleiro
      	for (posX = 0; posX < 8; posX++)
      	{
      		for (posY = 0; posY < 8; posY++)
      		{
      			casa[posY][posX].seleciona(false, Color.red);
      			selx = sely = -1;
      		}
      	}
	}
	
	private void lancesPossiveis(int x, int y)
	{
		int posX = 0;
      	int posY = 0;
	
		if (tabuleiro[x][y] == 'A' && vez == 'A') {
			if (x<7) {
				if (y<7) {
					if (tabuleiro[x+1][y+1] == 'B' && y<6 && x<6){
						if (tabuleiro[x+2][y+2] == ' '){
							//pode comer B
							casa[x+2][y+2].setPossivel(true,Color.cyan);
						}
					}
					if (tabuleiro[x+1][y+1] == ' '){
						casa[x+1][y+1].setPossivel(true,Color.cyan);
					}
					
				}
				if (y>0){
					if (tabuleiro[x+1][y-1] == 'B' && x<6 && y>1){
						if (tabuleiro[x+2][y-2] == ' '){
							//pode comer B
							casa[x+2][y-2].setPossivel(true,Color.cyan);
						}
					}
					if (tabuleiro[x+1][y-1] == ' '){
						casa[x+1][y-1].setPossivel(true,Color.cyan);
					}
				}
			}
			if (x>0  && casa[x][y].isDama()){
				if (y<7){
					if (tabuleiro[x-1][y+1] == 'B' && y<6 && x>1){
						if (tabuleiro[x-2][y+2] == ' '){
							//pode comer A
							casa[x-2][y+2].setPossivel(true,Color.cyan);
						}
					}
					if (tabuleiro[x-1][y+1] == ' '){
						casa[x-1][y+1].setPossivel(true,Color.cyan);
					}
				}
				if (y>0){
					if (tabuleiro[x-1][y-1] == 'B' && x>1 && y>1){
						if (tabuleiro[x-2][y-2] == ' '){
							//pode comer A
							casa[x-2][y-2].setPossivel(true,Color.cyan);
						}
					}
					if (tabuleiro[x-1][y-1] == ' ')
					{
						casa[x-1][y-1].setPossivel(true,Color.cyan);
					}
				}
			}
			
		}
	
	
		if (tabuleiro[x][y] == 'B' && vez == 'B'){
			if (x>0){
				if (y<7){
					if (tabuleiro[x-1][y+1] == 'A' && y<6 && x>1){
						if (tabuleiro[x-2][y+2] == ' '){
							//pode comer A
							casa[x-2][y+2].setPossivel(true,Color.cyan);
						}
					}
					if (tabuleiro[x-1][y+1] == ' '){
						casa[x-1][y+1].setPossivel(true,Color.cyan);
					}
				}
				if (y>0){
					if (tabuleiro[x-1][y-1] == 'A' && x>1 && y>1){
						if (tabuleiro[x-2][y-2] == ' '){
							//pode comer A
							casa[x-2][y-2].setPossivel(true,Color.cyan);
						}
					}
					if (tabuleiro[x-1][y-1] == ' ')
					{
						casa[x-1][y-1].setPossivel(true,Color.cyan);
					}
				}
			}
			if (x<7 && casa[x][y].isDama()) {
				if (y<7) {
					if (tabuleiro[x+1][y+1] == 'A' && y<6 && x<6){
						if (tabuleiro[x+2][y+2] == ' '){
							//pode comer B
							casa[x+2][y+2].setPossivel(true,Color.cyan);
						}
					}
					if (tabuleiro[x+1][y+1] == ' '){
						casa[x+1][y+1].setPossivel(true,Color.cyan);
					}
					
				}
				if (y>0){
					if (tabuleiro[x+1][y-1] == 'A' && x<6 && y>1){
						if (tabuleiro[x+2][y-2] == ' '){
							//pode comer B
							casa[x+2][y-2].setPossivel(true,Color.cyan);
						}
					}
					if (tabuleiro[x+1][y-1] == ' '){
						casa[x+1][y-1].setPossivel(true,Color.cyan);
					}
				}
			}
		}
	}

	public void trocaVez()
	{
		vez = (vez == 'A' ?  'B' : 'A');
	}

	public void movePeca(int xo, int yo, int xd, int yd)
	{
		movePeca(xo, yo, xd, yd, true);
	}

	public void movePeca(int xo, int yo, int xd, int yd, boolean local)
	{
		if (tabuleiro[yo][xo] != ' '){
			Casa origem = casa[yo][xo];
			Casa destino = casa[yd][xd];
			tabuleiro[yd][xd] = tabuleiro[yo][xo];
			tabuleiro[yo][xo] = ' ';
			destino.setForeground(origem.getForeground()); 
			origem.setForeground(origem.getBackground());
			if ((yd == 7 && tabuleiro[yd][xd] == 'A') || (yd == 0 && tabuleiro[yd][xd] == 'B') || (origem.isDama())){
				destino.setDama(true);
			}
			casa[yo][xo].setDama(false);
			if (local && rede) {
				try {
					output.writeObject((String) "MOVE");
					output.flush();
					output.writeObject((String) Integer.toString(xo) + "," +
												Integer.toString(yo) + "," + 
												Integer.toString(xd) + "," + 
												Integer.toString(yd) );
					output.flush();
			    }
			    catch ( IOException io ) {
			        io.printStackTrace();
			    }
			}
		}
	}

	public void comePeca(int x, int y)
	{
		comePeca(x, y, false);
	}

	public void comePeca(int x, int y, boolean local)
	{
		if (tabuleiro[y][x] == 'A')
			pecasA--;
		else if (tabuleiro[y][x] == 'B')
			pecasB--;
		tabuleiro[y][x] = ' ';
		casa[y][x].setDama(false);
		casa[y][x].setForeground(casa[y][x].getBackground());
		if (local && rede){
			try{
				output.writeObject((String) "COME");
				output.flush();
				output.writeObject((String) Integer.toString(x) + "," + Integer.toString(y));
				output.flush();
	        }
			    catch ( IOException io ) {
			        io.printStackTrace();
	        }
		}
	}

	public void addComponent(Component c, int linha, int coluna, int width, int height)	{
		gbConstraints.gridx = coluna;
		gbConstraints.gridy = linha;
		
		gbConstraints.gridwidth = width;
		gbConstraints.gridheight = height;
		
		gbLayout.setConstraints(c,gbConstraints);
		container.add(c);
	}

		// botao do mouse foi pressionado e liberado sem mover cursor
   public void mouseClicked( MouseEvent e ){
     // System.out.println( "Clicado em [" + e.getX() +
     //                    ", " + e.getY() + "]" );
   }


   	// botao do mouse foi solto
   public void mouseReleased( MouseEvent e ){
		int x = 0;
		int y = 0;
		if (!bloq && vez == eu || !rede){
			if (pecasA > 0 && pecasB > 0) {		
				x = (e.getX()) / (super.getWidth() / 8 );
				y = (e.getY() - 13) / (super.getHeight() / 8 );
				if (casa[y][x].isPossivel()){
					if (Math.abs(selx - x) == 2){
						System.out.println("comeu");
						comePeca((selx + x) / 2,(sely + y) / 2,true);
					}
					
					movePeca(selx,sely,x,y);
		
					if (pecasA == 0)
						JOptionPane.showMessageDialog( this,
		                	"O Jogador B Ganhou !",
		                    "Fim de Jogo", JOptionPane.PLAIN_MESSAGE );			
		
					if (pecasB == 0)
						JOptionPane.showMessageDialog( this,
		                	"O Jogador A Ganhou !",
		                    "Fim de Jogo", JOptionPane.PLAIN_MESSAGE );			
		
					if (vez == 'A')	{
						vez = 'B';
					}
					else{
						vez = 'A';
					}
				}
				
				desSeleciona();
				desPossibilita();
				
				if (tabuleiro[y][x] != ' ' && tabuleiro[y][x] != '*'){
					casa[y][x].seleciona(true,Color.red);
					selx = x;
					sely = y;
					lancesPossiveis(y,x);
				}
			}
		}
    }
   public void mousePressed( MouseEvent e ){
      //System.out.println( "Liberado em [" + e.getX() +
      //                   ", " + e.getY() + "]" );
   }

   	// cursor do mouse entra nos limites de um componente
   public void mouseEntered( MouseEvent e ){
      //System.out.println( "Mouse dentro da janela" );
   }

   // cursor do mouse sai dos limites de um componente
   public void mouseExited( MouseEvent e ){
      //System.out.println( "Mouse fora da janela" );
   }

   // botao foi pressionado e mouse movido
   public void mouseDragged( MouseEvent e ){
      //System.out.println( "Arrastado para [" + e.getX() +
      //                   ", " + e.getY() + "]" );
   }

   // mouse foi movido
   public void mouseMoved( MouseEvent e ){
      //System.out.println( "Movido para [" + e.getX() +
      //                   ", " + e.getY() + "]" );
   }
    
}
