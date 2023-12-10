package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class P01_Register extends PageBase{


    /**********************Constructor*****************/
    public P01_Register(WebDriver driver){
        super(driver);
    }

    /*********************FetchingElements**************/
    @FindBy(id="gender-male")
    WebElement gender;
    @FindBy(id="FirstName") WebElement firstName;
    @FindBy(id="LastName") WebElement lastName;
    @FindBy(name="DateOfBirthDay") WebElement dayOfBirth;
    @FindBy(name = "DateOfBirthMonth") WebElement monthOfBirth;
    @FindBy(name = "DateOfBirthYear") WebElement yearOfBirth;
    @FindBy(id="Email") WebElement email;
    @FindBy(id="Company") WebElement company;
    @FindBy(id="Password") WebElement password;
    @FindBy(id="ConfirmPassword") WebElement passwordConfirmation;
    @FindBy(id="register-button") WebElement registerButton;




    public WebElement getResultElement(){
        return driver.findElement(By.className("result"));
    }

    public void clickOnRegisterLink(){
        clickEle(new P00_Homepage(driver).registerLink());
    }


    public void setGender(){
       clickEle(gender);
    }

    public void setFirstName(){
        writeText(firstName,"Automation");
    }

    public void setLastName(){
        writeText(lastName,"Tester");
    }


    public void setDayOfBirth(){
        selectDDLByIndex(dayOfBirth,10);
    }

    public void setMonthOfBirth(){
        selectDDLByVisibleText(monthOfBirth,"April");
    }
    public void setYearOfBirth(){
        selectDDLByVisibleText(yearOfBirth,"1995");
    }
    public void setEmail(){
        writeText(email,"Tester@gmail.com");
    }
    public void setCompany(){
        writeText(company,"Amit");
    }
    /************************PasswordGetter*************/
    public String getPassword(){

        return "P@ssw0rd";
    }
    public void setPassword(){
        writeText(password,getPassword());
    }
    public void setPasswordConfirmation(){
        writeText(passwordConfirmation,getPassword());
    }

    public void submitRegistration(){
        clickEle(registerButton);
    }
    public String[] getResultColorAssertion(){

        String actualResultOfMessageColor= Color.fromString(getResultElement().getCssValue("color")).asHex();
        String expectedResultOfMessageColor="#4cb17c";
        String[] assertions=new String[2];
        assertions[0]=actualResultOfMessageColor;
        assertions[1]=expectedResultOfMessageColor;

        return assertions;
    }
    public String[] getResultTextAssertion(){
        String actualResultOfMessageText=getResultElement().getText();
        String expectedResultOfMessageText="Your registration completed";
        String[] assertions=new String[2];
        assertions[0]=actualResultOfMessageText;
        assertions[1]=expectedResultOfMessageText;

        return assertions;
    }

}
