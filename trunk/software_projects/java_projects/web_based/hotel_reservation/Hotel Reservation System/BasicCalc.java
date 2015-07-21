

import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.JOptionPane ;
import java.io.*;


public class BasicCalc extends JFrame
                implements ActionListener {

   private JButton bOne, bTwo, bThree, bFour, bFive,
                   bSix, bSeven, bEight, bNine,  bZero, bExi,
                   bMult, bDiv, bSub, bPlus, bEquals,
                    bDecPt, bClear ;
   private JTextField enterBox ;
   private JPanel textPanel, exitPanel, buttonPanel, functionPanel ;
   private Container c ;
   private Font         font;
   private String firstNum = new String(""), secondNum  = new String(""), tempNum, tempStr ;
   private boolean myDiag = false, result = false ,
                    tempfirstNumSet = false, firstNumSet = false, secondNumSet = false,
                   pendingOp  = false ;
   private double aNum, dNum1 = 0.0, dNum2 = 0.0 , answer = 0.0,
                   tempD = 0.0 , minusOne = -1.0 ;
   private double dArray[] = new double[ 10 ]  ;
   private int opCode = -1, tempInt = 0, tempInt2 = 0,
                 dArrayPtr = 0, pendingOpCode = -1 ;

  
   public BasicCalc() {

      super( " Calculator" );
      setup() ;

      setSize( 350, 250 ); 
      setLocation( 700, 70 ) ;
                  
   }


   public void setup()   {
      c = getContentPane() ;

     
      setUpTextField() ;


    
      setUpButtons() ;

     
      setUpFunctionPanel() ;

    
      setUpExitPanel() ;

   
      setUpActionListener() ;
   }

   
   public void setUpTextField() {
          
      enterBox  = new JTextField( 15 ) ;
      enterBox.setText( "0" );
      firstNumSet = true ;
      enterBox.setEditable( false );
      enterBox.setBackground( Color.white );
      enterBox.setHorizontalAlignment( JTextField.RIGHT );
      enterBox.addKeyListener(
     
         new KeyAdapter() {
            public void keyPressed ( KeyEvent e )   {
          
            }
         }
      );
      textPanel = new JPanel() ;
      textPanel.add(enterBox ) ;

      c.add( textPanel , BorderLayout.NORTH ) ;
   }

   
   public void setUpButtons() {
      buttonPanel = new JPanel() ;
      c.add( buttonPanel , BorderLayout.CENTER ) ;

      bZero   = new JButton( "0" ) ;
      bZero.setFont( new Font("Sanserif", Font.BOLD, 16 ) );
      bOne    = new JButton( "1" ) ;
      bTwo    = new JButton( "2" ) ;
      bThree  = new JButton( "3" ) ;
      bFour   = new JButton( "4" ) ;
      bFive   = new JButton( "5" ) ;
      bSix    = new JButton( "6" ) ;
      bSeven  = new JButton( "7" ) ;
      bEight  = new JButton( "8" ) ;
      bNine   = new JButton( "9" ) ;
      bExi   = new JButton( "Exit" ) ;
      bClear   = new JButton( "Clear" ) ;
      bClear.setBackground( Color.blue ) ;
      bClear.setForeground( Color.white );
      bMult   = new JButton( "*" ) ;
      bMult.setFont( new Font("Sanserif", Font.BOLD, 20 ) );
      bMult.setBackground( Color.blue ) ;
      bMult.setForeground( Color.white );
      bDiv    = new JButton( "/" ) ;
      bDiv.setFont( new Font("Sanserif", Font.BOLD, 20 ) );
      bDiv.setBackground( Color.blue ) ;
      bDiv.setForeground( Color.white );
      bSub    = new JButton( "-" ) ;
      bSub.setFont( new Font("Sanserif", Font.BOLD, 24 ) );
      bSub.setBackground( Color.blue ) ;
      bSub.setForeground( Color.white );
      bPlus   = new JButton( "+" ) ;
      bPlus.setBackground( Color.blue ) ;
      bPlus.setForeground( Color.white );

      bEquals = new JButton( "=" ) ;
      bEquals.setFont( new Font("Sanserif", Font.BOLD, 16 ) );
      bEquals.setBackground( Color.red ) ;
      bEquals.setForeground( Color.white );
      bDecPt = new JButton( "." ) ;
      bDecPt.setFont( new Font("Sanserif", Font.BOLD, 22 ) );


    
      buttonPanel.add( bSeven ) ;
      buttonPanel.add( bEight ) ;
      buttonPanel.add( bNine ) ;

      buttonPanel.add( bFour ) ;
      buttonPanel.add( bFive ) ;
      buttonPanel.add( bSix ) ;
      buttonPanel.add( bOne ) ;
      buttonPanel.add( bTwo ) ;
      buttonPanel.add( bThree ) ;


      buttonPanel.add( bZero ) ;
      buttonPanel.add( bDecPt ) ;
      buttonPanel.add( bEquals ) ;

      buttonPanel.setLayout( new GridLayout( 5, 3, 5, 5  ) );
   }


  
   public void setUpActionListener()  {
      bDecPt.addActionListener( this );
      bZero.addActionListener( this );
      bOne.addActionListener( this );
      bTwo.addActionListener( this );
      bThree.addActionListener( this );
      bFour.addActionListener( this );
      bFive.addActionListener( this );
      bSix.addActionListener( this );
      bSeven.addActionListener( this );
      bEight.addActionListener( this );
      bNine.addActionListener( this );
      bExi.addActionListener( this );
      bMult.addActionListener( this );
      bDiv.addActionListener( this );
      bSub.addActionListener( this );
      bPlus.addActionListener( this );
      bEquals.addActionListener( this );
      bClear.addActionListener( this );

      bExi.addActionListener( this );
    
   }

   public void setUpFunctionPanel() {

      functionPanel = new JPanel() ;
      c.add( functionPanel , BorderLayout.EAST ) ;
      functionPanel.setLayout( new GridLayout( 6, 1, 5, 3  ) );

      functionPanel.add( bMult ) ;
      functionPanel.add( bDiv ) ;
      functionPanel.add( bSub ) ;
      functionPanel.add( bPlus ) ;
      functionPanel.add( bClear ) ;
   }

 
   public void setUpExitPanel() {
      exitPanel = new JPanel() ;
      c.add( exitPanel , BorderLayout.SOUTH ) ;
      bExi  = new JButton( "Exit" ) ;
      bExi.setFont( new Font("Sanserif", Font.BOLD, 16 ) );
      bExi.setBackground( Color.red ) ;
      bExi.setForeground( Color.white );
    
     

    
      exitPanel.add( bExi ) ;
    

   }

  
   public void actionPerformed( ActionEvent e )    {

      tempNum = ""  + answer ;

      if ( e.getSource() == bPlus || e.getSource() == bSub ||
              e.getSource() == bMult || e.getSource() == bDiv  ) {
         tempNum = ""  + answer ;

         MyPrint( "actionPerformed() 1a: The value of result is " + result +
               " The value of tempNum is " + enterBox.getText() +
                " The value of opCode is " + opCode ) ;
      }

      if ( result ) {
        
         MyPrint( "actionPerformed() 1b: The value of result is " + result +
                  "The value of tempNum is " + enterBox.getText()
         );
         result = false ;
         enterBox.setText( "" );
      }

      if ( !pendingOp && opCode == 99 ) {
        
         MyPrint( "actionPerformed() 1c: The value of opCode is " + opCode +
                   " The value of firstNum is " + firstNum  +
                   " The value of tempNum is " + tempNum );
         pendingOpCode = -1 ;
        
         firstNumSet = true ;
         firstNum = tempNum ;
         enterBox.setText( "" );
      }

      if ( e.getSource() == bDecPt ) {
         MyPrint( "The decimal point button was pressed." );
         enterBox.setText( enterBox.getText() + "." ) ;
      }
      else if ( e.getSource() == bZero ) {
         MyPrint( "The zero button was pressed. And pendingOp is " + pendingOp );
         enterBox.setText( enterBox.getText() + "0" ) ;
      }
      else  if ( e.getSource() == bOne ) {
         MyPrint( "The one button was pressed. And pendingOp is " + pendingOp  );
         enterBox.setText( enterBox.getText() + "1" ) ;
      }
      else  if ( e.getSource() == bTwo ) {
         MyPrint( "The two button was pressed. And pendingOp is " + pendingOp );
         enterBox.setText( enterBox.getText() + "2" ) ;
      }
      else  if ( e.getSource() == bThree ) {
         MyPrint( "The Three button was pressed. And pendingOp is " + pendingOp);
         enterBox.setText( enterBox.getText() + "3" ) ;
      }
      else  if ( e.getSource() == bFour ) {
         MyPrint( "The Four button was pressed. And pendingOp is " + pendingOp );
         enterBox.setText( enterBox.getText() + "4" ) ;
      }
      else  if ( e.getSource() == bFive ) {
         MyPrint( "The Five button was pressed. And pendingOp is " + pendingOp );
         enterBox.setText( enterBox.getText() + "5" ) ;
      }
      else  if ( e.getSource() == bSix ) {
         MyPrint( "The Six button was pressed. And pendingOp is " + pendingOp );
         enterBox.setText( enterBox.getText() + "6" ) ;
      }
      else  if ( e.getSource() == bSeven ) {
         MyPrint( "The Seven button was pressed. And pendingOp is " + pendingOp );
         enterBox.setText( enterBox.getText() + "7" ) ;
      }
      else  if ( e.getSource() == bEight ) {
         MyPrint( "The Eight button was pressed. And pendingOp is " + pendingOp );
         enterBox.setText( enterBox.getText() + "8" ) ;
      }
      else  if ( e.getSource() == bNine ) {
         MyPrint( "The Nine button was pressed. And pendingOp is " + pendingOp );
         enterBox.setText( enterBox.getText() + "9" ) ;
      }
      else  if ( e.getSource() == bExi ) {
        setVisible(false);
      }
      else  if ( e.getSource() == bMult ) {
         MyPrint( "The Mult button was pressed. And pendingOp is " + pendingOp  );
         multOp() ;
      }
      else  if ( e.getSource() == bDiv ) {
         MyPrint( "The Div button was pressed. And pendingOp is " + pendingOp  );
         divOp() ;
      }
      else  if ( e.getSource() == bSub ) {
         MyPrint( "The Sub button was pressed. And pendingOp is " + pendingOp  );
         subOp() ;
      }
      else  if ( e.getSource() == bPlus ) {
         MyPrint( "The Plus button was pressed. And pendingOp is " + pendingOp  );
         plusOp()    ;
      }
      else  if ( e.getSource() == bClear ) {
         MyPrint( "The bClear button was pressed." );
         enterBox.setText( "" )  ;
         firstNum = "" ;
         firstNumSet = true ;
         secondNum =  ""   ;
         answer = 0.0 ;
         dNum1 = 0.0 ;
         dNum2 = 0.0 ;
         opCode = -1 ;
         pendingOpCode = -1 ;
         pendingOp = false ;
      }
      else  if ( e.getSource() == bEquals ) {
         MyPrint( "bEquals 1: The Equals button was pressed. And pendingOp is " + pendingOp  +
             " The opCode value is " + opCode );
         if ( pendingOpCode >= 0 || pendingOpCode <= 3 ) {
            MyPrint( "bEquals 2: In pendingOpCode =s " + pendingOpCode ) ;
            pendingOp = true ;
            opCodeMethod() ;
         }
      }
   
     
   }
  
   public void setResults() {
      MyPrint( "setResults() 1: answer is " + answer + " dNum1 is " + dNum1 );

      enterBox.setText( "" + answer );
      firstNum = "" + answer ;
      dNum1 =  answer;
      firstNumSet = true ;
      result  = true ;
      pendingOp = false ;
   }
 
   public void opCodeMethod() {
      int currentOpCode = -1 , tempOpCode = opCode ;
      boolean temppendingOp = pendingOp ;

      MyPrint( "opCodeMethod() 1: with an opCode of " + opCode );

    
      if ( pendingOp ) {
         MyPrint( "opCodeMethod() 2: with an opCode of " + opCode +
                                        " and a pendingOpCode =s " + pendingOpCode );
         currentOpCode = pendingOpCode ;
         pendingOp = false ;
      }
      else {
         currentOpCode = opCode ;
         MyPrint( "opCodeMethod() 2b: with an opCode of " + opCode ) ;
      }

      switch ( currentOpCode ) {
         case 0 :
            multOp() ;
         break ;
         case 1 :
            divOp() ;
         break ;
         case 2 :
            MyPrint( "opCodeMethod() 3: opCode =s " + currentOpCode ) ;
            subOp() ;
         break ;
         case 3 :
            MyPrint( "opCodeMethod() 4: opCode =s " + currentOpCode ) ;
            plusOp() ;
         break ;
         case 5 :
      
         break ;
         default :
            MyPrint( "opCodeMethod() 7: default case is " + currentOpCode );
            setResults() ;
            firstNumSet = true ;
            secondNum = "0.0" ;
            dNum2 = 0.0 ;
            pendingOp = false ;
            opCode = 99 ;
            MyPrint( "opCodeMethod() 8: Case default: firstNum =s " + firstNum);
         break ;
      }

      MyPrint( "opCodeMethod() 9: pendingOpCode =s " + pendingOpCode +
                   " pendingOp " +  pendingOp );

      pendingOpCode = tempOpCode ;
      pendingOp = temppendingOp ;

      if ( !( opCode == 99 ) )
         opCode = -1 ;

   }
 
   public void multOp() {
      opCode = 0 ;

      MyPrint( "multOp() 1a: The opcode value is " + opCode +
                  " The value of firstNum is " + firstNum +
                  " The value of answer is " + answer ) ;

      if ( pendingOpCode == 0  ) {
         secondNum = enterBox.getText()  ;
         if ( secondNum.equals( "" ) ) {
            secondNum = "0.0" ;
         }
         convertNumsToDouble() ;
         answer = dNum1 * dNum2 ;
         pendingOp = false ;
         setResults() ;
         MyPrint( "multOp() 2: opCode is " + opCode + " The value of answer is " + answer );
         secondNum = "0.0"  ;
         opCode = -1 ;

      }
      else if ( pendingOpCode >= 1 ) {
         MyPrint( "multOp() 2a: In pendingOpCode =s " + pendingOpCode ) ;
         pendingOp = true ;
         opCodeMethod() ;
      }
      else if ( opCode == 0  ) {
         MyPrint( "multOp() 3: In pendingOp code. The opcode value is " + opCode ) ;
         firstNum = enterBox.getText()  ;
         if ( secondNum.equals( "" ) ) {
            secondNum = "0.0" ;
         }
         opCode = 0 ;
         pendingOp = false ;
         pendingOpCode = 0 ;
         MyPrint( "multOp() 5: opCode is " + opCode + " The value of answer is " + answer );
         opCode = -1 ;
         result = true ;
         MyPrint( "multOp() 4: pendingOpCode is " + pendingOpCode + " The value of answer is " + answer );
      }

   }
 
   public void divOp() {
      MyPrint( "divOp() 1a: opCode is " + opCode + " firstNumSet =s " + firstNumSet  +
                " pendingOpCode =s " + pendingOpCode );
      opCode = 1 ;

      MyPrint( "divOp() 1b: The opcode value is " + opCode +
                  " The value of firstNum is " + firstNum +
                  " The value of answer is " + answer ) ;

      if ( pendingOpCode == 1  ) {
         secondNum = enterBox.getText()  ;
         if ( secondNum.equals( "" ) ) {
            secondNum = "0.0" ;
         }
         convertNumsToDouble() ;
         if ( dNum1 == 0.0 ) {
            answer = dNum1  ;
         }
         else if ( dNum2 == 0.0 ) {
            answer = dNum1  ;
            setResults() ;
            JOptionPane.showMessageDialog( this, "The number " +
                    dNum2 + " cannot be used as a denometer.\n" +
                    "You cannot divide by zero.",
                    "Attempted to Divide by Zero",
                    JOptionPane.ERROR_MESSAGE );
         }
         else {
            answer = dNum1 / dNum2 ;
         }
         pendingOp = false ;
         setResults() ;
         MyPrint( "divOp() 2: opCode is " + opCode + " The value of answer is " + answer );
         secondNum = "0.0"  ;
         opCode = -1 ;
      }
      else if ( pendingOpCode == 0 || pendingOpCode == 2 || pendingOpCode == 3 ) {
         MyPrint( "divOp() 2a: In pendingOpCode =s " + pendingOpCode ) ;
         pendingOp = true ;
         opCodeMethod() ;
      }
      else if ( opCode == 1  ) {
         MyPrint( "divOp() 3: In pendingOp code. The opcode value is " + opCode ) ;
         firstNum = enterBox.getText()  ;
         if ( secondNum.equals( "" ) ) {
            secondNum = "0.0" ;
         }
         opCode = 1 ;
         pendingOp = false ;
         pendingOpCode = 1 ;
         opCode = -1 ;
         result = true ;
         MyPrint( "divOp() 4: pendingOpCode is " + pendingOpCode +
                                  " The value of answer is " + answer );
      }

   }
 
   public void subOp() {
      opCode = 2 ;

      MyPrint( "subOp() 1a: The opcode value is " + opCode +
                  " The value of firstNum is " + firstNum +
                  " The value of answer is " + answer +
                  " pendingOpCode =s " + pendingOpCode ) ;

      if ( pendingOpCode == 2  ) {
         secondNum = enterBox.getText()  ;
         if ( secondNum.equals( "" ) ) {
            secondNum = "0.0" ;
         }
         convertNumsToDouble() ;
         answer = dNum1 - dNum2 ;
         pendingOp = false ;
         setResults() ;
         MyPrint( "subOp() 2: opCode is " + opCode + " The value of answer is " + answer );
         secondNum = "0.0"  ;
         opCode = -1 ;

      }
      else if ( pendingOpCode == 0 || pendingOpCode == 1 || pendingOpCode == 3 ) {
         MyPrint( "subOp() 2a: In pendingOpCode =s " + pendingOpCode ) ;
         pendingOp = true ;
         opCodeMethod() ;
      }
      else if ( opCode == 2  ) {
         MyPrint( "subOp() 3: In pendingOp code. The opcode value is " + opCode ) ;
         firstNum = enterBox.getText()  ;
         if ( secondNum.equals( "" ) ) {
            secondNum = "0.0" ;
         }
       
         pendingOp = true ;
         pendingOpCode = 2 ;
         opCode = 2 ;
         result = true ;
         MyPrint( "subOp() 4: pendingOpCode is " + pendingOpCode +
                        " The value of answer is " + answer );
      }
   }
 
   public void plusOp() {
      opCode = 3 ;

      MyPrint( "plusOp() 1a: The opcode value is " + opCode +
                  " The value of firstNum is " + firstNum +
                  " The value of answer is " + answer ) ;

      if ( pendingOpCode == 3  ) {
         secondNum = enterBox.getText()  ;
         if ( secondNum.equals( "" ) ) {
            secondNum = "0.0" ;
         }
         convertNumsToDouble() ;
         answer = dNum1 + dNum2 ;
         pendingOp = false ;
         setResults() ;
         MyPrint( "plusOp() 2: opCode is " + opCode + " The value of answer is " + answer );
         secondNum = "0.0"  ;
         opCode = -1 ;

      }
      else if ( pendingOpCode == 0 || pendingOpCode == 1 || pendingOpCode == 2 ) {
         MyPrint( "plusOp() 3: In pendingOpCode =s " + pendingOpCode ) ;
         pendingOp = true ;
         opCodeMethod() ;
      }
      else if ( opCode == 3  ) {
         MyPrint( "plusOp() 4: In pendingOp code. The opcode value is " + opCode ) ;
         firstNum = enterBox.getText()  ;
         if ( secondNum.equals( "" ) ) {
            secondNum = "0.0" ;
         }
         opCode = 3 ;
         pendingOp = false ;
         pendingOpCode = 3 ;
         MyPrint( "plusOp() 5: opCode is " + opCode + " The value of answer is " + answer );
         opCode = -1 ;
         result = true ;
      }

   }
 
   public void convertNumsToDouble() {
      if ( !firstNum.equals( "" ) ) {
         dNum1 = Double.parseDouble( firstNum ) ;
      }
      if ( !secondNum.equals( "" ) ) {
         dNum2 = Double.parseDouble( secondNum ) ;
      }
      MyPrint( "convertNumsToDouble(): The value of dNum1 is " + dNum1 );
      MyPrint( "convertNumsToDouble(): The value of dNum2 is " + dNum2 );

   }

   public void MyPrint( String str )   {
      if ( myDiag )
         System.out.println( str );

   }
  
}
