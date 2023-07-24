package testing.page.drivers;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriversSetup {

    public static SelfHealingDriver driver;
    public static WebDriversSetup withChromeOptions() {
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("chrome.capabilities.unexpectedAlertBehavior", "ignore");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --incognito --disable-gpu --no-sandbox --disable-download-notification");
        options.addArguments("use-fake-ui-for-media-stream");
        // options.addArguments("--remote-allow-origins=*");
        //options.addArguments("use-fake-device-for-media-stream");
        WebDriver delegate = new ChromeDriver(options);
        driver = SelfHealingDriver.create(delegate);
        return new WebDriversSetup();
    }
        public static WebDriver on(String url) {
            driver.get(url);
            return driver;
        }

        public static WebDriver quit(){
            driver.quit();
            return driver;
        }

        public static WebDriversSetup testCameraAccess() {
            // Add your assertions or interactions as needed
            // Keep in mind that you won't be able to test the actual camera stream using Selenium WebDriver
            return new WebDriversSetup();
        }
    }