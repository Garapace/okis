import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FireFox2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://github.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> content_1 = driver.findElements(By.
                xpath("//li[contains(@class, 'HeaderMenu')]"));

        for (int i = 0; i < content_1.size(); i++) {
            System.out.println(content_1.get(i).getAttribute("innerText"));
        }

        WebElement firstElement = driver.findElement(By.
                xpath("//button[contains(@class, 'search-button')]"));
        firstElement.click();

        WebElement secondElement = driver.findElement(By.
                cssSelector("#query-builder-test-result-enterprise"));
        secondElement.click();

        driver.quit();
    }
}
