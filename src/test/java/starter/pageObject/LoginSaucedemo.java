package starter.pageObject;

import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginSaucedemo extends PageObject {
    public LoginSaucedemo() {
    }
    By txtUserName = By.id("user-name");
    By txtContrasena = By.id("password");
    By btnLogin = By.id("login-button");

    public By getTxtContrasena() {
        return txtContrasena;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public By getTxtUserName() {
        return txtUserName;
    }
}
