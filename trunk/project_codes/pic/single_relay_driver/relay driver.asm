
_main:

;relay driver.c,1 :: 		void main()
;relay driver.c,3 :: 		trisb=0x00;
	CLRF       TRISB+0
;relay driver.c,4 :: 		while(1)
L_main0:
;relay driver.c,6 :: 		portb.rb0=0x00;
	BCF        PORTB+0, 0
;relay driver.c,7 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main2:
	DECFSZ     R13+0, 1
	GOTO       L_main2
	DECFSZ     R12+0, 1
	GOTO       L_main2
	DECFSZ     R11+0, 1
	GOTO       L_main2
	NOP
;relay driver.c,8 :: 		portb.rb0=0xff;
	BSF        PORTB+0, 0
;relay driver.c,9 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main3:
	DECFSZ     R13+0, 1
	GOTO       L_main3
	DECFSZ     R12+0, 1
	GOTO       L_main3
	DECFSZ     R11+0, 1
	GOTO       L_main3
	NOP
;relay driver.c,10 :: 		}
	GOTO       L_main0
;relay driver.c,12 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
