package StepDefs;

import Pages.P00_Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D07_Wishlist {
    P00_Homepage wishlistHome=new P00_Homepage(Hooks.driver);
    @Given("valid link of homepage")
    public void goToHomePage(){
        wishlistHome.goToHomepage();
    }
    @When("user clicked on heart icon")
    public void clickOnHeartIcon(){
        wishlistHome.clickOnWishlistIcon();
    }
    @Then("success message \"The product has been added to your wishlist\" with green background color appeared")
    public void successMessageValidation(){
        Assert.assertEquals(wishlistHome.getSuccessMessageText()[0],wishlistHome.getSuccessMessageText()[1],"this is text assertion");
        Assert.assertEquals(wishlistHome.successMessageBackgroundColor()[0],wishlistHome.successMessageBackgroundColor()[1],"this is background color assertion");
    }
    /***********************scenario2*********************************/
    @Given("valid home")
    public void goTOHomePage(){
        wishlistHome.goToHomepage();
    }
    @When("user click on heart icon of the HTC One M8 Android L 5.0 Lollipop product")
    public void clickOnWishlistIcon(){
        wishlistHome.clickOnWishlistIcon();
        wishlistHome.closeNotificationBar();

    }
    @And("go to wishlist page")
    public void goToWishlistPage(){
        wishlistHome.clickOnWishlistLink();
    }
    @Then("product added to wishlist successfully")
    public void wishlistQTYValidation(){

        int qty=Integer.parseInt(wishlistHome.getQTYValue());
        Assert.assertTrue(qty>0,"passed");

    }
}
