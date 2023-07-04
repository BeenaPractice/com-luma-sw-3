package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class WomenTest extends Utility {
    String baseUrl ="https://magento.softwaretestingboard.com/";
    @Before
    public void browsetSetUp(){
        openBrowser(baseUrl);
    }
    @Test
    //1. verifyTheSortByProductNameFilter
    public void verifyTheSortByProductNameFilter() {
        //  Mouse Hover on Women Menu
        //         * Mouse Hover on Tops
        WebElement womenmenu = driver.findElement(By.xpath("//span[normalize-space()='Women']"));
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenmenu).moveToElement(tops).build().perform();
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //* Click on Jackets
        actions.moveToElement(tops).moveToElement(jackets).click().build().perform();
        //* Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("//div[2]//div[3]//select[1]"), "Product Name");

        //* Verify the products name display in alphabetical order

    }
        @Test

        //2. verifyTheSortByPriceFilter
        public void verifyTheSortByPriceFilter(){
        // * Mouse Hover on Women Menu
        //* Mouse Hover on Tops
        //* Click on Jackets
            WebElement womenmenu = driver.findElement(By.xpath("//span[normalize-space()='Women']"));
            WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(womenmenu).moveToElement(tops).build().perform();
            WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

            actions.moveToElement(tops).moveToElement(jackets).click().build().perform();

           // * Select Sort By filter “Price”
            selectByVisibleTextFromDropDown(By.xpath("//div[2]//div[3]//select[1]"), "Price");
           //* Verify the products price display in Low to High


        }

}
