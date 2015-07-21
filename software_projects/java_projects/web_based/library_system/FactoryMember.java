import javax.swing.*;
import java.awt.*;

public class FactoryMember
{	
	Member[] m;
	private int i = 0;
	private int y = 0;
	private int z;

	public FactoryMember()
	{
		m = new Member[50];
	
		m[0] = new Member("C A Vijayan",             20, "00000001A", "#10-720,Yishun st 71,Singapore 760721", 7542473, 0);
		m[1] = new Member("Chan Wai Leng",           20, "00000002B", "#02-343,Jurong st 84,Singapore 765343", 8997598, 0);
		m[2] = new Member("Chong Yoon Siong",        20, "00000003C", "#09-756,Bukit Batok st 21,Singapore 345756", 5611300, 0);
		m[3] = new Member("Wang Ren",                20, "00000004D", "#08-213,Tampines st 36,Singapore 456213", 2438973, 0);
		m[4] = new Member("Su Huaqi",                20, "00000005E", "#14-167,Bukit Batok st 22,Singapore 856167", 3103109, 0);
		m[5] = new Member("Liu Peng Jian",           20, "00000006F", "#03-670,Tampines st 84,Singapore 343670", 7861194, 0);
		m[6] = new Member("Woo Mun Ken",             20, "00000007G", "#05-543,Pasir Ris st 16,Singapore 659543", 5844182, 0);
		m[7] = new Member("Erickson Ong Tian Rong",  20, "00000008H", "#02-233,Tampines st 18,Singapore 564233", 7486555, 0);		
		m[8] = new Member("W A J Fernando",          20, "00000009I", "#11-865,Tampines st 34,Singapore 455865", 97489129, 0);
		m[9] = new Member("Zaw Zaw Latt",            20, "00000010J", "#12-675,Tampines st 48,Singapore 232675", 2866027, 0);

		
	}

	public int getMemberSize()	{
		while (m[i] != null) {
			i++;
		}
		return i;
	}

	
	public void getStatsUsingName(String Name)	{
	
		for(int j = 0; j <= getMemberSize()-1; j++)	{
			if(Name.equalsIgnoreCase(m[j].getName()))	{
				
				JPanel p1 = new JPanel();
				p1.setLayout(new GridLayout(7,7));
				JLabel     mnl  = new JLabel("Name      : ");
				JTextField mnt  = new JTextField(""+m[j].getName()); 
				mnt.setEditable(false);
				JLabel     mal  = new JLabel("Age    : ");
				JTextField mat  = new JTextField(""+m[j].getAge()); 
				mat.setEditable(false);
				JLabel     micl  = new JLabel("IC No : ");
				JTextField mict  = new JTextField(""+m[j].getIC()); 
				mict.setEditable(false);
				JLabel     madl = new JLabel("Address       : ");
				JTextField madt = new JTextField(""+m[j].getAddress()); 
				madt.setEditable(false);
				JLabel     mtl  = new JLabel("Telelphone number  : ");
				JTextField mtt  = new JTextField(""+m[j].getPhone()); 
				mtt.setEditable(false);
				JLabel     midl  = new JLabel("Member ID    : ");
				JTextField midt  = new JTextField(""+m[j].getMemberID());
				midt.setEditable(false);
				JLabel     mbcl  = new JLabel("Book Counts    : ");
				JTextField mbct  = new JTextField(""+m[j].getBookCount());
				mbct.setEditable(false);
				p1.add(mnl);
				p1.add(mnt);
				p1.add(mal);
				p1.add(mat);
				p1.add(micl);
				p1.add(mict);
				p1.add(madl);
				p1.add(madt);
				p1.add(mtl);
				p1.add(mtt);
				p1.add(midl);
				p1.add(midt);
				p1.add(mbcl);
				p1.add(mbct);
								
			JOptionPane.showMessageDialog(null,p1,"Member Record",JOptionPane.INFORMATION_MESSAGE);
	
			}
		}
	}


	public void getStatsUsingIC (String IC)  {

		for(int j = 0; j <= getMemberSize()-1; j++)	{
			if(IC.equalsIgnoreCase(m[j].getIC()))	{
				
				JPanel p2 = new JPanel();
				p2.setLayout(new GridLayout(7,7));
				JLabel     mnl2  = new JLabel("Name      : ");
				JTextField mnt2  = new JTextField(""+m[j].getName());
				mnt2.setEditable(false); 
				JLabel     mal2  = new JLabel("Age    : ");
				JTextField mat2  = new JTextField(""+m[j].getAge());
				mat2.setEditable(false);  
				JLabel     micl2  = new JLabel("IC No : ");
				JTextField mict2  = new JTextField(""+m[j].getIC()); 
				mict2.setEditable(false); 
				JLabel     madl2 = new JLabel("Address       : ");
				JTextField madt2 = new JTextField(""+m[j].getAddress()); 
				madt2.setEditable(false); 
				JLabel     mtl2  = new JLabel("Telelphone number  : ");
				JTextField mtt2  = new JTextField(""+m[j].getPhone());
				mtt2.setEditable(false);  
				JLabel     midl2  = new JLabel("Member ID    : ");
				JTextField midt2  = new JTextField(""+m[j].getMemberID());
				midt2.setEditable(false); 
				JLabel     mbcl2  = new JLabel("Book Counts    : ");
				JTextField mbct2  = new JTextField(""+m[j].getBookCount());
				mbct2.setEditable(false); 
				
				p2.add(mnl2);
				p2.add(mnt2);
				p2.add(mal2);
				p2.add(mat2);
				p2.add(micl2);
				p2.add(mict2);
				p2.add(madl2);
				p2.add(madt2);
				p2.add(mtl2);
				p2.add(mtt2);
				p2.add(midl2);
				p2.add(midt2);
				p2.add(mbcl2);
				p2.add(mbct2);
								
			JOptionPane.showMessageDialog(null,p2,"Member Record",JOptionPane.INFORMATION_MESSAGE);
		
					
				
	}
		}
	}


	public void addMember(String Name, int Age, String IC, String Address, int Telephone)	{

		m[getMemberSize()] = new Member(Name,Age,IC,Address,Telephone,0);
		
	}


	public int getMemberBookCount(String MemberID)			{		
		
			for(int j = 0; j <= getMemberSize()-1; j++)	{
				if(MemberID.equals(m[j].getIC())) {
			  	y = m[j].getBookCount();
				}
			}
			  	return y;
	}

	
	public void UpdateBookCount (String MemberID) 			{
			for(int j = 0; j <= getMemberSize()-1; j++)	{
				if(MemberID.equals(m[j].getIC()))
				{
					m[j].IncreaseBookCount();
					
				}
			}
		}

	public void ReturnBookCount (String MemberID) 			{
			for(int j = 0; j <= getMemberSize()-1; j++)	{
				if(MemberID.equals(m[j].getIC()))
				{
					m[j].DecreaseBookCount();
					
				}
			}
		}
}
