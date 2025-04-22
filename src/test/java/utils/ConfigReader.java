package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ConfigReader {

	/*public static Properties properties = new Properties();

	public static void loadConfig() throws IOException {
		 InputStream inputStream = ConfigReader.class.getClassLoader()
				.getResourceAsStream("config/config.properties"); {
			if (inputStream == null)
				throw new IOException("Config file not found");
			}
		
			properties.load(inputStream);
		}  */
	
	private Properties properties;

	private final String propertyFilePath = "src//test//resources//config//config.properties";

	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at " + propertyFilePath);
		}

	}
	

	public  String getBrowserType() {
		
			return properties.getProperty("browser");
		
	}

	public  String getUrl() {
		
				return properties.getProperty("Url");
			
	}

	public  String getUserName() {
		return properties.getProperty("username");
	}

	public  String getPassword() {
		return properties.getProperty("password");
	}

	public  String getUrlHome() {
		return properties.getProperty("urlHome");
		
		
	}
	
	public  String getUrlTree() {
		return properties.getProperty("urlTree");
		
		
	}

/*	public static void initializeDriverFromConfig() throws Exception {
		loadConfig();
		String browser = getBrowserType();
		DriversBase.initializeDriver();
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
	}   */

}
