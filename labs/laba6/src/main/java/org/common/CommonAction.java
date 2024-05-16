package org.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.common.Config.BROWSER;
import static org.constants.Constants.ExpectationVariable.IMPLICIT_WAIT;

public class CommonAction {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (BROWSER) {
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Incorrect browser");
                break;
        }

        /*int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

        driver.manage().window().setSize(new Dimension(screenWidth, screenHeight));
        driver.manage().window().setPosition(new Point(0, 0));*/

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        return driver;
    }
}
