package com.flaconi.pages;

import com.flaconi.pages.panes.SearchPane;
import com.flaconi.pages.panes.TabsPane;
import org.openqa.selenium.WebDriver;

public abstract class GeneralPage extends PageObject{

    public TabsPane tabsPane;
    public SearchPane searchPane;
    static final String PAGE_HEADER = "//h1[@class='catalog-headline']";

    GeneralPage(WebDriver extDriver) {
        super(extDriver);
        tabsPane = new TabsPane(extDriver);
        searchPane = new SearchPane(extDriver);
    }
}
