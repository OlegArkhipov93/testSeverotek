package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.LoginPage;
import pages.MainPage;
import runner.Runner;

public class SeverotekTestBlog extends Runner {
    @BeforeTest
    public void login(){
        new LoginPage(driver)
                .open()
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp();
    }

    @Test
    public void deleteLastEntry() {
        new MainPage(driver)
                .openEntries()
                .clickLastCreatedEntry()
                .deleteLastEntry()
                .submitDeleteEntry();
        Assert.assertFalse(driver.getPageSource().contains("Title56435235"));
    }
}
