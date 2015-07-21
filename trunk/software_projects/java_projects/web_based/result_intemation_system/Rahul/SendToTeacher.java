import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.sql.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.table.*;
class SendToTeacher
{
	Connection conn;
	Statement st;
	Statement st2;
	SendToTeacher()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Teacher_Info","raj","17java71");
			st=conn.createStatement();
			st2=conn.createStatement();
		}
		catch(Exception e)
		{
		}
	}
	public void sendMessage()
	{
		String message="Lecture\n";
		String mobno="";
		System.out.println("Message Started");
		try
		{
			Calendar c=Calendar.getInstance();
			int day=c.get(Calendar.DAY_OF_WEEK);
			if(day==Calendar.MONDAY)
			{
				ResultSet set=st.executeQuery("select * from FacultyInfo ");
				while(set.next())
				{
					String faculty=set.getString(1);
					ResultSet reset=st2.executeQuery("select StartTime,EndTime,Monday,MCourse from "+faculty+"_time_table ");
					while(reset.next())
					{
						Time t=reset.getTime(1);
						Time en=reset.getTime(2);
						String ti=t.toString();
						String end=en.toString();
						if(!ti.equals("00:00:00"))
						{
							String sthr=ti.substring(0,2);
							String stmi=ti.substring(3,5);
							String endhr=end.substring(0,2);
							String endmt=end.substring(3,5);
							int starthr=Integer.parseInt(sthr);
							int duphr=starthr;
							int startmt=Integer.parseInt(stmi);
							int dupmt=startmt;
							int hour=c.get(Calendar.HOUR);
							int minute=c.get(Calendar.MINUTE);
							if(starthr>=12)
							{
								starthr=starthr-12;
							}
							int stmt=startmt-15;
							if(stmt<0)
							{
								if(starthr==0)
									starthr=11;
								else
									starthr--;

								startmt=60-(-stmt);
							}
							else
							{
								startmt=startmt-15;
							}
							System.out.println(starthr+" == "+hour +" && "+startmt+" == "+minute);
							if(starthr==hour && startmt==minute)
							{
								String sub=reset.getString(3);
								String cour=reset.getString(4);
								message=message+"Time : "+duphr+":"+dupmt+" To "+endhr+":"+endmt+"\n";
								message=message+"Subject : "+sub+"\n"+"Course : "+cour+"\n"+"Please Attend Lecture";
								mobno=set.getString(8).trim();
								//SMSClient send=SMSClient(1);
								//send.sendMessage(mobno,message);
								System.out.println(mobno);
								System.out.println(message);
								try
								{
									Thread.sleep(5000);
								}
								catch(Exception exe)
								{
								}
							}
						}


					}

				}
			}
			if(day==Calendar.TUESDAY)
			{
				ResultSet set=st.executeQuery("select * from FacultyInfo ");
				while(set.next())
				{
					String faculty=set.getString(1);
					ResultSet reset=st2.executeQuery("select StartTime,EndTime,Tuesday,TuCourse from "+faculty+"_time_table ");
					while(reset.next())
					{
						Time t=reset.getTime(1);
						Time en=reset.getTime(2);
						String ti=t.toString();
						String end=en.toString();
						if(!ti.equals("00:00:00"))
						{
							String sthr=ti.substring(0,2);
							String stmi=ti.substring(3,5);
							String endhr=end.substring(0,2);
							String endmt=end.substring(3,5);
							int starthr=Integer.parseInt(sthr);
							int duphr=starthr;
							int startmt=Integer.parseInt(stmi);
							int dupmt=startmt;
							int hour=c.get(Calendar.HOUR);
							int minute=c.get(Calendar.MINUTE);
							if(starthr>=12)
							{
								starthr=starthr-12;
							}
							int stmt=startmt-15;
							if(stmt<0)
							{
								if(starthr==0)
									starthr=11;
								else
									starthr--;

								startmt=60-(-stmt);
							}
							else
							{
								startmt=startmt-15;
							}
							System.out.println(starthr+" == "+hour +" && "+startmt+" == "+minute);
							if(starthr==hour && startmt==minute)
							{
								String sub=reset.getString(3);
								String cour=reset.getString(4);
								message=message+"Time : "+duphr+":"+dupmt+" To "+endhr+":"+endmt+"\n";
								message=message+"Subject : "+sub+"\n"+"Course : "+cour+"\n"+"Please Attend Lecture";
								mobno=set.getString(8).trim();
								//SMSClient send=SMSClient(1);
								//send.sendMessage(mobno,message);
								System.out.println(mobno+"\n"+message);
								try
								{
									Thread.sleep(5000);
								}
								catch(Exception exe)
								{
								}
							}
						}


					}

				}
			}
			if(day==Calendar.WEDNESDAY)
			{
				ResultSet set=st.executeQuery("select * from FacultyInfo ");
				while(set.next())
				{
					String faculty=set.getString(1);
					ResultSet reset=st2.executeQuery("select StartTime,EndTime,Wednesday,WCourse from "+faculty+"_time_table ");
					while(reset.next())
					{
						Time t=reset.getTime(1);
						Time en=reset.getTime(2);
						String ti=t.toString();
						String end=en.toString();
						if(!ti.equals("00:00:00"))
						{
							String sthr=ti.substring(0,2);
							String stmi=ti.substring(3,5);
							String endhr=end.substring(0,2);
							String endmt=end.substring(3,5);
							int starthr=Integer.parseInt(sthr);
							int duphr=starthr;
							int startmt=Integer.parseInt(stmi);
							int dupmt=startmt;
							int hour=c.get(Calendar.HOUR);
							int minute=c.get(Calendar.MINUTE);
							if(starthr>=12)
							{
								starthr=starthr-12;
							}
							int stmt=startmt-15;
							if(stmt<0)
							{
								if(starthr==0)
									starthr=11;
								else
									starthr--;

								startmt=60-(-stmt);
							}
							else
							{
								startmt=startmt-15;
							}
							System.out.println(starthr+" == "+hour +" && "+startmt+" == "+minute);
							if(starthr==hour && startmt==minute)
							{
								String sub=reset.getString(3);
								String cour=reset.getString(4);
								message=message+"Time : "+duphr+":"+dupmt+" To "+endhr+":"+endmt+"\n";
								message=message+"Subject : "+sub+"\n"+"Course : "+cour+"\n"+"Please Attend Lecture";
								mobno=set.getString(8).trim();
								//SMSClient send=SMSClient(1);
								//send.sendMessage(mobno,message);
								System.out.println(mobno+"\n"+message);
								try
								{
									Thread.sleep(5000);
								}
								catch(Exception exe)
								{
								}
							}
						}


					}

				}
			}
			if(day==Calendar.THURSDAY)
			{
				ResultSet set=st.executeQuery("select * from FacultyInfo ");
				while(set.next())
				{
					String faculty=set.getString(1);
					ResultSet reset=st2.executeQuery("select StartTime,EndTime,Thusday,ThCourse from "+faculty+"_time_table ");
					while(reset.next())
					{
						Time t=reset.getTime(1);
						Time en=reset.getTime(2);
						String ti=t.toString();
						String end=en.toString();
						if(!ti.equals("00:00:00"))
						{
							String sthr=ti.substring(0,2);
							String stmi=ti.substring(3,5);
							String endhr=end.substring(0,2);
							String endmt=end.substring(3,5);
							int starthr=Integer.parseInt(sthr);
							int duphr=starthr;
							int startmt=Integer.parseInt(stmi);
							int dupmt=startmt;
							int hour=c.get(Calendar.HOUR);
							int minute=c.get(Calendar.MINUTE);
							if(starthr>=12)
							{
								starthr=starthr-12;
							}
							int stmt=startmt-15;
							if(stmt<0)
							{
								if(starthr==0)
									starthr=11;
								else
									starthr--;

								startmt=60-(-stmt);
							}
							else
							{
								startmt=startmt-15;
							}
							System.out.println(starthr+" == "+hour +" && "+startmt+" == "+minute);
							if(starthr==hour && startmt==minute)
							{
								String sub=reset.getString(3);
								String cour=reset.getString(4);
								message=message+"Time : "+duphr+":"+dupmt+" To "+endhr+":"+endmt+"\n";
								message=message+"Subject : "+sub+"\n"+"Course : "+cour+"\n"+"Please Attend Lecture";
								mobno=set.getString(8).trim();
								//SMSClient send=SMSClient(1);
								//send.sendMessage(mobno,message);
								System.out.println(mobno+"\n"+message);
								try
								{
									Thread.sleep(5000);
								}
								catch(Exception exe)
								{
								}
							}
						}

					}
				}

			}
			if(day==Calendar.FRIDAY)
			{
				ResultSet set=st.executeQuery("select * from FacultyInfo ");
				while(set.next())
				{
					String faculty=set.getString(1);
					ResultSet reset=st2.executeQuery("select StartTime,EndTime,Friday,FCourse from "+faculty+"_time_table ");
					while(reset.next())
					{
						Time t=reset.getTime(1);
						Time en=reset.getTime(2);
						String ti=t.toString();
						String end=en.toString();
						if(!ti.equals("00:00:00"))
						{
							String sthr=ti.substring(0,2);
							String stmi=ti.substring(3,5);
							String endhr=end.substring(0,2);
							String endmt=end.substring(3,5);
							int starthr=Integer.parseInt(sthr);
							int duphr=starthr;
							int startmt=Integer.parseInt(stmi);
							int dupmt=startmt;
							int hour=c.get(Calendar.HOUR);
							int minute=c.get(Calendar.MINUTE);
							if(starthr>=12)
							{
								starthr=starthr-12;
							}
							int stmt=startmt-15;
							if(stmt<0)
							{
								if(starthr==0)
									starthr=11;
								else
									starthr--;

								startmt=60-(-stmt);
							}
							else
							{
								startmt=startmt-15;
							}
							System.out.println(starthr+" == "+hour +" && "+startmt+" == "+minute);
							if(starthr==hour && startmt==minute)
							{
								String sub=reset.getString(3);
								String cour=reset.getString(4);
								message=message+"Time : "+duphr+":"+dupmt+" To "+endhr+":"+endmt+"\n";
								message=message+"Subject : "+sub+"\n"+"Course : "+cour+"\n"+"Please Attend Lecture";
								mobno=set.getString(8).trim();
								//SMSClient send=SMSClient(1);
								//send.sendMessage(mobno,message);
								JOptionPane.showMessageDialog(null,mobno+"\n"+message);
								try
								{
									Thread.sleep(5000);
								}
								catch(Exception exe)
								{
								}
							}
						}

					}
				}

			}
			if(day==Calendar.SATURDAY)
			{
				ResultSet set=st.executeQuery("select * from FacultyInfo ");
				while(set.next())
				{
					String faculty=set.getString(1);
					ResultSet reset=st2.executeQuery("select StartTime,EndTime,Satureday,SCourse from "+faculty+"_time_table ");
					while(reset.next())
					{
						Time t=reset.getTime(1);
						Time en=reset.getTime(2);
						String ti=t.toString();
						String end=en.toString();
						if(!ti.equals("00:00:00"))
						{
							String sthr=ti.substring(0,2);
							String stmi=ti.substring(3,5);
							String endhr=end.substring(0,2);
							String endmt=end.substring(3,5);
							int starthr=Integer.parseInt(sthr);
							int duphr=starthr;
							int startmt=Integer.parseInt(stmi);
							int dupmt=startmt;
							int hour=c.get(Calendar.HOUR);
							int minute=c.get(Calendar.MINUTE);
							if(starthr>=12)
							{
								starthr=starthr-12;
							}
							int stmt=startmt-15;
							if(stmt<0)
							{
								if(starthr==0)
									starthr=11;
								else
									starthr--;

								startmt=60-(-stmt);
							}
							else
							{
								startmt=startmt-15;
							}
							System.out.println(starthr+" == "+hour +" && "+startmt+" == "+minute);
							if(starthr==hour && startmt==minute)
							{
								String sub=reset.getString(3);
								String cour=reset.getString(4);
								message=message+"Time : "+duphr+":"+dupmt+" To "+endhr+":"+endmt+"\n";
								message=message+"Subject : "+sub+"\n"+"Course : "+cour+"\n"+"Please Attend Lecture";
								mobno=set.getString(8).trim();
								//SMSClient send=SMSClient(1);
								//send.sendMessage(mobno,message);
								System.out.println(mobno+"\n"+message);
								try
								{
									Thread.sleep(5000);
								}
								catch(Exception exe)
								{
								}
							}
						}

					}

				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println("Message End");
	}
}