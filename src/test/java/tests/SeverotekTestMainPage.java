package tests;

import helpers.StaticDataProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;
import runner.Runner;

public class SeverotekTestMainPage extends Runner {

    @BeforeTest
    public void login() {
        new LoginPage(driver)
                .open("https://igorakintev.ru/admin/")
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp();
    }

    @Test(groups = {"testActionsWithEntries"})
    @Description("testing availability 'Добавить Entry'")
    public void testTitleEntries(){
        new MainPage(driver)
                .clickButtonAddEntries();
        Assert.assertTrue(driver.getTitle().contains("Добавить entry"));
    }

    @Test(groups = {"testActionsWithEntries"}, dataProvider = "entryFields", dataProviderClass = StaticDataProvider.class)
    @Description("Testing add Entry")
    public void testAddEntry(String title, String slug, String markdown, String text){
        new MainPage(driver)
                .clickButtonAddEntries()
                .setTitle(title)
                .setSlug(slug)
                .setMarkdown(markdown)
                .setText(text)
                .clickSaveButton()
                .open("http://igorakintev.ru/blog/");
        Assert.assertTrue(driver.getPageSource().contains(title));
    }

}
