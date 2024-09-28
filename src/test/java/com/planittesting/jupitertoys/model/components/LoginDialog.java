package com.planittesting.jupitertoys.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginDialog<T> {
    private WebElement rootElement;
    private T parent;

    public LoginDialog(WebElement rootElement, T parent) {
        this.rootElement = rootElement;
        this.parent = parent;
    }

    public LoginDialog<T> setUsername(String username) {
        rootElement.findElement(By.id("username")).sendKeys(username);
        return this;
    }

    public LoginDialog<T> setPassword(String password) {
        rootElement.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public LoginDialog<T> clickAgreeTermsOfService() {
        rootElement.findElement(By.id("agree")).click();
        return this;
    }

    public T clickLoginButton() {
        rootElement.findElement(By.id("modal-log-in-button")).click();
        return parent;
    }
}
