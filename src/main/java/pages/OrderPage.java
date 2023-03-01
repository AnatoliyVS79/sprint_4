package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    WebDriver driver;

    // Принять куки
    private final By cookieButton = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    // Кнопка Заказать
    private final By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g']");
    // нижняя кнопка заказа
    private final By bottomButtonToOrder = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    // Поле ввести Имя
    private final By inputName = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // Поле ввести Фамилию
    private final By inputLastName = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // Поле ввести Адрес
    private final By inputAddress = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // Поле метро
    private final By fieldSabWay = By.className("select-search__input");
    // Откидная шторка с выбором Станции метро
    private final By metroStationList = By.className("select-search__row");
    // Поле ввода телефонного номера
    private final By inputPhoneNumber = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // Кнопка Далее
    private final By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    //  "Поле дата"
    private final By fieldOrderDate = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    // Ввод даты вручкую
    private final By deliveryDateEntry = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");

    // Окно календаря
    private final By fieldCalendar = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[7]");

    // "Срок аренды"
    private final By fieldRentalPeriod = By.className("Dropdown-arrow");
    //  "На сколько дней"
    private final By dropDawnList = By.className("Dropdown-option");
    // "Чёрный цвет сомоката"
    private final By blackColor = By.id("black");
    // "Серый цвет сомоката"
    private final By greyColor = By.id("grey");
    // Поле коментарий
    private final By comment = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // "Клик по кнопке заказать, оформленного заказа"
    private final By orderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    // // Кнопка Да
    private final By yesButton = By.xpath("//button[text()='Да']");
    // текст и номер заказа
    private final By orderText = By.className("Order_Text__2broi");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // метод клик по кнопке принятия куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // метод "Нажать кнопку Заказать"
    public void clickOrderButton() {
        driver.findElement(buttonOrder).click();
    }
    //метод "Нажать кнопку заказать в низу"
    public void clickBottomButtonToOrder() {
        driver.findElement(bottomButtonToOrder).click();
    }

    public void setFirstName(String firstName) {
        driver.findElement(inputName).sendKeys(firstName);
    }

    // метод "Ввести фамилию"
    public void setLastName(String lastName) {
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    // метод "Ввести адрес"
    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void clickSubwayField() {
        driver.findElement(fieldSabWay).click();
    }

    // метод "Ввести станцию метро"
    public void setSubwayStation(int index) {
        driver.findElements(metroStationList).get(index).click();
    }

    // метод "Ввода телефонного номера"
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }

    // метод "клик по кнопке далее"
    public void userInput(String firstName, String lastName, String address, int index, String phoneNumber) {
        clickCookieButton();
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        clickSubwayField();
        setSubwayStation(index);
        setPhoneNumber(phoneNumber);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }

    // метод " В Поле дата вводим вручную"
    public void setDateEntry(String date) {
        driver.findElement(deliveryDateEntry).sendKeys(date);
    }
    // метод "Поле дата"
    public void setOrderDate() {
        driver.findElement(fieldOrderDate).click();
    }

    // метод "Выбор даты"
    public void clickDateCalendar() {
        driver.findElement(fieldCalendar).click();
    }
    // "Срок аренды"
    public void clickRentalPeriod() {
        driver.findElement(fieldRentalPeriod).click();
    }

    // метод "На сколько дней"
    public void clickDayCount(int index) {
        driver.findElements(dropDawnList).get(index).click();
    }

    // метод "Чёрный цвет сомоката"
    public void setBlackColor() {
        driver.findElement(blackColor).click();
    }

    // метод "Серый цвет сомоката"
    public void setGreyColor() {
        driver.findElement(greyColor).click();
    }

    // метод "Коминтарий"
    public void setComment(String comments) {
        driver.findElement(comment).sendKeys(comments);
    }

    // метод Заполнение форм , "Клик по кнопке заказать, оформленного заказа"
    public void formFieldFilling(String date, int index, String comments) {
        setDateEntry(date);
        clickRentalPeriod();
        clickDayCount(index);
        setBlackColor();
        setComment(comments);
        driver.findElement(orderButton).click();
    }
    // метод Заполнение форм , "Клик по кнопке заказать, оформленного заказа"
    public void formFieldFillingWithCalendar(int index, String comments) {
        setOrderDate();
        clickDateCalendar();
        clickRentalPeriod();
        clickDayCount(index);
        setBlackColor();
        setComment(comments);
        driver.findElement(orderButton).click();
    }

    // Кнопка Да
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    // Метод возврата текста и номера заказа
    public void getOrderTex() {
        driver.findElement(orderText).getText();
    }

}
