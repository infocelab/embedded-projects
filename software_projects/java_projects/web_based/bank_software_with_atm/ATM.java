/**
 * This class ATM provides for all the functionalities
 * that are provided by any ATM branch.
 * @author (Ankit Mohan X 'A') 
 * @Co-author (Amit Kumar X 'A')
 * @version (20th Dec. 2004)
 */
import java.io.*;
public class ATM
{
    public static void main()throws IOException
    {
        int trans=0;
        account ob;
        boolean t=false;//to test if account exists
        String c;// to store users choice
        String aNum=" ";// to store account number
        do
        {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        if(t==false)
        {
        System.out.println("\t \t V A L I D A T I N G - C U S T O M E R");
        System.out.println();
        System.out.println("Enter account number:");
        aNum=in.readLine();
        t=bank.exists(aNum);
        if(t==false)
        {
            System.out.println("The account specified does not exist.");
            System.out.println("Terminating...");
            break;
        }
        
        ob=new account(aNum);
        if(ob.ATMcard==0)// checking if account has not been deleted
        {
            System.out.println("The account no longer exist.");
            System.out.println("The account was closed on "+ob.name);
            break;
        }
        // validating ATM card number.
        System.out.println("Enter ATM card number: ");
        long at=Long.parseLong(in.readLine());
        if(ob.ATMcard!=at)
        {
            System.out.println("Wrong ATM card number.");
            break;
        }
        // validating PIN number
        System.out.println("Enter PIN number: ");
        int p=Integer.parseInt(in.readLine());
        if(p!=ob.PIN)
        {
            System.out.println("Wrong PIN number.");
            System.out.println("Terminating...");
            break;
        }
        }
        ob=new account(aNum);
        if(trans==0)
        {
            System.out.println();
            System.out.println("Hello "+ob.name+".");
            System.out.println("Welcome to the ATM branch.");
            System.out.println("Please follow the instructions below.");
            System.out.println();
        }
        trans++;
        System.out.println();
        System.out.println("\t \t M A I N - M E N U : A T M");
        System.out.println();
        System.out.println("1. Fast Cash");
        System.out.println("2. PIN Change");
        System.out.println("3. Mini-statement");
        System.out.println("4. View balance");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println("Enter choice: ");
        int ch=Integer.parseInt(in.readLine());
        switch(ch)
        {
            case 1:System.out.println("\t \t F A S T - C A S H");
                   System.out.println();
                   System.out.println("Enter amount to withdraw: ");
                   float am=Float.parseFloat(in.readLine());
                   if(am>ob.bal)
                   {
                       System.out.println("Not enough funds in account.");
                       System.out.println("Available balance: "+ob.bal);
                       System.out.println("Terminating...");
                       break;
                    }
                    if(am<=0)
                    {
                        System.out.println("Incorrect amount specified");
                        break;
                    }
                    ob=bank.withdraw(ob,am,"From ATM");
                    ob.toFile();
                    System.out.println();
                    System.out.println("\t\t T R A N S A C T I O N - S L I P");
                    System.out.println();
                    System.out.println("Transaction no.: "+trans);
                    System.out.println();
                    c=ob.getDate();
                    System.out.println("Date: "+c+"\tAccount number: "+ob.acn);
                    System.out.println("Withdrawal for: Rs."+am);
                    System.out.println("Available balance: "+ob.bal);
                    break;
            
            case 2:// PIN Change
            String p1=new String();
            String p2=new String();
            System.out.println();
            System.out.println("Enter new PIN number: ");
            p1=in.readLine();
            System.out.println("Re-enter to confirm: ");
            p2=in.readLine();
            if(!(p1.equals(p2)))
            {
                System.out.println("Wrong re-confirmation.");
                System.out.println("Terminating...");
                break;
            }
            ob.PIN=Integer.parseInt((p1));
            ob.toFile();
            break;
            
            case 3:// Print out last 5 transactions
            System.out.println();
            System.out.println("\t M I N I - S T A T E M E N T");
            System.out.println();
            System.out.println(ob.name+"        Account: "+ob.acn);
            int l;
            if(ob.tot<5)
              l=ob.tot;
            else
              l=5;
            System.out.println("      Date     Particls.        Amount         Type     Balance");
            for(int i=0;i<l;i++)
            {
                String s=ob.rec[i];
                for(int j=0;j<s.length();j++)
                if(s.charAt(j)=='\u0000')
                System.out.print(" ");
                else
                System.out.print(s.charAt(j));
                System.out.println();
            }
            break;
            
            case 4: // view balance
            System.out.println();
            System.out.println("Available balance: "+ob.bal);
            break;
            
            default: break;
        }
        System.out.println("Perform another transaction? Y/N");
        c=in.readLine();
        }
        while(c.equalsIgnoreCase("Y"));
        System.out.println();
        System.out.println("Have a nice day!!");
        System.out.println();
        System.out.println((char)169+"All rights reserved by Ankit");
    }
}