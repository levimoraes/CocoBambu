package steps;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage;
import utils.Utils;

public class LoginStep {

    LoginPage login = new LoginPage();


//    @Given("are on the application's login page")
//    public void areOnTheApplicationSLoginPage() {
//        login.accessApplication();
//    }



    @And("click on button Cadastre-se")
    public void clickOnButtonCadastreSe() {
        login.createUserlink();
    }

    @And("wait {int}sec")
    public void waitSec(int arg0) {
        Selenide.sleep(120);
    }

    @And("type {string} on CompleteNamefield")
    public void typeOnCompleteNamefield(String completeName) {

        login.typeCompleteName(completeName);
    }

    @And("type {string} on Emailfield")
    public void typeOnEmailfield(String email) {

        login.typeEmail(email);
    }

    @And("type {string} on Passwordfield")
    public void typeOnPasswordfield(String password) {
        login.typePassword(password);
    }

    @And("type {string} on ConfirmPasswordfield")
    public void typeOnConfirmPasswordfield(String password) {
        login.typeConfirmPassword(password);
    }

    @And("select Distrito Federal on State")
    public void selectDistritoFederalOnState() {
        login.selectState();
    }

    @And("checkbox Terms and Conditions")
    public void checkboxTermsAndConditions() {
        login.checkBoxTermsAndConditions();
    }

    @And("click on Cadastrar")
    public void clickOnCadastrar() {
        login.cadastrarbtn();
    }

    @Then("should appear confirmation message")
    public void shouldAppearConfirmationMessage() {
        login.confirmationMsg();
    }


    @Then("should appear {string} message")
    public void shouldAppearMessageMessage(String message) {
        login.invalidMsg(message);
    }


    @And("complete Name field")
    public void completeNameField() {

        String completeName = Utils.generateRadomName();
        login.typeCompleteName(completeName);
    }

    @And("complete Mail field")
    public void completeMailField() {
        String email = Utils.generateRadomMail();
        login.typeEmail(email);
    }
}
