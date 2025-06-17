package utilities;

import java.io.File;

public class FilePaths {
    private static final String BASE_PATH = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testdata";
    public static final String JSON_PATH = BASE_PATH + File.separator + "json";
    public static final String CONTACT_FORM_DATA = JSON_PATH + File.separator + "contactFormData.json";
    // Add in FilePaths.java
    public static final String API_PAYLOADS_PATH = JSON_PATH + File.separator + "api";
    public static final String CREATE_USER_PAYLOAD = API_PAYLOADS_PATH + File.separator + "CreateUser.json";

    // Report paths
    public static final String REPORT_FOLDER = "target" + File.separator + "SparkReport";
    public static final String EXTENT_REPORT_FILE = REPORT_FOLDER + File.separator + "extent-report.html";

    // Config file path
    public static final String CONFIG_PATH = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config";
    public static final String CONFIG_PROPERTIES_FILE = CONFIG_PATH + File.separator + "config.properties";

    // Feature files path
    public static final String FEATURES_PATH = "src/test/resources/Features";

}
