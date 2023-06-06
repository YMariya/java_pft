package ru.stqa.pft.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {


    @Test// (enabled = false)
    public void testContactCreation() throws Exception {

        Contacts before = app.contact().allContacts();
        app.goTo().contact();
        File photo = new File("src/test/resources/Screen.png");
        ContactData contact = new ContactData().withFirstname("Петр").withLastname("Иванов").withPhoto(photo);
        app.contact().createContact(contact);
        Assert.assertEquals(app.contact().getContactCount(), before.size() + 1);
        Contacts after = app.contact().allContacts();

        assertThat(after, equalTo(before.withAdded(contact
                .withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }


    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsoluteFile());
       File photo = new File("src/test/resources/Screen.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }


    // File photo = new File(currentDir.getAbsolutePath() + "/src/test/resources/Screen.png");

    @Test

    public void testBadContactCreation() throws Exception {

        Contacts before = app.contact().allContacts();
        app.goTo().contact();
        ContactData contact = new ContactData().withFirstname("Иван '").withLastname("");
        app.contact().createContact(contact);
        Assert.assertEquals(app.contact().getContactCount(), before.size());
        Contacts after = app.contact().allContacts();

        assertThat(after, equalTo(before));

    }

}
