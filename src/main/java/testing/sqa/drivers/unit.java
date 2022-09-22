package testing.sqa.drivers;

import cucumber.runtime.junit.Assertions;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;

@RunWith(SerenityRunner.class)
public class unit {

    @Managed
    WebDriver driver;



    @Test
    public void mike(){
        driver.get("http://watir.com/examples/shadow_dom.html");
        WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
        SearchContext shadowRoot = shadowHost.get.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("#shadow_content"));

        Assertions.assertEquals("some text", shadowContent.getText());

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = (WebElement) jse.executeScript("return document.querySelector(\"body > ntp-app\").shadowRoot.querySelector(\"#realbox\").shadowRoot.querySelector(\"#input\")");
        element.click();
    }
}
