package ru.stqa.pft.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("Петр", "Иванов", "Москва", "234ff@gmail.com"));
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(),before.size() + 1);
    }


}
