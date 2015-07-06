import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Title:       AboutPanel.java
 * Description: This class shows the about box showing who programmed the game
 * @author:     Shane Grunf
 * @version:    1.0
 */
public class AboutPanel extends JPanel implements ActionListener
{
      private JButton okButton;
      private JPanel buttonPanel;
      private JLabel myLabel;
      private ImageIcon myIcon;

      public AboutPanel()
      {
            //create the panel containing the OK button
            this.setLayout(new BorderLayout());

            //set up the image
            myIcon = new ImageIcon("images/AboutDialog.png");
            myLabel = new JLabel(myIcon);
            add(myLabel, BorderLayout.CENTER);

            //set up the button
            okButton = new JButton("OK");
            okButton.setFocusable(false);
            okButton.addActionListener(this);

            //set up the panel
            buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.setBackground(Color.black);
            buttonPanel.add(okButton);
            add(buttonPanel, BorderLayout.SOUTH);
      }//end constructor

      public void actionPerformed(ActionEvent e)
      {
            this.setVisible(false);
      }//end actionPerformed
}//end class
