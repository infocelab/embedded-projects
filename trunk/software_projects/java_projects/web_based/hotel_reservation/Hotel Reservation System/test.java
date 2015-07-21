
import java.util.Date;import java.util.GregorianCalendar;import java.util.Calendar;
public class test {

    public test() 
    {
    	Date d=new Date(2010,2,29);
    	
    	GregorianCalendar gr = new GregorianCalendar();
    	
    	int mon=(gr.get(Calendar.MONTH)+1);
	    int day=gr.get(Calendar.DATE);
	    int yer=gr.get(Calendar.YEAR);
	    
	    System.out.println(day+"  "+mon+"    " +yer);
	    
    	System.out.println(d.getDate());
    }
    
    public static void main(String args[])
    	{
    		new test();
    	}
}