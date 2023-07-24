package testing.page.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {
    CarritoPage() {}
    public static final Target BTN_CARRITO = Target.the("enlace al carrito")
            .locatedBy(".shopping_cart_link");
    public static final Target TXT_VALIDAR_PRODUCTO = Target.the("nombre del producto a validar")
            .locatedBy("//div[@class='inventory_item_name']");
    public static final Target BTN_CHECKOUT = Target.the("boton checkout")
            .locatedBy("//button[@class='btn btn_action btn_medium checkout_button']");
}