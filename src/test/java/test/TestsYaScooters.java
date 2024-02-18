package test;

import page.PageOrder;
import page.PageYaScooter;
import org.junit.Assert;
import org.junit.Test;

public class TestsYaScooters extends BaseSeleniumTest {


    @Test
    public void createOrderButtonUpTest() {
        PageOrder pageOrder = new PageYaScooter()
                .openOrderPageUp()
                .createOrderOneStep("Олег", "Петрович", "Ул.Танкистов.д 68 кв 22", "89626226694")
                .createOrderSecondStep("01.02.2024", "Хочу серый самокат ", 1);
        Assert.assertTrue(pageOrder.getModalHeader().isDisplayed());
        Assert.assertEquals("Заказ оформлен", pageOrder.getModalHeader());

    }

    @Test
    public void createOrderButtonDownTest() {
        PageOrder pageOrder = new PageYaScooter()
                .openOrderPageDown()
                .createOrderOneStep("Максим", "Кураторов", "Ул.Танкистов.д 68 кв 22", "89626226694")
                .createOrderSecondStep("01.02.2024", "Хочу серый самокат ", 1);
        Assert.assertTrue(pageOrder.getModalHeader().isDisplayed());
        Assert.assertEquals("Заказ оформлен", pageOrder.getModalHeader());
    }

    @Test
    public void checkUrlLogoScooter() {
        PageYaScooter pageYaScooter = new PageYaScooter();
        Assert.assertEquals("https://qa-scooter.praktikum-services.ru/", pageYaScooter.getUrlScooter());
    }

    @Test
    public void checkUrlLogoYandex() {
        PageYaScooter pageYaScooter = new PageYaScooter();
        String actual = pageYaScooter.openPageYandex().getUrlYandex(1);
        Assert.assertEquals("https://dzen.ru/?yredirect=true", actual);
    }


}