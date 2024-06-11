package org.pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.constants.Constants.ExpectationVariable.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));

    private final By buttonLogInBy = By.xpath("//button[@class='ph-login svelte-9hk6b1']");
    private final By inputNameBy = By.xpath("//input[@name='username']");
    private final By inputPassBy = By.xpath("//input[@name='password']");
    private final By buttonLoginNextBy = By.xpath("//button[@data-test-id='next-button']");
    private final By buttonPassNextBy = By.xpath("//button[@data-test-id='submit-button']");

    public HomePage authorization(String username, String password) throws AuthenticationException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogInBy)).click();
        changeFrame(iFrameLogInBy);

        driver.findElement(inputNameBy).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLoginNextBy)).click();
        invalidLogin();

        driver.findElement(inputPassBy).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPassNextBy)).click();
        invalidPassword();

        return new HomePage(driver);
    }

    public final By invalidLoginBy = By.xpath("//div[@data-test-id='error-footer-text']");
    private HomePage invalidLogin() throws AuthenticationException {
        try {
            if (wait.until(ExpectedConditions.presenceOfElementLocated(invalidLoginBy)).isDisplayed()) {
                throw new AuthenticationException("Не правильный логин");
            }
        } catch (TimeoutException e) {}
        return new HomePage(driver);
    }

    private HomePage invalidPassword() throws AuthenticationException {
        try {
            if (driver.getCurrentUrl().contains("account.mail.ru")) {
                throw new AuthenticationException("Неверный пароль");
            }
        } catch (TimeoutException e) {}
        return new HomePage(driver);
    }

    private final By profileNameBy = By.xpath("//div[@data-testid='whiteline-account']");
    public String profileName() {
        return driver.findElement(profileNameBy).getAttribute("ariaLabel");
    }


    private final By iFrameLogInBy = By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']");
    private final By iFrameHomePageBy = By.xpath("//html[contains(@class, 'layout-desktop')]");
    private HomePage changeFrame(By xpath) {
        driver.switchTo().frame(driver.findElement(xpath));
        return new HomePage(driver);
    }

    private final By buttonExitBy = By.xpath("//div[@data-testid='whiteline-account-exit']");
    public HomePage exit() throws AuthenticationException {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(profileNameBy)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonExitBy)).click();
        } catch (TimeoutException e) {
            throw new AuthenticationException("Вы не можете выйти, вы не вошли в аккаунт");
        }
        return new HomePage(driver);
    }

    public String exitCheck() {
        return driver.findElement(buttonLogInBy).getAttribute("innerText");
    }

    public static class AuthenticationException extends Exception {
        public AuthenticationException(String message) {
            super(message);
        }
    }

    private final By menuList = By.xpath("//nav[@aria-label='Проекты']");
    public String parseMenu() {
        List<WebElement> content = driver.findElements(menuList);
        return content.get(0).getAttribute("innerText");
    }

    private final By buttonProjectsBy = By.xpath("//button[@class='ph-project svelte-fxwh2g']");
    private final By projectsListBy = By.xpath("//ul[@class='ph-projects-bar svelte-ci5ln5']");
    public String parseProjects() {
        driver.findElement(buttonProjectsBy).click();
        List<WebElement> content = driver.findElements(projectsListBy);
        return content.get(0).getAttribute("innerText");
    }

    private final By buttonAllProjectsBy = By.xpath("//a[@class='ph-all-projects svelte-1cd1bhl']");
    private final By allProjectsListBy1 = By.xpath("//ul[@class='SideTabs_sideTabsList__4QLOo']");
    private final By allProjectsListBy2 = By.xpath("//ul[@class='AdaptiveTabs_tabsList__MdFef']");
    public String parseAllProjects() {
        driver.findElement(buttonProjectsBy).click();
        driver.findElement(buttonAllProjectsBy).click();

        Set<String> allTabs = driver.getWindowHandles();

        for (String tab : allTabs) {
            driver.switchTo().window(tab);
        }

        List<WebElement> content = driver.findElements(allProjectsListBy1);
        return content.get(0).getAttribute("innerText");
    }
}