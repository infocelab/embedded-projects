/**
 * This class holds all methods for various
 * transactions done in banks using account objects.
 * @author (Ankit Mohan X 'A') 
 * @Co-author (Amit Kumar X 'A')
 * @version (20th Dec. 2004)
 */
import java.io.*;
public class bank
{
    public static void main()throws IOException
    {
        String c="";
        do
        {
        System.out.println();
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\t \t M A I N - M E N U : B A N K");
        System.out.println();
        System.out.println(" 1. Create new account");
        System.out.println(" 2. Deposit");
        System.out.println(" 3. Withdraw");
        System.out.println(" 4. View details");
        System.out.println(" 5. Delete account");
        System.out.println(" 6. Exit");
        System.out.println();
        //variables used
        String aNum;// to store account number
        account ob;
        float am;   // to store amount
        boolean t;  //to test if account exists
        System.out.println("Enter choice:");
        int ch=Integer.parseInt(in.readLine());
        switch(ch)
        {
            case 1:System.out.println("\t \t C R E A T E   N E W   A C C O U N T");
                   System.out.println();
                   System.out.println("Enter name of account holder: ");
                   String nam=in.readLine();
                   System.out.println("Enter initial deposit:");
                   float bal=Float.parseFloat(in.readLine());
                   System.out.println("Write to files? Y/N");
                   c=in.readLine();
                   if(c.equalsIgnoreCase("n"))   break;
                   account ac=new account(nam, bal);
                   break;
                   
           case 2:System.out.println("\t \t D E P O S I T");
                  System.out.println();
                  System.out.println("Enter account number:");
                  aNum=in.readLine();
                  t=exists(aNum);
                  if(t==false)
                  {
                      System.out.println("Account does not exist.");
                      System.out.println("Deposit unsuccessful.");
                      System.out.println("Terminating...");
                      break;
                  }
                  ob=new account(aNum);
                  if(ob.ATMcard==0)
                  {
                      System.out.println("The account no longer exists.");
                      System.out.println("The account was closed on "+ob.name);
                      break;
                  }
                  System.out.println("Name of account holder: "+ob.name);
                  System.out.println("Name of depositor:");
                  String n=in.readLine();
                  System.out.println("Amount:");
                  am=Float.parseFloat(in.readLine());
                  
                  if(am<=0)
                  {
                      System.out.println("Wrong input. Deposit cannot be less than or equal to zero.");
                      System.out.println("Terminating deposit.");
                      break;
                  }
                  System.out.println("Write to files? Y/N");
                  c=in.readLine();
                  if(c.equalsIgnoreCase("n"))   break;
                  ob=deposit(ob,am,n);
                  ob.toFile();
                  System.out.println();
                  System.out.println("Deposit made by: "+n+" for Rs."+am);
                  System.out.println("Deposit done successfully.");
                  System.out.println("Current balance: "+ob.bal);
                  break;
                  
           case 3:System.out.println("\t \t W I T H D R A W");
                  System.out.println("Enter account number:");
                  aNum=in.readLine();
                  t=exists(aNum);
                  if(t==false)
                  {
                      System.out.println("Account does not exist");
                      System.out.println("Withdrawal unsuccessful.");
                      System.out.println("Terminating...");
                      break;
                  }
                  ob=new account(aNum);
                  if(ob.ATMcard==0)
                  {
                      System.out.println("The account no longer exists.");
                      System.out.println("It was closed on "+ob.name);
                      System.out.println("Withdrawal unsuccessful.");
                      break;
                  }
                  System.out.println("Name of account holder: "+ob.name);
                  System.out.println("Enter name of withdrawer:");
                  n=in.readLine();
                  System.out.println("Enter amount to withdraw:");
                  am=Float.parseFloat(in.readLine());
                  if(am<=0)
                  {
                      System.out.println("Withdrawal cannot be Rs."+am);
                      System.out.println("Wrong input");
                      System.out.println("Terminating...");
                      break;
                  }
                  if(ob.bal<am)//checking for money
                  {
                      System.out.println("Withdrawal unsuccessful.");
                      System.out.println("Not enough funds in account");
                      break;
                  }
                  System.out.println("Write to files? Y/N");
                  c=in.readLine();
                  if(c.equalsIgnoreCase("n"))   break;
                  ob=withdraw(ob,am,n);
                  ob.toFile();
                  System.out.println();
                  System.out.println("Withdrawal made by: "+n+" for Rs."+am);
                  System.out.println("Withdrawal done successfully.");
                  System.out.println("Current balance: "+ob.bal);
                  break;
           
           case 4:System.out.println("\t \t V I E W - D E T A I L S");
                  System.out.println();
                  System.out.println("Enter account number to view details:");
                  aNum=in.readLine();
                  t=exists(aNum);
                  if(t==false)
                  {
                      System.out.println("Account does not exist.");
                      System.out.println("Terminating...");
                      break;
                  }
                  ob=new account(aNum);
                  if(ob.ATMcard==0)
                  {
                      System.out.println("The account deos not exist.");
                      System.out.println("It was closed on "+ob.name);
                      break;
                  }
                  ob.show();
                  break;
           
           case 5:System.out.println("                 D E L E T E - A C C O U N T");
                  System.out.println();
                  System.out.println(" Enter account number to delete:");
                  aNum=in.readLine();
                  t=exists(aNum);
                  if(t==false)
                  {
                      System.out.println("The specified account does not exist.");
                      System.out.println("Cannot delete");
                      System.out.println("Terminating...");
                      break;
                  }
                  ob=new account(aNum);
                  if(ob.ATMcard==0)
                  {
                      System.out.println("The account has already been deleted.");
                      System.out.println("The account was closed on "+ob.name);
                      break;
                  }
                  System.out.println("Name of account holder: "+ob.name);
                  System.out.println("Delete account? Y/N");
                  c=in.readLine();
                  if(c.equalsIgnoreCase("y"))
                  {
                      System.out.println("Are you sure? Y/N");
                      c=in.readLine();
                      if(c.equalsIgnoreCase("Y"))  ob.del();
                      System.out.println("Account successfully deleted.");
                  }
                  break;
           
           case 6:break;
           default:System.out.println("Wrong input");       
        }
        System.out.println();
        System.out.println("Perform another transaction? Y/N");
        c=in.readLine();
      }
      while(c.equalsIgnoreCase("Y"));
      System.out.println();
      System.out.println((char)169+"All rights reserved by Ankit");
    }
        
    static boolean exists(String n)throws IOException
    {    //checks if account 'n' exists or not
         boolean test=false;
         BufferedReader inf=new BufferedReader(new FileReader("list.txt"));
         String in=new String();
         in=inf.readLine();
         try
         {
         do
         {
             in=inf.readLine();
             if(in.equals(n))
                {
                    test=true;
                    break;
                }
         }
         while(!(in.equals(n) && in.equals(null)));
         }
         catch(Exception e){}
         inf.close();
         return(test);
    }
    // returns a modified (amt deposited) account
    private static account deposit(account x,float amt,String n)
    {
        x.bal+=amt; //deposit added
        String s=new String();
        s=x.getDate();
        StringBuffer str=new StringBuffer(s);
        str.setLength(12);
        str=str.append(n);
        str.setLength(31);
        s=s.valueOf(amt);
        str=str.append(s);
        str.setLength(46);
        str=str.append(" Deposit  ");
        str=str.append(x.bal);
        String[] r=new String[(x.tot+1)];
        r[0]=s.valueOf(str);
       // creating new array record for account
       for(int i=1;i<=x.tot;i++)
            r[i]=x.rec[(i-1)];
       x.rec=r;
       x.tot++;
       return(x);
        
    }
    //returns modified(amt subtracetd) account
    static account withdraw(account x,float amt,String n)
    {
        x.bal-=amt; //deposit added
        String s=new String();
        s=x.getDate();
        StringBuffer str=new StringBuffer(s);
        str.setLength(12);
        str=str.append(n);
        str.setLength(31);
        s=s.valueOf(amt);
        str=str.append(s);
        str.setLength(46);
        str=str.append(" Withdrew ");
        str=str.append(x.bal);
        String[] r=new String[(x.tot+1)];
        r[0]=s.valueOf(str);
       // creating new array record for account
       for(int i=1;i<=x.tot;i++)
            r[i]=x.rec[(i-1)];
       x.rec=r;
       x.tot++;
       return(x);
     }
}       