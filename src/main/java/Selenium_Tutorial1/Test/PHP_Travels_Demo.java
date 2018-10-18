package Selenium_Tutorial1.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.NoSuchElementException;

public class PHP_Travels_Demo {

    WebDriver driver = new ChromeDriver();

    @Test(priority=1)
    public void openHomePage(){
        driver.get("https://phptravels.com/demo/");
        driver.findElement(By.cssSelector("[class='btn btn-primary btn-lg btn-block'][href='//www.phptravels.net']"));
        /*try {
            driver.findElement(By.cssSelector("[class='btn btn-primary btn-lg btn-block'][href='//www.phptravels.net']"));
        }
        catch (NoSuchElementException exc) {
            Assert.assertFalse(false, "BrakElementu");
        }*/
    }

    /*@Test(priority=2)
    public void FrontEndLinkExist(WebDriver driver){
        driver.findElement(By.cssSelector("[class='btn btn-primary btn-lg btn-block'][href='//www.phptravels.net']"));
        try {
            driver.findElement(By.cssSelector("[class='btn btn-primary btn-lg btn-block'][href='//www.phptravels.net']"));
        }
        catch (NoSuchElementException exc) {
            Assert.assertFalse(false, "BrakElementu");
        }
    }*/




}
