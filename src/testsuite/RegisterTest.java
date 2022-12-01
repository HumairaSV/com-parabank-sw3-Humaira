package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //* click on the ‘Register’ link
        clickOnElement(By.linkText("Register"));
        //* Verify the text ‘Signing up is easy!’
        verifyTextMessage("unable to verify text Signing up is easy", "Signing up is easy!", By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //* click on the ‘Register’ link
        clickOnElement(By.linkText("Register"));
        //* Enter First name
        sendTextToElement(By.xpath("//input[@id='customer.firstName']"), "Testerhv0");
        //* Enter Last name
        sendTextToElement(By.xpath("//input[@id='customer.lastName']"), "Automaters");
        //* Enter Address
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "Flat 301");
        //* Enter City
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"), "Manchester");
        //* Enter State
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "Lancashire");
        //* Enter Zip Code
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"), "M14 9AW");
        //* Enter Phone
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"), "07884445420");
        //* Enter SSN
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"), "AB123456D");
        //* Enter Username
        sendTextToElement(By.xpath("//input[@id='customer.username']"), "Testerhv0");
        //* Enter Password
        sendTextToElement(By.xpath("//input[@id='customer.password']"), "Password123");
        //* Enter Confirm
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"), "Password123");
        //* Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //* Verify the text 'Your account was created successfully. You are now logged in.’
        verifyTextMessage("Registration was not successful","Your account was created successfully. You are now logged in.", By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
