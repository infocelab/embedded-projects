import java.awt.*;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *      Sets the default parameters for this simulation.
 *	<p>
 *  <b>Project Web Site:</b><i>
 *  <br>
 *  <a href="http://www.geocities.com/cts">www.geocities.com/ctsproj</a><i>
 *
 *  @author <img src="my_img.jpg" width="56" height="70" alt="Author's photo" border="0">
 *   		<br>
 *          <a href="mailto: dimtsan@hotmail.com"><b>Jim Tsanakaliotis</b></a>
 *          <br>
 *          Author web site: <a href="http://www.geocities.com/dimtsan">http://www.geocities.com/dimtsan</a>
 *
 *  @version <font color=red><b>1.0</font><i> &nbsp * 06 April 2001 *</b></i>
 *  @see CTSParameters
 */
public abstract class CTSDefParameters {

	/* ========================  BASIC SIM PARAMETERS ============================== */
	public static final int MIN_INSERTION_TIME=3;
	public static final int MAX_INSERTION_TIME=6;
	public static final int STOP_ATSTATION_TIME=3;
	public static final int MAX_NUMOF_TRAINS=25;
	public static final int MIN_DELAY=0;
	public static final int MAX_DELAY=400;   // the maximun value of cycle interval.

	/* ========================  TIMING AND OTHER FLAG PARAMETERS ============================== */
	public static final int DEF_DELAY=30;
	public static final int DELAY_FLAG=60; // counted in cycles.
	public static final int MAX_WAIT_TIME=160; // counted in cycles.

	/* ========================  TRAIN PARAMETERS ============================== */
	public static final int DEF_NUM_OF_TRAINS=25;
	public static final int DEF_DIRECTION=0;

	/* ========================  COLOR PARAMETERS ============================== */
	public static final Color BACK_COLOR = new Color(106,65,19);
	public static final Color MAP_BACK_COLOR = new Color(139,105,20);
}