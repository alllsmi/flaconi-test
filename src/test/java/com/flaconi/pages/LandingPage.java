package com.flaconi.pages;

import com.flaconi.infrastructure.Config;
import org.openqa.selenium.WebDriver;

public class LandingPage extends GeneralPage {

    public LandingPage(WebDriver extDriver) {
        super(extDriver);
        log.info("Navigate to landing page. " + Config.landingUrl);
        this.driver.get(Config.landingUrl);
    }
}
