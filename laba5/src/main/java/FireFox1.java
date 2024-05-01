import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FireFox1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://otvet.mail.ru/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> content_1 = driver.findElements(By.
                xpath("//a[@class='ph-project__link svelte-64wa9f']"));
        content_1.add(driver.findElement(By.xpath("//div[@class='ph-project__all-projects-text svelte-fxwh2g']")));

        List<WebElement> content_2 = driver.findElements(By.
                xpath("//div[@class='uqCC6']"));


        for (int i = 0; i < content_1.size() - 1; i++) {
            System.out.println(content_1.get(i).getAttribute("text"));
        }
        System.out.println(content_1.get(content_1.size() - 1).getText());

        System.out.println();

        for (int i = 0; i < content_2.size(); i++) {
            System.out.println(content_2.get(i).getAttribute("innerText"));
        }

        WebElement firstElement = driver.findElement(By.
                xpath("//button[@class='ph-project svelte-fxwh2g']"));
        firstElement.click();

        WebElement secondElement = driver.findElement(By.
                cssSelector("a.ph-projects-bar-item__link[data-click-counter='374382545']"));
        secondElement.click();

        driver.quit();
    }
}