package tests;

import helpers.StaticDataProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import runner.Runner;

public class SeverotekTestLogin extends Runner {


    @Test(groups = {"SmokeSingUp"}, dataProvider = "loginDataProvider", dataProviderClass = StaticDataProvider.class)
    @Description("testing login")
    public void testLoginPage(String username, String password){
        new LoginPage(driver)
                .open("https://igorakintev.ru/admin/")
                .setUserName(username)
                .setPassword(password)
                .clickSignUp();
        Assert.assertTrue(driver.getTitle().contains("Панель управления"));
    }

}
