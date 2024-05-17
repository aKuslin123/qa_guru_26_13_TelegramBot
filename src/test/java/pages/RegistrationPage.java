package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.FormComponent;
import pages.components.ValidationComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    FormComponent formComponent = new FormComponent();
    ValidationComponent validationComponent = new ValidationComponent();

    @Step("Открываем страницу регистрационной формы")
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));

        return this;
    }

    @Step("Вводим имя {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вводим фамилию {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вводим емаил {value}")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Указываем пол {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Вводим номер телефона {value}")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Указываем дату рождения {day}/{month}/{year}")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбираем предмет {value}")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем хобби {value}")
    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем картинку {value}")
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Вводим адресс {value}")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    @Step("Выбираем штат {value}")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Выбираем город {value}")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Жмем кнопку submit")
    public RegistrationPage pressSubmit() {
        submitButton.click();

        return this;
    }

    @Step("Проверяем, что введенное значение - {value} совпадает с табличным - {key}")
    public RegistrationPage checkResult(String key, String value) {
        formComponent.checkForm(key, value);

        return this;
    }

    @Step("Проверяем, что таблица с результатами заполнения не появилась")
    public RegistrationPage checkFormNotDisplayed() {
        formComponent.formDoesNotAppear();

        return this;
    }

    @Step("Валидация пола")
    public RegistrationPage checkGenderValidation(String value) {
        validationComponent.genderValidation(value);

        return this;
    }

    @Step("Валидация обязательных полей инпутов")
    public RegistrationPage checkInputValidation(String value) {
        validationComponent.inputValidation(value);

        return this;
    }
}