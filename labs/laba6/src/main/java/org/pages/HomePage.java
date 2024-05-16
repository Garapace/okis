package org.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.BasePage;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private final By enterButtonBy = By.xpath("//button[@class='ph-login svelte-9hk6b1']");
    private final By inputLoginBy = By.xpath("//input[@class='input-0-2-71']");
    private final By buttonLoginPassBy = By.xpath("//button[@class='base-0-2-79 primary-0-2-93']");
    private final By inputPassBy = By.xpath("//input[@class='input-0-2-71 withIcon-0-2-72']");

    public HomePage authorization(String username, String password) throws AuthenticationException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterButtonBy)).click();
        changeFrame();
        driver.findElement(inputLoginBy).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLoginPassBy)).click();
        driver.findElement(inputPassBy).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLoginPassBy)).click();

        return new HomePage(driver);
    }


    private final By profileNameBy = By.xpath("//div[@class='ph-auth svelte-9hk6b1']");
    public String profileName() {
        return driver.findElement(profileNameBy).getAttribute("innerText");
    }


    private final By iFrameBy = By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']");
    private HomePage changeFrame() {
        driver.switchTo().frame(driver.findElement(iFrameBy));
        return new HomePage(driver);
    }


    private final By exitButtonBy = By.xpath("//div[@class='ph-item ph-item__social svelte-1popff4']");
    public HomePage exit() throws AuthenticationException {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(profileNameBy)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(exitButtonBy)).click();
        } catch (TimeoutException e) {
            throw new AuthenticationException("Вы не можете выйти, вы не вошли в аккаунт");
        }
        return new HomePage(driver);
    }

    public String exitCheck() {
        return driver.findElement(enterButtonBy).getAttribute("innerText");
    }



    public static class AuthenticationException extends Exception {
        public AuthenticationException(String message) {
            super(message);
        }
    }
}