package testing.sqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target TXT_USER = Target.the("Text field for user")
            .locatedBy("//input[@name='Username']");
    public static final Target TXT_PASSWORD = Target.the("Text field for password")
            .locatedBy("//input[@name='Password']");
    public static final Target BTN_LOGIN = Target.the("button to log in")
            .locatedBy("//button[contains(text(),'Sign In')]");
    public static final Target LBL_VALIDATION = Target.the("text to validate")
            .locatedBy("//h1[contains(text(),'Dashboard')]");

}
