package ru.stqa.pft.addressbook.test;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {

        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("Петр", "Иванов", "Москва", "234ff@gmail.com", "test1"), true);

    }


}
