import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class DelfiTests {

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");

   //  private final By ID_lOCATOR = By.id("id"); - Primer, kak iskatj imenno po lokatoru

    //  private final By ID_lOCATOR = By.name("id"); - Primer, kak iskatj imenno po name

    @Test
    public void firstDelfiTest() {

        System.setProperty("webdriver.chrome.driver", "C://Users/glebsj/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://delfi.lv");

        //  Thread.sleep(10000); - plohoi ton, ne rekomneduetsa ispolzovatj - delaetsa lishnaja zaderzhka

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIE_BTN));

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();


    }


    @Test
    public void tvnetTest() {

        String articleToOpen = "Komandantstundas laikā iedzīvotāji policiju centušies atbaidīt ar suņiem ";
        System.setProperty("webdriver.chrome.driver", "C://Users/glebsj/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

       List<WebElement> articles = driver.findElements(ARTICLE_TITLE);
        System.out.println(articles.size());
        System.out.println(articles.isEmpty());
        System.out.println(articles.get(5).getText());

        //--------------------------for----------------------------------   i - index
        //counter start---------till------------step--   (i++ -> i = i + 1) - inkrement/dobavljaem cto libo
//        for (int i = 0; i < articles.size(); i++) {
//            if (articles.get(i).getText().startsWith(articleToOpen)) {
//                articles.get(i).click();
//                break;
//            }
//        }

        //-------------------------foreach-------------------------------
        for (WebElement we: articles) {
            if (we.getText().startsWith(articleToOpen)) {
                we.click();
                break;
            }
        }

    }

}

