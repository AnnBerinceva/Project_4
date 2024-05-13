package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Page Object окна "Про аренду" - кнопка "Заказать" с главной страницы, потом кнопка "Далее"
public class RentPageObject{
    private WebDriver driver;
    public By date = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    public By date16May = By.xpath(".//div[@class = 'react-datepicker__day react-datepicker__day--016']");
    public By date22May = By.xpath(".//div[@class = 'react-datepicker__day react-datepicker__day--022']");
    public By rentalPeriod = By.xpath(".//div[@class = 'Dropdown-placeholder' and text() = '* Срок аренды']");
    public By rentalPeriodThreeDays = By.xpath(".//div[@class = 'Dropdown-option' and text() = 'трое суток']");
    public By rentalPeriodSixDays = By.xpath(".//div[@class = 'Dropdown-option' and text() = 'шестеро суток']");
    public By scooterColor = By.xpath(".//div[@class = 'Order_Title__3EKne' and text() = 'Цвет самоката']");
    public By scooterColorBlack = By.xpath(".//input[@class = 'Checkbox_Input__14A2w' and @id = 'black']");//может использовать text() = 'чёрный жемчуг'
    public By scooterColorGrey = By.xpath(".//input[@class = 'Checkbox_Input__14A2w' and @id = 'grey']"); //может использовать text() = 'серая безысходность'
    public By comment = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = 'Комментарий для курьера']");
    public By buttonBack = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text() = 'Назад']");
    public By buttonOrder = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    public RentPageObject(WebDriver driver) { this.driver = driver; }
    public boolean checkButtonBackIsEnabled() {
        return driver.findElement(buttonBack).isEnabled();
    }
    public boolean checkButtonOrderIsEnabled() {
        return driver.findElement(buttonOrder).isEnabled();
    }
    public void clickButtonBack() {
        driver.findElement(buttonBack).click();
    }
    public void clickButtonOrder() { driver.findElement(buttonOrder).click(); }
    public void clickDate() { driver.findElement(date).click(); }

        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(1).format(formatter);
        driver.findElement(By.className("react-datepicker__input-container")).sendKeys(date);
        driver.findElement(By.className("react-datepicker__input-container")).sendKeys(Keys.ENTER);*/

    public void clickDate16May() { driver.findElement(date16May).click(); }
    public void clickDate22May() { driver.findElement(date22May).click(); }
    public void clickRentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }
    public void clickRentalPeriodThreeDays() {
        driver.findElement(rentalPeriodThreeDays).click();
    }
    public void clickRentalPeriodSixDays() {
        driver.findElement(rentalPeriodSixDays).click();
    }
    public void clickScooterColorBlack() { driver.findElement(scooterColorBlack).click(); }
    public void clickScooterColorGrey() { driver.findElement(scooterColorGrey).click(); }
    public void setComment(String comment) {
        driver.findElement(By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = 'Комментарий для курьера']")).sendKeys(comment);
    }
      public void loginSecond(String comment){
        clickDate();
        clickDate16May();
        clickRentalPeriod();
        clickRentalPeriodThreeDays();
        clickScooterColorBlack();
        setComment(comment);
        clickButtonOrder();
    }
    public void loginThird(String comment){
        clickDate();
        clickDate22May();
        clickRentalPeriod();
        clickRentalPeriodSixDays();
        clickScooterColorGrey();
        setComment(comment);
        clickButtonOrder();
    }
}
