import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HtmlFindElements {
    WebDriver driver;
    private static final String MY_SITE = "C:\\Users\\Бубята\\IdeaProjects\\HerokuApp\\src\\test\\resources\\Test.html";

    @BeforeMethod
    public void initMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void htmlFindElementTable() {
        driver.get(MY_SITE);
        String actualResult = driver.findElement(By.xpath("//*[@id=\"table01\"]/tbody/tr[1]/th[1]")).getText();
        Assert.assertEquals(actualResult, "Firstname");
        driver.quit();
    }

    @Test
    public void htmlFindElementInput() {
        driver.get(MY_SITE);
        WebElement emailField = driver.findElement(By.name("email"));
        String actualResults = emailField.getText();
        Assert.assertEquals(actualResults, "Enter your email:");
        driver.quit();
    }

    @Test
    public void htmlFindElementCheckBox() {
        driver.get(MY_SITE);
        String actualResult = driver.findElement(By.xpath("//*[@id=\"form2\"]/label[1]")).getText();
        Assert.assertEquals(actualResult, "I live in apartment №1");
        driver.quit();
    }

    @Test
    public void htmlFindElementDropBox() {
        driver.get(MY_SITE);
        Select select = new Select(driver.findElement(By.id("name")));
        select.selectByVisibleText("Tom");
        String actualResult = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, "Tom");
        driver.quit();
    }

    @Test
    public void htmlFindElementButton() {
        driver.get(MY_SITE);
        String actualResult = driver.findElement(By.id("ring")).getText();
        Assert.assertEquals(actualResult, "The ring!");
        driver.quit();
    }

    @Test
    public void htmlFindElementImg() {
        driver.get(MY_SITE);
        boolean actualResult = driver.findElement(By.xpath("/html/body/img")).isDisplayed();
        Assert.assertTrue(actualResult);
        driver.quit();
    }
    @Test
    public void htmlFindElementLink() {
        driver.get(MY_SITE);
        String actualResult = driver.findElement(By.xpath("/html/body/a")).getText();
        Assert.assertEquals(actualResult, "Visit Google for search!");
        driver.quit();
    }

}
