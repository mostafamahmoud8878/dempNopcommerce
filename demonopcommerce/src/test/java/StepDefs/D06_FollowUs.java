package StepDefs;

import Pages.P00_Homepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D06_FollowUs {
    P00_Homepage homeFollowUs=new P00_Homepage(Hooks.driver);
    /**********************FacebookIcon*****************/
    @Given("the homepage")
    public void goToHomePage(){
        homeFollowUs.goToHomepage();
    }
    @When("user click on facebook icon")
    public void clickOnFacebookIcon(){
     homeFollowUs.clickOnFacebookIcon();
    }
    @Then("^facebook page ([^\"]*) will opened in new tab$")
    public void facebookUrlAssertion(String link){
        Assert.assertEquals(homeFollowUs.getUrlOfNewTab(),link,"this is facebook like assertion");
    }
    /*****************************TwitterIcon************/
    @Given("valid homepage")
    public void navigateToHomePage(){
        homeFollowUs.goToHomepage();
    }
    @When("user click on twitter icon")
    public void clickOnTwitterIcon(){
        homeFollowUs.clickOnTwitterIcon();
    }
    @Then("^twitter page ([^\"]*) will opened in new tab$")
    public void twitterUrlAssertion(String link){
        Assert.assertEquals(homeFollowUs.getUrlOfNewTab(),link,"this is twitter url assertion");
    }
    /*******************************RssIcon**************/
    @Given("website homepage")
    public void directedToHomePage(){
        homeFollowUs.goToHomepage();
    }
    @When("user click on rss icon")
    public void clickOnRssIcon(){
        homeFollowUs.clickOnRssIcon();
    }
    @Then("^rss page ([^\"]*) will opened in new tab$")
    public void rssUrlAssertion(String link){
        Assert.assertEquals(homeFollowUs.getUrlOfNewTab(),link,"this is rss url assertion");
    }

    /******************************YoutubeIcon*************/

    @Given("valid home link")
    public void goTOHomePage(){
        homeFollowUs.goToHomepage();
    }
    @When("user click on youtube icon")
    public void clickOnYoutubeIcon(){
        homeFollowUs.clickOnYoutubeIcon();
    }
    @Then("^youtube page ([^\"]*) will opened in new tab$")
    public void youtubeUrlAssertion(String link){
        Assert.assertEquals(homeFollowUs.getUrlOfNewTab(),link,"this is youtube url assertion");
    }
}
