package testing.page.interactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelfHealingTest {
   /* protected static SelfHealingDriver driver;

    public static void  withChromeOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        WebDriver delegate = new ChromeDriver(options);
        driver = SelfHealingDriver.create(delegate);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1200,800));
    }

    @AfterEach
    public void afterAll(){
        if (driver != null){
            driver.quit();
        }
    }*/

}
