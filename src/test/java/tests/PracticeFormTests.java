package tests;

import data.FormKeys;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static java.lang.String.format;
import static utils.RandomUtils.*;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            fullName = format("%s %s", firstName, lastName),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            userNumber = getRandomPhoneNumber(),
            birthDay = getRandomDay(),
            birthMonth = getRandomMonth(),
            birthYear = getRandomYear(),
            birthDate = format("%s %s,%s", birthDay, birthMonth, birthYear),
            userSubject = getRandomSubject(),
            userHobby = getRandomHobby(),
            userPictureDisplayed = getRandomPicture(),
            userPictureUpload = "images/" + userPictureDisplayed,
            userAddress = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state),
            stateAndCity = format("%s %s", state, city),
            emptyField = " ";

    @Test
    @Tag("registration")
    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Отправка формы со всеми заполненными полями")
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadPicture(userPictureUpload)
                .setAddress(userAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        registrationPage.checkResult(FormKeys.NAME.getKey(), fullName)
                .checkResult(FormKeys.EMAIL.getKey(), userEmail)
                .checkResult(FormKeys.GENDER.getKey(), userGender)
                .checkResult(FormKeys.MOBILE.getKey(), userNumber)
                .checkResult(FormKeys.BIRTH.getKey(), birthDate)
                .checkResult(FormKeys.SUBJECT.getKey(), userSubject)
                .checkResult(FormKeys.HOBBY.getKey(), userHobby)
                .checkResult(FormKeys.PICTURE.getKey(), userPictureDisplayed)
                .checkResult(FormKeys.ADDRESS.getKey(), userAddress)
                .checkResult(FormKeys.STATE_AND_CITY.getKey(), stateAndCity);
    }

    @Test
    @Tag("smoke")
    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Отправка формы с обязательными заполненными полями")
    void minSuccessfulFillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult(FormKeys.NAME.getKey(), fullName)
                .checkResult(FormKeys.EMAIL.getKey(), emptyField)
                .checkResult(FormKeys.GENDER.getKey(), userGender)
                .checkResult(FormKeys.MOBILE.getKey(), userNumber)
                .checkResult(FormKeys.BIRTH.getKey(), emptyField)
                .checkResult(FormKeys.SUBJECT.getKey(), emptyField)
                .checkResult(FormKeys.HOBBY.getKey(), emptyField)
                .checkResult(FormKeys.PICTURE.getKey(), emptyField)
                .checkResult(FormKeys.ADDRESS.getKey(), emptyField)
                .checkResult(FormKeys.STATE_AND_CITY.getKey(), emptyField);
    }

    @Test
    @Tags({
            @Tag("registration"),
            @Tag("negative")
    })
    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка валидации обязательных полей")
    void validationFormTest() {
        registrationPage.openPage()
                .pressSubmit();

        registrationPage.checkGenderValidation("Male")
                .checkGenderValidation("Female")
                .checkGenderValidation("Other")
                .checkInputValidation("firstName")
                .checkInputValidation("lastName")
                .checkInputValidation("userNumber");

        registrationPage.checkFormNotDisplayed();
    }

    @Test
    @Tag("registration")
    @Feature("Падающий тест")
    void fallingTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadPicture(userPictureUpload)
                .setAddress(userAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        registrationPage.checkResult(FormKeys.NAME.getKey(), fullName)
                .checkResult(FormKeys.EMAIL.getKey(), userEmail)
                .checkResult(FormKeys.GENDER.getKey(), userGender)
                .checkResult(FormKeys.MOBILE.getKey(), userNumber)
                .checkResult(FormKeys.BIRTH.getKey(), birthDate)
                .checkResult(FormKeys.SUBJECT.getKey(), userSubject)
                .checkResult(FormKeys.HOBBY.getKey(), userHobby)
                .checkResult(FormKeys.PICTURE.getKey(), userPictureDisplayed)
                .checkResult(FormKeys.ADDRESS.getKey(), userAddress)
                .checkResult(FormKeys.STATE_AND_CITY.getKey(), userAddress);
    }
}