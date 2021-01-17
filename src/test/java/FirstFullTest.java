import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstFullTest {

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//div[contains(@class, 'button cookie')]");
    private final By ARTICLE = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final Logger LOGGER = LogManager.getLogger(FirstFullTest.class);

            @Test

    public void titleCommentsCheck() {

       LOGGER.info("This test is checking titles and comments on tvnet page");
       System.setProperty("webdriver.chrome.driver", "C://Users/glebsj/Downloads/chromedriver.exe");

       LOGGER.info("We are opening driver window and maximizing it");
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();

       LOGGER.info("Opening tvnet main page");
       driver.get("http://tvnet.lv");

       LOGGER.info("Clicking the Accept cookies btn");
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIE_BTN));
       WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
       acceptBtn.click();

       LOGGER.info("Taking 3rd or other necessary article");
       WebElement currentArticle = driver.findElements(ARTICLE).get(6);

       LOGGER.info("Finding and storing title");
       String titleToCheck = currentArticle.findElement(ARTICLE_TITLE).getText();

       // Find and store comment count - sohranitj kolicestvo komentarij
       int commentCount = 0;

       if (!currentArticle.findElements(COMMENTS_COUNT).isEmpty()) {
           String commentsToParse = currentArticle.findElement(COMMENTS_COUNT).getText();  // (36)
           commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); // -> -1 ubiraet skobku ot (36) <-
           commentCount = Integer.parseInt(commentsToParse);
       }

       // Open article
       currentArticle.findElement(ARTICLE_TITLE).click();

       // Check title
       Assertions.assertEquals(titleToCheck, driver.findElement(ARTICLE_PAGE_TITLE).getText(),"Incorrect Title!");

       // Check comments

       // Find comments

       // Click on the comments

       // Check title

       // Check comments count

   }
}
