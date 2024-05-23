package org.baseTest;

import org.common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.pages.BasePage;
import org.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.common.Config.*;


public class BaseTest {
    protected WebDriver driver;
    protected BasePage BasePage;
    protected HomePage HomePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = CommonAction.createDriver();
        BasePage = new BasePage(driver);
        HomePage = new HomePage(driver);

        BasePage.open(URL);
    }

    public void openMainPage() {
        BasePage.open(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        if (CLOSE_BROWSER) {
            driver.quit();
        }
    }
}
