package Selenium_Tutorial1.PageDescriptions;

import com.mifmif.common.regex.Generex;

import java.util.Random;

public class RegistrationPage {



    public static int generateGender() {

        Random r = new Random();
        int x = 1;
        int y = 2;
        int gender;
        gender = r.nextInt(y-x+1)+x;
        return gender;
    }

    public static String generateFirstName() {

        Generex generexFirstName = new Generex("[A-Z]{1}[a-z]{4,8}");
        String firstName = String.valueOf(generexFirstName.random());
        //return firstName;
        //System.out.println(firstName);
        return firstName;
        //System.out.println(generexFirstName);
        //return String.valueOf(generexFirstName);
    }

    public static String generateLastName() {

        Generex generexLastName = new Generex("[A-Z]{1}[a-z]{4,8}");
        return String.valueOf(generexLastName.random());
    }


}
