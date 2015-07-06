import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Title:       MapCreation.java
 * Description: This class allows the user to customize the map size and
 *              map attributes
 * @author:     Shane Grund
 * @version:    1.0
 */
public class MapCreation extends JPanel
{
      private JLabel smallLabel, largeLabel, mediumLabel;
      private JLabel continentLabel, variedLabel, islandLabel;
      private JLabel mainLabel;
      private ImageIcon smallIcon, largeIcon, mediumIcon;
      private ImageIcon continentIcon, variedIcon, islandIcon;
      protected JRadioButton smallButton, mediumButton, largeButton;
      protected JRadioButton continentButton, variedButton, islandButton;
      private ButtonGroup sizeGroup, styleGroup;

      private JPanel sizePanel, stylePanel;

      /**
       * Constructor allows for set up of the panel
       */
      public MapCreation()
      {
            //panel set up
            this.setLayout(new GridLayout(0,1));

            //set up labels
            smallIcon = new ImageIcon("images/MapCreation/smallWorld.png");
            smallLabel = new JLabel(smallIcon);

            mediumIcon = new ImageIcon("images/MapCreation/mediumWorld.png");
            mediumLabel = new JLabel(mediumIcon);

            largeIcon = new ImageIcon("images/MapCreation/largeWorld.png");
            largeLabel = new JLabel(largeIcon);

            continentIcon = new ImageIcon("images/MapCreation/Continent.png");
            continentLabel = new JLabel(continentIcon);

            variedIcon = new ImageIcon("images/MapCreation/ContinentAndIsland.png");
            variedLabel = new JLabel(variedIcon);

            islandIcon = new ImageIcon("images/MapCreation/Islands.png");
            islandLabel = new JLabel(islandIcon);

            mainLabel = new JLabel("New Map Creation");
            mainLabel.setForeground(new Color(51, 0, 51));
            mainLabel.setFont(new Font("Dialog", 1, 32));
            mainLabel.setHorizontalAlignment(SwingConstants.CENTER);

            //set up the radioButtons
            smallButton = new JRadioButton("Small 50x50");
            mediumButton = new JRadioButton("Medium 75x75");
            largeButton = new JRadioButton("Large 100x100");
            largeButton.setSelected(true);

            sizeGroup = new ButtonGroup();
            sizeGroup.add(smallButton);
            sizeGroup.add(mediumButton);
            sizeGroup.add(largeButton);

            continentButton = new JRadioButton("Continents");
            variedButton = new JRadioButton("Varied");
            variedButton.setSelected(true);
            islandButton = new JRadioButton("Islands");

            styleGroup = new ButtonGroup();
            styleGroup.add(continentButton);
            styleGroup.add(variedButton);
            styleGroup.add(islandButton);


            //set up the panels
            sizePanel = new JPanel(new GridLayout(2,3));
            sizePanel.setBorder(BorderFactory.createTitledBorder("Please select map size"));
            sizePanel.add(smallLabel);
            sizePanel.add(mediumLabel);
            sizePanel.add(largeLabel);
            sizePanel.add(smallButton);
            sizePanel.add(mediumButton);
            sizePanel.add(largeButton);

            stylePanel = new JPanel(new GridLayout(2,3));
            stylePanel.setBorder(BorderFactory.createTitledBorder("Please select land style"));
            stylePanel.add(continentLabel);
            stylePanel.add(variedLabel);
            stylePanel.add(islandLabel);
            stylePanel.add(continentButton);
            stylePanel.add(variedButton);
            stylePanel.add(islandButton);

            //add to panel
            this.add(mainLabel);
            this.add(sizePanel);
            this.add(stylePanel);
            //this.add(buttonPanel);
      }//end constructor
}//end class
