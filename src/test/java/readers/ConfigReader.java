package readers;

import utilities.FilePaths;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static String getProperty(String key) {
        if (properties == null) {
            try {
                FileInputStream input = new FileInputStream(FilePaths.CONFIG_PROPERTIES_FILE);
                properties = new Properties();
                properties.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Could not load config.properties file.");
            }
        }
        return properties.getProperty(key);
    }
}
