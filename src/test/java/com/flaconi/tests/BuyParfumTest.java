package com.flaconi.tests;

import com.flaconi.pages.*;
import com.flaconi.pages.panes.TabsPane;
import org.testng.annotations.Test;

public class BuyParfumTest extends BaseTest {

    private static final String PRODUCER = "CHANEL";
    private static final String MARK = "COCO MADEMOISELLE";
    private static final String TYPE = "Eau de Parfum";
    private static final String PRICE = "56,95";
    private static final String VOLUME = "35";

    @Test
    public void buyParfumTest(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.tabsPane.selectTab(TabsPane.PARFUM);
        ParfumPage parfumPage = new ParfumPage(driver);
        parfumPage.verifyPage();
        parfumPage.searchPane.enterKeyword(PRODUCER + " " + MARK).clickSearch();
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        AddToCartPage addToCartPage =
                searchResultsPage.verifyPage(PRODUCER, MARK).clickProduct(PRODUCER, MARK, TYPE, PRICE, VOLUME);
        CartPage cartPage = addToCartPage.addToCart(PRICE);
        cartPage.verifyProductInCart(PRODUCER, MARK, TYPE, PRICE, VOLUME);
    }
}