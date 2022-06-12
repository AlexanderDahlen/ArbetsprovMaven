package arbetsprovPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchFolksam {
    //This is a class based on a google page after having searched for Folksam

    private WebDriver driver;
    private By folksamHomepageLink = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3");

    public GoogleSearchFolksam(WebDriver driver) {
        this.driver = driver;
    }

    public void pressLinkFolksamHomePage() {
        //Clicks a link to Folksam's home page
        driver.findElement(folksamHomepageLink).click();
    }

}