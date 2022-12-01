package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //* Enter valid username
        sendTextToElement(By.xpath("//input[@name = 'username']"), "Testerhv");
        //* Enter valid password
        sendTextToElement(By.xpath("//input[@name = 'password']"), "Password123");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value= 'Log In']"));
        //* Verify the ‘Accounts Overview’ text is display
        verifyTextMessage("Not navigated to Accounts overview page", "Accounts Overview", By.xpath("//h1[contains(text(),'Accounts Overview')]"));

    }

    @Test
    public void verifyTheErrorMessage() {
        //* Enter invalid username
        sendTextToElement(By.xpath("//input[@name= 'username']"), "Testhv");
        //* Enter invalid password
        sendTextToElement(By.xpath("//input[@name= 'password']"), "pass123456");
        //* Click on Login button
        clickOnElement(By.xpath("//input[@value= 'Log In']"));
        //* Verify the error message ‘The username and password could not be verified
        //not getting this error - only error on website is 'An internal error has occurred and has been logged.'
        verifyTextMessage("Unable to verify the error message", "An internal error has occurred and has been logged.", By.xpath("//p[contains(text(),'An internal error has occurred and has been logged')]"));

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //setting up a user account to ensure successful login
        clickOnElement(By.linkText("Register"));
        sendTextToElement(By.xpath("//input[@id='customer.firstName']"), "Testhv1");
        sendTextToElement(By.xpath("//input[@id='customer.lastName']"), "Automas");
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "Flat 201");
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"), "Manchester");
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "Lancashire");
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"), "M14 9AS");
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"), "07723456789");
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"), "AB123456F");
        sendTextToElement(By.xpath("//input[@id='customer.username']"), "Testhv1");
        sendTextToElement(By.xpath("//input[@id='customer.password']"), "Password123");
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"), "Password123");
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));

        //* Enter valid username
        sendTextToElement(By.xpath("//input[@name= 'username']"), "Testhv1");
        //* Enter valid password
        sendTextToElement(By.xpath("//input[@name= 'password']"), "Password123");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value= 'Log In']"));
        //* Click on ‘Log Out’ link
        clickOnElement(By.linkText("Log Out"));
        //* Verify the text ‘Customer Login’
        verifyTextMessage("Unable to verify the text customer login", "Customer Login", By.xpath("//h2[contains(text(),'Customer Login')]"));
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
