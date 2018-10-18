package Selenium_Tutorial1.Test;

import Selenium_Tutorial1.PageDescriptions.RegistrationPage;
import org.testng.annotations.Test;

public class TestMethodsTEST {



    @Test
    public void testMethodsTEST0() {
        RegistrationPage.generateGender();
    }

    @Test
    public void testMethodsTEST1() {
        try {
            RegistrationPage.generateLastName();
        } catch (IllegalArgumentException exc) {
            System.out.println("DUPA1");
        }


    }

    @Test
    public void testMethodsTEST2() {
        try {
            RegistrationPage.generateFirstName();
        } catch (IllegalArgumentException exc) {
            System.out.println("DUPA2");
        }

    }

}
