package testing.sqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class WebDriversSetup {
    public static WebDriver driver;
    public static WebDriversSetup withChromeOptions() {
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("chrome.capabilities.unexpectedAlertBehavior", "ignore");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --incognito --disable-gpu --no-sandbox --disable-download-notification");

        driver = new ChromeDriver(options);
        return new WebDriversSetup();
    }
    public static WebDriversSetup withFirefoxOptions() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.driver","Firefox");
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("gecko.capabilities.unexpectedAlertBehavior", "ignore");

        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --incognito --disable-gpu --no-sandbox --disable-download-notification");


        driver = new FirefoxDriver(options);
        return new WebDriversSetup();
    }

    public static WebDriversSetup withEdgeOptions() {
        WebDriverManager.edgedriver().setup();

        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("gecko.capabilities.unexpectedAlertBehavior", "ignore");

        EdgeOptions options = new EdgeOptions();


        driver = new EdgeDriver();
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
}
