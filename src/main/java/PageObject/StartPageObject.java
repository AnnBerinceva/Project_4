package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Object окна стартовой страницы
public class StartPageObject {
    private WebDriver driver;
    public StartPageObject(WebDriver driver){
        this.driver = driver;
    }
    private By logoYandex = By.xpath(".//img[@src = '/assets/ya.svg']");
    private By logoScooter = By.xpath(".//img[@src = '/assets/scooter.svg']");
    private By logoTrainingSimulator = By.xpath(".//div[@class = 'Header_Disclaimer__3VEni' and text() = 'Учебный тренажер']");
    public By orderButtonStartPage = By.xpath(".//button[@class = 'Button_Button__ra12g' and text() = 'Заказать']");
    private By orderStatusButtonStartPage = By.xpath(".//button[@class = 'Header_Link__1TAG7' and text() = 'Статус заказа']");
    public By orderNumber = By.xpath(".//input[@class = 'Input_Input__1iN_Z Header_Input__xIoUq' and @placeholder = 'Введите номер заказа']");
    public By buttonGo = By.xpath(".//button[@class = 'Button_Button__ra12g Header_Button__28dPO' and text() = 'Go!'");
    private By titleStartPage = By.xpath(".//div[@class = 'Home_Header__iJKdX' and text() = 'Самокат ']");
    private By  textStartPage= By.xpath(".//div[@class = 'Home_SubHeader__zwi_E' and text() = 'Привезём его прямо к вашей двери,']");
    private By  textStartPageAfterScroll = By.xpath(".//div[@class = 'Home_SubHeader__zwi_E' and text() = 'Он лёгкий и с мощными колёсами— самое то, чтобы ехать по набережной и нежно барабанить пальцами по рулю']");
    private By  textStartPageAboutScooter = By.xpath(".//div[@class = 'Home_Table__2kPxP']");
    private By scooterPicture = By.xpath(".//img[@src = '/assets/scooter.png']");
    private By textAboutCookies = By.xpath(".//div[@class = 'App_CookieText__1sbqp' and text() = 'И здесь куки! В общем, мы их используем.']");
    private By cookieButton = By.xpath(".//button[@class = 'App_CookieButton__3cvqF' and @id = 'rcc-confirm-button']");
    private By textHowItWorks = By.xpath(".//div[@class = 'Home_SubHeader__zwi_E' and text() = 'Как это работает']");
    private By listHowItWorks = By.className("Home_RoadMap__2tal_");

    public By orderButtonAfterScroll = By.xpath(".//button[@class = 'Button_Button__ra12g Button_UltraBig__UU3Lp' and text() = 'Заказать']");
    public By  QuestionsAfterScroll = By.xpath(".//div[@class = 'Home_SubHeader__zwi_E' and text() = 'Вопросы о важном']");
    public By  listQuestionsAfterScroll = (By.className("accordion__button"));
    private By buttonListFirst = By.id("accordion__heading-0");
    public By textListFirst = By.xpath(".//div[@class = 'accordion__panel' and @id = 'accordion__panel-0']");
    private By buttonListSecond = By.id("accordion__heading-1");
    public By textListSecond = (By.xpath(".//div[@class = 'accordion__panel' and @id = 'accordion__panel-1']"));
    private By buttonListThird = By.id("accordion__heading-2");
    public By textListThird = (By.xpath(".//div[@class = 'accordion__panel' and @id = 'accordion__panel-2']"));
    private By buttonListFourth = By.id("accordion__heading-3");
    public By textListFourth = (By.xpath(".//div[@class = 'accordion__panel' and @id = 'accordion__panel-3']"));
    private By buttonListFifth = By.id("accordion__heading-4");
    public By textListFifth = (By.xpath(".//div[@class = 'accordion__panel' and @id = 'accordion__panel-4']"));
    private By buttonListSixth = By.id("accordion__heading-5");
    public By textListSixth = (By.xpath(".//div[@class = 'accordion__panel' and @id = 'accordion__panel-5']"));
    private By buttonListSeventh = By.id("accordion__heading-6");
    public By textListSeventh = (By.xpath(".//div[@class = 'accordion__panel' and @id = 'accordion__panel-6']"));
    private By buttonListEighth = By.id("accordion__heading-7");
    public By textListEighth = (By.xpath(".//div[@class = 'accordion__panel' and @id = 'accordion__panel-7']"));
    public boolean checkOrderButtonStartPageIsEnabled() {
        return driver.findElement(orderButtonStartPage).isEnabled();
    }
    public boolean checkOrderStatusButtonStartPageIsEnabled() { return driver.findElement(orderStatusButtonStartPage).isEnabled(); }
   // public boolean checkOrderButtonStartPageAfterScrollIsEnabled() { return driver.findElement(orderButtonStartPageAfterScroll).isEnabled(); }
    public boolean checkCookieButtonIsEnabled() { return driver.findElement(cookieButton).isEnabled(); }
    public boolean checkOrderNumber() { return driver.findElement(orderNumber).isEnabled(); }
   public void clickOrderButtonStartPage() {
        driver.findElement(orderButtonStartPage).click();
    }
    public void clickOrderStatusButtonStartPage() {
        driver.findElement(orderStatusButtonStartPage).click();
    }
    public void clickOrderNumber() { driver.findElement(orderNumber).click(); }
    public void sendKeysOrderNumber() { driver.findElement(orderNumber).sendKeys("тест"); }
    public void clickButtonGo() { driver.findElement(buttonGo).click(); }
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }
   public void clickOrderButtonAfterScroll() {
        driver.findElement(orderButtonAfterScroll).click();
    }
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
    public void clickButtonListFirst() {
        driver.findElement(buttonListFirst).click();
    }
    public void clickButtonListSecond() {
        driver.findElement(buttonListSecond).click();
    }
    public void clickButtonListThird() {
        driver.findElement(buttonListThird).click();
    }
    public void clickButtonListFourth() {
        driver.findElement(buttonListFourth).click();
    }
    public void clickButtonListFifth() {
        driver.findElement(buttonListFifth).click();
    }
    public void clickButtonListSixth() {
        driver.findElement(buttonListSixth).click();
    }
    public void clickButtonListSeventh() {
        driver.findElement(buttonListSeventh).click();
    }
    public void clickButtonListEighth() {
        driver.findElement(buttonListEighth).click();
    }
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }
}
