package starter.Steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import starter.pageObject.ShoppingSaucedemo;

public class ShoppingSaucedemoSteps {
    ShoppingSaucedemo shoppingSaucedemo;
    public void llenarFormulario(String firstName, String lastName, String postalCode){
        shoppingSaucedemo.getDriver().findElement(shoppingSaucedemo.getTxtFirstName()).sendKeys(firstName);
        shoppingSaucedemo.getDriver().findElement(shoppingSaucedemo.getTxtLastName()).sendKeys(lastName);
        shoppingSaucedemo.getDriver().findElement(shoppingSaucedemo.getTxtPostalCode()).sendKeys(postalCode);
        shoppingSaucedemo.getDriver().findElement(shoppingSaucedemo.getBtnContinue()).click();
        shoppingSaucedemo.getDriver().findElement(shoppingSaucedemo.getBtnFinish()).click();
    }
    public void msjConfirmacion() {
        String msjConfirmacion = shoppingSaucedemo.getDriver().findElement(shoppingSaucedemo.getMsjConfirmacion()).getText();
        Assert.assertEquals(msjConfirmacion,"Thank you for your order!");
    }
}
