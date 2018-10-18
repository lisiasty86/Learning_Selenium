package Selenium_Tutorial1.Test;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AutomationPracticeHome {

    WebDriver driver = new ChromeDriver();

    String[] sizeTable = new String[] {"Small", "Medium", "Large"};
    //String[] sizeTable = new String[3];
    //sizeTable[0] = "Small";
    //sizeTable[1] = "Medium";
    //sizeTable[2] = "Larghe";
    int size;

    @BeforeMethod
    public void openHomePage(){
        driver.get("http://automationpractice.com/index.php");
        //System.out.println("dupa");
    }

    @Test
    public void pageLoaded() {
        //driver.get("http://automationpractice.com/index.php");
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        try {
            driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default"));
            //System.out.println("dupa2");
        } catch (InvalidSelectorException e) {
            System.out.println("Błędny lokalizator");
        }
    }

    @Test
    public void shouldOpenDetailsOfSomeProduct() {
        //driver.get("http://automationpractice.com/index.php");
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        WebElement more = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default"));
        try {
            more.click();
            driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
            System.out.println("Details were opened successfully");
        } catch (InvalidSelectorException ex){
            System.out.println("Błędny lokalizator2");
        } catch (NoSuchElementException ex){
            System.out.println("Błędny lokalizator3a");
        }
    }

    @Test
    public void checkIfCorrectSizeIsSelectedByDefault() {
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        WebElement more = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default"));
        try {
            more.click();
            driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
            System.out.println("Details were opened successfully");
        } catch (InvalidSelectorException ex){
            System.out.println("Błędny lokalizator2");
        } catch (NoSuchElementException ex){
            System.out.println("Błędny lokalizator3a");
        }

        Select selectByValue = new Select(driver.findElement(By.cssSelector("#group_1")));
        boolean sIsSelectedByDefault = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[1]")).isSelected();
        System.out.println(sIsSelectedByDefault);
        //selectByValue.selectByValue("2");
    }

    @Test
    public void checkIfPossibleToAddToCard() {
        //driver.get("http://automationpractice.com/index.php");
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        WebElement more = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default"));
        size = 3;

        try {
            more.click();
            driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
        } catch (InvalidSelectorException ex){
            System.out.println("Błędny lokalizator2");
        } catch (NoSuchElementException ex){
            System.out.println("Błędny lokalizator3b");
        }
        Select selectByValue = new Select(driver.findElement(By.cssSelector("#group_1")));
        selectByValue.selectByValue("3");

        if (size == 1) {
            System.out.println(sizeTable[0] + " size of Faded Short Sleeve T-shirt successfully added to card");
        }
        if (size == 2) {
            System.out.println(sizeTable[1] + " size of Faded Short Sleeve T-shirt successfully added to card");
        } else {
            System.out.println(sizeTable[2] + " size of Faded Short Sleeve T-shirt successfully added to card");
        }


        WebElement addToCard = driver.findElement(By.cssSelector("#add_to_cart > button"));
        addToCard.click();
        WebDriverWait wait5 = new WebDriverWait(driver, 20);
        WebElement productAdded = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span/i"));
        System.out.println(productAdded);
    }

    @Test
    public void checkIfPossibleToAddToCardFewProducts () {
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        WebElement more = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default"));

        try {
            more.click();
            driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
        } catch (InvalidSelectorException ex){
            System.out.println("Błędny lokalizator2");
        } catch (NoSuchElementException ex){
            System.out.println("Błędny lokalizator3b");
        }

        WebElement quantity = driver.findElement(By.cssSelector("#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up > span > i"));
        quantity.click();
        quantity.click();

        Select selectByValue = new Select(driver.findElement(By.cssSelector("#group_1")));
        selectByValue.selectByValue("2");

        if (size == 1) {
            System.out.println("3 x " + sizeTable[0] + " size of Faded Short Sleeve T-shirt successfully added to card");
        }
        if (size == 2) {
            System.out.println("3 x " + sizeTable[1] + " size of Faded Short Sleeve T-shirt successfully added to card");
        } else {
            System.out.println("3 x " + sizeTable[2] + " size of Faded Short Sleeve T-shirt successfully added to card");
        }

        WebElement addToCard = driver.findElement(By.cssSelector("#add_to_cart > button"));
        addToCard.click();
        WebDriverWait wait5 = new WebDriverWait(driver, 20);
        WebElement productAdded = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span/i"));
        System.out.println(productAdded);
    }
}