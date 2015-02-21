opt subtitle "HI-TECH Software Omniscient Code Generator (Lite mode) build 7503"

opt pagewidth 120

	opt lm

	processor	16F877A
clrc	macro
	bcf	3,0
	endm
clrz	macro
	bcf	3,2
	endm
setc	macro
	bsf	3,0
	endm
setz	macro
	bsf	3,2
	endm
skipc	macro
	btfss	3,0
	endm
skipz	macro
	btfss	3,2
	endm
skipnc	macro
	btfsc	3,0
	endm
skipnz	macro
	btfsc	3,2
	endm
indf	equ	0
indf0	equ	0
pc	equ	2
pcl	equ	2
status	equ	3
fsr	equ	4
fsr0	equ	4
c	equ	1
z	equ	0
pclath	equ	10
	FNCALL	_main,_PWM1_Init
	FNCALL	_main,_PWM2_Init
	FNCALL	_main,_PWM1_Duty
	FNCALL	_main,_PWM2_Duty
	FNCALL	_main,_PWM1_Start
	FNCALL	_main,_PWM2_Start
	FNCALL	_PWM2_Duty,___lwtoft
	FNCALL	_PWM2_Duty,___ftdiv
	FNCALL	_PWM2_Duty,_PWM_Max_Duty
	FNCALL	_PWM2_Duty,___awtoft
	FNCALL	_PWM2_Duty,___ftmul
	FNCALL	_PWM2_Duty,___fttol
	FNCALL	_PWM1_Duty,___lwtoft
	FNCALL	_PWM1_Duty,___ftdiv
	FNCALL	_PWM1_Duty,_PWM_Max_Duty
	FNCALL	_PWM1_Duty,___awtoft
	FNCALL	_PWM1_Duty,___ftmul
	FNCALL	_PWM1_Duty,___fttol
	FNCALL	___lwtoft,___ftpack
	FNCALL	___awtoft,___ftpack
	FNCALL	___ftmul,___ftpack
	FNCALL	___ftdiv,___ftpack
	FNCALL	_PWM2_Init,___aldiv
	FNCALL	_PWM1_Init,___aldiv
	FNCALL	_PWM_Max_Duty,___aldiv
	FNROOT	_main
	global	_CCPR1L
psect	text383,local,class=CODE,delta=2
global __ptext383
__ptext383:
_CCPR1L	set	21
	global	_CCPR2L
_CCPR2L	set	27
	global	_CCP1M2
_CCP1M2	set	186
	global	_CCP1M3
_CCP1M3	set	187
	global	_CCP1X
_CCP1X	set	189
	global	_CCP1Y
_CCP1Y	set	188
	global	_CCP2M2
_CCP2M2	set	234
	global	_CCP2M3
_CCP2M3	set	235
	global	_CCP2X
_CCP2X	set	237
	global	_CCP2Y
_CCP2Y	set	236
	global	_RD0
_RD0	set	64
	global	_RD1
_RD1	set	65
	global	_RD2
_RD2	set	66
	global	_RD3
_RD3	set	67
	global	_T2CKPS0
_T2CKPS0	set	144
	global	_T2CKPS1
_T2CKPS1	set	145
	global	_TMR2ON
_TMR2ON	set	146
	global	_PR2
_PR2	set	146
	global	_TRISB
_TRISB	set	134
	global	_TRISD
_TRISD	set	136
	global	_TRISC1
_TRISC1	set	1081
	global	_TRISC2
_TRISC2	set	1082
	global	_freq
psect	nvBANK0,class=BANK0,space=1
global __pnvBANK0
__pnvBANK0:
_freq:
       ds      4

	file	"pwm example.as"
	line	#
psect cinit,class=CODE,delta=2
global start_initialization
start_initialization:

psect cinit,class=CODE,delta=2
global end_of_initialization

;End of C runtime variable initialization code

end_of_initialization:
clrf status
ljmp _main	;jump to C main() function
psect	cstackCOMMON,class=COMMON,space=1
global __pcstackCOMMON
__pcstackCOMMON:
	global	??_PWM1_Start
??_PWM1_Start:	; 0 bytes @ 0x0
	global	??_PWM2_Start
??_PWM2_Start:	; 0 bytes @ 0x0
	global	?_main
?_main:	; 0 bytes @ 0x0
	global	?_PWM1_Start
?_PWM1_Start:	; 2 bytes @ 0x0
	global	?_PWM2_Start
?_PWM2_Start:	; 2 bytes @ 0x0
	global	?___ftpack
?___ftpack:	; 3 bytes @ 0x0
	global	?___aldiv
?___aldiv:	; 4 bytes @ 0x0
	global	___ftpack@arg
___ftpack@arg:	; 3 bytes @ 0x0
	global	___aldiv@divisor
___aldiv@divisor:	; 4 bytes @ 0x0
	ds	3
	global	___ftpack@exp
___ftpack@exp:	; 1 bytes @ 0x3
	ds	1
	global	___ftpack@sign
___ftpack@sign:	; 1 bytes @ 0x4
	global	___aldiv@dividend
___aldiv@dividend:	; 4 bytes @ 0x4
	ds	1
	global	??___ftpack
??___ftpack:	; 0 bytes @ 0x5
	ds	3
	global	??___aldiv
??___aldiv:	; 0 bytes @ 0x8
	ds	1
	global	??_PWM1_Init
??_PWM1_Init:	; 0 bytes @ 0x9
	global	??_PWM2_Init
??_PWM2_Init:	; 0 bytes @ 0x9
	global	??___fttol
??___fttol:	; 0 bytes @ 0x9
	ds	4
	global	??___lwtoft
??___lwtoft:	; 0 bytes @ 0xD
	global	___awtoft@sign
___awtoft@sign:	; 1 bytes @ 0xD
	ds	1
psect	cstackBANK0,class=BANK0,space=1
global __pcstackBANK0
__pcstackBANK0:
	global	___aldiv@counter
___aldiv@counter:	; 1 bytes @ 0x0
	ds	1
	global	___aldiv@sign
___aldiv@sign:	; 1 bytes @ 0x1
	ds	1
	global	___aldiv@quotient
___aldiv@quotient:	; 4 bytes @ 0x2
	ds	4
	global	?_PWM1_Init
?_PWM1_Init:	; 2 bytes @ 0x6
	global	?_PWM2_Init
?_PWM2_Init:	; 2 bytes @ 0x6
	global	?___fttol
?___fttol:	; 4 bytes @ 0x6
	global	___fttol@f1
___fttol@f1:	; 3 bytes @ 0x6
	global	PWM1_Init@fre
PWM1_Init@fre:	; 4 bytes @ 0x6
	global	PWM2_Init@fre
PWM2_Init@fre:	; 4 bytes @ 0x6
	ds	4
	global	___fttol@sign1
___fttol@sign1:	; 1 bytes @ 0xA
	ds	1
	global	___fttol@lval
___fttol@lval:	; 4 bytes @ 0xB
	ds	4
	global	___fttol@exp1
___fttol@exp1:	; 1 bytes @ 0xF
	ds	1
	global	?_PWM_Max_Duty
?_PWM_Max_Duty:	; 2 bytes @ 0x10
	global	?___lwtoft
?___lwtoft:	; 3 bytes @ 0x10
	global	___lwtoft@c
___lwtoft@c:	; 2 bytes @ 0x10
	ds	2
	global	??_PWM_Max_Duty
??_PWM_Max_Duty:	; 0 bytes @ 0x12
	ds	1
	global	?___ftdiv
?___ftdiv:	; 3 bytes @ 0x13
	global	___ftdiv@f2
___ftdiv@f2:	; 3 bytes @ 0x13
	ds	3
	global	?___awtoft
?___awtoft:	; 3 bytes @ 0x16
	global	___awtoft@c
___awtoft@c:	; 2 bytes @ 0x16
	global	___ftdiv@f1
___ftdiv@f1:	; 3 bytes @ 0x16
	ds	3
	global	??___ftdiv
??___ftdiv:	; 0 bytes @ 0x19
	global	??___awtoft
??___awtoft:	; 0 bytes @ 0x19
	ds	4
	global	___ftdiv@cntr
___ftdiv@cntr:	; 1 bytes @ 0x1D
	ds	1
	global	___ftdiv@f3
___ftdiv@f3:	; 3 bytes @ 0x1E
	ds	3
	global	___ftdiv@exp
___ftdiv@exp:	; 1 bytes @ 0x21
	ds	1
	global	___ftdiv@sign
___ftdiv@sign:	; 1 bytes @ 0x22
	ds	1
	global	?___ftmul
?___ftmul:	; 3 bytes @ 0x23
	global	___ftmul@f1
___ftmul@f1:	; 3 bytes @ 0x23
	ds	3
	global	___ftmul@f2
___ftmul@f2:	; 3 bytes @ 0x26
	ds	3
	global	??___ftmul
??___ftmul:	; 0 bytes @ 0x29
	ds	4
	global	___ftmul@exp
___ftmul@exp:	; 1 bytes @ 0x2D
	ds	1
	global	___ftmul@f3_as_product
___ftmul@f3_as_product:	; 3 bytes @ 0x2E
	ds	3
	global	___ftmul@cntr
___ftmul@cntr:	; 1 bytes @ 0x31
	ds	1
	global	___ftmul@sign
___ftmul@sign:	; 1 bytes @ 0x32
	ds	1
	global	?_PWM1_Duty
?_PWM1_Duty:	; 2 bytes @ 0x33
	global	?_PWM2_Duty
?_PWM2_Duty:	; 2 bytes @ 0x33
	global	PWM1_Duty@duty
PWM1_Duty@duty:	; 2 bytes @ 0x33
	global	PWM2_Duty@duty
PWM2_Duty@duty:	; 2 bytes @ 0x33
	ds	2
	global	??_PWM1_Duty
??_PWM1_Duty:	; 0 bytes @ 0x35
	global	??_PWM2_Duty
??_PWM2_Duty:	; 0 bytes @ 0x35
	ds	2
	global	??_main
??_main:	; 0 bytes @ 0x37
	ds	3
	global	main@i
main@i:	; 2 bytes @ 0x3A
	ds	2
	global	main@j
main@j:	; 2 bytes @ 0x3C
	ds	2
;;Data sizes: Strings 0, constant 0, data 0, bss 0, persistent 4 stack 0
;;Auto spaces:   Size  Autos    Used
;; COMMON          14     14      14
;; BANK0           80     62      66
;; BANK1           80      0       0
;; BANK3           96      0       0
;; BANK2           96      0       0

;;
;; Pointer list with targets:

;; ?___ftpack	float  size(1) Largest target is 0
;;
;; ?___fttol	long  size(1) Largest target is 0
;;
;; ?___ftdiv	float  size(1) Largest target is 0
;;
;; ?___lwtoft	float  size(1) Largest target is 0
;;
;; ?___ftmul	float  size(1) Largest target is 0
;;
;; ?___awtoft	float  size(1) Largest target is 0
;;
;; ?_PWM_Max_Duty	int  size(1) Largest target is 4
;;		 -> freq(BANK0[4]), 
;;
;; ?___aldiv	long  size(1) Largest target is 0
;;


;;
;; Critical Paths under _main in COMMON
;;
;;   _PWM2_Duty->___lwtoft
;;   _PWM2_Duty->___awtoft
;;   _PWM1_Duty->___lwtoft
;;   _PWM1_Duty->___awtoft
;;   ___lwtoft->___fttol
;;   ___awtoft->___fttol
;;   ___ftmul->___lwtoft
;;   ___ftmul->___awtoft
;;   ___ftdiv->___lwtoft
;;   _PWM2_Init->___aldiv
;;   _PWM1_Init->___aldiv
;;   _PWM_Max_Duty->___fttol
;;   ___fttol->___aldiv
;;
;; Critical Paths under _main in BANK0
;;
;;   _main->_PWM1_Duty
;;   _main->_PWM2_Duty
;;   _PWM2_Duty->___ftmul
;;   _PWM1_Duty->___ftmul
;;   ___lwtoft->___fttol
;;   ___awtoft->_PWM_Max_Duty
;;   ___ftmul->___ftdiv
;;   ___ftdiv->___lwtoft
;;   _PWM2_Init->___aldiv
;;   _PWM1_Init->___aldiv
;;   _PWM_Max_Duty->___fttol
;;   ___fttol->___aldiv
;;
;; Critical Paths under _main in BANK1
;;
;;   None.
;;
;; Critical Paths under _main in BANK3
;;
;;   None.
;;
;; Critical Paths under _main in BANK2
;;
;;   None.

;;
;;Main: autosize = 0, tempsize = 3, incstack = 0, save=0
;;

;;
;;Call Graph Tables:
;;
;; ---------------------------------------------------------------------------------
;; (Depth) Function   	        Calls       Base Space   Used Autos Params    Refs
;; ---------------------------------------------------------------------------------
;; (0) _main                                                 7     7      0    5262
;;                                             55 BANK0      7     7      0
;;                          _PWM1_Init
;;                          _PWM2_Init
;;                          _PWM1_Duty
;;                          _PWM2_Duty
;;                         _PWM1_Start
;;                         _PWM2_Start
;; ---------------------------------------------------------------------------------
;; (1) _PWM2_Duty                                            4     2      2    2196
;;                                             51 BANK0      4     2      2
;;                           ___lwtoft
;;                            ___ftdiv
;;                       _PWM_Max_Duty
;;                           ___awtoft
;;                            ___ftmul
;;                            ___fttol
;; ---------------------------------------------------------------------------------
;; (1) _PWM1_Duty                                            4     2      2    2196
;;                                             51 BANK0      4     2      2
;;                           ___lwtoft
;;                            ___ftdiv
;;                       _PWM_Max_Duty
;;                           ___awtoft
;;                            ___ftmul
;;                            ___fttol
;; ---------------------------------------------------------------------------------
;; (2) ___lwtoft                                             4     1      3     231
;;                                             13 COMMON     1     1      0
;;                                             16 BANK0      3     0      3
;;                           ___ftpack
;;                            ___fttol (ARG)
;; ---------------------------------------------------------------------------------
;; (2) ___awtoft                                             6     3      3     300
;;                                             13 COMMON     1     1      0
;;                                             22 BANK0      5     2      3
;;                           ___ftpack
;;                       _PWM_Max_Duty (ARG)
;;                            ___fttol (ARG)
;; ---------------------------------------------------------------------------------
;; (2) ___ftmul                                             16    10      6     535
;;                                             35 BANK0     16    10      6
;;                           ___ftpack
;;                            ___ftdiv (ARG)
;;                           ___lwtoft (ARG)
;;                           ___awtoft (ARG)
;;                       _PWM_Max_Duty (ARG)
;;                            ___fttol (ARG)
;; ---------------------------------------------------------------------------------
;; (2) ___ftdiv                                             16    10      6     489
;;                                             19 BANK0     16    10      6
;;                           ___ftpack
;;                           ___lwtoft (ARG)
;;                            ___fttol (ARG)
;; ---------------------------------------------------------------------------------
;; (1) _PWM2_Init                                            8     4      4     322
;;                                              9 COMMON     4     4      0
;;                                              6 BANK0      4     0      4
;;                            ___aldiv
;; ---------------------------------------------------------------------------------
;; (1) _PWM1_Init                                            8     4      4     322
;;                                              9 COMMON     4     4      0
;;                                              6 BANK0      4     0      4
;;                            ___aldiv
;; ---------------------------------------------------------------------------------
;; (2) _PWM_Max_Duty                                         6     4      2     300
;;                                             16 BANK0      6     4      2
;;                            ___aldiv
;;                            ___fttol (ARG)
;; ---------------------------------------------------------------------------------
;; (3) ___aldiv                                             15     7      8     300
;;                                              0 COMMON     9     1      8
;;                                              0 BANK0      6     6      0
;; ---------------------------------------------------------------------------------
;; (2) ___fttol                                             14    10      4     252
;;                                              9 COMMON     4     4      0
;;                                              6 BANK0     10     6      4
;;                           ___ftpack (ARG)
;;                            ___aldiv (ARG)
;; ---------------------------------------------------------------------------------
;; (3) ___ftpack                                             8     3      5     209
;;                                              0 COMMON     8     3      5
;; ---------------------------------------------------------------------------------
;; (1) _PWM2_Start                                           0     0      0       0
;; ---------------------------------------------------------------------------------
;; (1) _PWM1_Start                                           0     0      0       0
;; ---------------------------------------------------------------------------------
;; Estimated maximum stack depth 3
;; ---------------------------------------------------------------------------------

;; Call Graph Graphs:

;; _main (ROOT)
;;   _PWM1_Init
;;     ___aldiv
;;   _PWM2_Init
;;     ___aldiv
;;   _PWM1_Duty
;;     ___lwtoft
;;       ___ftpack
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     ___ftdiv
;;       ___ftpack
;;       ___lwtoft (ARG)
;;         ___ftpack
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     _PWM_Max_Duty
;;       ___aldiv
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     ___awtoft
;;       ___ftpack
;;       _PWM_Max_Duty (ARG)
;;         ___aldiv
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     ___ftmul
;;       ___ftpack
;;       ___ftdiv (ARG)
;;         ___ftpack
;;         ___lwtoft (ARG)
;;           ___ftpack
;;           ___fttol (ARG)
;;             ___ftpack (ARG)
;;             ___aldiv (ARG)
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___lwtoft (ARG)
;;         ___ftpack
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___awtoft (ARG)
;;         ___ftpack
;;         _PWM_Max_Duty (ARG)
;;           ___aldiv
;;           ___fttol (ARG)
;;             ___ftpack (ARG)
;;             ___aldiv (ARG)
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       _PWM_Max_Duty (ARG)
;;         ___aldiv
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     ___fttol
;;       ___ftpack (ARG)
;;       ___aldiv (ARG)
;;   _PWM2_Duty
;;     ___lwtoft
;;       ___ftpack
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     ___ftdiv
;;       ___ftpack
;;       ___lwtoft (ARG)
;;         ___ftpack
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     _PWM_Max_Duty
;;       ___aldiv
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     ___awtoft
;;       ___ftpack
;;       _PWM_Max_Duty (ARG)
;;         ___aldiv
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     ___ftmul
;;       ___ftpack
;;       ___ftdiv (ARG)
;;         ___ftpack
;;         ___lwtoft (ARG)
;;           ___ftpack
;;           ___fttol (ARG)
;;             ___ftpack (ARG)
;;             ___aldiv (ARG)
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___lwtoft (ARG)
;;         ___ftpack
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___awtoft (ARG)
;;         ___ftpack
;;         _PWM_Max_Duty (ARG)
;;           ___aldiv
;;           ___fttol (ARG)
;;             ___ftpack (ARG)
;;             ___aldiv (ARG)
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       _PWM_Max_Duty (ARG)
;;         ___aldiv
;;         ___fttol (ARG)
;;           ___ftpack (ARG)
;;           ___aldiv (ARG)
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;         ___aldiv (ARG)
;;     ___fttol
;;       ___ftpack (ARG)
;;       ___aldiv (ARG)
;;   _PWM1_Start
;;   _PWM2_Start
;;

;; Address spaces:

;;Name               Size   Autos  Total    Cost      Usage
;;BITCOMMON            E      0       0       0        0.0%
;;EEDATA             100      0       0       0        0.0%
;;NULL                 0      0       0       0        0.0%
;;CODE                 0      0       0       0        0.0%
;;COMMON               E      E       E       1      100.0%
;;BITSFR0              0      0       0       1        0.0%
;;SFR0                 0      0       0       1        0.0%
;;BITSFR1              0      0       0       2        0.0%
;;SFR1                 0      0       0       2        0.0%
;;STACK                0      0       3       2        0.0%
;;ABS                  0      0      50       3        0.0%
;;BITBANK0            50      0       0       4        0.0%
;;BITSFR3              0      0       0       4        0.0%
;;SFR3                 0      0       0       4        0.0%
;;BANK0               50     3E      42       5       82.5%
;;BITSFR2              0      0       0       5        0.0%
;;SFR2                 0      0       0       5        0.0%
;;BITBANK1            50      0       0       6        0.0%
;;BANK1               50      0       0       7        0.0%
;;BITBANK3            60      0       0       8        0.0%
;;BANK3               60      0       0       9        0.0%
;;BITBANK2            60      0       0      10        0.0%
;;BANK2               60      0       0      11        0.0%
;;DATA                 0      0      53      12        0.0%

	global	_main
psect	maintext,global,class=CODE,delta=2
global __pmaintext
__pmaintext:

;; *************** function _main *****************
;; Defined at:
;;		line 99 in file "G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
;; Parameters:    Size  Location     Type
;;		None
;; Auto vars:     Size  Location     Type
;;  j               2   60[BANK0 ] unsigned int 
;;  i               2   58[BANK0 ] unsigned int 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 17F/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         0       4       0       0       0
;;      Temps:          0       3       0       0       0
;;      Totals:         0       7       0       0       0
;;Total ram usage:        7 bytes
;; Hardware stack levels required when called:    3
;; This function calls:
;;		_PWM1_Init
;;		_PWM2_Init
;;		_PWM1_Duty
;;		_PWM2_Duty
;;		_PWM1_Start
;;		_PWM2_Start
;; This function is called by:
;;		Startup code after reset
;; This function uses a non-reentrant model
;;
psect	maintext
	file	"G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
	line	99
	global	__size_of_main
	__size_of_main	equ	__end_of_main-_main
	
_main:	
	opt	stack 5
; Regs used in _main: [wreg+status,2+status,0+pclath+cstack]
	line	100
	
l2567:	
;pwm example.c: 100: unsigned int i=0,j=0;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(main@i)
	clrf	(main@i+1)
	clrf	(main@j)
	clrf	(main@j+1)
	line	101
	
l2569:	
;pwm example.c: 101: PWM1_Init(5000);
	movlw	0
	movwf	(?_PWM1_Init+3)
	movlw	0
	movwf	(?_PWM1_Init+2)
	movlw	013h
	movwf	(?_PWM1_Init+1)
	movlw	088h
	movwf	(?_PWM1_Init)

	fcall	_PWM1_Init
	line	102
	
l2571:	
;pwm example.c: 102: PWM2_Init(5000);
	movlw	0
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(?_PWM2_Init+3)
	movlw	0
	movwf	(?_PWM2_Init+2)
	movlw	013h
	movwf	(?_PWM2_Init+1)
	movlw	088h
	movwf	(?_PWM2_Init)

	fcall	_PWM2_Init
	line	103
	
l2573:	
;pwm example.c: 103: TRISD = 0xFF;
	movlw	(0FFh)
	bsf	status, 5	;RP0=1, select bank1
	bcf	status, 6	;RP1=0, select bank1
	movwf	(136)^080h	;volatile
	line	104
	
l2575:	
;pwm example.c: 104: TRISB = 0;
	clrf	(134)^080h	;volatile
	line	107
	
l2577:	
;pwm example.c: 107: PWM1_Duty(0);
	movlw	low(0)
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(?_PWM1_Duty)
	movlw	high(0)
	movwf	((?_PWM1_Duty))+1
	fcall	_PWM1_Duty
	line	108
	
l2579:	
;pwm example.c: 108: PWM2_Duty(0);
	movlw	low(0)
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(?_PWM2_Duty)
	movlw	high(0)
	movwf	((?_PWM2_Duty))+1
	fcall	_PWM2_Duty
	line	109
	
l2581:	
;pwm example.c: 109: PWM1_Start();
	fcall	_PWM1_Start
	line	110
	
l2583:	
;pwm example.c: 110: PWM2_Start();
	fcall	_PWM2_Start
	goto	l2585
	line	111
;pwm example.c: 111: do
	
l718:	
	line	113
	
l2585:	
;pwm example.c: 112: {
;pwm example.c: 113: if(RD0 == 0 && i<1000)
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	btfsc	(64/8),(64)&7
	goto	u3331
	goto	u3330
u3331:
	goto	l2591
u3330:
	
l2587:	
	movlw	high(03E8h)
	subwf	(main@i+1),w
	movlw	low(03E8h)
	skipnz
	subwf	(main@i),w
	skipnc
	goto	u3341
	goto	u3340
u3341:
	goto	l2591
u3340:
	line	114
	
l2589:	
;pwm example.c: 114: i=i+10;
	movf	(main@i),w
	addlw	low(0Ah)
	movwf	(main@i)
	movf	(main@i+1),w
	skipnc
	addlw	1
	addlw	high(0Ah)
	movwf	1+(main@i)
	goto	l2591
	
l719:	
	line	115
	
l2591:	
;pwm example.c: 115: if(RD1 == 0 && i>0)
	btfsc	(65/8),(65)&7
	goto	u3351
	goto	u3350
u3351:
	goto	l2597
u3350:
	
l2593:	
	movf	(main@i+1),w
	iorwf	(main@i),w
	skipnz
	goto	u3361
	goto	u3360
u3361:
	goto	l2597
u3360:
	line	116
	
l2595:	
;pwm example.c: 116: i=i-10;
	movf	(main@i),w
	addlw	low(0FFF6h)
	movwf	(main@i)
	movf	(main@i+1),w
	skipnc
	addlw	1
	addlw	high(0FFF6h)
	movwf	1+(main@i)
	goto	l2597
	
l720:	
	line	117
	
l2597:	
;pwm example.c: 117: if(RD2 == 0 && j<1000)
	btfsc	(66/8),(66)&7
	goto	u3371
	goto	u3370
u3371:
	goto	l2603
u3370:
	
l2599:	
	movlw	high(03E8h)
	subwf	(main@j+1),w
	movlw	low(03E8h)
	skipnz
	subwf	(main@j),w
	skipnc
	goto	u3381
	goto	u3380
u3381:
	goto	l2603
u3380:
	line	118
	
l2601:	
;pwm example.c: 118: j=j+10;
	movf	(main@j),w
	addlw	low(0Ah)
	movwf	(main@j)
	movf	(main@j+1),w
	skipnc
	addlw	1
	addlw	high(0Ah)
	movwf	1+(main@j)
	goto	l2603
	
l721:	
	line	119
	
l2603:	
;pwm example.c: 119: if(RD3 == 0 && j>0)
	btfsc	(67/8),(67)&7
	goto	u3391
	goto	u3390
u3391:
	goto	l2609
u3390:
	
l2605:	
	movf	(main@j+1),w
	iorwf	(main@j),w
	skipnz
	goto	u3401
	goto	u3400
u3401:
	goto	l2609
u3400:
	line	120
	
l2607:	
;pwm example.c: 120: j=j-10;
	movf	(main@j),w
	addlw	low(0FFF6h)
	movwf	(main@j)
	movf	(main@j+1),w
	skipnc
	addlw	1
	addlw	high(0FFF6h)
	movwf	1+(main@j)
	goto	l2609
	
l722:	
	line	121
	
l2609:	
;pwm example.c: 121: PWM1_Duty(i);
	movf	(main@i+1),w
	clrf	(?_PWM1_Duty+1)
	addwf	(?_PWM1_Duty+1)
	movf	(main@i),w
	clrf	(?_PWM1_Duty)
	addwf	(?_PWM1_Duty)

	fcall	_PWM1_Duty
	line	122
	
l2611:	
;pwm example.c: 122: PWM2_Duty(j);
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(main@j+1),w
	clrf	(?_PWM2_Duty+1)
	addwf	(?_PWM2_Duty+1)
	movf	(main@j),w
	clrf	(?_PWM2_Duty)
	addwf	(?_PWM2_Duty)

	fcall	_PWM2_Duty
	line	126
	
l2613:	
;pwm example.c: 126: _delay((unsigned long)((50)*(20000000/4000.0)));
	opt asmopt_off
movlw  2
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
movwf	((??_main+0)+0+2),f
movlw	68
movwf	((??_main+0)+0+1),f
	movlw	169
movwf	((??_main+0)+0),f
u3417:
	decfsz	((??_main+0)+0),f
	goto	u3417
	decfsz	((??_main+0)+0+1),f
	goto	u3417
	decfsz	((??_main+0)+0+2),f
	goto	u3417
	clrwdt
opt asmopt_on

	line	127
;pwm example.c: 127: }while(1);
	goto	l2585
	
l723:	
	line	128
	
l724:	
	global	start
	ljmp	start
	opt stack 0
GLOBAL	__end_of_main
	__end_of_main:
;; =============== function _main ends ============

	signat	_main,88
	global	_PWM2_Duty
psect	text384,local,class=CODE,delta=2
global __ptext384
__ptext384:

;; *************** function _PWM2_Duty *****************
;; Defined at:
;;		line 36 in file "G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
;; Parameters:    Size  Location     Type
;;  duty            2   51[BANK0 ] unsigned int 
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  2   51[BANK0 ] int 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       2       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          0       2       0       0       0
;;      Totals:         0       4       0       0       0
;;Total ram usage:        4 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    2
;; This function calls:
;;		___lwtoft
;;		___ftdiv
;;		_PWM_Max_Duty
;;		___awtoft
;;		___ftmul
;;		___fttol
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text384
	file	"G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
	line	36
	global	__size_of_PWM2_Duty
	__size_of_PWM2_Duty	equ	__end_of_PWM2_Duty-_PWM2_Duty
	
_PWM2_Duty:	
	opt	stack 5
; Regs used in _PWM2_Duty: [wreg+status,2+status,0+pclath+cstack]
	line	37
	
l2557:	
;pwm example.c: 37: if(duty<1024)
	movlw	high(0400h)
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	subwf	(PWM2_Duty@duty+1),w
	movlw	low(0400h)
	skipnz
	subwf	(PWM2_Duty@duty),w
	skipnc
	goto	u3291
	goto	u3290
u3291:
	goto	l703
u3290:
	line	39
	
l2559:	
;pwm example.c: 38: {
;pwm example.c: 39: duty = ((float)duty/1023)*PWM_Max_Duty();
	movf	(PWM2_Duty@duty+1),w
	clrf	(?___lwtoft+1)
	addwf	(?___lwtoft+1)
	movf	(PWM2_Duty@duty),w
	clrf	(?___lwtoft)
	addwf	(?___lwtoft)

	fcall	___lwtoft
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___lwtoft)),w
	movwf	0+(?___ftdiv)+03h
	movf	(1+(?___lwtoft)),w
	movwf	1+(?___ftdiv)+03h
	movf	(2+(?___lwtoft)),w
	movwf	2+(?___ftdiv)+03h
	movlw	0xc0
	movwf	(?___ftdiv)
	movlw	0x7f
	movwf	(?___ftdiv+1)
	movlw	0x44
	movwf	(?___ftdiv+2)
	fcall	___ftdiv
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___ftdiv)),w
	movwf	0+(?___ftmul)+03h
	movf	(1+(?___ftdiv)),w
	movwf	1+(?___ftmul)+03h
	movf	(2+(?___ftdiv)),w
	movwf	2+(?___ftmul)+03h
	fcall	_PWM_Max_Duty
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(1+(?_PWM_Max_Duty)),w
	clrf	(?___awtoft+1)
	addwf	(?___awtoft+1)
	movf	(0+(?_PWM_Max_Duty)),w
	clrf	(?___awtoft)
	addwf	(?___awtoft)

	fcall	___awtoft
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___awtoft)),w
	movwf	(?___ftmul)
	movf	(1+(?___awtoft)),w
	movwf	(?___ftmul+1)
	movf	(2+(?___awtoft)),w
	movwf	(?___ftmul+2)
	fcall	___ftmul
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___ftmul)),w
	movwf	(?___fttol)
	movf	(1+(?___ftmul)),w
	movwf	(?___fttol+1)
	movf	(2+(?___ftmul)),w
	movwf	(?___fttol+2)
	fcall	___fttol
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	1+(((0+(?___fttol)))),w
	clrf	(PWM2_Duty@duty+1)
	addwf	(PWM2_Duty@duty+1)
	movf	0+(((0+(?___fttol)))),w
	clrf	(PWM2_Duty@duty)
	addwf	(PWM2_Duty@duty)

	line	40
	
l2561:	
;pwm example.c: 40: CCP2X = duty & 2;
	bcf	(237/8),(237)&7
	line	41
	
l2563:	
;pwm example.c: 41: CCP2Y = duty & 1;
	btfsc	(PWM2_Duty@duty),0
	goto	u3301
	goto	u3300
	
u3301:
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bsf	(236/8),(236)&7
	goto	u3314
u3300:
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bcf	(236/8),(236)&7
u3314:
	line	42
	
l2565:	
;pwm example.c: 42: CCPR2L = duty>>2;
	movf	(PWM2_Duty@duty+1),w
	movwf	(??_PWM2_Duty+0)+0+1
	movf	(PWM2_Duty@duty),w
	movwf	(??_PWM2_Duty+0)+0
	movlw	02h
u3325:
	clrc
	rrf	(??_PWM2_Duty+0)+1,f
	rrf	(??_PWM2_Duty+0)+0,f
	addlw	-1
	skipz
	goto	u3325
	movf	0+(??_PWM2_Duty+0)+0,w
	movwf	(27)	;volatile
	goto	l703
	line	43
	
l702:	
	line	44
	
l703:	
	return
	opt stack 0
GLOBAL	__end_of_PWM2_Duty
	__end_of_PWM2_Duty:
;; =============== function _PWM2_Duty ends ============

	signat	_PWM2_Duty,4218
	global	_PWM1_Duty
psect	text385,local,class=CODE,delta=2
global __ptext385
__ptext385:

;; *************** function _PWM1_Duty *****************
;; Defined at:
;;		line 25 in file "G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
;; Parameters:    Size  Location     Type
;;  duty            2   51[BANK0 ] unsigned int 
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  2   51[BANK0 ] int 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       2       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          0       2       0       0       0
;;      Totals:         0       4       0       0       0
;;Total ram usage:        4 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    2
;; This function calls:
;;		___lwtoft
;;		___ftdiv
;;		_PWM_Max_Duty
;;		___awtoft
;;		___ftmul
;;		___fttol
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text385
	file	"G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
	line	25
	global	__size_of_PWM1_Duty
	__size_of_PWM1_Duty	equ	__end_of_PWM1_Duty-_PWM1_Duty
	
_PWM1_Duty:	
	opt	stack 5
; Regs used in _PWM1_Duty: [wreg+status,2+status,0+pclath+cstack]
	line	26
	
l2547:	
;pwm example.c: 26: if(duty<1024)
	movlw	high(0400h)
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	subwf	(PWM1_Duty@duty+1),w
	movlw	low(0400h)
	skipnz
	subwf	(PWM1_Duty@duty),w
	skipnc
	goto	u3251
	goto	u3250
u3251:
	goto	l699
u3250:
	line	28
	
l2549:	
;pwm example.c: 27: {
;pwm example.c: 28: duty = ((float)duty/1023)*PWM_Max_Duty();
	movf	(PWM1_Duty@duty+1),w
	clrf	(?___lwtoft+1)
	addwf	(?___lwtoft+1)
	movf	(PWM1_Duty@duty),w
	clrf	(?___lwtoft)
	addwf	(?___lwtoft)

	fcall	___lwtoft
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___lwtoft)),w
	movwf	0+(?___ftdiv)+03h
	movf	(1+(?___lwtoft)),w
	movwf	1+(?___ftdiv)+03h
	movf	(2+(?___lwtoft)),w
	movwf	2+(?___ftdiv)+03h
	movlw	0xc0
	movwf	(?___ftdiv)
	movlw	0x7f
	movwf	(?___ftdiv+1)
	movlw	0x44
	movwf	(?___ftdiv+2)
	fcall	___ftdiv
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___ftdiv)),w
	movwf	0+(?___ftmul)+03h
	movf	(1+(?___ftdiv)),w
	movwf	1+(?___ftmul)+03h
	movf	(2+(?___ftdiv)),w
	movwf	2+(?___ftmul)+03h
	fcall	_PWM_Max_Duty
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(1+(?_PWM_Max_Duty)),w
	clrf	(?___awtoft+1)
	addwf	(?___awtoft+1)
	movf	(0+(?_PWM_Max_Duty)),w
	clrf	(?___awtoft)
	addwf	(?___awtoft)

	fcall	___awtoft
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___awtoft)),w
	movwf	(?___ftmul)
	movf	(1+(?___awtoft)),w
	movwf	(?___ftmul+1)
	movf	(2+(?___awtoft)),w
	movwf	(?___ftmul+2)
	fcall	___ftmul
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___ftmul)),w
	movwf	(?___fttol)
	movf	(1+(?___ftmul)),w
	movwf	(?___fttol+1)
	movf	(2+(?___ftmul)),w
	movwf	(?___fttol+2)
	fcall	___fttol
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	1+(((0+(?___fttol)))),w
	clrf	(PWM1_Duty@duty+1)
	addwf	(PWM1_Duty@duty+1)
	movf	0+(((0+(?___fttol)))),w
	clrf	(PWM1_Duty@duty)
	addwf	(PWM1_Duty@duty)

	line	29
	
l2551:	
;pwm example.c: 29: CCP1X = duty & 2;
	bcf	(189/8),(189)&7
	line	30
	
l2553:	
;pwm example.c: 30: CCP1Y = duty & 1;
	btfsc	(PWM1_Duty@duty),0
	goto	u3261
	goto	u3260
	
u3261:
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bsf	(188/8),(188)&7
	goto	u3274
u3260:
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bcf	(188/8),(188)&7
u3274:
	line	31
	
l2555:	
;pwm example.c: 31: CCPR1L = duty>>2;
	movf	(PWM1_Duty@duty+1),w
	movwf	(??_PWM1_Duty+0)+0+1
	movf	(PWM1_Duty@duty),w
	movwf	(??_PWM1_Duty+0)+0
	movlw	02h
u3285:
	clrc
	rrf	(??_PWM1_Duty+0)+1,f
	rrf	(??_PWM1_Duty+0)+0,f
	addlw	-1
	skipz
	goto	u3285
	movf	0+(??_PWM1_Duty+0)+0,w
	movwf	(21)	;volatile
	goto	l699
	line	32
	
l698:	
	line	33
	
l699:	
	return
	opt stack 0
GLOBAL	__end_of_PWM1_Duty
	__end_of_PWM1_Duty:
;; =============== function _PWM1_Duty ends ============

	signat	_PWM1_Duty,4218
	global	___lwtoft
psect	text386,local,class=CODE,delta=2
global __ptext386
__ptext386:

;; *************** function ___lwtoft *****************
;; Defined at:
;;		line 29 in file "C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\lwtoft.c"
;; Parameters:    Size  Location     Type
;;  c               2   16[BANK0 ] unsigned int 
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  3   16[BANK0 ] float 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       3       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         1       3       0       0       0
;;Total ram usage:        4 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___ftpack
;; This function is called by:
;;		_PWM1_Duty
;;		_PWM2_Duty
;; This function uses a non-reentrant model
;;
psect	text386
	file	"C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\lwtoft.c"
	line	29
	global	__size_of___lwtoft
	__size_of___lwtoft	equ	__end_of___lwtoft-___lwtoft
	
___lwtoft:	
	opt	stack 5
; Regs used in ___lwtoft: [wreg+status,2+status,0+pclath+cstack]
	line	30
	
l2543:	
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(___lwtoft@c),w
	movwf	(?___ftpack)
	movf	(___lwtoft@c+1),w
	movwf	(?___ftpack+1)
	clrf	(?___ftpack+2)
	movlw	(08Eh)
	movwf	(??___lwtoft+0)+0
	movf	(??___lwtoft+0)+0,w
	movwf	0+(?___ftpack)+03h
	clrf	0+(?___ftpack)+04h
	fcall	___ftpack
	movf	(0+(?___ftpack)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(?___lwtoft)
	movf	(1+(?___ftpack)),w
	movwf	(?___lwtoft+1)
	movf	(2+(?___ftpack)),w
	movwf	(?___lwtoft+2)
	goto	l956
	
l2545:	
	line	31
	
l956:	
	return
	opt stack 0
GLOBAL	__end_of___lwtoft
	__end_of___lwtoft:
;; =============== function ___lwtoft ends ============

	signat	___lwtoft,4219
	global	___awtoft
psect	text387,local,class=CODE,delta=2
global __ptext387
__ptext387:

;; *************** function ___awtoft *****************
;; Defined at:
;;		line 33 in file "C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\awtoft.c"
;; Parameters:    Size  Location     Type
;;  c               2   22[BANK0 ] int 
;; Auto vars:     Size  Location     Type
;;  sign            1   13[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;                  3   22[BANK0 ] float 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       3       0       0       0
;;      Locals:         1       0       0       0       0
;;      Temps:          0       2       0       0       0
;;      Totals:         1       5       0       0       0
;;Total ram usage:        6 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___ftpack
;; This function is called by:
;;		_PWM1_Duty
;;		_PWM2_Duty
;; This function uses a non-reentrant model
;;
psect	text387
	file	"C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\awtoft.c"
	line	33
	global	__size_of___awtoft
	__size_of___awtoft	equ	__end_of___awtoft-___awtoft
	
___awtoft:	
	opt	stack 5
; Regs used in ___awtoft: [wreg+status,2+status,0+pclath+cstack]
	line	36
	
l2535:	
	clrf	(___awtoft@sign)
	line	37
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	btfss	(___awtoft@c+1),7
	goto	u3241
	goto	u3240
u3241:
	goto	l2539
u3240:
	line	38
	
l2537:	
	comf	(___awtoft@c),f
	comf	(___awtoft@c+1),f
	incf	(___awtoft@c),f
	skipnz
	incf	(___awtoft@c+1),f
	line	39
	clrf	(___awtoft@sign)
	bsf	status,0
	rlf	(___awtoft@sign),f
	goto	l2539
	line	40
	
l869:	
	line	41
	
l2539:	
	movf	(___awtoft@c),w
	movwf	(?___ftpack)
	movf	(___awtoft@c+1),w
	movwf	(?___ftpack+1)
	clrf	(?___ftpack+2)
	movlw	(08Eh)
	movwf	(??___awtoft+0)+0
	movf	(??___awtoft+0)+0,w
	movwf	0+(?___ftpack)+03h
	movf	(___awtoft@sign),w
	movwf	(??___awtoft+1)+0
	movf	(??___awtoft+1)+0,w
	movwf	0+(?___ftpack)+04h
	fcall	___ftpack
	movf	(0+(?___ftpack)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(?___awtoft)
	movf	(1+(?___ftpack)),w
	movwf	(?___awtoft+1)
	movf	(2+(?___ftpack)),w
	movwf	(?___awtoft+2)
	goto	l870
	
l2541:	
	line	42
	
l870:	
	return
	opt stack 0
GLOBAL	__end_of___awtoft
	__end_of___awtoft:
;; =============== function ___awtoft ends ============

	signat	___awtoft,4219
	global	___ftmul
psect	text388,local,class=CODE,delta=2
global __ptext388
__ptext388:

;; *************** function ___ftmul *****************
;; Defined at:
;;		line 52 in file "C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\ftmul.c"
;; Parameters:    Size  Location     Type
;;  f1              3   35[BANK0 ] float 
;;  f2              3   38[BANK0 ] float 
;; Auto vars:     Size  Location     Type
;;  f3_as_produc    3   46[BANK0 ] unsigned um
;;  sign            1   50[BANK0 ] unsigned char 
;;  cntr            1   49[BANK0 ] unsigned char 
;;  exp             1   45[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  3   35[BANK0 ] float 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       6       0       0       0
;;      Locals:         0       6       0       0       0
;;      Temps:          0       4       0       0       0
;;      Totals:         0      16       0       0       0
;;Total ram usage:       16 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___ftpack
;; This function is called by:
;;		_PWM1_Duty
;;		_PWM2_Duty
;; This function uses a non-reentrant model
;;
psect	text388
	file	"C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\ftmul.c"
	line	52
	global	__size_of___ftmul
	__size_of___ftmul	equ	__end_of___ftmul-___ftmul
	
___ftmul:	
	opt	stack 5
; Regs used in ___ftmul: [wreg+status,2+status,0+pclath+cstack]
	line	56
	
l2485:	
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(___ftmul@f1),w
	movwf	((??___ftmul+0)+0)
	movf	(___ftmul@f1+1),w
	movwf	((??___ftmul+0)+0+1)
	movf	(___ftmul@f1+2),w
	movwf	((??___ftmul+0)+0+2)
	clrc
	rlf	(??___ftmul+0)+1,w
	rlf	(??___ftmul+0)+2,w
	movwf	(??___ftmul+3)+0
	movf	(??___ftmul+3)+0,w
	movwf	(___ftmul@exp)
	movf	((___ftmul@exp)),f
	skipz
	goto	u3101
	goto	u3100
u3101:
	goto	l2491
u3100:
	line	57
	
l2487:	
	movlw	0x0
	movwf	(?___ftmul)
	movlw	0x0
	movwf	(?___ftmul+1)
	movlw	0x0
	movwf	(?___ftmul+2)
	goto	l832
	
l2489:	
	goto	l832
	
l831:	
	line	58
	
l2491:	
	movf	(___ftmul@f2),w
	movwf	((??___ftmul+0)+0)
	movf	(___ftmul@f2+1),w
	movwf	((??___ftmul+0)+0+1)
	movf	(___ftmul@f2+2),w
	movwf	((??___ftmul+0)+0+2)
	clrc
	rlf	(??___ftmul+0)+1,w
	rlf	(??___ftmul+0)+2,w
	movwf	(??___ftmul+3)+0
	movf	(??___ftmul+3)+0,w
	movwf	(___ftmul@sign)
	movf	((___ftmul@sign)),f
	skipz
	goto	u3111
	goto	u3110
u3111:
	goto	l2497
u3110:
	line	59
	
l2493:	
	movlw	0x0
	movwf	(?___ftmul)
	movlw	0x0
	movwf	(?___ftmul+1)
	movlw	0x0
	movwf	(?___ftmul+2)
	goto	l832
	
l2495:	
	goto	l832
	
l833:	
	line	60
	
l2497:	
	movf	(___ftmul@sign),w
	addlw	07Bh
	movwf	(??___ftmul+0)+0
	movf	(??___ftmul+0)+0,w
	addwf	(___ftmul@exp),f
	line	61
	movf	(___ftmul@f1),w
	movwf	((??___ftmul+0)+0)
	movf	(___ftmul@f1+1),w
	movwf	((??___ftmul+0)+0+1)
	movf	(___ftmul@f1+2),w
	movwf	((??___ftmul+0)+0+2)
	movlw	010h
u3125:
	clrc
	rrf	(??___ftmul+0)+2,f
	rrf	(??___ftmul+0)+1,f
	rrf	(??___ftmul+0)+0,f
u3120:
	addlw	-1
	skipz
	goto	u3125
	movf	0+(??___ftmul+0)+0,w
	movwf	(??___ftmul+3)+0
	movf	(??___ftmul+3)+0,w
	movwf	(___ftmul@sign)
	line	62
	movf	(___ftmul@f2),w
	movwf	((??___ftmul+0)+0)
	movf	(___ftmul@f2+1),w
	movwf	((??___ftmul+0)+0+1)
	movf	(___ftmul@f2+2),w
	movwf	((??___ftmul+0)+0+2)
	movlw	010h
u3135:
	clrc
	rrf	(??___ftmul+0)+2,f
	rrf	(??___ftmul+0)+1,f
	rrf	(??___ftmul+0)+0,f
u3130:
	addlw	-1
	skipz
	goto	u3135
	movf	0+(??___ftmul+0)+0,w
	movwf	(??___ftmul+3)+0
	movf	(??___ftmul+3)+0,w
	xorwf	(___ftmul@sign),f
	line	63
	movlw	(080h)
	movwf	(??___ftmul+0)+0
	movf	(??___ftmul+0)+0,w
	andwf	(___ftmul@sign),f
	line	64
	
l2499:	
	bsf	(___ftmul@f1)+(15/8),(15)&7
	line	66
	
l2501:	
	bsf	(___ftmul@f2)+(15/8),(15)&7
	line	67
	
l2503:	
	movlw	0FFh
	andwf	(___ftmul@f2),f
	movlw	0FFh
	andwf	(___ftmul@f2+1),f
	movlw	0
	andwf	(___ftmul@f2+2),f
	line	68
	
l2505:	
	movlw	0
	movwf	(___ftmul@f3_as_product)
	movlw	0
	movwf	(___ftmul@f3_as_product+1)
	movlw	0
	movwf	(___ftmul@f3_as_product+2)
	line	69
	
l2507:	
	movlw	(07h)
	movwf	(??___ftmul+0)+0
	movf	(??___ftmul+0)+0,w
	movwf	(___ftmul@cntr)
	goto	l2509
	line	70
	
l834:	
	line	71
	
l2509:	
	btfss	(___ftmul@f1),(0)&7
	goto	u3141
	goto	u3140
u3141:
	goto	l2513
u3140:
	line	72
	
l2511:	
	movf	(___ftmul@f2),w
	addwf	(___ftmul@f3_as_product),f
	movf	(___ftmul@f2+1),w
	clrz
	skipnc
	incf	(___ftmul@f2+1),w
	skipnz
	goto	u3151
	addwf	(___ftmul@f3_as_product+1),f
u3151:
	movf	(___ftmul@f2+2),w
	clrz
	skipnc
	incf	(___ftmul@f2+2),w
	skipnz
	goto	u3152
	addwf	(___ftmul@f3_as_product+2),f
u3152:

	goto	l2513
	
l835:	
	line	73
	
l2513:	
	movlw	01h
u3165:
	clrc
	rrf	(___ftmul@f1+2),f
	rrf	(___ftmul@f1+1),f
	rrf	(___ftmul@f1),f
	addlw	-1
	skipz
	goto	u3165

	line	74
	
l2515:	
	movlw	01h
u3175:
	clrc
	rlf	(___ftmul@f2),f
	rlf	(___ftmul@f2+1),f
	rlf	(___ftmul@f2+2),f
	addlw	-1
	skipz
	goto	u3175
	line	75
	
l2517:	
	movlw	low(01h)
	subwf	(___ftmul@cntr),f
	btfss	status,2
	goto	u3181
	goto	u3180
u3181:
	goto	l2509
u3180:
	goto	l2519
	
l836:	
	line	76
	
l2519:	
	movlw	(09h)
	movwf	(??___ftmul+0)+0
	movf	(??___ftmul+0)+0,w
	movwf	(___ftmul@cntr)
	goto	l2521
	line	77
	
l837:	
	line	78
	
l2521:	
	btfss	(___ftmul@f1),(0)&7
	goto	u3191
	goto	u3190
u3191:
	goto	l2525
u3190:
	line	79
	
l2523:	
	movf	(___ftmul@f2),w
	addwf	(___ftmul@f3_as_product),f
	movf	(___ftmul@f2+1),w
	clrz
	skipnc
	incf	(___ftmul@f2+1),w
	skipnz
	goto	u3201
	addwf	(___ftmul@f3_as_product+1),f
u3201:
	movf	(___ftmul@f2+2),w
	clrz
	skipnc
	incf	(___ftmul@f2+2),w
	skipnz
	goto	u3202
	addwf	(___ftmul@f3_as_product+2),f
u3202:

	goto	l2525
	
l838:	
	line	80
	
l2525:	
	movlw	01h
u3215:
	clrc
	rrf	(___ftmul@f1+2),f
	rrf	(___ftmul@f1+1),f
	rrf	(___ftmul@f1),f
	addlw	-1
	skipz
	goto	u3215

	line	81
	
l2527:	
	movlw	01h
u3225:
	clrc
	rrf	(___ftmul@f3_as_product+2),f
	rrf	(___ftmul@f3_as_product+1),f
	rrf	(___ftmul@f3_as_product),f
	addlw	-1
	skipz
	goto	u3225

	line	82
	
l2529:	
	movlw	low(01h)
	subwf	(___ftmul@cntr),f
	btfss	status,2
	goto	u3231
	goto	u3230
u3231:
	goto	l2521
u3230:
	goto	l2531
	
l839:	
	line	83
	
l2531:	
	movf	(___ftmul@f3_as_product),w
	movwf	(?___ftpack)
	movf	(___ftmul@f3_as_product+1),w
	movwf	(?___ftpack+1)
	movf	(___ftmul@f3_as_product+2),w
	movwf	(?___ftpack+2)
	movf	(___ftmul@exp),w
	movwf	(??___ftmul+0)+0
	movf	(??___ftmul+0)+0,w
	movwf	0+(?___ftpack)+03h
	movf	(___ftmul@sign),w
	movwf	(??___ftmul+1)+0
	movf	(??___ftmul+1)+0,w
	movwf	0+(?___ftpack)+04h
	fcall	___ftpack
	movf	(0+(?___ftpack)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(?___ftmul)
	movf	(1+(?___ftpack)),w
	movwf	(?___ftmul+1)
	movf	(2+(?___ftpack)),w
	movwf	(?___ftmul+2)
	goto	l832
	
l2533:	
	line	84
	
l832:	
	return
	opt stack 0
GLOBAL	__end_of___ftmul
	__end_of___ftmul:
;; =============== function ___ftmul ends ============

	signat	___ftmul,8315
	global	___ftdiv
psect	text389,local,class=CODE,delta=2
global __ptext389
__ptext389:

;; *************** function ___ftdiv *****************
;; Defined at:
;;		line 50 in file "C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\ftdiv.c"
;; Parameters:    Size  Location     Type
;;  f2              3   19[BANK0 ] float 
;;  f1              3   22[BANK0 ] float 
;; Auto vars:     Size  Location     Type
;;  f3              3   30[BANK0 ] float 
;;  sign            1   34[BANK0 ] unsigned char 
;;  exp             1   33[BANK0 ] unsigned char 
;;  cntr            1   29[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  3   19[BANK0 ] float 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       6       0       0       0
;;      Locals:         0       6       0       0       0
;;      Temps:          0       4       0       0       0
;;      Totals:         0      16       0       0       0
;;Total ram usage:       16 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___ftpack
;; This function is called by:
;;		_PWM1_Duty
;;		_PWM2_Duty
;; This function uses a non-reentrant model
;;
psect	text389
	file	"C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\ftdiv.c"
	line	50
	global	__size_of___ftdiv
	__size_of___ftdiv	equ	__end_of___ftdiv-___ftdiv
	
___ftdiv:	
	opt	stack 5
; Regs used in ___ftdiv: [wreg+status,2+status,0+pclath+cstack]
	line	55
	
l2443:	
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(___ftdiv@f1),w
	movwf	((??___ftdiv+0)+0)
	movf	(___ftdiv@f1+1),w
	movwf	((??___ftdiv+0)+0+1)
	movf	(___ftdiv@f1+2),w
	movwf	((??___ftdiv+0)+0+2)
	clrc
	rlf	(??___ftdiv+0)+1,w
	rlf	(??___ftdiv+0)+2,w
	movwf	(??___ftdiv+3)+0
	movf	(??___ftdiv+3)+0,w
	movwf	(___ftdiv@exp)
	movf	((___ftdiv@exp)),f
	skipz
	goto	u3021
	goto	u3020
u3021:
	goto	l2449
u3020:
	line	56
	
l2445:	
	movlw	0x0
	movwf	(?___ftdiv)
	movlw	0x0
	movwf	(?___ftdiv+1)
	movlw	0x0
	movwf	(?___ftdiv+2)
	goto	l822
	
l2447:	
	goto	l822
	
l821:	
	line	57
	
l2449:	
	movf	(___ftdiv@f2),w
	movwf	((??___ftdiv+0)+0)
	movf	(___ftdiv@f2+1),w
	movwf	((??___ftdiv+0)+0+1)
	movf	(___ftdiv@f2+2),w
	movwf	((??___ftdiv+0)+0+2)
	clrc
	rlf	(??___ftdiv+0)+1,w
	rlf	(??___ftdiv+0)+2,w
	movwf	(??___ftdiv+3)+0
	movf	(??___ftdiv+3)+0,w
	movwf	(___ftdiv@sign)
	movf	((___ftdiv@sign)),f
	skipz
	goto	u3031
	goto	u3030
u3031:
	goto	l2455
u3030:
	line	58
	
l2451:	
	movlw	0x0
	movwf	(?___ftdiv)
	movlw	0x0
	movwf	(?___ftdiv+1)
	movlw	0x0
	movwf	(?___ftdiv+2)
	goto	l822
	
l2453:	
	goto	l822
	
l823:	
	line	59
	
l2455:	
	movlw	0
	movwf	(___ftdiv@f3)
	movlw	0
	movwf	(___ftdiv@f3+1)
	movlw	0
	movwf	(___ftdiv@f3+2)
	line	60
	
l2457:	
	movlw	(089h)
	addwf	(___ftdiv@sign),w
	movwf	(??___ftdiv+0)+0
	movf	0+(??___ftdiv+0)+0,w
	subwf	(___ftdiv@exp),f
	line	61
	
l2459:	
	movf	(___ftdiv@f1),w
	movwf	((??___ftdiv+0)+0)
	movf	(___ftdiv@f1+1),w
	movwf	((??___ftdiv+0)+0+1)
	movf	(___ftdiv@f1+2),w
	movwf	((??___ftdiv+0)+0+2)
	movlw	010h
u3045:
	clrc
	rrf	(??___ftdiv+0)+2,f
	rrf	(??___ftdiv+0)+1,f
	rrf	(??___ftdiv+0)+0,f
u3040:
	addlw	-1
	skipz
	goto	u3045
	movf	0+(??___ftdiv+0)+0,w
	movwf	(??___ftdiv+3)+0
	movf	(??___ftdiv+3)+0,w
	movwf	(___ftdiv@sign)
	line	62
	
l2461:	
	movf	(___ftdiv@f2),w
	movwf	((??___ftdiv+0)+0)
	movf	(___ftdiv@f2+1),w
	movwf	((??___ftdiv+0)+0+1)
	movf	(___ftdiv@f2+2),w
	movwf	((??___ftdiv+0)+0+2)
	movlw	010h
u3055:
	clrc
	rrf	(??___ftdiv+0)+2,f
	rrf	(??___ftdiv+0)+1,f
	rrf	(??___ftdiv+0)+0,f
u3050:
	addlw	-1
	skipz
	goto	u3055
	movf	0+(??___ftdiv+0)+0,w
	movwf	(??___ftdiv+3)+0
	movf	(??___ftdiv+3)+0,w
	xorwf	(___ftdiv@sign),f
	line	63
	
l2463:	
	movlw	(080h)
	movwf	(??___ftdiv+0)+0
	movf	(??___ftdiv+0)+0,w
	andwf	(___ftdiv@sign),f
	line	64
	
l2465:	
	bsf	(___ftdiv@f1)+(15/8),(15)&7
	line	65
	movlw	0FFh
	andwf	(___ftdiv@f1),f
	movlw	0FFh
	andwf	(___ftdiv@f1+1),f
	movlw	0
	andwf	(___ftdiv@f1+2),f
	line	66
	
l2467:	
	bsf	(___ftdiv@f2)+(15/8),(15)&7
	line	67
	movlw	0FFh
	andwf	(___ftdiv@f2),f
	movlw	0FFh
	andwf	(___ftdiv@f2+1),f
	movlw	0
	andwf	(___ftdiv@f2+2),f
	line	68
	movlw	(018h)
	movwf	(??___ftdiv+0)+0
	movf	(??___ftdiv+0)+0,w
	movwf	(___ftdiv@cntr)
	goto	l2469
	line	69
	
l824:	
	line	70
	
l2469:	
	movlw	01h
u3065:
	clrc
	rlf	(___ftdiv@f3),f
	rlf	(___ftdiv@f3+1),f
	rlf	(___ftdiv@f3+2),f
	addlw	-1
	skipz
	goto	u3065
	line	71
	
l2471:	
	movf	(___ftdiv@f2+2),w
	subwf	(___ftdiv@f1+2),w
	skipz
	goto	u3075
	movf	(___ftdiv@f2+1),w
	subwf	(___ftdiv@f1+1),w
	skipz
	goto	u3075
	movf	(___ftdiv@f2),w
	subwf	(___ftdiv@f1),w
u3075:
	skipc
	goto	u3071
	goto	u3070
u3071:
	goto	l2477
u3070:
	line	72
	
l2473:	
	movf	(___ftdiv@f2),w
	subwf	(___ftdiv@f1),f
	movf	(___ftdiv@f2+1),w
	skipc
	incfsz	(___ftdiv@f2+1),w
	subwf	(___ftdiv@f1+1),f
	movf	(___ftdiv@f2+2),w
	skipc
	incf	(___ftdiv@f2+2),w
	subwf	(___ftdiv@f1+2),f
	line	73
	
l2475:	
	bsf	(___ftdiv@f3)+(0/8),(0)&7
	goto	l2477
	line	74
	
l825:	
	line	75
	
l2477:	
	movlw	01h
u3085:
	clrc
	rlf	(___ftdiv@f1),f
	rlf	(___ftdiv@f1+1),f
	rlf	(___ftdiv@f1+2),f
	addlw	-1
	skipz
	goto	u3085
	line	76
	
l2479:	
	movlw	low(01h)
	subwf	(___ftdiv@cntr),f
	btfss	status,2
	goto	u3091
	goto	u3090
u3091:
	goto	l2469
u3090:
	goto	l2481
	
l826:	
	line	77
	
l2481:	
	movf	(___ftdiv@f3),w
	movwf	(?___ftpack)
	movf	(___ftdiv@f3+1),w
	movwf	(?___ftpack+1)
	movf	(___ftdiv@f3+2),w
	movwf	(?___ftpack+2)
	movf	(___ftdiv@exp),w
	movwf	(??___ftdiv+0)+0
	movf	(??___ftdiv+0)+0,w
	movwf	0+(?___ftpack)+03h
	movf	(___ftdiv@sign),w
	movwf	(??___ftdiv+1)+0
	movf	(??___ftdiv+1)+0,w
	movwf	0+(?___ftpack)+04h
	fcall	___ftpack
	movf	(0+(?___ftpack)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(?___ftdiv)
	movf	(1+(?___ftpack)),w
	movwf	(?___ftdiv+1)
	movf	(2+(?___ftpack)),w
	movwf	(?___ftdiv+2)
	goto	l822
	
l2483:	
	line	78
	
l822:	
	return
	opt stack 0
GLOBAL	__end_of___ftdiv
	__end_of___ftdiv:
;; =============== function ___ftdiv ends ============

	signat	___ftdiv,8315
	global	_PWM2_Init
psect	text390,local,class=CODE,delta=2
global __ptext390
__ptext390:

;; *************** function _PWM2_Init *****************
;; Defined at:
;;		line 19 in file "G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
;; Parameters:    Size  Location     Type
;;  fre             4    6[BANK0 ] long 
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  2    6[BANK0 ] int 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       4       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          4       0       0       0       0
;;      Totals:         4       4       0       0       0
;;Total ram usage:        8 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___aldiv
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text390
	file	"G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
	line	19
	global	__size_of_PWM2_Init
	__size_of_PWM2_Init	equ	__end_of_PWM2_Init-_PWM2_Init
	
_PWM2_Init:	
	opt	stack 6
; Regs used in _PWM2_Init: [wreg+status,2+status,0+pclath+cstack]
	line	20
	
l2439:	
;pwm example.c: 20: PR2 = (20000000/(freq*4*4)) - 1;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(_freq),w
	movwf	(??_PWM2_Init+0)+0
	movf	(_freq+1),w
	movwf	((??_PWM2_Init+0)+0+1)
	movf	(_freq+2),w
	movwf	((??_PWM2_Init+0)+0+2)
	movf	(_freq+3),w
	movwf	((??_PWM2_Init+0)+0+3)
	movlw	02h
u3005:
	clrc
	rlf	(??_PWM2_Init+0)+0,f
	rlf	(??_PWM2_Init+0)+1,f
	rlf	(??_PWM2_Init+0)+2,f
	rlf	(??_PWM2_Init+0)+3,f
u3000:
	addlw	-1
	skipz
	goto	u3005
	movlw	02h
u3015:
	clrc
	rlf	(??_PWM2_Init+0)+0,f
	rlf	(??_PWM2_Init+0)+1,f
	rlf	(??_PWM2_Init+0)+2,f
	rlf	(??_PWM2_Init+0)+3,f
u3010:
	addlw	-1
	skipz
	goto	u3015
	movf	3+(??_PWM2_Init+0)+0,w
	movwf	(?___aldiv+3)
	movf	2+(??_PWM2_Init+0)+0,w
	movwf	(?___aldiv+2)
	movf	1+(??_PWM2_Init+0)+0,w
	movwf	(?___aldiv+1)
	movf	0+(??_PWM2_Init+0)+0,w
	movwf	(?___aldiv)

	movlw	01h
	movwf	3+(?___aldiv)+04h
	movlw	031h
	movwf	2+(?___aldiv)+04h
	movlw	02Dh
	movwf	1+(?___aldiv)+04h
	movlw	0
	movwf	0+(?___aldiv)+04h

	fcall	___aldiv
	movf	0+(((0+(?___aldiv)))),w
	addlw	0FFh
	bsf	status, 5	;RP0=1, select bank1
	bcf	status, 6	;RP1=0, select bank1
	movwf	(146)^080h	;volatile
	line	21
	
l2441:	
;pwm example.c: 21: freq = fre;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(PWM2_Init@fre+3),w
	movwf	(_freq+3)
	movf	(PWM2_Init@fre+2),w
	movwf	(_freq+2)
	movf	(PWM2_Init@fre+1),w
	movwf	(_freq+1)
	movf	(PWM2_Init@fre),w
	movwf	(_freq)

	line	22
	
l695:	
	return
	opt stack 0
GLOBAL	__end_of_PWM2_Init
	__end_of_PWM2_Init:
;; =============== function _PWM2_Init ends ============

	signat	_PWM2_Init,4218
	global	_PWM1_Init
psect	text391,local,class=CODE,delta=2
global __ptext391
__ptext391:

;; *************** function _PWM1_Init *****************
;; Defined at:
;;		line 13 in file "G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
;; Parameters:    Size  Location     Type
;;  fre             4    6[BANK0 ] long 
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  2    6[BANK0 ] int 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       4       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          4       0       0       0       0
;;      Totals:         4       4       0       0       0
;;Total ram usage:        8 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___aldiv
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text391
	file	"G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
	line	13
	global	__size_of_PWM1_Init
	__size_of_PWM1_Init	equ	__end_of_PWM1_Init-_PWM1_Init
	
_PWM1_Init:	
	opt	stack 6
; Regs used in _PWM1_Init: [wreg+status,2+status,0+pclath+cstack]
	line	14
	
l2435:	
;pwm example.c: 14: PR2 = (20000000/(freq*4*4)) - 1;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(_freq),w
	movwf	(??_PWM1_Init+0)+0
	movf	(_freq+1),w
	movwf	((??_PWM1_Init+0)+0+1)
	movf	(_freq+2),w
	movwf	((??_PWM1_Init+0)+0+2)
	movf	(_freq+3),w
	movwf	((??_PWM1_Init+0)+0+3)
	movlw	02h
u2985:
	clrc
	rlf	(??_PWM1_Init+0)+0,f
	rlf	(??_PWM1_Init+0)+1,f
	rlf	(??_PWM1_Init+0)+2,f
	rlf	(??_PWM1_Init+0)+3,f
u2980:
	addlw	-1
	skipz
	goto	u2985
	movlw	02h
u2995:
	clrc
	rlf	(??_PWM1_Init+0)+0,f
	rlf	(??_PWM1_Init+0)+1,f
	rlf	(??_PWM1_Init+0)+2,f
	rlf	(??_PWM1_Init+0)+3,f
u2990:
	addlw	-1
	skipz
	goto	u2995
	movf	3+(??_PWM1_Init+0)+0,w
	movwf	(?___aldiv+3)
	movf	2+(??_PWM1_Init+0)+0,w
	movwf	(?___aldiv+2)
	movf	1+(??_PWM1_Init+0)+0,w
	movwf	(?___aldiv+1)
	movf	0+(??_PWM1_Init+0)+0,w
	movwf	(?___aldiv)

	movlw	01h
	movwf	3+(?___aldiv)+04h
	movlw	031h
	movwf	2+(?___aldiv)+04h
	movlw	02Dh
	movwf	1+(?___aldiv)+04h
	movlw	0
	movwf	0+(?___aldiv)+04h

	fcall	___aldiv
	movf	0+(((0+(?___aldiv)))),w
	addlw	0FFh
	bsf	status, 5	;RP0=1, select bank1
	bcf	status, 6	;RP1=0, select bank1
	movwf	(146)^080h	;volatile
	line	15
	
l2437:	
;pwm example.c: 15: freq = fre;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(PWM1_Init@fre+3),w
	movwf	(_freq+3)
	movf	(PWM1_Init@fre+2),w
	movwf	(_freq+2)
	movf	(PWM1_Init@fre+1),w
	movwf	(_freq+1)
	movf	(PWM1_Init@fre),w
	movwf	(_freq)

	line	16
	
l692:	
	return
	opt stack 0
GLOBAL	__end_of_PWM1_Init
	__end_of_PWM1_Init:
;; =============== function _PWM1_Init ends ============

	signat	_PWM1_Init,4218
	global	_PWM_Max_Duty
psect	text392,local,class=CODE,delta=2
global __ptext392
__ptext392:

;; *************** function _PWM_Max_Duty *****************
;; Defined at:
;;		line 8 in file "G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
;; Parameters:    Size  Location     Type
;;		None
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  2   16[BANK0 ] int 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       2       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          0       4       0       0       0
;;      Totals:         0       6       0       0       0
;;Total ram usage:        6 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___aldiv
;; This function is called by:
;;		_PWM1_Duty
;;		_PWM2_Duty
;; This function uses a non-reentrant model
;;
psect	text392
	file	"G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
	line	8
	global	__size_of_PWM_Max_Duty
	__size_of_PWM_Max_Duty	equ	__end_of_PWM_Max_Duty-_PWM_Max_Duty
	
_PWM_Max_Duty:	
	opt	stack 5
; Regs used in _PWM_Max_Duty: [wreg+status,2+status,0+pclath+cstack]
	line	9
	
l2431:	
;pwm example.c: 9: return(20000000/(freq*4);
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(_freq),w
	movwf	(??_PWM_Max_Duty+0)+0
	movf	(_freq+1),w
	movwf	((??_PWM_Max_Duty+0)+0+1)
	movf	(_freq+2),w
	movwf	((??_PWM_Max_Duty+0)+0+2)
	movf	(_freq+3),w
	movwf	((??_PWM_Max_Duty+0)+0+3)
	movlw	02h
u2975:
	clrc
	rlf	(??_PWM_Max_Duty+0)+0,f
	rlf	(??_PWM_Max_Duty+0)+1,f
	rlf	(??_PWM_Max_Duty+0)+2,f
	rlf	(??_PWM_Max_Duty+0)+3,f
u2970:
	addlw	-1
	skipz
	goto	u2975
	movf	3+(??_PWM_Max_Duty+0)+0,w
	movwf	(?___aldiv+3)
	movf	2+(??_PWM_Max_Duty+0)+0,w
	movwf	(?___aldiv+2)
	movf	1+(??_PWM_Max_Duty+0)+0,w
	movwf	(?___aldiv+1)
	movf	0+(??_PWM_Max_Duty+0)+0,w
	movwf	(?___aldiv)

	movlw	01h
	movwf	3+(?___aldiv)+04h
	movlw	031h
	movwf	2+(?___aldiv)+04h
	movlw	02Dh
	movwf	1+(?___aldiv)+04h
	movlw	0
	movwf	0+(?___aldiv)+04h

	fcall	___aldiv
	movf	1+(((0+(?___aldiv)))),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(?_PWM_Max_Duty+1)
	addwf	(?_PWM_Max_Duty+1)
	movf	0+(((0+(?___aldiv)))),w
	clrf	(?_PWM_Max_Duty)
	addwf	(?_PWM_Max_Duty)

	goto	l689
	
l2433:	
	line	10
	
l689:	
	return
	opt stack 0
GLOBAL	__end_of_PWM_Max_Duty
	__end_of_PWM_Max_Duty:
;; =============== function _PWM_Max_Duty ends ============

	signat	_PWM_Max_Duty,90
	global	___aldiv
psect	text393,local,class=CODE,delta=2
global __ptext393
__ptext393:

;; *************** function ___aldiv *****************
;; Defined at:
;;		line 5 in file "C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\aldiv.c"
;; Parameters:    Size  Location     Type
;;  divisor         4    0[COMMON] long 
;;  dividend        4    4[COMMON] long 
;; Auto vars:     Size  Location     Type
;;  quotient        4    2[BANK0 ] long 
;;  sign            1    1[BANK0 ] unsigned char 
;;  counter         1    0[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  4    0[COMMON] long 
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         8       0       0       0       0
;;      Locals:         0       6       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         9       6       0       0       0
;;Total ram usage:       15 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_PWM_Max_Duty
;;		_PWM1_Init
;;		_PWM2_Init
;; This function uses a non-reentrant model
;;
psect	text393
	file	"C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\aldiv.c"
	line	5
	global	__size_of___aldiv
	__size_of___aldiv	equ	__end_of___aldiv-___aldiv
	
___aldiv:	
	opt	stack 5
; Regs used in ___aldiv: [wreg+status,2+status,0]
	line	9
	
l2347:	
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(___aldiv@sign)
	line	10
	btfss	(___aldiv@divisor+3),7
	goto	u2811
	goto	u2810
u2811:
	goto	l2353
u2810:
	line	11
	
l2349:	
	comf	(___aldiv@divisor),f
	comf	(___aldiv@divisor+1),f
	comf	(___aldiv@divisor+2),f
	comf	(___aldiv@divisor+3),f
	incf	(___aldiv@divisor),f
	skipnz
	incf	(___aldiv@divisor+1),f
	skipnz
	incf	(___aldiv@divisor+2),f
	skipnz
	incf	(___aldiv@divisor+3),f
	line	12
	
l2351:	
	clrf	(___aldiv@sign)
	bsf	status,0
	rlf	(___aldiv@sign),f
	goto	l2353
	line	13
	
l928:	
	line	14
	
l2353:	
	btfss	(___aldiv@dividend+3),7
	goto	u2821
	goto	u2820
u2821:
	goto	l2359
u2820:
	line	15
	
l2355:	
	comf	(___aldiv@dividend),f
	comf	(___aldiv@dividend+1),f
	comf	(___aldiv@dividend+2),f
	comf	(___aldiv@dividend+3),f
	incf	(___aldiv@dividend),f
	skipnz
	incf	(___aldiv@dividend+1),f
	skipnz
	incf	(___aldiv@dividend+2),f
	skipnz
	incf	(___aldiv@dividend+3),f
	line	16
	
l2357:	
	movlw	(01h)
	movwf	(??___aldiv+0)+0
	movf	(??___aldiv+0)+0,w
	xorwf	(___aldiv@sign),f
	goto	l2359
	line	17
	
l929:	
	line	18
	
l2359:	
	movlw	0
	movwf	(___aldiv@quotient+3)
	movlw	0
	movwf	(___aldiv@quotient+2)
	movlw	0
	movwf	(___aldiv@quotient+1)
	movlw	0
	movwf	(___aldiv@quotient)

	line	19
	
l2361:	
	movf	(___aldiv@divisor+3),w
	iorwf	(___aldiv@divisor+2),w
	iorwf	(___aldiv@divisor+1),w
	iorwf	(___aldiv@divisor),w
	skipnz
	goto	u2831
	goto	u2830
u2831:
	goto	l2381
u2830:
	line	20
	
l2363:	
	clrf	(___aldiv@counter)
	bsf	status,0
	rlf	(___aldiv@counter),f
	line	21
	goto	l2367
	
l932:	
	line	22
	
l2365:	
	movlw	01h
	movwf	(??___aldiv+0)+0
u2845:
	clrc
	rlf	(___aldiv@divisor),f
	rlf	(___aldiv@divisor+1),f
	rlf	(___aldiv@divisor+2),f
	rlf	(___aldiv@divisor+3),f
	decfsz	(??___aldiv+0)+0
	goto	u2845
	line	23
	movlw	(01h)
	movwf	(??___aldiv+0)+0
	movf	(??___aldiv+0)+0,w
	addwf	(___aldiv@counter),f
	goto	l2367
	line	24
	
l931:	
	line	21
	
l2367:	
	btfss	(___aldiv@divisor+3),(31)&7
	goto	u2851
	goto	u2850
u2851:
	goto	l2365
u2850:
	goto	l2369
	
l933:	
	goto	l2369
	line	25
	
l934:	
	line	26
	
l2369:	
	movlw	01h
	movwf	(??___aldiv+0)+0
u2865:
	clrc
	rlf	(___aldiv@quotient),f
	rlf	(___aldiv@quotient+1),f
	rlf	(___aldiv@quotient+2),f
	rlf	(___aldiv@quotient+3),f
	decfsz	(??___aldiv+0)+0
	goto	u2865
	line	27
	
l2371:	
	movf	(___aldiv@divisor+3),w
	subwf	(___aldiv@dividend+3),w
	skipz
	goto	u2875
	movf	(___aldiv@divisor+2),w
	subwf	(___aldiv@dividend+2),w
	skipz
	goto	u2875
	movf	(___aldiv@divisor+1),w
	subwf	(___aldiv@dividend+1),w
	skipz
	goto	u2875
	movf	(___aldiv@divisor),w
	subwf	(___aldiv@dividend),w
u2875:
	skipc
	goto	u2871
	goto	u2870
u2871:
	goto	l2377
u2870:
	line	28
	
l2373:	
	movf	(___aldiv@divisor),w
	subwf	(___aldiv@dividend),f
	movf	(___aldiv@divisor+1),w
	skipc
	incfsz	(___aldiv@divisor+1),w
	subwf	(___aldiv@dividend+1),f
	movf	(___aldiv@divisor+2),w
	skipc
	incfsz	(___aldiv@divisor+2),w
	subwf	(___aldiv@dividend+2),f
	movf	(___aldiv@divisor+3),w
	skipc
	incfsz	(___aldiv@divisor+3),w
	subwf	(___aldiv@dividend+3),f
	line	29
	
l2375:	
	bsf	(___aldiv@quotient)+(0/8),(0)&7
	goto	l2377
	line	30
	
l935:	
	line	31
	
l2377:	
	movlw	01h
u2885:
	clrc
	rrf	(___aldiv@divisor+3),f
	rrf	(___aldiv@divisor+2),f
	rrf	(___aldiv@divisor+1),f
	rrf	(___aldiv@divisor),f
	addlw	-1
	skipz
	goto	u2885

	line	32
	
l2379:	
	movlw	low(01h)
	subwf	(___aldiv@counter),f
	btfss	status,2
	goto	u2891
	goto	u2890
u2891:
	goto	l2369
u2890:
	goto	l2381
	
l936:	
	goto	l2381
	line	33
	
l930:	
	line	34
	
l2381:	
	movf	(___aldiv@sign),w
	skipz
	goto	u2900
	goto	l2385
u2900:
	line	35
	
l2383:	
	comf	(___aldiv@quotient),f
	comf	(___aldiv@quotient+1),f
	comf	(___aldiv@quotient+2),f
	comf	(___aldiv@quotient+3),f
	incf	(___aldiv@quotient),f
	skipnz
	incf	(___aldiv@quotient+1),f
	skipnz
	incf	(___aldiv@quotient+2),f
	skipnz
	incf	(___aldiv@quotient+3),f
	goto	l2385
	
l937:	
	line	36
	
l2385:	
	movf	(___aldiv@quotient+3),w
	movwf	(?___aldiv+3)
	movf	(___aldiv@quotient+2),w
	movwf	(?___aldiv+2)
	movf	(___aldiv@quotient+1),w
	movwf	(?___aldiv+1)
	movf	(___aldiv@quotient),w
	movwf	(?___aldiv)

	goto	l938
	
l2387:	
	line	37
	
l938:	
	return
	opt stack 0
GLOBAL	__end_of___aldiv
	__end_of___aldiv:
;; =============== function ___aldiv ends ============

	signat	___aldiv,8316
	global	___fttol
psect	text394,local,class=CODE,delta=2
global __ptext394
__ptext394:

;; *************** function ___fttol *****************
;; Defined at:
;;		line 45 in file "C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\fttol.c"
;; Parameters:    Size  Location     Type
;;  f1              3    6[BANK0 ] float 
;; Auto vars:     Size  Location     Type
;;  lval            4   11[BANK0 ] unsigned long 
;;  exp1            1   15[BANK0 ] unsigned char 
;;  sign1           1   10[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  4    6[BANK0 ] long 
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       4       0       0       0
;;      Locals:         0       6       0       0       0
;;      Temps:          4       0       0       0       0
;;      Totals:         4      10       0       0       0
;;Total ram usage:       14 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_PWM1_Duty
;;		_PWM2_Duty
;; This function uses a non-reentrant model
;;
psect	text394
	file	"C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\fttol.c"
	line	45
	global	__size_of___fttol
	__size_of___fttol	equ	__end_of___fttol-___fttol
	
___fttol:	
	opt	stack 6
; Regs used in ___fttol: [wreg+status,2+status,0]
	line	49
	
l2291:	
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(___fttol@f1),w
	movwf	((??___fttol+0)+0)
	movf	(___fttol@f1+1),w
	movwf	((??___fttol+0)+0+1)
	movf	(___fttol@f1+2),w
	movwf	((??___fttol+0)+0+2)
	clrc
	rlf	(??___fttol+0)+1,w
	rlf	(??___fttol+0)+2,w
	movwf	(??___fttol+3)+0
	movf	(??___fttol+3)+0,w
	movwf	(___fttol@exp1)
	movf	((___fttol@exp1)),f
	skipz
	goto	u2701
	goto	u2700
u2701:
	goto	l2297
u2700:
	line	50
	
l2293:	
	movlw	0
	movwf	(?___fttol+3)
	movlw	0
	movwf	(?___fttol+2)
	movlw	0
	movwf	(?___fttol+1)
	movlw	0
	movwf	(?___fttol)

	goto	l843
	
l2295:	
	goto	l843
	
l842:	
	line	51
	
l2297:	
	movf	(___fttol@f1),w
	movwf	((??___fttol+0)+0)
	movf	(___fttol@f1+1),w
	movwf	((??___fttol+0)+0+1)
	movf	(___fttol@f1+2),w
	movwf	((??___fttol+0)+0+2)
	movlw	017h
u2715:
	clrc
	rrf	(??___fttol+0)+2,f
	rrf	(??___fttol+0)+1,f
	rrf	(??___fttol+0)+0,f
u2710:
	addlw	-1
	skipz
	goto	u2715
	movf	0+(??___fttol+0)+0,w
	movwf	(??___fttol+3)+0
	movf	(??___fttol+3)+0,w
	movwf	(___fttol@sign1)
	line	52
	
l2299:	
	bsf	(___fttol@f1)+(15/8),(15)&7
	line	53
	
l2301:	
	movlw	0FFh
	andwf	(___fttol@f1),f
	movlw	0FFh
	andwf	(___fttol@f1+1),f
	movlw	0
	andwf	(___fttol@f1+2),f
	line	54
	
l2303:	
	movf	(___fttol@f1),w
	movwf	(___fttol@lval)
	movf	(___fttol@f1+1),w
	movwf	((___fttol@lval))+1
	movf	(___fttol@f1+2),w
	movwf	((___fttol@lval))+2
	clrf	((___fttol@lval))+3
	line	55
	
l2305:	
	movlw	low(08Eh)
	subwf	(___fttol@exp1),f
	line	56
	
l2307:	
	btfss	(___fttol@exp1),7
	goto	u2721
	goto	u2720
u2721:
	goto	l2317
u2720:
	line	57
	
l2309:	
	movf	(___fttol@exp1),w
	xorlw	80h
	addlw	-((-15)^80h)
	skipnc
	goto	u2731
	goto	u2730
u2731:
	goto	l2315
u2730:
	line	58
	
l2311:	
	movlw	0
	movwf	(?___fttol+3)
	movlw	0
	movwf	(?___fttol+2)
	movlw	0
	movwf	(?___fttol+1)
	movlw	0
	movwf	(?___fttol)

	goto	l843
	
l2313:	
	goto	l843
	
l845:	
	goto	l2315
	line	59
	
l846:	
	line	60
	
l2315:	
	movlw	01h
u2745:
	clrc
	rrf	(___fttol@lval+3),f
	rrf	(___fttol@lval+2),f
	rrf	(___fttol@lval+1),f
	rrf	(___fttol@lval),f
	addlw	-1
	skipz
	goto	u2745

	line	61
	movlw	(01h)
	movwf	(??___fttol+0)+0
	movf	(??___fttol+0)+0,w
	addwf	(___fttol@exp1),f
	btfss	status,2
	goto	u2751
	goto	u2750
u2751:
	goto	l2315
u2750:
	goto	l2327
	
l847:	
	line	62
	goto	l2327
	
l844:	
	line	63
	
l2317:	
	movlw	(018h)
	subwf	(___fttol@exp1),w
	skipc
	goto	u2761
	goto	u2760
u2761:
	goto	l2325
u2760:
	line	64
	
l2319:	
	movlw	0
	movwf	(?___fttol+3)
	movlw	0
	movwf	(?___fttol+2)
	movlw	0
	movwf	(?___fttol+1)
	movlw	0
	movwf	(?___fttol)

	goto	l843
	
l2321:	
	goto	l843
	
l849:	
	line	65
	goto	l2325
	
l851:	
	line	66
	
l2323:	
	movlw	01h
	movwf	(??___fttol+0)+0
u2775:
	clrc
	rlf	(___fttol@lval),f
	rlf	(___fttol@lval+1),f
	rlf	(___fttol@lval+2),f
	rlf	(___fttol@lval+3),f
	decfsz	(??___fttol+0)+0
	goto	u2775
	line	67
	movlw	low(01h)
	subwf	(___fttol@exp1),f
	goto	l2325
	line	68
	
l850:	
	line	65
	
l2325:	
	movf	(___fttol@exp1),f
	skipz
	goto	u2781
	goto	u2780
u2781:
	goto	l2323
u2780:
	goto	l2327
	
l852:	
	goto	l2327
	line	69
	
l848:	
	line	70
	
l2327:	
	movf	(___fttol@sign1),w
	skipz
	goto	u2790
	goto	l2331
u2790:
	line	71
	
l2329:	
	comf	(___fttol@lval),f
	comf	(___fttol@lval+1),f
	comf	(___fttol@lval+2),f
	comf	(___fttol@lval+3),f
	incf	(___fttol@lval),f
	skipnz
	incf	(___fttol@lval+1),f
	skipnz
	incf	(___fttol@lval+2),f
	skipnz
	incf	(___fttol@lval+3),f
	goto	l2331
	
l853:	
	line	72
	
l2331:	
	movf	(___fttol@lval+3),w
	movwf	(?___fttol+3)
	movf	(___fttol@lval+2),w
	movwf	(?___fttol+2)
	movf	(___fttol@lval+1),w
	movwf	(?___fttol+1)
	movf	(___fttol@lval),w
	movwf	(?___fttol)

	goto	l843
	
l2333:	
	line	73
	
l843:	
	return
	opt stack 0
GLOBAL	__end_of___fttol
	__end_of___fttol:
;; =============== function ___fttol ends ============

	signat	___fttol,4220
	global	___ftpack
psect	text395,local,class=CODE,delta=2
global __ptext395
__ptext395:

;; *************** function ___ftpack *****************
;; Defined at:
;;		line 63 in file "C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\float.c"
;; Parameters:    Size  Location     Type
;;  arg             3    0[COMMON] unsigned um
;;  exp             1    3[COMMON] unsigned char 
;;  sign            1    4[COMMON] unsigned char 
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  3    0[COMMON] float 
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         5       0       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          3       0       0       0       0
;;      Totals:         8       0       0       0       0
;;Total ram usage:        8 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		___ftdiv
;;		___ftmul
;;		___awtoft
;;		___lwtoft
;;		___ftadd
;;		___lbtoft
;;		___abtoft
;;		___altoft
;;		___lltoft
;;		___attoft
;;		___lttoft
;; This function uses a non-reentrant model
;;
psect	text395
	file	"C:\Program Files (x86)\HI-TECH Software\PICC\9.81\sources\float.c"
	line	63
	global	__size_of___ftpack
	__size_of___ftpack	equ	__end_of___ftpack-___ftpack
	
___ftpack:	
	opt	stack 5
; Regs used in ___ftpack: [wreg+status,2+status,0]
	line	64
	
l2255:	
	movf	(___ftpack@exp),w
	skipz
	goto	u2590
	goto	l2259
u2590:
	
l2257:	
	movf	(___ftpack@arg+2),w
	iorwf	(___ftpack@arg+1),w
	iorwf	(___ftpack@arg),w
	skipz
	goto	u2601
	goto	u2600
u2601:
	goto	l2265
u2600:
	goto	l2259
	
l1067:	
	line	65
	
l2259:	
	movlw	0x0
	movwf	(?___ftpack)
	movlw	0x0
	movwf	(?___ftpack+1)
	movlw	0x0
	movwf	(?___ftpack+2)
	goto	l1068
	
l2261:	
	goto	l1068
	
l1065:	
	line	66
	goto	l2265
	
l1070:	
	line	67
	
l2263:	
	movlw	(01h)
	movwf	(??___ftpack+0)+0
	movf	(??___ftpack+0)+0,w
	addwf	(___ftpack@exp),f
	line	68
	movlw	01h
u2615:
	clrc
	rrf	(___ftpack@arg+2),f
	rrf	(___ftpack@arg+1),f
	rrf	(___ftpack@arg),f
	addlw	-1
	skipz
	goto	u2615

	goto	l2265
	line	69
	
l1069:	
	line	66
	
l2265:	
	movlw	low highword(0FE0000h)
	andwf	(___ftpack@arg+2),w
	btfss	status,2
	goto	u2621
	goto	u2620
u2621:
	goto	l2263
u2620:
	goto	l1072
	
l1071:	
	line	70
	goto	l1072
	
l1073:	
	line	71
	
l2267:	
	movlw	(01h)
	movwf	(??___ftpack+0)+0
	movf	(??___ftpack+0)+0,w
	addwf	(___ftpack@exp),f
	line	72
	
l2269:	
	movlw	01h
	addwf	(___ftpack@arg),f
	movlw	0
	skipnc
movlw 1
	addwf	(___ftpack@arg+1),f
	movlw	0
	skipnc
movlw 1
	addwf	(___ftpack@arg+2),f
	line	73
	
l2271:	
	movlw	01h
u2635:
	clrc
	rrf	(___ftpack@arg+2),f
	rrf	(___ftpack@arg+1),f
	rrf	(___ftpack@arg),f
	addlw	-1
	skipz
	goto	u2635

	line	74
	
l1072:	
	line	70
	movlw	low highword(0FF0000h)
	andwf	(___ftpack@arg+2),w
	btfss	status,2
	goto	u2641
	goto	u2640
u2641:
	goto	l2267
u2640:
	goto	l2275
	
l1074:	
	line	75
	goto	l2275
	
l1076:	
	line	76
	
l2273:	
	movlw	low(01h)
	subwf	(___ftpack@exp),f
	line	77
	movlw	01h
u2655:
	clrc
	rlf	(___ftpack@arg),f
	rlf	(___ftpack@arg+1),f
	rlf	(___ftpack@arg+2),f
	addlw	-1
	skipz
	goto	u2655
	goto	l2275
	line	78
	
l1075:	
	line	75
	
l2275:	
	btfss	(___ftpack@arg+1),(15)&7
	goto	u2661
	goto	u2660
u2661:
	goto	l2273
u2660:
	
l1077:	
	line	79
	btfsc	(___ftpack@exp),(0)&7
	goto	u2671
	goto	u2670
u2671:
	goto	l1078
u2670:
	line	80
	
l2277:	
	movlw	0FFh
	andwf	(___ftpack@arg),f
	movlw	07Fh
	andwf	(___ftpack@arg+1),f
	movlw	0FFh
	andwf	(___ftpack@arg+2),f
	
l1078:	
	line	81
	clrc
	rrf	(___ftpack@exp),f

	line	82
	
l2279:	
	movf	(___ftpack@exp),w
	movwf	((??___ftpack+0)+0)
	clrf	((??___ftpack+0)+0+1)
	clrf	((??___ftpack+0)+0+2)
	movlw	010h
u2685:
	clrc
	rlf	(??___ftpack+0)+0,f
	rlf	(??___ftpack+0)+1,f
	rlf	(??___ftpack+0)+2,f
u2680:
	addlw	-1
	skipz
	goto	u2685
	movf	0+(??___ftpack+0)+0,w
	iorwf	(___ftpack@arg),f
	movf	1+(??___ftpack+0)+0,w
	iorwf	(___ftpack@arg+1),f
	movf	2+(??___ftpack+0)+0,w
	iorwf	(___ftpack@arg+2),f
	line	83
	
l2281:	
	movf	(___ftpack@sign),w
	skipz
	goto	u2690
	goto	l1079
u2690:
	line	84
	
l2283:	
	bsf	(___ftpack@arg)+(23/8),(23)&7
	
l1079:	
	line	85
	line	86
	
l1068:	
	return
	opt stack 0
GLOBAL	__end_of___ftpack
	__end_of___ftpack:
;; =============== function ___ftpack ends ============

	signat	___ftpack,12411
	global	_PWM2_Start
psect	text396,local,class=CODE,delta=2
global __ptext396
__ptext396:

;; *************** function _PWM2_Start *****************
;; Defined at:
;;		line 72 in file "G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
;; Parameters:    Size  Location     Type
;;		None
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  2  711[COMMON] int 
;; Registers used:
;;		None
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          0       0       0       0       0
;;      Totals:         0       0       0       0       0
;;Total ram usage:        0 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text396
	file	"G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
	line	72
	global	__size_of_PWM2_Start
	__size_of_PWM2_Start	equ	__end_of_PWM2_Start-_PWM2_Start
	
_PWM2_Start:	
	opt	stack 7
; Regs used in _PWM2_Start: []
	line	73
	
l2183:	
;pwm example.c: 73: CCP2M3 = 1;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bsf	(235/8),(235)&7
	line	74
;pwm example.c: 74: CCP2M2 = 1;
	bsf	(234/8),(234)&7
	line	79
;pwm example.c: 79: T2CKPS0 = 1;
	bsf	(144/8),(144)&7
	line	80
;pwm example.c: 80: T2CKPS1 = 0;
	bcf	(145/8),(145)&7
	line	85
;pwm example.c: 85: TMR2ON = 1;
	bsf	(146/8),(146)&7
	line	86
;pwm example.c: 86: TRISC1 = 0;
	bsf	status, 5	;RP0=1, select bank1
	bcf	status, 6	;RP1=0, select bank1
	bcf	(1081/8)^080h,(1081)&7
	line	87
	
l712:	
	return
	opt stack 0
GLOBAL	__end_of_PWM2_Start
	__end_of_PWM2_Start:
;; =============== function _PWM2_Start ends ============

	signat	_PWM2_Start,90
	global	_PWM1_Start
psect	text397,local,class=CODE,delta=2
global __ptext397
__ptext397:

;; *************** function _PWM1_Start *****************
;; Defined at:
;;		line 47 in file "G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
;; Parameters:    Size  Location     Type
;;		None
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  2  705[COMMON] int 
;; Registers used:
;;		None
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          0       0       0       0       0
;;      Totals:         0       0       0       0       0
;;Total ram usage:        0 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text397
	file	"G:\Electronics\Embeded\PIC Microcontroller\Hi-Tech C\Generating PWM with PIC Microcontroller - Hi Tech C\pwm example.c"
	line	47
	global	__size_of_PWM1_Start
	__size_of_PWM1_Start	equ	__end_of_PWM1_Start-_PWM1_Start
	
_PWM1_Start:	
	opt	stack 7
; Regs used in _PWM1_Start: []
	line	48
	
l2181:	
;pwm example.c: 48: CCP1M3 = 1;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bsf	(187/8),(187)&7
	line	49
;pwm example.c: 49: CCP1M2 = 1;
	bsf	(186/8),(186)&7
	line	54
;pwm example.c: 54: T2CKPS0 = 1;
	bsf	(144/8),(144)&7
	line	55
;pwm example.c: 55: T2CKPS1 = 0;
	bcf	(145/8),(145)&7
	line	60
;pwm example.c: 60: TMR2ON = 1;
	bsf	(146/8),(146)&7
	line	61
;pwm example.c: 61: TRISC2 = 0;
	bsf	status, 5	;RP0=1, select bank1
	bcf	status, 6	;RP1=0, select bank1
	bcf	(1082/8)^080h,(1082)&7
	line	62
	
l706:	
	return
	opt stack 0
GLOBAL	__end_of_PWM1_Start
	__end_of_PWM1_Start:
;; =============== function _PWM1_Start ends ============

	signat	_PWM1_Start,90
psect	text398,local,class=CODE,delta=2
global __ptext398
__ptext398:
	global	btemp
	btemp set 07Eh

	DABS	1,126,2	;btemp
	global	wtemp0
	wtemp0 set btemp
	end
