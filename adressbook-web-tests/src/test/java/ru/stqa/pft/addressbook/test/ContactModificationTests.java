package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();

        if (app.contact().getContactList().size() == 0) {
            app.goTo().contact();
            app.contact().add();
        }
    }

    @Test //(enabled = false)

    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContacts = before.iterator().next();

        ContactData contact = new ContactData()
                .withId(modifiedContacts.getId()).withFirstname("firstname")
                .withLastname("lastname").withAddress("address");

        app.contact().modifyContacts(contact);
        Assert.assertEquals(app.contact().getContactCount(),before.size());
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.withOut(modifiedContacts).withAdded(contact)));
    }


}
