import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
    }

    @Test
    public void teststeps() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).click();
        driver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("ak");
        driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("ak");
        driver.findElement(By.xpath("//*[@id=\"second_form\"]/input")).click();

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"ShoeType\"]"));
        String actualFirstCategory = webElement.getText();
        String expectedFirstCategory = "Formal Shoes";

        Assert.assertEquals(expectedFirstCategory, actualFirstCategory);

        driver.quit();
    }
}
