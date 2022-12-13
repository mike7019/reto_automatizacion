package testing.page.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverRemoteBrowser {

    public static WebDriver driver;

    public static DriverRemoteBrowser chromeHisBrowserWeb() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        return new DriverRemoteBrowser();
    }

    public static DriverRemoteBrowser firefoxHisBrowserWeb()
    {
        driver = new FirefoxDriver();
        return new DriverRemoteBrowser();
    }

    public static DriverRemoteBrowser internetExplorerHisBrowserWeb()
    {
        driver = new InternetExplorerDriver();
        return new DriverRemoteBrowser();
    }

    public static WebDriver on(String url) {
        driver.get(url);
        return driver;
    }


}
