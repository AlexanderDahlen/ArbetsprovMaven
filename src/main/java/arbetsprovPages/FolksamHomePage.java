package arbetsprovPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FolksamHomePage {

    private WebDriver driver;
    private By acceptCookiesButton = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"); //Button on cookies prompt, "Accept cookies".
    private By homeInsurancesPic = By.xpath("//*[@id=\"main\"]/section[1]/div[1]/div/div/div/ul/li[2]/a"); //Hardcoded (copied xpath from inspect elements).

    public FolksamHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        //Accepts Folksam's cookies by clicking an accept cookies button.

        driver.findElement(acceptCookiesButton).click();
    }

    public void clickHomeInsurancePicLink() {
        //Clicks home insurances picture, which activates a link to home insurances.

        driver.findElement(homeInsurancesPic).click();
    }


}
