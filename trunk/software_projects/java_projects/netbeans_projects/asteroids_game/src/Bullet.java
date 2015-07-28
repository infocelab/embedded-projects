public class Bullet
	{
		double dirX;
		double dirY;
		double posX;
		double posY;
		final int speed = 10;
		int life = 40;
		public Bullet (int cx, int cy, int x, int y)
		{
			dirX = ((x-cx)*speed)/(Math.sqrt((cx-x)*(cx-x)+(cy-y)*(cy-y)));
			dirY = ((y-cy)*speed)/(Math.sqrt((cx-x)*(cx-x)+(cy-y)*(cy-y)));
			posX = cx;
			posY = cy;
		}
		
		public void updatePosition(int w, int h){
			life--;
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
			
	}