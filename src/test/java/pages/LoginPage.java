package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;

public class LoginPage {
    private SelenideElement linkCreateUser = $(By.xpath("//span[.='Cadastre-se']"));

    private SelenideElement inputCompleteName = $(By.xpath("//input[@name='name']"));

    private SelenideElement inputEmail = $(By.xpath("/html/body/app-root/ion-app/div/div/desktop-modal/div[2]/register-popup/div/form/div[3]/ion-input/input"));

    private SelenideElement inputPassword = $(By.xpath("//*[@id=\"formRegisterUser\"]/div[5]/ion-input/input"));

    private SelenideElement inputConfirmationPassword = $(By.xpath("//input[@name='confirmPassword']"));

    private SelenideElement selectState = $(By.xpath("//ion-select[@placeholder='Selecione seu Estado']"));
    private SelenideElement selectOptionState = $(By.xpath("//*[@id=\"ion-overlay-1\"]/div[2]/div/div[1]/button[8]"));

    private SelenideElement checkBoxTermsAndConditions = $(By.xpath("//*[@id=\"formRegisterUser\"]/div[11]/ion-item[2]/ion-checkbox"));

    private SelenideElement acceptBtn = $(By.xpath("//*[@id=\"content\"]/terms-and-conditions/base-button/button"));

    private SelenideElement btnCadastrar = $(By.xpath("//span[.=\"CADASTRAR\"]"));

    private SelenideElement confirmationAlertTitle = $(By.xpath("//h1"));
    private SelenideElement confirmationAlertBody = $(By.xpath("/html/body/app-root/ion-app/div/div/desktop-modal/div/email-spam-popup/div/span"));

    private SelenideElement invalidMsg = $(By.xpath("//*[@class=\"error-message ng-star-inserted\"]"));
    private SelenideElement fecharBtn = $(By.xpath("//div"));
    public void createUserlink() {
        linkCreateUser.click();
    }

    public void typeCompleteName(String completeName) {
        inputCompleteName.should(Condition.visible).sendKeys(completeName);
    }

    public void typeEmail(String email) {
        inputEmail.should(Condition.visible).sendKeys(email);
    }

    public void typePassword(String password) {
        inputPassword.should(Condition.visible).sendKeys(password);
    }

    public void typeConfirmPassword(String password) {
        inputConfirmationPassword.should(Condition.visible).sendKeys(password);
    }

    public void selectState() {
        selectState.should(Condition.visible).click();
        Selenide.sleep(1200);
        selectOptionState.should(Condition.visible).click();
    }

    public void checkBoxTermsAndConditions() {
        checkBoxTermsAndConditions.should(Condition.visible).click();
        acceptBtn.should(visible).click();
    }

    public void cadastrarbtn() {
        btnCadastrar.should(visible).click();
    }

    public void confirmationMsg() {
        Assert.assertEquals("CÓDIGO ENVIADO", confirmationAlertTitle.shouldBe(visible).getText());
        Assert.assertEquals("O seu CÓDIGO foi enviado para o E-MAIL informado. Caso não encontre na caixa de entrada, verifique na caixa de SPAM e marque em CONFIAR para receber novos e-mails Coco Bambu.", confirmationAlertBody.shouldBe(visible).getText());
        fecharBtn.shouldBe(visible);
    }

    public void invalidMsg(String message) {
        Assert.assertEquals(message, invalidMsg.shouldBe(visible).getText());

    }
}
