package org.authentication;

import org.baseTest.BaseTest;
import org.common.CommonAction;
import org.openqa.selenium.WebDriver;
import org.pages.BasePage;
import org.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Authentication extends BaseTest {
    @DataProvider(name = "userData")
    public Object[][] getUserData () {
        String userName_1 = "shmyakich@mail.ru";
        String password_1 = "karabambam14!";
        return new Object[][] {{userName_1, password_1}};
    }

    @Test (groups = "authentication", dataProvider = "userData")
    void signInPositive(String username, String password) throws HomePage.AuthenticationException {
        String actualResult;
        String expectedResult = username;

        actualResult = homePage.authorization(username, password).profileName();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (groups = "authentication", dataProvider = "userData")
    void exitPositive (String username, String password) throws HomePage.AuthenticationException {
        String actualResult;
        String expectedResult = "Войти";

        actualResult = homePage.authorization(username, password).exit().exitCheck();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
