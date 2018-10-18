package Selenium_Tutorial1.Test;

import Selenium_Tutorial1.PageDescriptions.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void openHomePage(){
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void firstRegistration() {
        WebElement signInButton = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
        signInButton.click();
        boolean registrationPageIsDisplayed = driver.findElement(By.cssSelector("#SubmitCreate > span")).isDisplayed();
        System.out.println("Registration page displayed = " + registrationPageIsDisplayed);
    }

    @Test
    public void registerNewEmail() {
        WebElement signInButton = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
        signInButton.click();

        WebElement emailAddress = driver.findElement(By.cssSelector("#email_create"));
        emailAddress.clear();
        emailAddress.sendKeys("jozinzbazintest@gmail.com");

        WebElement createAnAccount = driver.findElement(By.cssSelector("#SubmitCreate > span"));
        createAnAccount.click();

        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#noSlide > h1")));
        boolean yourPersonalInformation = driver.findElement(By.cssSelector("#noSlide > h1")).isDisplayed();
        System.out.println("Your personal information is displayed = " + yourPersonalInformation);

        // # entering personal information
        //Select selectByValue = new Select(driver.findElement(By.cssSelector("#account-creation_form > div:nth-child(1) > div.clearfix")));
        //selectByValue.selectByValue("1");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#noSlide > h1")));
        /*try {
            Thread.sleep(5000);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-id_gender1")));
        WebElement radioMr = driver.findElement(By.id("uniform-id_gender1"));
        WebElement radioMrs = driver.findElement(By.id("uniform-id_gender2"));

        if (RegistrationPage.generateGender() == 1) {
            radioMr.click();
            System.out.println("Mr selected -->" + RegistrationPage.generateGender());
        } else {
            radioMrs.click();
            System.out.println("Mrs selected -->" + RegistrationPage.generateGender());
        }

        WebElement firstName = driver.findElement(By.cssSelector("#customer_firstname"));
        firstName.sendKeys(RegistrationPage.generateFirstName());
        System.out.println("First name: " + firstName);

        WebElement lastName = driver.findElement(By.cssSelector("#customer_lastname"));
        lastName.sendKeys(RegistrationPage.generateLastName());
        System.out.println("Last name: " + lastName);


    }

}
