/**
* ile Copyright (C) 1998 ELAU Dillberg 12-16 D-97828 Marktheidenfeld
*       Definition der Firmware Version
*
* uthor autom. generiert von PacDrive-Konfigurator
*
* \version PacDrive-Konfigurator
*/

#ifndef __INC_PacConfigVersionHPP
#define __INC_PacConfigVersionHPP

// SCOPE ----------------------------------------------------------------------
#ifndef SCOPE_PacConfigVersionHPP
   #define SCOPE_PacConfigVersionHPP   extern
#else
   #define SCOPE_PacConfigVersionHPP
#endif

const char FW_VERSION_3S_STRING[9]  = "1.64.4.3";

const UINT8 FW_VERSION_MAJOR  = 1;
const UINT8 FW_VERSION_MINOR  = 64;
const UINT8 FW_VERSION_BUGFIX = 4;
const UINT8 FW_VERSION_BUILD  = 5;

const UINT32 FW_VERSION_UINT32 = 0x1400403;

const char FW_VERSION_STRING[13]  = "V01.64.04.03";
const int FW_VERSION_STRING_LENGTH  = 13;


const char FW_VERSION_STRING_USER[8]  = "V1.64.4";
const int FW_VERSION_STRING_USER_LENGTH  = 8;


const char FW_VERSION_STRING_COMPLETE[10]  = "V1.64.4.3";
const int FW_VERSION_STRING_COMPLETE_LENGTH  = 10;

#ifdef FILE_PacDriveCPP
   int g_lMax4VersionIdStart016404End;
   int g_lMax4Version2IdStart01_64_04_03End;
#endif

/**
* \}
*/
#endif //__INC_PacConfigVersionHPP
