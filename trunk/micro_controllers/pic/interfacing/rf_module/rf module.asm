
_main:

;rf module.c,11 :: 		void main() {
;rf module.c,12 :: 		TRISD = 0xFF; // PORTD as input
	MOVLW       255
	MOVWF       TRISD+0 
;rf module.c,13 :: 		TRISC = 0x00; // PORTC as output
	CLRF        TRISC+0 
;rf module.c,15 :: 		while(1)
L_main0:
;rf module.c,17 :: 		if(INPUT1==0 && INPUT2==1 && INPUT3==1 && INPUT4==1)  // 1 - on
	BTFSC       RD0_bit+0, 0 
	GOTO        L_main4
	BTFSS       RD1_bit+0, 1 
	GOTO        L_main4
	BTFSS       RD2_bit+0, 2 
	GOTO        L_main4
	BTFSS       RD3_bit+0, 3 
	GOTO        L_main4
L__main23:
;rf module.c,20 :: 		if(relay1==0)
	MOVLW       0
	XORWF       _relay1+1, 0 
	BTFSS       STATUS+0, 2 
	GOTO        L__main25
	MOVLW       0
	XORWF       _relay1+0, 0 
L__main25:
	BTFSS       STATUS+0, 2 
	GOTO        L_main5
;rf module.c,22 :: 		OUTPUT2 = 1;
	BSF         RC1_bit+0, 1 
;rf module.c,23 :: 		delay_ms(200);
	MOVLW       2
	MOVWF       R11, 0
	MOVLW       4
	MOVWF       R12, 0
	MOVLW       186
	MOVWF       R13, 0
L_main6:
	DECFSZ      R13, 1, 1
	BRA         L_main6
	DECFSZ      R12, 1, 1
	BRA         L_main6
	DECFSZ      R11, 1, 1
	BRA         L_main6
	NOP
;rf module.c,24 :: 		OUTPUT1 = 0;
	BCF         RC0_bit+0, 0 
;rf module.c,25 :: 		OUTPUT3 = 0;
	BCF         RC2_bit+0, 2 
;rf module.c,26 :: 		OUTPUT4 = 0;
	BCF         RC3_bit+0, 3 
;rf module.c,27 :: 		delay_ms(200);
	MOVLW       2
	MOVWF       R11, 0
	MOVLW       4
	MOVWF       R12, 0
	MOVLW       186
	MOVWF       R13, 0
L_main7:
	DECFSZ      R13, 1, 1
	BRA         L_main7
	DECFSZ      R12, 1, 1
	BRA         L_main7
	DECFSZ      R11, 1, 1
	BRA         L_main7
	NOP
;rf module.c,28 :: 		relay1 = 1;
	MOVLW       1
	MOVWF       _relay1+0 
	MOVLW       0
	MOVWF       _relay1+1 
;rf module.c,29 :: 		}
	GOTO        L_main8
L_main5:
;rf module.c,33 :: 		OUTPUT2 = 0;
	BCF         RC1_bit+0, 1 
;rf module.c,34 :: 		delay_ms(200);
	MOVLW       2
	MOVWF       R11, 0
	MOVLW       4
	MOVWF       R12, 0
	MOVLW       186
	MOVWF       R13, 0
L_main9:
	DECFSZ      R13, 1, 1
	BRA         L_main9
	DECFSZ      R12, 1, 1
	BRA         L_main9
	DECFSZ      R11, 1, 1
	BRA         L_main9
	NOP
;rf module.c,35 :: 		OUTPUT1 = 0;
	BCF         RC0_bit+0, 0 
;rf module.c,36 :: 		OUTPUT3 = 0;
	BCF         RC2_bit+0, 2 
;rf module.c,37 :: 		OUTPUT4 = 0;
	BCF         RC3_bit+0, 3 
;rf module.c,38 :: 		delay_ms(200);
	MOVLW       2
	MOVWF       R11, 0
	MOVLW       4
	MOVWF       R12, 0
	MOVLW       186
	MOVWF       R13, 0
L_main10:
	DECFSZ      R13, 1, 1
	BRA         L_main10
	DECFSZ      R12, 1, 1
	BRA         L_main10
	DECFSZ      R11, 1, 1
	BRA         L_main10
	NOP
;rf module.c,39 :: 		relay1 = 0;
	CLRF        _relay1+0 
	CLRF        _relay1+1 
;rf module.c,40 :: 		}
L_main8:
;rf module.c,41 :: 		delay_ms(2000);
	MOVLW       11
	MOVWF       R11, 0
	MOVLW       38
	MOVWF       R12, 0
	MOVLW       93
	MOVWF       R13, 0
L_main11:
	DECFSZ      R13, 1, 1
	BRA         L_main11
	DECFSZ      R12, 1, 1
	BRA         L_main11
	DECFSZ      R11, 1, 1
	BRA         L_main11
	NOP
	NOP
;rf module.c,43 :: 		}
L_main4:
;rf module.c,45 :: 		if(INPUT1==1 && INPUT2==0 && INPUT3==1 && INPUT4==1)  // 1 - on
	BTFSS       RD0_bit+0, 0 
	GOTO        L_main14
	BTFSC       RD1_bit+0, 1 
	GOTO        L_main14
	BTFSS       RD2_bit+0, 2 
	GOTO        L_main14
	BTFSS       RD3_bit+0, 3 
	GOTO        L_main14
L__main22:
;rf module.c,48 :: 		if(relay2==0)
	MOVLW       0
	XORWF       _relay2+1, 0 
	BTFSS       STATUS+0, 2 
	GOTO        L__main26
	MOVLW       0
	XORWF       _relay2+0, 0 
L__main26:
	BTFSS       STATUS+0, 2 
	GOTO        L_main15
;rf module.c,50 :: 		OUTPUT4 = 1;
	BSF         RC3_bit+0, 3 
;rf module.c,51 :: 		delay_ms(200);
	MOVLW       2
	MOVWF       R11, 0
	MOVLW       4
	MOVWF       R12, 0
	MOVLW       186
	MOVWF       R13, 0
L_main16:
	DECFSZ      R13, 1, 1
	BRA         L_main16
	DECFSZ      R12, 1, 1
	BRA         L_main16
	DECFSZ      R11, 1, 1
	BRA         L_main16
	NOP
;rf module.c,52 :: 		OUTPUT1 = 0;
	BCF         RC0_bit+0, 0 
;rf module.c,53 :: 		OUTPUT2 = 0;
	BCF         RC1_bit+0, 1 
;rf module.c,54 :: 		OUTPUT3 = 0;
	BCF         RC2_bit+0, 2 
;rf module.c,55 :: 		delay_ms(200);
	MOVLW       2
	MOVWF       R11, 0
	MOVLW       4
	MOVWF       R12, 0
	MOVLW       186
	MOVWF       R13, 0
L_main17:
	DECFSZ      R13, 1, 1
	BRA         L_main17
	DECFSZ      R12, 1, 1
	BRA         L_main17
	DECFSZ      R11, 1, 1
	BRA         L_main17
	NOP
;rf module.c,56 :: 		relay2 = 1;
	MOVLW       1
	MOVWF       _relay2+0 
	MOVLW       0
	MOVWF       _relay2+1 
;rf module.c,57 :: 		}
	GOTO        L_main18
L_main15:
;rf module.c,61 :: 		OUTPUT4 = 0;
	BCF         RC3_bit+0, 3 
;rf module.c,62 :: 		delay_ms(200);
	MOVLW       2
	MOVWF       R11, 0
	MOVLW       4
	MOVWF       R12, 0
	MOVLW       186
	MOVWF       R13, 0
L_main19:
	DECFSZ      R13, 1, 1
	BRA         L_main19
	DECFSZ      R12, 1, 1
	BRA         L_main19
	DECFSZ      R11, 1, 1
	BRA         L_main19
	NOP
;rf module.c,63 :: 		OUTPUT1 = 0;
	BCF         RC0_bit+0, 0 
;rf module.c,64 :: 		OUTPUT2 = 0;
	BCF         RC1_bit+0, 1 
;rf module.c,65 :: 		OUTPUT3 = 0;
	BCF         RC2_bit+0, 2 
;rf module.c,66 :: 		delay_ms(200);
	MOVLW       2
	MOVWF       R11, 0
	MOVLW       4
	MOVWF       R12, 0
	MOVLW       186
	MOVWF       R13, 0
L_main20:
	DECFSZ      R13, 1, 1
	BRA         L_main20
	DECFSZ      R12, 1, 1
	BRA         L_main20
	DECFSZ      R11, 1, 1
	BRA         L_main20
	NOP
;rf module.c,67 :: 		relay2 = 0;
	CLRF        _relay2+0 
	CLRF        _relay2+1 
;rf module.c,68 :: 		}
L_main18:
;rf module.c,69 :: 		delay_ms(2000);
	MOVLW       11
	MOVWF       R11, 0
	MOVLW       38
	MOVWF       R12, 0
	MOVLW       93
	MOVWF       R13, 0
L_main21:
	DECFSZ      R13, 1, 1
	BRA         L_main21
	DECFSZ      R12, 1, 1
	BRA         L_main21
	DECFSZ      R11, 1, 1
	BRA         L_main21
	NOP
	NOP
;rf module.c,71 :: 		}
L_main14:
;rf module.c,74 :: 		}
	GOTO        L_main0
;rf module.c,75 :: 		}
L_end_main:
	GOTO        $+0
; end of _main
