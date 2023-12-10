package StepDefs;

import Pages.P00_Homepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D04_hoveringCategory {
    P00_Homepage homeHovering = new P00_Homepage(Hooks.driver);
    String[] result;

    @Given("link of homepage")
    public void goToHomePage() {
        homeHovering.goToHomepage();
    }

    @When("^user hover on main ([^\"]*) and select from it's sub categories$")
    public void hoveringOnComputers(String category) {
        result = homeHovering.hoveredAndSelectedCategory(category);
    }

    @Then("redirected to Selected category page")
    public void redirectedToSelectedCategoryAssertion() {
        Assert.assertEquals(result[0], result[1], "this is page header assertion");
    }
}