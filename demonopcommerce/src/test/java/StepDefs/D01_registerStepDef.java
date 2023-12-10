package StepDefs;

import Pages.P01_Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D01_registerStepDef {


    P01_Register register= new P01_Register(Hooks.driver);
    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.clickOnRegisterLink();
    }
    @When("user select gender")
    public void selectGender()
    {
        register.setGender();
    }
    @And("user enter first name \"tester\" and  last name automation")
    public void inputFirstAndLastName()
    {
        register.setFirstName();
        register.setLastName();
    }
    @And("user enter day of birth")
    public void inputDayOfBirth()
    {
        register.setDayOfBirth();
    }
    @And("user enter month of birth")
    public void inputMonthOfBirth()
    {
        register.setMonthOfBirth();
    }
    @And("user enter year of birth")
    public void inputYearOfBirth()
    {
        register.setYearOfBirth();
    }
    @And("user enter email \"Test@gmail.com\"")
    public void inputEmail()
    {
        register.setEmail();
    }
    @And("user fills password fields\"P@ssw0rd\" \"P@ssw0rd\"")
    public void inputPasswordFields(){
        register.setPassword();
        register.setPasswordConfirmation();
    }
    @And("user click on register button")
    public void clickOnRegisterButton(){
        register.submitRegistration();
    }
    @Then("success message is displayed")
    public void validateSuccessMessage(){
        Assert.assertEquals(register.getResultColorAssertion()[0],register.getResultColorAssertion()[1],"This Is Color Assertion");
        Assert.assertEquals(register.getResultTextAssertion()[0],register.getResultTextAssertion()[1],"This Is Text Assertion");
    }

}
