import PageObject.CheckoutPageObject;
import PageObject.LoginPageObject;
import PageObject.RentPageObject;
import PageObject.StartPageObject;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderScooter {
    private WebDriver driver;
    @Test
    public void testSecond(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");   //Открыли
        driver.manage().window().maximize(); //развернули
        StartPageObject objStartPage = new StartPageObject(driver);
        objStartPage.clickOrderButtonStartPage();  //кнопка заказать сверху
        LoginPageObject objLoginPage = new LoginPageObject(driver);
        objLoginPage.login("Анна", "Иванов", "улица Большая Якиманка, 43","+71234567890"); //заполнили первый раз
        RentPageObject objRentPage = new RentPageObject(driver);
        objRentPage.loginSecond("comment 123"); //заполнили "Про аренду" первый раз
        CheckoutPageObject objCheckoutPage = new CheckoutPageObject(driver);
        objCheckoutPage.clickButtonYes(); //кнопка "Да"некликабельна
        objCheckoutPage.clickButtonNo(); //нажали "Нет
        objRentPage.clickButtonBack(); //нажали "Назад"
        driver.navigate().refresh(); //обновили
        objLoginPage.login("Наталья", "Сидорова", "тестовая 10","+71111111111"); //заполнили второй раз
        objRentPage.loginThird(" второй тестовый comment 123"); //заполнили "Про аренду" второй раз
        objCheckoutPage.clickButtonNo(); //нажали "Нет
        objStartPage.clickLogoScooter(); //клик на "Самокат"
        WebElement element = driver.findElement(objStartPage.orderButtonAfterScroll);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //скролл до второй кнопки "Заказать"
        objStartPage.clickOrderButtonAfterScroll(); //нажали вторую кнопку "Заказать"

//всплывающее окно с сообщением об успешном создании заказа не появляется, кнопка "Да" некликабельна
    }
    @After
    public void close() {
        driver.quit();
    }
}
