			//CIRCULAR DISPLAY
#include<stdio.h>
#include<process.h>
#include<conio.h>
#include<math.h>
#include<dos.h>
#include<graphics.h>

//parameters for displaying rectangular board:
#define ROWS 32
#define COLS 360
#define INITY 200
#define CELL_SIZE 5

//parameters for displaying circular board:
#define INNER_CIRCLE_RADIUS 20
#define PI 3.14159
int origin_x=0;
int origin_y=0;

union REGS in,out;
int INITX=0;
int data_arr[ROWS][COLS];

void circular_board();

int callmouse()                   // To initialise the MOUSE
{
 in.x.ax=1;
 int86(51,&in,&out);
 return 1;
}

void board()
{
 circular_board();
}

void showtext(int x, int y)
{
 int i,j;
 int outer_circle_radius;
 double theta;
 int line_x,line_y;
 char c[8]="WELCOME";

  setcolor(RED);
  settextstyle(DEFAULT_FONT,HORIZ_DIR,5);
  outtextxy(x+10,y,c);
}

void circular_board()
{
 circle(origin_x,origin_y,INNER_CIRCLE_RADIUS);
 circle(origin_x,origin_y,ROWS*CELL_SIZE+INNER_CIRCLE_RADIUS);

/* for(j=0;j<ROWS;j++)
  {
  outer_circle_radius=j*CELL_SIZE+INNER_CIRCLE_RADIUS;
  for(i=0; i<COLS && !kbhit(); i++)
  {
   theta=i*PI/180 + (360/COLS);
   line_x=origin_x+outer_circle_radius*cos(theta);
   line_y=origin_y+outer_circle_radius*sin(theta);
  // if(i==0)
  // line(origin_x,origin_y,line_x,line_y);
    //fillellipse(line_x,line_y,1,1);
   if(data_arr[j][i]==1)
   {
    putpixel(line_x,line_y,RED);
   }
  }
 }   */

}

void pos(int &x,int &y,int &cl)
{
      in.x.ax=3;
      int86(51,&in,&out);
      cl=out.x.bx;
      x=out.x.cx;
      y=out.x.dx;
}

void scan()
{
 int i,j,outer_circle_radius;
 double theta;
 int line_x,line_y;
 for(j=0;j<ROWS;j++)
  {
  outer_circle_radius=CELL_SIZE+INNER_CIRCLE_RADIUS;
  for(i=0; i<COLS && !kbhit(); i++)
  {
   theta=i*PI/180 + (360/COLS);
   line_x=origin_x+outer_circle_radius*cos(theta);
   line_y=origin_y+outer_circle_radius*sin(theta);
   if(i==0)
   line(origin_x,origin_y,line_x,line_y);
    //fillellipse(line_x,line_y,1,1);
   if(getpixel(line_x,line_y) == RED)
   {
    data_arr[j][i]=1;
   }
  }
 }
}

void make(int x, int y, int click)
{
 int i,j;
 double theta;
 int line_x,line_y;
 int outer_circle_radius;

 if(click==1)
 {
  showtext(x,y);
  scan();
  board();
  //fillellipse(x,y,3,3);
 }

  /*
  printf("\n\n\n\n\n");
  for(i=0;i<ROWS;i++)
  {
   for(j=0;j<COLS;j++)
   {
    printf("%d",data_arr[i][j]);
   }
   printf("\n");
  }               */
}

void main()
{
 int xpos,ypos,click;
 int driver=DETECT,mode;
 int i,j;
 int key;
 initgraph(&driver,&mode,"\\tc\\bgi");
 origin_x = getmaxx()/2;
 origin_y = getmaxy()/2;
 setfillstyle(SOLID_FILL,RED);
 board();

 callmouse();
 for(i=0;i<ROWS;i++)
 {
  for(j=0;j<COLS;j++)
  {
   data_arr[i][j]=0;
  }
 }
 while(1)
 {

  pos(xpos,ypos,click);
  if(kbhit())
  {
   key=getch();
   if(key==13||key==27)
   exit(1);
   if(key==77)
   {
    INITX-=CELL_SIZE;
    clearviewport();
    board();
   }
   if(key==75)
   {
    INITX+=CELL_SIZE;
    clearviewport();
    board();
   }
  }
  gotoxy(1,1);
  printf("Mouse Position: %d,%d",xpos,ypos);
  printf("\n\t Click:%d",click);
  printf("\n\t%d\t",key);
  make(xpos,ypos,click);
 // board();
  //INITX-=CELL_SIZE;
  //cleardevice();
 }

 //closegraph();
}