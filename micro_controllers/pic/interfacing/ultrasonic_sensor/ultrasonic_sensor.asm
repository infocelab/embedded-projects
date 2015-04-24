
_interrupt:
	MOVWF      R15+0
	SWAPF      STATUS+0, 0
	CLRF       STATUS+0
	MOVWF      ___saveSTATUS+0
	MOVF       PCLATH+0, 0
	MOVWF      ___savePCLATH+0
	CLRF       PCLATH+0

;ultrasonic_sensor.c,20 :: 		void interrupt()
;ultrasonic_sensor.c,22 :: 		if(INTCON.RBIF == 1)                 //Makes sure that it is PORTB On-Change Interrupt
	BTFSS      INTCON+0, 0
	GOTO       L_interrupt0
;ultrasonic_sensor.c,24 :: 		INTCON.RBIE = 0;                   //Disable On-Change Interrupt
	BCF        INTCON+0, 3
;ultrasonic_sensor.c,25 :: 		if(PORTB.F4 == 1)                  //If ECHO is HIGH
	BTFSS      PORTB+0, 4
	GOTO       L_interrupt1
;ultrasonic_sensor.c,26 :: 		T1CON.F0 = 1;                    //Start Timer
	BSF        T1CON+0, 0
L_interrupt1:
;ultrasonic_sensor.c,27 :: 		if(PORTB.F4 == 0)                  //If ECHO is LOW
	BTFSC      PORTB+0, 4
	GOTO       L_interrupt2
;ultrasonic_sensor.c,29 :: 		T1CON.F0 = 0;                    //Stop Timer
	BCF        T1CON+0, 0
;ultrasonic_sensor.c,30 :: 		a = (TMR1L | (TMR1H<<8))/58.82;  //Calculate Distance
	MOVF       TMR1H+0, 0
	MOVWF      R0+1
	CLRF       R0+0
	MOVF       TMR1L+0, 0
	IORWF      R0+0, 1
	MOVLW      0
	IORWF      R0+1, 1
	CALL       _Word2Double+0
	MOVLW      174
	MOVWF      R4+0
	MOVLW      71
	MOVWF      R4+1
	MOVLW      107
	MOVWF      R4+2
	MOVLW      132
	MOVWF      R4+3
	CALL       _Div_32x32_FP+0
	CALL       _Double2Int+0
	MOVF       R0+0, 0
	MOVWF      _a+0
	MOVF       R0+1, 0
	MOVWF      _a+1
;ultrasonic_sensor.c,31 :: 		}
L_interrupt2:
;ultrasonic_sensor.c,32 :: 		}
L_interrupt0:
;ultrasonic_sensor.c,33 :: 		INTCON.RBIF = 0;                     //Clear PORTB On-Change Interrupt flag
	BCF        INTCON+0, 0
;ultrasonic_sensor.c,34 :: 		INTCON.RBIE = 1;                     //Enable PORTB On-Change Interrupt
	BSF        INTCON+0, 3
;ultrasonic_sensor.c,35 :: 		}
L_end_interrupt:
L__interrupt13:
	MOVF       ___savePCLATH+0, 0
	MOVWF      PCLATH+0
	SWAPF      ___saveSTATUS+0, 0
	MOVWF      STATUS+0
	SWAPF      R15+0, 1
	SWAPF      R15+0, 0
	RETFIE
; end of _interrupt

_main:

;ultrasonic_sensor.c,37 :: 		void main()
;ultrasonic_sensor.c,40 :: 		Lcd_Init();
	CALL       _Lcd_Init+0
;ultrasonic_sensor.c,41 :: 		Lcd_Cmd(_LCD_CLEAR);                 // Clear display
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;ultrasonic_sensor.c,42 :: 		Lcd_Cmd(_LCD_CURSOR_OFF);            // Cursor off
	MOVLW      12
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;ultrasonic_sensor.c,44 :: 		TRISB = 0b00010000;
	MOVLW      16
	MOVWF      TRISB+0
;ultrasonic_sensor.c,45 :: 		INTCON.GIE = 1;                      //Global Interrupt Enable
	BSF        INTCON+0, 7
;ultrasonic_sensor.c,46 :: 		INTCON.RBIF = 0;                     //Clear PORTB On-Change Interrupt Flag
	BCF        INTCON+0, 0
;ultrasonic_sensor.c,47 :: 		INTCON.RBIE = 1;                     //Enable PORTB On-Change Interrupt
	BSF        INTCON+0, 3
;ultrasonic_sensor.c,49 :: 		Lcd_Out(1,1,"Developed By");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr1_ultrasonic_sensor+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;ultrasonic_sensor.c,50 :: 		Lcd_Out(2,1,"CELAB");
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr2_ultrasonic_sensor+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;ultrasonic_sensor.c,52 :: 		Delay_ms(3000);
	MOVLW      16
	MOVWF      R11+0
	MOVLW      57
	MOVWF      R12+0
	MOVLW      13
	MOVWF      R13+0
L_main3:
	DECFSZ     R13+0, 1
	GOTO       L_main3
	DECFSZ     R12+0, 1
	GOTO       L_main3
	DECFSZ     R11+0, 1
	GOTO       L_main3
	NOP
	NOP
;ultrasonic_sensor.c,53 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;ultrasonic_sensor.c,55 :: 		T1CON = 0x10;                        //Initializing Timer Module
	MOVLW      16
	MOVWF      T1CON+0
;ultrasonic_sensor.c,57 :: 		while(1)
L_main4:
;ultrasonic_sensor.c,59 :: 		TMR1H = 0;                  //Sets the Initial Value of Timer
	CLRF       TMR1H+0
;ultrasonic_sensor.c,60 :: 		TMR1L = 0;                  //Sets the Initial Value of Timer
	CLRF       TMR1L+0
;ultrasonic_sensor.c,62 :: 		PORTB.F0 = 1;               //TRIGGER HIGH
	BSF        PORTB+0, 0
;ultrasonic_sensor.c,63 :: 		Delay_us(10);               //10uS Delay
	MOVLW      3
	MOVWF      R13+0
L_main6:
	DECFSZ     R13+0, 1
	GOTO       L_main6
;ultrasonic_sensor.c,64 :: 		PORTB.F0 = 0;               //TRIGGER LOW
	BCF        PORTB+0, 0
;ultrasonic_sensor.c,66 :: 		while(!PORTB.F4);           //Waiting for Echo
L_main7:
	BTFSC      PORTB+0, 4
	GOTO       L_main8
	GOTO       L_main7
L_main8:
;ultrasonic_sensor.c,67 :: 		T1CON.F0 = 1;               //Timer Starts
	BSF        T1CON+0, 0
;ultrasonic_sensor.c,68 :: 		while(PORTB.F4);            //Waiting for Echo goes LOW
L_main9:
	BTFSS      PORTB+0, 4
	GOTO       L_main10
	GOTO       L_main9
L_main10:
;ultrasonic_sensor.c,69 :: 		T1CON.F0 = 0;               //Timer Stops
	BCF        T1CON+0, 0
;ultrasonic_sensor.c,71 :: 		a = (TMR1L | (TMR1H<<8));   //Reads Timer Value
	MOVF       TMR1H+0, 0
	MOVWF      R0+1
	CLRF       R0+0
	MOVF       TMR1L+0, 0
	IORWF      R0+0, 1
	MOVLW      0
	IORWF      R0+1, 1
	MOVF       R0+0, 0
	MOVWF      _a+0
	MOVF       R0+1, 0
	MOVWF      _a+1
;ultrasonic_sensor.c,72 :: 		a = a/58.82;                //Converts Time to Distance
	CALL       _Int2Double+0
	MOVLW      174
	MOVWF      R4+0
	MOVLW      71
	MOVWF      R4+1
	MOVLW      107
	MOVWF      R4+2
	MOVLW      132
	MOVWF      R4+3
	CALL       _Div_32x32_FP+0
	CALL       _Double2Int+0
	MOVF       R0+0, 0
	MOVWF      _a+0
	MOVF       R0+1, 0
	MOVWF      _a+1
;ultrasonic_sensor.c,74 :: 		if(a>=2 && a<=400)          //Check whether the result is valid or not
	INCF       R0+0, 1
	BTFSC      STATUS+0, 2
	INCF       R0+1, 1
	MOVF       R0+0, 0
	MOVWF      _a+0
	MOVF       R0+1, 0
	MOVWF      _a+1
;ultrasonic_sensor.c,76 :: 		IntToStr(a,txt);
	MOVF       R0+0, 0
	MOVWF      FARG_IntToStr_input+0
	MOVF       R0+1, 0
	MOVWF      FARG_IntToStr_input+1
	MOVLW      main_txt_L0+0
	MOVWF      FARG_IntToStr_output+0
	CALL       _IntToStr+0
;ultrasonic_sensor.c,77 :: 		Ltrim(txt);
	MOVLW      main_txt_L0+0
	MOVWF      FARG_Ltrim_string+0
	CALL       _Ltrim+0
;ultrasonic_sensor.c,78 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;ultrasonic_sensor.c,79 :: 		Lcd_Out(1,1,"Distance = ");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr3_ultrasonic_sensor+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;ultrasonic_sensor.c,80 :: 		Lcd_Out(1,12,txt);
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      12
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      main_txt_L0+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;ultrasonic_sensor.c,81 :: 		Lcd_Out(1,15,"cm");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      15
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr4_ultrasonic_sensor+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;ultrasonic_sensor.c,83 :: 		Delay_ms(400);
	MOVLW      3
	MOVWF      R11+0
	MOVLW      8
	MOVWF      R12+0
	MOVLW      119
	MOVWF      R13+0
L_main11:
	DECFSZ     R13+0, 1
	GOTO       L_main11
	DECFSZ     R12+0, 1
	GOTO       L_main11
	DECFSZ     R11+0, 1
	GOTO       L_main11
;ultrasonic_sensor.c,84 :: 		}
	GOTO       L_main4
;ultrasonic_sensor.c,85 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
