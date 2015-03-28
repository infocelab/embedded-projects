
_main:

;ir_module.c,1 :: 		void main()
;ir_module.c,5 :: 		TRISD = 0xFF; // PORTD as input
	MOVLW      255
	MOVWF      TRISD+0
;ir_module.c,6 :: 		TRISB = 0x00; // PORTB as output
	CLRF       TRISB+0
;ir_module.c,8 :: 		RB0_bit=0;
	BCF        RB0_bit+0, 0
;ir_module.c,10 :: 		while (1)
L_main0:
;ir_module.c,12 :: 		if (RD0_bit == 1)
	BTFSS      RD0_bit+0, 0
	GOTO       L_main2
;ir_module.c,14 :: 		RB0_bit=1;
	BSF        RB0_bit+0, 0
;ir_module.c,15 :: 		Delay_ms(1000);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
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
;ir_module.c,16 :: 		RB0_bit=0;
	BCF        RB0_bit+0, 0
;ir_module.c,17 :: 		}
L_main2:
;ir_module.c,19 :: 		}
	GOTO       L_main0
;ir_module.c,20 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
