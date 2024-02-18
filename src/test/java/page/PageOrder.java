package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageOrder extends BaseSeleniumPage {
    /**
     * Имя
     */
    @FindBy(xpath = ".//input[@placeholder= '* Имя']")
    private WebElement name;
    /**
     * Фамилия
     */
    @FindBy(xpath = ".//input[@placeholder= '* Фамилия']")
    private WebElement surname;
    /**
     * Адрес
     */
    @FindBy(xpath = ".//input[@placeholder= '* Адрес: куда привезти заказ']")
    private WebElement address;
    /**
     * Телефон
     */
    @FindBy(xpath = ".//input[@placeholder= '* Телефон: на него позвонит курьер']")
    private WebElement phoneNumber;
    /**
     * Список станций метро
     */
    @FindBy(xpath = ".//div[@class='select-search__select']//ul//li")
    private List<WebElement> metroStations;
    /**
     * Метро
     */
    @FindBy(xpath = ".//input[@placeholder= '* Станция метро']")
    private WebElement metro;
    /**
     * Кнопка Далее
     */
    @FindBy(xpath = "//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement nextButton;
    /**
     * Календарь
     */
    @FindBy(xpath = ".//input[@placeholder= '* Когда привезти самокат']")
    private WebElement calendar;
    /**
     * Срок аренды
     */
    @FindBy(xpath = "//div[@class='Dropdown-placeholder']")
    private WebElement rentalPeriod;
    /**
     * Варианты срока аренды
     */
    @FindBy(xpath = "//div[@class='Dropdown-option']")
    private List<WebElement> rentalPeriodOptions;
    /**
     * Чек бокс с вариантом серый самокат
     */
    @FindBy(id = "grey")
    private WebElement colorScooter;
    /**
     * Комментарий для курьера
     */
    @FindBy(xpath = ".//input[@placeholder= 'Комментарий для курьера']")
    private WebElement comments;
    /**
     * Кнопка заказа
     */
    @FindBy(xpath = "(//button[text() ='Заказать'])[2]")
    private WebElement buttonOrder;
    /**
     * Кнопка подтверждения заказа
     */
    @FindBy(xpath = "//button[text() ='Да']")
    private WebElement buttonOrderConfirmation;

    @FindBy(xpath = ".//div[@class ='Order_ModalHeader__3FDaJ']")
    private WebElement modalHeader;

    public PageOrder() {
        PageFactory.initElements(driver, this);
    }

    public PageOrder createOrderOneStep(String name, String surname, String address, String phoneNumber) {
        this.name.sendKeys(name);
        this.surname.sendKeys(surname);
        this.address.sendKeys(address);
        metro.click();
        metroStations.get(2).click();
        this.phoneNumber.sendKeys(phoneNumber);
        nextButton.click();
        return this;
    }

    public PageOrder createOrderSecondStep(String date, String comment, int period) {
        calendar.sendKeys(date, Keys.ENTER);
        rentalPeriod.click();
        rentalPeriodOptions.get(period).click();
        colorScooter.click();
        comments.sendKeys(comment);
        buttonOrder.click();
        buttonOrderConfirmation.click();
        return this;
    }

    public String getModalHeaderText() {
        return modalHeader.getText();
    }

    public WebElement getModalHeader() {
        return modalHeader;
    }
}
