import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Edge {
    public static void main(String[] args) {
        // иницилизация драйвера + неявное ожидание
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // открытие страницы
        driver.get("https://testng.org/");

        // поиск веб-элемента + явное ожидание на появление этого элемента
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//h1[text()=\"TestNG Documentation\"]")));
        List<WebElement> content = driver.findElements(By.cssSelector(".toc-link.node-name--H2." +
                "ignoreactive,.toc-link.node-name--H3,.toc-link.node-name--H4,.toc-link.node-name--H2," +
                ".toc-link.node-name--H5 "));

        // вывод
        System.out.println("Вывод:\n" + header.getText());
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).getAttribute("text"));
        }

        WebElement firstElement = driver.findElement(By.
                xpath("//a[text()='3. TestNG Documentation']"));
        firstElement.click();

        WebElement secondElement = driver.findElement(By.
                cssSelector("li.toc-list-item > a[href=\"#_testng_xml\"]"));
        secondElement.click();

        // закрытие
        driver.quit();
    }
}