package com.ortusolis.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.io.Zip;
import org.slf4j.*;
import org.testng.annotations.BeforeMethod;

public class CommonUtilities extends TestBase{
		
		static Properties props = new Properties();
		static FileInputStream fileIn = null;
		final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());

	
	public void loadPropertyFiles(String PropertiesFilePath) throws Exception {

			log.info("Current dir using System:" + PropertiesFilePath);
			fileIn = new FileInputStream(PropertiesFilePath);
			props.load(fileIn);
			System.getProperties().putAll(props);
			// log.info(util.props);
	}

	public String[] ufSplitMe(String sReadyTosplit) {
	
		String[] sArrAfterSplit = sReadyTosplit.split("::");
		if(sArrAfterSplit[0].contains("model"))
			sArrAfterSplit[0]="model";
		else if(sArrAfterSplit[0].contains("button"))
			sArrAfterSplit[0]="button";
		
		return sArrAfterSplit;
	}


	public String getTypeOfPortal(String sURL) {
	
		String sPortalType=null;
		if(sURL.toLowerCase().contains("blimpi"))
			sPortalType=Constants.sCustPortType_Generic;
		else if(sURL.toLowerCase().contains("coldstone"))
			sPortalType=Constants.sCustPortType_Customized;
		else if(sURL.toLowerCase().contains("jamesconey"))
			sPortalType=Constants.sCustPortType_Templeted;
		else
			log.error("portal type not found. Script is going to fail");
		return sPortalType;
	}
	
	public void deleteScreenShotDirectory() {
		String destDir = "screenshots";
		String SRC_FOLDER = System.getProperty("user.dir") + "/test-output/" + destDir;
		File directory = new File(SRC_FOLDER);
		if (directory.exists()) {
			try {
				delete(directory);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		new File(System.getProperty("user.dir") + "/test-output/" + destDir).mkdirs();

	}

	public void delete(File file) throws IOException {

		if (file.isDirectory()) {
			// directory is empty, then delete it
			if (file.list().length == 0) {
				file.delete();
				log.info("Directory is deleted : " + file.getAbsolutePath());

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);
					// recursive delete
					delete(fileDelete);
				}
				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					log.info("Directory is deleted : " + file.getAbsolutePath());
				}
			}

		} else {
			// if file, then delete it
			file.delete();
			log.info("File is deleted : " + file.getAbsolutePath());
		}
	}
	
	public void ufdeletescreenshots() throws IOException {
		String destdir = "screenshots";
		String screenpath = System.getProperty("user.dir") + "/test-output/" + destdir;
		File screenshotfolder = new File(screenpath);

		if (screenshotfolder.exists()) {
			try {
				FileUtils.cleanDirectory(screenshotfolder);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		new File(System.getProperty("user.dir") + "/test-output/" + destdir).mkdirs();

	}

	@SuppressWarnings("static-access")
	public void ufzipscreenshots() {
		Zip zip = new Zip();

		try {

			File inputfolder = new File(System.getProperty("user.dir") + "/test-output/screenshots");

			File output = new File(System.getProperty("user.dir") + "/test-output/screenshots.zip");
			if (output.exists()) {
				output.delete();
			}

			zip.zip(inputfolder);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public JSONObject ReadJsonFileGetJsonObject(String sPathOfJson) throws Exception {
		log.info(sPathOfJson);
		String sJsonContent = readfileReturnInString(sPathOfJson);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = new JSONObject(sJsonContent.trim());
		} catch (Exception pj) {
			try {
				jsonObject = new JSONObject(sPathOfJson.substring(sPathOfJson.indexOf('{')));
			} catch (Exception pja) {
				
				log.error("Unable to parse " + pj);
			}
		}

		return jsonObject;
	}
	public String readfileReturnInString(String sPathOfJson) throws IOException {

		byte[] encoded = Files.readAllBytes(Paths.get(sPathOfJson));
		return new String(encoded, StandardCharsets.UTF_8);

	}

	public String setEnvironment(String sURL) throws Exception {
		return sURL.replace("spendgoenv", oJsConfig.getString("environment"));
	}

	public String generateUnixTimeStamp() {
		long unixTime = System.currentTimeMillis();
		return TrimmingToTenLetters(String.valueOf(unixTime));
	}

	private String TrimmingToTenLetters(String valueOf) {
		String sReadyToUse =valueOf.substring((valueOf.length())-10);
		log.info("Actual Time Stamp: "+valueOf+"\nConverted Time Stamp: "+sReadyToUse);
		return sReadyToUse;
	}
	
}
