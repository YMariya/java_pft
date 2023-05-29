package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;


@Test //(enabled = false)
public class ContactDeletionTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();

        if ( app.contact().getContactList().size() == 0){
            app.goTo().contact();
            app.contact().add();
        }
    }

    public void testContactDeletion() {
        Set<ContactData> before = app.contact().allContacts();
        ContactData deletedContacts = before.iterator().next();
        app.contact().delete(deletedContacts);
        app.goTo().home();

        Set<ContactData> after = app.contact().allContacts();
        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(deletedContacts);
        Assert.assertEquals(before,after);

    }




}
