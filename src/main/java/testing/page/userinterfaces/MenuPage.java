package testing.page.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;


public class MenuPage {
    MenuPage() {}

    public static final Target BTN_AÑADIR = Target.the("boton para añadir al carrito")
            .locatedBy("//div[contains(@class, 'inventory_item_name') and contains(text(),'{0}')]/ancestor::div[@class='inventory_item_description']//button[contains(text(), 'Add to cart')]");
}
