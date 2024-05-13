import PageObject.StartPageObject;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class dropdownList {
    private WebDriver driver;

    @Test
    public void testFirst(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");  //Открыли
        driver.manage().window().maximize();  //Развернули
        StartPageObject objStartPage = new StartPageObject(driver);
        objStartPage.clickCookieButton(); //нажали "да все привыкли"
        WebElement element = driver.findElement(objStartPage.QuestionsAfterScroll);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);  //скролл "Вопросы о важном"
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.numberOfElementsToBe(objStartPage.listQuestionsAfterScroll, 8));   //подождали загрузки 8 элементов
        objStartPage.clickButtonListFirst();   //кликнули на 1 стрелочку
        driver.findElement(objStartPage.textListFirst);     //проверка текста
        objStartPage.clickButtonListSecond();
        driver.findElement(objStartPage.textListSecond);
        objStartPage.clickButtonListThird();
        driver.findElement(objStartPage.textListThird);
        objStartPage.clickButtonListFourth();
        driver.findElement(objStartPage.textListFourth);
        objStartPage.clickButtonListFifth();
        driver.findElement(objStartPage.textListFifth);
        objStartPage.clickButtonListSixth();
        driver.findElement(objStartPage.textListSixth);
        objStartPage.clickButtonListSeventh();
        driver.findElement(objStartPage.textListSeventh);
        objStartPage.clickButtonListEighth();
        driver.findElement(objStartPage.textListEighth);
    }
    @After
    public void close() {
        driver.quit();
    }
}
