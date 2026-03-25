package utils;

public class TestDataGenerator {

    public static String generateMobile() {

        return "9" + (int)(Math.random() * 900000000 + 100000000);

    }

}