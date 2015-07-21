public class Dates
{
    int m,d,y;
        
    public Dates(int month, int day, int year) 
    {
        m=month;
        d=day;
        y=year;
    }

    // get properties
    public int getMonth()
    { return m; }

    public int getDay()
    { return d; }

    public int getYear()
    { return y; }

    // set properties
    public void setMonth(int month)
    { m=month;  }

    public void setDay(int day)
    { d=day;    }

    public void setYear(int year)
    { y=year;   }

    // returns a string in format M/D/YYYY
    public String toString()
    {
        String s = m + "/" + d + "/" + y;
        return s;
    }

    // returns the number of days from 1/1/1900
    public long toLong() 
    {
        // first find number of days from 1/1
        long days=0;
            
        switch(m)
            {
            case 12: days+=30;
            case 11: days+=31;
            case 10: days+=30;
            case 9:  days+=31;
            case 8:  days+=31;
            case 7:  days+=30;
            case 6:  days+=31;
            case 5:  days+=30;
            case 4:  days+=31;
            case 3:  days+= isLeapYear(y) ? 29 : 28;
            case 2:  days+=31;
            case 1:  days+=d-1; //days from the first
            }

        // now find days in years since 1900
        if(y!=1900) {
            int inc=(1900-y)/Math.abs(1900-y);
            for(int i=y; i!=1900; i+=inc)
                days += (isLeapYear(i) ? 366 : 365);
        }
            
        return days;
    }

    // determines whether a year is a leap year
    private boolean isLeapYear(int y)
    {
        if((y%100)==0) return (y%400)==0;
        else return (y%4)==0;
    }

    // return difference between two Datess
    public long getDifference(Dates date) 
    { return Math.abs(toLong()-date.toLong()); }
        
}