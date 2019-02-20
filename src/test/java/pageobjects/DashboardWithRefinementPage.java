package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardWithRefinementPage extends DashboardPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[1]/div/div/ul/li/div/div[2]/span/span")
    private WebElement span_UnrefinedProductsCount;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[1]/div/div/ul/li/div/div[4]/a")
    private WebElement button_refineProducts;

    public WebElement getSpan_UnrefinedProductsCount() {
        return span_UnrefinedProductsCount;
    }

    public void setSpan_UnrefinedProductsCount(WebElement span_UnrefinedProductsCount) {
        this.span_UnrefinedProductsCount = span_UnrefinedProductsCount;
    }

    public WebElement getButton_refineProducts() {
        return button_refineProducts;
    }

    public void setButton_refineProducts(WebElement button_refineProducts) {
        this.button_refineProducts = button_refineProducts;
    }

    public DashboardWithRefinementPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Override
    public boolean elementsExist() {
        return webpageElementsExist(new WebElement[]{span_UnrefinedProductsCount, button_refineProducts});
    }

    public void waitForRefineProductsButton() {
        browserWaitVisibility(button_refineProducts);
    }

    public String getUnrefinedProductsCount() {

        return span_UnrefinedProductsCount.getText();

    }

}