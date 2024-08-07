package tests;

import common.PageManager;
import driver.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;

public class AddRecordTest {

    static PageManager pageManager;

    @BeforeAll
    public static void setup() {
        pageManager = new PageManager();
        pageManager.addRPage.open();
    }

    @Test
    public void testAddAndEditRecord() {

        pageManager.addRPage.clickAddButton();
        pageManager.addRPage.fillForm("Sena", "Efe", "senaefe@gmail.com", "28", "77000", "Software");
        pageManager.addRPage.submitForm();

        pageManager.addRPage.findRecordByName("Sena").shouldHave(text("Sena"), text("Efe"));

        pageManager.addRPage.editRecord(pageManager.addRPage.findRecordByName("Sena"));
        pageManager.addRPage.updateFirstName("Aylin");
        pageManager.addRPage.submitForm();

        pageManager.addRPage.findRecordByName("Aylin").shouldHave(text("Aylin"), text("Efe"));
    }

    @AfterAll
    public static void tearDown() {
        DriverFactory.close();
    }
}







