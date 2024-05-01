import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FireFox_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://otvet.mail.ru/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement header_1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("/html/body/div[1]/div[3]/div/nav/ul")));

        List<WebElement> content_1 = driver.findElements(By.
                xpath("/html/body/div[1]/div[3]/div/nav/ul/li/a"));

        WebElement header_2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("/html/body/div[2]/div[1]/div[1]/div[1]")));

        List<WebElement> content_2 = driver.findElements(By.
                xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/a"));

        System.out.println("Вывод:\n" + header_1.getAttribute("host"));
        for (int i = 0; i < content_1.size(); i++) {
            System.out.println(content_1.get(i).getAttribute("text"));
        }

        for (int i = 0; i < content_2.size(); i++) {
            System.out.println(content_2.get(i).getAttribute("text"));
        }


        driver.quit();

    }
}