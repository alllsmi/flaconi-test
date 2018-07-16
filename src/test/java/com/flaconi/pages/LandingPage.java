package com.flaconi.pages;

import com.flaconi.infrastructure.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends GeneralPage {

    private static final String COOKIE_BOX_CROSS = "//a[@class='cookie-box__close']/span";

    public LandingPage(WebDriver extDriver) {
        super(extDriver);
        log.info("Navigate to landing page. " + Config.landingUrl);
        this.driver.get(Config.landingUrl);
        closeCookieBoxIfShown();
    }

    private void closeCookieBoxIfShown(){
        try {
            waitForElementVisibility(By.xpath(COOKIE_BOX_CROSS));
            click(By.xpath(COOKIE_BOX_CROSS));
        }catch (Exception e){
            log.warn("Cookies box is absent.");
        }
    }
}
