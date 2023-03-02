package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.component.ComponentElements;

public class MainPage {
    WebDriver driver;
    // Статус заказа
    private final By buttonOrderStatus = By.className("Header_Link__1TAG7");
    // Выведите номер заказа
    private final By inputOrderNum = By.xpath("//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    // Кнопка Go
    private final By buttonSearch = By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    //список вопросов о важном
    private final By questionsList = By.xpath("//div[@class='accordion__button']");
    //блок ответов о важном
    private final By answerBlock = By.xpath("//div[@class='accordion__panel']");
    private final ComponentElements logo;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        logo = new ComponentElements(driver);
    }

    // метод Клик кнопки Статус заказа
    public MainPage clickOrderStatusButton() {
        driver.findElement(buttonOrderStatus).click();
        return this;
    }

    // метод Выведите номер заказа
    public MainPage setOrderNum(String orderNum) {
        driver.findElement(inputOrderNum).sendKeys(orderNum);
        return this;
    }

    // метод клик кнопки Go
    public TrackOrderPage clickSearchButton() {
        driver.findElement(buttonSearch).click();
        return new TrackOrderPage(driver);
    }

    //вызов ответа на вопрос
    public void clickOnQuestionByIndex(int index) {
        driver.findElements(questionsList).get(index).click();

    }

    //возвращение текста ответа
    public String findAnswerByIndex(int index) {
        WebElement element = driver.findElement(questionsList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        clickOnQuestionByIndex(index);
        return driver.findElements(answerBlock).get(index).getText();
    }
}
