package com.planittesting.jupitertoys.model.pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.jupitertoys.model.components.Product;

public class ShopPage extends BasePage<ShopPage> {

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public Product getProduct(Function<Product, Boolean> condition) {
        var rootElements = driver.findElements(By.cssSelector("[data-locator='product']"));
        var product = rootElements.stream()
            .map(e -> new Product(e))
            .filter(p -> condition.apply(p))
            .findFirst()
            .orElseThrow();
        return product;
    }
}
