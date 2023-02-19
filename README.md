# StartSharpModule


Executes automation on the site
 [StartSharp](https://serenity.is/demo/)
 following the login procces, creating a new bussiness unit followed by the appointment schedule creation.
[Gradle](https://gradle.org/), [Java](https://www.java.com/es/), [SerenityBDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html), [Cucumber](https://cucumber.io/) and Screenplay.

## tools used on the project
<table>
<tr>
  <th>Java 11</th>
  <td>
    <h6>requires Java 11 to run properly, if the JDK is higher it needs to be refactored</h6>
  </td>
</tr>
<tr>
  <th>Gradle 7.4.2</th>
  <td>
    <h6>Gradle is used to manage all dependencies</h6>
  </td>
</tr>
</table>


## Code Structure

the code was developed using screenplay pattern as below:
<table>
<tr>
  <th>Tasks</th>
  <td>
    <h6>Contains all the task to execute on the automation</h6>
  </td>
</tr>
  <tr>
  <th>Interactions</th>
  <td>
    <h6>Contains all the interactions to execute on the automation</h6>
  </td>
</tr>
  <tr>
  <th>Models</th>
  <td>
    <h6>Contains all the models to build the execution data</h6>
  </td>
</tr>
  <tr>
  <th>Uis</th>
  <td>
    <h6>contains all the abstraction classes with the selectors for each site</h6>
  </td>
</tr>
  <tr>
  <th>Drivers</th>
  <td>
    <h6>contains all the drivers for each browser</h6>
  </td>
</tr>
  <tr>
  <th>Runners</th>
  <td>
    <h6>Contains all the runers to run the automation</h6>
  </td>
</tr>
  <tr>
  <th>Steps Definitions</th>
  <td>
    <h6>Contains all the step definitions for each test</h6>
  </td>
</tr>
  <tr>
  <th>Features</th>
  <td>
    <h6>Contains all the scenarios under the Gherkin language</h6>
  </td>
</tr>
<tr>
  <th>Questions</th>
  <td>
    <h6>Contains all the validations needed to ensure the tests</h6>
  </td>
</tr>
</table>


#### Tasks

#### CreateANewBussinessUnit

These task creates a Bussiness Unit and asigns a Parent unit to it and uses the interaction class `ChooseFromList.java` with two parameters `(Target locator, int index)`

```java
public class CreateANewBussinessUnit implements Task {


    public ArrayList<Map<String, String>> dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {

            try {
                dataExcel = ExcelDataTable.ReadData("data.xlsx", "Sheet1");
            } catch (IOException e) {
                e.printStackTrace();
            }

            actor.attemptsTo(
                WaitUntil.the(BTN_ORGANIZATION, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_ORGANIZATION),
                JavaScriptClick.on(BTN_BUSSINESS_UNIT),
                JavaScriptClick.on(BTN_BUSSINESS),
                JavaScriptClick.on(BTN_NEW_BUSSINESS_UNIT),
                Enter.theValue(dataExcel.get(0).get("Bussiness_Name")).into(TXT_BUSSINESS_NAME),
                Click.on(TXT_PARENT_UNIT),
                ChooseFromList.index(LST_PARENT_UNIT,0),
                JavaScriptClick.on(BTN_SAVE_UNIT)
        );

    }

    public static CreateANewBussinessUnit onTheSite() {
        return Instrumented.instanceOf(CreateANewBussinessUnit.class).withProperties();
    }
}
```

#### CreateANewMeeting

These class creates a new meeting after creating the Bussiness Unit, uses an excel class data driven with two parameters `(path, sheet)`, to get the text from that excel file it uses the instruction `dataExcel.get(index).get("column_Name")` as String, there is the interaction `SelectUnit(Target element, String Bussiness_Name)` to arrange the field with the meeting created

```java
public class CreateANewMeeting implements Task {

    public ArrayList<Map<String, String>> dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {

            dataExcel = ExcelDataTable.ReadData("data.xlsx", "Sheet1");

        } catch (Exception e) {

        }
        actor.attemptsTo(
                WaitUntil.the(BTN_MEETING, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_MEETING),
                JavaScriptClick.on(BTN_MEETINGS),
                Ensure.that(LBL_TEXT).isDisplayed(),
                JavaScriptClick.on(BTN_NEW_MEETING),
                Enter.theValue(dataExcel.get(0).get("Meeting_Name")).into(TXT_MEETING_NAME),
                Click.on(TXT_MEETING_TYPE),
                ChooseFromList.index(LST_MEETING_TYPE, 2),
                Click.on(TXT_START_DATE),
                Clear.field(TXT_START_DATE),
                Enter.keyValues(dataExcel.get(0).get("Start Date")).into(TXT_START_DATE),
                ChooseListSelect.index(TXT_START_HOUR, 10),
                Enter.keyValues(dataExcel.get(0).get("Meeting_Number")).into(TXT_MEETING_NUMBER),
                JavaScriptClick.on(TXT_END_DATE),
                Clear.field(TXT_END_DATE),
                Enter.keyValues(dataExcel.get(0).get("End_Date")).into(TXT_END_DATE),
                ChooseListSelect.index(TXT_END_HOUR, 12),
                Click.on(TXT_LOCATION),
                ChooseFromList.index(LST_LOCATION_OPTIONS, 3),
                Click.on(TXT_ORGANIZED_BY),
                ChooseFromList.index(LST_ORGANIZED_BY, 5),
                Click.on(TXT_UNIT),
                SelectUnit.on(LST_UNIT, dataExcel.get(0).get("Bussiness_Name")),
                Click.on(TXT_REPORTER),
                ChooseFromList.index(LST_REPORTER, 3),
                Click.on(TXT_ATENDEE_LIST),
                ChooseFromList.index(LST_ATENDEE_LIST, 3),
                Click.on(BTN_SAVE),
                ExplicitWait.here(5),
                Ensure.that(LBL_USER_VALIDATION).isDisplayed()
        );
    }

    public static CreateANewMeeting onTheSite() {
        return Instrumented.instanceOf(CreateANewMeeting.class).withProperties();
    }
}
```

#### DoTheLogin

these class executes the login steps receiving the data directly from the .feature file and managed by the `model.LoginData` creating a datable and passing the data right from the When Snippet,

```java
public class DoTheLogin implements Task {

    private String user;
    private String password;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(TXT_USER),
                Enter.theValue(password).into(TXT_PASSWORD),
                JavaScriptClick.on(BTN_LOGIN),
                WaitUntil.the(LBL_VALIDATION, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static DoTheLogin onTheSite() {
        return Instrumented.instanceOf(DoTheLogin.class).withProperties();
    }

    public DoTheLogin user(String user) {
        this.user = user;
        return this;
    }

    public DoTheLogin password(String password) {
        this.password = password;
        return this;
    }

}

```

### Interactions

#### ChooseFromList

has two private data to drive the data as parameter, on the @Override annotation right below the element is treated as a WebElement by the actor and then will list all the "li" tags within the ul tag.

once is located and mapped its ready to choose the option giving a click into it.

```java
public class ChooseFromList implements Interaction {

    private final Target element;
    private final int index;


    public ChooseFromList(Target element, int index) {
        this.element = element;
        this.index = index;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listLocation = element.resolveFor(actor);
        List<WebElement> options = listLocation.findElements(By.tagName("li"));
        options.get(index).click();
    }

    public static ChooseFromList index(Target element, int index) {
        return Instrumented.instanceOf(ChooseFromList.class).withProperties(element, index);
    }
}
```

#### ChooseFromList

has two private data to drive the data as parameter, on the @Override annotation right below the element is treated as a WebElement by the actor and then will list all the "li" tags within the ul tag.

once is located and mapped its ready to choose the option giving a click into it.

```java
public class ChooseFromList implements Interaction {

    private final Target element;
    private final int index;


    public ChooseFromList(Target element, int index) {
        this.element = element;
        this.index = index;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listLocation = element.resolveFor(actor);
        List<WebElement> options = listLocation.findElements(By.tagName("li"));
        options.get(index).click();
    }

    public static ChooseFromList index(Target element, int index) {
        return Instrumented.instanceOf(ChooseFromList.class).withProperties(element, index);
    }
}
```

### ExplicitWait

uses a try/catch sorround to manage the Thread.sleep method with an exception


```java
public class ExplicitWait implements Interaction {

    long secs;

    public ExplicitWait(int secs) {
        this.secs = secs;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {

        }

    }

    public static ExplicitWait here(int secs) {
        return Instrumented.instanceOf(ExplicitWait.class).withProperties(secs);
    }
}
```

### ChooseListSelect

it uses a WebElement, clicks it and then uses the class Select to choose an option by Index


```java
public class ChooseListSelect implements Interaction {

    private final Target element;
    private final int index;


    public ChooseListSelect(Target element, int index) {
        this.element = element;
        this.index = index;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement hour = element.resolveFor(actor);
        hour.click();
        Select listSelect = new Select(hour);
        listSelect.selectByIndex(index);

    }

    public static ChooseListSelect index(Target element, int index){
        return Instrumented.instanceOf(ChooseListSelect.class).withProperties(element, index);
    }
}

```


### SelectUnit

this class received two parameters: `(Target element, String bussinessName)` it uses the target element to create a `WebElement element` to resolve it for the actor in order to create a `List<WebElement>` with all the childs that the selector has, once its done will use a `for each` loop to review the whole list and once it finds the same text as the condicion expects will give a click within the element found by the `WebElement i` iterator variable.  


```java
public class SelectUnit implements Interaction {

    private final Target element;
    private final String bussinessName;


    public SelectUnit(Target element, String bussinessName) {
        this.element = element;
        this.bussinessName = bussinessName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listLocation = element.resolveFor(actor);
        List<WebElement> options = listLocation.findElements(By.tagName("li"));
        for (WebElement i : options) {
            if (i.getText().contains(bussinessName)){
                i.click();
                break;
            }
        }
    }

    public static SelectUnit on(Target element, String bussinessName) {
        return Instrumented.instanceOf(SelectUnit.class).withProperties(element, bussinessName);
    }
}

```

#### UserInterfaces

#### BussinessUnitPage

Here its where we can store all the locators using the class `Target` to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test. 

```java

public class BussinessUnitPage {


    public static final Target BTN_BUSSINESS = Target.the("button to create a new bussiness unit")
            .locatedBy("//div[@class='tool-button add-button icon-tool-button']");
    public static final Target BTN_NEW_BUSSINESS_UNIT = Target.the("button to create a new bussiness unit")
            .locatedBy("//div[@class='s-TemplatedDialog ui-dialog-content ui-widget-content']/descendant:: input[1]");
}


```

#### DashBoardPage

Here its where we can store all the locators using the class `Target` to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test. 

```java

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


```

#### LoginPage

Here its where we can store all the locators using the class `Target` to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test. 

```java

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


```

#### MeetingPage

Here its where we can store all the locators using the class `Target` to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test. 

```java

public class MeetingsPage {

    public static final Target LBL_TEXT = Target.the("text to validate")
            .locatedBy("//div[@class='title-text']");
    public static final Target BTN_NEW_MEETING = Target.the("button new meeting")
            .locatedBy("//div[@class='tool-button add-button icon-tool-button']");
    public static final Target TXT_MEETING_NAME = Target.the("meeting name to validate")
            .locatedBy("//div[@class='slick-cell l1 r1']/a");
    public static final Target LBL_USER_VALIDATION = Target.the("user validate")
            .locatedBy("//span[@class='slick-column-name']");


}


```

#### NewBussinessUnitPage

Here its where we can store all the locators using the class `Target` to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test. 

```java

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


```

#### NewMeetingPage

Here its where we can store all the locators using the class `Target` to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test. 

```java

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


```

#### Questions

#### ValidateTheMeetingName

these class contains a boolean answer defined from the beginning with the implementation of `Question<Boolean>` and returns a boolean answer asking "is the element displayed?"

```java
public class ValidateTheMeetingName implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return MeetingsPage.LBL_USER_VALIDATION.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> value() {
        return new ValidateTheMeetingName();
    }
}

```

#### ValidateTheMessage

these class contains a String answer defined from the beginning with the implementation of `Question<String>` and returns a String answer extracting the text from the locator using the method `return locator.resolveFor(actor).getText();`

```java
public class ValidateTheMessage implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return LBL_VALIDATION.resolveFor(actor).getText();
    }

    public static Question<String> value() {
        return new ValidateTheMessage();
    }

}

```

### drivers

#### WebDriversSetup

these class contains all the options and methods to build each browser with the options given and a method to open the url


```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class WebDriversSetup {
    public static WebDriver driver;
    public static WebDriversSetup withChromeOptions() {
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("chrome.capabilities.unexpectedAlertBehavior", "ignore");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --incognito --disable-gpu --no-sandbox --disable-download-notification");

        driver = new ChromeDriver(options);
        return new WebDriversSetup();
    }
    public static WebDriversSetup withFirefoxOptions() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.driver","Firefox");
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("gecko.capabilities.unexpectedAlertBehavior", "ignore");

        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --incognito --disable-gpu --no-sandbox --disable-download-notification");


        driver = new FirefoxDriver(options);
        return new WebDriversSetup();
    }

    public static WebDriversSetup withEdgeOptions() {
        WebDriverManager.edgedriver().setup();

        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("gecko.capabilities.unexpectedAlertBehavior", "ignore");

        EdgeOptions options = new EdgeOptions();


        driver = new EdgeDriver();
        return new WebDriversSetup();
    }

    public static WebDriver on(String url) {
        driver.get(url);
        return driver;
    }

    public static WebDriver quit(){
        driver.quit();
        return driver;
    }
}
```

### utils

### ExcelDatatable

Works giving only the column and row number

```java

public class ExcelDataTable {

    private XSSFWorkbook book;
    private FileInputStream file;

    public String ReadDataSheet(String page, String path, int rowValue, int cellValue) throws IOException {
        String pointer;
        file = new FileInputStream(new File(path));
        book = new XSSFWorkbook(file);
        Sheet sheet = book.getSheet(page);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        pointer = cell.getStringCellValue();
        book.close();
        file.close();
        return pointer;
    }

    public static ArrayList<Map<String, String>> ReadData(String excelPath, String excelSheet) throws IOException {
        ArrayList<Map<String, String>> arrayListWorkPlanData = new ArrayList<Map<String, String>>();
        Map<String, String> projectInformation = new HashMap<String, String>();
        File file = new File(excelPath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(excelSheet);
        Iterator<Row> rowIterator = newSheet.iterator();
        Row tiles = rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.getColumnIndex();
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        projectInformation.put(tiles.getCell(cell.getColumnIndex()).toString(), cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        projectInformation.put(tiles.getCell(cell.getColumnIndex()).toString(), String.valueOf((long) cell.getNumericCellValue()));
                        break;
                    case BLANK:
                        projectInformation.put(tiles.getCell(cell.getColumnIndex()).toString(), "");
                        break;
                    default:
                }
            }
            arrayListWorkPlanData.add(projectInformation);
            projectInformation = new HashMap<String, String>();
        }
        return arrayListWorkPlanData;
    }
}

```

### how to use the excel

before the annotation `@override` an arrayList has to be created as follow `public ArrayList<Map<String, String>> dataExcel;` afterwards, the read method has to be surrounded within a try/catch in case the element is not found

```java

public ArrayList<Map<String, String>> dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            dataExcel = ExcelDataTable.ReadData("data.xlsx", "Sheet1");
            } catch (IOException e) {
                e.printStackTrace();
            }

        actor.attemptsTo(
                        Enter.theValue(dataExcel.get(0).get("Bussiness_Name")).into(TXT_BUSSINESS_NAME),
        );

    }

```

### Runners

#### StartSharpBussinessRubber

follows the steps and executes the proper methods  on the `startsharpstepdefinitions`, this class runs via `@RunWith` from the class `CucumberWithSerenity.class` and uses `@CucumberOptions` to call the feature, set the glue folder with `Steps Definitions` and the snnipets output with `CamelCase`.

```java
@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/startSharpBussiness.feature",
        glue = "testing.startSharp.startsharpstepdefinitions",
        snippets = SnippetType.CAMELCASE)
```

#### StartSharpDotheLoginRunner

```java
@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/startSharpLogin.feature",
        glue = "testing.startSharp.startsharpstepdefinitions",
        snippets = SnippetType.CAMELCASE)
```

#### Step Definitions

##### startSharpLogin

Before everything starts, its needed to create an instance of the actor using the OnStage class using the @Before annotation

```java
@Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }
```

starts with the login on the website and validates the login was successfully done, the driver setups the options needed to run the browser properly with the line followed by the url that is passed raw to the ability.

```java
@Given("^That Mike opens the url to see the login page$")
    public void thatMikeOpensTheHttpsSerenityIsDemoToSeeTheLoginPage() {
            WebDriversSetup.withChromeOptions();
            OnStage.theActorCalled("Mike").can(BrowseTheWeb.with(WebDriversSetup.on(URL)));

    }
```

holding the flow; When executes the task to give the data through the feature file using a Datatable controlled by a model class

```java
@When("^Mike types the following data$")
    public void MikeTypesTheFollowingData(List<LoginData> loginDataList) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                DoTheLogin.onTheSite()
                        .withThisUser(loginDataList.get(0).getUser())
                        .andThisPassword(loginDataList.get(0).getPassword())
        );
    }
```

holding the flow; Then validates the login taking the message DashBoard displayed on the screen

```java
@Then("^Mike will be able to see the (.*)$")
    public void mikeWillBeAbleToSeeTheExploraYGestionaTusProductos(String text) {

        OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheMessage.value(), containsString(text)));

    }
```

#### startSharpBussiness



Before everything starts, its needed to create an instance of the actor using the OnStage class using the @Before annotation

```java
@Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

```

Starts creating a new bussiness unit followed by the new meeting creation
```java
    @When("^Mike creates a new unit bussiness and setups a meeting$")
    public void mikeCreatesANewUnitBussinessAndSetupsAMeeting() {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateANewBussinessUnit.onTheSite());
        OnStage.theActorInTheSpotlight().attemptsTo(CreateANewMeeting.onTheSite());
    }
```

Then uses a Question class to validate using a boolean answer

```java
    @Then("^Mike will be able see the meeting was succesfully scheduled$")
    public void mikeWillBeAbleSeeTheMeetingWasSuccesfullyScheduled() {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheMeetingName.value()));

    }
```

### Features

#### startSharpBussiness.feature

```cucumber
Feature: testing the serenity demo page

  Background:

    Given That Mike opens the url to see the login page

    When Mike types the following data
      | user  | password |
      | admin | serenity |

  Scenario: Mike wants to create an unit bussiness

    When Mike creates a new unit bussiness and setups a meeting

    Then Mike will be able see the meeting was succesfully scheduled
```


#### startSharpLogin.feature

```cucumber
Feature: testing login on the serenity demo page

  Scenario Outline: Mike wants to login on the website

    Given That Mike opens the url to see the login page

    When Mike types the following data
      | user   | password   |
      | <user> | <password> |

    Then Mike will be able to see the <text>

    Examples:
      | user  | password |  text      |
      | admin | serenity |  Dashboard |
```


#### buildGradle

```groovy
buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("net.serenity-bdd:serenity-gradle-plugin:2.0.80")
    }
}

plugins {
    id 'java-library'
}

apply plugin: 'net.serenity-bdd.aggregator'

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation 'net.serenity-bdd:serenity-junit:2.0.80'
    implementation 'net.serenity-bdd:serenity-cucumber:1.9.45'
    implementation 'net.serenity-bdd:serenity-core:2.0.80'
    implementation 'net.serenity-bdd:serenity-ensure:2.0.80'
    implementation 'org.slf4j:slf4j-simple:2.0.5'
    implementation 'io.github.bonigarcia:webdrivermanager:5.3.1'
    implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.13.3'
    implementation group: 'org.apache.poi', name: 'poi', version: '3.17'
    implementation group: 'org.apache.poi', name: 'poi-ooxml', version: '3.17'

}

test {

    ignoreFailures = true
}

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

gradle.startParameter.continueOnFailure = true
```


## Execution

in order to execute the project and generates the Aggregate report provided by Serenity BDD, we open the `CMD` on the IDE and type the follow command.

```yml
    gradle clean test aggregate
```
these command executes all the declared scenarios on this project

```cmd
    3 actionable tasks: 3 executed
```

At the end we must go and open the file `index.html` that is located on on the following route

```yml
  <ProjectoName>\target\site\serenity\index.html
```

This Readme.md was made it by Michael Garzon Rodriguez