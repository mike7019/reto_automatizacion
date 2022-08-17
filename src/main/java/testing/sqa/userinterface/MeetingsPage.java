package testing.sqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class MeetingsPage {

    public static final Target LBL_TEXT = Target.the("text to validate").locatedBy("//div[@class='title-text']");

    public static final Target BTN_NEW_MEETING = Target.the("button new meeting").locatedBy("//div[@class='tool-button add-button icon-tool-button']");
    public static final Target TXT_MEETING_NAME = Target.the("meeting name to validate").locatedBy("//div[@class='slick-cell l1 r1']/a");

    public static final Target LBL_USER_VALIDATION = Target.the("user validate").locatedBy("//span[@class='slick-column-name']");


}
