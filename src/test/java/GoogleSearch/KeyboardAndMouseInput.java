package GoogleSearch;

import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class KeyboardAndMouseInput {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty( "webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com");

        // Explicit Wait
       // WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement clickLink = driver.findElement(By.linkText("Autocomplete"));
        clickLink.click();
        sleep(1000);
        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("Clementi Avenue 1, Singapore");
       // sleep(1000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit Wait

        WebElement autocompleteResults = driver.findElement(By.className("pac-item"));
        //sleep(1000);
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // -- Implicit Wait
        autocompleteResults.click();
        driver.quit();
    }
}
