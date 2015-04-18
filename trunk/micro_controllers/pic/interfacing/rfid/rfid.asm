
_main:

;rfid.c,17 :: 		void main()
;rfid.c,20 :: 		Lcd_Init(); // Initialize LCD
	CALL       _Lcd_Init+0
;rfid.c,21 :: 		Lcd_Cmd(_LCD_CLEAR); // Clear display
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,22 :: 		Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
	MOVLW      12
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;rfid.c,23 :: 		Lcd_Out(1,1,"rfid tag reader");//Write text'Hello World' in first row
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr1_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,25 :: 		UART1_Init(9600);                 // Initialize UART, 9600 baud rate
	MOVLW      25
	MOVWF      SPBRG+0
	BSF        TXSTA+0, 2
	CALL       _UART1_Init+0
;rfid.c,27 :: 		rfid[12] = '\0';                  // String Terminating Character
	CLRF       main_rfid_L0+12
;rfid.c,29 :: 		while(1)                          // Infinite Loop
L_main0:
;rfid.c,31 :: 		if(UART1_Data_Ready())          // If UART Data Ready
	CALL       _UART1_Data_Ready+0
	MOVF       R0+0, 0
	BTFSC      STATUS+0, 2
	GOTO       L_main2
;rfid.c,33 :: 		for(i=0;i<12;)                // To Read 12 characters
	CLRF       main_i_L0+0
L_main3:
	MOVLW      12
	SUBWF      main_i_L0+0, 0
	BTFSC      STATUS+0, 0
	GOTO       L_main4
;rfid.c,35 :: 		if(UART1_Data_Ready())
	CALL       _UART1_Data_Ready+0
	MOVF       R0+0, 0
	BTFSC      STATUS+0, 2
	GOTO       L_main6
;rfid.c,37 :: 		rfid[i] = UART1_Read();
	MOVF       main_i_L0+0, 0
	ADDLW      main_rfid_L0+0
	MOVWF      FLOC__main+0
	CALL       _UART1_Read+0
	MOVF       FLOC__main+0, 0
	MOVWF      FSR
	MOVF       R0+0, 0
	MOVWF      INDF+0
;rfid.c,38 :: 		i++;
	INCF       main_i_L0+0, 1
;rfid.c,39 :: 		}
L_main6:
;rfid.c,40 :: 		}
	GOTO       L_main3
L_main4:
;rfid.c,42 :: 		if((rfid[0] ^ rfid[2] ^ rfid[4] ^ rfid[6] ^ rfid[8] == rfid[10]) && (rfid[1] ^ rfid[3] ^ rfid[5] ^ rfid[7] ^ rfid[9] == rfid[11]))
	MOVF       main_rfid_L0+2, 0
	XORWF      main_rfid_L0+0, 0
	MOVWF      R0+0
	MOVF       main_rfid_L0+4, 0
	XORWF      R0+0, 1
	MOVF       main_rfid_L0+6, 0
	XORWF      R0+0, 0
	MOVWF      R1+0
	MOVF       main_rfid_L0+8, 0
	XORWF      main_rfid_L0+10, 0
	MOVLW      1
	BTFSS      STATUS+0, 2
	MOVLW      0
	MOVWF      R0+0
	MOVF       R1+0, 0
	XORWF      R0+0, 1
	BTFSC      STATUS+0, 2
	GOTO       L_main9
	MOVF       main_rfid_L0+3, 0
	XORWF      main_rfid_L0+1, 0
	MOVWF      R0+0
	MOVF       main_rfid_L0+5, 0
	XORWF      R0+0, 1
	MOVF       main_rfid_L0+7, 0
	XORWF      R0+0, 0
	MOVWF      R1+0
	MOVF       main_rfid_L0+9, 0
	XORWF      main_rfid_L0+11, 0
	MOVLW      1
	BTFSS      STATUS+0, 2
	MOVLW      0
	MOVWF      R0+0
	MOVF       R1+0, 0
	XORWF      R0+0, 1
	BTFSC      STATUS+0, 2
	GOTO       L_main9
L__main11:
;rfid.c,44 :: 		Lcd_Out(2,1,rfid);
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      main_rfid_L0+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,45 :: 		}
	GOTO       L_main10
L_main9:
;rfid.c,48 :: 		Lcd_Out(2,1,"Error ");
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr2_rfid+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;rfid.c,49 :: 		}
L_main10:
;rfid.c,50 :: 		}
L_main2:
;rfid.c,51 :: 		}
	GOTO       L_main0
;rfid.c,52 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
