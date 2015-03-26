
_Hex:

;four_digit_seven_segment_display.c,1 :: 		unsigned int Hex(int a)
;four_digit_seven_segment_display.c,3 :: 		switch(a)
	GOTO       L_Hex0
;four_digit_seven_segment_display.c,5 :: 		case 1: return 0x06;
L_Hex2:
	MOVLW      6
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,6 :: 		case 2: return 0x5B;
L_Hex3:
	MOVLW      91
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,7 :: 		case 3: return 0x4F;
L_Hex4:
	MOVLW      79
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,8 :: 		case 4: return 0x66;
L_Hex5:
	MOVLW      102
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,9 :: 		case 5: return 0x6D;
L_Hex6:
	MOVLW      109
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,10 :: 		case 6: return 0x7D;
L_Hex7:
	MOVLW      125
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,11 :: 		case 7: return 0x07;
L_Hex8:
	MOVLW      7
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,12 :: 		case 8: return 0x7F;
L_Hex9:
	MOVLW      127
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,13 :: 		case 9: return 0x6F;
L_Hex10:
	MOVLW      111
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,14 :: 		case 0: return 0x3F;
L_Hex11:
	MOVLW      63
	MOVWF      R0+0
	MOVLW      0
	MOVWF      R0+1
	GOTO       L_end_Hex
;four_digit_seven_segment_display.c,15 :: 		}
L_Hex0:
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex23
	MOVLW      1
	XORWF      FARG_Hex_a+0, 0
L__Hex23:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex2
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex24
	MOVLW      2
	XORWF      FARG_Hex_a+0, 0
L__Hex24:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex3
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex25
	MOVLW      3
	XORWF      FARG_Hex_a+0, 0
L__Hex25:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex4
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex26
	MOVLW      4
	XORWF      FARG_Hex_a+0, 0
L__Hex26:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex5
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex27
	MOVLW      5
	XORWF      FARG_Hex_a+0, 0
L__Hex27:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex6
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex28
	MOVLW      6
	XORWF      FARG_Hex_a+0, 0
L__Hex28:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex7
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex29
	MOVLW      7
	XORWF      FARG_Hex_a+0, 0
L__Hex29:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex8
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex30
	MOVLW      8
	XORWF      FARG_Hex_a+0, 0
L__Hex30:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex9
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex31
	MOVLW      9
	XORWF      FARG_Hex_a+0, 0
L__Hex31:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex10
	MOVLW      0
	XORWF      FARG_Hex_a+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__Hex32
	MOVLW      0
	XORWF      FARG_Hex_a+0, 0
L__Hex32:
	BTFSC      STATUS+0, 2
	GOTO       L_Hex11
;four_digit_seven_segment_display.c,16 :: 		}
L_end_Hex:
	RETURN
; end of _Hex

_main:

;four_digit_seven_segment_display.c,18 :: 		void main()
;four_digit_seven_segment_display.c,20 :: 		int s = 0;
	CLRF       main_s_L0+0
	CLRF       main_s_L0+1
	MOVLW      10
	MOVWF      main_d_L0+0
	MOVLW      0
	MOVWF      main_d_L0+1
;four_digit_seven_segment_display.c,22 :: 		CMCON = 0x07;   // To turn off comparators
	MOVLW      7
	MOVWF      CMCON+0
;four_digit_seven_segment_display.c,23 :: 		ADCON1 = 0x06;  // To turn off analog to digital converters
	MOVLW      6
	MOVWF      ADCON1+0
;four_digit_seven_segment_display.c,24 :: 		TRISB = 0x00;
	CLRF       TRISB+0
;four_digit_seven_segment_display.c,25 :: 		TRISD = 0x00;
	CLRF       TRISD+0
;four_digit_seven_segment_display.c,26 :: 		do
L_main12:
;four_digit_seven_segment_display.c,28 :: 		PORTB = Hex(s%10);
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       main_s_L0+0, 0
	MOVWF      R0+0
	MOVF       main_s_L0+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVF       R8+0, 0
	MOVWF      R0+0
	MOVF       R8+1, 0
	MOVWF      R0+1
	MOVF       R0+0, 0
	MOVWF      FARG_Hex_a+0
	MOVF       R0+1, 0
	MOVWF      FARG_Hex_a+1
	CALL       _Hex+0
	MOVF       R0+0, 0
	MOVWF      PORTB+0
;four_digit_seven_segment_display.c,29 :: 		PORTD.F3 = 1;
	BSF        PORTD+0, 3
;four_digit_seven_segment_display.c,30 :: 		Delay_ms(1);
	MOVLW      3
	MOVWF      R12+0
	MOVLW      151
	MOVWF      R13+0
L_main15:
	DECFSZ     R13+0, 1
	GOTO       L_main15
	DECFSZ     R12+0, 1
	GOTO       L_main15
	NOP
	NOP
;four_digit_seven_segment_display.c,31 :: 		PORTD.F3 = 0;
	BCF        PORTD+0, 3
;four_digit_seven_segment_display.c,32 :: 		PORTB = Hex((s/10)%10);
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       main_s_L0+0, 0
	MOVWF      R0+0
	MOVF       main_s_L0+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	CALL       _Div_16x16_S+0
	MOVF       R8+0, 0
	MOVWF      R0+0
	MOVF       R8+1, 0
	MOVWF      R0+1
	MOVF       R0+0, 0
	MOVWF      FARG_Hex_a+0
	MOVF       R0+1, 0
	MOVWF      FARG_Hex_a+1
	CALL       _Hex+0
	MOVF       R0+0, 0
	MOVWF      PORTB+0
;four_digit_seven_segment_display.c,33 :: 		PORTD.F2 = 1;
	BSF        PORTD+0, 2
;four_digit_seven_segment_display.c,34 :: 		Delay_ms(1);
	MOVLW      3
	MOVWF      R12+0
	MOVLW      151
	MOVWF      R13+0
L_main16:
	DECFSZ     R13+0, 1
	GOTO       L_main16
	DECFSZ     R12+0, 1
	GOTO       L_main16
	NOP
	NOP
;four_digit_seven_segment_display.c,35 :: 		PORTD.F2 = 0;
	BCF        PORTD+0, 2
;four_digit_seven_segment_display.c,36 :: 		PORTB = Hex((s/100)%10);
	MOVLW      100
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	MOVF       main_s_L0+0, 0
	MOVWF      R0+0
	MOVF       main_s_L0+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	CALL       _Div_16x16_S+0
	MOVF       R8+0, 0
	MOVWF      R0+0
	MOVF       R8+1, 0
	MOVWF      R0+1
	MOVF       R0+0, 0
	MOVWF      FARG_Hex_a+0
	MOVF       R0+1, 0
	MOVWF      FARG_Hex_a+1
	CALL       _Hex+0
	MOVF       R0+0, 0
	MOVWF      PORTB+0
;four_digit_seven_segment_display.c,37 :: 		PORTD.F1 = 1;
	BSF        PORTD+0, 1
;four_digit_seven_segment_display.c,38 :: 		Delay_ms(1);
	MOVLW      3
	MOVWF      R12+0
	MOVLW      151
	MOVWF      R13+0
L_main17:
	DECFSZ     R13+0, 1
	GOTO       L_main17
	DECFSZ     R12+0, 1
	GOTO       L_main17
	NOP
	NOP
;four_digit_seven_segment_display.c,39 :: 		PORTD.F1 = 0;
	BCF        PORTD+0, 1
;four_digit_seven_segment_display.c,40 :: 		PORTB = Hex((s/1000)%10);
	MOVLW      232
	MOVWF      R4+0
	MOVLW      3
	MOVWF      R4+1
	MOVF       main_s_L0+0, 0
	MOVWF      R0+0
	MOVF       main_s_L0+1, 0
	MOVWF      R0+1
	CALL       _Div_16x16_S+0
	MOVLW      10
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	CALL       _Div_16x16_S+0
	MOVF       R8+0, 0
	MOVWF      R0+0
	MOVF       R8+1, 0
	MOVWF      R0+1
	MOVF       R0+0, 0
	MOVWF      FARG_Hex_a+0
	MOVF       R0+1, 0
	MOVWF      FARG_Hex_a+1
	CALL       _Hex+0
	MOVF       R0+0, 0
	MOVWF      PORTB+0
;four_digit_seven_segment_display.c,41 :: 		PORTD.F0 = 1;
	BSF        PORTD+0, 0
;four_digit_seven_segment_display.c,42 :: 		Delay_ms(1);
	MOVLW      3
	MOVWF      R12+0
	MOVLW      151
	MOVWF      R13+0
L_main18:
	DECFSZ     R13+0, 1
	GOTO       L_main18
	DECFSZ     R12+0, 1
	GOTO       L_main18
	NOP
	NOP
;four_digit_seven_segment_display.c,43 :: 		PORTD.F0 = 0;
	BCF        PORTD+0, 0
;four_digit_seven_segment_display.c,45 :: 		if(d>0)
	MOVLW      128
	MOVWF      R0+0
	MOVLW      128
	XORWF      main_d_L0+1, 0
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main34
	MOVF       main_d_L0+0, 0
	SUBLW      0
L__main34:
	BTFSC      STATUS+0, 0
	GOTO       L_main19
;four_digit_seven_segment_display.c,47 :: 		d--;
	MOVLW      1
	SUBWF      main_d_L0+0, 1
	BTFSS      STATUS+0, 0
	DECF       main_d_L0+1, 1
;four_digit_seven_segment_display.c,48 :: 		if(d == 0)
	MOVLW      0
	XORWF      main_d_L0+1, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main35
	MOVLW      0
	XORWF      main_d_L0+0, 0
L__main35:
	BTFSS      STATUS+0, 2
	GOTO       L_main20
;four_digit_seven_segment_display.c,50 :: 		s++;
	INCF       main_s_L0+0, 1
	BTFSC      STATUS+0, 2
	INCF       main_s_L0+1, 1
;four_digit_seven_segment_display.c,51 :: 		d = 10;
	MOVLW      10
	MOVWF      main_d_L0+0
	MOVLW      0
	MOVWF      main_d_L0+1
;four_digit_seven_segment_display.c,52 :: 		}
L_main20:
;four_digit_seven_segment_display.c,53 :: 		if(s > 9999)
	MOVLW      128
	XORLW      39
	MOVWF      R0+0
	MOVLW      128
	XORWF      main_s_L0+1, 0
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main36
	MOVF       main_s_L0+0, 0
	SUBLW      15
L__main36:
	BTFSC      STATUS+0, 0
	GOTO       L_main21
;four_digit_seven_segment_display.c,54 :: 		s = 0;
	CLRF       main_s_L0+0
	CLRF       main_s_L0+1
L_main21:
;four_digit_seven_segment_display.c,55 :: 		}
L_main19:
;four_digit_seven_segment_display.c,56 :: 		}while(1);
	GOTO       L_main12
;four_digit_seven_segment_display.c,57 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
