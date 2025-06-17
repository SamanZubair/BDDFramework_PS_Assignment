package readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key);
    }

    private static void loadProperties() {
        String env = System.getProperty("env", "qa");
        String fileName = "config/config_" + env + ".properties";

        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("Could not find properties file: " + fileName);
            }
            properties = new Properties();
            properties.load(input);
            System.out.println("Loaded config for environment: " + env);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + fileName, e);
        }
    }
}
