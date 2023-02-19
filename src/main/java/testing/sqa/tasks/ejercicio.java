package testing.sqa.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import testing.sqa.drivers.WebDriversSetup;

import static testing.sqa.drivers.WebDriversSetup.driver;

public class ejercicio {


    private static final String URL = "https://demo.serenity.is/Account/Login/?ReturnUrl=%2F";

    public static void main(String[] args) throws InterruptedException {

//        WebDriversSetup.withChromeOptions();
//        WebDriversSetup.on(URL);
        WebDriverManager.chromedriver().setup();
        driver.get(URL);
        Thread.sleep(3000);
        WebDriversSetup.quit();
    }
}
