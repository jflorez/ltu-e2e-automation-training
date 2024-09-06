package com.planittesting.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariFactory extends DriverFactory {
    @Override
    public SafariOptions getOptions() {
        return new SafariOptions();
    }

    @Override
    public WebDriver getDriver() {
        return new SafariDriver(getOptions());
    }
}
