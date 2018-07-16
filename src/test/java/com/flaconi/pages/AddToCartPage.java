package com.flaconi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends GeneralPage {

    private static final String POSITION_PATTERN = "//span[@class='price'][contains(., '%s')]/../../../..//button[contains(., 'In den Warenkorb')]";

    AddToCartPage(WebDriver extDriver) {
        super(extDriver);
    }

    public CartPage addToCart(String prise){
        log.info("Add to cart product with price: " + prise);
        click(By.xpath(String.format(POSITION_PATTERN, prise)));
        return new CartPage(driver);
    }
}
