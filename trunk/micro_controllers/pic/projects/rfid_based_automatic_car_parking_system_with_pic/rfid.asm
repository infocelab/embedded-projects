
_main:

;rfid.c,19 :: 		void main()
;rfid.c,23 :: 		trisb=0x00;
	CLRF       TRISB+0
;rfid.c,24 :: 		UART1_Init(9600);                 // Initialize UART, 9600 baud rate
	MOVLW      25
	MOVWF      SPBRG+0
	BSF        TXSTA+0, 2
	CALL       _UART1_Init+0
;rfid.c,26 :: 		Lcd_Init(); // Initialize LCD
	CALL       _Lcd_Init+0
;rfid.c,27 :: 		Lcd_Cmd(_LCD_CLEAR); // Clear display
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,28 :: 		Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
	MOVLW      12
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,29 :: 		Lcd_Out(1,1,"Welcome to RFID ");//Write text'Hello World' in first row
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr1_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,30 :: 		delay_ms(1000);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
	MOVWF      R13+0
L_main0:
	DECFSZ     R13+0, 1
	GOTO       L_main0
	DECFSZ     R12+0, 1
	GOTO       L_main0
	DECFSZ     R11+0, 1
	GOTO       L_main0
	NOP
	NOP
;rfid.c,31 :: 		Lcd_Out(2,1,"Security System");//Write text'Hello World' in first row
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr2_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,32 :: 		delay_ms(1000);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
	MOVWF      R13+0
L_main1:
	DECFSZ     R13+0, 1
	GOTO       L_main1
	DECFSZ     R12+0, 1
	GOTO       L_main1
	DECFSZ     R11+0, 1
	GOTO       L_main1
	NOP
	NOP
;rfid.c,33 :: 		Lcd_Cmd(_LCD_CLEAR); // Clear display
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,34 :: 		Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
	MOVLW      12
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,35 :: 		Lcd_Out(1,1,"PLZ Show Your RFID ");//Write text'Hello World' in first row
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr3_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,36 :: 		delay_ms(1000);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
	MOVWF      R13+0
L_main2:
	DECFSZ     R13+0, 1
	GOTO       L_main2
	DECFSZ     R12+0, 1
	GOTO       L_main2
	DECFSZ     R11+0, 1
	GOTO       L_main2
	NOP
	NOP
;rfid.c,37 :: 		Lcd_Out(2,1,"Card");//Write text'Hello World' in first row
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr4_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,38 :: 		while(1)
L_main3:
;rfid.c,40 :: 		if(UART1_Data_Ready())          // If UART Data Ready
	CALL       _UART1_Data_Ready+0
	MOVF       R0+0, 0
	BTFSC      STATUS+0, 2
	GOTO       L_main5
;rfid.c,42 :: 		for(i=0;i<12;)                // To Read 12 characters
	CLRF       main_i_L0+0
	CLRF       main_i_L0+1
L_main6:
	MOVLW      128
	XORWF      main_i_L0+1, 0
	MOVWF      R0+0
	MOVLW      128
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main26
	MOVLW      12
	SUBWF      main_i_L0+0, 0
L__main26:
	BTFSC      STATUS+0, 0
	GOTO       L_main7
;rfid.c,44 :: 		if(UART1_Data_Ready())
	CALL       _UART1_Data_Ready+0
	MOVF       R0+0, 0
	BTFSC      STATUS+0, 2
	GOTO       L_main9
;rfid.c,46 :: 		rfid[i] = UART1_Read();
	MOVF       main_i_L0+0, 0
	ADDLW      _rfid+0
	MOVWF      FLOC__main+0
	CALL       _UART1_Read+0
	MOVF       FLOC__main+0, 0
	MOVWF      FSR
	MOVF       R0+0, 0
	MOVWF      INDF+0
;rfid.c,47 :: 		i++;
	INCF       main_i_L0+0, 1
	BTFSC      STATUS+0, 2
	INCF       main_i_L0+1, 1
;rfid.c,48 :: 		}
L_main9:
;rfid.c,49 :: 		}
	GOTO       L_main6
L_main7:
;rfid.c,50 :: 		if((rfid[0] ^ rfid[2] ^ rfid[4] ^ rfid[6] ^ rfid[8] == rfid[10]) && (rfid[1] ^ rfid[3] ^ rfid[5] ^ rfid[7] ^ rfid[9] == rfid[11]))
	MOVF       _rfid+2, 0
	XORWF      _rfid+0, 0
	MOVWF      R0+0
	MOVF       _rfid+4, 0
	XORWF      R0+0, 1
	MOVF       _rfid+6, 0
	XORWF      R0+0, 0
	MOVWF      R1+0
	MOVF       _rfid+8, 0
	XORWF      _rfid+10, 0
	MOVLW      1
	BTFSS      STATUS+0, 2
	MOVLW      0
	MOVWF      R0+0
	MOVF       R1+0, 0
	XORWF      R0+0, 1
	BTFSC      STATUS+0, 2
	GOTO       L_main12
	MOVF       _rfid+3, 0
	XORWF      _rfid+1, 0
	MOVWF      R0+0
	MOVF       _rfid+5, 0
	XORWF      R0+0, 1
	MOVF       _rfid+7, 0
	XORWF      R0+0, 0
	MOVWF      R1+0
	MOVF       _rfid+9, 0
	XORWF      _rfid+11, 0
	MOVLW      1
	BTFSS      STATUS+0, 2
	MOVLW      0
	MOVWF      R0+0
	MOVF       R1+0, 0
	XORWF      R0+0, 1
	BTFSC      STATUS+0, 2
	GOTO       L_main12
L__main24:
;rfid.c,52 :: 		Lcd_Out(2,1,rfid);
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      _rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,53 :: 		delay_ms(1000);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
	MOVWF      R13+0
L_main13:
	DECFSZ     R13+0, 1
	GOTO       L_main13
	DECFSZ     R12+0, 1
	GOTO       L_main13
	DECFSZ     R11+0, 1
	GOTO       L_main13
	NOP
	NOP
;rfid.c,54 :: 		if(rfid[0] == '1' && rfid[1] == '3' && rfid[2] == '0' && rfid[3] == '0' && rfid[4] == '4' &&  rfid[5] == 'A' && rfid[6] == '0' && rfid[7] == '4' && rfid[8] == 'A' && rfid[9] == 'B'  && rfid[10] == 'F' && rfid[11] == '6' )
	MOVF       _rfid+0, 0
	XORLW      49
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+1, 0
	XORLW      51
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+2, 0
	XORLW      48
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+3, 0
	XORLW      48
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+4, 0
	XORLW      52
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+5, 0
	XORLW      65
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+6, 0
	XORLW      48
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+7, 0
	XORLW      52
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+8, 0
	XORLW      65
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+9, 0
	XORLW      66
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+10, 0
	XORLW      70
	BTFSS      STATUS+0, 2
	GOTO       L_main16
	MOVF       _rfid+11, 0
	XORLW      54
	BTFSS      STATUS+0, 2
	GOTO       L_main16
L__main23:
;rfid.c,56 :: 		Lcd_Cmd(_LCD_CLEAR); // Clear display
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,57 :: 		Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
	MOVLW      12
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,58 :: 		Lcd_Out(1,1,"ACCESS GRANTED");//Write text'Hello World' in first row
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr5_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,59 :: 		portb.rb0=0xff;
	BSF        PORTB+0, 0
;rfid.c,60 :: 		delay_ms(2000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main17:
	DECFSZ     R13+0, 1
	GOTO       L_main17
	DECFSZ     R12+0, 1
	GOTO       L_main17
	DECFSZ     R11+0, 1
	GOTO       L_main17
	NOP
	NOP
;rfid.c,61 :: 		portb.rb0=0x00;
	BCF        PORTB+0, 0
;rfid.c,62 :: 		delay_ms(2000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main18:
	DECFSZ     R13+0, 1
	GOTO       L_main18
	DECFSZ     R12+0, 1
	GOTO       L_main18
	DECFSZ     R11+0, 1
	GOTO       L_main18
	NOP
	NOP
;rfid.c,63 :: 		}
	GOTO       L_main19
L_main16:
;rfid.c,66 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,67 :: 		Lcd_Out(1,1,"ACCESS DENIED");//Write text'Hello World' in first row
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr6_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,68 :: 		delay_ms(2000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main20:
	DECFSZ     R13+0, 1
	GOTO       L_main20
	DECFSZ     R12+0, 1
	GOTO       L_main20
	DECFSZ     R11+0, 1
	GOTO       L_main20
	NOP
	NOP
;rfid.c,69 :: 		}
L_main19:
;rfid.c,70 :: 		}
L_main12:
;rfid.c,71 :: 		delay_ms(1000);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
	MOVWF      R13+0
L_main21:
	DECFSZ     R13+0, 1
	GOTO       L_main21
	DECFSZ     R12+0, 1
	GOTO       L_main21
	DECFSZ     R11+0, 1
	GOTO       L_main21
	NOP
	NOP
;rfid.c,72 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,73 :: 		Lcd_Out(1,1,"PLZ Show RFID ");//Write text'Hello World' in first row
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr7_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,74 :: 		delay_ms(2000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main22:
	DECFSZ     R13+0, 1
	GOTO       L_main22
	DECFSZ     R12+0, 1
	GOTO       L_main22
	DECFSZ     R11+0, 1
	GOTO       L_main22
	NOP
	NOP
;rfid.c,75 :: 		Lcd_Out(2,1,"Card ");//Write text'Hello World' in first row
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr8_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,77 :: 		}
L_main5:
;rfid.c,78 :: 		}
	GOTO       L_main3
;rfid.c,79 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
