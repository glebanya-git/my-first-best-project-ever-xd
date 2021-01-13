import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstFullTest {
    private final By ARTICLE = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");

   @Test

   public void titleCommentsCheck() {
       System.setProperty("webdriver.chrome.driver", "C://Users/glebsj/Downloads/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://tvnet.lv");

       // Find article
       WebElement currentArticle = driver.findElements(ARTICLE).get(3);

       // Store title - sohranitj zagolovok
       String titleToCheck = currentArticle.findElement(ARTICLE_TITLE).getText();

       // Store comment count - sohranitj kolicestvo komentarij
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
