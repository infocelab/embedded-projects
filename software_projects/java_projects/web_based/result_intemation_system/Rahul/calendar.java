// Calendar Generator.  Original program in C,            05/01/90
// v1.0   Converted to Java code.                         09/23/99
// v1.1   Added button to inc/dec years.                  09/27/99
// v1.2   Made Month and day names bold.                  09/29/99
// v1.3   Added 'about' and 'now, buttons.                10/02/99
// v1.4   Added Font and Background color buttons.        10/03/99
// v1.5   Added frames (lines) around Months.             10/08/99
// v2.0   Pop-up window for individual Months             10/10/99 - 10/12/99
// v2.01  Some mouse event changes. Update month in
//        window each time a month is clicked.            10/13/99
// v2.02  Adjusted lines on month window.                 10/14/99
// v2.03  Month windows no longer show empty weeks        10/20/99
// v2.1   Used date class to set year from clock          10/22/99
// v2.2   Made seperate applet for printing               05/14/00
// v2.21  Removed monthframe for now                      05/16/00
//

// Kerry Newman  -  newman@wt.net
// http://web.wt.net/~newman/

import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.awt.print.*;
import javax.swing.*;
class calendar extends JFrame
{
	Dimension screenSize;
	int width;
	int height;

	calendar()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		setSize(780,700);
		setLocation(width/5,height/20);
		setTitle("Calendar");
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		add(new cale());
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}

}
class cale extends Panel
{

  Button m100;            //year decrement buttons.
  Button m10;
  Button m1;
  Button p1;              //year increment buttons.
  Button p10;
  Button p100;
  Button about;           //URL on calendar history
  Button now;
  Button fontColor;
  Button backColor;
  Button print;
  TextField yearbox;      //box for year

  int day[] = new int[12];
  int year, day_week, iMonth;
  int lineinc = 16;
  int lindex;
  int FontIndex, BackIndex;
  String line = "";
  int LastWeek;  //used for month window.
  boolean MonthEnd = false;

  /////  Read Date from the computer to setup initial display /////
  Calendar ReadTime = Calendar.getInstance();
  int CurrentMonth = ReadTime.get(Calendar.MONTH);
  int CurrentYear = ReadTime.get(Calendar.YEAR);
  Date Now = ReadTime.getTime();

  cale()
  {
	  ScrollPane pn=new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
	backColor = new Button("BackColor");
    about = new Button("About");
    m100 = new Button("-100");
    m10  = new Button("-10");
    m1   = new Button("-1");
    yearbox = new TextField(4);  //box to put year in.
    p1   = new Button("+1");
    p10  = new Button("+10");
    p100 = new Button("+100");
    now = new Button("Now");
    fontColor = new Button("FontColor");
    print = new Button("Print");
	print.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			PrinterJob jb=PrinterJob.getPrinterJob();
			jb.printDialog();
		}
	});
    FlowLayout Buttons = new FlowLayout(FlowLayout.CENTER, 10, 7 );
    Panel p=new Panel();
    //setLayout(Buttons);

    p.add ( fontColor );
    p.add ( now );
    p.add ( m100 );               //Year buttons.
    p.add ( m10 );
    p.add ( m1 );
    p.add ( yearbox );
    p.add ( p1 );
    p.add ( p10 );
    p.add ( p100 );
    //p.add ( about );
    p.add ( backColor );
    p.add ( print );
    add(p,"North");

    yearbox.setText(String.valueOf(CurrentYear));   //initialize year to current
    FontIndex = 1;             //index counter for Font color
    BackIndex = 2;             //index counter for Back color
  }

  /////////////////////////////////////////////////////////////////
  ////////////////// Main program flow ////////////////////////////
  /////////////////////////////////////////////////////////////////
  public void paint( Graphics g )
  {
    Font font1 = new Font( "Courier", Font.PLAIN, 16 ); //Fixed width font needed
    Font font2 = new Font( "Courier", Font.BOLD,  16 );

    switch ( BackIndex )     //Background Color settings
    {
      case 0:   setBackground( Color.black );      break;
      case 1:   setBackground( Color.blue );       break;
      case 2:   setBackground( Color.cyan );       break;
      case 3:   setBackground( Color.darkGray );   break;
      case 4:   setBackground( Color.gray );       break;
      case 5:   setBackground( Color.lightGray );  break;
      case 6:   setBackground( Color.green );      break;
      case 7:   setBackground( Color.magenta );    break;
      case 8:   setBackground( Color.orange );     break;
      case 9:   setBackground( Color.pink );       break;
      case 10:  setBackground( Color.red );        break;
      case 11:  setBackground( Color.white );      break;
      case 12:  setBackground( Color.yellow );     break;
    }

    switch ( FontIndex )     //Font Color settings
    {
      case 0:   g.setColor( Color.black );     break;
      case 1:   g.setColor( Color.blue );      break;
      case 2:   g.setColor( Color.cyan );      break;
      case 3:   g.setColor( Color.darkGray );  break;
      case 4:   g.setColor( Color.gray );      break;
      case 5:   g.setColor( Color.lightGray ); break;
      case 6:   g.setColor( Color.green );     break;
      case 7:   g.setColor( Color.magenta );   break;
      case 8:   g.setColor( Color.orange );    break;
      case 9:   g.setColor( Color.pink );      break;
      case 10:  g.setColor( Color.red );       break;
      case 11:  g.setColor( Color.white );     break;
      case 12:  g.setColor( Color.yellow );    break;
    }

    //////////////////////////////////////////////
    ////////// Draw Frame around Months //////////
    //////////////////////////////////////////////

    g.drawRect( 0, 0, 779, 679 );       // main box

    g.drawLine( 260, 40, 260, 680 );    // Center verticle lines
    g.drawLine( 520, 40, 520, 680 );

    g.drawLine( 0, 40, 780, 40 );       // Lines around buttons
    g.drawLine( 0, 72, 780, 72 );

    g.drawLine( 0, 200, 780, 200 );     // Horizontal lines around Months
    g.drawLine( 0, 232, 780, 232 );
    g.drawLine( 0, 360, 780, 360 );
    g.drawLine( 0, 392, 780, 392 );
    g.drawLine( 0, 520, 780, 520 );
    g.drawLine( 0, 552, 780, 552 );

    g.setFont( font2 );
    String Year = yearbox.getText();
    year = Integer.parseInt( Year );

    if ( year < 1 )
    {
      g.drawString( "                 Please enter a year of 1 AD or later!!", 10, 100 );
      return;
    }

    lindex = 60;                           // initialize writing area each repaint
    LastWeek = 0;  //used for month window.
    MonthEnd = false;

    for ( int i = 0; i <= 11; i++ )
      day[i] = 1;                          //initialize day of Month to 1
    for ( int row= 0 ; row <= 3 ; ++row )  // 4 rows of Months 0-1-2  3-4-5  6-7-8  9-10-11
    {
      g.setFont( font2 );
      if ( row != 0 )
        lindex += lineinc;

      switch (row)    // Draw Month names
      {
        case 0:  g.drawString( "  ***** JANUARY ******      ***** FEBRUARY *****      ******* MARCH ******", 10, lindex ); break;
        case 1:  g.drawString( "  ****** APRIL *******      ******* MAY ********      ******* JUNE *******", 10, lindex ); break;
        case 2:  g.drawString( "  ******* JULY *******      ****** AUGUST ******      ***** SEPTEMBER ****", 10, lindex ); break;
        case 3:  g.drawString( "  ***** OCTOBER ******      ***** NOVEMBER *****      ***** DECEMBER *****", 10, lindex );
      }

      lindex += 2*lineinc;               //increment line space by 2.  One blank line.
      g.drawString( "  Su Mo Tu We Th Fr Sa      Su Mo Tu We Th Fr Sa      Su Mo Tu We Th Fr Sa", 10, lindex );
      lindex += lineinc;

      for ( int week = 0 ; week <= 5 ; ++week )  //week loops.  one line includes one week for 3 Months.
      {
        g.setFont( font1 );
        line = " ";
        for ( int col = 0 ; col <= 2 ; ++col )   //3 Months in a row
        {
          if (week == 0)         //1st week needs to know what day to start.
            firstweek( row*3 + col, year );
          else
            otherweek( row*3 + col );
        }                        /* Column end  */

        g.drawString(line, 10, lindex);      //done with line, print it out.
        lindex += lineinc;
        line = " ";

      }     // Week end
    }       // Row end
  }         // Paint end


  /////////////////////////////////////////////////////////////////
  /////////////////// first week of the Month /////////////////////
  /////////////////////////////////////////////////////////////////

  public void firstweek( int Month, int year )
  {
    int day_week = firstday ( Month, year );           //get starting day of week.
    for ( int i = 0 ; i < day_week ; i++ )             //print blanks until 1st.
      line = line.concat("   ");

    do
    {
      line = line.concat( "  " + String.valueOf( day[Month] ) );  //print day of Month with leading blanks.
      ++day[Month];
      ++day_week;
    }
    while (day_week <= 6 );

    if ( ((Month + 1) % 3) != 0 )  //if last day of week, print spaces between Month.
      line = line.concat("     ");
  }

  /////////////////////////////////////////////////////
  /////////////////// weeks 2 - 6 /////////////////////
  /////////////////////////////////////////////////////

  public void otherweek( int Month )
  {
    day_week = 0;               //initialize day of week to 0.  Sunday
    int daysinMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    if (((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0)))
      daysinMonth[1] = 29;
    else
      daysinMonth[1] = 28;   //need to set it back because it only gets set to 28 in initialization

    do
    {
      if ( day[Month] == daysinMonth[ Month ] )
        MonthEnd = true;

      if ( day[Month] <= daysinMonth[ Month ] )  //check to see if days still left.
      {
        if ( day[Month] < 10 )  //if 1-9, 2 leading spaces needed.
          line = line.concat( "  " + String.valueOf( day[Month] ) );
        else                    //if 10-31, 1 leading space needed.
          line = line.concat( " " + String.valueOf( day[Month] ) );
        ++day[Month];
        ++day_week;
      }
      else
      {
        line = line.concat("   ");  //if after last day of Month, print blanks.
        ++day_week;
      }

    }
    while ( day_week <= 6 );

    if ( ((Month + 1) % 3) != 0 )  //if last day of week, print spaces between Month.
      line = line.concat("     ");
  }   //end of otherweek

  /////////////////////////////////////////////////////
  ///////////////// first day of Month ////////////////
  /////////////////////////////////////////////////////

    public int firstday( int Month, int year )
    {
      int yeardiff, days_since, dayofyear[]={ 0,31,59,90,120,151,181,212,243,273,304,334 };
      yeardiff = year - 1;
      days_since = yeardiff * 365;
      days_since += ( ( yeardiff/4 ) - ( yeardiff/100 ) + ((yeardiff)/400) ) + dayofyear[ Month ];
      if (((((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0)))) && ( Month > 1 ))
        days_since++;
      return ( ( days_since + 1 ) % 7 );
    }

  /////////////////////////////////////////////////////
  ////////// Button and Mouse Activity  ///////////////
  /////////////////////////////////////////////////////


  public boolean action(Event event, Object arg )
  {
    if (event.target instanceof Button )
      HandleButtons(arg);

    repaint();
    return true;
  }

  /////////////////////////////////////////////////////
  /////////////////// Button Handler //////////////////
  /////////////////////////////////////////////////////

  protected void HandleButtons(Object label)
  {
    String NewYear;
    if ( label == "-100" )
      year -= 100;
    else if ( label == "-10" )
      year -= 10;
    else if ( label == "-1" )
      year -= 1;
    else if ( label == "+1" )
      year += 1;
    else if ( label == "+10" )
      year += 10;
    else if ( label == "+100" )
      year += 100;
    else if ( label == "Now" )
    {
      CurrentYear = ReadTime.get(Calendar.YEAR);
      yearbox.setText(String.valueOf(CurrentYear));   //initialize year to current
      return;
    }

    NewYear = String.valueOf( year );
    yearbox.setText( NewYear );


/////////////////////////////////////////////////////
///////////// URL Link - Calendar History ///////////
/////////////////////////////////////////////////////

  /*  if ( label == "About" )
    {
      try
      {
        URL newman_networkcal = new URL( "http://web.wt.net/~newman/calendar/about_calendar.html" );
        AppletContext context = getAppletContext();
        context.showDocument( newman_networkcal );
      }

      catch ( MalformedURLException e )
      {
        //Nothing at this time.  A good URL.
      }
    }*/

  /////////////////////////////////////////////////////
  /////////// URL Link - Printable Calander ///////////
  /////////////////////////////////////////////////////

   /* if ( label == "Print" )
    {
      try
      {
        URL newman_networkcalp = new URL( "http://web.wt.net/~newman/calendar/printcal.html" );
        AppletContext context = getAppletContext();
        context.showDocument( newman_networkcalp );
      }

      catch ( MalformedURLException e )
      {
        //Nothing at this time.  A good URL.
      }
    }*/

  /////////////////////////////////////////////////////
  ////////////// Font and Background Color ////////////
  /////////////////////////////////////////////////////

    if ( label == "FontColor" )
    {
      FontIndex++;
      if ( FontIndex == 13 )
        FontIndex = 0;
    }

    if ( label == "BackColor" )
    {
      BackIndex++;
      if ( BackIndex == 13 )
        BackIndex = 0;
    }
  }  //handle buttons
}    // calendar class end