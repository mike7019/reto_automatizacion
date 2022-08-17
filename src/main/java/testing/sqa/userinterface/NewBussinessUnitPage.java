package testing.sqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class NewBussinessUnitPage {

    public static final Target TXT_BUSSINESS_NAME = Target.the("field for the bussiness unit name")
            .locatedBy("//input[@class='editor s-Serenity-StringEditor s-StringEditor required']");
    public static final Target TXT_PARENT_UNIT = Target.the("div with the parent unit list")
            .locatedBy("//div[@class='field ParentUnitId']//div");
    public static final Target LST_PARENT_UNIT = Target.the("the parent unit list")
            .locatedBy("//ul[@id='select2-results-1']");

    public static final Target BTN_SAVE_UNIT = Target.the("the button to save changes")
            .locatedBy("//div[@class='tool-button save-and-close-button icon-tool-button']");

}
