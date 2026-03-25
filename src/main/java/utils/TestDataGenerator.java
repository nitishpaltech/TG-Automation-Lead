package utils;

import base.BaseUtility;

public class TestDataGenerator {

    public static String generateMobile() {

        String env = BaseUtility.prop.getProperty("env");

        if(env.equalsIgnoreCase("production")) {

            return BaseUtility.prop.getProperty(
                    "productionTestMobile"
            );

        }

        return "9" + (int)(Math.random() * 900000000 + 100000000);

    }

}