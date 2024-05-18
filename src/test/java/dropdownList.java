<<<<<<< HEAD
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import pageobject.startPage;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class dropdownList extends constants {
    private dropdownList dropdownList;
    private int numberQuestion;
    private String expectedText;

    public dropdownList(int numberQuestion, String expectedText) {
        this.numberQuestion = numberQuestion;
        this.expectedText = expectedText;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testTextQuestions(){
        return Arrays.asList(new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }
    @Before
   public void beforeTest() {
        super.beforeTest();
        startPage startPage = new startPage(driver);
    }
    @Test
    public void testOrderScooter(){
        WebElement question = startPage.getQuestion(numberQuestion);
        question.click();
        WebElement answer = startPage.getAnswer(numberQuestion);
        String actualAnswer = answer.getText();
        assertEquals("Текст ответа не совпадает с ожидаемым", expectedText, actualAnswer);
    }
}
=======
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
>>>>>>> 6620147bb6e635d4cbdecd94a0cae8ebbe57b0cf
