package com.planittesting.jupitertoys.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
    private WebElement rootElement;

    public Product(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    public String getTitle() {
        return rootElement.findElement(By.cssSelector("[data-locator='product-title']")).getText();
    }

    public double getPrice() {
        var priceAsText = rootElement.findElement(By.cssSelector("[data-locator='product-price']")).getText();
        return Double.parseDouble(priceAsText.replace("$", ""));
    }

    public int getStars() {
        return Integer.parseInt(rootElement.findElement(By.cssSelector("[data-locator='rating-value']")).getText());
    }
}
