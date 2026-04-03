package utils;

import java.util.Random;

import base.BaseUtility;

public class TestDataGenerator {

  public static String generateMobile() {

    String env =
        BaseUtility.prop.getProperty("env");

    if(env.equalsIgnoreCase("production")) {

        String mobile =
            BaseUtility.prop.getProperty(
                "productionMobile"
            );

        if(mobile != null) {

            return mobile;

        }

    }

    return generateRandomMobile();

}
private static String generateRandomMobile() {

    Random rand = new Random();

    return "9" +
        (rand.nextInt(900000000) + 100000000);

}



}