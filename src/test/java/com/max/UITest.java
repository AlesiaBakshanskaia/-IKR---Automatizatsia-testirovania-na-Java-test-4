package com.max;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class UITest extends UIAbstractTest{

    @Test
    void testGBNotEmailLogin() {
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.authorize("login", "password");

        Assertions.assertFalse(loginPage.getParsleyErrorLogin().isEmpty());
        Assertions.assertEquals("Введите адрес электронной почты.",
                loginPage.getParsleyErrorLogin().get(0).getText());
    }

    @Test
    void testGBWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.authorizeWithoutPassword("login@login.ru");
//        loginPage.authorize("login", "");//второй вариант

        Assertions.assertFalse(loginPage.getParsleyErrorPassword().isEmpty());

    }

}
