
_main:

;MyProject.c,1 :: 		void main()
;MyProject.c,3 :: 		short current_duty_1  = 16; // initial value for current_duty_1
	MOVLW      16
	MOVWF      main_current_duty_1_L0+0
;MyProject.c,6 :: 		TRISD = 0xFF; // PORTD as input
	MOVLW      255
	MOVWF      TRISD+0
;MyProject.c,7 :: 		TRISC = 0x00; // PORTC as output
	CLRF       TRISC+0
;MyProject.c,9 :: 		PWM1_Init(5000);  // Initialize PWM1
	BCF        T2CON+0, 0
	BCF        T2CON+0, 1
	MOVLW      199
	MOVWF      PR2+0
	CALL       _PWM1_Init+0
;MyProject.c,12 :: 		PWM1_Start();  // start PWM1
	CALL       _PWM1_Start+0
;MyProject.c,15 :: 		PWM1_Set_Duty(current_duty_1); // Set current duty for PWM1
	MOVF       main_current_duty_1_L0+0, 0
	MOVWF      FARG_PWM1_Set_Duty_new_duty+0
	CALL       _PWM1_Set_Duty+0
;MyProject.c,18 :: 		while (1)        // endless loop
L_main0:
;MyProject.c,20 :: 		if (RD0_bit == 1)   // if button on RD0 pressed
	BTFSS      RD0_bit+0, 0
	GOTO       L_main2
;MyProject.c,22 :: 		Delay_ms(40);
	MOVLW      52
	MOVWF      R12+0
	MOVLW      241
	MOVWF      R13+0
L_main3:
	DECFSZ     R13+0, 1
	GOTO       L_main3
	DECFSZ     R12+0, 1
	GOTO       L_main3
	NOP
	NOP
;MyProject.c,23 :: 		current_duty_1 += 1;  // increment current_duty_1
	INCF       main_current_duty_1_L0+0, 1
;MyProject.c,24 :: 		PWM1_Set_Duty(current_duty_1);  //Change the duty cycle
	MOVF       main_current_duty_1_L0+0, 0
	MOVWF      FARG_PWM1_Set_Duty_new_duty+0
	CALL       _PWM1_Set_Duty+0
;MyProject.c,25 :: 		}
	GOTO       L_main4
L_main2:
;MyProject.c,27 :: 		else if (RD1_bit == 1)               // button on RD1 pressed
	BTFSS      RD1_bit+0, 1
	GOTO       L_main5
;MyProject.c,29 :: 		Delay_ms(40);
	MOVLW      52
	MOVWF      R12+0
	MOVLW      241
	MOVWF      R13+0
L_main6:
	DECFSZ     R13+0, 1
	GOTO       L_main6
	DECFSZ     R12+0, 1
	GOTO       L_main6
	NOP
	NOP
;MyProject.c,30 :: 		current_duty_1 -=1;  // decrement current_duty_1
	DECF       main_current_duty_1_L0+0, 1
;MyProject.c,31 :: 		PWM1_Set_Duty(current_duty_1);
	MOVF       main_current_duty_1_L0+0, 0
	MOVWF      FARG_PWM1_Set_Duty_new_duty+0
	CALL       _PWM1_Set_Duty+0
;MyProject.c,32 :: 		}
L_main5:
L_main4:
;MyProject.c,48 :: 		Delay_ms(10);      // slow down change pace a little
	MOVLW      13
	MOVWF      R12+0
	MOVLW      251
	MOVWF      R13+0
L_main7:
	DECFSZ     R13+0, 1
	GOTO       L_main7
	DECFSZ     R12+0, 1
	GOTO       L_main7
	NOP
	NOP
;MyProject.c,49 :: 		}
	GOTO       L_main0
;MyProject.c,50 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
