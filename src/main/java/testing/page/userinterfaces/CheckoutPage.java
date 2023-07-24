package testing.page.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;


public class CheckoutPage {
    CheckoutPage() {}
    public static final Target TXT_NOMBRE = Target.the("nombre de comprador")
            .locatedBy("//input[@name='firstName']");
    public static final Target TXT_APPELIDO = Target.the("apellido de comprador")
            .locatedBy("//input[@name='lastName']");
    public static final Target TXT_ZIP = Target.the("codigo ZIP de comprador")
            .locatedBy("//input[@id='postal-code']");
    public static final Target BTN_CONTINUE = Target.the("buton para continuar")
            .locatedBy("//input[@name='continue']");
    public static final Target BTN_FINISH = Target.the("buton para finalizar")
            .locatedBy("//button[contains(text(),'Finish')]");
    public static final Target TXT_CONFIRMAR = Target.the("texto a validar compra")
            .locatedBy("//h2[contains(text(),'Thank you for your order!')]");


}
