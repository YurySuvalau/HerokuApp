import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class htmlFindElements {
    WebDriver driver;
    private static final String Mysite = "C:\\Users\\Бубята\\IdeaProjects\\HerokuApp\\src\\test\\resources\\Test.html";

    @BeforeMethod
    public void initMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void htmlFindElementTable() {
        driver.get(Mysite);
        String actualResult = driver.findElement(By.id("table01")).getAttribute("id");
        Assert.assertEquals(actualResult, "table01");
        driver.quit();
    }

    @Test
    public void htmlFindElementInput() {
        driver.get(Mysite);
        String actualResult = driver.findElement(By.name("email")).getAttribute("name");
        Assert.assertEquals(actualResult, "email");
        driver.quit();
    }

    @Test
    public void htmlFindElementCheckBox() {
        driver.get(Mysite);
        String actualResult = driver.findElement(By.xpath("//*[@id=\"form2\"]/label[1]")).getText();
        Assert.assertEquals(actualResult, "I live in apartment №1");
        driver.quit();
    }

    @Test
    public void htmlFindElementDropBox() {
        driver.get(Mysite);
        Select select = new Select(driver.findElement(By.id("name")));
        select.selectByVisibleText("Tom");
        String actualResult = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, "Tom");
        driver.quit();
    }

    @Test
    public void htmlFindElementButton() {
        driver.get(Mysite);
        String actualResult = driver.findElement(By.id("ring")).getText();
        Assert.assertEquals(actualResult, "The ring!");
        driver.quit();
    }

    @Test
    public void htmlFindElementImg() {
        driver.get(Mysite);
        String actualResult = driver.findElement(By.xpath("/html/body/img")).getAttribute("alt");
        Assert.assertEquals(actualResult, "The house");
        driver.quit();
    }
    @Test
    public void htmlFindElementLink() {
        driver.get(Mysite);
        String actualResult = driver.findElement(By.xpath("/html/body/a")).getText();
        Assert.assertEquals(actualResult, "Visit Google for search!");
        driver.quit();
    }

}
