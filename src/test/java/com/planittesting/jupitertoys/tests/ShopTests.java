package com.planittesting.jupitertoys.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.planittesting.jupitertoys.model.pages.HomePage;
import com.planittesting.jupitertoys.tests.support.dataproviders.WithJson;
import com.planittesting.jupitertoys.tests.support.dataproviders.apiMocks.ProductListMock;


class ShopTests extends BaseTest {
    
    @Test
    void validateProductPrice() {
        var product = open(HomePage.class)
            .clickShopMenu()
            .getProduct(p -> p.getTitle().endsWith("The Sequel") && p.getStars() == 3);
        var price = product.getPrice();
        assertEquals(10.99, price);
    }



    @ExtendWith(ProductListMock.class)
    @WithJson("""
    [{
        "quantity": "2000",
        "visible": "true",
        "image": "https://c2.staticflickr.com/4/3042/2762123727_db6d650cf2_b.jpg",
        "category": "Stuffed Toys",
        "price": "-999",
        "id": "9ba9a21a-2b78-49e3-9a55-fbfc4a15ccf6",
        "stars": "4",
        "title": "Mocked Quokka"
    },
    {
        "quantity": "2000",
        "visible": "true",
        "image": "https://static01.nyt.com/images/2017/08/01/science/29TB-PLATYPUS1/29TB-PLATYPUS1-videoSixteenByNineJumbo1600.jpg",
        "category": "Stuffed Toys",
        "price": "-1",
        "id": "9ba9a21a-2b78-49e3-9a55-fbfc4a15ccf7",
        "stars": "4",
        "title": "PLATYPUS"
    }]
    """)
    @Test
    void testIntercetorExample() {
        var price = open(HomePage.class)
			.clickShopMenu()
			.getProduct(p->p.getTitle().equals("Mocked Quokka"))
			.getPrice();
            assertEquals(-999, price);
    }

}
