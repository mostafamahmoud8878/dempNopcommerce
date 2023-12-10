package StepDefs;

import Pages.P00_Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D00_Homepage {

    P00_Homepage home=new P00_Homepage(Hooks.driver);
    @Given("valid homepage link")
    public void goToHomePage(){
       home.goToHomepage();
    }
    @When("users selected euro currency from DDl")
    public void selectEuroFromDDl(){
        home.selectEuroFromDDl();
    }
    @Then("euro symbol is shown on 4 products displayed on homepage")
    public void validateEuroSymbolIsShown(){
        for(int i=0;i<home.prices().size();i++){
           String price = home.prices().get(i).getText();
            Assert.assertTrue(price.contains("€"),"this is euro Assertions");
        }
    }

}
