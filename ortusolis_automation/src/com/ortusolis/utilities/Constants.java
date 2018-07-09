package com.ortusolis.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	public static String sCustPortType_Generic = "Generic";
	public static String sCustPortType_Customized = "Customized";
	public static String sCustPortType_Templeted = "Templeted";
	public static String sAlmostThere = "YOU’RE ALMOST THERE!";
	public static String sExtentReportFormatSuite = "suite";
	public static String sExtentReportFormatMethod = "method";
	public static String sRDRole = "RD";
	public static String sSuperUser = "Super User";
	public static String sRDAdRole = "RDAdmin";
	public static String sLMRole = "LM";
	public static String sLMAdRole = "LMAdmin";
	public static String sBOMRole = "BOM";
	public static String sBOMAdRole = "BOMAdmin";
	public static String sProcRole = "Proc";
	public static String sProcAdRole = "ProcAdmin";
	public static String sSMRole = "SM";
	public static String sSMAdRole = "SMAdmin";
	public static String sPJARole = "PJA";
	public static String sPJAAdRole = "PJAAdmin";
	
	// Generating new Damler ID for LM Flow and storing this in sDamlerIDForLMFlow
	public static String sDaimlerIDForLMFlow="";
	public static String sDaimlerIDForBOMFlow="";
}
