package StepDefs;

import Pages.P00_Homepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D05_homeSliders {
    P00_Homepage homeSlider=new P00_Homepage(Hooks.driver);

    String actualResult;

    @Given("navigate to homepage")
    public void gotoHomePage(){
        homeSlider.goToHomepage();
    }
    @When("users click on nokia lumia 1020 slider")
    public void clickOnNokiaSlider(){
        actualResult= homeSlider.directedToNokiaSliderPage();
    }


    @Then("redirected to url contains nokia-lumia")
    public void urlNokiaAssertion() {
        Assert.assertEquals(actualResult,
                " https://demo.nopcommerce.com/nokia-lumia-1020","this is nokia url assertion");
    }

    @Given("navigate to homepage link")
    public void navigateToHomepageLink() {

        homeSlider.goToHomepage();
    }

    @When("users click on iphone slider")
    public void usersClickOnIphoneSlider() {
        actualResult=homeSlider.directedToIphoneSliderPage();
    }

    @Then("directed to url contains iphone")
    public void urlIphoneAssertion() {
        Assert.assertEquals(actualResult,
                "https://demo.nopcommerce.com/iphone-6","this is iphone url assertion");
    }

   }
