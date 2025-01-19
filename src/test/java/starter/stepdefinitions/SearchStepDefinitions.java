package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.Steps.HomeSaucedemoSteps;
import starter.Steps.LoginSaucedemoSteps;
import starter.Steps.ShoppingSaucedemoSteps;

public class SearchStepDefinitions {
    @Steps
    LoginSaucedemoSteps loginSaucedemoSteps;
    @Steps
    HomeSaucedemoSteps homeSaucedemoSteps;
    @Steps
    ShoppingSaucedemoSteps shoppingSaucedemoSteps;

    @Given("yo como usuario ingreso al portal {string} {string}")
    public void yoComoUsuarioIngresoAlPortal(String usuario, String contrasena){
        loginSaucedemoSteps.abrirNavegador();
        loginSaucedemoSteps.Login(usuario, contrasena);
    }
    @When("Ingreso al modulo de compras {string} {string} {string}")
    public void ingresoAlModuloDeCompras(String firsName, String lastName, String postalCode){
        homeSaucedemoSteps.SeleccionarArticulo();
        homeSaucedemoSteps.IrAlCarrito();
        shoppingSaucedemoSteps.llenarFormulario(firsName, lastName, postalCode);

    }
    @Then("Valido la transaccion exitosa de los articulos seleccionados")
    public void validoLaTransaccionExitosaDeLosArticulosSeleccionados() {
        shoppingSaucedemoSteps.msjConfirmacion();
    }

}
