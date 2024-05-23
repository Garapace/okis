package org.authorization;

import org.baseTest.BaseTest;
import org.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest {
    @DataProvider(name = "userData")
    public Object[][] getUserData () {
        String username_1 = "shmyakich@mail.ru";
        String password_1 = "karabambam14!";
        return new Object[][] {{username_1, password_1}};
    }

    @Test (groups = "authorization", dataProvider = "userData")
    void authorizationPositive(String username, String password) throws HomePage.AuthenticationException {
        String actualResult;
        String expectedResult = username;

        actualResult = HomePage.authorization(username, password).profileName();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (groups = "authorization", dataProvider = "userData")
    void exitPositive (String username, String password) throws HomePage.AuthenticationException {
        String actualResult;
        String expectedResult = "Войти";

        actualResult = HomePage.authorization(username, password).exit().exitCheck();

        Assert.assertEquals(actualResult, expectedResult);
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    @Test (groups = "authorization", dataProvider = "userData", expectedExceptions = {HomePage.AuthenticationException.class})
    void authorizationLoginNegative (String username, String password) throws HomePage.AuthenticationException {
        String invalidLogin = reverseString(username);
        HomePage.authorization(invalidLogin, password);
    }

    @Test (groups = "authorization", dataProvider = "userData", expectedExceptions = {HomePage.AuthenticationException.class})
    void authorizationPasswordNegative (String username, String password) throws HomePage.AuthenticationException {
        String invalidPassword = reverseString(password);
        HomePage.authorization(username, invalidPassword);
    }

    @Test (groups = "authorization", dataProvider = "userData", expectedExceptions = {HomePage.AuthenticationException.class})
    void exitNegative (String username, String password) throws HomePage.AuthenticationException {
        HomePage.exit();
    }
}
