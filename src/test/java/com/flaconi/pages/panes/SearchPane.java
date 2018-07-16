package com.flaconi.pages.panes;

import com.flaconi.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPane extends PageObject {

    public static final String SEARCH_INPUT_XPATH = "//form[@id='autosuggest-form-header']/input";
    public static final String SEARCH_BTN_XPATH = "//form[@action='/search/']//span[text()='Suchen']/..";

    public SearchPane(WebDriver extDriver) {
        super(extDriver);
    }

    public SearchPane enterKeyword(String keyword) {
        log.info("Enter search keyword: " + keyword);
        enterText(By.xpath(SEARCH_INPUT_XPATH), keyword);
        return this;
    }

    public void clickSearch(){
        log.info("Click search.");
        click(By.xpath(SEARCH_BTN_XPATH));
    }
}
