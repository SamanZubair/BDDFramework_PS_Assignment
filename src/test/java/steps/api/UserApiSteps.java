package steps.api;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.api.UserData;
import readers.JsonReader;
import utilities.BaseApiClient;
import utilities.DataGenerator;
import utilities.FilePaths;
import utilities.TestContextClass;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;

public class UserApiSteps {

    private static final Logger logger = LogManager.getLogger(UserApiSteps.class);

    TestContextClass context;
    UserData userData;
    private final BaseApiClient apiClient;

    public UserApiSteps(TestContextClass context) {
        this.context = context;
        this.apiClient = new BaseApiClient();
    }

    @Given("I have a valid GoRest bearer token")
    public void i_have_a_valid_go_rest_bearer_token() {

    }


    @Given("I load payload from file")
    public void i_load_payload_from_file() {
        userData = JsonReader.readJson(FilePaths.CREATE_USER_PAYLOAD, UserData.class);

        if (userData != null) {

            String baseName = userData.getName() != null ? userData.getName() : "Test User";
            String baseEmail = userData.getEmail() != null ? userData.getEmail() : "test.user@example.com";

            String[] emailParts = baseEmail.split("@");
            String emailPrefix = emailParts[0];
            String emailDomain = emailParts.length > 1 ? emailParts[1] : "example.com";

            userData.setName(DataGenerator.generateRandomName(baseName));
            userData.setEmail(DataGenerator.generateRandomEmail(emailPrefix, emailDomain));
        } else {
            logger.error("Failed to load user data from JSON.");
            throw new RuntimeException("❌ Failed to load user data from JSON.");
        }
    }

    @When("I send a POST request to {string}")
    public void i_send_a_post_request_to(String endpoint) {
        Response response = apiClient.post(endpoint, userData);
        context.setResponse(response);
    }
    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer expectedStatusCode) {
        Response response = context.getResponse();
        assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");
    }
    @Then("verify the response")
    public void verify_the_response() {
        Response response = context.getResponse();

        // Deserialize response to UserData
        UserData responseUser = response.as(UserData.class);

        // Validate values match the payload
        assertEquals(responseUser.getName(), userData.getName(), "Name mismatch");
        assertEquals(responseUser.getEmail(), userData.getEmail(), "Email mismatch");
        assertEquals(responseUser.getGender(), userData.getGender(), "Gender mismatch");
        assertEquals(responseUser.getStatus(), userData.getStatus(), "Status mismatch");

    }

    @And("the response should match the JSON schema {string}")
    public void theResponseShouldMatchTheJSONSchema(String schemaFile) {
        Response response = context.getResponse();
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("Schema/" + schemaFile));
    }
}
