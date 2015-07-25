import java.awt.*;
import javax.swing.*;
import java.io.*;

/**
 * File:         BomberBomb
 * Copyright:    Copyright (c) 2001
 * @author Sammy Leong
 * @version 1.0
 */

/**
 * This class creates the bombs in the game.
 */
public class BomberBomb extends Thread {
    /** map object */
    private BomberMap map = null;
    /** position */
    private int x = 0;
    private int y = 0;
    /** frame count */
    private int frame = 0;
    /** alive flag */
    private boolean alive = true;
    /** owner */
    private int owner = 0;
    /** count down : 3000 ms */
    private int countDown = 3900;
    /** bomb sprite image handles */
    private static Image[] images = null;
    /** rendering hints */
    private static Object hints = null;

    static {
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
    }

    /**
     * Constructs a BOMB!
     * @param map game map
     * @param x x-coordinate
     * @param y y-coordinate
     * @param owner owner
     * @param images bomb images
     */
    public BomberBomb(BomberMap map, int x, int y, int owner) {
        this.map = map;
        this.x = x;
        this.y = y;
        this.owner = owner - 1;
        this.images = BomberMap.bombImages;

        map.grid[x >> BomberMain.shiftCount][y >> BomberMain.shiftCount] =
        BomberMap.BOMB;
        setPriority(Thread.MAX_PRIORITY);
        start();
    }

    /**
     * Main loop.
     */
    public synchronized void run() {
        while (alive) {
            /** draw the bomb */
            //paint();
            map.paintImmediately(x, y, BomberMain.size, BomberMain.size);
            /** rotate frame */
            frame = (frame + 1) % 2;
            /** sleep for 130 ms */
            try { sleep(130); } catch (Exception e) {}
            if (!alive) break;
            /** decrease count down */
            countDown -= 130;
            /** if count down reached 0 then exit */
            /** the loop and short the bomb */
            if (countDown <= 0) break;
        }
        /** remove it from the grid */
        map.grid[x >> BomberMain.shiftCount][y >> BomberMain.shiftCount] =
        BomberMap.NOTHING;
        /** give the bomb back to the player */
        BomberGame.players[owner].usedBombs -= 1;
        map.bombGrid[x >> BomberMain.shiftCount][y >> BomberMain.shiftCount] =
        null;
        BomberGame.players[owner].bombGrid
        [x >> BomberMain.shiftCount][y >> BomberMain.shiftCount] = false;
        map.removeBomb(x, y);
        BomberMain.sndEffectPlayer.playSound("Explosion");
        /** create the fire */
        map.createFire(x, y, owner, BomberMap.FIRE_CENTER);
    }

    /**
     * Explodes the bomb
     */
    public void shortBomb() {
        alive = false;
        interrupt();
    }

    /**
     * Drawing method.
     */
    public void paint(Graphics g) {
        /** if java runtime is Java 2 */
        if (Main.J2) { paint2D(g); }
        /** if java runtime isn't Java 2 */
        else {
             g.drawImage(images[frame], x, y,
             BomberMain.size, BomberMain.size, null);
        }
    }

    /**
     * Drawing method for Java 2's Graphics2D
     * @param graphics graphics handle
     */
    public void paint2D(Graphics graphics) {
        Graphics2D g2 = (Graphics2D)graphics;
        /** set the rendering hints */
        g2.setRenderingHints((RenderingHints)hints);
        g2.drawImage(images[frame], x, y,
        BomberMain.size, BomberMain.size, null);
    }
}