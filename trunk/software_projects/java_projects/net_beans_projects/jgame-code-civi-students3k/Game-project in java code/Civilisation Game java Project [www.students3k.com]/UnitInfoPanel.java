import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Title:       UnitInfoPanel.java
 * Description: This panel allows players to view unit statistics
 * @author:     Shane Grund
 * @version:    1.0
 */
public class UnitInfoPanel extends JPanel
{
      private JLabel playerLabel, unitLabel, attack, defence, moves, yearLabel;
      private ImageIcon playerIcon;
		private int year;

      /**
       * This constructor sets up the panel
       */
      public UnitInfoPanel()
      {
            this.setLayout(new GridLayout(0,1));
            this.setBackground(Color.black);
            this.setBorder(BorderFactory.createEtchedBorder(0,Color.blue,Color.blue));
				year = -4000;

            //set up labels
				yearLabel = new JLabel("  Year: 4000 bc  ");
				yearLabel.setForeground(Color.white);
            playerLabel = new JLabel("  Player 1  ");
				playerLabel.setForeground(Color.white);

            playerIcon = new ImageIcon("images/units/settler1.png");
            unitLabel = new JLabel(playerIcon);

            attack = new JLabel("  Attack: 0  ");
				attack.setForeground(Color.white);
            defence = new JLabel("  Defence: 0  ");
				defence.setForeground(Color.white);
            moves = new JLabel("  Moves Left: 1  ");
				moves.setForeground(Color.white);

				this.add(yearLabel);
            this.add(playerLabel);
            this.add(unitLabel);
            this.add(attack);
            this.add(defence);
            this.add(moves);
      }//end constructor

      public void setImageIcon(ImageIcon i)
      {
            playerIcon = i;
            unitLabel.setIcon(playerIcon);
      }//end set imageIcon

      public void setPlayer(int i)
      {
            playerLabel.setText("  Player " + i+ "  ");
      }//end set player

      public void setMovement(int i)
      {
            moves.setText("  MovesLeft: " + i+ "  ");
      }//end set movement

      public void setAttack(int i)
      {
            attack.setText("  Attack: " + i+ "  ");
      }//end set attack

      public void setDefence(int i)
      {
            defence.setText("  Defence: " + i+ "  ");
      }//end set defence
		
		public void setYear(int i)
		{
			year = i;
			if(year < 0)
			{
				int temp = Math.abs(year);
				yearLabel.setText("  Year: " + temp + " bc  ");
			}
			else
				yearLabel.setText("  Year: " + year + " ad  ");
		}
		
		public int getYear()
		{
			return year;
		}
}//end class
