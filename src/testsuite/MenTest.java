package testsuite;



import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl ="https://magento.softwaretestingboard.com/";
    @Before
    public void browsetSetUp(){
        openBrowser(baseUrl);
    }

    //1. userShouldAddProductSuccessFullyTo
    //ShoppinCart()
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
     // * Mouse Hover on Men Menu
      //          * Mouse Hover on Bottoms
       //         * Click on Pants
        WebElement menmenu = driver.findElement(By.xpath("//span[normalize-space()='Men']"));
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menmenu).moveToElement(bottoms).build().perform();
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //* Click on Jackets
        actions.moveToElement(bottoms).moveToElement(pants).click().build().perform();

        //* Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on size 32.
        WebElement cronusYogaPant = driver.findElement(By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@class='products wrapper grid products-grid']/ol[@class='products list items product-items']/li[1]/div[1]/div[1]"));

        actions.moveToElement(cronusYogaPant).build().perform();
        driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']")).click();
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        actions.moveToElement(cronusYogaPant).build().perform();
        driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']")).click();
       // * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        actions.moveToElement(cronusYogaPant).build().perform();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]")).click();
        //* Verify the text
        //‘You added Cronus Yoga Pant to your shopping cart.’
       verifyText(driver,By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),"You added Cronus Yoga Pant to your shopping cart");
       //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //* Verify the text ‘Shopping Cart.’
        verifyText(driver,By.xpath("//span[@class='base']"),"Shopping Cart");

        //* Verify the product name ‘Cronus Yoga Pant’
        //* Verify the product size ‘32’
        //* Verify the product colour ‘Black’
        verifyText(driver,By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"),"Cronus Yoga Pant");
        verifyText(driver,By.xpath("//dd[contains(text(),'32')]"),"32");
        verifyText(driver, By.xpath("//dd[contains(text(),'Black')]"),"Black");

           }

}
