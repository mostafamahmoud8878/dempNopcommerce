package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class P02_Login extends PageBase{

    public P02_Login(WebDriver driver){
        super(driver);
    }

    @FindBy
            (id = "Email")
    WebElement emailField;

    @FindBy
            (id="Password")WebElement passwordField;


    @FindBy
            (className = "login-button") WebElement loginButton;

    @FindBy(className = "message-error") WebElement messageError;


    /**********************LoginWithValidCredential*****************/

    public void clickOnLoginLink(){

       clickEle(new P00_Homepage(driver).loginLink());
    }
    public void inputValidEmail(){

        writeText(emailField,"test@gmail.com");
    }
    public void inputValidPassword(){
        writeText(passwordField,"P@ssw0rd");
    }
    public void clickLoginButton(){
        clickEle(loginButton);
    }

    public String[] redirectedToHomepageAssertion(){

        String actualResult=driver.getCurrentUrl();
        String expectedResult="https://demo.nopcommerce.com/";
        String[] results=new String[2];
        results[0]=actualResult;
        results[1]=expectedResult;
        return results;
    }
    public void myAccountTabIsDisplayed(){

        try {new P00_Homepage(driver).myAccountTab().isDisplayed();}
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

     /***********************LoginWithInvalidCredential**********************/

     public void inputInvalidEmail(){
         writeText(emailField,"wrong@example.com");
     }
     public String[] errorMessageTextAssertions(){
         String actualResult=messageError.getText();
         String expectedResult="Login was unsuccessful.";
         String[] results=new String[2];
         results[0]=actualResult;
         results[1]=expectedResult;
         return results;
     }

     public String [] errorMessageColorAssertions(){

         String actualResult= Color.fromString(messageError.getCssValue("color")).asHex();
         String expectedResult="#e4434b";
         String [] results=new String[2];
         results[0]=actualResult;
         results[1]=expectedResult;
         return results;
     }

}
