package common;

import pages.AddRecordPage;
import pages.ClickMeButtonPage;

public class PageFactory {

    public static ClickMeButtonPage buildClickPage() {
        return new ClickMeButtonPage("/elements");
    }

    public static AddRecordPage buildAddPage() {
        return new AddRecordPage("/webtables");
    }

}
