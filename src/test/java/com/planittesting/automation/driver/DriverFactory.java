package com.planittesting.automation.driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.reflections.Reflections;

public abstract class DriverFactory {
    public abstract Capabilities getOptions();
    public abstract WebDriver getDriver();

    protected boolean headless = true;
    protected Optional<URL> gridUrl = Optional.ofNullable(null);
    protected String version = "latest";

    public DriverFactory withHeadless(boolean headless) {
        this.headless = headless;
        return this;
    }

    public DriverFactory withVersion(String version) {
        this.version = version;
        return this;
    }

    public DriverFactory withGridUrl(String gridUrl) throws MalformedURLException, URISyntaxException {
        URL url = gridUrl != null && !gridUrl.isEmpty()? new URI(gridUrl).toURL() : null;
        this.gridUrl = Optional.ofNullable(url);
        return this;
    }

    public WebDriver build() {
        var driver = gridUrl
            .map(url -> (WebDriver)new RemoteWebDriver(url, this.getOptions()))
            .orElseGet(() -> this.getDriver());
        return new Augmenter().augment(driver);
    }

    /**
     * Creates an instance of a DriverFactory 
     * and calls the getDriver methodd to instantiate the WebDriver
     * @param browser Name of the browser to instantiate
     * @return DriverFactory instance of type hinted by the browser parameter
     * @throws Exception Thrown if the browser is not yet supported. To add support for a new browser create a new class that extends DriverFactory
     */
    public static DriverFactory getFactory(String browser) throws Exception {
        var driverClasses = new ArrayList<>(
                new Reflections(DriverFactory.class.getPackageName()).getSubTypesOf(DriverFactory.class));
        return driverClasses.stream()
                .filter(driverClass -> driverClass.getSimpleName().toLowerCase().contains(browser.toLowerCase())).findFirst()
                .orElseThrow(() -> new RuntimeException("Browser: '" + browser + "'' is not a supported browser"))
                .getConstructor()
                .newInstance();
    }
}