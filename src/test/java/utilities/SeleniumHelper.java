package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumHelper {
    WebDriver driver;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void sendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickButton(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void waitForElementToAppear(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getTextWhenVisible(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }

    public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public void acceptCookiesIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
            }
        } catch (Exception e) {

        }
    }
}
