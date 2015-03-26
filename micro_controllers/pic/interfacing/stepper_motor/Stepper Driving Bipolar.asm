
_main:

;Stepper Driving Bipolar.c,1 :: 		void main()
;Stepper Driving Bipolar.c,3 :: 		CMCON = 0x07;   // To turn off comparators
	MOVLW      7
	MOVWF      CMCON+0
;Stepper Driving Bipolar.c,4 :: 		ADCON1 = 0x06;  // To turn off analog to digital converters
	MOVLW      6
	MOVWF      ADCON1+0
;Stepper Driving Bipolar.c,6 :: 		TRISB = 0;        // PORT B as output port
	CLRF       TRISB+0
;Stepper Driving Bipolar.c,7 :: 		PORTB = 0x0F;
	MOVLW      15
	MOVWF      PORTB+0
;Stepper Driving Bipolar.c,9 :: 		while(1)
L_main0:
;Stepper Driving Bipolar.c,11 :: 		PORTB=0x01; //0001
	MOVLW      1
	MOVWF      PORTB+0
;Stepper Driving Bipolar.c,12 :: 		Delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main2:
	DECFSZ     R13+0, 1
	GOTO       L_main2
	DECFSZ     R12+0, 1
	GOTO       L_main2
	DECFSZ     R11+0, 1
	GOTO       L_main2
	NOP
	NOP
;Stepper Driving Bipolar.c,13 :: 		PORTB=0x02; //0010
	MOVLW      2
	MOVWF      PORTB+0
;Stepper Driving Bipolar.c,14 :: 		Delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
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
;Stepper Driving Bipolar.c,15 :: 		PORTB=0x04; //0100
	MOVLW      4
	MOVWF      PORTB+0
;Stepper Driving Bipolar.c,16 :: 		Delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main4:
	DECFSZ     R13+0, 1
	GOTO       L_main4
	DECFSZ     R12+0, 1
	GOTO       L_main4
	DECFSZ     R11+0, 1
	GOTO       L_main4
	NOP
	NOP
;Stepper Driving Bipolar.c,17 :: 		PORTB=0x08; //1000
	MOVLW      8
	MOVWF      PORTB+0
;Stepper Driving Bipolar.c,18 :: 		Delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main5:
	DECFSZ     R13+0, 1
	GOTO       L_main5
	DECFSZ     R12+0, 1
	GOTO       L_main5
	DECFSZ     R11+0, 1
	GOTO       L_main5
	NOP
	NOP
;Stepper Driving Bipolar.c,19 :: 		}
	GOTO       L_main0
;Stepper Driving Bipolar.c,20 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
