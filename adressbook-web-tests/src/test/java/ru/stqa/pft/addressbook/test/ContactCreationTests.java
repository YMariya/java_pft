package ru.stqa.pft.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("Петр", "Иванов", "Москва", "234ff@gmail.com"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before + 1);
    }


}
