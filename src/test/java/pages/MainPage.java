package pages;

import helpers.StableElementSearch;
import org.openqa.selenium.WebDriver;


public class MainPage implements StableElementSearch {

    WebDriver driver;



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

    public MainPage clickButtonAddEntries() {
        return this;
    }
    public MainPage setTitle(String title){
        return this;
    }
    public MainPage setSlug(String slug){
        return this;
    }
    public MainPage setMarkdown(String markdown){
        return this;
    }
    public MainPage setText(String text){
        return this;
    }
    public MainPage clickSaveButton(){
        return this;
    }

}
