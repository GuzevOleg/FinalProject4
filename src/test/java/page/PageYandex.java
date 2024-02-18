package page;

public class PageYandex extends BaseSeleniumPage {

    public String getUrlYandex(int numberWindow) {
        String handle = driver.getWindowHandles().toArray()[numberWindow]
                .toString();
        driver.switchTo().window(handle);
        return driver.getCurrentUrl();
    }

}
