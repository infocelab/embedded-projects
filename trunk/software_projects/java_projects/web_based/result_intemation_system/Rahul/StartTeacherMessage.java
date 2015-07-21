class StartTeacherMessage
{
	MessageThread msg=new MessageThread();
	StartTeacherMessage()
	{
	}
	public void startMsg(boolean fg)
	{
		if(fg==true)
		{
			msg.start();
		}
	}
	public void endMsg()
	{
		msg.suspend();
	}
}
