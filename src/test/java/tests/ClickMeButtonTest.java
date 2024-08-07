package tests;

import common.PageManager;
import driver.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickMeButtonTest {

    static PageManager pageManager;

    @BeforeAll
    public static void setup() {
        pageManager = new PageManager();
        pageManager.clickMePage.open();
        pageManager.clickMePage.navigateToButtonsSection();
    }

    @Test
    public void testClickButton() {
        pageManager.clickMePage.clickMeButton();
        String expectedMessage = "You have done a dynamic click";
        String actualMessage = pageManager.clickMePage.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @AfterAll
    public static void tearDown() {
        DriverFactory.close();
    }
}













