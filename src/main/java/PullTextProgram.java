
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PullTextProgram {
    /*
     * Main program that pulls a specific text from Folksam's website and prints it.
     * WARNING! Code is not very reliable and prone to errors from:
     * 1. Interacting with an element too early.
     * 2. ExpectedConditions not working the way I expect.
     * 3. User not having the correct version of chrome, correct version being 95.0.4638.69.
     */


    private String TEXT_FROM_SITE = "Wrong."; //The text that is to be pulled from the website, if it isn't pulled it prints "Wrong.".


    public static void main(String[] args) {
        //Runs the program when launched.
        PullTextProgram program = new PullTextProgram();
        program.run();
    }

    private void run() {
        /* Body of the program which:
         * 1. Gets a string from Folksam's website.
         * 2. Prints that string or "Wrong." if failure.
         */
        fetchText();
        System.out.println(TEXT_FROM_SITE);

    }

    private void fetchText() {
        /*
         * Collects a string from Folksam's website.
         */

        // Set up a webdriver, chrome driver v.95 in this case.
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Open up google.se and agree to demands.
        driver.get("https://www.google.se/");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        System.out.println(driver.findElement(By.xpath("//h1")).getText() + "here");

        //Enter "Folksam" into the google search bar and search.
        driver.findElement(By.name("q")).sendKeys("Folksam");
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))); //Warning! Wait function unreliable.
        driver.findElement(By.name("btnK")).click();

        //Press the link to Folksam's homepage and accept cookies.
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3")).click();
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();

        //Go to Folksam's webpage "Hemförsäkring".
        driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div[1]/div/div/div/ul/li[2]/a")).click();

        //Get the wanted string.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/section/div/div/div[2]/h1")));
        TEXT_FROM_SITE = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/section/div/div/div[2]/h1")).getText();


        //Stop using the chrome driver
        driver.quit();

    }

}
