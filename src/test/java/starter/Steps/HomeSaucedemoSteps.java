package starter.Steps;

import starter.pageObject.HomeSaucedemo;

public class HomeSaucedemoSteps {
    HomeSaucedemo homeSaucedemo;
public void SeleccionarArticulo(){
    homeSaucedemo.getDriver().findElement(homeSaucedemo.getBtnAddToCar()).click();

}
public void IrAlCarrito(){
    homeSaucedemo.getDriver().findElement(homeSaucedemo.getBtnCarrito()).click();
    homeSaucedemo.getDriver().findElement(homeSaucedemo.getBtnCheckout()).click();
}
}
