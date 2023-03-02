import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.OrderPage;

public class ScooterTest {
    private WebDriver driver;
    private final String firstName = "Иван";
    private final String lastName = "Иванов";
    private final String address = "Ивантеевская 19";
    private final int subwayStation = 0;
    private final String phoneNumber = "+79255730700";
    private final String date = "10.03.2023";
    private final int index = 0;
    private final String comments = "Перезвонить";
    private final String actualOrder = "Номер заказа:";

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void fillingForms() {
        OrderPage forWhom = new OrderPage(driver);
        forWhom.clickOrderButton();
        forWhom.userInput(firstName, lastName, address, subwayStation, phoneNumber);
        forWhom.formFieldFilling(date, index, comments);
        forWhom.clickYesButton();
        Assert.assertNotNull(actualOrder);
    }

    @Test
    public void fillingFormsWithCalendar() {
        OrderPage forWhom = new OrderPage(driver);
        WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        forWhom.clickBottomButtonToOrder();
        forWhom.userInput(firstName, lastName, address, subwayStation, phoneNumber);
        forWhom.formFieldFillingWithCalendar(index, comments);
        forWhom.clickYesButton();
        Assert.assertNotNull(actualOrder);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
