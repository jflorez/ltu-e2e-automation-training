package com.planittesting.jupitertoys.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.jupitertoys.model.pages.HomePage;

class ShopTests extends BaseTest {
    
    @Test
    void validateProductPrice() {
        var product = open(HomePage.class)
            .clickShopMenu()
            .getProduct(p -> p.getTitle().endsWith("The Sequel") && p.getStars() == 3);
        var price = product.getPrice();
        assertEquals(10.99, price);
    }

}
