/***************************************
* CWorldListener
* Author: Martin Adams
****************************************
* Defines the worlds callback
* procedures
****************************************/

import javax.vecmath.*;

public interface CWorldListener
{
  public void onEnterTable();
	public void onExitTable();
	public void onCollisionDetect(Vector3f newPosition);
}
