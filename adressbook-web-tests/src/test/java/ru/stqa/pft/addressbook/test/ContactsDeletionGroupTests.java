package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsDeletionGroupTests extends TestBase {

    @BeforeTest
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));

        }

        app.goTo().home();
        if (app.contact().getContactList().size() == 0) {
            app.goTo().contact();
            app.contact().add();
        }

        app.goTo().home();
        Contacts beforeContact = app.db().contacts();
        ContactData forGroup = beforeContact.iterator().next();
        if (forGroup.getGroups().size() == 0) {
            Groups beforeGroup = app.db().groups();
            GroupData forContact = beforeGroup.iterator().next();
            app.contact().ContactAddToGroup(forGroup.getId(), forContact.getName());
            app.goTo().home();

        }
    }


@Test
public void testContactsDeletionGroup() {
    Contacts beforeContact = app.db().contacts();
    ContactData forGroup = beforeContact.iterator().next();
    String name = forGroup.getGroups().iterator().next().getName();
    Groups beforeGroups = app.db().groups();
    if (forGroup.getGroups().size() != 0) {
        app.goTo().home();
        app.contact().ContactDeletionToGroup(forGroup.getId(), name);
        app.goTo().home();
        Contacts afterContact = app.db().contacts();
        assertThat(afterContact.size(), equalTo(beforeContact.size()));
        Groups afterInGrous = app.db().groups();
        assertThat((afterInGrous), equalTo(new Groups(beforeGroups)));
    }
}}