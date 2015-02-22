
_main:

;ir_module_use _led_on_and_off.c,1 :: 		void main()
;ir_module_use _led_on_and_off.c,3 :: 		trisb=0x00;
	CLRF       TRISB+0
;ir_module_use _led_on_and_off.c,4 :: 		while(1)
L_main0:
;ir_module_use _led_on_and_off.c,6 :: 		if( portd.rd0==1 && portd.rd1==0 && portd.rd2==0 && portd.rd3==0 && portd.rd4==0 && portd.rd5==0 && portd.rd6==0 && portd.rd7==0)
	BTFSS      PORTD+0, 0
	GOTO       L_main4
	BTFSC      PORTD+0, 1
	GOTO       L_main4
	BTFSC      PORTD+0, 2
	GOTO       L_main4
	BTFSC      PORTD+0, 3
	GOTO       L_main4
	BTFSC      PORTD+0, 4
	GOTO       L_main4
	BTFSC      PORTD+0, 5
	GOTO       L_main4
	BTFSC      PORTD+0, 6
	GOTO       L_main4
	BTFSC      PORTD+0, 7
	GOTO       L_main4
L__main18:
;ir_module_use _led_on_and_off.c,8 :: 		portb.rb0=1;
	BSF        PORTB+0, 0
;ir_module_use _led_on_and_off.c,9 :: 		portb.rb1=1;
	BSF        PORTB+0, 1
;ir_module_use _led_on_and_off.c,10 :: 		portb.rb2=0;
	BCF        PORTB+0, 2
;ir_module_use _led_on_and_off.c,11 :: 		portb.rb3=0;
	BCF        PORTB+0, 3
;ir_module_use _led_on_and_off.c,12 :: 		portb.rb4=0;
	BCF        PORTB+0, 4
;ir_module_use _led_on_and_off.c,13 :: 		portb.rb5=0;
	BCF        PORTB+0, 5
;ir_module_use _led_on_and_off.c,14 :: 		portb.rb6=0;
	BCF        PORTB+0, 6
;ir_module_use _led_on_and_off.c,15 :: 		portb.rb7=0;
	BCF        PORTB+0, 7
;ir_module_use _led_on_and_off.c,16 :: 		delay_ms(200);
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main5:
	DECFSZ     R13+0, 1
	GOTO       L_main5
	DECFSZ     R12+0, 1
	GOTO       L_main5
	DECFSZ     R11+0, 1
	GOTO       L_main5
	NOP
;ir_module_use _led_on_and_off.c,17 :: 		}
	GOTO       L_main6
L_main4:
;ir_module_use _led_on_and_off.c,18 :: 		else if(portd.rd0==0 && portd.rd1==1 && portd.rd2==0 && portd.rd3==0 && portd.rd4==0 && portd.rd5==0 && portd.rd6==0 && portd.rd7==0)
	BTFSC      PORTD+0, 0
	GOTO       L_main9
	BTFSS      PORTD+0, 1
	GOTO       L_main9
	BTFSC      PORTD+0, 2
	GOTO       L_main9
	BTFSC      PORTD+0, 3
	GOTO       L_main9
	BTFSC      PORTD+0, 4
	GOTO       L_main9
	BTFSC      PORTD+0, 5
	GOTO       L_main9
	BTFSC      PORTD+0, 6
	GOTO       L_main9
	BTFSC      PORTD+0, 7
	GOTO       L_main9
L__main17:
;ir_module_use _led_on_and_off.c,20 :: 		portb.rb0=1;
	BSF        PORTB+0, 0
;ir_module_use _led_on_and_off.c,21 :: 		portb.rb1=1;
	BSF        PORTB+0, 1
;ir_module_use _led_on_and_off.c,22 :: 		portb.rb2=0xff;
	BSF        PORTB+0, 2
;ir_module_use _led_on_and_off.c,23 :: 		portb.rb3=0xff;
	BSF        PORTB+0, 3
;ir_module_use _led_on_and_off.c,24 :: 		portb.rb4=0;
	BCF        PORTB+0, 4
;ir_module_use _led_on_and_off.c,25 :: 		portb.rb5=0;
	BCF        PORTB+0, 5
;ir_module_use _led_on_and_off.c,26 :: 		portb.rb6=0;
	BCF        PORTB+0, 6
;ir_module_use _led_on_and_off.c,27 :: 		portb.rb7=0;
	BCF        PORTB+0, 7
;ir_module_use _led_on_and_off.c,28 :: 		delay_ms(200);
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
;ir_module_use _led_on_and_off.c,29 :: 		}
	GOTO       L_main11
L_main9:
;ir_module_use _led_on_and_off.c,30 :: 		else if(portd.rd0==0 && portd.rd1==0 && portd.rd2==1 && portd.rd3==0 && portd.rd4==0 && portd.rd5==0 && portd.rd6==0 && portd.rd7==0)
	BTFSC      PORTD+0, 0
	GOTO       L_main14
	BTFSC      PORTD+0, 1
	GOTO       L_main14
	BTFSS      PORTD+0, 2
	GOTO       L_main14
	BTFSC      PORTD+0, 3
	GOTO       L_main14
	BTFSC      PORTD+0, 4
	GOTO       L_main14
	BTFSC      PORTD+0, 5
	GOTO       L_main14
	BTFSC      PORTD+0, 6
	GOTO       L_main14
	BTFSC      PORTD+0, 7
	GOTO       L_main14
L__main16:
;ir_module_use _led_on_and_off.c,33 :: 		portb.rb0=0;
	BCF        PORTB+0, 0
;ir_module_use _led_on_and_off.c,34 :: 		portb.rb1=0;
	BCF        PORTB+0, 1
;ir_module_use _led_on_and_off.c,35 :: 		portb.rb2=0;
	BCF        PORTB+0, 2
;ir_module_use _led_on_and_off.c,36 :: 		portb.rb3=0;
	BCF        PORTB+0, 3
;ir_module_use _led_on_and_off.c,37 :: 		portb.rb4=0;
	BCF        PORTB+0, 4
;ir_module_use _led_on_and_off.c,38 :: 		portb.rb5=0;
	BCF        PORTB+0, 5
;ir_module_use _led_on_and_off.c,39 :: 		portb.rb6=0;
	BCF        PORTB+0, 6
;ir_module_use _led_on_and_off.c,40 :: 		portb.rb7=0;
	BCF        PORTB+0, 7
;ir_module_use _led_on_and_off.c,41 :: 		delay_ms(200);
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
;ir_module_use _led_on_and_off.c,42 :: 		}
L_main14:
L_main11:
L_main6:
;ir_module_use _led_on_and_off.c,43 :: 		}
	GOTO       L_main0
;ir_module_use _led_on_and_off.c,45 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
