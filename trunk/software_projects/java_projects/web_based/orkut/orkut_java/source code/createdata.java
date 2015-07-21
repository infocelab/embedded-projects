public class createdata


{
	public static void main(String args[])
	{
		String q="create table logins (username varchar(20),password varchar(20),sex  varchar(10),country varchar(20),dob varchar(50), interest varchar(50),lang varchar(10),relig varchar(10),humour varchar(200), first varchar(10), last varchar(10),abtme varchar(200), passion varchar(200),book varchar(200),movie varchar(200),living varchar(50),fashion varchar(50),pets varchar(20),drink varchar(20),smok  varchar (20),primary key (username))";
	
	     new Client(q);
	}
}