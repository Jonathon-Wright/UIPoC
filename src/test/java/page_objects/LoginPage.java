package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "kc-login")
    private WebElement button_login;

    @FindBy(id = "username")
    private WebElement text_username;

    @FindBy(id = "password")
    private WebElement text_password;

    @FindBy(xpath = "//div[@id='kc-content-wrapper']//span[@class='kc-feedback-text']")
    private WebElement message_unsuccessful;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean elementsExist() {
        return webpageElementsExist(new WebElement[]{button_login, text_username, text_password});
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


    public DashboardPage login(String username, String password) {

        text_username.sendKeys(username);
        text_password.sendKeys(password);
        button_login.click();

        return new DashboardPage(this.driver);

    }

}