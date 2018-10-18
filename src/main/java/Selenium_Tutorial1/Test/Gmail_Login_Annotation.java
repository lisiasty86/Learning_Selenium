package Selenium_Tutorial1.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Gmail_Login_Annotation {

    public WebDriver driver = new ChromeDriver();
    String appUrl = "https://accounts.google.com";

    @Test
    public void gmailLogin() throws InterruptedException {
        // launch the firefox browser and open the application url
        driver.get(appUrl);

// maximize the browser window
        //driver.manage().window().maximize();

// declare and initialize the variable to store the expected title of the webpage.
        String expectedTitle1 = "Logowanie – Konta Google";
        String expectedTitle2 = "Konto Google";

// fetch the title of the web page and save it into a string variable
        String actualTitle1 = driver.getTitle();
        System.out.println(actualTitle1);
        Assert.assertEquals(expectedTitle1,actualTitle1);

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

        // fetch the title of the web page and save it into a string variable
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        WebElement waitUntil = wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='B39JC']")));
        //Thread.sleep(2000);
        String actualTitle2 = driver.getTitle();
        System.out.println(actualTitle2);
        Assert.assertEquals(expectedTitle2,actualTitle2);

//close the web browser
        //Thread.sleep(9000);
        //driver.close();
        System.out.println("Test script executed successfully.");

//terminate the program
        System.exit(0);
    }

}
