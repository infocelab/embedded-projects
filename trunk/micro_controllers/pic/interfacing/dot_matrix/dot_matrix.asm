
_main:

;dot_matrix.c,14 :: 		void main() {
;dot_matrix.c,16 :: 		unsigned char k,l,m=0,n;
	CLRF       main_m_L0+0
;dot_matrix.c,17 :: 		trisb=0;
	CLRF       TRISB+0
;dot_matrix.c,18 :: 		trisd=0;
	CLRF       TRISD+0
;dot_matrix.c,19 :: 		while(1)
L_main0:
;dot_matrix.c,22 :: 		for(n=0;n<100;n++)
	CLRF       R3+0
L_main2:
	MOVLW      100
	SUBWF      R3+0, 0
	BTFSC      STATUS+0, 0
	GOTO       L_main3
;dot_matrix.c,24 :: 		for(k=0;k<6;k++)
	CLRF       R1+0
L_main5:
	MOVLW      6
	SUBWF      R1+0, 0
	BTFSC      STATUS+0, 0
	GOTO       L_main6
;dot_matrix.c,26 :: 		portb=b[l];
	MOVF       R2+0, 0
	ADDLW      _b+0
	MOVWF      FSR
	MOVF       INDF+0, 0
	MOVWF      PORTB+0
;dot_matrix.c,27 :: 		portd=ch[k];
	MOVF       R1+0, 0
	ADDLW      _ch+0
	MOVWF      FSR
	MOVF       INDF+0, 0
	MOVWF      PORTD+0
;dot_matrix.c,29 :: 		delay_ms(8);
	MOVLW      11
	MOVWF      R12+0
	MOVLW      98
	MOVWF      R13+0
L_main8:
	DECFSZ     R13+0, 1
	GOTO       L_main8
	DECFSZ     R12+0, 1
	GOTO       L_main8
	NOP
;dot_matrix.c,30 :: 		l++;
	INCF       R2+0, 1
;dot_matrix.c,31 :: 		if(l==20){l=0;}
	MOVF       R2+0, 0
	XORLW      20
	BTFSS      STATUS+0, 2
	GOTO       L_main9
	CLRF       R2+0
L_main9:
;dot_matrix.c,24 :: 		for(k=0;k<6;k++)
	INCF       R1+0, 1
;dot_matrix.c,32 :: 		}
	GOTO       L_main5
L_main6:
;dot_matrix.c,33 :: 		l=m;
	MOVF       main_m_L0+0, 0
	MOVWF      R2+0
;dot_matrix.c,34 :: 		if(m==20){m=0;}
	MOVF       main_m_L0+0, 0
	XORLW      20
	BTFSS      STATUS+0, 2
	GOTO       L_main10
	CLRF       main_m_L0+0
L_main10:
;dot_matrix.c,22 :: 		for(n=0;n<100;n++)
	INCF       R3+0, 1
;dot_matrix.c,35 :: 		}
	GOTO       L_main2
L_main3:
;dot_matrix.c,36 :: 		m++;
	INCF       main_m_L0+0, 1
;dot_matrix.c,37 :: 		l=m;
	MOVF       main_m_L0+0, 0
	MOVWF      R2+0
;dot_matrix.c,38 :: 		}
	GOTO       L_main0
;dot_matrix.c,39 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
