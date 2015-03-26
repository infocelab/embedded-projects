
_main:

;motor_driver_interfacing_pic.c,1 :: 		void main()
;motor_driver_interfacing_pic.c,3 :: 		TRISB = 0; // PORT B as output port
	CLRF       TRISB+0
;motor_driver_interfacing_pic.c,4 :: 		PORTB = 1; // Set RB0 to high
	MOVLW      1
	MOVWF      PORTB+0
;motor_driver_interfacing_pic.c,5 :: 		do
L_main0:
;motor_driver_interfacing_pic.c,8 :: 		PORTB.F1 = 1;
	BSF        PORTB+0, 1
;motor_driver_interfacing_pic.c,9 :: 		Delay_ms(2000);//2 seconds delay
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
;motor_driver_interfacing_pic.c,12 :: 		PORTB = 0; // or PORTB = 3
	CLRF       PORTB+0
;motor_driver_interfacing_pic.c,13 :: 		Delay_ms(2000);//2 seconds delay
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
;motor_driver_interfacing_pic.c,16 :: 		PORTB.F2 = 1;
	BSF        PORTB+0, 2
;motor_driver_interfacing_pic.c,17 :: 		Delay_ms(2000);//2 seconds delay
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
;motor_driver_interfacing_pic.c,20 :: 		PORTB = 0; // or PORTB = 3 (3 = 0b00000011)
	CLRF       PORTB+0
;motor_driver_interfacing_pic.c,21 :: 		Delay_ms(2000); // 2 seconds delay
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main6:
	DECFSZ     R13+0, 1
	GOTO       L_main6
	DECFSZ     R12+0, 1
	GOTO       L_main6
	DECFSZ     R11+0, 1
	GOTO       L_main6
	NOP
	NOP
;motor_driver_interfacing_pic.c,23 :: 		}while(1);
	GOTO       L_main0
;motor_driver_interfacing_pic.c,24 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
