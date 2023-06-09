package ru.stqa.pft.addressbook.test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;


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
        Contacts before = app.db().contacts();
        ContactData deletedContacts = before.iterator().next();
        app.contact().delete(deletedContacts);
        Assert.assertEquals(app.contact().getContactCount(),before.size()-1);
        app.goTo().contact();
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.withOut(deletedContacts)));

        verifyContactListInUI();
    }




}
