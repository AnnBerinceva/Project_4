package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public By nameField = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Имя']"); //имя
    public By surnameField = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Фамилия']"); //фамилия
    public By addressField = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Адрес: куда привезти заказ']"); //адрес
    public By station = By.xpath(".//input[@class = 'select-search__input' and @placeholder = '* Станция метро']"); //метро
    public By phoneField = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Телефон: на него позвонит курьер']"); //телефон
    public By buttonNextPage = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Далее']"); //кнопка далее
    public By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //когда привезти самокат
    public By rentalPeriod = By.xpath(".//div[text()='* Срок аренды']"); //срок аренды
    public By scooterColorBlack = By.xpath(".//input[@class = 'Checkbox_Input__14A2w' and @id = 'black']");//чёрный цвет самоката
    public By scooterColorGrey = By.xpath(".//input[@class = 'Checkbox_Input__14A2w' and @id = 'grey']"); //серый цвет самоката
    public By commentField = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = 'Комментарий для курьера']"); //коммент
    public By buttonOrder = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']"); //кнопка заказать
    public By buttonYes = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']"); //кнопка да
    public By orderIssue = By.xpath(".//div[text()='Заказ оформлен']"); //заказ оформлен

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void enterNameField(String name){
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }
    public void enterSurnameField(String surname){
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void enterAddressField(String address){
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }
    public void enterStation(String stationMetro){
        driver.findElement(station).clear();
        driver.findElement(station).sendKeys(stationMetro);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='"+ stationMetro +"']")));
        driver.findElement(By.xpath(".//div[text()='"+ stationMetro +"']")).click();
    }
    public void enterPhoneField(String phone){
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void clickButtonNextPage(){ driver.findElement(buttonNextPage).click();  }

    public void enterDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateCorrect = LocalDate.now().plusDays(1).format(formatter);
        driver.findElement(date).clear();
        driver.findElement(date).sendKeys(dateCorrect);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }
    public void enterRentalPeriod(int time){
        driver.findElement(rentalPeriod).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-menu")));
        switch (time){
            case 1: driver.findElement(By.xpath(".//div[text()='сутки']")).click(); break;
            case 2: driver.findElement(By.xpath(".//div[text()='двое суток']")).click(); break;
            case 3: driver.findElement(By.xpath(".//div[text()='трое суток']")).click(); break;
            case 4: driver.findElement(By.xpath(".//div[text()='четверо суток']")).click(); break;
            case 5: driver.findElement(By.xpath(".//div[text()='пятеро суток']")).click(); break;
            case 6: driver.findElement(By.xpath(".//div[text()='шестеро суток']")).click(); break;
            case 7: driver.findElement(By.xpath(".//div[text()='семеро суток']")).click(); break;
        }
    }
    public void checkedScooterColorBlack(Boolean isBlack){
        if (!driver.findElement(scooterColorBlack).isSelected() & isBlack) {
            driver.findElement(scooterColorBlack).click();
        }
    }
    public void checkedScooterColorGrey(Boolean isGrey){
        if (!driver.findElement(scooterColorGrey).isSelected() & isGrey) {
            driver.findElement(scooterColorGrey).click();
        }
    }
    public void enterCommentField(String comment){// Заполняем поле коммментарий
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickButtonOrder(){ driver.findElement(buttonOrder).click(); }
    public void clickButtonYes(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3")));
        driver.findElement(buttonYes).click();
    }
    public void order(String name, String surname, String address, String stationMetro, String phone, int period, Boolean isBlack, Boolean isGrey, String comment) {
        enterNameField(name);
        enterSurnameField(surname);
        enterAddressField(address);
        enterStation(stationMetro);
        enterPhoneField(phone);
        clickButtonNextPage();
        enterDate();
        enterRentalPeriod(period);
        checkedScooterColorBlack(isBlack);
        checkedScooterColorGrey(isGrey);
        enterCommentField(comment);
        clickButtonOrder();
        clickButtonYes();
    }
    public Boolean isOrderIssue() { return driver.findElements(orderIssue).isEmpty(); } }