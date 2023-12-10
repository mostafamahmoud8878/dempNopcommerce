package StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

  public static WebDriver driver;
    @Before
    public void setUpEnvironment(){
        //*********************-Navigate-*************************//
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        //*******************-Configurations-********************//
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

