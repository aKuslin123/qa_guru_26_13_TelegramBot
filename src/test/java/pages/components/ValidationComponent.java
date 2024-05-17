package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ValidationComponent {

    private final SelenideElement genderWrapper = $("#genterWrapper");

    public void genderValidation(String value) {
        genderWrapper.$(byText(value))
                .shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
    }

    public void inputValidation(String value) {
        $("#" + value).shouldBe(empty);
        $("#" + value).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#" + value).shouldHave(cssValue("background-image",
                "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' " +
                        "height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' " +
                        "r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' " +
                        "fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
    }
}