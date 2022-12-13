package testing.page.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ClientesPage {

    public static final Target LABEL_MENU_VIENTO_NORTE = Target.the("Label menú viento del norte")
            .locatedBy("//span[contains(text(),'Northwind')]");
    public static final Target LABEL_SUBMENU_CLIENTES = Target.the("Label submenú clientes")
            .locatedBy("//span[contains(text(),'Customers')]");
    public static final Target BTN_NUEVO_CLIENTE = Target.the("Boton de nuevo cliente")
            .locatedBy("//div[@class='tool-button add-button icon-tool-button']");
    public static final Target TXT_COUNTRY = Target.the("text")
            .locatedBy("//div[@id='s2id_Serenity_Demo_Northwind_CustomerDialog9_Country']");

    public static final Target INPUT_ID = Target.the("Input para el campo id")
            .located(By.xpath("//*[@id='Serenity_Demo_Northwind_CustomerDialog9_CustomerID']"));
    public static final Target INPUT_NOMBRE_EMPRESA = Target.the("Input para el campo nombre de empresa")
            .located(By.xpath("//*[@id='Serenity_Demo_Northwind_CustomerDialog9_CompanyName']"));
    public static final Target INPUT_NOMBRE_CONTACTO = Target.the("Input para el campo contacto")
            .located(By.xpath("//*[@id='Serenity_Demo_Northwind_CustomerDialog9_ContactName']"));
    public static final Target INPUT_TITULO_CONTACTO = Target.the("Input para el campo contacto")
            .located(By.xpath("//*[@id='Serenity_Demo_Northwind_CustomerDialog9_ContactTitle']"));
    public static final Target SELECT_REPRESENTANTE = Target.the("select para el campo representante")
            .located(By.xpath("//*[@id='s2id_autogen4']"));
    public static final Target INPUT_DIRECCION = Target.the("Input para direccion")
            .located(By.xpath("//*[@id='Serenity_Demo_Northwind_CustomerDialog9_Address']"));
    public static final Target SELECT_PAIS = Target.the("select para el campo  pais")
            .locatedBy("//span[@id='select2-chosen-5']");
    public static final Target SELECT_PAIS_UL = Target.the("select para el campo  pais")
            .located(By.xpath("//ul[@id='select2-results-5']"));

}
