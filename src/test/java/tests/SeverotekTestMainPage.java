package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import runner.Runner;

public class SeverotekTestMainPage extends Runner {

    @BeforeTest
    public void login(){
        new LoginPage(driver)
                .open()
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp();
    }

    @Test
    public void testTitleEntries(){
        new MainPage(driver)
                .clickButtonAddEntries();
        Assert.assertTrue(driver.getTitle().contains("Добавить entry"));
    }

    @Test
    @Description("Test add Entry")
    public void testAddEntry(){
        new MainPage(driver)
                .clickButtonAddEntries()
                .setTitle("Title56435235")
                .setSlug("Slug56435235")
                .setMarkdown("Markdown56435235")
                .setText("Text56435235")
                .clickSaveButton()
                .open("http://igorakintev.ru/blog/");
        Assert.assertTrue(driver.getPageSource().contains("Title56435235"));
    }

}
