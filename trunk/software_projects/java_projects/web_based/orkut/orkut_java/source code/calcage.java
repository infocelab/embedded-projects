// Demonstrate Calendar
import java.util.Calendar;


public class calcage {
 

 public calcage()
 {
 }
 
 public  int calc(String dob) {

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
        // //System.out.println("*******date is"+s);
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
String y=s.substring(k+1,k+5);
y=y.trim();

int yea=Integer.parseInt(y);
int cyea=calendar.get(Calendar.YEAR);

 age=cyea-yea;
if(cmonth<month)
  age--;
  else if(cmonth==month)
       if(cdat<dat)
       age--;






//System.out.println(dat+"/"+month+"/"+yea);
//System.out.println(cdat+"/"+cmonth+"/"+cyea);

//System.out.println("age is "+age);




return age;



}
}