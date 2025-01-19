package starter.Steps;

import net.serenitybdd.annotations.Step;
import starter.pageObject.LoginSaucedemo;

public class LoginSaucedemoSteps {

    LoginSaucedemo loginSaucedemo;
    @Step
    public void Login (String usuario, String contrasena) {
        loginSaucedemo.getDriver().findElement(loginSaucedemo.getTxtUserName()).sendKeys(usuario);
        loginSaucedemo.getDriver().findElement(loginSaucedemo.getTxtContrasena()).sendKeys(contrasena);
        loginSaucedemo.getDriver().findElement(loginSaucedemo.getBtnLogin()).click();
    }
    @Step
    public void abrirNavegador () {
        loginSaucedemo.open();
    }
}
