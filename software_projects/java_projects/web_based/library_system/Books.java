
public class Books
{
	String BookName,BookAuthor, BookPublisher,BookStatus;
	int BookID;

	Books(String BName, String BAuthor, String BPublisher,int BID,String BStatus)	{
	
		BookName = BName;
		BookAuthor = BAuthor;
		BookPublisher = BPublisher;
		BookID = BID;
		BookStatus = BStatus;
		
	}

	public String getName()			{
		return BookName;
	}

	public String getAuthor()  		{
		return BookAuthor;
	}

	public int getID()				{
		return BookID;
	}
	
	public String getPublisher()	{
		return BookPublisher;
	}

	public String getStatus()		{
		return BookStatus;
	}
	
	public void setBorrowStatus()	{
		BookStatus = "Unavalible";
	}

	public void setReturnStatus()	{
		BookStatus = "Avalible";
	}
}
