package br.unisc.prog5.trabalho.pharma;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JTelaPadrao extends JInternalFrame { 

	private Container container;
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	
	public JTelaPadrao(){
        super("Teste",true,true,true,true);
				//setagem do layout
		container = getContentPane();
		gbLayout = new GridBagLayout();
		container.setLayout(gbLayout);
		
		//instancia as limitações
		gbConstraints = new GridBagConstraints();

	}
	
	public void mostra()
	{
        setOpaque( true );
        show();
	}

	public void mostra(JDesktopPane main)
	{
		main.add(this);
        setOpaque( true );
        show();
	}


	public void addComponent(Component c, int linha, int coluna, int width, int height)
	{
		gbConstraints.gridx = coluna;
		gbConstraints.gridy = linha;
		
		gbConstraints.gridwidth = width;
		gbConstraints.gridheight = height;
		
		gbLayout.setConstraints(c,gbConstraints);
		container.add(c);
	}
	
	public void setConstraintFill(int fillConstraint){
		gbConstraints.fill = fillConstraint;
	}
	
	public void setConstraintGridwidth(int gridwidth){
		gbConstraints.gridwidth = gridwidth;
	}
	
	public void setWeightx(int v)
	{
       	gbConstraints.weightx = v;  // can grow wider
	}
	
	public void setWeighty(int v)
	{
       	gbConstraints.weighty = v;  // can grow taler
	}
	
}