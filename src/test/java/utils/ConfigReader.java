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

	public static Properties properties = new Properties();
	private static final String propertyFilePath = "src//test//resources//config//config.properties";
	
	public static void loadConfig() throws IOException {
		 InputStream inputStream = ConfigReader.class.getClassLoader()
				.getResourceAsStream("config/config.properties"); {
			if (inputStream == null)
				throw new IOException("Config file not found");
			}
		
			properties.load(inputStream);
		}  
	
	static {
        try (FileInputStream fileInput = new FileInputStream(propertyFilePath)) {
            properties.load(fileInput);
        } catch (IOException e) {
            throw new RuntimeException("Config.properties file not found at: " + propertyFilePath);
        }
    }
	
	
	// Method to retrieve values from properties file
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

	public  String getBrowserType() {
		return properties.getProperty("browser");
		
	}
	public  static String getUrl() {
			return properties.getProperty("Url");
		
	}

	public static  String getUserName() {
		return properties.getProperty("username");
	}

	public static  String getPassword() {
		return properties.getProperty("password");
	}

	public static String getUrlHome() {
		return properties.getProperty("urlHome");
		
		
	}
	
	public  String getUrlTree() {
		return properties.getProperty("urlTree");
		
		
	}



}
