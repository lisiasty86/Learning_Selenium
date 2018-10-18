package Selenium_Tutorial1.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.testng.annotations.Test;

public class Gmail_Login {

    public static void main(String[] args) throws InterruptedException {


        //objects and variables instantion
        WebDriver driver = new ChromeDriver();
        String appURL = "https://accounts.google.com";

        //launch the chrome browser and open the application url
        driver.get(appURL);

        //maximize the browser window
        //driver.manage().window().maximize();

        //declare and initialize the variable to store the expected title of the webpage
        String expectedTitile = "Logowanie – Konta Google";

        //fetch the title of the web page and save it into a string variable
        String actualTitle = driver.getTitle();

        //compare the expected title of the page with the actual title of the page and print the result
        Assert.assertEquals(expectedTitile,actualTitle);
        /*if (expectedTitile.equals(actualTitle))
        {
            System.out.println("Verification Successful - The correct title is displayed");
        }
        else
        {
            System.out.println("Verification failed - An incorrect title is displayed");
        }*/

        // enter a valid username in the email textbox
        WebElement username = driver.findElement(By.name("identifier"));
        username.clear();
        username.sendKeys("jozinzbazintest@gmail.com");

        //click on the Sign in button
        WebElement SignInButton = driver.findElement(By.id("identifierNext"));
        SignInButton.click();

        //enter a valid password in the password textbox
        //WebElement secondEmail = driver.findElement(By.cssSelector("input[type='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement secondEmail = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        secondEmail.clear();
        secondEmail.sendKeys("niemabata86");

        //logowanie
        WebElement loguj = driver.findElement(By.cssSelector("[id='passwordNext']"));
        loguj.click();

        //close the web browser
        Thread.sleep(9000);
        driver.close();
        System.out.println("Test script executed successfully.");

        //terminate the program
        System.exit(0);

    }

}
