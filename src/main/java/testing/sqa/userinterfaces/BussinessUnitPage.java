package testing.sqa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BussinessUnitPage {

    public static final Target LOCATOR = Target.the("").locatedBy("");

    public static final Target BTN_BUSSINESS = Target.the("button to create a new bussiness unit")
            .locatedBy("//div[@class='tool-button add-button icon-tool-button']");
    public static final Target BTN_NEW_BUSSINESS_UNIT = Target.the("button to create a new bussiness unit")
            .locatedBy("//div[@class='s-TemplatedDialog ui-dialog-content ui-widget-content']/descendant:: input[1]");
}











