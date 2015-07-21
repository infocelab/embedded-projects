
import java.awt.*;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *  	Holds the parameters of this application. The difference between this class <br>
 *      and the CTSDefParameters is that the variables in this class can be changed according<br>
 *      to user preferences, while variables of CTSDefParameters are final. Furthermore, <br>
 *      if the user types values and then wants to restore the default ones, this can be <br>
 *      achieved by setting these variables to the default stored on CTSDefParameters.
 *	<p>
 *
 *  <b>Project Web Site:</b><i><br>
 *  <a href="http://www.geocities.com/cts">www.geocities.com/ctsproj</a><i>
 *
 *  @author <img src="my_img.jpg" width="56" height="70" alt="Author's photo" border="0">
 *   		<br>
 *          <a href="mailto: dimtsan@hotmail.com"><b>Jim Tsanakaliotis</b></a>
 *          <br>
 *          Author web site: <a href="http://www.geocities.com/dimtsan">http://www.geocities.com/dimtsan</a>
 *  @version <font color=red><b>1.0</font><i> &nbsp * 06 April 2001 *</b></i>
 *  @see CTSDefParameters
 */
public class CTSParameters {

	public static int DELAY;
	public static int NUM_OF_TRAINS;
	public static int DIRECTION;
	public static int MIN_INSERTION_TIME;
	public static int MAX_INSERTION_TIME;
	private int[] parValues;
	private String[] parNames;

	public CTSParameters() {
		parValues = new int[5];
		parNames = new String[5];
		NUM_OF_TRAINS=CTSDefParameters.DEF_NUM_OF_TRAINS;
		DELAY=CTSDefParameters.DEF_DELAY;
		DIRECTION=CTSDefParameters.DEF_DIRECTION;
		MIN_INSERTION_TIME=CTSDefParameters.MIN_INSERTION_TIME;
		MAX_INSERTION_TIME=CTSDefParameters.MAX_INSERTION_TIME;
		// setup the names
		parNames[0] = "NUM_OF_TRAINS";
		parNames[1] = "DELAY";
		parNames[2] = "DIRECTION";
		parNames[3] = "MIN_INSERTION_TIME";
		parNames[4] = "MAX_INSERTION_TIME";
		parValues[0]=NUM_OF_TRAINS;
		parValues[1]=DELAY;
		parValues[2]=DIRECTION;
		parValues[3]=MIN_INSERTION_TIME;
		parValues[4]=MAX_INSERTION_TIME;
	}

    /**
     *  Set the parameters.
     *
     *  @param par: an array containing the parameters.
     */
	public void setParameters(int[] par) {
		parValues=par;
		NUM_OF_TRAINS=parValues[0];
		DELAY=parValues[1];
		DIRECTION=parValues[2];
		MIN_INSERTION_TIME=parValues[3];
		MAX_INSERTION_TIME=parValues[4];
	}


    /**
     *  Returns the value of the specified parameter.
     *
     *  @param pos: the parameter position in the stored array.
     *  @return an integer presenting the value of the parameter.
     */
	public int getParValue(int pos) {
		return parValues[pos];
	}


    /**
     *  Returns the name of the specified parameter.
     *
     *  @param pos: the parameter position in the stored array.
     *  @return a String specifying the name of the parameter.
     */
	public String getParName(int pos) {
		return parNames[pos];
	}
}