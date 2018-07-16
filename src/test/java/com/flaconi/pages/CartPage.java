package com.flaconi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends GeneralPage{

    private static final String HEADER = "//h2[text()='Warenkorb']";
    private static final String PRODUCT_PATTERN = "//div[@class='row product cell ']//div[contains(., '%s - %s')]//*[contains(., '%s %s ml')]//span[@class='price'][contains(., '%s €')]";

    CartPage(WebDriver extDriver) {
        super(extDriver);
        waitForElementVisibility(By.xpath(HEADER));
    }

    public void verifyProductInCart(String producer, String mark, String type, String price, String volume){
        log.info("Verify product presented in cart: " + producer + " " + mark + " " + price + " " + volume);
        Assert.assertTrue(isElementDisplayed(By.xpath(String.format(PRODUCT_PATTERN, producer, mark, type, volume, price))));
    }
}
