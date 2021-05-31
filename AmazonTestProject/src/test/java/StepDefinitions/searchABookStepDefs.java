package StepDefinitions;

import PageOperations.HomePage;
import Utilities.WebConnector;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class searchABookStepDefs {
    WebDriver driver;
    HomePage homePage = new HomePage();
    public static String url="https://www.amazon.co.uk/";

    @Given("navigate to Amazon home page")
    public void navigate_to_amazon_home_page() {
        driver= WebConnector.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("select {string} option from dropdown")
    public void select_option_from_dropdown(String string) {
        homePage.selectBooksFromDropDown(string);
    }

    @Given("enter the {string} in the textbox")
    public void enter_the_in_the_textbox(String string) {
        homePage.typeBookName(string);
    }

    @When("click the search button")
    public void click_the_search_button() {
        homePage.clickSearchButton();
    }

    @Then("check if the book is a {string}")
    public void check_if_the_book_is_a(String string) {
        String message=homePage.checkIfItBestSeller(string);
        System.out.println("The book is a " + message);
    }

    @Then("verify author {string}")
    public void verify_author(String string) {
        String message= homePage.verifyAuthor(string);
        System.out.println("Book's author is " + message);
    }
    @Then("verify the book name")
    public void verify_the_book_name() {
        String bn="Harry Potter and the Philosopher's Stone, Book 1";
        String message= homePage.verifyTheBookName(bn);
        System.out.println("The book name is " + message);
    }
    @Then("check the book has {string}")
    public void check_the_book_has_kindle_edition(String string) {
        String message= homePage.checkKindleEdition(string);
        System.out.println("The book is available in the format of a  " + message);
    }
   /* @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);

        WebConnector.getDriver();
    }*/
    //@Then("select the book to buy")
    //public void select_the_book_to_buy() {
     //   homePage.clickABookToBuy();
    //}
}
