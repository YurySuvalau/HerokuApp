import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown {
    WebDriver driver;
    private static final String HEROCU_APP_URL = "http://the-internet.herokuapp.com/dropdown";

    @BeforeMethod
    public void initMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void testMethod() {

        driver.get(HEROCU_APP_URL);
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 2");
        String selectedText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedText, "Option 2");
        List<WebElement> options = dropdown.getOptions();
        for (WebElement element : options){
            System.out.println(element.getText());
        }
        driver.quit();
    }
}
