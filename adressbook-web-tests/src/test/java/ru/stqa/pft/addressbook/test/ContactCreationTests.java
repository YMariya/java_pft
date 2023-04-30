package ru.stqa.pft.addressbook.test;


import org.testng.annotations.*;


public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {

        app.gotoContactPage();
        app.fillContactForm(new ContactData("Петр", "Иванов", "Москва", "234ff@gmail.com"));
        app.submitContactCreation();
        app.returnToHomePage();
        app.Logout();
    }


}
