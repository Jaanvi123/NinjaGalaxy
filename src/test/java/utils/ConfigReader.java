package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import driverManager.DriverBase;

public class ConfigReader 
{
	private static Properties properties = new Properties();

	public static void loadConfig() throws IOException {
		try (InputStream inputStream = ConfigReader.class.getClassLoader()
				.getResourceAsStream("config/config.properties")) {
			if (inputStream == null)
				throw new IOException("Config file not found");
			properties.load(inputStream);
		}
	}

	public static String getBrowserType() {
		return properties.getProperty("browser", "chrome").toLowerCase();
	}

	public static String getUrl() {
		return properties.getProperty("url");
	}

	public static String getUserName() {
		return properties.getProperty("username");
	}

	public static String getPassword() {
		return properties.getProperty("password");
	}

	public static String getUrlHome() {
		return properties.getProperty("urlHome");
	}

	public static void initializeDriverFromConfig() throws Exception {
		loadConfig();
		String browser = getBrowserType();
		DriverBase.initializeBrowser(browser);
	}

	public static Properties initializeProp() {
		Properties prop = new Properties();
		File profile = new File(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");

		try (FileInputStream fis = new FileInputStream(profile)) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
