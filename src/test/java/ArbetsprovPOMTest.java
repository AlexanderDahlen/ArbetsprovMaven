import arbetsprovPages.FolksamHomeInsurancesPage;
import arbetsprovPages.FolksamHomePage;
import arbetsprovPages.GoogleHomePage;
import arbetsprovPages.GoogleSearchFolksam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ArbetsprovPOMTest {
    /*
     * A test that compares a sting taken from a website with a string of what it is supposed to be.
     */

    private final String EXPECTED_STRING = "Sveriges populäraste hemförsäkring"; //What we expect the siring from Hemförsäkringar to be.
    private final String FOLKSAM = "Folksam"; //String to enter into the google search bar

    private WebDriver driver;

    //Webpages used
    private GoogleHomePage objGoogleHomePage;
    private GoogleSearchFolksam objGoogleSearchFolksam;
    private FolksamHomePage objFolksamHomePage;
    private FolksamHomeInsurancesPage objFolksamHomeInsurancesPage;


    @BeforeTest
    public void setUp() {
        //Sets up the web driver
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe"); //Chromedriver v95
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.google.se/");
    }

    @Test
    public void isStringFromFolksamAsExpected() {
        //Google home page navigation
        objGoogleHomePage = new GoogleHomePage(driver);
        objGoogleHomePage.acceptCookies();
        objGoogleHomePage.googleSearchString(FOLKSAM);

        //Google search page navigation
        objGoogleSearchFolksam = new GoogleSearchFolksam(driver);
        objGoogleSearchFolksam.pressLinkFolksamHomePage();

        //Folksam homepage navigation
        objFolksamHomePage = new FolksamHomePage(driver);
        objFolksamHomePage.acceptCookies();
        objFolksamHomePage.clickInsurancePicLink();

        //Folksam home insurances webpage navigation
        objFolksamHomeInsurancesPage = new FolksamHomeInsurancesPage(driver);
        String pulledText = objFolksamHomeInsurancesPage.getTargetText();

        //Assertion
        Assert.assertEquals(pulledText, EXPECTED_STRING);

    }

    @AfterTest
    private void shutDown(){
        driver.quit();
    }
}
