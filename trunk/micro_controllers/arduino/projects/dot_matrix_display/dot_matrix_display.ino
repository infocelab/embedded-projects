int speed = 100; //the delay time in milliseconds

int pauseDelay = 1;    //the number of milliseconds to display each scanned line

//Pin Definitions
int rowA[] = {9,10,11,12,13,A0,A1,A2,};          //An Array defining which pin each row is attached to
                                         //(rows are common anode (drive HIGH))
int colA[] = {A3,2,3,4,8,7,6,5};  //An Array defining which pin each column is attached to
                                         //(columns are common cathode (drive LOW))

//The array used to hold a bitmap of the display 
//(if you wish to do something other than scrolling marque change the data in this
//variable then display)
byte data[] = {0,0,0,0,0,0,0,0};    


//Setup runs once when power is applied
void setup()
{ 
  Serial.begin(9600);         //Open the Serial port for debugging
  for(int i = 0; i <8; i++){  //Set the 16 pins used to control the array as OUTPUTs
    pinMode(rowA[i], OUTPUT);
    pinMode(colA[i], OUTPUT);
  }
}

void make_A()
{
  data[0] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B00111100; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B01111110; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
}

void make_B()
{
  data[0] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B11111100; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B01111100; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B11111100; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
}

void make_C()
{
  data[0] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B00111100; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B01000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B01000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B01000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B00111100; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
}

void make_D()
{
  data[0] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B11111100; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B01000010; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B11111100; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
}


void make_E()
{
  data[0] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B11111110; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B10000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B11111000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B10000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B11111110; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
}


void make_F()
{
  data[0] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B11111110; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B10000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B11111000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B10000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B10000000; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B10000000; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
}


void make_G()
{
  data[0] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B11111110; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B10000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B10011110; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B11111100; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
}


void make_H()
{
  data[0] = B00000000; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B11111110; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B10000010; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
}
//repeats   
void loop()
{
 //Example #1 - test pattern
 //Run a small test program which lights up each light in time
  //test();
 make_A();
 make_B();
 make_C();
 make_D();
 make_E();
 make_F();
 make_G();
 make_H();
 
 
 //Example #2 - static image
 //Display a defined bitmap
/*
  data[0] = B10101010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[1] = B01010101; //row 1s bit mask (1 LED is on 0 LED is off)
  data[2] = B10101010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[3] = B01010101; //row 1s bit mask (1 LED is on 0 LED is off)
  data[4] = B10101010; //row 1s bit mask (1 LED is on 0 LED is off)
  data[5] = B01010101; //row 1s bit mask (1 LED is on 0 LED is off)
  data[6] = B10101010; //row 1s bit mask (1 LED is on 0 LED is off)  
  data[7] = B01010101; //row 1s bit mask (1 LED is on 0 LED is off)  
  showSprite(speed); 
  */
}

//An array to store power values to act as bit masks
const int powers[] = {1,2,4,8,16,32,64,128};

//Runs a pattern where each LED is lit one after another
void test(){
  for(int i = 0; i < 8; i++){
    for(int ii = 0; ii< 8; ii++){
    data[i] = data[i]+ powers[ii];   //Goes through each row of lights lighting each column one after another
    showSprite(speed);
    }
  }
  
  for(int i = 0; i < 8; i++){
    for(int ii = 0; ii< 8; ii++){
    data[i] = data[i] - powers[ii];   //Goes through each row of lights turning off each column one after another
    showSprite(speed);
    }
  }  
}

void showSprite(int speed2){
 for(int iii = 0; iii < speed2; iii++){                 //show the current frame speed2 times
  for(int column = 0; column < 8; column++){            //iterate through each column
   for(int i = 0; i < 8; i++){                          
       digitalWrite(rowA[i], LOW);                      //turn off all row pins  
   }
   for(int i = 0; i < 8; i++){ //Set only the one pin
     if(i == column){     digitalWrite(colA[i], LOW);}  //turns the current row on
     else{                digitalWrite(colA[i], HIGH); }//turns the rest of the rows off
   }

   for(int row = 0; row < 8; row++){                    //iterate through each pixel in the current column
    int bit = (data[column] >> row) & 1;
    if(bit == 1){ 
       digitalWrite(rowA[row], HIGH);                   //if the bit in the data array is set turn the LED on
    }

   }
   delay(pauseDelay);                       //leave the column on for pauseDelay microseconds (too high a delay causes flicker)
  } 
 }
}
