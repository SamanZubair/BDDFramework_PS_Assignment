package readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static <T> T readJson(String filePath, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
