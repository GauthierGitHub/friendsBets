package utils;

import java.util.Properties;

public class ConfigurationUtil {
    private static final Properties properties;
    
    static {
        try {
        	properties = new Properties();
        	properties.load(ConfigurationUtil.class.getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (Throwable ex) {
            System.err.println("Configuration loading failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Properties getProperties() {
        return properties;
    }
    
    public static String getProperty(String name) {
    	return properties.getProperty(name);
    }
}