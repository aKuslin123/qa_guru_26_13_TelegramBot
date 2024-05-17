package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputForm = $("#output");

    public TextBoxPage openPage(){
        open("/text-box");

        return this;
    }
    public TextBoxPage setUserName(String value){
        userName.setValue(value);

        return this;
    }
    public TextBoxPage setEmail(String value){
        userEmail.setValue(value);

        return this;
    }
    public TextBoxPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }
    public TextBoxPage setPermanentAddress(String value){
        permanentAddress.setValue(value);

        return this;
    }
    public TextBoxPage pressSubmitButton(){
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResult(String key, String value){
        outputForm.should(appear);
        outputForm.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
