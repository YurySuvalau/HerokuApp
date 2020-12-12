import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Typos {

        WebDriver driver;
        private static final String HEROCU_APP_URL = "http://the-internet.herokuapp.com/typos";

        @BeforeMethod
        public void initMethod() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        @Test
        public void testTypos() {
            driver.get(HEROCU_APP_URL);
            WebElement typos = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]"));
            String actualTypos = typos.getText();
            String expectedTypos = "Sometimes you'll see a typo, other times you won't.";
            Assert.assertEquals(actualTypos, expectedTypos, "Typo in a word - don't");
            driver.quit();

    }



    }


