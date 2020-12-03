import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DelfiTests {

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");


    @Test
    public void firstDelfiTest() {

        System.setProperty("webdriver.chrome.driver", "C://Users/glebsj/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://delfi.lv");

        //  Thread.sleep(10000); - plohoi ton, ne rekomneduetsa ispolzovatj

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIE_BTN));

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();
    }

}

