import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lesson10 {
    WebDriver driver;
    private static final String HEROCU_APP_URL_CONTEXT_MENU = "http://the-internet.herokuapp.com/context_menu";
    private static final String HEROCU_APP_URL_DYNAMIC_CONTROL = "http://the-internet.herokuapp.com/dynamic_controls";
    private static final String HEROCU_APP_UPLOAD_FILE = "http://the-internet.herokuapp.com/upload";
    private static final String HEROCU_APP_URL_IFRAME = "http://the-internet.herokuapp.com/iframe";

    private static final String WHITE_BOX = "//*[@id='hot-spot']";
    private static final String CHECKBOX = "//*[@id='checkbox']";
    private static final String BUTTON_REMOVE_ADD = "//*[@id='checkbox-example']/button";
    private static final String INPUT = "//*[@id=\"input-example\"]/input";
    private static final String MESSAGE_CHECKBOX_IS_GONE = "//*[@id='message']";
    private static final String BUTTON_ENABLE_INPUT = "//*[@id='input-example']/button";
    private static final By MESSAGE_INPUT_ENABLED = By.xpath("//*[@id='message']");
    private static final String FILE_UPLOAD_BUTTON = "file-upload";
    private static final String SUBMIT_UPLOAD_FILE_BUTTON = "file-submit";
    private static final String UPLOAD_FILE_NAME = "uploaded-files";
    private static final String CHECK_TEXT_IN_IFRAME = "tinymce";

    @BeforeMethod
    public void initMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void contextMenuTest() {
        //open page http://the-internet.herokuapp.com/context_menu
        driver.get(HEROCU_APP_URL_CONTEXT_MENU);
        //find dedicated box on page
        WebElement whiteBox = driver.findElement(By.xpath(WHITE_BOX));
        //Click on box by right button
        Actions rightClick = new Actions(driver);
        rightClick.contextClick(whiteBox).build().perform();
        //Set waiter on alert message
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait when alert is displayed
        wait.until(ExpectedConditions.alertIsPresent());
        //get text from alert message
        String actualResult = driver.switchTo().alert().getText();
        //close alert message
        driver.switchTo().alert().dismiss();
        //Check text on expected
        Assert.assertEquals(actualResult, "You selected a context menu");
    }

    @Test
    public void dynamicControl() {
        //open page http://the-internet.herokuapp.com/dynamic_controls
        driver.get(HEROCU_APP_URL_DYNAMIC_CONTROL);
        //find checkbox
        driver.findElement(By.xpath(CHECKBOX));
        //find button "Remove/add", and click it
        driver.findElement(By.xpath(BUTTON_REMOVE_ADD)).click();
        //wait when message "It's gone!" is displayed
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_CHECKBOX_IS_GONE)));
        // checkbox displayed verification
        Assert.assertTrue(driver.findElement(By.xpath(MESSAGE_CHECKBOX_IS_GONE)).isDisplayed());
        //Check input field is disabled
        Assert.assertFalse(driver.findElement(By.xpath(INPUT)).isEnabled());
        //find button "Enable" and click it
        driver.findElement(By.xpath(BUTTON_ENABLE_INPUT)).click();
        //wait when message "It's enabled!" is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_INPUT_ENABLED));
        //chek input field is enabled
        Assert.assertTrue(driver.findElement(By.xpath(INPUT)).isEnabled());
    }

    @Test
    public void uploadFileTest() {
        //open page http://the-internet.herokuapp.com/upload
        driver.get(HEROCU_APP_UPLOAD_FILE);
        //find button "open file", and send absolute path to upload file
        driver.findElement(By.id(FILE_UPLOAD_BUTTON)).sendKeys("C:\\Users\\Бубята\\IdeaProjects\\HerokuApp\\src\\test\\resources\\Lesson_4.jpg");
        //find and click button "Upload"
        driver.findElement(By.id(SUBMIT_UPLOAD_FILE_BUTTON)).click();
        //Chek uploaded file name
        Assert.assertEquals(driver.findElement(By.id(UPLOAD_FILE_NAME)).getText(), "Lesson_4.jpg");
    }

    @Test
    public void iFrameTest() {
        //open page
        driver.get(HEROCU_APP_URL_IFRAME);
        //switch to iFrame
        driver.switchTo().frame(0);
        //check text in iFrame
        Assert.assertEquals(driver.findElement(By.id(CHECK_TEXT_IN_IFRAME)).getText(), "Your content goes here.");
    }

    @AfterMethod(alwaysRun = true)
    public void driverQuit() {
        driver.quit();
    }
}
