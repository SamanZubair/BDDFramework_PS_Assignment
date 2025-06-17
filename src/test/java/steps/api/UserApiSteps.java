package steps.api;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import models.api.UserData;
import readers.JsonReader;
import utilities.BaseApiClient;
import utilities.FilePaths;
import utilities.TestContextClass;

import static org.testng.Assert.assertEquals;

public class UserApiSteps {

    TestContextClass context;
    UserData userData;
    private final BaseApiClient apiClient;

    public UserApiSteps(TestContextClass context) {
        this.context = context;
        this.apiClient = new BaseApiClient();
    }

    @Given("I have a valid GoRest bearer token")
    public void i_have_a_valid_go_rest_bearer_token() {
        System.out.println("1111");
    }
    @Given("I load payload from file")
    public void i_load_payload_from_file() {
        System.out.println("1111");
        userData = JsonReader.readJson(FilePaths.CREATE_USER_PAYLOAD, UserData.class);
    }
    @When("I send a POST request to {string}")
    public void i_send_a_post_request_to(String endpoint) {
        System.out.println("1111");
        Response response = apiClient.post(endpoint, userData);
        context.setResponse(response);
    }
    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer int1) {
       // assertEquals(context.getResponse().getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");
    }
    @Then("verify the response")
    public void verify_the_response() {
        System.out.println("1111");
    }
}
