package testing.page.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import testing.page.drivers.WebDriversSetup;


public class ShadowDOMSelector {

    static int secs = 5;
    private static final String SHADOWDOM = "https://qaboxletstestcypresspracticesite.netlify.app/shadowdom";

    public static void main(String[] args) {

        WebDriversSetup.withChromeOptions();
        WebDriversSetup.on(SHADOWDOM);

        WebElement button = WebDriversSetup.driver.findElement(By.xpath("//button[@onclick]"));
        button.click();
        JavascriptExecutor js = (JavascriptExecutor) WebDriversSetup.driver;
        WebElement text = (WebElement) js.executeScript("element = document.querySelector('#shadowHost'').shadowRoot.querySelector('#name')");
        text.sendKeys("bibozon");
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriversSetup.quit();


    }

}
