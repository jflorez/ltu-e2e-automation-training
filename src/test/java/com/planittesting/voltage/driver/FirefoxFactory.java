package com.planittesting.voltage.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxFactory extends DriverFactory {
    @Override
    public FirefoxOptions getOptions() {
        var firefoxProfile = new FirefoxProfile();
        //these preferences are required for CDP to work in Firefox
        firefoxProfile.setPreference("fission.bfcacheInParent", false);
        firefoxProfile.setPreference("fission.webContentIsolationStrategy",0);
        var options = new FirefoxOptions();
        options.setLogLevel(FirefoxDriverLogLevel.FATAL);
        if (headless) options.addArguments("-headless");
        options.addArguments("-width 1920", "-height 1200");
        options.setProfile(firefoxProfile);
        return options;
    }

    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver(getOptions());
    }
}