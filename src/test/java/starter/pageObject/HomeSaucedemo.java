package starter.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomeSaucedemo  extends PageObject {
    public HomeSaucedemo() {
    }
    By btnAddToCar = By.xpath("(//*[text()='Add to cart'])[1]");
    By btnCarrito = By.xpath("//*[@class='shopping_cart_link']");
    By btnCheckout = By.id("checkout");

    public By getBtnAddToCar() {
        return btnAddToCar;
    }

    public By getBtnCarrito() {
        return btnCarrito;
    }

    public By getBtnCheckout() {
        return btnCheckout;
    }
}
