package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class P00_Homepage extends PageBase {
    public P00_Homepage(WebDriver driver) {
        super(driver);
    }

    /*********************HomepageLink****************/
    public WebElement homePageLink() {
        return driver.findElement(By.className("header-logo"));
    }

    public void goToHomepage() {
        clickEle(homePageLink());
    }

    /*******************RegisterLinkElement***********/
    protected WebElement registerLink() {

        return driver.findElement(By.className("ico-register"));
    }

    /*******************LoginLink**********************/

    protected WebElement loginLink() {

        return driver.findElement(By.className("ico-login"));
    }

    /*******************MyAccountTabLink********************/
    protected WebElement myAccountTab() {

        return driver.findElement(By.className("ico-account"));
    }


    /****************CurrenciesDDL**************************/
    protected WebElement currenciesDDL() {
        return driver.findElement(By.id("customerCurrency"));
    }

    public void selectEuroFromDDl() {
        selectDDLByVisibleText(currenciesDDL(), "Euro");
    }

    public List<WebElement> prices() {


        return driver.findElements(By.className("actual-price"));

    }

    /************************SearchFunctionality*****************/

    protected WebElement SearchBox() {
        return driver.findElement(By.className("search-box-text"));
    }

    protected WebElement searchButton() {
        return driver.findElement(By.className("search-box-button"));
    }

    public List<WebElement> getProductTitle() {
        return driver.findElements(By.className("product-title"));
    }


    public void inputSearchQuery(String product) {
        writeText(SearchBox(), product);
    }

    public void clickOnSearchButton() {
        clickEle(searchButton());
    }

    /***************************SearchingBySku****************************/

    protected WebElement getProduct() {
        return driver.findElement(By.className("picture"));
    }

    protected WebElement getSkuElement() {
        return driver.findElement(By.className("sku"));
    }

    public void clickOnProduct() {
        clickEle(getProduct());
    }

    public String getSkuText() {
        clickOnProduct();
        return getSkuElement().getText();
    }

    /***********************Hovering******************/


    protected WebElement pageHeader() {
        return driver.findElement(By.className("page-title"));
    }

    protected WebElement subList() {
        return driver.findElement(By.className("sublist"));
    }

    protected List<WebElement> mainMenuCategories() {
        return driver.findElements(By.xpath("//*[contains(@class,'header-menu')]/ul/li/a[contains(@href,'/')]"));
    }

    protected List<WebElement> subCategories() {
        return driver.findElements(By.xpath("//ul[contains(@class,'sublist')]/li/a[contains(@href,'/')]"));
    }


    public String getPageHeaderText() {

        return pageHeader().getText();

    }

    public WebElement selectMainCategory(String ele) {
        WebElement element = null;
        for (int i = 0; i < mainMenuCategories().size(); i++) {
            if (Objects.equals(mainMenuCategories().get(i).getText(), ele)) {
                element = mainMenuCategories().get(i);
            }
        }
        return element;
    }


    public String[] hoveredAndSelectedCategory(String category) {
        hover(selectMainCategory(category));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        if (subList().isDisplayed()) {
            String actualResult = subCategories().get(0).getText().toLowerCase().trim();
            subCategories().get(0).click();
            String expectedResult = getPageHeaderText().toLowerCase().trim();
            String[] results = new String[2];
            results[0] = actualResult;
            results[1] = expectedResult;
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return results;
        } else {


            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            String actualResult = selectMainCategory(category).getText().toLowerCase().trim();
            clickEle(selectMainCategory(category));
            String expectedResult = getPageHeaderText().toLowerCase().trim();
            String[] results = new String[2];
            results[0] = actualResult;
            results[1] = expectedResult;
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return results;
        }

    }

    /******************************HomepageSliders************************************/
    protected WebElement homepageIphoneSlider() {
        return driver.findElement(By.xpath("//img [contains(@src,'https://demo.nopcommerce.com/images/thumbs/0000088_banner_01.webp')] "));
    }

    protected WebElement homepageNokiaSlider() {
        return driver.findElement(By.xpath("//img [contains(@src,'https://demo.nopcommerce.com/images/thumbs/0000089_banner_02.webp')] "));
    }


    public WebElement checkIfIphoneSliderSIsClickable() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait1.until(ExpectedConditions.elementToBeClickable(homepageIphoneSlider()));

    }

    public WebElement checkIfNokiaSliderSIsClickable() {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait1.until(ExpectedConditions.elementToBeClickable(homepageNokiaSlider()));

    }


    public String directedToIphoneSliderPage() {
        if (homepageIphoneSlider().isDisplayed() && homepageIphoneSlider().isEnabled()) {
            clickEle(checkIfIphoneSliderSIsClickable());
        }
        return driver.getCurrentUrl();
    }

    public String directedToNokiaSliderPage() {
        if (homepageNokiaSlider().isDisplayed() && homepageNokiaSlider().isEnabled()) {
            clickEle(checkIfNokiaSliderSIsClickable());
        }
        return driver.getCurrentUrl();
    }


    /****************************FollowUS*****************************/
    protected WebElement facebookIcon() {
        return driver.findElement(By.className("facebook"));
    }
    protected WebElement twitterIcon(){
        return driver.findElement(By.className("twitter"));
    }
    protected WebElement rssIcon(){
        return driver.findElement(By.className("rss"));
    }
    protected WebElement youtubeIcon(){
        return driver.findElement(By.className("youtube"));
    }
    public void clickOnFacebookIcon(){
        facebookIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));


    }
    public void clickOnTwitterIcon(){
        twitterIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));


    }
    public void clickOnRssIcon(){
        rssIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));


    }
    public void clickOnYoutubeIcon(){
        youtubeIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    }
    public String getUrlOfNewTab(){
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }
/************************************Wihslist****************************/
protected WebElement wishlistIcon(){
    return driver.findElement(By.xpath("(//div[contains(@class,'buttons')]/button[3])[3]"));
}

protected WebElement wishlistLink(){
    return driver.findElement(By.className("ico-wishlist"));
}
protected WebElement notificationBar(){
    return driver.findElement(By.className("bar-notification"));
}
protected WebElement closeButton(){
    return driver.findElement(By.className("close"));
}
protected WebElement WishlistQtyInput(){
    return driver.findElement(By.className("qty-input"));
}

public void clickOnWishlistIcon(){
    wishlistIcon().click();
}
public String[] getSuccessMessageText() {
    String[] results = new String[2];
    results[0] =notificationBar().getText();
    results[1] ="The product has been added to your wishlist";
    return results;
}
public String[] successMessageBackgroundColor(){
    String[]results=new String[2];
    results[0]= Color.fromString(notificationBar().getCssValue("background-color")).asHex();
    results[1]="#4bb07a";
    return results;
}
public String getQTYValue(){
    return WishlistQtyInput().getAttribute("value");
}
public void clickOnWishlistLink(){
    wishlistLink().click();
}
public void closeNotificationBar(){
    closeButton().click();
}
}


