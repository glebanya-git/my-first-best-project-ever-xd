package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SuccessPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By SUCCESS_BLOCK = By.xpath(".//div[@class = 'successTxt']");
    private BaseFunc baseFunc;

    public SuccessPage (BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        LOGGER.info("Success registration page");
    }

    public String getSUCCESS_TXT() {
        LOGGER.info("Getting success msg");
        return baseFunc.getText(SUCCESS_BLOCK);

    }

}
