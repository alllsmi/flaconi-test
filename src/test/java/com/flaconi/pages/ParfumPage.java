package com.flaconi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ParfumPage extends GeneralPage {

    private static final String PAGE_NAME = "Parfum";

    public ParfumPage(WebDriver extDriver) {
        super(extDriver);
        waitForElementVisibility(By.xpath(PAGE_HEADER));
    }

    public ParfumPage verifyPage(){
        log.info("Verify page " + PAGE_NAME);
        Assert.assertTrue(getElementText(By.xpath(PAGE_HEADER)).contains(PAGE_NAME));
        return this;
    }
}
