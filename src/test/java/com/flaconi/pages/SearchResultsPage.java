package com.flaconi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultsPage extends GeneralPage {

    private static final String RESULTS_LIST = PAGE_HEADER + "/../../..//div[@class='product-item-box']";
    private static final String NAME_PATTERN = "//strong[contains(., '%s')][contains(., '%s')]/../../../..";
    private static final String TYPE_PATTERN = "//span[text()='%s']/../../../..";
    private static final String PRICE_VOLUME_PATTERN = "//span[contains(text(), '%s € / %s ml')]/../../..";


    public SearchResultsPage(WebDriver extDriver) {
        super(extDriver);
        waitForElementVisibility(By.xpath(PAGE_HEADER));
    }

    public SearchResultsPage verifyPage(String producer, String mark){
        log.info("Verify search results page.");
        Assert.assertTrue(getElementText(By.xpath(PAGE_HEADER)).contains(producer));
        Assert.assertTrue(getElementText(By.xpath(PAGE_HEADER)).contains(mark));
        return this;
    }

    public AddToCartPage clickProduct(String producer, String mark, String type, String prise, String volume){
        log.info("Click product: " + producer + " " + mark + " " + type + " " + prise + " " + volume);
        click(By.xpath(RESULTS_LIST + String.format(NAME_PATTERN, producer, mark) + String.format(TYPE_PATTERN, type) +
        String.format(PRICE_VOLUME_PATTERN, prise, volume)));
        return new AddToCartPage(driver);
    }
}
