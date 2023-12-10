package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    protected PageBase(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**************ClickOnElement*******************/
    protected void clickEle(WebElement ele){

      ele.click();
    }
    /**************WriteText************************/
    protected void writeText(WebElement ele,String text){

        ele.sendKeys(text);
    }
    /**************SelectDDLByIndex*****************/
    protected void selectDDLByIndex(WebElement ele,int index){
        new Select(ele).selectByIndex(index);
    }
    /*************SelectDDLByVisibleText************/
    protected void selectDDLByVisibleText(WebElement ele,String text){
        new Select(ele).selectByVisibleText(text);
    }
    /*************HoveringAction********************/
    protected void hover(WebElement ele){

        actions=new Actions(driver);
        actions.moveToElement(ele).perform();
    }

    }




