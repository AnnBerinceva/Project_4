package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class startPage {
    private static WebDriver driver;

    public By logoScooter = By.xpath(".//img[@src = '/assets/scooter.svg']"); //логотип самоката
    public By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g' and text() = 'Заказать']"); //кнопка заказать
    public By orderButtonDown = By.xpath(".//button[@class = 'Button_Button__ra12g Button_UltraBig__UU3Lp' and text() = 'Заказать']"); //кнопка заказать снизу
    public static By questions = (By.className("accordion__button")); //вопросы
    public static By answer = By.xpath(".//div[@data-accordion-component='AccordionItemPanel']"); //ответы

    public startPage(WebDriver driver) {  this.driver = driver; }
    public WebElement getLogoScooter() {
        return driver.findElement(logoScooter);
    }
    public WebElement getOrderButton() {
        return driver.findElement(orderButton);
    }

    public WebElement getOrderButtonDown() {
        WebElement element = driver.findElement(orderButtonDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderButtonDown));
        return element;
    }

    public static WebElement getQuestion(int numberQuestion) {
        WebElement element = driver.findElement(questions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(questions));
        return driver.findElements(questions).get(numberQuestion);
    }

    public static WebElement getAnswer(int numberQuestion) {
        WebElement element = driver.findElements(answer).get(numberQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(answer));
        return driver.findElements(answer).get(numberQuestion);
    }
}