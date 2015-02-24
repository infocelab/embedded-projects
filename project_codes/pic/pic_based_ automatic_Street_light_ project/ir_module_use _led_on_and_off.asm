
_main:

;ir_module_use _led_on_and_off.c,4 :: 		void main()
;ir_module_use _led_on_and_off.c,6 :: 		short current_duty_1  = MIN; // initial value for current_duty_1
	MOVLW      10
	MOVWF      main_current_duty_1_L0+0
	MOVLW      10
	MOVWF      main_current_duty_2_L0+0
;ir_module_use _led_on_and_off.c,11 :: 		TRISD = 0xFF; // PORTD as input
	MOVLW      255
	MOVWF      TRISD+0
;ir_module_use _led_on_and_off.c,12 :: 		TRISC = 0x00; // PORTC as output
	CLRF       TRISC+0
;ir_module_use _led_on_and_off.c,14 :: 		PWM1_Init(5000);  // Initialize PWM1
	BCF        T2CON+0, 0
	BCF        T2CON+0, 1
	MOVLW      199
	MOVWF      PR2+0
	CALL       _PWM1_Init+0
;ir_module_use _led_on_and_off.c,15 :: 		PWM2_Init(5000);  // Initialize PWM2
	BCF        T2CON+0, 0
	BCF        T2CON+0, 1
	MOVLW      199
	MOVWF      PR2+0
	CALL       _PWM2_Init+0
;ir_module_use _led_on_and_off.c,17 :: 		PWM1_Start();  // start PWM1
	CALL       _PWM1_Start+0
;ir_module_use _led_on_and_off.c,18 :: 		PWM2_Start();  // start PWM2
	CALL       _PWM2_Start+0
;ir_module_use _led_on_and_off.c,20 :: 		PWM1_Set_Duty(current_duty_1); // Set current duty for PWM1
	MOVF       main_current_duty_1_L0+0, 0
	MOVWF      FARG_PWM1_Set_Duty_new_duty+0
	CALL       _PWM1_Set_Duty+0
;ir_module_use _led_on_and_off.c,21 :: 		PWM2_Set_Duty(current_duty_2); // Set current duty for PWM2
	MOVF       main_current_duty_2_L0+0, 0
	MOVWF      FARG_PWM2_Set_Duty_new_duty+0
	CALL       _PWM2_Set_Duty+0
;ir_module_use _led_on_and_off.c,23 :: 		while (1)        // endless loop
L_main0:
;ir_module_use _led_on_and_off.c,25 :: 		if (RD0_bit == 1)   // if button on RD0 pressed
	BTFSS      RD0_bit+0, 0
	GOTO       L_main2
;ir_module_use _led_on_and_off.c,27 :: 		Delay_ms(40);
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
;ir_module_use _led_on_and_off.c,28 :: 		current_duty_1 = MAX;  // increment current_duty_1
	MOVLW      40
	MOVWF      main_current_duty_1_L0+0
;ir_module_use _led_on_and_off.c,29 :: 		PWM1_Set_Duty(current_duty_1);  //Change the duty cycle
	MOVLW      40
	MOVWF      FARG_PWM1_Set_Duty_new_duty+0
	CALL       _PWM1_Set_Duty+0
;ir_module_use _led_on_and_off.c,30 :: 		}
	GOTO       L_main4
L_main2:
;ir_module_use _led_on_and_off.c,31 :: 		else if (RD1_bit == 1)               // button on RD1 pressed
	BTFSS      RD1_bit+0, 1
	GOTO       L_main5
;ir_module_use _led_on_and_off.c,33 :: 		Delay_ms(40);
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
;ir_module_use _led_on_and_off.c,34 :: 		current_duty_2 = MAX;  // increment current_duty_1
	MOVLW      40
	MOVWF      main_current_duty_2_L0+0
;ir_module_use _led_on_and_off.c,35 :: 		PWM2_Set_Duty(current_duty_2);  //Change the duty cycle
	MOVLW      40
	MOVWF      FARG_PWM2_Set_Duty_new_duty+0
	CALL       _PWM2_Set_Duty+0
;ir_module_use _led_on_and_off.c,36 :: 		}
L_main5:
L_main4:
;ir_module_use _led_on_and_off.c,37 :: 		if(current_duty_1 > MIN)
	MOVLW      128
	XORLW      10
	MOVWF      R0+0
	MOVLW      128
	XORWF      main_current_duty_1_L0+0, 0
	SUBWF      R0+0, 0
	BTFSC      STATUS+0, 0
	GOTO       L_main7
;ir_module_use _led_on_and_off.c,39 :: 		current_duty_1--;
	DECF       main_current_duty_1_L0+0, 1
;ir_module_use _led_on_and_off.c,40 :: 		PWM1_Set_Duty(current_duty_1);  //Change the duty cycle
	MOVF       main_current_duty_1_L0+0, 0
	MOVWF      FARG_PWM1_Set_Duty_new_duty+0
	CALL       _PWM1_Set_Duty+0
;ir_module_use _led_on_and_off.c,41 :: 		Delay_ms(30);
	MOVLW      39
	MOVWF      R12+0
	MOVLW      245
	MOVWF      R13+0
L_main8:
	DECFSZ     R13+0, 1
	GOTO       L_main8
	DECFSZ     R12+0, 1
	GOTO       L_main8
;ir_module_use _led_on_and_off.c,42 :: 		}
L_main7:
;ir_module_use _led_on_and_off.c,43 :: 		if(current_duty_2 > MIN)
	MOVLW      128
	XORLW      10
	MOVWF      R0+0
	MOVLW      128
	XORWF      main_current_duty_2_L0+0, 0
	SUBWF      R0+0, 0
	BTFSC      STATUS+0, 0
	GOTO       L_main9
;ir_module_use _led_on_and_off.c,45 :: 		current_duty_2--;
	DECF       main_current_duty_2_L0+0, 1
;ir_module_use _led_on_and_off.c,46 :: 		PWM2_Set_Duty(current_duty_2);  //Change the duty cycle
	MOVF       main_current_duty_2_L0+0, 0
	MOVWF      FARG_PWM2_Set_Duty_new_duty+0
	CALL       _PWM2_Set_Duty+0
;ir_module_use _led_on_and_off.c,47 :: 		Delay_ms(30);
	MOVLW      39
	MOVWF      R12+0
	MOVLW      245
	MOVWF      R13+0
L_main10:
	DECFSZ     R13+0, 1
	GOTO       L_main10
	DECFSZ     R12+0, 1
	GOTO       L_main10
;ir_module_use _led_on_and_off.c,48 :: 		}
L_main9:
;ir_module_use _led_on_and_off.c,49 :: 		Delay_ms(10);      // slow down change pace a little
	MOVLW      13
	MOVWF      R12+0
	MOVLW      251
	MOVWF      R13+0
L_main11:
	DECFSZ     R13+0, 1
	GOTO       L_main11
	DECFSZ     R12+0, 1
	GOTO       L_main11
	NOP
	NOP
;ir_module_use _led_on_and_off.c,50 :: 		}
	GOTO       L_main0
;ir_module_use _led_on_and_off.c,51 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
