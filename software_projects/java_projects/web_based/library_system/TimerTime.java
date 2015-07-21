//**************************************
//     
// Name: TimerTime
// Description:This code will show the t
//     ime on a JLabel. It is 'loosely' based o
//     n an example from the sun site. It will 
//     only work for Java 1.3 and above. The ti
//     mer class is now in java.util.*.
// By: EtStiles
//
// Inputs:JLabel. I included the option 
//     to change how often the time update (in 
//     seconds), but I'm having trouble with th
//     at portion.
//
// Assumes:In your own application just 
//     call 'new TimerTime(JLabel)'. I included
//     an example main.
//
// Side Effects:None.
//
//This code is copyrighted and has// limited warranties.Please see http://
//     www.Planet-Source-Code.com/xq/ASP/txtCod
//     eId.2388/lngWId.2/qx/vb/scripts/ShowCode
//     .htm//for details.//**************************************
//     

//Please give me some feedback. Thanks.
//Eric Stiles 8/30/01.
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
/**
* this class is a timer that will display the time on a JLabel. The user can specify
* the amount time between each display.
*/


    public class TimerTime {
    	Timer timer;
    	Calendar cal;
    	Date date;
    	DateFormat dateFormatter;
    	
    	/**
    	 * Constructor used for running example main.
    	 */


        	public TimerTime(boolean visible,JLabel label,int seconds){
        		timer = new Timer();
        		timer.scheduleAtFixedRate(new DoTime(visible,label),0, seconds*1000);
        	}
        	/**
        	 * Constructor used for creating class in another application.
        	 */
        	public TimerTime(int seconds) {this(new JLabel(),seconds);}
        	public TimerTime() {this(new JLabel(),1);}
        	public TimerTime(JLabel label) {this(label, 1);}


            	public TimerTime(JLabel label, int seconds) {
            		timer = new Timer();
            		timer.scheduleAtFixedRate(new DoTime(label),0, seconds*1000);
        }


            	class DoTime extends TimerTask {
            		JLabel label = new JLabel();
            		boolean visible = false;
            		public DoTime(){}


                		public DoTime(boolean visible, JLabel label){
                			this.label = label;
                			this.visible = visible;
                		}
                		public DoTime(JLabel label){this.label = label;}


                    		public void run() {
                    			cal = Calendar.getInstance();
                    			date = cal.getTime();
                    			dateFormatter = DateFormat.getTimeInstance();
                    			label.setText(dateFormatter.format(date));
                }
                		public void timerCancel(){timer.cancel();}
            }

                        public void timerCancel(){timer.cancel();}
            }
