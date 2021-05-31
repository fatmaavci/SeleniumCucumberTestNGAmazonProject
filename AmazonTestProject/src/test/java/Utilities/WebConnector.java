package Utilities;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebConnector {
    public static WebDriver driver=null;
    //public static String url="https://www.amazon.co.uk/";


    /*public static WebDriver getDriver() {
        if (driver==null){
            System.setProperty("webdriver.chrome.driver","src/test/drivers/chromedriver");
            driver=new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }*/

    //public static void goToHomePage(WebDriver driver){
      //  driver.get(url);
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //}
    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> browserName = new ThreadLocal<>();
    public static WebDriver getDriver(){
        if (browserName.get()==null){
            browserName.set("chrome");
        }
        if (threadDriver.get()==null){
            switch (browserName.get()){

                //case "firefox":
                //    System.setProperty("webdriver.gecko.driver","src/test/drivers/...");
                //    threadDriver.set(new FirefoxDriver());

                  //  break;
               // case "edge":
               //     System.setProperty("webdriver.edge.driver", "src/test/drivers/....");
                //    threadDriver.set(new EdgeDriver());
                  //  break;
                default:
                    System.setProperty("webdriver.chrome.driver","src/test/drivers/chromedriver");
                    threadDriver.set(new ChromeDriver());
                    break;
            }

        } return threadDriver.get();
    }
    public void closeDriver(){
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}
