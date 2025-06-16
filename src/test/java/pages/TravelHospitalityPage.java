package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TravelHospitalityPage {

    WebDriver driver;
    SeleniumHelper seleniumHelper;
    private static final Logger logger = LogManager.getLogger(TravelHospitalityPage.class);


    @FindBy(xpath = "//ul[@class='menu-l1']/li/a[normalize-space()='What We Do']")
    private WebElement navMenu;

    @FindBy(xpath = "//ul[@class='level3-list']/li/a/span//span/span[normalize-space()='Travel & Hospitality']")
    private WebElement travelAndHosptialityMenu;

    @FindBy(xpath = "//section[@id='sectors']//div[@class='accordion-item']//h3")
    private List<WebElement> sectorHeadings;

    @FindBy(xpath = "//section[@id='sectors']")
    private WebElement sector;


    public TravelHospitalityPage(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public String navigateToTavelPage(){
        seleniumHelper.clickButton(navMenu);
        seleniumHelper.clickButton(travelAndHosptialityMenu);
         return seleniumHelper.getPageTitle();
    }

    public List<String> getTravelFacilityHeaders() {
        List<String> headers = new ArrayList<>();

        for (WebElement item : sectorHeadings) {
            try {
                String sectorValue = item.getText().trim();
                headers.add(sectorValue);
                logger.info("List sector value "+sectorValue);
            } catch (Exception e) {
                logger.error("Error "+e.getMessage(),e);
            }
        }
        return headers;
    }

    public void scrollToTravelSectors() {
        seleniumHelper.scrollToElement(sector);
    }

}
