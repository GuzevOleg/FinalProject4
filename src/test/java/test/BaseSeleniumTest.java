package test;

import page.BaseSeleniumPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSeleniumTest {

    protected WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BaseSeleniumPage.setDriver(driver);
    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
