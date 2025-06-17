// utilities/TestContext.java
package utilities;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import models.api.UserData;
import org.openqa.selenium.WebDriver;
import pages.PSMainPage;
import pages.TravelHospitalityPage;

public class TestContextClass {

    // UI Fields
    @Getter
    private WebDriver driver;
    @Getter
    private SeleniumHelper seleniumHelper;
    @Getter
    private PSMainPage psMainPage;
    @Getter
    private TravelHospitalityPage travelHospitalityPage;

    // --- API Methods ---
    //API Fields
    @Setter
    @Getter
    private Response response;
    private UserData userData;

    public void initialize() {
        BaseClass base = new BaseClass();
        driver = base.launchBrowser();
        seleniumHelper = new SeleniumHelper(driver);
        psMainPage = new PSMainPage(driver);
        travelHospitalityPage = new TravelHospitalityPage(driver);
    }

    public void clear() {
        driver = null;
        seleniumHelper = null;
        psMainPage = null;
    }

    public UserData userPayload() {
        return userData;
    }

    public void setUserPayload(UserData userPayload) {
        this.userData = userPayload;
    }
}
