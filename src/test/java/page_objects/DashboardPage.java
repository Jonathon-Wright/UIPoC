package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage extends BasePage {

    @FindBy(xpath = "//div[@id='app']/div[@class='container']//h1[.='Welcome to Volo']")
    public WebElement text_Welcome;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/nav/ul/li[3]/div/div/button")
    private WebElement button_ImportProducts;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/form/div[2]/div/input")
    private WebElement text_FileName;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/form/div[3]/button[1]")
    private WebElement modal_button_ImportProducts;

    public WebElement getButton_ImportProducts() {
        return button_ImportProducts;
    }

    public void setButton_ImportProducts(WebElement button_ImportProducts) {
        this.button_ImportProducts = button_ImportProducts;
    }

    public WebElement getText_FileName() {
        return text_FileName;
    }

    public void setText_FileName(WebElement text_FileName) {
        this.text_FileName = text_FileName;
    }

    public WebElement getModal_button_ImportProducts() {
        return modal_button_ImportProducts;
    }

    public void setModal_button_ImportProducts(WebElement modal_button_ImportProducts) {
        this.modal_button_ImportProducts = modal_button_ImportProducts;
    }

    public DashboardPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Override
    public boolean elementsExist() {
        return webpageElementsExist(new WebElement[]{button_ImportProducts, text_FileName});
    }

    public DashboardWithRefinementPage importProducts(String importFilePath) {

        browserWaitVisibility(button_ImportProducts);
        button_ImportProducts.click();

        text_FileName.sendKeys(importFilePath);
        browserWaitVisibility(modal_button_ImportProducts);

        modal_button_ImportProducts.click();

        return new DashboardWithRefinementPage(driver);

    }

}