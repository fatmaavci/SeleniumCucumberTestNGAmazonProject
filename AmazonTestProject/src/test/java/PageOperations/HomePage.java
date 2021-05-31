package PageOperations;

import Utilities.WebConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//this class operate page functions
public class HomePage extends WebElementFunctions {
    WebDriver driver;

    public HomePage(){ //constructor
        driver= WebConnector.getDriver();
        PageFactory.initElements(driver,this); // for cucumber tags (@FindBy, @FindAll etc.)
    }

    //select Books from dropdown
    @FindBy(id="searchDropdownBox")
    private WebElement searchDropDownBox;
    public void selectBooksFromDropDown(String option){
        selectElementFromDropDown(searchDropDownBox, option);
    }

    //type book name
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;
    public void typeBookName(String bookname){
        sendKeysFunction(searchTextBox, bookname);
    }

    //click search button
    @FindBy(id ="nav-search-submit-text")
    private WebElement searchButton;
    public void clickSearchButton(){
        clickFunction(searchButton);
    }

    //Check if Book is a "Best Seller" or Not
    @FindBy(className = "a-badge-text")
    private WebElement bestSeller;
    public String checkIfItBestSeller(String best){
        return Assertion(bestSeller, best);
    }

    //verify author
    @FindBy(xpath = "//span[text()='J.K. Rowling'][1]")
    private WebElement author;
    public String verifyAuthor(String writer){
        return Assertion(author, writer);
    }

    // verify book name
    @FindBy(xpath = "/descendant::span[@class='a-size-medium a-color-base a-text-normal'][1]")
    private WebElement verifybookname;
    public String verifyTheBookName(String book){
        return Assertion(verifybookname, book);
    }

    //check the if Book is available in the format of a Kindle Edition
    @FindBy(xpath = "/descendant::a[@class='a-size-base a-link-normal a-text-bold'][3]") //first book's kindle Edition
    private WebElement kindleEdition;
    public String checkKindleEdition(String kindle){
        return Assertion(kindleEdition, kindle);
    }

    //click a book to buy
    @FindBy(xpath = "//img[@data-image-index='1']")
    //@FindBy(xpath="/descendant::a[@class='a-link-normal a-text-normal'][1]")
    private WebElement selectabooktobuy;
    public void clickABookToBuy(){
        clickFunction(selectabooktobuy);
    }
}
