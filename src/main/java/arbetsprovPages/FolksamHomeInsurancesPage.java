package arbetsprovPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FolksamHomeInsurancesPage {

    private WebDriver driver;
    private By targetText = By.xpath("//*[@id=\"main\"]/div[2]/div[1]/section/div/div/div[2]/h1"); //Hardcoded (copied xpath from inspect elements).

    public FolksamHomeInsurancesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTargetText() {
        //Takes a string of note from the webpage, which should say "Sveriges populäraste hemförsäkring".

        return driver.findElement(targetText).getText();
    }
}
