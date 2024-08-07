package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddRecordPage extends BasePage {

    private final SelenideElement addButton = $(By.id("addNewRecordButton"));
    private final SelenideElement firstNameInput = $(By.id("firstName"));
    private final SelenideElement lastNameInput = $(By.id("lastName"));
    private final SelenideElement emailInput = $(By.id("userEmail"));
    private final SelenideElement ageInput = $(By.id("age"));
    private final SelenideElement salaryInput = $(By.id("salary"));
    private final SelenideElement departmentInput = $(By.id("department"));
    private final SelenideElement submitButton = $(By.id("submit"));
    private final ElementsCollection records = $$(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']"));

    public AddRecordPage(String pageUrl) {
        super(pageUrl);
    }

    private void removeAds() {
        Selenide.executeJavaScript(
                "var ads = document.querySelectorAll('iframe[id^=google_ads_iframe_]');" +
                        "ads.forEach(function(ad) { ad.remove(); });"
        );
    }

    @Override
    public void open() {
        super.open();
        removeAds();
    }

    public void clickAddButton() {
        removeAds();
        addButton.click();
    }

    public void fillForm(String firstName, String lastName, String email, String age, String salary, String department) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        ageInput.setValue(age);
        salaryInput.setValue(salary);
        departmentInput.setValue(department);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getFirstRecordData() {
        return records.first().getText();
    }

    public SelenideElement findRecordByName(String name) {
        for (SelenideElement record : records) {
            if (record.getText().contains(name)) {
                return record;
            }
        }
        return null;
    }

    public void editRecord(SelenideElement record) {
        removeAds();
        record.$(By.xpath(".//span[@title='Edit']")).click();
    }

    public void updateFirstName(String newFirstName) {
        firstNameInput.setValue(newFirstName);
    }
}
