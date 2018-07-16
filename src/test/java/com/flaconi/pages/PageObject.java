package com.flaconi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageObject {

    protected WebDriver driver;
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public PageObject(WebDriver extDriver){
        this.driver = extDriver;
    }

    protected void click(By by){
        waitForElementVisibility(by);
        driver.findElement(by).click();
    }

    protected void waitForElementVisibility(By by){
        new WebDriverWait(driver, 10, 50)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void enterText(By by, String text){
        waitForElementVisibility(by);
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    protected String getElementText(By by){
        return driver.findElement(by).getText();
    }

    protected boolean isElementDisplayed(By by){
        return driver.findElement(by).isDisplayed();
    }
}
