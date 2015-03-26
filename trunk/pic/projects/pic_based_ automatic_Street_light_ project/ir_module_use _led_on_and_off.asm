
_main:

;ir_module_use _led_on_and_off.c,4 :: 		void main()
;ir_module_use _led_on_and_off.c,11 :: 		TRISD = 0xFF; // PORTD as input
	MOVLW      255
	MOVWF      TRISD+0
;ir_module_use _led_on_and_off.c,12 :: 		TRISC = 0x00; // PORTC as output
	CLRF       TRISC+0
;ir_module_use _led_on_and_off.c,22 :: 		RC0_bit=1;
	BSF        RC0_bit+0, 0
;ir_module_use _led_on_and_off.c,23 :: 		RC1_bit=0;
	BCF        RC1_bit+0, 1
;ir_module_use _led_on_and_off.c,24 :: 		RC2_bit=0;
	BCF        RC2_bit+0, 2
;ir_module_use _led_on_and_off.c,25 :: 		RC3_bit=0;
	BCF        RC3_bit+0, 3
;ir_module_use _led_on_and_off.c,26 :: 		RC4_bit=0;
	BCF        RC4_bit+0, 4
;ir_module_use _led_on_and_off.c,28 :: 		while (1)        // endless loop
L_main0:
;ir_module_use _led_on_and_off.c,30 :: 		if (RD0_bit == 1)   // if button on RD0 pressed
	BTFSS      RD0_bit+0, 0
	GOTO       L_main2
;ir_module_use _led_on_and_off.c,32 :: 		RC1_bit=1;
	BSF        RC1_bit+0, 1
;ir_module_use _led_on_and_off.c,33 :: 		RC0_bit=0;
	BCF        RC0_bit+0, 0
;ir_module_use _led_on_and_off.c,34 :: 		}
	GOTO       L_main3
L_main2:
;ir_module_use _led_on_and_off.c,35 :: 		else if (RD1_bit == 1)               // button on RD1 pressed
	BTFSS      RD1_bit+0, 1
	GOTO       L_main4
;ir_module_use _led_on_and_off.c,37 :: 		RC2_bit=1;
	BSF        RC2_bit+0, 2
;ir_module_use _led_on_and_off.c,38 :: 		RC1_bit=0;
	BCF        RC1_bit+0, 1
;ir_module_use _led_on_and_off.c,39 :: 		}
	GOTO       L_main5
L_main4:
;ir_module_use _led_on_and_off.c,40 :: 		else if (RD2_bit == 1)               // button on RD1 pressed
	BTFSS      RD2_bit+0, 2
	GOTO       L_main6
;ir_module_use _led_on_and_off.c,42 :: 		RC3_bit=1;
	BSF        RC3_bit+0, 3
;ir_module_use _led_on_and_off.c,43 :: 		RC2_bit=0;
	BCF        RC2_bit+0, 2
;ir_module_use _led_on_and_off.c,44 :: 		}
	GOTO       L_main7
L_main6:
;ir_module_use _led_on_and_off.c,45 :: 		else if (RD3_bit == 1)               // button on RD1 pressed
	BTFSS      RD3_bit+0, 3
	GOTO       L_main8
;ir_module_use _led_on_and_off.c,47 :: 		RC4_bit=1;
	BSF        RC4_bit+0, 4
;ir_module_use _led_on_and_off.c,48 :: 		RC3_bit=0;
	BCF        RC3_bit+0, 3
;ir_module_use _led_on_and_off.c,49 :: 		}
	GOTO       L_main9
L_main8:
;ir_module_use _led_on_and_off.c,50 :: 		else if (RD4_bit == 1)               // button on RD1 pressed
	BTFSS      RD4_bit+0, 4
	GOTO       L_main10
;ir_module_use _led_on_and_off.c,52 :: 		RC4_bit=0;
	BCF        RC4_bit+0, 4
;ir_module_use _led_on_and_off.c,53 :: 		RC0_bit=1;
	BSF        RC0_bit+0, 0
;ir_module_use _led_on_and_off.c,54 :: 		}
L_main10:
L_main9:
L_main7:
L_main5:
L_main3:
;ir_module_use _led_on_and_off.c,55 :: 		Delay_ms(5);      // slow down change pace a little
	MOVLW      7
	MOVWF      R12+0
	MOVLW      125
	MOVWF      R13+0
L_main11:
	DECFSZ     R13+0, 1
	GOTO       L_main11
	DECFSZ     R12+0, 1
	GOTO       L_main11
;ir_module_use _led_on_and_off.c,56 :: 		}
	GOTO       L_main0
;ir_module_use _led_on_and_off.c,57 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
