opt subtitle "HI-TECH Software Omniscient Code Generator (Lite mode) build 6738"

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
	FNCALL	_main,_lcd_init
	FNCALL	_main,___wmul
	FNCALL	_main,___lwtoft
	FNCALL	_main,___ftmul
	FNCALL	_main,___ftdiv
	FNCALL	_main,_disp
	FNCALL	_main,_DelayMs
	FNCALL	_disp,___fttol
	FNCALL	_disp,___awmod
	FNCALL	_disp,___awdiv
	FNCALL	_disp,___awtoft
	FNCALL	_disp,___ftneg
	FNCALL	_disp,___ftadd
	FNCALL	_disp,___ftmul
	FNCALL	_disp,_lookup
	FNCALL	_disp,_lcd_goto
	FNCALL	_disp,_lcd_putch
	FNCALL	_disp,_lcd_puts
	FNCALL	_lcd_init,_lcd_write
	FNCALL	_lcd_init,_lcd_clear
	FNCALL	_lcd_clear,_lcd_write
	FNCALL	_lcd_puts,_lcd_write
	FNCALL	_lcd_putch,_lcd_write
	FNCALL	_lcd_goto,_lcd_write
	FNCALL	___lwtoft,___ftpack
	FNCALL	___awtoft,___ftpack
	FNCALL	___ftmul,___ftpack
	FNCALL	___ftdiv,___ftpack
	FNCALL	___ftadd,___ftpack
	FNROOT	_main
	global	disp@f1
	global	_ADCON0
psect	text434,local,class=CODE,delta=2
global __ptext434
__ptext434:
_ADCON0	set	31
	global	_ADRESH
_ADRESH	set	30
	global	_PIR1
_PIR1	set	12
	global	_PORTD
_PORTD	set	8
	global	_RA1
_RA1	set	41
	global	_RA2
_RA2	set	42
	global	_RA3
_RA3	set	43
	global	_ADCON1
_ADCON1	set	159
	global	_ADRESL
_ADRESL	set	158
	global	_TRISA
_TRISA	set	133
	global	_TRISD
_TRISD	set	136
psect	strings,class=STRING,delta=2
global __pstrings
__pstrings:
;	global	stringdir,stringtab,__stringbase
stringtab:
;	String table - string pointers are 1 byte each
stringcode:stringdir:
movlw high(stringdir)
movwf pclath
movf fsr,w
incf fsr
	addwf pc
__stringbase:
	retlw	0
psect	strings
	
STR_1:	
	retlw	32	;' '
	retlw	100	;'d'
	retlw	101	;'e'
	retlw	103	;'g'
	retlw	32	;' '
	retlw	99	;'c'
	retlw	101	;'e'
	retlw	108	;'l'
	retlw	0
psect	strings
	file	"tempr.as"
	line	#
psect cinit,class=CODE,delta=2
global start_initialization
start_initialization:

psect	bssBANK0,class=BANK0,space=1
global __pbssBANK0
__pbssBANK0:
disp@f1:
       ds      3

; Clear objects allocated to BANK0
psect cinit,class=CODE,delta=2
	clrf	((__pbssBANK0)+0)&07Fh
	clrf	((__pbssBANK0)+1)&07Fh
	clrf	((__pbssBANK0)+2)&07Fh
psect cinit,class=CODE,delta=2
global end_of_initialization

;End of C runtime variable initialization code

end_of_initialization:
clrf status
ljmp _main	;jump to C main() function
psect	cstackCOMMON,class=COMMON,space=1
global __pcstackCOMMON
__pcstackCOMMON:
	global	?_lcd_init
?_lcd_init:	; 0 bytes @ 0x0
	global	?_DelayMs
?_DelayMs:	; 0 bytes @ 0x0
	global	??_DelayMs
??_DelayMs:	; 0 bytes @ 0x0
	global	?_lcd_goto
?_lcd_goto:	; 0 bytes @ 0x0
	global	?_lcd_putch
?_lcd_putch:	; 0 bytes @ 0x0
	global	?_lcd_puts
?_lcd_puts:	; 0 bytes @ 0x0
	global	?_main
?_main:	; 0 bytes @ 0x0
	global	?_lcd_write
?_lcd_write:	; 0 bytes @ 0x0
	global	??_lcd_write
??_lcd_write:	; 0 bytes @ 0x0
	global	?_lcd_clear
?_lcd_clear:	; 0 bytes @ 0x0
	global	?_lookup
?_lookup:	; 1 bytes @ 0x0
	global	?___wmul
?___wmul:	; 2 bytes @ 0x0
	global	?___awdiv
?___awdiv:	; 2 bytes @ 0x0
	global	?___awmod
?___awmod:	; 2 bytes @ 0x0
	global	?___ftpack
?___ftpack:	; 3 bytes @ 0x0
	global	lookup@no
lookup@no:	; 2 bytes @ 0x0
	global	___wmul@multiplier
___wmul@multiplier:	; 2 bytes @ 0x0
	global	___awdiv@divisor
___awdiv@divisor:	; 2 bytes @ 0x0
	global	___awmod@divisor
___awmod@divisor:	; 2 bytes @ 0x0
	global	___ftpack@arg
___ftpack@arg:	; 3 bytes @ 0x0
	ds	1
	global	lcd_write@c
lcd_write@c:	; 1 bytes @ 0x1
	global	DelayMs@cnt
DelayMs@cnt:	; 1 bytes @ 0x1
	ds	1
	global	??_lookup
??_lookup:	; 0 bytes @ 0x2
	global	??_lcd_goto
??_lcd_goto:	; 0 bytes @ 0x2
	global	??_lcd_putch
??_lcd_putch:	; 0 bytes @ 0x2
	global	??_lcd_puts
??_lcd_puts:	; 0 bytes @ 0x2
	global	??_lcd_clear
??_lcd_clear:	; 0 bytes @ 0x2
	global	lcd_putch@c
lcd_putch@c:	; 1 bytes @ 0x2
	global	lcd_goto@pos
lcd_goto@pos:	; 1 bytes @ 0x2
	global	DelayMs@i
DelayMs@i:	; 1 bytes @ 0x2
	global	___wmul@multiplicand
___wmul@multiplicand:	; 2 bytes @ 0x2
	global	___awdiv@dividend
___awdiv@dividend:	; 2 bytes @ 0x2
	global	___awmod@dividend
___awmod@dividend:	; 2 bytes @ 0x2
	ds	1
	global	lookup@cha
lookup@cha:	; 1 bytes @ 0x3
	global	lcd_puts@s
lcd_puts@s:	; 1 bytes @ 0x3
	global	DelayMs@_dcnt
DelayMs@_dcnt:	; 1 bytes @ 0x3
	global	___ftpack@exp
___ftpack@exp:	; 1 bytes @ 0x3
	ds	1
	global	??_lcd_init
??_lcd_init:	; 0 bytes @ 0x4
	global	??___wmul
??___wmul:	; 0 bytes @ 0x4
	global	??___awdiv
??___awdiv:	; 0 bytes @ 0x4
	global	??___awmod
??___awmod:	; 0 bytes @ 0x4
	global	___ftpack@sign
___ftpack@sign:	; 1 bytes @ 0x4
	global	___wmul@product
___wmul@product:	; 2 bytes @ 0x4
	ds	1
	global	??___ftpack
??___ftpack:	; 0 bytes @ 0x5
	global	___awdiv@counter
___awdiv@counter:	; 1 bytes @ 0x5
	global	___awmod@counter
___awmod@counter:	; 1 bytes @ 0x5
	ds	1
	global	lcd_init@init_value
lcd_init@init_value:	; 1 bytes @ 0x6
	global	___awdiv@sign
___awdiv@sign:	; 1 bytes @ 0x6
	global	___awmod@sign
___awmod@sign:	; 1 bytes @ 0x6
	ds	1
	global	___awdiv@quotient
___awdiv@quotient:	; 2 bytes @ 0x7
	ds	1
	global	?___ftdiv
?___ftdiv:	; 3 bytes @ 0x8
	global	?___ftneg
?___ftneg:	; 3 bytes @ 0x8
	global	?___lwtoft
?___lwtoft:	; 3 bytes @ 0x8
	global	?___fttol
?___fttol:	; 4 bytes @ 0x8
	global	___lwtoft@c
___lwtoft@c:	; 2 bytes @ 0x8
	global	___ftdiv@f2
___ftdiv@f2:	; 3 bytes @ 0x8
	global	___fttol@f1
___fttol@f1:	; 3 bytes @ 0x8
	global	___ftneg@f1
___ftneg@f1:	; 3 bytes @ 0x8
	ds	3
	global	??___ftneg
??___ftneg:	; 0 bytes @ 0xB
	global	??___lwtoft
??___lwtoft:	; 0 bytes @ 0xB
	global	?___awtoft
?___awtoft:	; 3 bytes @ 0xB
	global	___awtoft@c
___awtoft@c:	; 2 bytes @ 0xB
	global	___ftdiv@f1
___ftdiv@f1:	; 3 bytes @ 0xB
	ds	3
psect	cstackBANK0,class=BANK0,space=1
global __pcstackBANK0
__pcstackBANK0:
	global	??___ftdiv
??___ftdiv:	; 0 bytes @ 0x0
	global	??___fttol
??___fttol:	; 0 bytes @ 0x0
	global	??___awtoft
??___awtoft:	; 0 bytes @ 0x0
	ds	2
	global	___awtoft@sign
___awtoft@sign:	; 1 bytes @ 0x2
	ds	1
	global	?___ftadd
?___ftadd:	; 3 bytes @ 0x3
	global	___ftadd@f1
___ftadd@f1:	; 3 bytes @ 0x3
	ds	1
	global	___ftdiv@cntr
___ftdiv@cntr:	; 1 bytes @ 0x4
	global	___fttol@sign1
___fttol@sign1:	; 1 bytes @ 0x4
	ds	1
	global	___ftdiv@f3
___ftdiv@f3:	; 3 bytes @ 0x5
	global	___fttol@lval
___fttol@lval:	; 4 bytes @ 0x5
	ds	1
	global	___ftadd@f2
___ftadd@f2:	; 3 bytes @ 0x6
	ds	2
	global	___ftdiv@exp
___ftdiv@exp:	; 1 bytes @ 0x8
	ds	1
	global	??___ftadd
??___ftadd:	; 0 bytes @ 0x9
	global	___ftdiv@sign
___ftdiv@sign:	; 1 bytes @ 0x9
	global	___fttol@exp1
___fttol@exp1:	; 1 bytes @ 0x9
	ds	1
	global	?___ftmul
?___ftmul:	; 3 bytes @ 0xA
	global	___ftmul@f1
___ftmul@f1:	; 3 bytes @ 0xA
	ds	3
	global	___ftadd@sign
___ftadd@sign:	; 1 bytes @ 0xD
	global	___ftmul@f2
___ftmul@f2:	; 3 bytes @ 0xD
	ds	1
	global	___ftadd@exp2
___ftadd@exp2:	; 1 bytes @ 0xE
	ds	1
	global	___ftadd@exp1
___ftadd@exp1:	; 1 bytes @ 0xF
	ds	1
	global	??___ftmul
??___ftmul:	; 0 bytes @ 0x10
	ds	4
	global	___ftmul@exp
___ftmul@exp:	; 1 bytes @ 0x14
	ds	1
	global	___ftmul@f3_as_product
___ftmul@f3_as_product:	; 3 bytes @ 0x15
	ds	3
	global	___ftmul@cntr
___ftmul@cntr:	; 1 bytes @ 0x18
	ds	1
	global	___ftmul@sign
___ftmul@sign:	; 1 bytes @ 0x19
	ds	1
	global	?_disp
?_disp:	; 0 bytes @ 0x1A
	global	disp@num
disp@num:	; 3 bytes @ 0x1A
	ds	3
	global	??_disp
??_disp:	; 0 bytes @ 0x1D
	ds	1
	global	disp@x1
disp@x1:	; 2 bytes @ 0x1E
	ds	2
	global	disp@x2
disp@x2:	; 2 bytes @ 0x20
	ds	2
	global	disp@x3
disp@x3:	; 2 bytes @ 0x22
	ds	2
	global	disp@x4
disp@x4:	; 2 bytes @ 0x24
	ds	2
	global	disp@temp
disp@temp:	; 2 bytes @ 0x26
	ds	2
	global	disp@ch1
disp@ch1:	; 1 bytes @ 0x28
	ds	1
	global	disp@ch2
disp@ch2:	; 1 bytes @ 0x29
	ds	1
	global	disp@ch3
disp@ch3:	; 1 bytes @ 0x2A
	ds	1
	global	disp@ch4
disp@ch4:	; 1 bytes @ 0x2B
	ds	1
	global	disp@dot
disp@dot:	; 1 bytes @ 0x2C
	ds	1
	global	disp@n
disp@n:	; 2 bytes @ 0x2D
	ds	2
	global	??_main
??_main:	; 0 bytes @ 0x2F
	ds	2
	global	main@tmpr
main@tmpr:	; 3 bytes @ 0x31
	ds	3
	global	main@f
main@f:	; 3 bytes @ 0x34
	ds	3
	global	main@x
main@x:	; 2 bytes @ 0x37
	ds	2
	global	main@y
main@y:	; 2 bytes @ 0x39
	ds	2
	global	main@c
main@c:	; 2 bytes @ 0x3B
	ds	2
	global	main@z
main@z:	; 2 bytes @ 0x3D
	ds	2
	global	main@p
main@p:	; 3 bytes @ 0x3F
	ds	3
;;Data sizes: Strings 9, constant 0, data 0, bss 3, persistent 0 stack 0
;;Auto spaces:   Size  Autos    Used
;; COMMON          14     14      14
;; BANK0           80     66      69
;; BANK1           80      0       0
;; BANK3           96      0       0
;; BANK2           96      0       0

;;
;; Pointer list with targets:

;; ?___ftpack	float  size(1) Largest target is 0
;;
;; ?___ftadd	float  size(1) Largest target is 0
;;
;; ?___ftneg	float  size(1) Largest target is 0
;;
;; ?___awtoft	float  size(1) Largest target is 0
;;
;; ?___awdiv	int  size(1) Largest target is 0
;;
;; ?___awmod	int  size(1) Largest target is 0
;;
;; ?___fttol	long  size(1) Largest target is 0
;;
;; ?___ftmul	float  size(1) Largest target is 0
;;
;; ?___ftdiv	float  size(1) Largest target is 0
;;
;; ?___lwtoft	float  size(1) Largest target is 0
;;
;; ?___wmul	unsigned int  size(1) Largest target is 0
;;
;; lcd_puts@s	PTR const unsigned char  size(1) Largest target is 9
;;		 -> STR_1(CODE[9]), 
;;


;;
;; Critical Paths under _main in COMMON
;;
;;   _main->___ftdiv
;;   _disp->___awtoft
;;   _lcd_init->_lcd_clear
;;   _lcd_clear->_lcd_write
;;   _lcd_puts->_lcd_write
;;   _lcd_putch->_lcd_write
;;   _lcd_goto->_lcd_write
;;   ___lwtoft->___ftpack
;;   ___awtoft->___ftneg
;;   ___ftmul->___fttol
;;   ___ftdiv->___ftpack
;;   ___ftadd->___awtoft
;;   ___ftneg->___ftpack
;;   ___fttol->___ftpack
;;
;; Critical Paths under _main in BANK0
;;
;;   _main->_disp
;;   _disp->___ftmul
;;   ___ftmul->___fttol
;;   ___ftadd->___awtoft
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
;;Main: autosize = 0, tempsize = 2, incstack = 0, save=0
;;

;;
;;Call Graph Tables:
;;
;; ---------------------------------------------------------------------------------
;; (Depth) Function   	        Calls       Base Space   Used Autos Params    Refs
;; ---------------------------------------------------------------------------------
;; (0) _main                                                19    19      0    5171
;;                                             47 BANK0     19    19      0
;;                           _lcd_init
;;                             ___wmul
;;                           ___lwtoft
;;                            ___ftmul
;;                            ___ftdiv
;;                               _disp
;;                            _DelayMs
;; ---------------------------------------------------------------------------------
;; (1) _disp                                                21    18      3    3461
;;                                             26 BANK0     21    18      3
;;                            ___fttol
;;                            ___awmod
;;                            ___awdiv
;;                           ___awtoft
;;                            ___ftneg
;;                            ___ftadd
;;                            ___ftmul
;;                             _lookup
;;                           _lcd_goto
;;                          _lcd_putch
;;                           _lcd_puts
;; ---------------------------------------------------------------------------------
;; (1) _lcd_init                                             3     3      0     111
;;                                              4 COMMON     3     3      0
;;                          _lcd_write
;;                          _lcd_clear
;; ---------------------------------------------------------------------------------
;; (2) _lcd_clear                                            2     2      0      44
;;                                              2 COMMON     2     2      0
;;                          _lcd_write
;; ---------------------------------------------------------------------------------
;; (2) _lcd_puts                                             2     2      0      89
;;                                              2 COMMON     2     2      0
;;                          _lcd_write
;; ---------------------------------------------------------------------------------
;; (2) _lcd_putch                                            1     1      0      66
;;                                              2 COMMON     1     1      0
;;                          _lcd_write
;; ---------------------------------------------------------------------------------
;; (2) _lcd_goto                                             1     1      0      66
;;                                              2 COMMON     1     1      0
;;                          _lcd_write
;; ---------------------------------------------------------------------------------
;; (1) ___lwtoft                                             4     1      3     231
;;                                              8 COMMON     4     1      3
;;                           ___ftpack
;; ---------------------------------------------------------------------------------
;; (2) ___awtoft                                             6     3      3     300
;;                                             11 COMMON     3     0      3
;;                                              0 BANK0      3     3      0
;;                           ___ftpack
;;                            ___ftneg (ARG)
;; ---------------------------------------------------------------------------------
;; (2) ___ftmul                                             16    10      6     535
;;                                             10 BANK0     16    10      6
;;                           ___ftpack
;;                            ___fttol (ARG)
;; ---------------------------------------------------------------------------------
;; (1) ___ftdiv                                             16    10      6     489
;;                                              8 COMMON     6     0      6
;;                                              0 BANK0     10    10      0
;;                           ___ftpack
;; ---------------------------------------------------------------------------------
;; (2) ___ftadd                                             13     7      6    1049
;;                                              3 BANK0     13     7      6
;;                           ___ftpack
;;                            ___ftneg (ARG)
;;                           ___awtoft (ARG)
;; ---------------------------------------------------------------------------------
;; (3) _lcd_write                                            2     2      0      44
;;                                              0 COMMON     2     2      0
;; ---------------------------------------------------------------------------------
;; (2) ___awmod                                              7     3      4     296
;;                                              0 COMMON     7     3      4
;; ---------------------------------------------------------------------------------
;; (2) ___ftneg                                              3     0      3      45
;;                                              8 COMMON     3     0      3
;;                           ___ftpack (ARG)
;; ---------------------------------------------------------------------------------
;; (2) ___awdiv                                              9     5      4     300
;;                                              0 COMMON     9     5      4
;; ---------------------------------------------------------------------------------
;; (2) ___fttol                                             14    10      4     252
;;                                              8 COMMON     4     0      4
;;                                              0 BANK0     10    10      0
;;                           ___ftpack (ARG)
;; ---------------------------------------------------------------------------------
;; (3) ___ftpack                                             8     3      5     209
;;                                              0 COMMON     8     3      5
;; ---------------------------------------------------------------------------------
;; (1) ___wmul                                               6     2      4      92
;;                                              0 COMMON     6     2      4
;; ---------------------------------------------------------------------------------
;; (2) _lookup                                               4     2      2      54
;;                                              0 COMMON     4     2      2
;; ---------------------------------------------------------------------------------
;; (1) _DelayMs                                              4     4      0      68
;;                                              0 COMMON     4     4      0
;; ---------------------------------------------------------------------------------
;; Estimated maximum stack depth 3
;; ---------------------------------------------------------------------------------

;; Call Graph Graphs:

;; _main (ROOT)
;;   _lcd_init
;;     _lcd_write
;;     _lcd_clear
;;       _lcd_write
;;   ___wmul
;;   ___lwtoft
;;     ___ftpack
;;   ___ftmul
;;     ___ftpack
;;     ___fttol (ARG)
;;       ___ftpack (ARG)
;;   ___ftdiv
;;     ___ftpack
;;   _disp
;;     ___fttol
;;       ___ftpack (ARG)
;;     ___awmod
;;     ___awdiv
;;     ___awtoft
;;       ___ftpack
;;       ___ftneg (ARG)
;;         ___ftpack (ARG)
;;     ___ftneg
;;       ___ftpack (ARG)
;;     ___ftadd
;;       ___ftpack
;;       ___ftneg (ARG)
;;         ___ftpack (ARG)
;;       ___awtoft (ARG)
;;         ___ftpack
;;         ___ftneg (ARG)
;;           ___ftpack (ARG)
;;     ___ftmul
;;       ___ftpack
;;       ___fttol (ARG)
;;         ___ftpack (ARG)
;;     _lookup
;;     _lcd_goto
;;       _lcd_write
;;     _lcd_putch
;;       _lcd_write
;;     _lcd_puts
;;       _lcd_write
;;   _DelayMs
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
;;ABS                  0      0      53       3        0.0%
;;BITBANK0            50      0       0       4        0.0%
;;BITSFR3              0      0       0       4        0.0%
;;SFR3                 0      0       0       4        0.0%
;;BANK0               50     42      45       5       86.3%
;;BITSFR2              0      0       0       5        0.0%
;;SFR2                 0      0       0       5        0.0%
;;BITBANK1            50      0       0       6        0.0%
;;BANK1               50      0       0       7        0.0%
;;BITBANK3            60      0       0       8        0.0%
;;BANK3               60      0       0       9        0.0%
;;BITBANK2            60      0       0      10        0.0%
;;BANK2               60      0       0      11        0.0%
;;DATA                 0      0      56      12        0.0%

	global	_main
psect	maintext,global,class=CODE,delta=2
global __pmaintext
__pmaintext:

;; *************** function _main *****************
;; Defined at:
;;		line 14 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\tempr.c"
;; Parameters:    Size  Location     Type
;;		None
;; Auto vars:     Size  Location     Type
;;  p               3   63[BANK0 ] float 
;;  f               3   52[BANK0 ] float 
;;  tmpr            3   49[BANK0 ] float 
;;  z               2   61[BANK0 ] unsigned int 
;;  c               2   59[BANK0 ] unsigned int 
;;  y               2   57[BANK0 ] unsigned int 
;;  x               2   55[BANK0 ] unsigned int 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, fsr0l, fsr0h, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 17F/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         0      17       0       0       0
;;      Temps:          0       2       0       0       0
;;      Totals:         0      19       0       0       0
;;Total ram usage:       19 bytes
;; Hardware stack levels required when called:    3
;; This function calls:
;;		_lcd_init
;;		___wmul
;;		___lwtoft
;;		___ftmul
;;		___ftdiv
;;		_disp
;;		_DelayMs
;; This function is called by:
;;		Startup code after reset
;; This function uses a non-reentrant model
;;
psect	maintext
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\tempr.c"
	line	14
	global	__size_of_main
	__size_of_main	equ	__end_of_main-_main
	
_main:	
	opt	stack 5
; Regs used in _main: [wreg-fsr0h+status,2+status,0+pclath+cstack]
	line	15
	
l3432:	
;tempr.c: 15: lcd_init();
	fcall	_lcd_init
	line	16
	
l3434:	
;tempr.c: 16: unsigned x,y,c=0x100,z;
	movlw	low(0100h)
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(main@c)
	movlw	high(0100h)
	movwf	((main@c))+1
	line	18
	
l3436:	
;tempr.c: 17: float p,tmpr,f;
;tempr.c: 18: ADCON0=0;
	clrf	(31)	;volatile
	line	19
	
l3438:	
;tempr.c: 19: TRISA=1;
	movlw	(01h)
	bsf	status, 5	;RP0=1, select bank1
	bcf	status, 6	;RP1=0, select bank1
	movwf	(133)^080h	;volatile
	line	20
	
l3440:	
;tempr.c: 20: ADCON1=0xCE;
	movlw	(0CEh)
	movwf	(159)^080h	;volatile
	line	21
	
l3442:	
;tempr.c: 21: ADCON0=ADCON0|1;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(31),w	;volatile
	iorlw	01h
	movwf	(31)	;volatile
	goto	l3444
	line	22
;tempr.c: 22: while(1)
	
l573:	
	line	24
	
l3444:	
;tempr.c: 23: {
;tempr.c: 24: ADCON0=ADCON0|4;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(31),w	;volatile
	iorlw	04h
	movwf	(31)	;volatile
	goto	l3446
	line	25
;tempr.c: 25: while(1)
	
l574:	
	line	27
	
l3446:	
;tempr.c: 26: {
;tempr.c: 27: if(ADCON0==0x01)
	movf	(31),w	;volatile
	xorlw	01h
	skipz
	goto	u3241
	goto	u3240
u3241:
	goto	l3446
u3240:
	goto	l3450
	line	28
	
l3448:	
;tempr.c: 28: break;
	goto	l3450
	
l575:	
	goto	l3446
	line	29
	
l577:	
	line	25
	goto	l3446
	
l576:	
	line	30
	
l3450:	
;tempr.c: 29: }
;tempr.c: 30: x=ADRESH;
	movf	(30),w	;volatile
	movwf	(??_main+0)+0
	clrf	(??_main+0)+0+1
	movf	0+(??_main+0)+0,w
	movwf	(main@x)
	movf	1+(??_main+0)+0,w
	movwf	(main@x+1)
	line	31
;tempr.c: 31: y=ADRESL;
	bsf	status, 5	;RP0=1, select bank1
	bcf	status, 6	;RP1=0, select bank1
	movf	(158)^080h,w	;volatile
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(??_main+0)+0
	clrf	(??_main+0)+0+1
	movf	0+(??_main+0)+0,w
	movwf	(main@y)
	movf	1+(??_main+0)+0,w
	movwf	(main@y+1)
	line	32
	
l3452:	
;tempr.c: 32: PIR1=PIR1&~64;
	movf	(12),w
	andlw	0BFh
	movwf	(12)	;volatile
	line	33
	
l3454:	
;tempr.c: 33: z=x*c+y;
	movf	(main@x+1),w
	clrf	(?___wmul+1)
	addwf	(?___wmul+1)
	movf	(main@x),w
	clrf	(?___wmul)
	addwf	(?___wmul)

	movf	(main@c+1),w
	clrf	1+(?___wmul)+02h
	addwf	1+(?___wmul)+02h
	movf	(main@c),w
	clrf	0+(?___wmul)+02h
	addwf	0+(?___wmul)+02h

	fcall	___wmul
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(main@y),w
	addwf	(0+(?___wmul)),w
	movwf	(main@z)
	movf	(main@y+1),w
	skipnc
	incf	(main@y+1),w
	addwf	(1+(?___wmul)),w
	movwf	1+(main@z)
	line	34
	
l3456:	
;tempr.c: 34: f=z;
	movf	(main@z+1),w
	clrf	(?___lwtoft+1)
	addwf	(?___lwtoft+1)
	movf	(main@z),w
	clrf	(?___lwtoft)
	addwf	(?___lwtoft)

	fcall	___lwtoft
	movf	(0+(?___lwtoft)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(main@f)
	movf	(1+(?___lwtoft)),w
	movwf	(main@f+1)
	movf	(2+(?___lwtoft)),w
	movwf	(main@f+2)
	line	35
	
l3458:	
;tempr.c: 35: p=(f*5)/1023;
	movlw	0x0
	movwf	(?___ftmul)
	movlw	0xa0
	movwf	(?___ftmul+1)
	movlw	0x40
	movwf	(?___ftmul+2)
	movf	(main@f),w
	movwf	0+(?___ftmul)+03h
	movf	(main@f+1),w
	movwf	1+(?___ftmul)+03h
	movf	(main@f+2),w
	movwf	2+(?___ftmul)+03h
	fcall	___ftmul
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___ftmul)),w
	movwf	(main@p)
	movf	(1+(?___ftmul)),w
	movwf	(main@p+1)
	movf	(2+(?___ftmul)),w
	movwf	(main@p+2)
	
l3460:	
	movlw	0xc0
	movwf	(?___ftdiv)
	movlw	0x7f
	movwf	(?___ftdiv+1)
	movlw	0x44
	movwf	(?___ftdiv+2)
	movf	(main@p),w
	movwf	0+(?___ftdiv)+03h
	movf	(main@p+1),w
	movwf	1+(?___ftdiv)+03h
	movf	(main@p+2),w
	movwf	2+(?___ftdiv)+03h
	fcall	___ftdiv
	movf	(0+(?___ftdiv)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(main@p)
	movf	(1+(?___ftdiv)),w
	movwf	(main@p+1)
	movf	(2+(?___ftdiv)),w
	movwf	(main@p+2)
	line	36
	
l3462:	
;tempr.c: 36: tmpr=p*100;
	movlw	0x0
	movwf	(?___ftmul)
	movlw	0xc8
	movwf	(?___ftmul+1)
	movlw	0x42
	movwf	(?___ftmul+2)
	movf	(main@p),w
	movwf	0+(?___ftmul)+03h
	movf	(main@p+1),w
	movwf	1+(?___ftmul)+03h
	movf	(main@p+2),w
	movwf	2+(?___ftmul)+03h
	fcall	___ftmul
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___ftmul)),w
	movwf	(main@tmpr)
	movf	(1+(?___ftmul)),w
	movwf	(main@tmpr+1)
	movf	(2+(?___ftmul)),w
	movwf	(main@tmpr+2)
	line	37
	
l3464:	
;tempr.c: 37: disp(tmpr);
	movf	(main@tmpr),w
	movwf	(?_disp)
	movf	(main@tmpr+1),w
	movwf	(?_disp+1)
	movf	(main@tmpr+2),w
	movwf	(?_disp+2)
	fcall	_disp
	line	38
	
l3466:	
;tempr.c: 38: DelayMs(1000);
	movlw	(0E8h)
	fcall	_DelayMs
	goto	l3444
	line	39
	
l578:	
	line	22
	goto	l3444
	
l579:	
	line	40
	
l580:	
	global	start
	ljmp	start
	opt stack 0
GLOBAL	__end_of_main
	__end_of_main:
;; =============== function _main ends ============

	signat	_main,88
	global	_disp
psect	text435,local,class=CODE,delta=2
global __ptext435
__ptext435:

;; *************** function _disp *****************
;; Defined at:
;;		line 43 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\tempr.c"
;; Parameters:    Size  Location     Type
;;  num             3   26[BANK0 ] float 
;; Auto vars:     Size  Location     Type
;;  n               2   45[BANK0 ] int 
;;  temp            2   38[BANK0 ] int 
;;  x4              2   36[BANK0 ] int 
;;  x3              2   34[BANK0 ] int 
;;  x2              2   32[BANK0 ] int 
;;  x1              2   30[BANK0 ] int 
;;  dot             1   44[BANK0 ] unsigned char 
;;  ch4             1   43[BANK0 ] unsigned char 
;;  ch3             1   42[BANK0 ] unsigned char 
;;  ch2             1   41[BANK0 ] unsigned char 
;;  ch1             1   40[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, fsr0l, fsr0h, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       3       0       0       0
;;      Locals:         0      17       0       0       0
;;      Temps:          0       1       0       0       0
;;      Totals:         0      21       0       0       0
;;Total ram usage:       21 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    2
;; This function calls:
;;		___fttol
;;		___awmod
;;		___awdiv
;;		___awtoft
;;		___ftneg
;;		___ftadd
;;		___ftmul
;;		_lookup
;;		_lcd_goto
;;		_lcd_putch
;;		_lcd_puts
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text435
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\tempr.c"
	line	43
	global	__size_of_disp
	__size_of_disp	equ	__end_of_disp-_disp
	
_disp:	
	opt	stack 5
; Regs used in _disp: [wreg-fsr0h+status,2+status,0+pclath+cstack]
	line	46
	
l3390:	
;tempr.c: 44: int x1,x2,x3,x4,n,temp;
;tempr.c: 45: static float f1;
;tempr.c: 46: char ch1,ch2,ch3,ch4,dot='.';
	movlw	(02Eh)
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(??_disp+0)+0
	movf	(??_disp+0)+0,w
	movwf	(disp@dot)
	line	47
	
l3392:	
;tempr.c: 47: n=num;
	movf	(disp@num),w
	movwf	(?___fttol)
	movf	(disp@num+1),w
	movwf	(?___fttol+1)
	movf	(disp@num+2),w
	movwf	(?___fttol+2)
	fcall	___fttol
	movf	1+(((0+(?___fttol)))),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(disp@n+1)
	addwf	(disp@n+1)
	movf	0+(((0+(?___fttol)))),w
	clrf	(disp@n)
	addwf	(disp@n)

	line	48
	
l3394:	
;tempr.c: 48: temp=num;
	movf	(disp@num),w
	movwf	(?___fttol)
	movf	(disp@num+1),w
	movwf	(?___fttol+1)
	movf	(disp@num+2),w
	movwf	(?___fttol+2)
	fcall	___fttol
	movf	1+(((0+(?___fttol)))),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(disp@temp+1)
	addwf	(disp@temp+1)
	movf	0+(((0+(?___fttol)))),w
	clrf	(disp@temp)
	addwf	(disp@temp)

	line	49
	
l3396:	
;tempr.c: 49: x1=n%10;
	movlw	low(0Ah)
	movwf	(?___awmod)
	movlw	high(0Ah)
	movwf	((?___awmod))+1
	movf	(disp@n+1),w
	clrf	1+(?___awmod)+02h
	addwf	1+(?___awmod)+02h
	movf	(disp@n),w
	clrf	0+(?___awmod)+02h
	addwf	0+(?___awmod)+02h

	fcall	___awmod
	movf	(1+(?___awmod)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(disp@x1+1)
	addwf	(disp@x1+1)
	movf	(0+(?___awmod)),w
	clrf	(disp@x1)
	addwf	(disp@x1)

	line	50
	
l3398:	
;tempr.c: 50: n=n/10;
	movlw	low(0Ah)
	movwf	(?___awdiv)
	movlw	high(0Ah)
	movwf	((?___awdiv))+1
	movf	(disp@n+1),w
	clrf	1+(?___awdiv)+02h
	addwf	1+(?___awdiv)+02h
	movf	(disp@n),w
	clrf	0+(?___awdiv)+02h
	addwf	0+(?___awdiv)+02h

	fcall	___awdiv
	movf	(1+(?___awdiv)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(disp@n+1)
	addwf	(disp@n+1)
	movf	(0+(?___awdiv)),w
	clrf	(disp@n)
	addwf	(disp@n)

	line	51
	
l3400:	
;tempr.c: 51: x2=n%10;
	movlw	low(0Ah)
	movwf	(?___awmod)
	movlw	high(0Ah)
	movwf	((?___awmod))+1
	movf	(disp@n+1),w
	clrf	1+(?___awmod)+02h
	addwf	1+(?___awmod)+02h
	movf	(disp@n),w
	clrf	0+(?___awmod)+02h
	addwf	0+(?___awmod)+02h

	fcall	___awmod
	movf	(1+(?___awmod)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(disp@x2+1)
	addwf	(disp@x2+1)
	movf	(0+(?___awmod)),w
	clrf	(disp@x2)
	addwf	(disp@x2)

	line	52
	
l3402:	
;tempr.c: 52: n=n/10;
	movlw	low(0Ah)
	movwf	(?___awdiv)
	movlw	high(0Ah)
	movwf	((?___awdiv))+1
	movf	(disp@n+1),w
	clrf	1+(?___awdiv)+02h
	addwf	1+(?___awdiv)+02h
	movf	(disp@n),w
	clrf	0+(?___awdiv)+02h
	addwf	0+(?___awdiv)+02h

	fcall	___awdiv
	movf	(1+(?___awdiv)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(disp@n+1)
	addwf	(disp@n+1)
	movf	(0+(?___awdiv)),w
	clrf	(disp@n)
	addwf	(disp@n)

	line	53
	
l3404:	
;tempr.c: 53: x3=n%10;
	movlw	low(0Ah)
	movwf	(?___awmod)
	movlw	high(0Ah)
	movwf	((?___awmod))+1
	movf	(disp@n+1),w
	clrf	1+(?___awmod)+02h
	addwf	1+(?___awmod)+02h
	movf	(disp@n),w
	clrf	0+(?___awmod)+02h
	addwf	0+(?___awmod)+02h

	fcall	___awmod
	movf	(1+(?___awmod)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(disp@x3+1)
	addwf	(disp@x3+1)
	movf	(0+(?___awmod)),w
	clrf	(disp@x3)
	addwf	(disp@x3)

	line	54
	
l3406:	
;tempr.c: 54: f1=num-temp;
	movf	(disp@num),w
	movwf	(?___ftadd)
	movf	(disp@num+1),w
	movwf	(?___ftadd+1)
	movf	(disp@num+2),w
	movwf	(?___ftadd+2)
	movf	(disp@temp+1),w
	clrf	(?___awtoft+1)
	addwf	(?___awtoft+1)
	movf	(disp@temp),w
	clrf	(?___awtoft)
	addwf	(?___awtoft)

	fcall	___awtoft
	movf	(0+(?___awtoft)),w
	movwf	(?___ftneg)
	movf	(1+(?___awtoft)),w
	movwf	(?___ftneg+1)
	movf	(2+(?___awtoft)),w
	movwf	(?___ftneg+2)
	fcall	___ftneg
	movf	(0+(?___ftneg)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	0+(?___ftadd)+03h
	movf	(1+(?___ftneg)),w
	movwf	1+(?___ftadd)+03h
	movf	(2+(?___ftneg)),w
	movwf	2+(?___ftadd)+03h
	fcall	___ftadd
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(0+(?___ftadd)),w
	movwf	(disp@f1)
	movf	(1+(?___ftadd)),w
	movwf	(disp@f1+1)
	movf	(2+(?___ftadd)),w
	movwf	(disp@f1+2)
	line	55
	
l3408:	
;tempr.c: 55: x4=f1*10;
	movf	(disp@f1),w
	movwf	0+(?___ftmul)+03h
	movf	(disp@f1+1),w
	movwf	1+(?___ftmul)+03h
	movf	(disp@f1+2),w
	movwf	2+(?___ftmul)+03h
	movlw	0x0
	movwf	(?___ftmul)
	movlw	0x20
	movwf	(?___ftmul+1)
	movlw	0x41
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
	movf	1+(((0+(?___fttol)))),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	clrf	(disp@x4+1)
	addwf	(disp@x4+1)
	movf	0+(((0+(?___fttol)))),w
	clrf	(disp@x4)
	addwf	(disp@x4)

	line	56
	
l3410:	
;tempr.c: 56: ch1=lookup(x3);
	movf	(disp@x3+1),w
	clrf	(?_lookup+1)
	addwf	(?_lookup+1)
	movf	(disp@x3),w
	clrf	(?_lookup)
	addwf	(?_lookup)

	fcall	_lookup
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(??_disp+0)+0
	movf	(??_disp+0)+0,w
	movwf	(disp@ch1)
	line	57
	
l3412:	
;tempr.c: 57: ch2=lookup(x2);
	movf	(disp@x2+1),w
	clrf	(?_lookup+1)
	addwf	(?_lookup+1)
	movf	(disp@x2),w
	clrf	(?_lookup)
	addwf	(?_lookup)

	fcall	_lookup
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(??_disp+0)+0
	movf	(??_disp+0)+0,w
	movwf	(disp@ch2)
	line	58
	
l3414:	
;tempr.c: 58: ch3=lookup(x1);
	movf	(disp@x1+1),w
	clrf	(?_lookup+1)
	addwf	(?_lookup+1)
	movf	(disp@x1),w
	clrf	(?_lookup)
	addwf	(?_lookup)

	fcall	_lookup
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(??_disp+0)+0
	movf	(??_disp+0)+0,w
	movwf	(disp@ch3)
	line	59
	
l3416:	
;tempr.c: 59: ch4=lookup(x4);
	movf	(disp@x4+1),w
	clrf	(?_lookup+1)
	addwf	(?_lookup+1)
	movf	(disp@x4),w
	clrf	(?_lookup)
	addwf	(?_lookup)

	fcall	_lookup
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(??_disp+0)+0
	movf	(??_disp+0)+0,w
	movwf	(disp@ch4)
	line	60
	
l3418:	
;tempr.c: 60: lcd_goto(0);
	movlw	(0)
	fcall	_lcd_goto
	line	61
	
l3420:	
;tempr.c: 61: lcd_putch(ch1);
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(disp@ch1),w
	fcall	_lcd_putch
	line	62
	
l3422:	
;tempr.c: 62: lcd_putch(ch2);
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(disp@ch2),w
	fcall	_lcd_putch
	line	63
	
l3424:	
;tempr.c: 63: lcd_putch(ch3);
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(disp@ch3),w
	fcall	_lcd_putch
	line	64
	
l3426:	
;tempr.c: 64: lcd_putch(dot);
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(disp@dot),w
	fcall	_lcd_putch
	line	65
	
l3428:	
;tempr.c: 65: lcd_putch(ch4);
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(disp@ch4),w
	fcall	_lcd_putch
	line	66
	
l3430:	
;tempr.c: 66: lcd_puts(" deg cel");
	movlw	((STR_1-__stringbase))&0ffh
	fcall	_lcd_puts
	line	67
	
l585:	
	return
	opt stack 0
GLOBAL	__end_of_disp
	__end_of_disp:
;; =============== function _disp ends ============

	signat	_disp,4216
	global	_lcd_init
psect	text436,local,class=CODE,delta=2
global __ptext436
__ptext436:

;; *************** function _lcd_init *****************
;; Defined at:
;;		line 93 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
;; Parameters:    Size  Location     Type
;;		None
;; Auto vars:     Size  Location     Type
;;  init_value      1    6[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         1       0       0       0       0
;;      Temps:          2       0       0       0       0
;;      Totals:         3       0       0       0       0
;;Total ram usage:        3 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    2
;; This function calls:
;;		_lcd_write
;;		_lcd_clear
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text436
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
	line	93
	global	__size_of_lcd_init
	__size_of_lcd_init	equ	__end_of_lcd_init-_lcd_init
	
_lcd_init:	
	opt	stack 5
; Regs used in _lcd_init: [wreg+status,2+status,0+pclath+cstack]
	line	96
	
l3344:	
;lcd.c: 94: char init_value;
;lcd.c: 96: init_value = 0x3;
	movlw	(03h)
	movwf	(??_lcd_init+0)+0
	movf	(??_lcd_init+0)+0,w
	movwf	(lcd_init@init_value)
	line	97
;lcd.c: 97: TRISA=1;
	movlw	(01h)
	bsf	status, 5	;RP0=1, select bank1
	bcf	status, 6	;RP1=0, select bank1
	movwf	(133)^080h	;volatile
	line	98
	
l3346:	
;lcd.c: 98: TRISD=0;
	clrf	(136)^080h	;volatile
	line	99
	
l3348:	
;lcd.c: 99: RA3 = 0;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bcf	(43/8),(43)&7
	line	100
	
l3350:	
;lcd.c: 100: RA1 = 0;
	bcf	(41/8),(41)&7
	line	101
	
l3352:	
;lcd.c: 101: RA2 = 0;
	bcf	(42/8),(42)&7
	line	103
	
l3354:	
;lcd.c: 103: _delay((unsigned long)((15)*(4000000/4000.0)));
	opt asmopt_off
movlw	20
movwf	((??_lcd_init+0)+0+1),f
	movlw	121
movwf	((??_lcd_init+0)+0),f
u3257:
	decfsz	((??_lcd_init+0)+0),f
	goto	u3257
	decfsz	((??_lcd_init+0)+0+1),f
	goto	u3257
	nop2
opt asmopt_on

	line	104
	
l3356:	
;lcd.c: 104: PORTD = init_value;
	movf	(lcd_init@init_value),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(8)	;volatile
	line	105
	
l3358:	
;lcd.c: 105: ((RA1 = 1),(RA1=0));
	bsf	(41/8),(41)&7
	
l3360:	
	bcf	(41/8),(41)&7
	line	106
	
l3362:	
;lcd.c: 106: _delay((unsigned long)((5)*(4000000/4000.0)));
	opt asmopt_off
movlw	7
movwf	((??_lcd_init+0)+0+1),f
	movlw	125
movwf	((??_lcd_init+0)+0),f
u3267:
	decfsz	((??_lcd_init+0)+0),f
	goto	u3267
	decfsz	((??_lcd_init+0)+0+1),f
	goto	u3267
opt asmopt_on

	line	107
	
l3364:	
;lcd.c: 107: ((RA1 = 1),(RA1=0));
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bsf	(41/8),(41)&7
	
l3366:	
	bcf	(41/8),(41)&7
	line	108
	
l3368:	
;lcd.c: 108: _delay((unsigned long)((200)*(4000000/4000000.0)));
	opt asmopt_off
movlw	66
movwf	(??_lcd_init+0)+0,f
u3277:
decfsz	(??_lcd_init+0)+0,f
	goto	u3277
	clrwdt
opt asmopt_on

	line	109
	
l3370:	
;lcd.c: 109: ((RA1 = 1),(RA1=0));
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bsf	(41/8),(41)&7
	
l3372:	
	bcf	(41/8),(41)&7
	line	110
	
l3374:	
;lcd.c: 110: _delay((unsigned long)((200)*(4000000/4000000.0)));
	opt asmopt_off
movlw	66
movwf	(??_lcd_init+0)+0,f
u3287:
decfsz	(??_lcd_init+0)+0,f
	goto	u3287
	clrwdt
opt asmopt_on

	line	111
	
l3376:	
;lcd.c: 111: PORTD = 2;
	movlw	(02h)
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(8)	;volatile
	line	112
	
l3378:	
;lcd.c: 112: ((RA1 = 1),(RA1=0));
	bsf	(41/8),(41)&7
	
l3380:	
	bcf	(41/8),(41)&7
	line	114
	
l3382:	
;lcd.c: 114: lcd_write(0x28);
	movlw	(028h)
	fcall	_lcd_write
	line	115
	
l3384:	
;lcd.c: 115: lcd_write(0xF);
	movlw	(0Fh)
	fcall	_lcd_write
	line	116
	
l3386:	
;lcd.c: 116: lcd_clear();
	fcall	_lcd_clear
	line	117
	
l3388:	
;lcd.c: 117: lcd_write(0x6);
	movlw	(06h)
	fcall	_lcd_write
	line	118
	
l1179:	
	return
	opt stack 0
GLOBAL	__end_of_lcd_init
	__end_of_lcd_init:
;; =============== function _lcd_init ends ============

	signat	_lcd_init,88
	global	_lcd_clear
psect	text437,local,class=CODE,delta=2
global __ptext437
__ptext437:

;; *************** function _lcd_clear *****************
;; Defined at:
;;		line 53 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
;; Parameters:    Size  Location     Type
;;		None
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          2       0       0       0       0
;;      Totals:         2       0       0       0       0
;;Total ram usage:        2 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		_lcd_write
;; This function is called by:
;;		_lcd_init
;; This function uses a non-reentrant model
;;
psect	text437
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
	line	53
	global	__size_of_lcd_clear
	__size_of_lcd_clear	equ	__end_of_lcd_clear-_lcd_clear
	
_lcd_clear:	
	opt	stack 5
; Regs used in _lcd_clear: [wreg+status,2+status,0+pclath+cstack]
	line	54
	
l3338:	
;lcd.c: 54: RA3 = 0;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bcf	(43/8),(43)&7
	line	55
	
l3340:	
;lcd.c: 55: lcd_write(0x1);
	movlw	(01h)
	fcall	_lcd_write
	line	56
	
l3342:	
;lcd.c: 56: _delay((unsigned long)((2)*(4000000/4000.0)));
	opt asmopt_off
movlw	3
movwf	((??_lcd_clear+0)+0+1),f
	movlw	151
movwf	((??_lcd_clear+0)+0),f
u3297:
	decfsz	((??_lcd_clear+0)+0),f
	goto	u3297
	decfsz	((??_lcd_clear+0)+0+1),f
	goto	u3297
	nop2
opt asmopt_on

	line	57
	
l1164:	
	return
	opt stack 0
GLOBAL	__end_of_lcd_clear
	__end_of_lcd_clear:
;; =============== function _lcd_clear ends ============

	signat	_lcd_clear,88
	global	_lcd_puts
psect	text438,local,class=CODE,delta=2
global __ptext438
__ptext438:

;; *************** function _lcd_puts *****************
;; Defined at:
;;		line 63 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
;; Parameters:    Size  Location     Type
;;  s               1    wreg     PTR const unsigned char 
;;		 -> STR_1(9), 
;; Auto vars:     Size  Location     Type
;;  s               1    3[COMMON] PTR const unsigned char 
;;		 -> STR_1(9), 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, fsr0l, fsr0h, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         1       0       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         2       0       0       0       0
;;Total ram usage:        2 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		_lcd_write
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text438
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
	line	63
	global	__size_of_lcd_puts
	__size_of_lcd_puts	equ	__end_of_lcd_puts-_lcd_puts
	
_lcd_puts:	
	opt	stack 5
; Regs used in _lcd_puts: [wreg-fsr0h+status,2+status,0+pclath+cstack]
;lcd_puts@s stored from wreg
	movwf	(lcd_puts@s)
	line	64
	
l3330:	
;lcd.c: 64: RA3 = 1;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bsf	(43/8),(43)&7
	line	65
;lcd.c: 65: while(*s)
	goto	l3336
	
l1168:	
	line	66
	
l3332:	
;lcd.c: 66: lcd_write(*s++);
	movf	(lcd_puts@s),w
	movwf	fsr0
	fcall	stringdir
	fcall	_lcd_write
	
l3334:	
	movlw	(01h)
	movwf	(??_lcd_puts+0)+0
	movf	(??_lcd_puts+0)+0,w
	addwf	(lcd_puts@s),f
	goto	l3336
	
l1167:	
	line	65
	
l3336:	
	movf	(lcd_puts@s),w
	movwf	fsr0
	fcall	stringdir
	iorlw	0
	skipz
	goto	u3231
	goto	u3230
u3231:
	goto	l3332
u3230:
	goto	l1170
	
l1169:	
	line	67
	
l1170:	
	return
	opt stack 0
GLOBAL	__end_of_lcd_puts
	__end_of_lcd_puts:
;; =============== function _lcd_puts ends ============

	signat	_lcd_puts,4216
	global	_lcd_putch
psect	text439,local,class=CODE,delta=2
global __ptext439
__ptext439:

;; *************** function _lcd_putch *****************
;; Defined at:
;;		line 73 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
;; Parameters:    Size  Location     Type
;;  c               1    wreg     unsigned char 
;; Auto vars:     Size  Location     Type
;;  c               1    2[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         1       0       0       0       0
;;      Temps:          0       0       0       0       0
;;      Totals:         1       0       0       0       0
;;Total ram usage:        1 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		_lcd_write
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text439
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
	line	73
	global	__size_of_lcd_putch
	__size_of_lcd_putch	equ	__end_of_lcd_putch-_lcd_putch
	
_lcd_putch:	
	opt	stack 5
; Regs used in _lcd_putch: [wreg+status,2+status,0+pclath+cstack]
;lcd_putch@c stored from wreg
	movwf	(lcd_putch@c)
	line	74
	
l3326:	
;lcd.c: 74: RA3 = 1;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bsf	(43/8),(43)&7
	line	75
	
l3328:	
;lcd.c: 75: lcd_write( c );
	movf	(lcd_putch@c),w
	fcall	_lcd_write
	line	76
	
l1173:	
	return
	opt stack 0
GLOBAL	__end_of_lcd_putch
	__end_of_lcd_putch:
;; =============== function _lcd_putch ends ============

	signat	_lcd_putch,4216
	global	_lcd_goto
psect	text440,local,class=CODE,delta=2
global __ptext440
__ptext440:

;; *************** function _lcd_goto *****************
;; Defined at:
;;		line 85 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
;; Parameters:    Size  Location     Type
;;  pos             1    wreg     unsigned char 
;; Auto vars:     Size  Location     Type
;;  pos             1    2[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         1       0       0       0       0
;;      Temps:          0       0       0       0       0
;;      Totals:         1       0       0       0       0
;;Total ram usage:        1 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		_lcd_write
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text440
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
	line	85
	global	__size_of_lcd_goto
	__size_of_lcd_goto	equ	__end_of_lcd_goto-_lcd_goto
	
_lcd_goto:	
	opt	stack 5
; Regs used in _lcd_goto: [wreg+status,2+status,0+pclath+cstack]
;lcd_goto@pos stored from wreg
	movwf	(lcd_goto@pos)
	line	86
	
l3322:	
;lcd.c: 86: RA3 = 0;
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	bcf	(43/8),(43)&7
	line	87
	
l3324:	
;lcd.c: 87: lcd_write(0x80+pos);
	movf	(lcd_goto@pos),w
	addlw	080h
	fcall	_lcd_write
	line	88
	
l1176:	
	return
	opt stack 0
GLOBAL	__end_of_lcd_goto
	__end_of_lcd_goto:
;; =============== function _lcd_goto ends ============

	signat	_lcd_goto,4216
	global	___lwtoft
psect	text441,local,class=CODE,delta=2
global __ptext441
__ptext441:

;; *************** function ___lwtoft *****************
;; Defined at:
;;		line 29 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\lwtoft.c"
;; Parameters:    Size  Location     Type
;;  c               2    8[COMMON] unsigned int 
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  3    8[COMMON] float 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         3       0       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         4       0       0       0       0
;;Total ram usage:        4 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___ftpack
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text441
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\lwtoft.c"
	line	29
	global	__size_of___lwtoft
	__size_of___lwtoft	equ	__end_of___lwtoft-___lwtoft
	
___lwtoft:	
	opt	stack 6
; Regs used in ___lwtoft: [wreg+status,2+status,0+pclath+cstack]
	line	30
	
l3318:	
	movf	(___lwtoft@c),w
	movwf	(?___ftpack)
	movf	(___lwtoft@c+1),w
	movwf	(?___ftpack+1)
	clrf	(?___ftpack+2)
	movlw	(08Eh)
	movwf	(??___lwtoft+0)+0
	movf	(??___lwtoft+0)+0,w
	movwf	0+(?___ftpack)+03h
	clrc
	movlw	0
	btfsc	status,0
	movlw	1
	movwf	0+(?___ftpack)+04h
	fcall	___ftpack
	movf	(0+(?___ftpack)),w
	movwf	(?___lwtoft)
	movf	(1+(?___ftpack)),w
	movwf	(?___lwtoft+1)
	movf	(2+(?___ftpack)),w
	movwf	(?___lwtoft+2)
	goto	l1421
	
l3320:	
	line	31
	
l1421:	
	return
	opt stack 0
GLOBAL	__end_of___lwtoft
	__end_of___lwtoft:
;; =============== function ___lwtoft ends ============

	signat	___lwtoft,4219
	global	___awtoft
psect	text442,local,class=CODE,delta=2
global __ptext442
__ptext442:

;; *************** function ___awtoft *****************
;; Defined at:
;;		line 33 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\awtoft.c"
;; Parameters:    Size  Location     Type
;;  c               2   11[COMMON] int 
;; Auto vars:     Size  Location     Type
;;  sign            1    2[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  3   11[COMMON] float 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         3       0       0       0       0
;;      Locals:         0       1       0       0       0
;;      Temps:          0       2       0       0       0
;;      Totals:         3       3       0       0       0
;;Total ram usage:        6 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___ftpack
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text442
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\awtoft.c"
	line	33
	global	__size_of___awtoft
	__size_of___awtoft	equ	__end_of___awtoft-___awtoft
	
___awtoft:	
	opt	stack 5
; Regs used in ___awtoft: [wreg+status,2+status,0+pclath+cstack]
	line	36
	
l3308:	
	clrc
	movlw	0
	btfsc	status,0
	movlw	1
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(___awtoft@sign)
	line	37
	
l3310:	
	btfss	(___awtoft@c+1),7
	goto	u3221
	goto	u3220
u3221:
	goto	l3314
u3220:
	line	38
	
l3312:	
	comf	(___awtoft@c),f
	comf	(___awtoft@c+1),f
	incf	(___awtoft@c),f
	skipnz
	incf	(___awtoft@c+1),f
	line	39
	clrf	(___awtoft@sign)
	bsf	status,0
	rlf	(___awtoft@sign),f
	goto	l3314
	line	40
	
l1334:	
	line	41
	
l3314:	
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
	movwf	(?___awtoft)
	movf	(1+(?___ftpack)),w
	movwf	(?___awtoft+1)
	movf	(2+(?___ftpack)),w
	movwf	(?___awtoft+2)
	goto	l1335
	
l3316:	
	line	42
	
l1335:	
	return
	opt stack 0
GLOBAL	__end_of___awtoft
	__end_of___awtoft:
;; =============== function ___awtoft ends ============

	signat	___awtoft,4219
	global	___ftmul
psect	text443,local,class=CODE,delta=2
global __ptext443
__ptext443:

;; *************** function ___ftmul *****************
;; Defined at:
;;		line 52 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\ftmul.c"
;; Parameters:    Size  Location     Type
;;  f1              3   10[BANK0 ] float 
;;  f2              3   13[BANK0 ] float 
;; Auto vars:     Size  Location     Type
;;  f3_as_produc    3   21[BANK0 ] unsigned um
;;  sign            1   25[BANK0 ] unsigned char 
;;  cntr            1   24[BANK0 ] unsigned char 
;;  exp             1   20[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  3   10[BANK0 ] float 
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
;;		_main
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text443
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\ftmul.c"
	line	52
	global	__size_of___ftmul
	__size_of___ftmul	equ	__end_of___ftmul-___ftmul
	
___ftmul:	
	opt	stack 5
; Regs used in ___ftmul: [wreg+status,2+status,0+pclath+cstack]
	line	56
	
l3258:	
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
	goto	u3081
	goto	u3080
u3081:
	goto	l3264
u3080:
	line	57
	
l3260:	
	movlw	0x0
	movwf	(?___ftmul)
	movlw	0x0
	movwf	(?___ftmul+1)
	movlw	0x0
	movwf	(?___ftmul+2)
	goto	l1297
	
l3262:	
	goto	l1297
	
l1296:	
	line	58
	
l3264:	
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
	goto	u3091
	goto	u3090
u3091:
	goto	l3270
u3090:
	line	59
	
l3266:	
	movlw	0x0
	movwf	(?___ftmul)
	movlw	0x0
	movwf	(?___ftmul+1)
	movlw	0x0
	movwf	(?___ftmul+2)
	goto	l1297
	
l3268:	
	goto	l1297
	
l1298:	
	line	60
	
l3270:	
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
u3105:
	clrc
	rrf	(??___ftmul+0)+2,f
	rrf	(??___ftmul+0)+1,f
	rrf	(??___ftmul+0)+0,f
u3100:
	addlw	-1
	skipz
	goto	u3105
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
u3115:
	clrc
	rrf	(??___ftmul+0)+2,f
	rrf	(??___ftmul+0)+1,f
	rrf	(??___ftmul+0)+0,f
u3110:
	addlw	-1
	skipz
	goto	u3115
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
	
l3272:	
	bsf	(___ftmul@f1)+(15/8),(15)&7
	line	66
	
l3274:	
	bsf	(___ftmul@f2)+(15/8),(15)&7
	line	67
	
l3276:	
	movlw	0FFh
	andwf	(___ftmul@f2),f
	movlw	0FFh
	andwf	(___ftmul@f2+1),f
	movlw	0
	andwf	(___ftmul@f2+2),f
	line	68
	
l3278:	
	movlw	0
	movwf	(___ftmul@f3_as_product)
	movlw	0
	movwf	(___ftmul@f3_as_product+1)
	movlw	0
	movwf	(___ftmul@f3_as_product+2)
	line	69
	
l3280:	
	movlw	(07h)
	movwf	(??___ftmul+0)+0
	movf	(??___ftmul+0)+0,w
	movwf	(___ftmul@cntr)
	goto	l3282
	line	70
	
l1299:	
	line	71
	
l3282:	
	btfss	(___ftmul@f1),(0)&7
	goto	u3121
	goto	u3120
u3121:
	goto	l3286
u3120:
	line	72
	
l3284:	
	movf	(___ftmul@f2),w
	addwf	(___ftmul@f3_as_product),f
	movf	(___ftmul@f2+1),w
	clrz
	skipnc
	incf	(___ftmul@f2+1),w
	skipnz
	goto	u3131
	addwf	(___ftmul@f3_as_product+1),f
u3131:
	movf	(___ftmul@f2+2),w
	clrz
	skipnc
	incf	(___ftmul@f2+2),w
	skipnz
	goto	u3132
	addwf	(___ftmul@f3_as_product+2),f
u3132:

	goto	l3286
	
l1300:	
	line	73
	
l3286:	
	movlw	01h
u3145:
	clrc
	rrf	(___ftmul@f1+2),f
	rrf	(___ftmul@f1+1),f
	rrf	(___ftmul@f1),f
	addlw	-1
	skipz
	goto	u3145

	line	74
	
l3288:	
	movlw	01h
u3155:
	clrc
	rlf	(___ftmul@f2),f
	rlf	(___ftmul@f2+1),f
	rlf	(___ftmul@f2+2),f
	addlw	-1
	skipz
	goto	u3155
	line	75
	
l3290:	
	movlw	low(01h)
	subwf	(___ftmul@cntr),f
	btfss	status,2
	goto	u3161
	goto	u3160
u3161:
	goto	l3282
u3160:
	goto	l3292
	
l1301:	
	line	76
	
l3292:	
	movlw	(09h)
	movwf	(??___ftmul+0)+0
	movf	(??___ftmul+0)+0,w
	movwf	(___ftmul@cntr)
	goto	l3294
	line	77
	
l1302:	
	line	78
	
l3294:	
	btfss	(___ftmul@f1),(0)&7
	goto	u3171
	goto	u3170
u3171:
	goto	l3298
u3170:
	line	79
	
l3296:	
	movf	(___ftmul@f2),w
	addwf	(___ftmul@f3_as_product),f
	movf	(___ftmul@f2+1),w
	clrz
	skipnc
	incf	(___ftmul@f2+1),w
	skipnz
	goto	u3181
	addwf	(___ftmul@f3_as_product+1),f
u3181:
	movf	(___ftmul@f2+2),w
	clrz
	skipnc
	incf	(___ftmul@f2+2),w
	skipnz
	goto	u3182
	addwf	(___ftmul@f3_as_product+2),f
u3182:

	goto	l3298
	
l1303:	
	line	80
	
l3298:	
	movlw	01h
u3195:
	clrc
	rrf	(___ftmul@f1+2),f
	rrf	(___ftmul@f1+1),f
	rrf	(___ftmul@f1),f
	addlw	-1
	skipz
	goto	u3195

	line	81
	
l3300:	
	movlw	01h
u3205:
	clrc
	rrf	(___ftmul@f3_as_product+2),f
	rrf	(___ftmul@f3_as_product+1),f
	rrf	(___ftmul@f3_as_product),f
	addlw	-1
	skipz
	goto	u3205

	line	82
	
l3302:	
	movlw	low(01h)
	subwf	(___ftmul@cntr),f
	btfss	status,2
	goto	u3211
	goto	u3210
u3211:
	goto	l3294
u3210:
	goto	l3304
	
l1304:	
	line	83
	
l3304:	
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
	goto	l1297
	
l3306:	
	line	84
	
l1297:	
	return
	opt stack 0
GLOBAL	__end_of___ftmul
	__end_of___ftmul:
;; =============== function ___ftmul ends ============

	signat	___ftmul,8315
	global	___ftdiv
psect	text444,local,class=CODE,delta=2
global __ptext444
__ptext444:

;; *************** function ___ftdiv *****************
;; Defined at:
;;		line 50 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\ftdiv.c"
;; Parameters:    Size  Location     Type
;;  f2              3    8[COMMON] float 
;;  f1              3   11[COMMON] float 
;; Auto vars:     Size  Location     Type
;;  f3              3    5[BANK0 ] float 
;;  sign            1    9[BANK0 ] unsigned char 
;;  exp             1    8[BANK0 ] unsigned char 
;;  cntr            1    4[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  3    8[COMMON] float 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         6       0       0       0       0
;;      Locals:         0       6       0       0       0
;;      Temps:          0       4       0       0       0
;;      Totals:         6      10       0       0       0
;;Total ram usage:       16 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___ftpack
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text444
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\ftdiv.c"
	line	50
	global	__size_of___ftdiv
	__size_of___ftdiv	equ	__end_of___ftdiv-___ftdiv
	
___ftdiv:	
	opt	stack 6
; Regs used in ___ftdiv: [wreg+status,2+status,0+pclath+cstack]
	line	55
	
l3216:	
	movf	(___ftdiv@f1),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
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
	goto	u3001
	goto	u3000
u3001:
	goto	l3222
u3000:
	line	56
	
l3218:	
	movlw	0x0
	movwf	(?___ftdiv)
	movlw	0x0
	movwf	(?___ftdiv+1)
	movlw	0x0
	movwf	(?___ftdiv+2)
	goto	l1287
	
l3220:	
	goto	l1287
	
l1286:	
	line	57
	
l3222:	
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
	goto	u3011
	goto	u3010
u3011:
	goto	l3228
u3010:
	line	58
	
l3224:	
	movlw	0x0
	movwf	(?___ftdiv)
	movlw	0x0
	movwf	(?___ftdiv+1)
	movlw	0x0
	movwf	(?___ftdiv+2)
	goto	l1287
	
l3226:	
	goto	l1287
	
l1288:	
	line	59
	
l3228:	
	movlw	0
	movwf	(___ftdiv@f3)
	movlw	0
	movwf	(___ftdiv@f3+1)
	movlw	0
	movwf	(___ftdiv@f3+2)
	line	60
	
l3230:	
	movlw	(089h)
	addwf	(___ftdiv@sign),w
	movwf	(??___ftdiv+0)+0
	movf	0+(??___ftdiv+0)+0,w
	subwf	(___ftdiv@exp),f
	line	61
	
l3232:	
	movf	(___ftdiv@f1),w
	movwf	((??___ftdiv+0)+0)
	movf	(___ftdiv@f1+1),w
	movwf	((??___ftdiv+0)+0+1)
	movf	(___ftdiv@f1+2),w
	movwf	((??___ftdiv+0)+0+2)
	movlw	010h
u3025:
	clrc
	rrf	(??___ftdiv+0)+2,f
	rrf	(??___ftdiv+0)+1,f
	rrf	(??___ftdiv+0)+0,f
u3020:
	addlw	-1
	skipz
	goto	u3025
	movf	0+(??___ftdiv+0)+0,w
	movwf	(??___ftdiv+3)+0
	movf	(??___ftdiv+3)+0,w
	movwf	(___ftdiv@sign)
	line	62
	
l3234:	
	movf	(___ftdiv@f2),w
	movwf	((??___ftdiv+0)+0)
	movf	(___ftdiv@f2+1),w
	movwf	((??___ftdiv+0)+0+1)
	movf	(___ftdiv@f2+2),w
	movwf	((??___ftdiv+0)+0+2)
	movlw	010h
u3035:
	clrc
	rrf	(??___ftdiv+0)+2,f
	rrf	(??___ftdiv+0)+1,f
	rrf	(??___ftdiv+0)+0,f
u3030:
	addlw	-1
	skipz
	goto	u3035
	movf	0+(??___ftdiv+0)+0,w
	movwf	(??___ftdiv+3)+0
	movf	(??___ftdiv+3)+0,w
	xorwf	(___ftdiv@sign),f
	line	63
	
l3236:	
	movlw	(080h)
	movwf	(??___ftdiv+0)+0
	movf	(??___ftdiv+0)+0,w
	andwf	(___ftdiv@sign),f
	line	64
	
l3238:	
	bsf	(___ftdiv@f1)+(15/8),(15)&7
	line	65
	movlw	0FFh
	andwf	(___ftdiv@f1),f
	movlw	0FFh
	andwf	(___ftdiv@f1+1),f
	movlw	0
	andwf	(___ftdiv@f1+2),f
	line	66
	
l3240:	
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
	goto	l3242
	line	69
	
l1289:	
	line	70
	
l3242:	
	movlw	01h
u3045:
	clrc
	rlf	(___ftdiv@f3),f
	rlf	(___ftdiv@f3+1),f
	rlf	(___ftdiv@f3+2),f
	addlw	-1
	skipz
	goto	u3045
	line	71
	
l3244:	
	movf	(___ftdiv@f2+2),w
	subwf	(___ftdiv@f1+2),w
	skipz
	goto	u3055
	movf	(___ftdiv@f2+1),w
	subwf	(___ftdiv@f1+1),w
	skipz
	goto	u3055
	movf	(___ftdiv@f2),w
	subwf	(___ftdiv@f1),w
u3055:
	skipc
	goto	u3051
	goto	u3050
u3051:
	goto	l3250
u3050:
	line	72
	
l3246:	
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
	
l3248:	
	bsf	(___ftdiv@f3)+(0/8),(0)&7
	goto	l3250
	line	74
	
l1290:	
	line	75
	
l3250:	
	movlw	01h
u3065:
	clrc
	rlf	(___ftdiv@f1),f
	rlf	(___ftdiv@f1+1),f
	rlf	(___ftdiv@f1+2),f
	addlw	-1
	skipz
	goto	u3065
	line	76
	
l3252:	
	movlw	low(01h)
	subwf	(___ftdiv@cntr),f
	btfss	status,2
	goto	u3071
	goto	u3070
u3071:
	goto	l3242
u3070:
	goto	l3254
	
l1291:	
	line	77
	
l3254:	
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
	movwf	(?___ftdiv)
	movf	(1+(?___ftpack)),w
	movwf	(?___ftdiv+1)
	movf	(2+(?___ftpack)),w
	movwf	(?___ftdiv+2)
	goto	l1287
	
l3256:	
	line	78
	
l1287:	
	return
	opt stack 0
GLOBAL	__end_of___ftdiv
	__end_of___ftdiv:
;; =============== function ___ftdiv ends ============

	signat	___ftdiv,8315
	global	___ftadd
psect	text445,local,class=CODE,delta=2
global __ptext445
__ptext445:

;; *************** function ___ftadd *****************
;; Defined at:
;;		line 87 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\ftadd.c"
;; Parameters:    Size  Location     Type
;;  f1              3    3[BANK0 ] float 
;;  f2              3    6[BANK0 ] float 
;; Auto vars:     Size  Location     Type
;;  exp1            1   15[BANK0 ] unsigned char 
;;  exp2            1   14[BANK0 ] unsigned char 
;;  sign            1   13[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  3    3[BANK0 ] float 
;; Registers used:
;;		wreg, status,2, status,0, pclath, cstack
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       6       0       0       0
;;      Locals:         0       3       0       0       0
;;      Temps:          0       4       0       0       0
;;      Totals:         0      13       0       0       0
;;Total ram usage:       13 bytes
;; Hardware stack levels used:    1
;; Hardware stack levels required when called:    1
;; This function calls:
;;		___ftpack
;; This function is called by:
;;		_disp
;;		___ftsub
;; This function uses a non-reentrant model
;;
psect	text445
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\ftadd.c"
	line	87
	global	__size_of___ftadd
	__size_of___ftadd	equ	__end_of___ftadd-___ftadd
	
___ftadd:	
	opt	stack 5
; Regs used in ___ftadd: [wreg+status,2+status,0+pclath+cstack]
	line	90
	
l3144:	
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movf	(___ftadd@f1),w
	movwf	((??___ftadd+0)+0)
	movf	(___ftadd@f1+1),w
	movwf	((??___ftadd+0)+0+1)
	movf	(___ftadd@f1+2),w
	movwf	((??___ftadd+0)+0+2)
	clrc
	rlf	(??___ftadd+0)+1,w
	rlf	(??___ftadd+0)+2,w
	movwf	(??___ftadd+3)+0
	movf	(??___ftadd+3)+0,w
	movwf	(___ftadd@exp1)
	line	91
	movf	(___ftadd@f2),w
	movwf	((??___ftadd+0)+0)
	movf	(___ftadd@f2+1),w
	movwf	((??___ftadd+0)+0+1)
	movf	(___ftadd@f2+2),w
	movwf	((??___ftadd+0)+0+2)
	clrc
	rlf	(??___ftadd+0)+1,w
	rlf	(??___ftadd+0)+2,w
	movwf	(??___ftadd+3)+0
	movf	(??___ftadd+3)+0,w
	movwf	(___ftadd@exp2)
	line	92
	
l3146:	
	movf	(___ftadd@exp1),w
	skipz
	goto	u2760
	goto	l3152
u2760:
	
l3148:	
	movf	(___ftadd@exp2),w
	subwf	(___ftadd@exp1),w
	skipnc
	goto	u2771
	goto	u2770
u2771:
	goto	l3156
u2770:
	
l3150:	
	decf	(___ftadd@exp1),w
	xorlw	0ffh
	addwf	(___ftadd@exp2),w
	movwf	(??___ftadd+0)+0
	movlw	(019h)
	subwf	0+(??___ftadd+0)+0,w
	skipc
	goto	u2781
	goto	u2780
u2781:
	goto	l3156
u2780:
	goto	l3152
	
l1244:	
	line	93
	
l3152:	
	movf	(___ftadd@f2),w
	movwf	(?___ftadd)
	movf	(___ftadd@f2+1),w
	movwf	(?___ftadd+1)
	movf	(___ftadd@f2+2),w
	movwf	(?___ftadd+2)
	goto	l1245
	
l3154:	
	goto	l1245
	
l1242:	
	line	94
	
l3156:	
	movf	(___ftadd@exp2),w
	skipz
	goto	u2790
	goto	l1248
u2790:
	
l3158:	
	movf	(___ftadd@exp1),w
	subwf	(___ftadd@exp2),w
	skipnc
	goto	u2801
	goto	u2800
u2801:
	goto	l3162
u2800:
	
l3160:	
	decf	(___ftadd@exp2),w
	xorlw	0ffh
	addwf	(___ftadd@exp1),w
	movwf	(??___ftadd+0)+0
	movlw	(019h)
	subwf	0+(??___ftadd+0)+0,w
	skipc
	goto	u2811
	goto	u2810
u2811:
	goto	l3162
u2810:
	
l1248:	
	line	95
	goto	l1245
	
l1246:	
	line	96
	
l3162:	
	movlw	(06h)
	movwf	(??___ftadd+0)+0
	movf	(??___ftadd+0)+0,w
	movwf	(___ftadd@sign)
	line	97
	
l3164:	
	btfss	(___ftadd@f1+2),(23)&7
	goto	u2821
	goto	u2820
u2821:
	goto	l1249
u2820:
	line	98
	
l3166:	
	bsf	(___ftadd@sign)+(7/8),(7)&7
	
l1249:	
	line	99
	btfss	(___ftadd@f2+2),(23)&7
	goto	u2831
	goto	u2830
u2831:
	goto	l1250
u2830:
	line	100
	
l3168:	
	bsf	(___ftadd@sign)+(6/8),(6)&7
	
l1250:	
	line	101
	bsf	(___ftadd@f1)+(15/8),(15)&7
	line	102
	
l3170:	
	movlw	0FFh
	andwf	(___ftadd@f1),f
	movlw	0FFh
	andwf	(___ftadd@f1+1),f
	movlw	0
	andwf	(___ftadd@f1+2),f
	line	103
	
l3172:	
	bsf	(___ftadd@f2)+(15/8),(15)&7
	line	104
	movlw	0FFh
	andwf	(___ftadd@f2),f
	movlw	0FFh
	andwf	(___ftadd@f2+1),f
	movlw	0
	andwf	(___ftadd@f2+2),f
	line	106
	movf	(___ftadd@exp2),w
	subwf	(___ftadd@exp1),w
	skipnc
	goto	u2841
	goto	u2840
u2841:
	goto	l3184
u2840:
	goto	l3174
	line	109
	
l1252:	
	line	110
	
l3174:	
	movlw	01h
u2855:
	clrc
	rlf	(___ftadd@f2),f
	rlf	(___ftadd@f2+1),f
	rlf	(___ftadd@f2+2),f
	addlw	-1
	skipz
	goto	u2855
	line	111
	movlw	low(01h)
	subwf	(___ftadd@exp2),f
	line	112
	
l3176:	
	movf	(___ftadd@exp2),w
	xorwf	(___ftadd@exp1),w
	skipnz
	goto	u2861
	goto	u2860
u2861:
	goto	l3182
u2860:
	
l3178:	
	movlw	low(01h)
	subwf	(___ftadd@sign),f
	movf	((___ftadd@sign)),w
	andlw	07h
	btfss	status,2
	goto	u2871
	goto	u2870
u2871:
	goto	l3174
u2870:
	goto	l3182
	
l1254:	
	goto	l3182
	
l1255:	
	line	113
	goto	l3182
	
l1257:	
	line	114
	
l3180:	
	movlw	01h
u2885:
	clrc
	rrf	(___ftadd@f1+2),f
	rrf	(___ftadd@f1+1),f
	rrf	(___ftadd@f1),f
	addlw	-1
	skipz
	goto	u2885

	line	115
	movlw	(01h)
	movwf	(??___ftadd+0)+0
	movf	(??___ftadd+0)+0,w
	addwf	(___ftadd@exp1),f
	goto	l3182
	line	116
	
l1256:	
	line	113
	
l3182:	
	movf	(___ftadd@exp1),w
	xorwf	(___ftadd@exp2),w
	skipz
	goto	u2891
	goto	u2890
u2891:
	goto	l3180
u2890:
	goto	l1259
	
l1258:	
	line	117
	goto	l1259
	
l1251:	
	
l3184:	
	movf	(___ftadd@exp1),w
	subwf	(___ftadd@exp2),w
	skipnc
	goto	u2901
	goto	u2900
u2901:
	goto	l1259
u2900:
	goto	l3186
	line	120
	
l1261:	
	line	121
	
l3186:	
	movlw	01h
u2915:
	clrc
	rlf	(___ftadd@f1),f
	rlf	(___ftadd@f1+1),f
	rlf	(___ftadd@f1+2),f
	addlw	-1
	skipz
	goto	u2915
	line	122
	movlw	low(01h)
	subwf	(___ftadd@exp1),f
	line	123
	
l3188:	
	movf	(___ftadd@exp2),w
	xorwf	(___ftadd@exp1),w
	skipnz
	goto	u2921
	goto	u2920
u2921:
	goto	l3194
u2920:
	
l3190:	
	movlw	low(01h)
	subwf	(___ftadd@sign),f
	movf	((___ftadd@sign)),w
	andlw	07h
	btfss	status,2
	goto	u2931
	goto	u2930
u2931:
	goto	l3186
u2930:
	goto	l3194
	
l1263:	
	goto	l3194
	
l1264:	
	line	124
	goto	l3194
	
l1266:	
	line	125
	
l3192:	
	movlw	01h
u2945:
	clrc
	rrf	(___ftadd@f2+2),f
	rrf	(___ftadd@f2+1),f
	rrf	(___ftadd@f2),f
	addlw	-1
	skipz
	goto	u2945

	line	126
	movlw	(01h)
	movwf	(??___ftadd+0)+0
	movf	(??___ftadd+0)+0,w
	addwf	(___ftadd@exp2),f
	goto	l3194
	line	127
	
l1265:	
	line	124
	
l3194:	
	movf	(___ftadd@exp1),w
	xorwf	(___ftadd@exp2),w
	skipz
	goto	u2951
	goto	u2950
u2951:
	goto	l3192
u2950:
	goto	l1259
	
l1267:	
	goto	l1259
	line	128
	
l1260:	
	line	129
	
l1259:	
	btfss	(___ftadd@sign),(7)&7
	goto	u2961
	goto	u2960
u2961:
	goto	l3198
u2960:
	line	131
	
l3196:	
	movlw	0FFh
	xorwf	(___ftadd@f1),f
	movlw	0FFh
	xorwf	(___ftadd@f1+1),f
	movlw	0FFh
	xorwf	(___ftadd@f1+2),f
	line	132
	movlw	01h
	addwf	(___ftadd@f1),f
	movlw	0
	skipnc
movlw 1
	addwf	(___ftadd@f1+1),f
	movlw	0
	skipnc
movlw 1
	addwf	(___ftadd@f1+2),f
	goto	l3198
	line	133
	
l1268:	
	line	134
	
l3198:	
	btfss	(___ftadd@sign),(6)&7
	goto	u2971
	goto	u2970
u2971:
	goto	l3202
u2970:
	line	136
	
l3200:	
	movlw	0FFh
	xorwf	(___ftadd@f2),f
	movlw	0FFh
	xorwf	(___ftadd@f2+1),f
	movlw	0FFh
	xorwf	(___ftadd@f2+2),f
	line	137
	movlw	01h
	addwf	(___ftadd@f2),f
	movlw	0
	skipnc
movlw 1
	addwf	(___ftadd@f2+1),f
	movlw	0
	skipnc
movlw 1
	addwf	(___ftadd@f2+2),f
	goto	l3202
	line	138
	
l1269:	
	line	139
	
l3202:	
	clrc
	movlw	0
	btfsc	status,0
	movlw	1
	movwf	(___ftadd@sign)
	line	140
	
l3204:	
	movf	(___ftadd@f1),w
	addwf	(___ftadd@f2),f
	movf	(___ftadd@f1+1),w
	clrz
	skipnc
	incf	(___ftadd@f1+1),w
	skipnz
	goto	u2981
	addwf	(___ftadd@f2+1),f
u2981:
	movf	(___ftadd@f1+2),w
	clrz
	skipnc
	incf	(___ftadd@f1+2),w
	skipnz
	goto	u2982
	addwf	(___ftadd@f2+2),f
u2982:

	line	141
	
l3206:	
	btfss	(___ftadd@f2+2),(23)&7
	goto	u2991
	goto	u2990
u2991:
	goto	l3212
u2990:
	line	142
	
l3208:	
	movlw	0FFh
	xorwf	(___ftadd@f2),f
	movlw	0FFh
	xorwf	(___ftadd@f2+1),f
	movlw	0FFh
	xorwf	(___ftadd@f2+2),f
	line	143
	movlw	01h
	addwf	(___ftadd@f2),f
	movlw	0
	skipnc
movlw 1
	addwf	(___ftadd@f2+1),f
	movlw	0
	skipnc
movlw 1
	addwf	(___ftadd@f2+2),f
	line	144
	
l3210:	
	clrf	(___ftadd@sign)
	bsf	status,0
	rlf	(___ftadd@sign),f
	goto	l3212
	line	145
	
l1270:	
	line	146
	
l3212:	
	movf	(___ftadd@f2),w
	movwf	(?___ftpack)
	movf	(___ftadd@f2+1),w
	movwf	(?___ftpack+1)
	movf	(___ftadd@f2+2),w
	movwf	(?___ftpack+2)
	movf	(___ftadd@exp1),w
	movwf	(??___ftadd+0)+0
	movf	(??___ftadd+0)+0,w
	movwf	0+(?___ftpack)+03h
	movf	(___ftadd@sign),w
	movwf	(??___ftadd+1)+0
	movf	(??___ftadd+1)+0,w
	movwf	0+(?___ftpack)+04h
	fcall	___ftpack
	movf	(0+(?___ftpack)),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(?___ftadd)
	movf	(1+(?___ftpack)),w
	movwf	(?___ftadd+1)
	movf	(2+(?___ftpack)),w
	movwf	(?___ftadd+2)
	goto	l1245
	
l3214:	
	line	148
	
l1245:	
	return
	opt stack 0
GLOBAL	__end_of___ftadd
	__end_of___ftadd:
;; =============== function ___ftadd ends ============

	signat	___ftadd,8315
	global	_lcd_write
psect	text446,local,class=CODE,delta=2
global __ptext446
__ptext446:

;; *************** function _lcd_write *****************
;; Defined at:
;;		line 39 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
;; Parameters:    Size  Location     Type
;;  c               1    wreg     unsigned char 
;; Auto vars:     Size  Location     Type
;;  c               1    1[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         1       0       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         2       0       0       0       0
;;Total ram usage:        2 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_lcd_clear
;;		_lcd_puts
;;		_lcd_putch
;;		_lcd_goto
;;		_lcd_init
;; This function uses a non-reentrant model
;;
psect	text446
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\lcd.c"
	line	39
	global	__size_of_lcd_write
	__size_of_lcd_write	equ	__end_of_lcd_write-_lcd_write
	
_lcd_write:	
	opt	stack 5
; Regs used in _lcd_write: [wreg+status,2+status,0]
;lcd_write@c stored from wreg
	movwf	(lcd_write@c)
	line	40
	
l3130:	
;lcd.c: 40: _delay((unsigned long)((40)*(4000000/4000000.0)));
	opt asmopt_off
movlw	13
movwf	(??_lcd_write+0)+0,f
u3307:
decfsz	(??_lcd_write+0)+0,f
	goto	u3307
opt asmopt_on

	line	41
	
l3132:	
;lcd.c: 41: PORTD = ( ( c >> 4 ) & 0x0F );
	movf	(lcd_write@c),w
	movwf	(??_lcd_write+0)+0
	movlw	04h
u2755:
	clrc
	rrf	(??_lcd_write+0)+0,f
	addlw	-1
	skipz
	goto	u2755
	movf	0+(??_lcd_write+0)+0,w
	andlw	0Fh
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
	movwf	(8)	;volatile
	line	42
	
l3134:	
;lcd.c: 42: ((RA1 = 1),(RA1=0));
	bsf	(41/8),(41)&7
	
l3136:	
	bcf	(41/8),(41)&7
	line	43
	
l3138:	
;lcd.c: 43: PORTD = ( c & 0x0F );
	movf	(lcd_write@c),w
	andlw	0Fh
	movwf	(8)	;volatile
	line	44
	
l3140:	
;lcd.c: 44: ((RA1 = 1),(RA1=0));
	bsf	(41/8),(41)&7
	
l3142:	
	bcf	(41/8),(41)&7
	line	45
	
l1161:	
	return
	opt stack 0
GLOBAL	__end_of_lcd_write
	__end_of_lcd_write:
;; =============== function _lcd_write ends ============

	signat	_lcd_write,4216
	global	___awmod
psect	text447,local,class=CODE,delta=2
global __ptext447
__ptext447:

;; *************** function ___awmod *****************
;; Defined at:
;;		line 5 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\awmod.c"
;; Parameters:    Size  Location     Type
;;  divisor         2    0[COMMON] int 
;;  dividend        2    2[COMMON] int 
;; Auto vars:     Size  Location     Type
;;  sign            1    6[COMMON] unsigned char 
;;  counter         1    5[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;                  2    0[COMMON] int 
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         4       0       0       0       0
;;      Locals:         2       0       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         7       0       0       0       0
;;Total ram usage:        7 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text447
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\awmod.c"
	line	5
	global	__size_of___awmod
	__size_of___awmod	equ	__end_of___awmod-___awmod
	
___awmod:	
	opt	stack 6
; Regs used in ___awmod: [wreg+status,2+status,0]
	line	8
	
l3050:	
	clrc
	movlw	0
	btfsc	status,0
	movlw	1
	movwf	(___awmod@sign)
	line	9
	
l3052:	
	btfss	(___awmod@dividend+1),7
	goto	u2601
	goto	u2600
u2601:
	goto	l3056
u2600:
	line	10
	
l3054:	
	comf	(___awmod@dividend),f
	comf	(___awmod@dividend+1),f
	incf	(___awmod@dividend),f
	skipnz
	incf	(___awmod@dividend+1),f
	line	11
	clrf	(___awmod@sign)
	bsf	status,0
	rlf	(___awmod@sign),f
	goto	l3056
	line	12
	
l1406:	
	line	13
	
l3056:	
	btfss	(___awmod@divisor+1),7
	goto	u2611
	goto	u2610
u2611:
	goto	l3060
u2610:
	line	14
	
l3058:	
	comf	(___awmod@divisor),f
	comf	(___awmod@divisor+1),f
	incf	(___awmod@divisor),f
	skipnz
	incf	(___awmod@divisor+1),f
	goto	l3060
	
l1407:	
	line	15
	
l3060:	
	movf	(___awmod@divisor+1),w
	iorwf	(___awmod@divisor),w
	skipnz
	goto	u2621
	goto	u2620
u2621:
	goto	l3078
u2620:
	line	16
	
l3062:	
	clrf	(___awmod@counter)
	bsf	status,0
	rlf	(___awmod@counter),f
	line	17
	goto	l3068
	
l1410:	
	line	18
	
l3064:	
	movlw	01h
	
u2635:
	clrc
	rlf	(___awmod@divisor),f
	rlf	(___awmod@divisor+1),f
	addlw	-1
	skipz
	goto	u2635
	line	19
	
l3066:	
	movlw	(01h)
	movwf	(??___awmod+0)+0
	movf	(??___awmod+0)+0,w
	addwf	(___awmod@counter),f
	goto	l3068
	line	20
	
l1409:	
	line	17
	
l3068:	
	btfss	(___awmod@divisor+1),(15)&7
	goto	u2641
	goto	u2640
u2641:
	goto	l3064
u2640:
	goto	l3070
	
l1411:	
	goto	l3070
	line	21
	
l1412:	
	line	22
	
l3070:	
	movf	(___awmod@divisor+1),w
	subwf	(___awmod@dividend+1),w
	skipz
	goto	u2655
	movf	(___awmod@divisor),w
	subwf	(___awmod@dividend),w
u2655:
	skipc
	goto	u2651
	goto	u2650
u2651:
	goto	l3074
u2650:
	line	23
	
l3072:	
	movf	(___awmod@divisor),w
	subwf	(___awmod@dividend),f
	movf	(___awmod@divisor+1),w
	skipc
	decf	(___awmod@dividend+1),f
	subwf	(___awmod@dividend+1),f
	goto	l3074
	
l1413:	
	line	24
	
l3074:	
	movlw	01h
	
u2665:
	clrc
	rrf	(___awmod@divisor+1),f
	rrf	(___awmod@divisor),f
	addlw	-1
	skipz
	goto	u2665
	line	25
	
l3076:	
	movlw	low(01h)
	subwf	(___awmod@counter),f
	btfss	status,2
	goto	u2671
	goto	u2670
u2671:
	goto	l3070
u2670:
	goto	l3078
	
l1414:	
	goto	l3078
	line	26
	
l1408:	
	line	27
	
l3078:	
	movf	(___awmod@sign),w
	skipz
	goto	u2680
	goto	l3082
u2680:
	line	28
	
l3080:	
	comf	(___awmod@dividend),f
	comf	(___awmod@dividend+1),f
	incf	(___awmod@dividend),f
	skipnz
	incf	(___awmod@dividend+1),f
	goto	l3082
	
l1415:	
	line	29
	
l3082:	
	movf	(___awmod@dividend+1),w
	clrf	(?___awmod+1)
	addwf	(?___awmod+1)
	movf	(___awmod@dividend),w
	clrf	(?___awmod)
	addwf	(?___awmod)

	goto	l1416
	
l3084:	
	line	30
	
l1416:	
	return
	opt stack 0
GLOBAL	__end_of___awmod
	__end_of___awmod:
;; =============== function ___awmod ends ============

	signat	___awmod,8314
	global	___ftneg
psect	text448,local,class=CODE,delta=2
global __ptext448
__ptext448:

;; *************** function ___ftneg *****************
;; Defined at:
;;		line 16 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\ftneg.c"
;; Parameters:    Size  Location     Type
;;  f1              3    8[COMMON] float 
;; Auto vars:     Size  Location     Type
;;		None
;; Return value:  Size  Location     Type
;;                  3    8[COMMON] float 
;; Registers used:
;;		wreg
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         3       0       0       0       0
;;      Locals:         0       0       0       0       0
;;      Temps:          0       0       0       0       0
;;      Totals:         3       0       0       0       0
;;Total ram usage:        3 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text448
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\ftneg.c"
	line	16
	global	__size_of___ftneg
	__size_of___ftneg	equ	__end_of___ftneg-___ftneg
	
___ftneg:	
	opt	stack 6
; Regs used in ___ftneg: [wreg]
	line	17
	
l3042:	
	movf	(___ftneg@f1+2),w
	iorwf	(___ftneg@f1+1),w
	iorwf	(___ftneg@f1),w
	skipnz
	goto	u2591
	goto	u2590
u2591:
	goto	l3046
u2590:
	line	18
	
l3044:	
	movlw	080h
	xorwf	(___ftneg@f1+2),f
	goto	l3046
	
l1361:	
	line	19
	
l3046:	
	goto	l1362
	
l3048:	
	line	20
	
l1362:	
	return
	opt stack 0
GLOBAL	__end_of___ftneg
	__end_of___ftneg:
;; =============== function ___ftneg ends ============

	signat	___ftneg,4219
	global	___awdiv
psect	text449,local,class=CODE,delta=2
global __ptext449
__ptext449:

;; *************** function ___awdiv *****************
;; Defined at:
;;		line 5 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\awdiv.c"
;; Parameters:    Size  Location     Type
;;  divisor         2    0[COMMON] int 
;;  dividend        2    2[COMMON] int 
;; Auto vars:     Size  Location     Type
;;  quotient        2    7[COMMON] int 
;;  sign            1    6[COMMON] unsigned char 
;;  counter         1    5[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;                  2    0[COMMON] int 
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         4       0       0       0       0
;;      Locals:         4       0       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         9       0       0       0       0
;;Total ram usage:        9 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text449
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\awdiv.c"
	line	5
	global	__size_of___awdiv
	__size_of___awdiv	equ	__end_of___awdiv-___awdiv
	
___awdiv:	
	opt	stack 6
; Regs used in ___awdiv: [wreg+status,2+status,0]
	line	9
	
l3004:	
	clrc
	movlw	0
	btfsc	status,0
	movlw	1
	movwf	(___awdiv@sign)
	line	10
	
l3006:	
	btfss	(___awdiv@divisor+1),7
	goto	u2491
	goto	u2490
u2491:
	goto	l3010
u2490:
	line	11
	
l3008:	
	comf	(___awdiv@divisor),f
	comf	(___awdiv@divisor+1),f
	incf	(___awdiv@divisor),f
	skipnz
	incf	(___awdiv@divisor+1),f
	line	12
	clrf	(___awdiv@sign)
	bsf	status,0
	rlf	(___awdiv@sign),f
	goto	l3010
	line	13
	
l1338:	
	line	14
	
l3010:	
	btfss	(___awdiv@dividend+1),7
	goto	u2501
	goto	u2500
u2501:
	goto	l1339
u2500:
	line	15
	
l3012:	
	comf	(___awdiv@dividend),f
	comf	(___awdiv@dividend+1),f
	incf	(___awdiv@dividend),f
	skipnz
	incf	(___awdiv@dividend+1),f
	line	16
	
l3014:	
	movlw	(01h)
	movwf	(??___awdiv+0)+0
	movf	(??___awdiv+0)+0,w
	xorwf	(___awdiv@sign),f
	line	17
	
l1339:	
	line	18
	movlw	low(0)
	movwf	(___awdiv@quotient)
	movlw	high(0)
	movwf	((___awdiv@quotient))+1
	line	19
	movf	(___awdiv@divisor+1),w
	iorwf	(___awdiv@divisor),w
	skipnz
	goto	u2511
	goto	u2510
u2511:
	goto	l3034
u2510:
	line	20
	
l3016:	
	clrf	(___awdiv@counter)
	bsf	status,0
	rlf	(___awdiv@counter),f
	line	21
	goto	l3022
	
l1342:	
	line	22
	
l3018:	
	movlw	01h
	
u2525:
	clrc
	rlf	(___awdiv@divisor),f
	rlf	(___awdiv@divisor+1),f
	addlw	-1
	skipz
	goto	u2525
	line	23
	
l3020:	
	movlw	(01h)
	movwf	(??___awdiv+0)+0
	movf	(??___awdiv+0)+0,w
	addwf	(___awdiv@counter),f
	goto	l3022
	line	24
	
l1341:	
	line	21
	
l3022:	
	btfss	(___awdiv@divisor+1),(15)&7
	goto	u2531
	goto	u2530
u2531:
	goto	l3018
u2530:
	goto	l3024
	
l1343:	
	goto	l3024
	line	25
	
l1344:	
	line	26
	
l3024:	
	movlw	01h
	
u2545:
	clrc
	rlf	(___awdiv@quotient),f
	rlf	(___awdiv@quotient+1),f
	addlw	-1
	skipz
	goto	u2545
	line	27
	movf	(___awdiv@divisor+1),w
	subwf	(___awdiv@dividend+1),w
	skipz
	goto	u2555
	movf	(___awdiv@divisor),w
	subwf	(___awdiv@dividend),w
u2555:
	skipc
	goto	u2551
	goto	u2550
u2551:
	goto	l3030
u2550:
	line	28
	
l3026:	
	movf	(___awdiv@divisor),w
	subwf	(___awdiv@dividend),f
	movf	(___awdiv@divisor+1),w
	skipc
	decf	(___awdiv@dividend+1),f
	subwf	(___awdiv@dividend+1),f
	line	29
	
l3028:	
	bsf	(___awdiv@quotient)+(0/8),(0)&7
	goto	l3030
	line	30
	
l1345:	
	line	31
	
l3030:	
	movlw	01h
	
u2565:
	clrc
	rrf	(___awdiv@divisor+1),f
	rrf	(___awdiv@divisor),f
	addlw	-1
	skipz
	goto	u2565
	line	32
	
l3032:	
	movlw	low(01h)
	subwf	(___awdiv@counter),f
	btfss	status,2
	goto	u2571
	goto	u2570
u2571:
	goto	l3024
u2570:
	goto	l3034
	
l1346:	
	goto	l3034
	line	33
	
l1340:	
	line	34
	
l3034:	
	movf	(___awdiv@sign),w
	skipz
	goto	u2580
	goto	l3038
u2580:
	line	35
	
l3036:	
	comf	(___awdiv@quotient),f
	comf	(___awdiv@quotient+1),f
	incf	(___awdiv@quotient),f
	skipnz
	incf	(___awdiv@quotient+1),f
	goto	l3038
	
l1347:	
	line	36
	
l3038:	
	movf	(___awdiv@quotient+1),w
	clrf	(?___awdiv+1)
	addwf	(?___awdiv+1)
	movf	(___awdiv@quotient),w
	clrf	(?___awdiv)
	addwf	(?___awdiv)

	goto	l1348
	
l3040:	
	line	37
	
l1348:	
	return
	opt stack 0
GLOBAL	__end_of___awdiv
	__end_of___awdiv:
;; =============== function ___awdiv ends ============

	signat	___awdiv,8314
	global	___fttol
psect	text450,local,class=CODE,delta=2
global __ptext450
__ptext450:

;; *************** function ___fttol *****************
;; Defined at:
;;		line 45 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\fttol.c"
;; Parameters:    Size  Location     Type
;;  f1              3    8[COMMON] float 
;; Auto vars:     Size  Location     Type
;;  lval            4    5[BANK0 ] unsigned long 
;;  exp1            1    9[BANK0 ] unsigned char 
;;  sign1           1    4[BANK0 ] unsigned char 
;; Return value:  Size  Location     Type
;;                  4    8[COMMON] long 
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         4       0       0       0       0
;;      Locals:         0       6       0       0       0
;;      Temps:          0       4       0       0       0
;;      Totals:         4      10       0       0       0
;;Total ram usage:       14 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text450
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\fttol.c"
	line	45
	global	__size_of___fttol
	__size_of___fttol	equ	__end_of___fttol-___fttol
	
___fttol:	
	opt	stack 6
; Regs used in ___fttol: [wreg+status,2+status,0]
	line	49
	
l2946:	
	movf	(___fttol@f1),w
	bcf	status, 5	;RP0=0, select bank0
	bcf	status, 6	;RP1=0, select bank0
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
	goto	u2381
	goto	u2380
u2381:
	goto	l2952
u2380:
	line	50
	
l2948:	
	movlw	0
	movwf	(?___fttol+3)
	movlw	0
	movwf	(?___fttol+2)
	movlw	0
	movwf	(?___fttol+1)
	movlw	0
	movwf	(?___fttol)

	goto	l1308
	
l2950:	
	goto	l1308
	
l1307:	
	line	51
	
l2952:	
	movf	(___fttol@f1),w
	movwf	((??___fttol+0)+0)
	movf	(___fttol@f1+1),w
	movwf	((??___fttol+0)+0+1)
	movf	(___fttol@f1+2),w
	movwf	((??___fttol+0)+0+2)
	movlw	017h
u2395:
	clrc
	rrf	(??___fttol+0)+2,f
	rrf	(??___fttol+0)+1,f
	rrf	(??___fttol+0)+0,f
u2390:
	addlw	-1
	skipz
	goto	u2395
	movf	0+(??___fttol+0)+0,w
	movwf	(??___fttol+3)+0
	movf	(??___fttol+3)+0,w
	movwf	(___fttol@sign1)
	line	52
	
l2954:	
	bsf	(___fttol@f1)+(15/8),(15)&7
	line	53
	
l2956:	
	movlw	0FFh
	andwf	(___fttol@f1),f
	movlw	0FFh
	andwf	(___fttol@f1+1),f
	movlw	0
	andwf	(___fttol@f1+2),f
	line	54
	
l2958:	
	movf	(___fttol@f1),w
	movwf	(___fttol@lval)
	movf	(___fttol@f1+1),w
	movwf	((___fttol@lval))+1
	movf	(___fttol@f1+2),w
	movwf	((___fttol@lval))+2
	clrf	((___fttol@lval))+3
	line	55
	
l2960:	
	movlw	low(08Eh)
	subwf	(___fttol@exp1),f
	line	56
	
l2962:	
	btfss	(___fttol@exp1),7
	goto	u2401
	goto	u2400
u2401:
	goto	l2972
u2400:
	line	57
	
l2964:	
	movf	(___fttol@exp1),w
	xorlw	80h
	addlw	-((-15)^80h)
	skipnc
	goto	u2411
	goto	u2410
u2411:
	goto	l2970
u2410:
	line	58
	
l2966:	
	movlw	0
	movwf	(?___fttol+3)
	movlw	0
	movwf	(?___fttol+2)
	movlw	0
	movwf	(?___fttol+1)
	movlw	0
	movwf	(?___fttol)

	goto	l1308
	
l2968:	
	goto	l1308
	
l1310:	
	goto	l2970
	line	59
	
l1311:	
	line	60
	
l2970:	
	movlw	01h
u2425:
	clrc
	rrf	(___fttol@lval+3),f
	rrf	(___fttol@lval+2),f
	rrf	(___fttol@lval+1),f
	rrf	(___fttol@lval),f
	addlw	-1
	skipz
	goto	u2425

	line	61
	movlw	(01h)
	movwf	(??___fttol+0)+0
	movf	(??___fttol+0)+0,w
	addwf	(___fttol@exp1),f
	btfss	status,2
	goto	u2431
	goto	u2430
u2431:
	goto	l2970
u2430:
	goto	l2982
	
l1312:	
	line	62
	goto	l2982
	
l1309:	
	line	63
	
l2972:	
	movlw	(018h)
	subwf	(___fttol@exp1),w
	skipc
	goto	u2441
	goto	u2440
u2441:
	goto	l2980
u2440:
	line	64
	
l2974:	
	movlw	0
	movwf	(?___fttol+3)
	movlw	0
	movwf	(?___fttol+2)
	movlw	0
	movwf	(?___fttol+1)
	movlw	0
	movwf	(?___fttol)

	goto	l1308
	
l2976:	
	goto	l1308
	
l1314:	
	line	65
	goto	l2980
	
l1316:	
	line	66
	
l2978:	
	movlw	01h
	movwf	(??___fttol+0)+0
u2455:
	clrc
	rlf	(___fttol@lval),f
	rlf	(___fttol@lval+1),f
	rlf	(___fttol@lval+2),f
	rlf	(___fttol@lval+3),f
	decfsz	(??___fttol+0)+0
	goto	u2455
	line	67
	movlw	low(01h)
	subwf	(___fttol@exp1),f
	goto	l2980
	line	68
	
l1315:	
	line	65
	
l2980:	
	movf	(___fttol@exp1),f
	skipz
	goto	u2461
	goto	u2460
u2461:
	goto	l2978
u2460:
	goto	l2982
	
l1317:	
	goto	l2982
	line	69
	
l1313:	
	line	70
	
l2982:	
	movf	(___fttol@sign1),w
	skipz
	goto	u2470
	goto	l2986
u2470:
	line	71
	
l2984:	
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
	goto	l2986
	
l1318:	
	line	72
	
l2986:	
	movf	(___fttol@lval+3),w
	movwf	(?___fttol+3)
	movf	(___fttol@lval+2),w
	movwf	(?___fttol+2)
	movf	(___fttol@lval+1),w
	movwf	(?___fttol+1)
	movf	(___fttol@lval),w
	movwf	(?___fttol)

	goto	l1308
	
l2988:	
	line	73
	
l1308:	
	return
	opt stack 0
GLOBAL	__end_of___fttol
	__end_of___fttol:
;; =============== function ___fttol ends ============

	signat	___fttol,4220
	global	___ftpack
psect	text451,local,class=CODE,delta=2
global __ptext451
__ptext451:

;; *************** function ___ftpack *****************
;; Defined at:
;;		line 63 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\float.c"
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
;;		___ftadd
;;		___ftdiv
;;		___ftmul
;;		___awtoft
;;		___lwtoft
;;		___lbtoft
;;		___abtoft
;;		___altoft
;;		___lltoft
;;		___attoft
;;		___lttoft
;; This function uses a non-reentrant model
;;
psect	text451
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\float.c"
	line	63
	global	__size_of___ftpack
	__size_of___ftpack	equ	__end_of___ftpack-___ftpack
	
___ftpack:	
	opt	stack 5
; Regs used in ___ftpack: [wreg+status,2+status,0]
	line	64
	
l2910:	
	movf	(___ftpack@exp),w
	skipz
	goto	u2270
	goto	l2914
u2270:
	
l2912:	
	movf	(___ftpack@arg+2),w
	iorwf	(___ftpack@arg+1),w
	iorwf	(___ftpack@arg),w
	skipz
	goto	u2281
	goto	u2280
u2281:
	goto	l2920
u2280:
	goto	l2914
	
l1532:	
	line	65
	
l2914:	
	movlw	0x0
	movwf	(?___ftpack)
	movlw	0x0
	movwf	(?___ftpack+1)
	movlw	0x0
	movwf	(?___ftpack+2)
	goto	l1533
	
l2916:	
	goto	l1533
	
l1530:	
	line	66
	goto	l2920
	
l1535:	
	line	67
	
l2918:	
	movlw	(01h)
	movwf	(??___ftpack+0)+0
	movf	(??___ftpack+0)+0,w
	addwf	(___ftpack@exp),f
	line	68
	movlw	01h
u2295:
	clrc
	rrf	(___ftpack@arg+2),f
	rrf	(___ftpack@arg+1),f
	rrf	(___ftpack@arg),f
	addlw	-1
	skipz
	goto	u2295

	goto	l2920
	line	69
	
l1534:	
	line	66
	
l2920:	
	movlw	low highword(0FE0000h)
	andwf	(___ftpack@arg+2),w
	btfss	status,2
	goto	u2301
	goto	u2300
u2301:
	goto	l2918
u2300:
	goto	l1537
	
l1536:	
	line	70
	goto	l1537
	
l1538:	
	line	71
	
l2922:	
	movlw	(01h)
	movwf	(??___ftpack+0)+0
	movf	(??___ftpack+0)+0,w
	addwf	(___ftpack@exp),f
	line	72
	
l2924:	
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
	
l2926:	
	movlw	01h
u2315:
	clrc
	rrf	(___ftpack@arg+2),f
	rrf	(___ftpack@arg+1),f
	rrf	(___ftpack@arg),f
	addlw	-1
	skipz
	goto	u2315

	line	74
	
l1537:	
	line	70
	movlw	low highword(0FF0000h)
	andwf	(___ftpack@arg+2),w
	btfss	status,2
	goto	u2321
	goto	u2320
u2321:
	goto	l2922
u2320:
	goto	l2930
	
l1539:	
	line	75
	goto	l2930
	
l1541:	
	line	76
	
l2928:	
	movlw	low(01h)
	subwf	(___ftpack@exp),f
	line	77
	movlw	01h
u2335:
	clrc
	rlf	(___ftpack@arg),f
	rlf	(___ftpack@arg+1),f
	rlf	(___ftpack@arg+2),f
	addlw	-1
	skipz
	goto	u2335
	goto	l2930
	line	78
	
l1540:	
	line	75
	
l2930:	
	btfss	(___ftpack@arg+1),(15)&7
	goto	u2341
	goto	u2340
u2341:
	goto	l2928
u2340:
	
l1542:	
	line	79
	btfsc	(___ftpack@exp),(0)&7
	goto	u2351
	goto	u2350
u2351:
	goto	l1543
u2350:
	line	80
	
l2932:	
	movlw	0FFh
	andwf	(___ftpack@arg),f
	movlw	07Fh
	andwf	(___ftpack@arg+1),f
	movlw	0FFh
	andwf	(___ftpack@arg+2),f
	
l1543:	
	line	81
	clrc
	rrf	(___ftpack@exp),f

	line	82
	
l2934:	
	movf	(___ftpack@exp),w
	movwf	((??___ftpack+0)+0)
	clrf	((??___ftpack+0)+0+1)
	clrf	((??___ftpack+0)+0+2)
	movlw	010h
u2365:
	clrc
	rlf	(??___ftpack+0)+0,f
	rlf	(??___ftpack+0)+1,f
	rlf	(??___ftpack+0)+2,f
u2360:
	addlw	-1
	skipz
	goto	u2365
	movf	0+(??___ftpack+0)+0,w
	iorwf	(___ftpack@arg),f
	movf	1+(??___ftpack+0)+0,w
	iorwf	(___ftpack@arg+1),f
	movf	2+(??___ftpack+0)+0,w
	iorwf	(___ftpack@arg+2),f
	line	83
	
l2936:	
	movf	(___ftpack@sign),w
	skipz
	goto	u2370
	goto	l1544
u2370:
	line	84
	
l2938:	
	bsf	(___ftpack@arg)+(23/8),(23)&7
	
l1544:	
	line	85
	line	86
	
l1533:	
	return
	opt stack 0
GLOBAL	__end_of___ftpack
	__end_of___ftpack:
;; =============== function ___ftpack ends ============

	signat	___ftpack,12411
	global	___wmul
psect	text452,local,class=CODE,delta=2
global __ptext452
__ptext452:

;; *************** function ___wmul *****************
;; Defined at:
;;		line 3 in file "C:\Program Files\HI-TECH Software\PICC\9.80\sources\wmul.c"
;; Parameters:    Size  Location     Type
;;  multiplier      2    0[COMMON] unsigned int 
;;  multiplicand    2    2[COMMON] unsigned int 
;; Auto vars:     Size  Location     Type
;;  product         2    4[COMMON] unsigned int 
;; Return value:  Size  Location     Type
;;                  2    0[COMMON] unsigned int 
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         4       0       0       0       0
;;      Locals:         2       0       0       0       0
;;      Temps:          0       0       0       0       0
;;      Totals:         6       0       0       0       0
;;Total ram usage:        6 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text452
	file	"C:\Program Files\HI-TECH Software\PICC\9.80\sources\wmul.c"
	line	3
	global	__size_of___wmul
	__size_of___wmul	equ	__end_of___wmul-___wmul
	
___wmul:	
	opt	stack 7
; Regs used in ___wmul: [wreg+status,2+status,0]
	line	4
	
l2898:	
	movlw	low(0)
	movwf	(___wmul@product)
	movlw	high(0)
	movwf	((___wmul@product))+1
	goto	l2900
	line	6
	
l1198:	
	line	7
	
l2900:	
	btfss	(___wmul@multiplier),(0)&7
	goto	u2231
	goto	u2230
u2231:
	goto	l1199
u2230:
	line	8
	
l2902:	
	movf	(___wmul@multiplicand),w
	addwf	(___wmul@product),f
	skipnc
	incf	(___wmul@product+1),f
	movf	(___wmul@multiplicand+1),w
	addwf	(___wmul@product+1),f
	
l1199:	
	line	9
	movlw	01h
	
u2245:
	clrc
	rlf	(___wmul@multiplicand),f
	rlf	(___wmul@multiplicand+1),f
	addlw	-1
	skipz
	goto	u2245
	line	10
	
l2904:	
	movlw	01h
	
u2255:
	clrc
	rrf	(___wmul@multiplier+1),f
	rrf	(___wmul@multiplier),f
	addlw	-1
	skipz
	goto	u2255
	line	11
	movf	((___wmul@multiplier+1)),w
	iorwf	((___wmul@multiplier)),w
	skipz
	goto	u2261
	goto	u2260
u2261:
	goto	l2900
u2260:
	goto	l2906
	
l1200:	
	line	12
	
l2906:	
	movf	(___wmul@product+1),w
	clrf	(?___wmul+1)
	addwf	(?___wmul+1)
	movf	(___wmul@product),w
	clrf	(?___wmul)
	addwf	(?___wmul)

	goto	l1201
	
l2908:	
	line	13
	
l1201:	
	return
	opt stack 0
GLOBAL	__end_of___wmul
	__end_of___wmul:
;; =============== function ___wmul ends ============

	signat	___wmul,8314
	global	_lookup
psect	text453,local,class=CODE,delta=2
global __ptext453
__ptext453:

;; *************** function _lookup *****************
;; Defined at:
;;		line 70 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\tempr.c"
;; Parameters:    Size  Location     Type
;;  no              2    0[COMMON] int 
;; Auto vars:     Size  Location     Type
;;  cha             1    3[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;                  1    wreg      unsigned char 
;; Registers used:
;;		wreg, fsr0l, fsr0h, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         2       0       0       0       0
;;      Locals:         1       0       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         4       0       0       0       0
;;Total ram usage:        4 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_disp
;; This function uses a non-reentrant model
;;
psect	text453
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\tempr.c"
	line	70
	global	__size_of_lookup
	__size_of_lookup	equ	__end_of_lookup-_lookup
	
_lookup:	
	opt	stack 6
; Regs used in _lookup: [wreg-fsr0h+status,2+status,0]
	line	72
	
l2866:	
;tempr.c: 71: char cha;
;tempr.c: 72: switch(no)
	goto	l2890
	line	74
;tempr.c: 73: {
;tempr.c: 74: case 0:
	
l589:	
	line	75
	
l2868:	
;tempr.c: 75: cha='0';
	movlw	(030h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	76
;tempr.c: 76: break;
	goto	l2892
	line	77
;tempr.c: 77: case 1:
	
l591:	
	line	78
	
l2870:	
;tempr.c: 78: cha='1';
	movlw	(031h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	79
;tempr.c: 79: break;
	goto	l2892
	line	80
;tempr.c: 80: case 2:
	
l592:	
	line	81
	
l2872:	
;tempr.c: 81: cha='2';
	movlw	(032h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	82
;tempr.c: 82: break;
	goto	l2892
	line	83
;tempr.c: 83: case 3:
	
l593:	
	line	84
	
l2874:	
;tempr.c: 84: cha='3';
	movlw	(033h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	85
;tempr.c: 85: break;
	goto	l2892
	line	86
;tempr.c: 86: case 4:
	
l594:	
	line	87
	
l2876:	
;tempr.c: 87: cha='4';
	movlw	(034h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	88
;tempr.c: 88: break;
	goto	l2892
	line	89
;tempr.c: 89: case 5:
	
l595:	
	line	90
	
l2878:	
;tempr.c: 90: cha='5';
	movlw	(035h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	91
;tempr.c: 91: break;
	goto	l2892
	line	92
;tempr.c: 92: case 6:
	
l596:	
	line	93
	
l2880:	
;tempr.c: 93: cha='6';
	movlw	(036h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	94
;tempr.c: 94: break;
	goto	l2892
	line	95
;tempr.c: 95: case 7:
	
l597:	
	line	96
	
l2882:	
;tempr.c: 96: cha='7';
	movlw	(037h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	97
;tempr.c: 97: break;
	goto	l2892
	line	98
;tempr.c: 98: case 8:
	
l598:	
	line	99
	
l2884:	
;tempr.c: 99: cha='8';
	movlw	(038h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	100
;tempr.c: 100: break;
	goto	l2892
	line	101
;tempr.c: 101: case 9:
	
l599:	
	line	102
	
l2886:	
;tempr.c: 102: cha='9';
	movlw	(039h)
	movwf	(??_lookup+0)+0
	movf	(??_lookup+0)+0,w
	movwf	(lookup@cha)
	line	103
;tempr.c: 103: break;
	goto	l2892
	line	104
	
l2888:	
;tempr.c: 104: }
	goto	l2892
	line	72
	
l588:	
	
l2890:	
	; Switch on 2 bytes has been partitioned into a top level switch of size 1, and 1 sub-switches
; Switch size 1, requested type "space"
; Number of cases is 1, Range of values is 0 to 0
; switch strategies available:
; Name         Bytes Cycles
; simple_byte     4     3 (average)
; direct_byte    22    19 (fixed)
;	Chosen strategy is simple_byte

	movf (lookup@no+1),w
	xorlw	0^0	; case 0
	skipnz
	goto	l3478
	goto	l2892
	
l3478:	
; Switch size 1, requested type "space"
; Number of cases is 10, Range of values is 0 to 9
; switch strategies available:
; Name         Bytes Cycles
; simple_byte    31    16 (average)
; direct_byte    49    19 (fixed)
;	Chosen strategy is simple_byte

	movf (lookup@no),w
	xorlw	0^0	; case 0
	skipnz
	goto	l2868
	xorlw	1^0	; case 1
	skipnz
	goto	l2870
	xorlw	2^1	; case 2
	skipnz
	goto	l2872
	xorlw	3^2	; case 3
	skipnz
	goto	l2874
	xorlw	4^3	; case 4
	skipnz
	goto	l2876
	xorlw	5^4	; case 5
	skipnz
	goto	l2878
	xorlw	6^5	; case 6
	skipnz
	goto	l2880
	xorlw	7^6	; case 7
	skipnz
	goto	l2882
	xorlw	8^7	; case 8
	skipnz
	goto	l2884
	xorlw	9^8	; case 9
	skipnz
	goto	l2886
	goto	l2892

	line	104
	
l590:	
	line	105
	
l2892:	
;tempr.c: 105: return cha;
	movf	(lookup@cha),w
	goto	l600
	
l2894:	
	line	106
	
l600:	
	return
	opt stack 0
GLOBAL	__end_of_lookup
	__end_of_lookup:
;; =============== function _lookup ends ============

	signat	_lookup,4217
	global	_DelayMs
psect	text454,local,class=CODE,delta=2
global __ptext454
__ptext454:

;; *************** function _DelayMs *****************
;; Defined at:
;;		line 12 in file "C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\delay.c"
;; Parameters:    Size  Location     Type
;;  cnt             1    wreg     unsigned char 
;; Auto vars:     Size  Location     Type
;;  cnt             1    1[COMMON] unsigned char 
;;  _dcnt           1    3[COMMON] unsigned char 
;;  i               1    2[COMMON] unsigned char 
;; Return value:  Size  Location     Type
;;		None               void
;; Registers used:
;;		wreg, status,2, status,0
;; Tracked objects:
;;		On entry : 0/0
;;		On exit  : 0/0
;;		Unchanged: 0/0
;; Data sizes:     COMMON   BANK0   BANK1   BANK3   BANK2
;;      Params:         0       0       0       0       0
;;      Locals:         3       0       0       0       0
;;      Temps:          1       0       0       0       0
;;      Totals:         4       0       0       0       0
;;Total ram usage:        4 bytes
;; Hardware stack levels used:    1
;; This function calls:
;;		Nothing
;; This function is called by:
;;		_main
;; This function uses a non-reentrant model
;;
psect	text454
	file	"C:\Documents and Settings\Administrator\Desktop\PIC-TEMP\tempr\delay.c"
	line	12
	global	__size_of_DelayMs
	__size_of_DelayMs	equ	__end_of_DelayMs-_DelayMs
	
_DelayMs:	
	opt	stack 7
; Regs used in _DelayMs: [wreg+status,2+status,0]
;DelayMs@cnt stored from wreg
	movwf	(DelayMs@cnt)
	line	21
;delay.c: 20: unsigned char i;
;delay.c: 21: do {
	
l1182:	
	line	22
	
l2858:	
;delay.c: 22: i = 4;
	movlw	(04h)
	movwf	(??_DelayMs+0)+0
	movf	(??_DelayMs+0)+0,w
	movwf	(DelayMs@i)
	line	23
;delay.c: 23: do {
	
l1183:	
	line	24
;delay.c: 24: { unsigned char _dcnt; _dcnt = (250)/((12*1000L)/(4*1000L))|1; while(--_dcnt != 0) continue; };
	movlw	(053h)
	movwf	(??_DelayMs+0)+0
	movf	(??_DelayMs+0)+0,w
	movwf	(DelayMs@_dcnt)
	goto	l2860
	
l1185:	
	goto	l2860
	
l1184:	
	
l2860:	
	movlw	low(01h)
	subwf	(DelayMs@_dcnt),f
	btfss	status,2
	goto	u2201
	goto	u2200
u2201:
	goto	l2860
u2200:
	goto	l2862
	
l1186:	
	line	25
	
l2862:	
;delay.c: 25: } while(--i);
	movlw	low(01h)
	subwf	(DelayMs@i),f
	btfss	status,2
	goto	u2211
	goto	u2210
u2211:
	goto	l1183
u2210:
	goto	l2864
	
l1187:	
	line	26
	
l2864:	
;delay.c: 26: } while(--cnt);
	movlw	low(01h)
	subwf	(DelayMs@cnt),f
	btfss	status,2
	goto	u2221
	goto	u2220
u2221:
	goto	l1182
u2220:
	goto	l1189
	
l1188:	
	line	28
	
l1189:	
	return
	opt stack 0
GLOBAL	__end_of_DelayMs
	__end_of_DelayMs:
;; =============== function _DelayMs ends ============

	signat	_DelayMs,4216
psect	text455,local,class=CODE,delta=2
global __ptext455
__ptext455:
	global	btemp
	btemp set 07Eh

	DABS	1,126,2	;btemp
	global	wtemp0
	wtemp0 set btemp
	end
