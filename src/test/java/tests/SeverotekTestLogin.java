package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import runner.Runner;

public class SeverotekTestLogin extends Runner {
    @Test
    public void testLoginPage(){
        new LoginPage(driver)
                .open()
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp();
        Assert.assertTrue(driver.getTitle().contains("Панель управления"));
    }


}
