package ru.stqa.pft.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.Set;


public class ContactCreationTests extends TestBase {


    @Test// (enabled = false)
    public void testContactCreation() throws Exception {

        Set<ContactData> before = app.contact().allContacts();
        app.goTo().contact();
        ContactData contact = new ContactData().withFirstname("Петр").withLastname("Иванов");
        app.contact().createContact(contact);
        Set<ContactData> after = app.contact().allContacts();
        Assert.assertEquals(after.size(),before.size() + 1);

        contact.whithId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }


}
