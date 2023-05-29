package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();

        if ( app.contact().getContactList().size() == 0){
            app.goTo().contact();
            app.contact().add();
        }
    }
    @Test //(enabled = false)

    public void testContactModification() {
        Set<ContactData> before = app.contact().allContacts();
        ContactData modifiedContacts = before.iterator().next();

         ContactData contact = new ContactData()
                .whithId(modifiedContacts.getId()).withFirstname("firstname")
                .withLastname("lastname").withAddress("address");

        app.contact().modifyContacts(contact);
        Set<ContactData> after = app.contact().allContacts();
        Assert.assertEquals(after.size(),before.size());

        before.remove(modifiedContacts);
        before.add(contact);
        Assert.assertEquals(before,after); }



}
