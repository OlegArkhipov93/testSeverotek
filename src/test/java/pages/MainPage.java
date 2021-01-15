package pages;

import helpers.StableElementSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.jq.Main;
import tests.SeverotekTestMainPage;


public class MainPage implements StableElementSearch {

    WebDriver driver;
    By usernameField = By.cssSelector("input#id_username"); // or By.xpath("//input[@id='id_username']")
    By passwordField = By.cssSelector("input#id_password"); // or By.xpath("//input[@id='id_password']")
    By signUpButton = By.xpath("//input[@type='submit']");

    By addEntry = By.xpath("//a[@href='/admin/blog/entry/add/']");
    By addEntryTitle = By.cssSelector("input#id_title");
    By addEntrySlug = By.cssSelector("input#id_slug");
    By addEntryTextMarkdown= By.cssSelector("textarea#id_text_markdown");
    By addEntryText = By.cssSelector("textarea#id_text");
    By saveButton = By.xpath("//input[@name='_save']");

//    By checkBoxLastEntry = By.xpath("//td//input[@value='3530']"); // or By.cssSelector("input.action-select[value='']")
//    By selector = By.cssSelector("select");
//    By executeButton = By.cssSelector("button.button");
    By submitButton = By.cssSelector("input[type='submit']");
    By deleteButton = By.cssSelector("a[class='deletelink']");
    By lastCreatedEntry = By.linkText("Title56435235");




    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }

    public MainPage open(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return new MainPage(driver);
    }
    public MainPage setUserName(String username) {
        searchElementByCss(usernameField).sendKeys(username);
        return new MainPage(driver);
    }

    public MainPage setPassword(String password) {
        searchElementByCss(passwordField).sendKeys(password);
        return new MainPage(driver);
    }

    public MainPage clickSignUp() {
        searchElementByXpath(signUpButton).click();
        return new MainPage(driver);
    }

    public MainPage clickButtonAddEntries() {
        searchElementByXpath(addEntry).click();
        return new MainPage(driver);
    }
    public MainPage setTitle(String title){
        searchElementByCss(addEntryTitle).sendKeys(title);
        return new MainPage(driver);
    }
    public MainPage setSlug(String slug){
        searchElementByCss(addEntrySlug).sendKeys(slug);
        return new MainPage(driver);
    }
    public MainPage setMarkdown(String markdown){
        searchElementByCss(addEntryTextMarkdown).sendKeys(markdown);
        return new MainPage(driver);
    }
    public MainPage setText(String text){
        searchElementByCss(addEntryText).sendKeys(text);
        return new MainPage(driver);
    }
    public MainPage clickSaveButton(){
        searchElementByXpath(saveButton).click();
        return new MainPage(driver);
    }


//    public MainPage clickCheckboxLastEntry(){
//        searchElementByXpath(checkBoxLastEntry).click();
//        return this;
//    }

//    public MainPage selectLastEntry() {
//        Select dpEntries = new Select(searchElementByCss(selector));
//        dpEntries.selectByVisibleText("Удалить выбранные Entries");
//        return this;
//    }

    public MainPage clickLastCreatedEntry() {
        driver.findElement(lastCreatedEntry).click();
        return this;
    }

    public MainPage deleteLastEntry() {
        searchElementByCss(deleteButton).click();
        return this;
    }

    public MainPage submitDeleteEntry() {
        searchElementByCss(submitButton).click();
        return new MainPage(driver);
    }
}
