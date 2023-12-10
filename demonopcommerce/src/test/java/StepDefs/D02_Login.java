package StepDefs;

import Pages.P02_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D02_Login {

    P02_Login login = new P02_Login(Hooks.driver);

    /**************************LoginWithValidCredential**************************/
    @Given("user go to login page")
    public void goToLoginLink() {
        login.clickOnLoginLink();
    }

    @When("user login with \"valid\" \"test@example.com\" and \"P@ssw0rd\"")
    public void loginWithValidCredential() {
        login.inputValidEmail();
        login.inputValidPassword();
    }

    @And("user press on login button")
    public void pressOnLoginButton() {
        login.clickLoginButton();
    }

    @Then("user login to system successfully and redirected to homepage")
    public void redirectedToHomePageValidation() {
        Assert.assertEquals(login.redirectedToHomepageAssertion()[0], login.redirectedToHomepageAssertion()[1], "this is homepage redirection assertion ");
    }

    @And("my account tab displayed")
    public void validateMyAccountTabDisplaying() {
        login.myAccountTabIsDisplayed();
    }

/***************************LoginWithInValidCredential************************/

    @Given("user go to login Link")
   public void userClickOnLoginLink(){
        login.clickOnLoginLink();
    }

    @When("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void userLoginWithInvalidCredential(){
        login.inputInvalidEmail();
        login.inputValidPassword();
    }
    @And("user press login button")
    public void pressLoginButton(){
        login.clickLoginButton();
    }
    @Then("user could not login to the system and error message displayed contains \"Login was unsuccessful.\"")
    public void validateErrorMessageText(){
        Assert.assertTrue(login.errorMessageTextAssertions()[0].contains(login.errorMessageTextAssertions()[1]),"this is error message text assertion");
    }
    @And("the color of this message is red #e4434b")
    public void validateErrorMessageColor(){
        Assert.assertEquals(login.errorMessageColorAssertions()[0],login.errorMessageColorAssertions()[1],"this is error message color assertions");
    }
}
