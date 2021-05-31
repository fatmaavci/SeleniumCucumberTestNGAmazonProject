package PageOperations;
import Utilities.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

//this class operates web element functions (click, select  etc.)
public abstract class WebElementFunctions {
    private WebDriver driver= WebConnector.getDriver();
    WebDriverWait wait= new WebDriverWait(driver,10);


    //for dropdown element operations
    public  void selectElementFromDropDown(WebElement dropdown, String element){
        Select slc=new Select(dropdown);
        slc.selectByVisibleText(element);
    }
    //for send a value for a element like textbox
    public void sendKeysFunction(WebElement sendKeysElement,String value){
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }
    //for click a button or any other clickable elements
    public void clickFunction(WebElement clickElement){
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }
    //to verify something
    public String Assertion(WebElement actual,String expected){
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText(),expected); //wait until the text appear
        return actual.getText();
    }
}
