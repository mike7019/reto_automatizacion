package testing.page.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static testing.page.drivers.WebDriversSetup.driver;


public class Prueba {


    public static void main(String[] args) throws InterruptedException {

        try {
            WebDriversSetup.withChromeOptions();
            WebDriversSetup.on("http://127.0.0.1:5500/src/prueba.html");
            Thread.sleep(2000);
            new Actions(driver)
                    .moveToElement(driver.findElement(By.xpath("//input[@placeholder='york']")))
                    .click()
                    .sendKeys("search")
                    .build()
                    .perform();


//            driver.findElement(By.xpath("//input[@placeholder='name']")).sendKeys("Juan");
//            driver.findElement(By.xpath("//input[@placeholder='lastname']")).sendKeys("Puerta");
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(2000);
            WebDriversSetup.quit();

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
