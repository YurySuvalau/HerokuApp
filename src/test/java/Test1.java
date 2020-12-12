import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver driver;

    @BeforeMethod
    public void initMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();

    }

    @Test
    public void testMethod() {


        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("20");
        inputField.getText();
        String actualTextFromInputField = inputField.getAttribute("value");
        Assert.assertEquals(actualTextFromInputField, "20");
        inputField.sendKeys(Keys.ARROW_DOWN);
        String actualTextFromInputField1 = inputField.getAttribute("value");
        Assert.assertEquals(actualTextFromInputField1, "19");
        inputField.sendKeys(Keys.ARROW_DOWN);
        String actualTextFromInputField2 = inputField.getAttribute("value");
        Assert.assertEquals(actualTextFromInputField2, "18");
        inputField.clear();
        String actualTextFromInputField3 = inputField.getAttribute("value");
        Assert.assertEquals(actualTextFromInputField3, "");

        driver.quit();
    }
}
