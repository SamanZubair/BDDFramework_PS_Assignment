package utilities;

import java.util.UUID;

public class DataGenerator {

    public static String generateRandomName(String base) {
        return base + "_" + UUID.randomUUID().toString().substring(0, 6);
    }

    public static String generateRandomEmail(String basePrefix, String domain) {
        return basePrefix + "_" + UUID.randomUUID().toString().substring(0, 6) + "@" + domain;
    }

    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

}
