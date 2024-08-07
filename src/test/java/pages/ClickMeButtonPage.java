package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ClickMeButtonPage extends BasePage {

    private final SelenideElement buttonsMenu = $(By.xpath("//span[text()='Buttons']"));
    private final SelenideElement clickMeButton = $(By.xpath("//button[text()='Click Me']"));
    private final SelenideElement dynamicClickMessage = $("#dynamicClickMessage");

    public ClickMeButtonPage(String pageUrl) {
        super(pageUrl);
    }

    public void navigateToButtonsSection() {
        buttonsMenu.click();
    }

    public void clickMeButton() {
        clickMeButton.click();
    }

    public String getMessage() {
        dynamicClickMessage.shouldBe(Condition.visible).shouldHave(Condition.text("You have done a dynamic click"));
        return dynamicClickMessage.getText();
    }
}











