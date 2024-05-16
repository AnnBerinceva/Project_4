import pageobject.orderPage;
import pageobject.startPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class orderScooter extends constants {
    private startPage startPage;
    private orderPage orderPage;
    private final String name;
    private final String surname;
    private final String address;
    private final String stationMetro;
    private final String phone;
    private final int period;
    private final Boolean isBlack;
    private final Boolean isGrey;
    private final String comment;

    public orderScooter(String name, String surname, String address, String stationMetro, String phone, int period, Boolean isBlack, Boolean isGrey, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.stationMetro = stationMetro;
        this.phone = phone;
        this.period = period;
        this.isBlack = isBlack;
        this.isGrey = isGrey;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Анна", "Иванов", "улица Большая Якиманка, 43", "+71234567890", 25, false, true, "комментарий тест"},
                {"Петр", "Петров", "пр. Невский, д. 10", "Сокольники", "+79007654321", 9, true, false, "комментарий тест001"}
        });
    }

    @Before
    public void beforeTest() {
        super.beforeTest();
        startPage = new startPage(driver);
        orderPage = new orderPage(driver);
    }
    @Test
    public void getOrderButton() {
        startPage.getOrderButton().click();
        orderPage.order(name, surname, address, stationMetro, phone, period, isBlack, isGrey, comment);
        assertTrue("orderIssue отсутствует", !orderPage.isOrderIssue());
    }
    @Test
    public void orderScooterOrderButtonDown() {
        startPage.getOrderButtonDown().click();
        orderPage.order(name, surname, address, stationMetro, phone, period, isBlack, isGrey, comment);
        assertTrue("orderIssue отсутствует", !orderPage.isOrderIssue());
    }
}