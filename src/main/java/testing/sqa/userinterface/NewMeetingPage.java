package testing.sqa.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class NewMeetingPage {

    public static final Target TXT_MEETING_NAME = Target.the("field for the meeting name")
            .locatedBy("//input[@id='Serenity_Pro_Meeting_MeetingDialog10_MeetingName']");
    public static final Target TXT_MEETING_TYPE = Target.the("dropdown list for the meeting type")
            .locatedBy("//div[@id='s2id_Serenity_Pro_Meeting_MeetingDialog10_MeetingTypeId']");
    public static final Target LST_MEETING_TYPE = Target.the("options from the meeting type")
            .locatedBy("//ul[@id='select2-results-6']");
    public static final Target OPTION_SELECT = Target.the("")
            .locatedBy("//ul//div[contains(text(),'{0}')]//ancestor::li");
    public static final Target TXT_START_DATE = Target.the("field for the date")
            .locatedBy("//input[@id='Serenity_Pro_Meeting_MeetingDialog10_StartDate']");
    public static final Target TXT_START_HOUR = Target.the("start hour to choose")
            .locatedBy("(//i[@class='inplace-button inplace-now'])[1]");
    public static final Target TXT_END_DATE = Target.the("end date field")
            .locatedBy("//input[@id='Serenity_Pro_Meeting_MeetingDialog10_EndDate']");
    public static final Target TXT_END_HOUR = Target.the("end hour to choose")
            .locatedBy("(//i[@class='inplace-button inplace-now'])[2]");
    public static final Target TXT_LOCATION = Target.the("location to select")
            .locatedBy("//div[@id='s2id_Serenity_Pro_Meeting_MeetingDialog10_LocationId']");
    public static final Target LST_LOCATION_OPTIONS = Target.the("options from the location list")
            .locatedBy("//ul[@id='select2-results-7']");
    public static final Target TXT_ORGANIZED_BY = Target.the("location to select")
            .locatedBy("//div[@id='s2id_Serenity_Pro_Meeting_MeetingDialog10_OrganizerContactId']");
    public static final Target LST_ORGANIZED_BY = Target.the("select Organized By")
            .locatedBy("//ul[@id='select2-results-9']");
    public static final Target TXT_ATENDEE_LIST = Target.the("attendee list to choose")
            .locatedBy("//div[@id='s2id_autogen11']");
    public static final Target LST_ATENDEE_LIST = Target.the("attendee list options")
            .locatedBy("//ul[@id='select2-results-12']");
    public static final Target TXT_MEETING_NUMBER = Target.the("meeting number label")
            .locatedBy("//input[@name='MeetingNumber']");
    public static final Target TXT_UNIT = Target.the("unit input")
            .locatedBy("//div[@id='s2id_Serenity_Pro_Meeting_MeetingDialog10_UnitId']");
    public static final Target LST_UNIT = Target.the("select Unit")
            .locatedBy("//ul[@id='select2-results-8']");
    public static final Target TXT_REPORTER = Target.the("reporter list")
            .locatedBy("//div[@id='s2id_Serenity_Pro_Meeting_MeetingDialog10_ReporterContactId']");
    public static final Target LST_REPORTER = Target.the("select reporter list")
            .locatedBy("//ul[@id='select2-results-10']");
    public static final Target TXT_ATENDEE_TYPE = Target.the("atendee type list")
            .locatedBy("//select[@class='valid']");
    public static final Target TXT_ATTENDANCE_STATUS = Target.the("Attendance status list")
            .locatedBy("//div[@class='slick-cell l3 r3']/select");
    public static final Target BTN_SAVE = Target.the("button to save the meeting")
            .locatedBy("//div[@class='tool-button save-and-close-button icon-tool-button']");
}
