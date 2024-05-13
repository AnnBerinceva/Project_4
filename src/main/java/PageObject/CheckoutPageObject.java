package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Object окна "Хотите оформить заказ" - кнопка "Заказать" с главной страницы, потом кнопка "Далее", потом кнопка "Заказать"
public class CheckoutPageObject {
    private WebDriver driver;
    private By question = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Хотите оформить заказ?']");
    private By buttonYes = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    private By buttonNo = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text() = 'Нет']");
    public CheckoutPageObject(WebDriver driver){
        this.driver = driver;
    }
    public boolean checkButtonYesIsEnabled() {
        return driver.findElement(buttonYes).isEnabled();
    }
    public boolean checkButtonNoIsEnabled() {
        return driver.findElement(buttonNo).isEnabled();
    }
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }
    public void clickButtonNo() {
        driver.findElement(buttonNo).click();
    }
}
