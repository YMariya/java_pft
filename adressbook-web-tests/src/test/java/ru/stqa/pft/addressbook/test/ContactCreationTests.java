package ru.stqa.pft.addressbook.test;


import org.testng.annotations.*;


public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {

        app.getNavigationHelper().gotoContactPage();
        app.getGroupHelper().fillContactForm(new ContactData("Петр", "Иванов", "Москва", "234ff@gmail.com"));
        app.getGroupHelper().submitContactCreation();
        app.getGroupHelper().returnToHomePage();

    }


}
