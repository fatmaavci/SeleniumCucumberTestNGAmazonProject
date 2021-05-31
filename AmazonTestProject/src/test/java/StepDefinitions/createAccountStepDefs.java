package StepDefinitions;

import PageOperations.CreateAccountPage;
import PageOperations.HomePage;
import Utilities.WebConnector;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class createAccountStepDefs {
    WebDriver driver;
    CreateAccountPage createAccountPage = new CreateAccountPage();
    public static String url="https://www.amazon.co.uk/ap/signin?_encoding=UTF8&accountStatusPolicy=P1&openid.assoc_handle=gbflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.co.uk%2Fgp%2Fdigital%2Ffiona%2Fadd-to-wish-list.html%3Fie%3DUTF8%26ASIN.0%3DB017V51FEG%26anti-csrftoken-a2z%3DgEvEi6IeucICnIL2%252F%252FliB9wyufAzhRYBb4DP7asAAAAMAAAAAGC0Rv9yYXcAAAAA%26itemCount%3D1%26ref_%3Dwl%26rsid%3D257-2493604-6397030%26session-id%3D257-2493604-6397030%26sourceVendorId%3Dwebsite.audible.detail%26store%3Daudible%26submit.add-to-registry.wishlist%3DAdd%2520to%2520List%26wlPopCommand%3D";

    @Given("navigate to buy a book page")
    public void navigate_to_buy_a_book_page() {
        driver= WebConnector.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @And("click create your amazon account button")
    public void click_create_your_amazon_account_button() {
        createAccountPage.clickCreateAccountButton();
    }

    @When("type name {string}")
    public void type_name(String name) {
        createAccountPage.typeName(name);
    }
    @And("type email {string}")
    public void type_email(String email) {
        createAccountPage.typeEmail(email);
    }
    @And("type password{string}")
    public void type_password(String password) {
        createAccountPage.typePassword(password);
    }
    @And("type repassword{string}")
    public void type_repassword(String repassword) {
        createAccountPage.typeRepassword(repassword);
    }
    @And("click Amazon Account button")
    public void click_amazon_account_button() {
        createAccountPage.clickAmazonAccountButton();
    }

    @After

    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        WebConnector.getDriver();
    }
}
