package pages;

import helpers.StableElementSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage implements StableElementSearch {

    WebDriver driver;

    By usernameField = By.cssSelector("input#id_username"); // or By.xpath("//input[@id='id_username']")
    By passwordField = By.cssSelector("input#id_password"); // or By.xpath("//input[@id='id_password']")
    By signUpButton = By.xpath("//input[@type='submit']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }

    public LoginPage open() {
        driver.get("https://igorakintev.ru/admin/");
        driver.manage().window().maximize();
        return new LoginPage(driver);
    }

    public LoginPage setUserName(String username) {
        searchElementByCss(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        searchElementByCss(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickSignUp() {
        searchElementByXpath(signUpButton).click();
        return this;
    }
}
