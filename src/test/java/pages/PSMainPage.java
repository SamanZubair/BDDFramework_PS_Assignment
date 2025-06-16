package pages;

import models.ContactFormData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;

import java.util.List;

public class PSMainPage {
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    private static final Logger logger = LogManager.getLogger(PSMainPage.class);

    @FindBy(xpath = "//form[@action='/apps/ps-rebrand/ps-footer-form']")
    private WebElement contactForm;

    @FindBy(xpath = "//div[@class='footer-nav-items footer-links']//ul/li")
    private List<WebElement>  footerSectionList;

    @FindBy(xpath = "//div[@class='footer-nav-items footer-links']")
    private WebElement  footerSection;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "job_title")
    private WebElement jobField;

    @FindBy(id = "comments")
    private WebElement messageField;

    @FindBy(id = "country")
    private WebElement countryDropDown;

    @FindBy(xpath = "//BUTTON[@TYPE='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h2[@role='alert']")
    private WebElement successMsg;

    public PSMainPage(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void scrollToContactForm() {
        seleniumHelper.scrollToElement(contactForm);
    }

    public void fillForm(ContactFormData contactFormData) {
        seleniumHelper.sendKeys(firstNameField, contactFormData.getFirstName());
        seleniumHelper.sendKeys(lastNameField, contactFormData.getLastName());
        seleniumHelper.sendKeys(emailField, contactFormData.getEmail());
        seleniumHelper.sendKeys(companyField, contactFormData.getCompany());
        seleniumHelper.sendKeys(jobField,contactFormData.getJobTitle() );
        seleniumHelper.sendKeys(messageField, contactFormData.getMessage());
        seleniumHelper.selectDropdownByVisibleText(countryDropDown,contactFormData.getCountry());
    }

    public void submitForm() {
        seleniumHelper.clickButton(submitButton);
        seleniumHelper.waitForElementToAppear(successMsg, 10);
    }

    public String getSuccessMessage() {
        return seleniumHelper.getTextWhenVisible(successMsg, 15);
    }

    public void scrollToFooterSection() {
        seleniumHelper.scrollToElement(footerSection);
    }

    public List<WebElement> getFooterListItems() {
        for (WebElement item : footerSectionList) {
            try {
                WebElement a = item.findElement(By.tagName("a"));
                logger.info("Link text"+a.getText().trim());
            } catch (Exception e) {
                logger.error("li without <a>: "+e.getMessage());
            }
        }
        return footerSectionList;
    }

}
