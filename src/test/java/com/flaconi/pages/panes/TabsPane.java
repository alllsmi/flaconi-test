package com.flaconi.pages.panes;

import com.flaconi.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabsPane extends PageObject {

    public static final String TABS_XPATH_PATTERN = "//header//a[text()='%s'][@data-webtrekk-link-id='header.nav']";

    public static final String MARKEN = "Marken";
    public static final String PARFUM = "Parfum";

    public TabsPane(WebDriver extDriver) {
        super(extDriver);
    }

    public void selectTab(String tabName){
        log.info("Click tab " + tabName);
        click(By.xpath(String.format(TABS_XPATH_PATTERN, tabName)));
    }
}
