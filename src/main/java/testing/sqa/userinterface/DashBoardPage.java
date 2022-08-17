package testing.sqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class DashBoardPage {

    public static final Target BTN_MEETING = Target.the("dropdown list meetings")
            .locatedBy("//i[@class='s-sidebar-icon fa fa-comments premium-feature']");
    public static final Target BTN_MEETINGS = Target.the("button to see the meetings")
            .locatedBy("//span[contains(text(),'Meetings')]");
    public static final Target BTN_ORGANIZATION =  Target.the("dropdown list organization")
            .locatedBy("//i[@class='s-sidebar-icon fa fa-comments premium-feature']");
    public static final Target BTN_BUSSINESS_UNIT = Target.the("button to see the bussiness unit")
            .locatedBy("//i[@class='s-sidebar-icon fa fa-sitemap']");

}
