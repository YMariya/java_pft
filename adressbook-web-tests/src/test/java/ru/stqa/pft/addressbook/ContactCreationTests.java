package ru.stqa.pft.addressbook;


import java.time.Duration;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {

        gotoContactPage();
        fillContactForm(new ContactData("Петр", "Иванов", "Москва", "234ff@gmail.com"));
        submitContactCreation();
        returnToHomePage();
        Logout();
    }


}
