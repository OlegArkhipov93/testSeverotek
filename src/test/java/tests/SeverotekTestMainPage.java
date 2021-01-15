package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import runner.Runner;

public class SeverotekTestMainPage extends Runner {
    @Test
    public void testTitleEntries(){
        new MainPage(driver)
                .open("https://igorakintev.ru/admin")
                .clickButtonAddEntries();
        Assert.assertTrue(driver.getTitle().contains("Добавить entry"));
    }
    @Test
    public void testAddEntry(){
        new MainPage(driver)
                .open("")
                .clickButtonAddEntries()
                .setTitle()
                .setSlug()
                .setMarkdown()
                .setText()
                .clickSaveButton()
                .open();
        Assert.assertTrue(driver.getPageSource().contains(title));
        Assert.assertTrue(driver.getPageSource().contains(slug));
    }

}
