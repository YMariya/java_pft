package ru.stqa.pft.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {


    @Test// (enabled = false)
    public void testContactCreation() throws Exception {

       Contacts before = app.contact().allContacts();
        app.goTo().contact();
        ContactData contact = new ContactData().withFirstname("Петр").withLastname("Иванов");
        app.contact().createContact(contact);
        Contacts after = app.contact().allContacts();
        Assert.assertEquals(after.size(),before.size() + 1);
        assertThat(after, equalTo(before.withAdded(contact
                .whithId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }


}
