package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public String getCurrentURL() {

        return driver.getCurrentUrl();
    }

    public abstract boolean elementsExist();

    protected boolean webpageElementsExist(WebElement[] arrayWebElements) {
        for (WebElement we : arrayWebElements) {
            if (null == we) {
                return false;
            }
        }
        return true;
    }

    protected boolean browserElementExists(WebElement element) {
        return element.isDisplayed();
    }

    public void browserWaitVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void browserClick(WebElement element) {
        browserWaitVisibility(element);
        element.click();
    }

}