
_main:

;keypad_interfacing_pic.c,20 :: 		void main()
;keypad_interfacing_pic.c,22 :: 		cnt = 0; // Reset counter
	CLRF       _cnt+0
;keypad_interfacing_pic.c,23 :: 		Keypad_Init(); // Initialize Keypad
	CALL       _Keypad_Init+0
;keypad_interfacing_pic.c,24 :: 		Lcd_Init(); // Initialize Lcd
	CALL       _Lcd_Init+0
;keypad_interfacing_pic.c,25 :: 		Lcd_Cmd(_LCD_CLEAR); // Clear display
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;keypad_interfacing_pic.c,26 :: 		Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
	MOVLW      12
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;keypad_interfacing_pic.c,27 :: 		Lcd_Out(1, 1, "1");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr1_keypad_interfacing_pic+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;keypad_interfacing_pic.c,28 :: 		Lcd_Out(1, 1, "Key :"); // Write message text on Lcd
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr2_keypad_interfacing_pic+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;keypad_interfacing_pic.c,29 :: 		Lcd_Out(2, 1, "Times:");
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr3_keypad_interfacing_pic+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;keypad_interfacing_pic.c,30 :: 		do
L_main0:
;keypad_interfacing_pic.c,32 :: 		kp = 0; // Reset key code variable
	CLRF       _kp+0
;keypad_interfacing_pic.c,34 :: 		do
L_main3:
;keypad_interfacing_pic.c,36 :: 		kp = Keypad_Key_Click(); // Store key code in kp variable
	CALL       _Keypad_Key_Click+0
	MOVF       R0+0, 0
	MOVWF      _kp+0
;keypad_interfacing_pic.c,37 :: 		while (!kp);
	MOVF       R0+0, 0
	BTFSC      STATUS+0, 2
	GOTO       L_main3
;keypad_interfacing_pic.c,39 :: 		switch (kp)
	GOTO       L_main6
;keypad_interfacing_pic.c,41 :: 		case 1: kp = 49; break; // 1
L_main8:
	MOVLW      49
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,42 :: 		case 2: kp = 50; break; // 2
L_main9:
	MOVLW      50
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,43 :: 		case 3: kp = 51; break; // 3
L_main10:
	MOVLW      51
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,44 :: 		case 4: kp = 65; break; // A commented since 4th column is absent for 4*3 keypad
L_main11:
	MOVLW      65
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,45 :: 		case 5: kp = 52; break; // 4
L_main12:
	MOVLW      52
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,46 :: 		case 6: kp = 53; break; // 5
L_main13:
	MOVLW      53
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,47 :: 		case 7: kp = 54; break; // 6
L_main14:
	MOVLW      54
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,48 :: 		case 8: kp = 66; break; // B commented since 4th column is absent for 4*3 keypad
L_main15:
	MOVLW      66
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,49 :: 		case 9: kp = 55; break; // 7
L_main16:
	MOVLW      55
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,50 :: 		case 10: kp = 56; break; // 8
L_main17:
	MOVLW      56
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,51 :: 		case 11: kp = 57; break; // 9
L_main18:
	MOVLW      57
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,52 :: 		case 12: kp = 67; break; // C commented since 4th column is absent for 4*3 keypad
L_main19:
	MOVLW      67
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,53 :: 		case 13: kp = 42; break; // *
L_main20:
	MOVLW      42
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,54 :: 		case 14: kp = 48; break; // 0
L_main21:
	MOVLW      48
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,55 :: 		case 15: kp = 35; break; // #
L_main22:
	MOVLW      35
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,56 :: 		case 16: kp = 68; break; // D
L_main23:
	MOVLW      68
	MOVWF      _kp+0
	GOTO       L_main7
;keypad_interfacing_pic.c,57 :: 		}
L_main6:
	MOVF       _kp+0, 0
	XORLW      1
	BTFSC      STATUS+0, 2
	GOTO       L_main8
	MOVF       _kp+0, 0
	XORLW      2
	BTFSC      STATUS+0, 2
	GOTO       L_main9
	MOVF       _kp+0, 0
	XORLW      3
	BTFSC      STATUS+0, 2
	GOTO       L_main10
	MOVF       _kp+0, 0
	XORLW      4
	BTFSC      STATUS+0, 2
	GOTO       L_main11
	MOVF       _kp+0, 0
	XORLW      5
	BTFSC      STATUS+0, 2
	GOTO       L_main12
	MOVF       _kp+0, 0
	XORLW      6
	BTFSC      STATUS+0, 2
	GOTO       L_main13
	MOVF       _kp+0, 0
	XORLW      7
	BTFSC      STATUS+0, 2
	GOTO       L_main14
	MOVF       _kp+0, 0
	XORLW      8
	BTFSC      STATUS+0, 2
	GOTO       L_main15
	MOVF       _kp+0, 0
	XORLW      9
	BTFSC      STATUS+0, 2
	GOTO       L_main16
	MOVF       _kp+0, 0
	XORLW      10
	BTFSC      STATUS+0, 2
	GOTO       L_main17
	MOVF       _kp+0, 0
	XORLW      11
	BTFSC      STATUS+0, 2
	GOTO       L_main18
	MOVF       _kp+0, 0
	XORLW      12
	BTFSC      STATUS+0, 2
	GOTO       L_main19
	MOVF       _kp+0, 0
	XORLW      13
	BTFSC      STATUS+0, 2
	GOTO       L_main20
	MOVF       _kp+0, 0
	XORLW      14
	BTFSC      STATUS+0, 2
	GOTO       L_main21
	MOVF       _kp+0, 0
	XORLW      15
	BTFSC      STATUS+0, 2
	GOTO       L_main22
	MOVF       _kp+0, 0
	XORLW      16
	BTFSC      STATUS+0, 2
	GOTO       L_main23
L_main7:
;keypad_interfacing_pic.c,58 :: 		if (kp != oldstate)
	MOVF       _kp+0, 0
	XORWF      _oldstate+0, 0
	BTFSC      STATUS+0, 2
	GOTO       L_main24
;keypad_interfacing_pic.c,60 :: 		cnt = 1;
	MOVLW      1
	MOVWF      _cnt+0
;keypad_interfacing_pic.c,61 :: 		oldstate = kp;
	MOVF       _kp+0, 0
	MOVWF      _oldstate+0
;keypad_interfacing_pic.c,62 :: 		}
	GOTO       L_main25
L_main24:
;keypad_interfacing_pic.c,65 :: 		cnt++;
	INCF       _cnt+0, 1
;keypad_interfacing_pic.c,66 :: 		}
L_main25:
;keypad_interfacing_pic.c,67 :: 		Lcd_Chr(1, 10, kp); // Print key ASCII value on Lcd
	MOVLW      1
	MOVWF      FARG_Lcd_Chr_row+0
	MOVLW      10
	MOVWF      FARG_Lcd_Chr_column+0
	MOVF       _kp+0, 0
	MOVWF      FARG_Lcd_Chr_out_char+0
	CALL       _Lcd_Chr+0
;keypad_interfacing_pic.c,68 :: 		if (cnt == 255)
	MOVF       _cnt+0, 0
	XORLW      255
	BTFSS      STATUS+0, 2
	GOTO       L_main26
;keypad_interfacing_pic.c,70 :: 		cnt = 0;
	CLRF       _cnt+0
;keypad_interfacing_pic.c,71 :: 		Lcd_Out(2, 10, " ");
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      10
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr4_keypad_interfacing_pic+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;keypad_interfacing_pic.c,72 :: 		}
L_main26:
;keypad_interfacing_pic.c,74 :: 		WordToStr(cnt, txt); // Transform counter value to string
	MOVF       _cnt+0, 0
	MOVWF      FARG_WordToStr_input+0
	CLRF       FARG_WordToStr_input+1
	MOVLW      _txt+0
	MOVWF      FARG_WordToStr_output+0
	CALL       _WordToStr+0
;keypad_interfacing_pic.c,75 :: 		Lcd_Out(2, 10, txt); // Display counter value on Lcd
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      10
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      _txt+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;keypad_interfacing_pic.c,76 :: 		} while (1);
	GOTO       L_main0
;keypad_interfacing_pic.c,77 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
