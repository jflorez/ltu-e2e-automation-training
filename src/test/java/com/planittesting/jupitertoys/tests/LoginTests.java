package com.planittesting.jupitertoys.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.jupitertoys.model.pages.HomePage;

class LoginTests extends BaseTest {
    @Test
    void validateLogin() {
        var user = open(HomePage.class)
            .clickContactMenu()
            .clickLoginMenu()
            .setUsername("itsmemario")
            .setPassword("letmein")
            .clickAgreeTermsOfService()
            .clickLoginButton()
            .getUser();

        assertEquals("Hi itsmemario", user);
    }
}
