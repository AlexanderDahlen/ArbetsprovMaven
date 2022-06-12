package arbetsprovPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {


    private WebDriver driver;
    private By acceptCookiesButton = By.xpath("//*[@id=\"L2AGLb\"]/div");
    private By searchbar = By.name("q");
    private By searchButton = By.name("btnK");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void acceptCookies() {
        //Accepts cookies by pressing a button that says "I agree".
        driver.findElement(acceptCookiesButton).click();
    }

    public void googleSearchString(String string) {
        //Takes a string, puts it in the search bar, then executes a google search.
        enterStringIntoSearchbar(string);
        executeSearch();
    }

    private void enterStringIntoSearchbar(String string) {
        //Takes a string and puts it in the search bar. NOTE! Does not execute a search!
        driver.findElement(searchbar).sendKeys(string);
    }

    private void executeSearch() {
        //The equivalent of pressing enter into the search bar.
        //This because the driver sometimes can't find the button.
        //driver.findElement(searchButton).click();
        driver.findElement(searchbar).sendKeys(Keys.ENTER);
    }



}
