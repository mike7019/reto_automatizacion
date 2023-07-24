package testing.page.drivers;

public class Hola {

    public static void main(String[] args) throws InterruptedException {
        WebDriversSetup.withChromeOptions();
        WebDriversSetup.on("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);
    }

}
