import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Hovers {

    WebDriver driver;
    private static final String HEROCU_APP_URL = "http://the-internet.herokuapp.com/hovers";

    @BeforeMethod
    public void initMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHoversUser1() {
        //Open site http://the-internet.herokuapp.com/hovers
        driver.get(HEROCU_APP_URL);
        Actions action = new Actions(driver);
        //Move to User1 icon
        WebElement we = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        //Move to User1 link, and click it
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"))).click().build().perform();
        //Chek page on "Page not found" error
        String actualPage = driver.findElement(By.xpath("/html/body/h1")).getText();
        String exceptedPage = "Not Found";
        Assert.assertEquals(actualPage, exceptedPage, "Not contains error 404");
        //Close driver
        driver.close();
    }

    @Test
    public void testHoversUser2() {
        //Open site http://the-internet.herokuapp.com/hovers
        driver.get(HEROCU_APP_URL);
        Actions action = new Actions(driver);
        //Move to User1 icon
        WebElement we = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        //Move to User1 link, and click it
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"))).click().build().perform();
        //Chek page on "Page not found" error
        String actualPage = driver.findElement(By.xpath("/html/body/h1")).getText();
        String exceptedPage = "Not Found";
        Assert.assertEquals(actualPage, exceptedPage, "Not contains error 404");
        //Close driver
        driver.close();
    }

    @Test
    public void testHoversUser3() {
        //Open site http://the-internet.herokuapp.com/hovers
        driver.get(HEROCU_APP_URL);
        Actions action = new Actions(driver);
        //Move to User1 icon
        WebElement we = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        //Move to User1 link, and click it
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"))).click().build().perform();
        //Chek page on page "Not Found" error
        String actualPage = driver.findElement(By.xpath("/html/body/h1")).getText();
        String exceptedPage = "Not Found";
        Assert.assertEquals(actualPage, exceptedPage, "Not contains error 404");
        //Close driver
        driver.close();
    }
}



