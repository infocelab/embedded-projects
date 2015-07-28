import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Blackjack extends Applet implements ActionListener, Runnable {
   char v[]={'a','2','3','4','5','6','7','8','9','t','j','q','k'};
   char s[]={'c','d','h','s'};
   String []mon = {"£1","£2","£3","£4","£5","£6","£7","£8","£9","£10"};
   String []bLabels = {"KEEP","DRAW","BUY","SPLIT","Insurance"};
   String str="",str2="",calc="punter to my game",winLose="   W E L C O M E!", insure="";
   int numCards, r, k, fin, temp1, temp2, total, total1, total2, ins, edge1, edge2, bet2;
   int bet=1, score=50;
   int []st  = new int[30];
   int []vl = new int[30];
   Image cards[]=new Image[52];
   Image back;
   MediaTracker mt=null;
   Thread theThread = null;
   Color cloth = new Color(30,110,0);
   Color bGrnd = new Color(90,10,0);
   Color pans  = new Color(0,20,70);
   int hand[]=new int[30];
   Panel pan = new Panel();
   
   Button Deal = new Button("DEAL THE CARDS");
   Button []buts = new Button[5];
   Choice money=new Choice();
   boolean deck[]=new boolean[52];
   boolean begin, newGame=true, blackjack, jackblack, insurance, doCards=true, drawCard, 
           hasAces, split, split1, splitter, dealer, splitScore, finish;
   Font f1 = new Font("Arial",0,18);
   Font f2 = new Font("Arial",0,14);

public void init(){
    loadImages();
    this.setLayout(null); 
    setBackground(bGrnd);
    pan.setBounds(15,10,420,330);
    pan.setBackground(cloth);
    add(pan);
    int j=0;
       for(int i=0; i<5; i++){
          buts[i]=new Button(bLabels[i]);          
          buts[i].setEnabled(false);
          buts[i].setBounds(450,180+j,70,25);
          buts[i].addActionListener(this);
          add(buts[i]);
          j+=33;
       }
    Deal.setBounds(450,130,135,35);
    Deal.addActionListener(this);
    add(Deal);       
       for(int i=0; i<10; i++)money.addItem(mon[i]);
    money.setBounds(535,180,50,80);
    add(money);
    shuffle();
  }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void shuffle() {
      if(!newGame)winLose="  G A M E  O N";
      newGame=blackjack=jackblack=insurance=drawCard=hasAces=splitScore=splitter=finish=false;
      begin=true;
      edge1=edge2=200;
      r=k=ins=total2=bet2=0;
      numCards=k=2;
      str2=calc=insure="";
      buts[3].setLabel("SPLIT");
      int i,card; 
      for (i=0;i<52;i++)deck[i]=false;
      java.util.Random rand = new java.util.Random();  
      for (i=0;i<30;i++) {
         while(true) {
            card=rand.nextInt(52);
            if(!deck[card])
            break;
         }
         hand[i]=card;
         deck[card]=true;
      }
      for (i=0;i<30;i++) {
         st[i]=(int)(hand[i]/13);
         vl[i]=hand[i]-((st[i]*13)-1);         
      }
   deal();
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public synchronized void loadImages() {
      mt = new MediaTracker(this);
      try{
         for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
               cards[i*13+j]=getImage(getCodeBase(),"cards/"+v[j]+s[i]+".gif");
               mt.addImage(cards[i*13+j],0);
            }
         }
         back=getImage(getCodeBase(),"cards/"+"b.gif");
         mt.addImage(back,0);  
         mt.waitForAll();
      }catch(InterruptedException e){} 
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void start(){
      if(theThread == null) {
         theThread = new Thread(this, "Blackjack");
         theThread.start();
      }
   }
   public void run(){
       //int r=0;
      Thread thread = Thread.currentThread();
      Thread theThread = new Thread();
      theThread.setPriority(Thread.MIN_PRIORITY);
      while (theThread != null){
         try{
            while (doCards){
              if(r>3) doCards=false;
              Thread.sleep (500);
              deal();
              r++;
            }
            while(split){
               if(r>1) split=false;
               Thread.sleep (700);
               doSplitz();
               r++;
            }
            while(split1){
               Thread.sleep (700);
               if(r>numCards+2) split1=false;
               doSplitz();
               r++;
            }
            while(dealer){
               Thread.sleep (700);
               if(r==numCards-1)dealer=false;
               dealerCards();
               k++;
               r++;
            }
         }
         catch (InterruptedException ex){}   
      }      
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
// Note: These next lines of code could be optimised, it works but its not good code
   public void deal(){
   Graphics g = pan.getGraphics();
    if(begin){
      g.setColor(cloth);
      g.fillRect(0,0,420,330);
      g.setColor(Color.yellow);
      g.drawString("DEALERS HAND",37,30);      
      g.drawRoundRect(15, 10,200,140,20,10);
      g.drawRoundRect(15,170,edge1,140,20,10);
      begin=false;
    }
    else{
      if(drawCard){
          g.setColor(cloth);
          g.fillRect(110,175,80,20);
          if(numCards < 6){                
             g.fillRect(110,171,edge1-150,32);
             g.fillRect(150,300,edge1-200,10);
          }
          else g.fillRect(110,171,50,20);
          g.fillRect(20,175,150,20);
          g.setColor(Color.yellow);
          g.drawString("YOUR HAND  "+str,37,190);
          if(numCards<5)g.drawRoundRect(15,170,edge1,140,20,10);
       }
       else {
          g.setColor(cloth);
          g.fillRect(edge1-70,171,6,139);
       }
    int j=80;
    if(r==0){}//pause
    if(r==1) g.drawImage(cards[hand[0]],37,42,this);
    if(r==2) g.drawImage(back,37+j,42,this);
    if(r==3) g.drawImage(cards[hand[1]],37,203,this);
    if(r==4) {
       g.drawImage(cards[hand[2]],37+j,203,this);
       g.setColor(Color.yellow);
       g.drawString("YOUR HAND  "+str,37,190);
    } 
    if(numCards==3) {g.drawImage(cards[hand[k]],37+j*2,203,this);}
    if(numCards==4) g.drawImage(cards[hand[k]],37+j*3,203,this);      
    if(numCards==5) {
       j=0;
       g.setColor(cloth);
       g.fillRect(30,200,360,102);
       g.setColor(Color.yellow);
          if(str2.length()>1){
             g.drawImage(cards[hand[2]],37,203,this);
                for(int i=1; i<4; i++){ 
                   g.drawImage(cards[hand[k-(numCards-2)+i]],37+j,203,this);
                   j+=75;
                 }
          }
          else{
             for(int i=0; i<5; i++){ 
                g.drawImage(cards[hand[k-(numCards-1)+i]],25+j,203,this);
                j+=75;
             }
          }
    g.drawRoundRect(15,170,390,140,20,10);
    }         
    if(numCards==6) {
       j=0;
          for(int i=0; i<5; i++){
             g.drawImage(cards[hand[k-(numCards-2)+i]],86+j,203,this);
             j+=60;
          }
    }  
    if(numCards==7) {
       j=0;
          for(int i=0; i<6; i++){
             g.drawImage(cards[hand[k-(numCards-2)+i]],71+j,203,this);
             j+=51;
          }
    }
    if(numCards==8) {
       j=0;
          for(int i=0; i<7; i++){
             g.drawImage(cards[hand[k-(numCards-2)+i]],63+j,203,this);
             j+=44;
          }
    }
   }
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void doSplitz(){
   Graphics g = pan.getGraphics();
   g.setColor(cloth);
      if(split1){
        if(r==0)g.drawString("OOO ",130,60);
        if(r==1){
           g.fillRect(10,170,400,142);
           g.fillRect(250,12,130,128);
           g.setColor(Color.yellow);
           g.drawRoundRect(15,170,edge1,140,20,10);
           g.drawString("1st HAND "+str,260,30);
           g.drawImage(cards[hand[2]],37,203,this);              
           splitter=true;
        }
        if(r==numCards+2){
           g.setColor(Color.yellow);
           g.drawImage(cards[hand[3+numCards]],117,203,this); 
           checkResults();
           g.drawString("2nd HAND "+str,37,190);
           numCards=2;
           splitter=false;
        }
        if(r<numCards+2) {
           if(r==2)g.drawImage(cards[hand[1]],253,42,this);
           if(r==3)g.drawImage(cards[hand[3]],253+fin,42,this);
           if(r==4)g.drawImage(cards[hand[4]],253+fin*2,42,this);
           if(r==5)g.drawImage(cards[hand[5]],253+fin*3,42,this);
           if(r==6)g.drawImage(cards[hand[6]],253+fin*4,42,this);
           if(r==7)g.drawImage(cards[hand[7]],253+fin*5,42,this);
           if(r==8)g.drawImage(cards[hand[8]],253+fin*6,42,this);
           if(r==9)g.drawImage(cards[hand[9]],253+fin*7,42,this);
        }
      }
      else{
         if(r==0){            
            g.setColor(Color.yellow);
            g.drawString("SPLIT CARD",270,30);
            g.drawRoundRect(240,10,160,140,20,10);  //split area
         }
         if(r==1){      
            g.fillRect(115,202,80,100);
            g.drawImage(cards[hand[2]],270,42,this);
         }
         if(r==2){
            g.fillRect(20,175,160,20);
            g.fillRect(110,175,80,20);
            g.drawImage(cards[hand[3]],117,203,this);
            g.setColor(Color.yellow);
            g.drawString("1st HAND  "+str,37,190);
            doButtons();
         }
      }  
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X* 
   public void dealerCards(){
      Graphics g = pan.getGraphics();
         if(r==0){
            g.setColor(cloth);
            g.fillRect(35,15,100,20);
            g.fillRect(115,40,90,110);
         }
         if(r==numCards-1){            
            g.setColor(Color.yellow);
            g.drawString("DEALER :  "+str,37,30);
            g.drawImage(cards[hand[k]],37+edge2*(numCards-1),42,this);
         money.setEnabled(true);
         Deal.setEnabled(true);
         finalCalc();
         }
         if(r!=numCards-1){         
            if(r==1)g.drawImage(cards[hand[k]],37+edge2,42,this);
            if(r==2)g.drawImage(cards[hand[k]],37+edge2*2,42,this);
            if(r==3)g.drawImage(cards[hand[k]],37+edge2*3,42,this);
            if(r==4)g.drawImage(cards[hand[k]],37+edge2*4,42,this);
            if(r==5)g.drawImage(cards[hand[k]],37+edge2*5,42,this);
            if(r==6)g.drawImage(cards[hand[k]],37+edge2*6,42,this);
            if(r==7)g.drawImage(cards[hand[k]],37+edge2*7,42,this);
        }
   }      

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X* 
   public int doDeal(int x){
     hasAces=false;
     boolean hasAces2=false;
     int i=1, j=0;
     numCards=1;
     if((vl[0]==1)||(vl[k+i]==1))hasAces=true;
     if(vl[0]>10)fin=10;
     else fin = vl[0];
     if(hasAces)fin+=10;
       do{
         if(vl[k+i]>10)fin+=10;
         else fin += vl[k+i];
         if((hasAces)&&(fin>21)){
            fin -=10;
            hasAces=false;
         }
         if((i!=1)&&(vl[k+i]==1))hasAces2=true;
         if(hasAces2)fin+=10;
         if((hasAces2)&&(fin>21))fin-=10;
         numCards=i+1;
         i++;
       } while (fin<17);
   return numCards;
   }      

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*  
   public int doSpaces(int x){
     if(numCards==2) edge2 =80;
     else edge2 = (int)(80/(numCards-1)+0.5);
     return edge2;
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public int getParam(int y){
     if(numCards==2) fin =64;
     else fin = (int)(64/(numCards-1)+0.5);
     return fin;
   }
   
// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void checkResults() {
     str="";
     blackjack=jackblack=hasAces=false;
      if(split) {
         vl[1]=vl[2];
         vl[2]=vl[3];
         st[1]=st[2];
         st[2]=st[3];
      }
      else if(splitter){
         vl[2]=vl[k];
         st[2]=st[k];    
      }
      else if(finish){
         vl[1]=vl[0];
         vl[2]=vl[k+1];
         st[1]=st[0];
         st[2]=st[k+1];
      } 
      else {}  
      if(((vl[1]==11)&&((st[1]==0)||(st[1]==3)))||((vl[2]==11)&&((st[2]==0)||(st[2]==3))))jackblack=true;
      if(vl[1]>10)vl[1]=10;
      if(vl[2]>10)vl[2]=10;
      total = vl[1]+vl[2];
      if((vl[0]==1)||(vl[0]>9))  insurance=true;
      if((vl[1]==1)||(vl[2]==1)) hasAces  =true;
      if((hasAces) && (total==11)) blackjack=true;
         if(blackjack){
            if(jackblack)str=" JACKPOT !";
            if((finish)&&(jackblack))str=" TOP DOG !";
            else str=" BLACKJACK";
         }         
         else{
            str=Integer.toString(total);
               if((!splitter)&&(vl[1]==vl[2]))str +=" : Split?"; 
               else if((!hasAces)&&(insurance))str += " : Insurance?";
               else if((hasAces)&&(total<12)) str=" "+total+" or "+(total+10);
               else str =" "+total+" : Play";   
         }
      if(blackjack)total=100;
      if((jackblack)&&(blackjack))total=250;
      if((finish)&&(!blackjack))str=Integer.toString(fin);
   } 

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void updateScore(){
         if(vl[k]>10)vl[k]=10;
         total += vl[k];
         if(vl[k]==1) hasAces=true;
         if((hasAces)&&(total<12)) str=" "+total+" or "+(total+10);
         else str = Integer.toString(total);
         if(total>20){
            if(!splitter) setNext();
            if(total!=21) str=Integer.toString(total)+"  BUST!";
         } 
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void setNext(){
      for(int i=0;i<5;i++)buts[i].setEnabled(false);
         if(bet!=0){
            buts[3].setLabel("NEXT");
            buts[3].setEnabled(true);
         }
         else Deal.setEnabled(false);
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void doScores(){
      Graphics g = pan.getGraphics();
      g.setColor(cloth);
      g.fillRect(25,15,180,130);
      g.setColor(Color.yellow);
      g.drawString("YOU LOSE: click on deal",37,30);
      Deal.setEnabled(true);
      money.setEnabled(true);
      score=score-bet;
      calc="You lose £"+bet;
   repaint();
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void finalCalc(){
      if(fin>21)fin=3;
      int temp1=0, temp2=0;
      if(blackjack)fin=100;
      if((blackjack)&&(jackblack))fin=250;
     // for two cards
        if(splitScore){
            if(fin>total2){
               temp1 -= bet2;
               calc="Lose 1st hand";
            }
            if(fin<total2) {
               if(total2==100) temp1 =bet2*2;
               else if(total2==250) temp1 =bet2*5;
               else temp1 +=bet2;
               calc="Win 1st hand";
            }
            if(fin==total2)calc="Push 1st hand"; 
            if(fin>total1){
               temp2 -= bet2;
               calc+=", lose 2nd";
            }
            else if(fin<total1) {
               if(total1==100) temp2 =bet*2;
               else if(total1==250) temp2 =bet*5;
               else temp2 +=bet;
               calc+=", win 2nd";
            }
            else calc+=", push 2nd";
         } // end for 2 cards      
           // one card only: not split
         else{
            if(fin>total1) temp2 -=bet;
            else if(fin<total1) {
               if(total1==100) temp2 =bet*2;
               else if(total1==250) temp2 =bet*5;
               else temp2 =bet;
               calc ="You win, place your bet.";
            }         
            else winLose="Its a pushhhh...";            
         }  // end one card only
         if((blackjack)&&(ins!=0)){
            insure="win "+(ins*3)/2;
            temp2 +=(ins*3)/2;
         }     
         if((!blackjack)&&(ins!=0)){
            insure="lose "+ins;
            temp2 -=ins; 
         }
        // final tallies: !=lose
         if(temp1 + temp2 < 0){
            if(!splitScore){
               calc = "Sorry you lose £"+((temp1 + temp2)*-1);
               winLose=" L O O Z E R !!";
            }
            else winLose=" L O S E - £ "+(temp1 + temp2)*-1;
            score += (temp1 + temp2);
            repaint(); 
         } 
        // 2: no win no loss
         else if(temp1 + temp2==0){
            if(!splitScore)calc = "Honours are even!";
            winLose="NOTHING GAINED";
            repaint(); 
         }
        // 3: else its a win
         else{ 
            score+=temp1 + temp2;
            winLose=" Y O U  W I N   £"+(temp1 + temp2);
            repaint();
         }
     }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void doButtons(){
      if(!blackjack){
         buts[0].setEnabled(true);
         buts[1].setEnabled(true);
      }
      money.setEnabled(false);
      if(insurance){
            buts[4].setEnabled(true);
            money.setEnabled(true);
         }
         else buts[4].setEnabled(false);      
      if((blackjack)&&(!splitter))setNext();
      else if((k==2)||(splitScore)) if(vl[1]==vl[2])buts[3].setEnabled(true);
      else buts[3].setEnabled(false); 
      if(splitter){
         buts[3].setLabel("SPLIT");
         buts[3].setEnabled(false);
         buts[0].setEnabled(true);
      }
      if((!blackjack)&&((vl[1]+vl[2]<12)||(total<12))) buts[2].setEnabled(true);
         else buts[2].setEnabled(false);         
   }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void paint(Graphics g) {
      g.setColor(Color.white);
      g.drawString(calc,450,120);       
      g.drawString(insure,530,328);
      if(splitter)g.drawString("£ "+bet2,550,280);
      else g.drawString("£ "+bet,550,280);
      g.drawRect(485,44,65,50); 
      g.drawRect(487,46,61,46);
      g.drawRect(537,240,50,50); 
      g.drawRect(539,242,46,46);
      g.drawString('\u00A9'+" info@computronicslab.com 2015",515,348);
      g.setFont(f2);
      g.drawString("SCORE:",494,62);
      g.drawString("£"+score,500,84);
      g.drawString("BET",549,260);
      g.drawString(winLose,455,30);
   } // end paint

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
   public void actionPerformed(ActionEvent e) {
      String com = e.getActionCommand();
      if(com.equals("DEAL THE CARDS")) {    
         shuffle();
         if(score>0)doCards = true;
         Deal.setEnabled(false);
         bet=money.getSelectedIndex()+1;
         checkResults();
         doButtons();
            if(bet>score)bet=score;
            if(bet==0){
               winLose="Game Over Sucker";
               calc="You have no money";
               setNext();
            }
      }

// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
      if((com.equals("DRAW"))||(com.equals("BUY"))) {
         drawCard=true;
         numCards++;
         edge1+=80;
         k++;
         updateScore();
         if((splitter)&&(total>20)) setNext();
            if(com.equals("BUY")){
               if(splitter){
                  if(score-bet>bet){
                     bet2*=2;
                     calc="Ride 'em cowboy !!!";
                  }
                  else calc="Ahh, ah, ah!!!";
               }
               if(!splitter){
                  if(score-bet>bet){
                     bet*=2;
                     calc="OK, double-down £"+bet/2;
                  }                
                  else calc="No money for that";
               }
            deal();
            setNext();
            }
            else deal();
         buts[4].setEnabled(false);
         buts[2].setEnabled(false);
      }
// X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*
      if(com.equals("SPLIT")) {
         if(score-bet>bet){
            bet2=bet;
            r=0;
            k++;
            doSplitz();
            split=splitter=splitScore=true;
            buts[3].setLabel("NEXT");
            checkResults();
         }
         else calc="No money to split";
      }
      if((com.equals("NEXT"))||(com.equals("KEEP"))){
        if(splitter){
            r=0;
            edge1=200;
              if(!blackjack) {        
                 if((hasAces)&&(total<12))total +=10;
                 if(total>21)total=2;
               }
            total2=total;
            getParam(fin);
            split1=true;
               if(split1)k+=2;               
            drawCard=false;
            doButtons();           
         }
         else {
            for(int i=0;i<5;i++)buts[i].setEnabled(false);
              if(k==2)checkResults();
              if(!blackjack) {        
                 if((hasAces)&&(total<12))total +=10;
                 if(total>21)total=2;
               }
            total1=total;  
            r=0;
            if((total1==2)&&(total2==0)&&(ins==0))doScores();
            else{
               doDeal(numCards);
               doSpaces(edge2);
               finish=dealer=true;
               checkResults();
           }
         }
      }
      if(com.equals("Insurance")){
         if(score-bet-bet2>money.getSelectedIndex()+1){
            ins+=money.getSelectedIndex()+1;
            insure="paid "+ins;
         }
         else insure="can't do it"; 
         money.setEnabled(false);
         buts[4].setEnabled(false);
      }
   repaint();
   
   }
   
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // Blackjack b=new Blackjack();
      //  b.run();
        (new Thread(new Blackjack())).start();
    }
}
 
