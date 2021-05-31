package PageOperations;

import Utilities.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends WebElementFunctions {
    WebDriver driver;
    public CreateAccountPage(){ //constructor
        driver= WebConnector.getDriver();
        PageFactory.initElements(driver,this); // for cucumber tags (@FindBy, @FindAll etc.)
    }
    //click create account button
    @FindBy(id="createAccountSubmit")
    private WebElement createaccount;
    public void clickCreateAccountButton(){
        clickFunction(createaccount);
    }

    //type a name
    @FindBy(id = "ap_customer_name")
    private WebElement nametextbox;
    public void typeName(String name){
        sendKeysFunction(nametextbox, name);
    }

    //type an email
    @FindBy(id = "ap_email")
    private WebElement emailtextbox;
    public void typeEmail(String email){
        sendKeysFunction(emailtextbox, email);
    }

    //type a password
    @FindBy(xpath = "//input[@tabindex=5]")
    private WebElement passwordtextbox;
    public void typePassword(String password){
        sendKeysFunction(passwordtextbox, password);
    }

    //type repassword
    @FindBy(xpath = "//input[@tabindex=6]")
    private WebElement repasswordtextbox;
    public void typeRepassword(String repassword){
        sendKeysFunction(repasswordtextbox, repassword);
    }

    //click create account button
    @FindBy(id="continue")
    private WebElement amazonaccount;
    public void clickAmazonAccountButton(){
        clickFunction(amazonaccount);
    }

    //verify infos
    @FindBy(xpath = "//h1[text()='Verify e-mail address']")
    private WebElement verifying;
    public String verifyInfos(String value){
        return Assertion(verifying, value);
    }
    public void title(){
        System.out.println(driver.getTitle());
    }
}
