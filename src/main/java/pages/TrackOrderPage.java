package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.component.ComponentElements;

public class TrackOrderPage {
    WebDriver driver;

    private final By containerOrderNotFound = By.className("Track_NotFound__6oaoY");

    private final ComponentElements logo;
    public TrackOrderPage(WebDriver driver){
        this.driver = driver;
        logo = new ComponentElements(driver);
    }
    public boolean isContainerOrderNotFoundVisible(){
        return driver.findElement(containerOrderNotFound).isDisplayed();
    }
}
