package Selenium_Tutorial1.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class PHP_Travelers_Home {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void openHomePage(){
        driver.get("https://phptravels.com/demo/");
    }

    @Test(priority=1)
    //@AfterTest
    public void openTravelersHome() {
        WebElement homePage = driver.findElement(By.cssSelector("[class='btn btn-primary btn-lg btn-block'][href='//www.phptravels.net']"));
        homePage.click();
    }

    @Test(priority=2)
    public void isHomeLoaded(WebDriver driver) {
        driver.findElement(By.cssSelector("[class='destination-title go-text-right ttu']"));

        /*try {
            driver.findElement(By.cssSelector("[class='destination-title go-text-right ttu']"));
            return true;
        }
        catch (NoSuchElementException exc){
            return false;
        }*/
    }
}
