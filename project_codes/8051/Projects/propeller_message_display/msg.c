#define ON 0x00
#define OFF 0xFF
#define U_SEC 70
#define ONE_SEC 1000
#define MS 1
#define US 999

//----------------------------------------------------------------------display_W()------------------------------------------------------------------------------------

display_W()
{
    //--------------col-1--------------
    P2 = ON;                           // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                          // Turn Off diodes on PORT2 zz
    //--------------col-2--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_7_bit = OFF;
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_6_bit = OFF;
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
     //--------------col-9--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
     //--------------col-9--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
     //--------------col-9--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_5_bit = OFF;
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2_4_bit = OFF;
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-15--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-15--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-15--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-15--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-16--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-17--------------
    P2_5_bit = OFF;
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-19--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-20--------------
    P2_6_bit = OFF;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-21--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
     //--------------col-21--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
     //--------------col-21--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
     //--------------col-21--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-22--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-23--------------
    P2 = ON;                            // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                           // Turn Off diodes on PORT2
    //--------------col-23--------------
    P2 = ON;                            // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                           // Turn Off diodes on PORT2
    //----------------------------------
}


//----------------------------------------------------------------------display_E()------------------------------------------------------------------------------------

display_E()
{
    //--------------col-1--------------
    P2 = ON;                             // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                            // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_3_bit = OFF;
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
    //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
    //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
    //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    P2_0_bit = OFF;
    P2_1_bit = OFF;
    P2_6_bit = OFF;
    P2_7_bit = OFF;
    //---------------------------------
}

//----------------------------------------------------------------------display_L()------------------------------------------------------------------------------------

display_L()
{
    //--------------col-1--------------
    P2 = ON;                             // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                            // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2_6_bit = ON;
    P2_7_bit = ON;
    //--------------col-14--------------
    P2_6_bit = ON;
    P2_7_bit = ON;
    //--------------col-14--------------
    P2_6_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    P2_6_bit = OFF;
    P2_7_bit = OFF;
    //---------------------------------
}

//----------------------------------------------------------------------display_C()------------------------------------------------------------------------------------

display_C()
{
    //--------------col-1--------------
    P2 = ON;                           // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                         // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
     //--------------col-2--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
     //--------------col-2--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
     //--------------col-2--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
     //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
     //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
     //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    P2_0_bit = OFF;
    P2_1_bit = OFF;
    P2_6_bit = OFF;
    P2_7_bit = OFF;
    //----------------------------------
}

//----------------------------------------------------------------------display_O()------------------------------------------------------------------------------------

display_O()
{
    //--------------col-1--------------
    P2 = ON;                           // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                          // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2 = ON;                            // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                           // Turn Off diodes on PORT2
     //--------------col-14--------------
    P2 = ON;                            // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                           // Turn Off diodes on PORT2
    //----------------------------------
}

//----------------------------------------------------------------------display_M()------------------------------------------------------------------------------------

display_M()
{
    //--------------col-1--------------
    P2 = ON;                           // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                          // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_0_bit = OFF;
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_1_bit = OFF;
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_2_bit = OFF;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2_3_bit = OFF;
    P2_2_bit = ON;
    Delay_us(U_SEC);

    //--------------col-15--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-15--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-15--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-16--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-17--------------
    P2_2_bit = OFF;
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-19--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-20--------------
    P2_1_bit = OFF;
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-21--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-21--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-21--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-22--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-23--------------
    P2 = ON;                            // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                           // Turn Off diodes on PORT2
    //----------------------------------
}

//----------------------------------------------------------------------display_T()------------------------------------------------------------------------------------

display_T()
{
    //--------------col-1--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    Delay_us(U_SEC);
    P2_1_bit = OFF;
    //--------------col-2--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2 = ON;
    Delay_us(U_SEC);
    P2 = OFF;
    //--------------col-8--------------
    P2_0_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_0_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    Delay_us(U_SEC);
    P2_0_bit = OFF;
    P2_1_bit = OFF;
    //---------------------------------
}


//----------------------------------------------------------------------display_H()------------------------------------------------------------------------------------

display_H()
{
    //--------------col-1--------------
    P2 = ON;                           // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                          // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2 = ON;
    Delay_us(U_SEC);
    P2 = OFF;
    //---------------------------------

}

//----------------------------------------------------------------------display_N()------------------------------------------------------------------------------------

display_N()
{
    //--------------col-1--------------
    P2 = ON;                           // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                          // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_1_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_1_bit = OFF;
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_2_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_2_bit = OFF;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_3_bit = OFF;
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_4_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2_4_bit = OFF;
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-15--------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-16-------------
    P2_5_bit = ON;
    Delay_us(U_SEC);
    //--------------col-17--------------
    P2_5_bit = OFF;
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-18--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-19--------------
    P2_6_bit = ON;
    Delay_us(U_SEC);
    //--------------col-20--------------
    P2 = ON;                            // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                           // Turn Off diodes on PORT2
    //----------------------------------
}

//----------------------------------------------------------------------display_B()------------------------------------------------------------------------------------

display_B()
{
    //--------------col-1--------------
    P2 = ON;                           // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                         // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2 = ON;
    Delay_us(U_SEC);
    P2 = OFF;
    //---------------------------------
}

//----------------------------------------------------------------------display_A()------------------------------------------------------------------------------------

display_A()
{
    //--------------col-1--------------
    P2 = ON;                           // Turn ON diodes on PORT2
    Delay_us(U_SEC);
    P2 = OFF;                          // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-14--------------
    P2 = ON;
    Delay_us(U_SEC);
    P2 = OFF;
    //---------------------------------

}

//----------------------------------------------------------------------display_S()------------------------------------------------------------------------------------

display_S()
{
    //--------------col-1--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_2_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    P2 = OFF;                          // Turn Off diodes on PORT2
    //--------------col-2--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_0_bit = ON;
    P2_3_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    P2_3_bit = OFF;
    //--------------col-8--------------
    P2_0_bit = ON;
    P2_4_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_0_bit = ON;
    P2_4_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-10--------------
    P2_0_bit = ON;
    P2_4_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-11--------------
    P2_0_bit = ON;
    P2_4_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-12--------------
    P2_0_bit = ON;
    P2_4_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    //--------------col-13--------------
    P2_0_bit = ON;
    P2_4_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    P2_4_bit = OFF;
    //--------------col-14--------------
    P2_0_bit = ON;
    P2_1_bit = ON;
    P2_5_bit = ON;
    P2_6_bit = ON;
    P2_7_bit = ON;
    Delay_us(U_SEC);
    P2 = OFF;                           // Turn Off diodes on PORT2
    //----------------------------------
}

//----------------------------------------------------------------------display_'-'()------------------------------------------------------------------------------------

display_()
{
    //--------------col-1--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-2--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-3--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-4--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-5--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-6--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-7--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-8--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    //--------------col-9--------------
    P2_3_bit = ON;
    Delay_us(U_SEC);
    P2_3_bit = OFF;
    //---------------------------------
}


//----------------------------------------------------------------------void main()------------------------------------------------------------------------------------


void main()
{

    P0 = OFF;                           // Turn Off diodes on PORT0
    P1 = OFF;                           // Turn Off diodes on PORT1
    P2 = OFF;                           // Turn Off diodes on PORT2
    P3 = OFF;                           // Turn Off diodes on PORT3
    Delay_ms(ONE_SEC);

    while(1)
    {
        display_W();
        P2 = OFF;
        Delay_us(1000);
        display_E();
        P2 = OFF;
        Delay_us(1000);
        display_L();
        P2 = OFF;
        Delay_us(1000);
        display_C();
        P2 = OFF;
        Delay_us(1000);
        display_O();
        P2 = OFF;
        Delay_us(1000);
        display_M();
        P2 = OFF;
        Delay_us(1000);
        display_E();
        P2 = OFF;
        Delay_us(1000);
        display_T();
        P2 = OFF;
        Delay_us(1000);
        display_O();
        P2 = OFF;
        Delay_us(1000);
        display_T();
        P2 = OFF;
        Delay_us(1000);
        display_E();
        P2 = OFF;
        Delay_us(1000);
        display_C();
        P2 = OFF;
        Delay_us(1000);
        display_H();
        P2 = OFF;
        Delay_us(1000);
        display_N();
        P2 = OFF;
        Delay_us(1000);
        display_O();
        P2 = OFF;
        Delay_us(1000);
        display_B();
        P2 = OFF;
        Delay_us(1000);
        display_L();
        P2 = OFF;
        Delay_us(1000);
        display_A();
        P2 = OFF;
        Delay_us(1000);
        display_S();
        P2 = OFF;
        Delay_us(1000);
        display_T();
        P2 = OFF;
        Delay_us(1000);
        /*display_-();
        P2 = OFF;
        Delay_us(1000);
        display_2();
        P2 = OFF;
        Delay_us(1000);
        display_0();
        P2 = OFF;
        Delay_us(1();
        P2 = OFF;
        Delay_us(1000);
        display_3();
        P2 = OFF;
        Delay_us(1000);*/
    }
}
