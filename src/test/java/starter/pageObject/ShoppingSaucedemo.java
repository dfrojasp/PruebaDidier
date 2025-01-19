package starter.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShoppingSaucedemo extends PageObject {
    public ShoppingSaucedemo() {
    }
    By txtFirstName = By.id("first-name");
    By txtLastName = By.id("last-name");
    By txtPostalCode = By.id("postal-code");
    By btnContinue = By.id("continue");
    By btnFinish = By.id("finish");
    By msjConfirmacion = By.xpath("//*[text()='Thank you for your order!']");

    public By getMsjConfirmacion() {
        return msjConfirmacion;
    }

    public By getBtnFinish() {
        return btnFinish;
    }

    public By getTxtFirstName() {
        return txtFirstName;
    }

    public By getTxtLastName() {
        return txtLastName;
    }

    public By getTxtPostalCode() {
        return txtPostalCode;
    }

    public By getBtnContinue() {
        return btnContinue;
    }
}
