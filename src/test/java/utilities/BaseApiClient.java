package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static readers.ConfigReader.getProperty;

public class BaseApiClient {

    private final String TOKEN = getProperty("token");       // Loaded from config.properties

    public RequestSpecification getBaseRequest() {
        // Could move to config file
        String BASE_URI = "https://gorest.co.in";
        return given()
                .baseUri(BASE_URI)
                .header("Authorization", TOKEN)
                .header("Content-Type", "application/json")
                .log().all();
    }

    public Response post(String endpoint, Object body) {
        return getBaseRequest().body(body).post(endpoint);
    }

    public Response get(String endpoint) {
        return getBaseRequest().get(endpoint);
    }

    public Response put(String endpoint, Object body) {
        return getBaseRequest().body(body).put(endpoint);
    }

    public Response delete(String endpoint) {
        return getBaseRequest().delete(endpoint);
    }
}
