
_Delay:

;bi_directional_visitor_counter.c,17 :: 		void Delay(int a)
;bi_directional_visitor_counter.c,21 :: 		for(i=0;i<a;i++)
	CLRF       R3+0
	CLRF       R3+1
L_Delay0:
	MOVLW      128
	XORWF      R3+1, 0
	MOVWF      R0+0
	MOVLW      128
	XORWF      FARG_Delay_a+1, 0
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Delay25
	MOVF       FARG_Delay_a+0, 0
	SUBWF      R3+0, 0
L__Delay25:
	BTFSC      STATUS+0, 0
	GOTO       L_Delay1
;bi_directional_visitor_counter.c,23 :: 		for(j=0;j<100;j++)
	CLRF       R1+0
	CLRF       R1+1
L_Delay3:
	MOVLW      128
	XORWF      R1+1, 0
	MOVWF      R0+0
	MOVLW      128
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Delay26
	MOVLW      100
	SUBWF      R1+0, 0
L__Delay26:
	BTFSC      STATUS+0, 0
	GOTO       L_Delay4
	INCF       R1+0, 1
	BTFSC      STATUS+0, 2
	INCF       R1+1, 1
;bi_directional_visitor_counter.c,25 :: 		}
	GOTO       L_Delay3
L_Delay4:
;bi_directional_visitor_counter.c,21 :: 		for(i=0;i<a;i++)
	INCF       R3+0, 1
	BTFSC      STATUS+0, 2
	INCF       R3+1, 1
;bi_directional_visitor_counter.c,26 :: 		}
	GOTO       L_Delay0
L_Delay1:
;bi_directional_visitor_counter.c,27 :: 		}
L_end_Delay:
	RETURN
; end of _Delay

_toChar:

;bi_directional_visitor_counter.c,29 :: 		char toChar(int a)
;bi_directional_visitor_counter.c,31 :: 		switch(a)
	GOTO       L_toChar6
;bi_directional_visitor_counter.c,33 :: 		case 1:
L_toChar8:
;bi_directional_visitor_counter.c,34 :: 		return '1';
	MOVLW      49
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,36 :: 		case 2:
L_toChar9:
;bi_directional_visitor_counter.c,37 :: 		return '2';
	MOVLW      50
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,39 :: 		case 3:
L_toChar10:
;bi_directional_visitor_counter.c,40 :: 		return '3';
	MOVLW      51
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,42 :: 		case 4:
L_toChar11:
;bi_directional_visitor_counter.c,43 :: 		return '4';
	MOVLW      52
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,45 :: 		case 5:
L_toChar12:
;bi_directional_visitor_counter.c,46 :: 		return '5';
	MOVLW      53
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,48 :: 		case 6:
L_toChar13:
;bi_directional_visitor_counter.c,49 :: 		return '6';
	MOVLW      54
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,51 :: 		case 7:
L_toChar14:
;bi_directional_visitor_counter.c,52 :: 		return '7';
	MOVLW      55
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,54 :: 		case 8:
L_toChar15:
;bi_directional_visitor_counter.c,55 :: 		return '8';
	MOVLW      56
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,57 :: 		case 9:
L_toChar16:
;bi_directional_visitor_counter.c,58 :: 		return '9';
	MOVLW      57
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,60 :: 		case 0:
L_toChar17:
;bi_directional_visitor_counter.c,61 :: 		return '0';
	MOVLW      48
	MOVWF      R0+0
	GOTO       L_end_toChar
;bi_directional_visitor_counter.c,64 :: 		}
L_toChar6:
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar28
	MOVLW      1
	XORWF      FARG_toChar_a+0, 0
L__toChar28:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar8
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar29
	MOVLW      2
	XORWF      FARG_toChar_a+0, 0
L__toChar29:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar9
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar30
	MOVLW      3
	XORWF      FARG_toChar_a+0, 0
L__toChar30:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar10
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar31
	MOVLW      4
	XORWF      FARG_toChar_a+0, 0
L__toChar31:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar11
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar32
	MOVLW      5
	XORWF      FARG_toChar_a+0, 0
L__toChar32:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar12
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar33
	MOVLW      6
	XORWF      FARG_toChar_a+0, 0
L__toChar33:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar13
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar34
	MOVLW      7
	XORWF      FARG_toChar_a+0, 0
L__toChar34:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar14
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar35
	MOVLW      8
	XORWF      FARG_toChar_a+0, 0
L__toChar35:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar15
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar36
	MOVLW      9
	XORWF      FARG_toChar_a+0, 0
L__toChar36:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar16
	MOVLW      0
	XORWF      FARG_toChar_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__toChar37
	MOVLW      0
	XORWF      FARG_toChar_a+0, 0
L__toChar37:
	BTFSC      STATUS+0, 2
	GOTO       L_toChar17
;bi_directional_visitor_counter.c,66 :: 		}
L_end_toChar:
	RETURN
; end of _toChar

_main:

;bi_directional_visitor_counter.c,67 :: 		void main()
;bi_directional_visitor_counter.c,70 :: 		int count=0;
	CLRF       main_count_L0+0
	CLRF       main_count_L0+1
;bi_directional_visitor_counter.c,72 :: 		ENTER=1;
	BSF        RD0_bit+0, BitPos(RD0_bit+0)
;bi_directional_visitor_counter.c,73 :: 		EXIT=1;
	BSF        RD1_bit+0, BitPos(RD1_bit+0)
;bi_directional_visitor_counter.c,74 :: 		TRISD = 0xFF; // PORTD as input
	MOVLW      255
	MOVWF      TRISD+0
;bi_directional_visitor_counter.c,75 :: 		Lcd_Init(); // Initialize LCD
	CALL       _Lcd_Init+0
;bi_directional_visitor_counter.c,76 :: 		Lcd_Cmd(_LCD_CLEAR); // Clear display
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;bi_directional_visitor_counter.c,77 :: 		Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
	MOVLW      12
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;bi_directional_visitor_counter.c,78 :: 		Lcd_Out(1,1,"WELCOME:");//Write text'Hello World' in first row
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr1_bi_directional_visitor_counter+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;bi_directional_visitor_counter.c,79 :: 		c=toChar(count);
	MOVF       main_count_L0+0, 0
	MOVWF      FARG_toChar_a+0
	MOVF       main_count_L0+1, 0
	MOVWF      FARG_toChar_a+1
	CALL       _toChar+0
;bi_directional_visitor_counter.c,80 :: 		Lcd_chr(2,1,c);
	MOVLW      2
	MOVWF      FARG_Lcd_Chr_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Chr_column+0
	MOVF       R0+0, 0
	MOVWF      FARG_Lcd_Chr_out_char+0
	CALL       _Lcd_Chr+0
;bi_directional_visitor_counter.c,81 :: 		while(1)
L_main18:
;bi_directional_visitor_counter.c,83 :: 		if(ENTER == 1)
	BTFSS      RD0_bit+0, BitPos(RD0_bit+0)
	GOTO       L_main20
;bi_directional_visitor_counter.c,85 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;bi_directional_visitor_counter.c,86 :: 		Lcd_Out(1,1,"WELCOME");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr2_bi_directional_visitor_counter+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;bi_directional_visitor_counter.c,87 :: 		count++;
	INCF       main_count_L0+0, 1
	BTFSC      STATUS+0, 2
	INCF       main_count_L0+1, 1
;bi_directional_visitor_counter.c,88 :: 		if(count == 999)
	MOVF       main_count_L0+1, 0
	XORLW      3
	BTFSS      STATUS+0, 2
	GOTO       L__main39
	MOVLW      231
	XORWF      main_count_L0+0, 0
L__main39:
	BTFSS      STATUS+0, 2
	GOTO       L_main21
;bi_directional_visitor_counter.c,89 :: 		count=0;
	CLRF       main_count_L0+0
	CLRF       main_count_L0+1
L_main21:
;bi_directional_visitor_counter.c,90 :: 		Delay(500);
	MOVLW      244
	MOVWF      FARG_Delay_a+0
	MOVLW      1
	MOVWF      FARG_Delay_a+1
	CALL       _Delay+0
;bi_directional_visitor_counter.c,91 :: 		}
L_main20:
;bi_directional_visitor_counter.c,92 :: 		if(EXIT == 1)
	BTFSS      RD1_bit+0, BitPos(RD1_bit+0)
	GOTO       L_main22
;bi_directional_visitor_counter.c,94 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;bi_directional_visitor_counter.c,95 :: 		Lcd_Out(1,1,"THANKS");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr3_bi_directional_visitor_counter+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;bi_directional_visitor_counter.c,96 :: 		count--;
	MOVLW      1
	SUBWF      main_count_L0+0, 1
	BTFSS      STATUS+0, 0
	DECF       main_count_L0+1, 1
;bi_directional_visitor_counter.c,97 :: 		if(count == -1)
	MOVLW      255
	XORWF      main_count_L0+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main40
	MOVLW      255
	XORWF      main_count_L0+0, 0
L__main40:
	BTFSS      STATUS+0, 2
	GOTO       L_main23
;bi_directional_visitor_counter.c,98 :: 		count=0;
	CLRF       main_count_L0+0
	CLRF       main_count_L0+1
L_main23:
;bi_directional_visitor_counter.c,99 :: 		Delay(500);
	MOVLW      244
	MOVWF      FARG_Delay_a+0
	MOVLW      1
	MOVWF      FARG_Delay_a+1
	CALL       _Delay+0
;bi_directional_visitor_counter.c,100 :: 		}
L_main22:
;bi_directional_visitor_counter.c,101 :: 		i=count;
	MOVF       main_count_L0+0, 0
	MOVWF      main_i_L0+0
	MOVF       main_count_L0+1, 0
	MOVWF      main_i_L0+1
;bi_directional_visitor_counter.c,102 :: 		j=i%10;
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       main_count_L0+0, 0
	MOVWF      R0+0
	MOVF       main_count_L0+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVF       R8+0, 0
	MOVWF      R0+0
	MOVF       R8+1, 0
	MOVWF      R0+1
	MOVF       R0+0, 0
	MOVWF      main_j_L0+0
	MOVF       R0+1, 0
	MOVWF      main_j_L0+1
;bi_directional_visitor_counter.c,103 :: 		k=i/10;
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       main_i_L0+0, 0
	MOVWF      R0+0
	MOVF       main_i_L0+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVF       R0+0, 0
	MOVWF      main_k_L0+0
	MOVF       R0+1, 0
	MOVWF      main_k_L0+1
;bi_directional_visitor_counter.c,104 :: 		l=i/100;
	MOVLW      100
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       main_i_L0+0, 0
	MOVWF      R0+0
	MOVF       main_i_L0+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVF       R0+0, 0
	MOVWF      main_l_L0+0
	MOVF       R0+1, 0
	MOVWF      main_l_L0+1
;bi_directional_visitor_counter.c,105 :: 		k=k-l*10;
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	CALL       _Mul_16x16_U+0
	MOVF       R0+0, 0
	SUBWF      main_k_L0+0, 1
	BTFSS      STATUS+0, 0
	DECF       main_k_L0+1, 1
	MOVF       R0+1, 0
	SUBWF      main_k_L0+1, 1
;bi_directional_visitor_counter.c,106 :: 		c=toChar(j);
	MOVF       main_j_L0+0, 0
	MOVWF      FARG_toChar_a+0
	MOVF       main_j_L0+1, 0
	MOVWF      FARG_toChar_a+1
	CALL       _toChar+0
;bi_directional_visitor_counter.c,107 :: 		Lcd_chr(2,3,c);
	MOVLW      2
	MOVWF      FARG_Lcd_Chr_row+0
	MOVLW      3
	MOVWF      FARG_Lcd_Chr_column+0
	MOVF       R0+0, 0
	MOVWF      FARG_Lcd_Chr_out_char+0
	CALL       _Lcd_Chr+0
;bi_directional_visitor_counter.c,108 :: 		c=toChar(k);
	MOVF       main_k_L0+0, 0
	MOVWF      FARG_toChar_a+0
	MOVF       main_k_L0+1, 0
	MOVWF      FARG_toChar_a+1
	CALL       _toChar+0
;bi_directional_visitor_counter.c,109 :: 		Lcd_chr(2,2,c);
	MOVLW      2
	MOVWF      FARG_Lcd_Chr_row+0
	MOVLW      2
	MOVWF      FARG_Lcd_Chr_column+0
	MOVF       R0+0, 0
	MOVWF      FARG_Lcd_Chr_out_char+0
	CALL       _Lcd_Chr+0
;bi_directional_visitor_counter.c,110 :: 		c=toChar(l);
	MOVF       main_l_L0+0, 0
	MOVWF      FARG_toChar_a+0
	MOVF       main_l_L0+1, 0
	MOVWF      FARG_toChar_a+1
	CALL       _toChar+0
;bi_directional_visitor_counter.c,111 :: 		Lcd_chr(2,1,c);
	MOVLW      2
	MOVWF      FARG_Lcd_Chr_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Chr_column+0
	MOVF       R0+0, 0
	MOVWF      FARG_Lcd_Chr_out_char+0
	CALL       _Lcd_Chr+0
;bi_directional_visitor_counter.c,112 :: 		}
	GOTO       L_main18
;bi_directional_visitor_counter.c,113 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
