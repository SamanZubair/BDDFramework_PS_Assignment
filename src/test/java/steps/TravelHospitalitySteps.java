package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PSMainPage;
import pages.TravelHospitalityPage;
import utilities.SeleniumHelper;
import utilities.TestContextClass;
import java.util.Arrays;
import java.util.List;

public class TravelHospitalitySteps {

    TestContextClass context;
    PSMainPage psMainPage;
    SeleniumHelper seleniumHelper;
    TravelHospitalityPage travelHospitalityPage;

    public TravelHospitalitySteps(TestContextClass context) {
        this.context = context;
        this.psMainPage = context.getPsMainPage();
        this.travelHospitalityPage = context.getTravelHospitalityPage();
        this.seleniumHelper = context.getSeleniumHelper();
    }

    @When("I navigate to the Travel and Hospitality industry page")
    public void i_navigate_to_the_travel_and_hospitality_industry_page() {
        String getActualPageTitle = travelHospitalityPage.navigateToTavelPage();
        Assert.assertTrue(getActualPageTitle.contains("Travel & Hospitality"),
                "Page title does not contain expected text. Actual title: " + getActualPageTitle);
    }

    @Then("I should see the following headers:")
    public void i_should_see_the_following_headers() {
        List<String> actualHeaders = travelHospitalityPage.getTravelFacilityHeaders();
        List<String> expectedHeaders = Arrays.asList(
                "Food & dining",
                "Airlines & airports",
                "Hotels, casinos & leisure destinations",
                "Cruise lines",
                "Travel agencies & tour operators"

        );
        Assert.assertEquals(actualHeaders, expectedHeaders);
    }

    @When("Scroll to travelSectors")
    public void scroll_to_travel_sectors() {
        travelHospitalityPage.scrollToTravelSectors();
    }
}
