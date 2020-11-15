
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DelfiTests {
    @Test
    public void firstDelfiTest() {

        System.setProperty("webdriver.chrome.driver", "C://Users/glebsj/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://delfi.lv");

    }



}
