
_main:

;rf.c,2 :: 		void main()
;rf.c,4 :: 		TRISD = 0xFF; // PORTD as input
	MOVLW      255
	MOVWF      TRISD+0
;rf.c,5 :: 		TRISB = 0x00; // PORTB as output    int relay = 0;
	CLRF       TRISB+0
;rf.c,6 :: 		RB0_bit=0;
	BCF        RB0_bit+0, BitPos(RB0_bit+0)
;rf.c,7 :: 		RB1_bit=0;
	BCF        RB1_bit+0, BitPos(RB1_bit+0)
;rf.c,8 :: 		RB2_bit=0;
	BCF        RB2_bit+0, BitPos(RB2_bit+0)
;rf.c,9 :: 		RB3_bit=0;
	BCF        RB3_bit+0, BitPos(RB3_bit+0)
;rf.c,11 :: 		while(1)
L_main0:
;rf.c,13 :: 		if(RD0_bit==0 && RD1_bit==1 )  // 1 - on
	BTFSC      RD0_bit+0, BitPos(RD0_bit+0)
	GOTO       L_main4
	BTFSS      RD1_bit+0, BitPos(RD1_bit+0)
	GOTO       L_main4
L__main21:
;rf.c,15 :: 		if( RB0_bit== 0 )
	BTFSC      RB0_bit+0, BitPos(RB0_bit+0)
	GOTO       L_main5
;rf.c,17 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main6:
	DECFSZ     R13+0, 1
	GOTO       L_main6
	DECFSZ     R12+0, 1
	GOTO       L_main6
	DECFSZ     R11+0, 1
	GOTO       L_main6
	NOP
;rf.c,18 :: 		RB1_bit = 0;
	BCF        RB1_bit+0, BitPos(RB1_bit+0)
;rf.c,19 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main7:
	DECFSZ     R13+0, 1
	GOTO       L_main7
	DECFSZ     R12+0, 1
	GOTO       L_main7
	DECFSZ     R11+0, 1
	GOTO       L_main7
	NOP
;rf.c,20 :: 		RB0_bit=1;
	BSF        RB0_bit+0, BitPos(RB0_bit+0)
;rf.c,21 :: 		}
	GOTO       L_main8
L_main5:
;rf.c,24 :: 		RB1_bit = 0;
	BCF        RB1_bit+0, BitPos(RB1_bit+0)
;rf.c,25 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main9:
	DECFSZ     R13+0, 1
	GOTO       L_main9
	DECFSZ     R12+0, 1
	GOTO       L_main9
	DECFSZ     R11+0, 1
	GOTO       L_main9
	NOP
;rf.c,26 :: 		RB0_bit=0;
	BCF        RB0_bit+0, BitPos(RB0_bit+0)
;rf.c,27 :: 		}
L_main8:
;rf.c,28 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main10:
	DECFSZ     R13+0, 1
	GOTO       L_main10
	DECFSZ     R12+0, 1
	GOTO       L_main10
	DECFSZ     R11+0, 1
	GOTO       L_main10
	NOP
;rf.c,29 :: 		}
L_main4:
;rf.c,31 :: 		if(RD0_bit==1 && RD1_bit==0 )  // 1 - on
	BTFSS      RD0_bit+0, BitPos(RD0_bit+0)
	GOTO       L_main13
	BTFSC      RD1_bit+0, BitPos(RD1_bit+0)
	GOTO       L_main13
L__main20:
;rf.c,33 :: 		if( RB1_bit== 0 )
	BTFSC      RB1_bit+0, BitPos(RB1_bit+0)
	GOTO       L_main14
;rf.c,35 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main15:
	DECFSZ     R13+0, 1
	GOTO       L_main15
	DECFSZ     R12+0, 1
	GOTO       L_main15
	DECFSZ     R11+0, 1
	GOTO       L_main15
	NOP
;rf.c,36 :: 		RB0_bit = 0;
	BCF        RB0_bit+0, BitPos(RB0_bit+0)
;rf.c,37 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main16:
	DECFSZ     R13+0, 1
	GOTO       L_main16
	DECFSZ     R12+0, 1
	GOTO       L_main16
	DECFSZ     R11+0, 1
	GOTO       L_main16
	NOP
;rf.c,38 :: 		RB1_bit=1;
	BSF        RB1_bit+0, BitPos(RB1_bit+0)
;rf.c,39 :: 		}
	GOTO       L_main17
L_main14:
;rf.c,42 :: 		RB0_bit = 0;
	BCF        RB0_bit+0, BitPos(RB0_bit+0)
;rf.c,43 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main18:
	DECFSZ     R13+0, 1
	GOTO       L_main18
	DECFSZ     R12+0, 1
	GOTO       L_main18
	DECFSZ     R11+0, 1
	GOTO       L_main18
	NOP
;rf.c,44 :: 		RB1_bit=0;
	BCF        RB1_bit+0, BitPos(RB1_bit+0)
;rf.c,45 :: 		}
L_main17:
;rf.c,46 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main19:
	DECFSZ     R13+0, 1
	GOTO       L_main19
	DECFSZ     R12+0, 1
	GOTO       L_main19
	DECFSZ     R11+0, 1
	GOTO       L_main19
	NOP
;rf.c,47 :: 		}
L_main13:
;rf.c,48 :: 		}
	GOTO       L_main0
;rf.c,49 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
