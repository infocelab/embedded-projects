/*
	Trivial applet that displays a string
*/

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.util.*;
import java.applet.AudioClip;

//import java.awt.

public class Asteroids extends Applet implements KeyListener, MouseListener, MouseMotionListener
{
	int X;
	int Y;
	int h ;
	int w;
	boolean beginning = true;
	MediaTracker tracker;
	Image background;
	Image back1;
	Image back2;
	Image back3;
	Image back4;
	Image asteroidB;
	Image asteroidM;
	Image asteroidS;
	Image gun;
	AudioClip laser;
	AudioClip bombS;
	AudioClip astex;
	AudioClip music;
	AudioClip shipex;
	AudioClip lose;
	Vector bullets;
	Vector asteroids;
	Image OSC;
	Graphics OSG;
	int turretX;
	int turretY;
	int counter = 40;
	int bomb = 150;
	int lives = 3;
	int maxAst = 4;
	int stage = 1;
	int maxBullets = 10;
	int bombs = 3;
	boolean dead = false;

	public void init() {

		w = getWidth();
		h = getHeight();
		OSC = createImage(w,h);
		OSG = OSC.getGraphics();
		bullets = new Vector();
		asteroids = new Vector();
		tracker = new MediaTracker(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		lose = getAudioClip(getCodeBase(), "gameover.mid");
		laser = getAudioClip(getCodeBase(), "laser.wav");
		bombS = getAudioClip(getCodeBase(), "bomb.wav");
		astex = getAudioClip(getCodeBase(), "asteroid.wav");
		shipex = getAudioClip(getCodeBase(), "shipexplode.wav");
		music = getAudioClip(getCodeBase(), "music.mid");
		background = getImage(getCodeBase(), "stars.jpg");
		asteroidB = getImage(getCodeBase(), "asteroid_big.gif");
		asteroidM = getImage(getCodeBase(), "asteroid_med.gif");
		asteroidS = getImage(getCodeBase(), "asteroid_small.gif");
		gun = getImage(getCodeBase(), "gun.gif");
		music.loop();

		repaint();
	}

	public void update(Graphics g)
	{

		OSG.drawImage(background,0,0,null);
		OSG.setColor(Color.white);

		paint(OSG);
		g.drawImage(OSC,0,0,null);
	}

	public void paint(Graphics g) {
		if(beginning){
			g.setFont(new Font("Westminster",1,48));
			g.drawString("ASTEROIDS Written by D. Zimardi", w/2-100, h/2-40);
			g.drawString("Click to Begin",w/2-100, h/2);


		}else if((lives > 0 || counter < 40)  && asteroids.size()!=0){

			g.setColor(Color.red);
			if(!dead ){
				g.drawImage(gun, w/2-20, h/2-20, null);
				g.drawLine(w/2,h/2,w/2+turretX,h/2+turretY);
				g.drawLine(w/2+1,h/2+1,w/2+turretX+1,h/2+turretY+1);

				g.drawLine(w/2,h/2+1,w/2+turretX,h/2+turretY+1);
				g.drawLine(w/2,h/2-1,w/2+turretX,h/2+turretY-1);

				g.drawLine(w/2+1,h/2,w/2+turretX+1,h/2+turretY);
				g.drawLine(w/2-1,h/2,w/2+turretX-1,h/2+turretY);

				g.drawLine(w/2+1,h/2-1,w/2+turretX+1,h/2+turretY-1);
				g.drawLine(w/2-1,h/2+1,w/2+turretX-1,h/2+turretY+1);
			}
			g.setColor(Color.yellow);
			Bullet tempB;
			for(int i = 0; i < bullets.size(); i ++){
				tempB = (Bullet)(bullets.elementAt(i));
				tempB.updatePosition(w,h);

				g.fillOval((int)tempB.posX,(int)tempB.posY,3,3);

				if(tempB.life < 0)
					bullets.removeElementAt(i);

			}
			Asteroid tAsteroid;
			for(int i = 0; i < asteroids.size(); i++){
				tAsteroid = (Asteroid)(asteroids.elementAt(i));
				tAsteroid.updatePosition(w,h);
				if(tAsteroid.radius == 30)
					g.drawImage(asteroidB,(int)tAsteroid.posX,(int)tAsteroid.posY,this);
				else if(tAsteroid.radius ==  20)
					g.drawImage(asteroidM,(int)tAsteroid.posX,(int)tAsteroid.posY,this);
				else
					g.drawImage(asteroidS,(int)tAsteroid.posX,(int)tAsteroid.posY,this);

			}

			Bullet tBullet;


			for(int i = 0; i < bullets.size(); i++)
			{
				tBullet = (Bullet)(bullets.elementAt(i));
				for(int j = 0; j < asteroids.size(); j++)
				{
					tAsteroid = (Asteroid)(asteroids.elementAt(j));
					if(tAsteroid.CheckCollision(tBullet))
					{
						if(tAsteroid.radius!=10)
						{
							asteroids.addElement(new Asteroid(tAsteroid.posX+(double)tAsteroid.radius, tAsteroid.posY+(double)tAsteroid.radius, tAsteroid.decRad()));
							asteroids.addElement(new Asteroid(tAsteroid.posX+(double)tAsteroid.radius, tAsteroid.posY+(double)tAsteroid.radius, tAsteroid.decRad()));
						}


							asteroids.removeElementAt(j);
							astex.play();
							bullets.removeElementAt(i);
							j = asteroids.size();//makes loop end
					}
				}

			}

			if( !dead && baseCollision()){
				counter = 0;
				dead = true;
				lives--;
				shipex.play();

			}

			if(bomb<150){
				g.setColor( new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255),50));
				g.fillOval(w/2-bomb,h/2-bomb,2*bomb,2*bomb);
				bombCollision(bomb);
				bomb+=5;
			}
			if(counter < 40){
				g.setColor( new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				g.fillOval(w/2-counter,h/2-counter,counter*2,counter*2);
				counter++;
			}
			g.setFont( new Font("Times",1,12));
			g.setColor(Color.white);
			g.drawString("Stage= "+String.valueOf(stage),10,20);
			g.drawString("Lives= "+String.valueOf(lives),10,40);
			g.drawString("Bombs= "+String.valueOf(bombs),10,60);
			try{Thread.sleep(50);}catch(Exception e){}
			repaint();
		} else if(asteroids.size() == 0){background=getImage(getCodeBase(),"back_"+stage%5);
			g.setFont(new Font("Westminster",1,48));
			g.drawString("Stage "+stage+" Complete!!",w/2-150, h/2);
			g.setFont(new Font("Westminster",1,24));
			g.drawString("hit enter to continue",w/2-100, h/2+50);
			bombs = 3;
		}else{
			music.stop();
			lose.play();
			g.setFont(new Font("Westminster",1,48));
			g.drawString("GAME OVER",w/2-100, h/2);
			g.setFont(new Font("Westminster",1,24));
			g.drawString("hit enter to restart",w/2-100, h/2+50);
		}
	}




	public void keyPressed(KeyEvent evt){
		int code = evt.getKeyCode();
		System.out.println(code);
		if (code == 32 && counter == 40 && lives>0)
			dead = false;
		if(code == 10 && lives == 0){
			dead = false;
			asteroids = new Vector();
			lives = 3;
			stage = 1;
			lose.stop();
			music.loop();
			background = getImage(getCodeBase(), "stars.jpg");
			for(int i = 0; i < 5; i++)
				asteroids.addElement(new Asteroid(w,h));
		}


		if(code == 10 && asteroids.size() == 0){
			background=getImage(getCodeBase(),"back_"+(stage%5)+".jpg");
			stage++;
			maxBullets+=5;
			lives++;
			for(int i = 0; i < stage*5; i++)
				asteroids.addElement(new Asteroid(w,h));
		}

		if(code==76){
			lives++;
		}
		if(code==75){
			asteroids.removeElementAt(0);
		}
		if(code == 66 && bombs>0&& !dead){
			bombs--;
			bomb = 30;
			bombS.play();
		}
		repaint();

	}
	synchronized public boolean baseCollision(){
		Asteroid tAsteroid;
		double d;
		double r;
		double cy;
		double cx;
		for(int i = 0; i < asteroids.size(); i++)
		{
			tAsteroid = (Asteroid)(asteroids.elementAt(i));
			r = (double)tAsteroid.getRadius();
			cy = tAsteroid.posY+r;
			cx = tAsteroid.posX+r;
			d = Math.sqrt((w/2-cx)*(w/2-cx)+(h/2-cy)*(h/2-cy));

			if(d<(20+tAsteroid.radius)){
				asteroids.removeElementAt(i);
				return true;
			}

		}
		return false;
	}

	synchronized public boolean bombCollision(int bombR){
		Asteroid tAsteroid;
		double d;
		double r;
		double cy;
		double cx;
		for(int i = 0; i < asteroids.size(); i++)
		{
			tAsteroid = (Asteroid)(asteroids.elementAt(i));
			r = (double)tAsteroid.getRadius();
			cy = tAsteroid.posY+r;
			cx = tAsteroid.posX+r;
			d = Math.sqrt((w/2-cx)*(w/2-cx)+(h/2-cy)*(h/2-cy));

			if(d<bombR+r){
				asteroids.removeElementAt(i);
				bombS.play();
				return true;
			}

		}
		return false;
	}
	public void keyReleased(KeyEvent evt){}
	public void keyTyped(KeyEvent evt){}

	public void mousePressed(MouseEvent evt){
		int x = evt.getX();
		int y = evt.getY();
		if(beginning){
			beginning = false;
			for(int i = 0; i < 5; i++)
				asteroids.addElement(new Asteroid(w,h));
		}

		if(bullets.size() < maxBullets && !dead){
			bullets.addElement(new Bullet(w/2+turretX,h/2+turretY,x,y));
			laser.play();
			}

		repaint();
	}
	public void mouseReleased(MouseEvent evt){}
	public void mouseClicked(MouseEvent evt){}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}
	public void mouseDragged(MouseEvent evt){}
	public void mouseMoved(MouseEvent evt)
		{
			int x = evt.getX();
			int y = evt.getY();
			X = x;
			Y = y;
			double d= Math.sqrt((w/2-x)*(w/2-x)+(h/2-y)*(h/2-y));
			turretX = (int)((((double)x-(double)w/2)*30)/d);
			turretY = (int)((((double)y-(double)h/2)*30)/d);
	}









}
