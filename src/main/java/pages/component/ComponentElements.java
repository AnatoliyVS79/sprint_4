package pages.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComponentElements {
    private final WebDriver driver;
    // Логотип Яндекс Самокат
    private final By containerLogo = By.className("Header_Logo__23yGT");

    // Кнопка Яндекс, ведёт на страницу Дзэн
    private final By buttonLogoYandex = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[1]/a[1]/img");
    // Кнопка Самокат, ведёт на стартовую страницу "Самокат на пару дней"
    private final By scooterButtonHome = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[1]/a[2]/img");
    // Кнопка заказать
    private final By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g']");

    public ComponentElements(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogo() {
        driver.findElement(containerLogo).click();
    }

    public void clickHeaderLogoYandex() {
        driver.findElement(buttonLogoYandex).click();
    }

    public void clickScooterButtonHome() {
        driver.findElement(scooterButtonHome).click();
    }

    //метод "Клик по кнопке Заказать"
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

}
