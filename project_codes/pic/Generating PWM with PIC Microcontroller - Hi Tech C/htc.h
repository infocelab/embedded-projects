#ifndef _HTC_H_
#define _HTC_H_


/* common definitions */

#define	___mkstr1(x)	#x
#define	___mkstr(x)	___mkstr1(x)



/* HI-TECH PICC / PICC-Lite compiler */
#if	defined(__PICC__) || defined(__PICCLITE__)
#include <pic.h>
#endif

/* HI-TECH PICC-18 compiler */
#if	defined(__PICC18__)
#include <pic18.h>
#endif

/* HI-TECH dsPICC compiler */
#if	defined(__DSPICC__)
#include <dspic.h>
#endif

/* HI-TECH HTKC compiler for Holtek MCUs */
#if	defined(_HTKC_)
#include <htk.h>
#endif

/* HI-TECH C for 8051 */
#if	defined(__HTC8051__)
#include <8051.h>
#endif

/* HI-TECH C for MSP430 */
#if	defined(__MSP430C__)
#include <msp430.h>
#endif

/* HI-TECH C for ARM */
#if	defined(__ARMC__)
#include <arm.h>
#endif

#endif
