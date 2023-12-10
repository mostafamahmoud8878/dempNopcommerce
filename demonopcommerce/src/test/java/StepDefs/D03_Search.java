package StepDefs;

import Pages.P00_Homepage;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class D03_Search {
    P00_Homepage homeSearch=new P00_Homepage(Hooks.driver);

    @Given("homepage link")
    public void goToHomePage(){
        homeSearch.goToHomepage();
    }

    @When("^users enter search keyword as ([^\"]*)$")
    public void inputSearchQueryAsProductNameAs(String product)  {
        homeSearch.inputSearchQuery(product);

    }

    @And("users press on search button")
    public void pressOnSearchButton(){

        homeSearch.clickOnSearchButton();

    }


    @Then("directed to url contains search?q=")
    public void urlAssertion(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=")
                ,"this is url assertion");
    }
    @And("^displayed relevant results to the ([^\"]*)$")
    public void ValidateResults(String product){
        for (int i = 0 ; i < homeSearch.getProductTitle().size();i++)
        {
            SoftAssert softAssert=new SoftAssert();

            softAssert.assertTrue(homeSearch.getProductTitle().get(i).getText().toLowerCase().contains(product),
                    "this is results assertion");
        }
    }
    /*********************userCanSearchUsingSKU*********************/
    @Given("homepage")

    public void goToHomePageLink(){
        homeSearch.goToHomepage();
    }
    @When("^users enter search query as ([^\"]*)$")
    public void inputSearchQueryAsSku(String sku){

        homeSearch.inputSearchQuery(sku);
    }
    @And("users clicked search button")
    public void clickOnSearchButton(){
        homeSearch.clickOnSearchButton();
    }

    @Then("directed to url which contains search?q=")
    public void directedToUrlWhichContainsSearchQ() {

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=")
                ,"this is url assertion");

    }

    @And("^relevant ([^\"]*) result displayed$")
    public void relevantSkuResultDisplayed(String sku) {
        Assert.assertEquals(homeSearch.getSkuText(),"SKU: "+sku,"this is sku Assertion");
    }
}
