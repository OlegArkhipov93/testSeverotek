package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import runner.Runner;

public class SeverotekTestMainPage extends Runner {
    @Test
    public void testTitleEntries(){
        new MainPage(driver)
                .open("https://igorakintev.ru/admin")
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp()
                .clickButtonAddEntries();
        Assert.assertTrue(driver.getTitle().contains("Добавить entry"));
    }
    @Test
    public void testAddEntry(){
        new MainPage(driver)
                .open("https://igorakintev.ru/admin")
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp()
                .clickButtonAddEntries()
                .setTitle("Title56435235")
                .setSlug("Slug56435235")
                .setMarkdown("Markdown56435235")
                .setText("Text56435235")
                .clickSaveButton()
                .open("http://igorakintev.ru/blog/");
        Assert.assertTrue(driver.getPageSource().contains("Title56435235"));
        Assert.assertTrue(driver.getPageSource().contains("Slug56435235"));
    }
    @Test
    public void deleteLastEntry() {
        new MainPage(driver)
                .open("https://igorakintev.ru/admin/blog/entry/")
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp()
                .clickLastCreatedEntry()
                .deleteLastEntry()
                .submitDeleteEntry();
        Assert.assertFalse(driver.getPageSource().contains("Title56435235"));
    }

}
