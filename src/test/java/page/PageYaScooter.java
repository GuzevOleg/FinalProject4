package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageYaScooter extends BaseSeleniumPage {
    private final static String BASE_URL = "https://qa-scooter.praktikum-services.ru";
    /**
     * Элемент к которому необходимо переместиться на странице для получения вопроса
     */
    @FindBy(css = ".accordion")
    private WebElement questions;
    /**
     * Список вопросов
     */
    @FindBy(xpath = ".//div[@class='accordion__item']")
    private List<WebElement> listQuestions;
    /**
     * Список ответов
     */
    @FindBy(xpath = ".//div[@class='accordion__panel']")
    private List<WebElement> listAnswers;
    /**
     * Кнопка заказа наверху
     */
    @FindBy(className = "Button_Button__ra12g")
    private WebElement orderButtonUp;
    /**
     * Кнопка заказа снизу
     */
    @FindBy(className = "Button_Button__ra12g")
    private WebElement orderButtonDown;
    /**
     * ссылка на Яндекс Самокат
     */
    @FindBy(xpath = ".//a[@class ='Header_LogoScooter__3lsAR']")
    private WebElement urlScooter;
    /**
     * ссылка на главную страницу яндекс
     */
    @FindBy(className = "Header_LogoYandex__3TSOI")
    private WebElement urlYandex;

    public PageYaScooter() {
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }


    public String getAnswer(int question) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questions);
        listQuestions.get(question).click();
        return listAnswers.get(question).getText();
    }

    public PageOrder openOrderPageUp() {
        orderButtonUp.click();
        return new PageOrder();
    }

    public PageOrder openOrderPageDown() {
        orderButtonDown.click();
        return new PageOrder();
    }

    public String getUrlScooter() {
        orderButtonUp.click();
        urlScooter.click();
        return driver.getCurrentUrl();
    }

    public PageYandex openPageYandex() {
        urlYandex.click();
        return new PageYandex();
    }

}
