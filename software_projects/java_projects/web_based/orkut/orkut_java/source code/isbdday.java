// Demonstrate Calendar
import java.util.Calendar;


public class isbdday {
 

 public isbdday()
 {
 }
 
 public  boolean calc(String dob) {

 String months[] = {
"Jan", "Feb", "Mar", "Apr",
"May", "Jun", "Jul", "Aug",
"Sep", "Oct", "Nov", "Dec"};
// Create a calendar initialized with the
// current date and time in the default
// locale and timezone.

String s=dob;
 
 int age;
 String m=s.substring(0,3);
 
 String d="";
          char cha;
         int k;
         //System.out.println("*******date is"+s);
         for( k=4;(cha=s.charAt(k))!='/';k++)
           d=d + cha ;
         int dat=Integer.parseInt(d);
         
         
         
         

Calendar calendar = Calendar.getInstance();
// Display current time and date information.
//System.out.print("Date: ");
int i;
for ( i=0;i<12;i++)
if(m.equals(months[i])) break;

int month=i+1;
int cmonth=calendar.get(Calendar.MONTH)+1;
int cdat=calendar.get(Calendar.DATE);
  
  
  //System.out.println("month="+month+"   cmon="+cmonth+"dat=   "+dat+"   cdat="+cdat); 
 
 boolean isb;
 if(month==cmonth  && dat==cdat)
    isb=true;
    
   else isb=false;
   
   
    //System.out.println("isb = "+isb);
     
     return isb;


}
}