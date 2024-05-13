import PageObject.LoginPageObject;
import PageObject.StartPageObject;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class additionalTask {
    private WebDriver driver;
    @Test
    public void testThird(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/"); //открыли
        driver.manage().window().maximize(); //развернули
        StartPageObject objStartPage = new StartPageObject(driver);
        objStartPage.clickOrderButtonStartPage(); //нажали "Заказать"
        LoginPageObject objLoginPage = new LoginPageObject(driver);
        objLoginPage.loginForAdditionalTask("1", "1", "1","1"); //ввели невалидные данные + клик "Для кого самокат"
        driver.findElement(objLoginPage.errorName); //ошибка по полю имя
        driver.findElement(objLoginPage.errorSurname); //ошибка по полю фамилия
        driver.findElement(objLoginPage.errorAddress); //ошибка по полю адрес
        driver.findElement(objLoginPage.errorPhone); //ошибка по полю телефон
        objStartPage.clickLogoScooter(); //клик на логотип самоката - ушли на старт страницу
        objStartPage.clickOrderStatusButtonStartPage(); //клик "Статус заказа"
        objStartPage.checkOrderNumber(); //проверили активность поля "Введите номер заказа"

        /* пункт 4 доп задания так и не смогла доделать. билась-билась, падают тесты при вводе значения в поле
        "Введите номер заказа". хотя метод checkOrderNumber() проверяет, что поле активно */

        objStartPage.clickLogoYandex(); //открыли вкладку яндекс
    }
   @After
    public void close() {
        driver.quit();
    }
}
