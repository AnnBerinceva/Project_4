import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
public class constants {
    protected WebDriver driver;
    protected String site = "https://qa-scooter.praktikum-services.ru/";
    @Before
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
        driver.get(site);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}