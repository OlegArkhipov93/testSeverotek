package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.LoginPage;
import pages.MainPage;
import runner.Runner;

public class SeverotekTestBlog extends Runner {
    @BeforeTest
    public void login(String username, String password){
        new LoginPage(driver)
                .open("https://igorakintev.ru/admin/")
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp();
    }


    @Test(groups = {"actions with entries"})
    @Description("testing delete entry")
    public void deleteLastEntry() {
        new MainPage(driver)
                .openEntries()
                .clickLastCreatedEntry()
                .deleteLastEntry()
                .submitDeleteEntry();
        Assert.assertFalse(driver.getPageSource().contains("Title56435235"));
    }
}
