// utilities/TestContext.java
package utilities;

import org.openqa.selenium.WebDriver;
import pages.PSMainPage;
import pages.TravelHospitalityPage;

public class TestContextClass {

    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private PSMainPage psMainPage;
    private TravelHospitalityPage travelHospitalityPage;

    public void initialize() {
        BaseClass base = new BaseClass();
        driver = base.launchBrowser();
        seleniumHelper = new SeleniumHelper(driver);
        psMainPage = new PSMainPage(driver);
        travelHospitalityPage = new TravelHospitalityPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public SeleniumHelper getSeleniumHelper() {
        return seleniumHelper;
    }

    public PSMainPage getPsMainPage() {
        return psMainPage;
    }

    public TravelHospitalityPage getTravelHospitalityPage() {
        return travelHospitalityPage;
    }

    public void clear() {
        driver = null;
        seleniumHelper = null;
        psMainPage = null;
    }
}
