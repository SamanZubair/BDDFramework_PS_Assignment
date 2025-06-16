// utilities/BaseClass.java
package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import readers.ConfigReader;

public class BaseClass {

    public WebDriver launchBrowser() {
        WebDriver driver;
        String browser = ConfigReader.getProperty("browser");
        String baseURL = ConfigReader.getProperty("baseURL");

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        new SeleniumHelper(driver).acceptCookiesIfPresent();

        return driver;
    }

    public static void quitBrowser() {

    }
}
