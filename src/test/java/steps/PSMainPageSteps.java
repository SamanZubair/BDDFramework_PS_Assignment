package steps;

import io.cucumber.java.en.*;
import models.ContactFormData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PSMainPage;
import readers.JsonReader;
import utilities.FilePaths;
import utilities.SeleniumHelper;
import utilities.TestContextClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PSMainPageSteps {

    TestContextClass context;
    PSMainPage psMainPage;
    SeleniumHelper seleniumHelper;

    public PSMainPageSteps(TestContextClass context) {
        this.context = context;
        this.psMainPage = context.getPsMainPage();
        this.seleniumHelper = context.getSeleniumHelper();
    }

    @Given("Publicis Sapient mainpage is opened")
    public void publicisSapientMainpageIsOpened() {
    }

    @When("Scroll down to the {string} section")
    public void scroll_down_to_the_section(String section) {
        psMainPage.scrollToContactForm();
    }

    @When("Fill in the contact form with valid details")
    public void fill_in_the_contact_form_with_valid_details() {
        ContactFormData data = JsonReader.readJson(FilePaths.CONTACT_FORM_DATA, ContactFormData.class);
        assert data != null;
        psMainPage.fillForm(data);
    }

    @When("Submit the form")
    public void submit_the_form() {
        psMainPage.submitForm();
    }

    @Then("Should see a success message after form submission")
    public void should_see_a_success_message_after_form_submission() {
        String actualMessage = psMainPage.getSuccessMessage();
        String expectedMessage = "Thank you for taking the first step. Our team will be in touch soon.";
        Assert.assertEquals(actualMessage, expectedMessage, "Success message doesn't match!");
    }

    @When("Scroll down to the footer section")
    public void scrollDownToTheFooterSection() {
        psMainPage.scrollToFooterSection();
    }

    @Then("Should see {int} links in the Contact Us footer section")
    public void shouldSeeLinksInTheContactUsFooterSection(int count) {
        List<WebElement> elements = psMainPage.getFooterListItems();
        Assert.assertEquals(elements.size(), count);

        List<String> expected = Arrays.asList(
                "Accessibility", "Careers", "Client Stories", "Company Overview", "Cookie Policy", "Cookie Settings",
                "DBT GPT", "Industries", "Insights", "Legal", "Locations", "Media", "Privacy Policy",
                "Sitemap", "Solutions", "SPEED Approach", "Subscription Center", "Terms"
        );

        List<String> actual = new ArrayList<>();
        for (WebElement item : elements) {
            String text = item.getText().trim();
            if (text.contains("\n")) text = text.split("\n")[0];
            actual.add(text.replace("Opens in a new tab", "").trim());
        }

        Assert.assertEquals(actual, expected);
    }
}
