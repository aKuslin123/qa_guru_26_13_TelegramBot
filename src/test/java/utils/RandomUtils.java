package utils;

import com.github.javafaker.Faker;

import java.util.Date;

public class RandomUtils {
    static Faker faker = new Faker();
    private static final Date date = faker.date().birthday();

    public static String getRandomFirstName() {

        return faker.name().firstName();
    }

    public static String getRandomLastName() {

        return faker.name().lastName();
    }

    public static String getRandomEmail() {

        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

    public static String getRandomPhoneNumber() {

        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomDay() {

        return String.format("%02d", date.getDate());
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int monthIndex = date.getMonth();

        return months[monthIndex];
    }

    public static String getRandomYear() {

        return String.valueOf(date.getYear() + 1900);
    }

    public static String getRandomSubject() {
        String[] subjects = {"English", "Chemistry", "Computer Science", "Commerce",
                "Economics", "Social Studies", "Arts", "History", "Biology", "Math",
                "Accounting", "Physics", "Hindi", "Civics"};

        return faker.options().option(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return faker.options().option(hobbies);
    }

    public static String getRandomPicture() {

        String[] pictures = {"img1.jpg", "img2.jpg", "img3.jpg"};

        return faker.options().option(pictures);
    }

    public static String getRandomAddress() {

        return faker.address().streetAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option(states);
    }

    public static String getRandomCity(String state) {

        switch (state) {
            case "NCR": {
                String[] cities = {"Delhi", "Gurgaon", "Noida"};
                return faker.options().option(cities);
            }
            case "Uttar Pradesh": {
                String[] cities = {"Agra", "Lucknow", "Merrut"};
                return faker.options().option(cities);
            }
            case "Haryana": {
                String[] cities = {"Karnal", "Panipat"};
                return faker.options().option(cities);
            }
            default: {
                String[] cities = {"Jaipur", "Jaiselmer"};
                return faker.options().option(cities);
            }
        }
    }
}