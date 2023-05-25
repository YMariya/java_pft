package ru.stqa.pft.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactCreationTests extends TestBase {


    @Test (enabled = false)
    public void testContactCreation() throws Exception {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoContactPage();
        ContactData contact = new ContactData("Петр", "Иванов", "Москва", "234ff@gmail.com");
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);

        contact.setId(after.stream().max((Comparator.comparingInt(ContactData::getId))).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }


}
