import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Testi {


    private final By NEWS = By.xpath(".//span[@itemprop = 'headline name']");

    @Test

    public void homeworkTvnet() {

        String aritcleToOpen = "Gaiļezera feldšerei nav taisnība – vakcīnas ir pārbaudītas un maskas nenogalina";

        System.setProperty("webdriver.chrome.driver", "C://Users/glebsj/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        List<WebElement> articles = driver.findElements(NEWS);

        for (int i = 0; i < articles.size(); i++) {
            System.out.println(i + " " + articles.get(i).getText());


        }
    }
}