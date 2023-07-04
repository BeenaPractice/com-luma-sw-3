package testsuite;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest  extends Utility {
    String baseUrl ="https://magento.softwaretestingboard.com/";
    @Before
    public void browsetSetUp(){
        openBrowser(baseUrl);
    }
    @Test
    //  1. userShouldAddProductSuccessFullyToShoppingCart()
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
    //Mouse Hover on Gear Menu
       mouseHover(By.xpath("//span[normalize-space()='Gear']"));
       // * Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        // * Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//img[@alt='Overnight Duffle']"));
        //* Verify the text ‘Overnight Duffle’
        verifyText(driver,By.xpath("//span[@class='base']"),"Overnight Duffle");
        // * Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));
        //* Verify the text
        //‘You added Overnight Duffle to your shopping cart.’
        verifyText(driver,By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),"‘You added Overnight Duffle to your shopping cart");
        // * Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //* Verify the product name ‘Overnight Duffle
        verifyText(driver,By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"),"Overnight Duffle");

       //* Verify the Qty is ‘3’
        verifyText(driver,By.xpath("//input[@id='cart-237256-qty']"),"3");
       // * Verify the product price ‘$135.00’
       verifyText(driver,By.xpath("//span[contains(text(),'$270.00')]"),"$135.00");
        //* Change Qty to ‘5’
        sendTextToElement(By.xpath("//input[@id='cart-235271-qty']"),"5");
        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //* Verify the product price ‘$225.00’
        verifyText(driver,By.xpath("//span[contains(text(),'$270.00')]"),"$225.00");

    }
}
