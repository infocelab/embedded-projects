/**
 * This class instantiates objcts (accounts)
 * of the Bank after reading from file or creating
 * new files for new accounts.
 * @author (Ankit Mohan X 'A')
 * @Co-author (Amit Kumar X 'A')
 * @version (20th Dec. 2004)
 */
import java.util.*;
import java.io.*;
class account
{

    String acn;  // A/C number, not on file
    String name; // name of A/C holder
    float bal;   // current balance
    long ATMcard;    // ATMcard card number
    int PIN;     // PIN number of ATMcard
    int tot=1;   // total transactions recorded
    String rec[];// to hold all transactions
    
    account(String an)throws IOException
    {
        // Object creation for already created account
        
        try
        {
        BufferedReader inf=new BufferedReader(new FileReader("acc"+an+".txt"));
        acn=an;
        name=inf.readLine();
        bal=Float.parseFloat(inf.readLine());
        ATMcard=Long.parseLong(inf.readLine());
        PIN=Integer.parseInt(inf.readLine());
        tot=Integer.parseInt(inf.readLine());
        String r[]=new String[tot];

        for(int i=0;i<tot;i++)
            r[i]=inf.readLine();
        
        rec=r;
        }
        catch(Exception e)
        {
            System.out.println();
            System.out.println("The account has been deleted.");
        }
            
        
    }
    
    account(String n, float b)throws IOException
    {
        name=n;
        bal=b;
        ATMcard=getATM();
        PIN=getPIN();
        String s=new String();
        s=getDate();
        /*s=s.concat(s.valueOf("  Self               "+b));
        s=s.concat(s.valueOf(" Deposit "+bal));*/
        String r[]=new String[tot];
        
        StringBuffer str=new StringBuffer(s);
        str.setLength(12);
        str=str.append("Self");
        str.setLength(31);
        s=s.valueOf(b);
        str=str.append(s);
        str.setLength(46);
        str=str.append(" Deposit  ");
        str=str.append(bal);
        s=s.valueOf(str);
        r[0]=s;
        rec=r;
        
        BufferedReader inf=new BufferedReader(new FileReader("list.txt"));
        String text=new String();
        String ans=new String();
        text=inf.readLine();
                
        // reading account number of last account created
         try
         {
         do
         {   ans=text;
             text=inf.readLine();
             //if(text.equals("")||text.equals(null)) break;
         }
         while(!(text.equals("")||text.equals(null)));
         }
         catch(Exception e){}
        if(ans.equals(null)||ans.equals(""))
            ans="1100";
        inf.close();
        
        // generating account number           
        int ac=Integer.parseInt(ans);
        ac+=1;
        acn=s.valueOf(ac);
        toFile();
        
        // adding A/C no. to list of accounts
        PrintWriter opf=new PrintWriter(new BufferedWriter(new FileWriter("list.txt",true)));
        opf.println(acn);
        opf.close();
        
        // Printing information
        System.out.println("New account created.");
        show();
    }
    public void toFile()throws IOException
    {
       // Writing information to file
       PrintWriter opf=new PrintWriter(new BufferedWriter(new FileWriter("acc"+acn+".txt")));
       opf.println(this.name);
       opf.println(this.bal);
       opf.println(this.ATMcard);
       opf.println(this.PIN);
       opf.println(this.tot);
       for(int i=0;i<this.tot;i++)
            opf.println(this.rec[i]);
       opf.close();
    }
        
        
  
    private static int getPIN()// generates 4 digit
    {                          // rendom PIN number
        Calendar c=Calendar.getInstance();
        String n=new String();
        n=n.valueOf(c.get(Calendar.MILLISECOND));
        n=n.concat(n.valueOf(c.get(Calendar.SECOND)));
        if(n.length()<3) n=n.valueOf(getPIN());
        int num=Integer.parseInt(n);
        num%=10000;
        return(num);
    }       
        
    public static String getDate()
    {
        Calendar c=Calendar.getInstance();
        String d=new String();
        d=d.valueOf(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));
        return(d);
    }
    
    private static long getATM()// generates 10 digit
    {                           // random ATMcard number
        Calendar c=Calendar.getInstance();
        String n=new String();
        n=n.valueOf(c.get(Calendar.MILLISECOND));
        n=n.concat(n.valueOf(c.get(Calendar.SECOND)));
        n=n.concat(n.valueOf(c.get(Calendar.MINUTE)+c.get(Calendar.HOUR)));
        long num=Long.parseLong(n);
        num*=2;
        return(num);
   }
   
   public void show()
   {
       System.out.println();
       System.out.println("              A C C O U N T - D E T A I L S");
       System.out.println();
       System.out.println("Name of account holder: "+this.name);
       System.out.println("Account number: "+this.acn);
       System.out.println("Available balance: "+this.bal);
       System.out.println("ATM card number: "+this.ATMcard);
       if(this.tot==1)
        System.out.println("Initial PIN assigned: "+this.PIN);
       System.out.println();
       System.out.println("      Date     Particls.        Amount         Type     Balance");
       System.out.println();
       for(int i=0;i<tot;i++)
        {
            String s=this.rec[i];
            for(int j=0;j<s.length();j++)
            if(s.charAt(j)=='\u0000')
            System.out.print(" ");
            else
            System.out.print(s.charAt(j));
            System.out.println();
        }
    }
    
    public void del()throws IOException
    {
        // writing null to file
        PrintWriter opf=new PrintWriter(new BufferedWriter(new FileWriter("acc"+this.acn+".txt")));
        String date=getDate();
        opf.println(date);// writing date when a/c closed
        opf.close();
    }
}