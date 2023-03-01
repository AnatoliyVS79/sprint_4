import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.component.ComponentElements;

public class AdditionalTests {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }
    @Test
    public void yandexButton(){
        ComponentElements yandexElement = new ComponentElements(driver);
        yandexElement.clickHeaderLogoYandex();
    }
    @Test
    public void scooterButton(){
        ComponentElements scooterElement = new ComponentElements(driver);
        scooterElement.clickScooterButtonHome();
    }



    @After
    public void teardown() {
        driver.quit();
    }
}
