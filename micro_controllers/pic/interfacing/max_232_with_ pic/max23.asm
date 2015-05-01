
_main:

;max23.c,2 :: 		void main() {
;max23.c,4 :: 		ADCON0=0x01;
	MOVLW      1
	MOVWF      ADCON0+0
;max23.c,5 :: 		ADCON1=0x0E;
	MOVLW      14
	MOVWF      ADCON1+0
;max23.c,6 :: 		UART1_Init(9600);               // Initialize UART module at 9600 bps
	MOVLW      25
	MOVWF      SPBRG+0
	BSF        TXSTA+0, 2
	CALL       _UART1_Init+0
;max23.c,7 :: 		Delay_ms(100);                  // Wait for UART module to stabilize
	MOVLW      130
	MOVWF      R12+0
	MOVLW      221
	MOVWF      R13+0
L_main0:
	DECFSZ     R13+0, 1
	GOTO       L_main0
	DECFSZ     R12+0, 1
	GOTO       L_main0
	NOP
	NOP
;max23.c,9 :: 		UART1_Write_Text("Embedded Projects");
	MOVLW      ?lstr1_max23+0
	MOVWF      FARG_UART1_Write_Text_uart_text+0
	CALL       _UART1_Write_Text+0
;max23.c,10 :: 		UART1_Write(0x0D);
	MOVLW      13
	MOVWF      FARG_UART1_Write_data_+0
	CALL       _UART1_Write+0
;max23.c,11 :: 		while(1)
L_main1:
;max23.c,13 :: 		UART1_Write_Text("hello");
	MOVLW      ?lstr2_max23+0
	MOVWF      FARG_UART1_Write_Text_uart_text+0
	CALL       _UART1_Write_Text+0
;max23.c,16 :: 		}
	GOTO       L_main1
;max23.c,17 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
