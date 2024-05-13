package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

//Page Object окна "Для кого самокат" - авторизация с кнопки "Заказать" с главной страницы
public class LoginPageObject {
    private WebDriver driver;
    public By whoIsTheScooterFor = By.xpath(".//div[@class = 'Order_Header__BZXOb' and text() = 'Для кого самокат']");
    public By name = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Имя']");
    public By surname = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Фамилия']");
    public By address = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Адрес: куда привезти заказ']");
    public By station = By.xpath(".//input[@class = 'select-search__input' and @placeholder = '* Станция метро']");
    public By stationDropDown = By.xpath(".//div[contains(@class, 'Order_Text__2broi') and text()='Бульвар Рокоссовского']");
    public By phone = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Далее']");
    //ошибки в полях
    public By errorName = By.xpath(".//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and text() = 'Введите корректное имя']");
    public By errorSurname = By.xpath(".//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and text() = 'Введите корректную фамилию']");
    public By errorAddress = By.xpath(".//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and text() = 'Введите корректный адрес']");
    public By errorPhone = By.xpath(".//div[@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and text() = 'Введите корректный номер']");
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    public boolean checkNextButtonIsEnabled() {
        return driver.findElement(nextButton).isEnabled();
    }
    public void clickStation() {
        driver.findElement(station).click();
    }
    public void clickNextButton() { driver.findElement(nextButton).click(); }
    public void clickStationDropDown() {
        driver.findElement(stationDropDown).click();
    }
    public void clickWhoIsTheScooterFor() {
        driver.findElement(whoIsTheScooterFor).click();
    }

    public void setName(String name) {
        driver.findElement(By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Имя']")).sendKeys(name);
    }
    public void setSurname(String surname) {
        driver.findElement(By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Фамилия']")).sendKeys(surname);
    }
    public void setAddress(String address) {
        driver.findElement(By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Адрес: куда привезти заказ']")).sendKeys(address);
    }
    public void setPhone(String phone) {
        driver.findElement(By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Телефон: на него позвонит курьер']")).sendKeys(phone);
    }
    public void login(String name, String surname, String address, String phone){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setPhone(phone);
        clickStation();
        clickStationDropDown();
        clickNextButton();
    }
    public void loginForAdditionalTask(String name, String surname, String address, String phone){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setPhone(phone);
        clickWhoIsTheScooterFor();
    }
}
