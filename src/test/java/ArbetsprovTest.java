import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ArbetsprovTest {

    private final String EXPECTED_STRING = "Sveriges populäraste hemförsäkring"; //What we expect the siring from Hemförsäkringar to be.

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Sets up the web driver.

        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe"); //Chrome Driver version 95.0.4638.69.
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void isStringFromFolksamAsExpected() {
        //fetches a string from Folksam's home insurances webpage and compares it to an expected string.

        //Open up google.se and agree to cookies.
        driver.get("https://www.google.se/");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        //Enter "Folksam" into the google search bar and search.
        driver.findElement(By.name("q")).sendKeys("Folksam");
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))); //Warning! Wait function unreliable.
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //Press the link to Folksam's homepage and accept cookies.
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3")).click();
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();

        //Go to Folksam's webpage "Hemförsäkring".
        driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div[1]/div/div/div/ul/li[2]/a")).click();

        //Get the wanted string.
        String pulledText = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/section/div/div/div[2]/h1")).getText();

        //Check if the string is what is expected
        //System.out.println(pulledText);
        Assert.assertEquals(pulledText, EXPECTED_STRING);

    }

    @AfterTest
    public void shutDown() {
        //Shut off the driver
        driver.quit();
    }


}
