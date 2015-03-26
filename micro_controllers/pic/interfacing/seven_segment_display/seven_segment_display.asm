
_Mask_7seg:

;seven_segment_display.c,5 :: 		unsigned short Mask_7seg(unsigned short num) {
;seven_segment_display.c,6 :: 		switch (num) {
	GOTO       L_Mask_7seg0
;seven_segment_display.c,7 :: 		case 0: return 0x3F;
L_Mask_7seg2:
	MOVLW      63
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,8 :: 		case 1: return 0x06;
L_Mask_7seg3:
	MOVLW      6
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,9 :: 		case 2: return 0x5B;
L_Mask_7seg4:
	MOVLW      91
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,10 :: 		case 3: return 0x4F;
L_Mask_7seg5:
	MOVLW      79
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,11 :: 		case 4: return 0x66;
L_Mask_7seg6:
	MOVLW      102
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,12 :: 		case 5: return 0x6D;
L_Mask_7seg7:
	MOVLW      109
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,13 :: 		case 6: return 0x7D;
L_Mask_7seg8:
	MOVLW      125
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,14 :: 		case 7: return 0x07;
L_Mask_7seg9:
	MOVLW      7
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,15 :: 		case 8: return 0x7F;
L_Mask_7seg10:
	MOVLW      127
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,16 :: 		case 9: return 0x6F;
L_Mask_7seg11:
	MOVLW      111
	MOVWF      R0+0
	GOTO       L_end_Mask_7seg
;seven_segment_display.c,17 :: 		}
L_Mask_7seg0:
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      0
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg2
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      1
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg3
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      2
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg4
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      3
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg5
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      4
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg6
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      5
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg7
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      6
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg8
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      7
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg9
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      8
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg10
	MOVF       FARG_Mask_7seg_num+0, 0
	XORLW      9
	BTFSC      STATUS+0, 2
	GOTO       L_Mask_7seg11
;seven_segment_display.c,18 :: 		}//~
L_end_Mask_7seg:
	RETURN
; end of _Mask_7seg

_main:

;seven_segment_display.c,20 :: 		void main() {
;seven_segment_display.c,21 :: 		INTCON = 0;  // Disable PEIE, INTE, RBIE, T0IE
	CLRF       INTCON+0
;seven_segment_display.c,22 :: 		TRISA  = 0;
	CLRF       TRISA+0
;seven_segment_display.c,23 :: 		TRISB  = 0;
	CLRF       TRISB+0
;seven_segment_display.c,24 :: 		PORTB  = 0;
	CLRF       PORTB+0
;seven_segment_display.c,25 :: 		PORTA  = 2;
	MOVLW      2
	MOVWF      PORTA+0
;seven_segment_display.c,28 :: 		do {
L_main12:
;seven_segment_display.c,29 :: 		for (i = 0; i <= 9u; i++) {
	CLRF       _i+0
L_main15:
	MOVF       _i+0, 0
	SUBLW      9
	BTFSS      STATUS+0, 0
	GOTO       L_main16
;seven_segment_display.c,30 :: 		PORTB = Mask_7seg(i);  // Display digit on 7seg display
	MOVF       _i+0, 0
	MOVWF      FARG_Mask_7seg_num+0
	CALL       _Mask_7seg+0
	MOVF       R0+0, 0
	MOVWF      PORTB+0
;seven_segment_display.c,31 :: 		Delay_ms(1000);        // 1 second pause
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
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
;seven_segment_display.c,29 :: 		for (i = 0; i <= 9u; i++) {
	INCF       _i+0, 1
;seven_segment_display.c,32 :: 		}
	GOTO       L_main15
L_main16:
;seven_segment_display.c,33 :: 		} while (1);
	GOTO       L_main12
;seven_segment_display.c,34 :: 		}//~!
L_end_main:
	GOTO       $+0
; end of _main
