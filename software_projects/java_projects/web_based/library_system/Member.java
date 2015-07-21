

public class Member
{
	String MemberName, MemberID, MemAddress, MemberIC;
	int MemberAge, MemPhone, BookCount;

	Member(String Name, int Age, String IC, String Address, int Telephone, int Count)	{
	
		MemberName = Name;
		MemberAge = Age;
		MemberIC = IC;
		MemAddress = Address;
		MemPhone = Telephone;
		MemberID = IC;
		BookCount = Count;

	}

	public String getName()		{
		return MemberName;
	}

	public int getAge()  		{
		return MemberAge;
	}

	public String getIC()		{
		return MemberIC;
	}
	
	public String getAddress()	{
		return MemAddress;
	}

	public int getPhone()		{
		return MemPhone;
	}

	public String getMemberID()	{
		return MemberID;

	}

	public int getBookCount()	{
		return BookCount;
	
	}

	public void IncreaseBookCount(){
		BookCount++;
	}

	public void DecreaseBookCount(){
		BookCount--;
	}
}
