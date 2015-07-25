import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * File:         BomberGame.java
 * Copyright:    Copyright (c) 2001
 * @author Sammy Leong
 * @version 1.0
 */

/**
 * This class contains the player objects.
 */
public class BomberGame extends JPanel
implements ActionListener {
    /** main frame object */
    private BomberMain main = null;
    /** game over flag */
    private boolean gameOver = false;
    /** map object */
    private BomberMap map = null;
    /** winner */
    private int winner = -1;
    /** timer */
    private Timer timer = null;
    /** elapsed seconds */
    private int elapsedSec = 0;

    /** rendering hints */
    private static Object hints = null;
    /** end game images */
    private static Image[] images = null;
    /** total number of players */
    public static int totalPlayers = 4;
    /** players alive */
    public static int playersLeft = totalPlayers;
    /** player objects */
    public static BomberPlayer[] players = null;

    static
    {
        /** if java runtime is Java 2 */
        if (Main.J2) {
            /** create the rendering hints for better graphics output */
            RenderingHints h = null;
            h = new RenderingHints(null);
            h.put(RenderingHints.KEY_TEXT_ANTIALIASING,
             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            h.put(RenderingHints.KEY_FRACTIONALMETRICS,
             RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            h.put(RenderingHints.KEY_ALPHA_INTERPOLATION,
             RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            h.put(RenderingHints.KEY_ANTIALIASING,
             RenderingHints.VALUE_ANTIALIAS_ON);
            h.put(RenderingHints.KEY_COLOR_RENDERING,
             RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            hints = (RenderingHints)h;
        }

        String path = BomberMain.RP + "Images/BomberEndGame/";
        String str = null;
        /** create the images */
        images = new Image[6];
        /** open the image files */
        try
        {
            for (int i = 0; i < 4; i++) {
                str = path + "Player " + (i + 1) + " Wins.jpg";
                images[i] = Toolkit.getDefaultToolkit().getImage(
                new File(str).getCanonicalPath());
            }
            str = path + "Draw.jpg";
            images[4] = Toolkit.getDefaultToolkit().getImage(
            new File(str).getCanonicalPath());
            str = path + "Enter to Continue.jpg";
            images[5] = Toolkit.getDefaultToolkit().getImage(
            new File(str).getCanonicalPath());
        } catch (Exception e) { new ErrorDialog(e); }
    }

    /**
     * Constructs a game.
     * @param main main frame object
     * @param map map object
     * @param totalPlayers total number of players
     */
    public BomberGame(BomberMain main, BomberMap map, int totalPlayers) {
        this.main = main;
        this.map = map;
        this.totalPlayers = this.playersLeft = totalPlayers;

        /** load the images */
        try {
            MediaTracker tracker = new MediaTracker(this);
            for (int i = 0; i < 6; i++) tracker.addImage(images[i], i);
            tracker.waitForAll();
        }
        catch (Exception e) { new ErrorDialog(e); }

        /** create the players array */
        players = new BomberPlayer[totalPlayers];
        /** create the players */
        for (int i = 0; i < totalPlayers; i++)
            players[i] = new BomberPlayer(this, map, i + 1);

        /** double buffer on */
        setDoubleBuffered(true);
        setBounds(0, 0, 17 << main.shiftCount, 17 << main.shiftCount);
        /** set it to opaque */
        setOpaque(false);
        /** add it to the top layer */
        main.getLayeredPane().add(this, 0);
    }

    /**
     * Key pressed handler
     * @param evt key event
     */
    public void keyPressed(KeyEvent evt)
    {
        if (!gameOver) {
           for (int i = 0; i < totalPlayers; i++)
               players[i].keyPressed(evt);
        }
        else if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timer.stop();
            timer = null;
            main.dispose();
            new BomberMain();
        }
    }

    /**
     * Key released handler
     * @param evt key event
     */
    public void keyReleased(KeyEvent evt)
    {
        if (!gameOver) {
           for (int i = 0; i < totalPlayers; i++)
               players[i].keyReleased(evt);
        }
    }

    /**
     * Drawing handler.
     * @param graphics graphics handle
     */
    public void paint(Graphics graphics) {
        Graphics g = graphics;
        /** if game is active */
        if (!gameOver) {
           for (int i = 0; i < totalPlayers; i++)
               players[i].paint(graphics);
        }
        /** if java runtime is Java 2 */
        if (Main.J2) { paint2D(graphics); }
        /** if java runtime isn't Java 2 */
        else {
            /** if game is over */
            if (gameOver) {
                /** draw end game image */
                g.drawImage(images[winner], 0,
                BomberMain.size == 16 ? -25 : -50,
                17 << BomberMain.shiftCount,
                17 << BomberMain.shiftCount, this);
                /** if elapsed seconds % 2 == 0 */
                /** then draw press enter to exit image */
                if (elapsedSec == 0)
                    g.drawImage(images[5], 0,
                    (17 << BomberMain.shiftCount) - images[5].getHeight(this) /
                    (BomberMain.size != 16 ? 1 : 2),
                    images[5].getWidth(this) / (BomberMain.size != 16 ? 1 : 2),
                    images[5].getHeight(this) /
                    (BomberMain.size != 16 ? 1 : 2), this);
                /** if elapsed seconds % 2 == 1 then clear the area */
                else
                    g.fillRect(0, (17 << BomberMain.shiftCount) -
                    images[5].getHeight(this) /
                    (BomberMain.size != 16 ? 1 : 2),
                    images[5].getWidth(this) /
                     (BomberMain.size != 16 ? 1 : 2),
                    images[5].getHeight(this) /
                    (BomberMain.size != 16 ? 1 : 2));
            }
            /** if 1 or less players left alive */
            if (playersLeft <= 1 && timer == null)
            {
                /** deactiavte all the players */
                for (int i = 0; i < totalPlayers; i++)
                    players[i].deactivate();
                timer = new Timer(1000, this);
                timer.start();
            }
        }
    }

    /**
     * Public accessor to paintImmediately(...).
     * @param x x-coordinate
     * @param y y-coordinate
     * @param w width
     * @param h height
     */
    public void pPaintImmediately(int x, int y, int w, int h) {
        paintImmediately(x, y, w, h);
    }

    /**
     * Drawing method for Java 2's Graphics2D
     * @param graphics graphics handle
     */
    public void paint2D(Graphics graphics) {
        Graphics2D g2 = (Graphics2D)graphics;
        /** set the rendering hints */
        g2.setRenderingHints((RenderingHints)hints);
        /** if game is over */
        if (gameOver) {
            /** draw end game image */
            g2.drawImage(images[winner], 0, BomberMain.size == 16 ? -25 : -50,
            17 << BomberMain.shiftCount, 17 << BomberMain.shiftCount, this);
            /** if elapsed seconds % 2 == 0 */
            /** then draw press enter to exit image */
            if (elapsedSec == 0)
                g2.drawImage(images[5], 0,
                (17 << BomberMain.shiftCount) - images[5].getHeight(this) /
                (BomberMain.size != 16 ? 1 : 2),
                images[5].getWidth(this) / (BomberMain.size != 16 ? 1 : 2),
                images[5].getHeight(this) /
                 (BomberMain.size != 16 ? 1 : 2), this);
            /** if elapsed seconds % 2 == 1 then clear the area */
            else
                g2.fillRect(0, (17 << BomberMain.shiftCount) -
                images[5].getHeight(this) / (BomberMain.size != 16 ? 1 : 2),
                images[5].getWidth(this) / (BomberMain.size != 16 ? 1 : 2),
                images[5].getHeight(this) / (BomberMain.size != 16 ? 1 : 2));
        }
        /** if 1 or less players left alive */
        if (playersLeft <= 1 && timer == null)
        {
            /** deactiavte all the players */
            for (int i = 0; i < totalPlayers; i++)
                players[i].deactivate();
            timer = new Timer(1000, this);
            timer.start();
        }
    }

    public void actionPerformed(ActionEvent evt) {
        /** increased elapsed time */
        elapsedSec += 1;
        /** if elapsed 4 seconds */
        if (elapsedSec >= 4)
        {
            /** if Java 2 available */
            if (Main.J2) {
               /** stop background music */
               BomberBGM.mute();
            }
            /** set default game result = draw */
            winner = 4;
            /** find winner */
            for (int i = 0; i < totalPlayers; i++) {
                if (!players[i].isDead()) { winner = i; break; }
            }
            gameOver = true;
            map.setGameOver();
            /** restart timer with new delay */
            timer.stop();
            timer = new Timer(500, this);
            timer.start();
        }
        /** if game is over */
        if (gameOver)
        {
            elapsedSec %= 2;
            paintImmediately(0,
            (17 << BomberMain.shiftCount) - images[5].getHeight(this) /
            (BomberMain.size != 16 ? 1 : 2),
            images[5].getWidth(this)  / (BomberMain.size != 16 ? 1 : 2),
            images[5].getHeight(this)  / (BomberMain.size != 16 ? 1 : 2));
        }
    }
}