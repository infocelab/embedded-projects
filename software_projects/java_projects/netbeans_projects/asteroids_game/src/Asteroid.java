public class Asteroid
{
	double dirX;
	double dirY;
	double posX;
	double posY;
	int radius;
	
	public Asteroid(int w, int h)
	{
		
	
		radius = 30;
			
		
		double rand = Math.random();
		if(rand < .25) {
			posX = 0;
			posY = (int)(Math.random()*h);
		} else if(rand>.25 && rand < .5){
			posX = (int)(Math.random()*w);
			posY = 0;
		} else if(rand>.5 && rand < .75){
			posX = w;
			posY = (int)(Math.random()*h);
		} else {
			posX = (int)(Math.random()*w);
			posY = h;
		}
		
		dirX = Math.random()*30/radius;
		dirY = Math.random()*30/radius;
		
		
		if(Math.random() < .5)
			dirX = dirX*-1;
		if(Math.random() < .5)
			dirY = dirY*-1;
			
		}
		public Asteroid(double x, double y, int r){
			posX = x;
			posY = y;
			radius = r;
			
			dirX = Math.random()*30/radius*30/radius;
			dirY = Math.random()*30/radius*30/radius;
			if(Math.random() < .5)
			dirX = dirX*-1;
			if(Math.random() < .5)
			dirY = dirY*-1;
		
		
		}	
		public boolean CheckCollision(Bullet tB)
		{
			int cx = (int)posX + radius;
			int cy = (int)posY + radius;
			double d = Math.sqrt((cx-tB.posX)*(cx-tB.posX)+(cy-tB.posY)*(cy-tB.posY));
			
			if (d < radius)
				return true;
			return false;
		}
		public int getRadius(){
		
			return radius;
		}
		
		public void updatePosition(int w, int h){
			if(posX<=w && posX>=0)
				posX = posX+dirX;
			else if(posX>w)
				posX = 0;
			else if (posX<0)
				posX = w;
				
				
			if(posY<=h && posY>=0)
				posY = posY+dirY;
			else if(posY>h)
				posY = 0;
			else if(posY<0)
				posY = h;
		}
			
			
		public int decRad()
		{
		
			return radius -10;
		}
			
		
				
			
			
	}
	
	
	