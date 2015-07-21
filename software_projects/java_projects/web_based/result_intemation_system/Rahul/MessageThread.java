class MessageThread extends Thread
{
	SendToTeacher tch=new SendToTeacher();
	public void run()
	{
		while(true)
		{
			try
			{
				while(true)
				{
					tch.sendMessage();
					Thread.sleep(30000);
				}
			}
			catch(Exception ex)
			{
			}
		}
	}
}