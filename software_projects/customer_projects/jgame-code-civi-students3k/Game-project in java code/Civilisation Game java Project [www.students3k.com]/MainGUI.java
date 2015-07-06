import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Title:       MainGUI.java
 * Description: This is the main class of this application. It starts the game
 *              and also sets up most other screens ready to be shown. It also
 *              handles some events of other panels.
 * @author:     Shane Grund
 * @version:    1.0
 */
public class MainGUI extends GameCore implements ActionListener, Runnable
{
      private JButton playButton, aboutButton, quitButton;
      private JButton createButton, saveButton;
      private JButton unitButton, doneButton;
      private JFrame frame;
      private JPanel eastPanel, buttonPanel, southPanel;

      private AboutPanel aboutPanel;
      private MapPanel mapPanel;
      private MapCreation mapCreation;
      private UnitTable unitTable;

      private Image bgImage;

      private Container contentPane;
      private boolean gameStarted = false;
      private boolean isFullScreen = true;

      /**
       * Constructor sets up the screen, gets a full screen to start with and
       * sets up all components to be shown on the content pane.
       */
      public void init()
      {
            super.init();

            // make sure Swing components don't paint themselves
            RepaintManager repaintManager = new RepaintManager();
            repaintManager.setDoubleBufferingEnabled(false);
            RepaintManager.setCurrentManager(repaintManager);

            //load image
            bgImage = loadImage("images/background.gif");

            // create buttons
            quitButton = createButton("quit", "Quit");
            playButton = createButton("play", "Start New Game");
            aboutButton = createButton("config", "About");
            unitButton = createButton("unit","View Units");

            frame = super.screen.getFullScreenWindow();
            contentPane = frame.getContentPane();

            // make sure the content pane is transparent
            if (contentPane instanceof JComponent)
            {
                  ((JComponent)contentPane).setOpaque(false);
            }//end if

            //create a border
            Border border = BorderFactory.createLineBorder(Color.black);

            //create the aboutDialog
            aboutPanel = new AboutPanel();
            aboutPanel.setBorder(border);
            aboutPanel.setVisible(false);
            aboutPanel.setSize(aboutPanel.getPreferredSize());

            // center the dialog
            aboutPanel.setLocation(
              (screen.getWidth() - aboutPanel.getWidth()) / 2,
              (screen.getHeight() - aboutPanel.getHeight()) / 2);

           //create the unit panel
           unitTable = new UnitTable();
           doneButton = new JButton("Close");
           doneButton.addActionListener(this);
           unitTable.bottomPanel.add(doneButton);
           unitTable.setBorder(border);
           unitTable.setVisible(false);
           unitTable.setSize(600,360);

           //center the panel
           unitTable.setLocation(100,130);

           //create the mapCreation dialog
           mapCreation = new MapCreation();
           buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
           createButton = new JButton("Generate Map");
           createButton.addActionListener(this);
           buttonPanel.add(createButton);
           mapCreation.add(buttonPanel);
           mapCreation.setBorder(border);
           mapCreation.setVisible(false);
           mapCreation.setSize(aboutPanel.getPreferredSize());

           // center the dialog
           mapCreation.setLocation(
             (screen.getWidth() - aboutPanel.getWidth()) / 2,
             (screen.getHeight() - aboutPanel.getHeight()) / 2);

           // add the dialog to the "modal dialog" layer of the screen's layered pane.
           screen.getFullScreenWindow().getLayeredPane().add(aboutPanel, JLayeredPane.MODAL_LAYER);
           screen.getFullScreenWindow().getLayeredPane().add(mapCreation, JLayeredPane.MODAL_LAYER);
           screen.getFullScreenWindow().getLayeredPane().add(unitTable, JLayeredPane.MODAL_LAYER);

           //set up east panel
           eastPanel = new JPanel(new FlowLayout());
           eastPanel.setOpaque(false);
           eastPanel.add(playButton);
           eastPanel.add(unitButton);
           eastPanel.add(aboutButton);
           eastPanel.add(quitButton);

           //set up the north and south panel
           southPanel = new JPanel(new BorderLayout());
           southPanel.setOpaque(false);
           southPanel.add(eastPanel, BorderLayout.NORTH);

           // add components to the screen's content pane
           contentPane.setLayout(new BorderLayout());
           contentPane.add(southPanel, BorderLayout.SOUTH);

           // explicitly layout components (needed on some systems)
           frame.validate();
      }//end constructot

      public static void main(String[] args)
      {
            new MainGUI().run();
      }//end main

      /**
          Extends GameCores functionality to draw all
          Swing components.
       */
      public void draw(Graphics2D g)
      {
            g.drawImage(bgImage, 0, 0, null);
            frame = super.screen.getFullScreenWindow();
            frame.getLayeredPane().paintComponents(g);
      }//end draw

      /**
           Called by the AWT event dispatch thread when a button is
           pressed.
       */
      public void actionPerformed(ActionEvent e)
      {
            if (e.getSource() == quitButton)//quit
            {
                  System.exit(0);
            }//end if

            else if (e.getSource() == aboutButton)//show about dialog
            {
                  aboutPanel.setVisible(true);
            }//end if

            else if (e.getSource() == playButton)//start game
            {
                  if(gameStarted == false)
                  {
                        mapCreation.setVisible(true);
                  }
                  gameStarted = true;
            }//end if

            else if(e.getSource() == unitButton)//view units in a jTable
            {
                  unitTable.setVisible(true);
            }//end else if

            else if(e.getSource() == doneButton)//close jTable
            {
                  unitTable.setVisible(false);
                  if(gameStarted == true)
                        mapPanel.requestFocus();
            }//end else if

            else if(e.getSource() == createButton)//create new map
            {
                  mapCreation.setVisible(false);
                  int size = 0;
                  int style = 0;
                  if(mapCreation.largeButton.isSelected())
                        size = 100;
                  else if(mapCreation.mediumButton.isSelected())
                        size = 75;
                  else
                        size = 50;
                  if(mapCreation.continentButton.isSelected())
                        style = 1;
                  else if(mapCreation.variedButton.isSelected())
                        style = 2;
                  else
                        style = 3;
                  mapPanel = new MapPanel(size, style);
                  mapCreation.setVisible(false);
                  contentPane.add(mapPanel, BorderLayout.CENTER);
                  mapPanel.setVisible(true);
                  eastPanel.setBackground(Color.black);
                  eastPanel.setOpaque(true);
                  mapPanel.requestFocus();

                  PlayMidi pm = new PlayMidi("sounds/The_Salt_Flats.mid");
            }//end if
      }//end actionPerformed

      public JButton createButton(String name, String toolTip)//create a new JButton
      {
            // load the image
            String imagePath = "images/menu/" + name + ".png";
            ImageIcon iconRollover = new ImageIcon(imagePath);
            int w = iconRollover.getIconWidth();
            int h = iconRollover.getIconHeight();

            // get the cursor for this button
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

            // make translucent default image
            Image image = screen.createCompatibleImage(w, h,Transparency.TRANSLUCENT);
            Graphics2D g = (Graphics2D)image.getGraphics();
            Composite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f);
            g.setComposite(alpha);
            g.drawImage(iconRollover.getImage(), 0, 0, null);
            g.dispose();
            ImageIcon iconDefault = new ImageIcon(image);

            // make a pressed iamge
            image = screen.createCompatibleImage(w, h,Transparency.TRANSLUCENT);
            g = (Graphics2D)image.getGraphics();
            g.drawImage(iconRollover.getImage(), 2, 2, null);
            g.dispose();
            ImageIcon iconPressed = new ImageIcon(image);

            // create the button
            JButton button = new JButton();
            button.addActionListener(this);
            button.setIgnoreRepaint(true);
            button.setFocusable(false);
            button.setToolTipText(toolTip);
            button.setBorder(null);
            button.setContentAreaFilled(false);
            button.setCursor(cursor);
            button.setIcon(iconDefault);
            button.setRolloverIcon(iconRollover);
            button.setPressedIcon(iconPressed);

            return button;
      }//end create Button
}//end menu test
