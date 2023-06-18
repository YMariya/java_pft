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


public class ContactsAddGroupTests extends TestBase {
    @BeforeMethod
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
    }

    @Test
    public void testContactsAddGroup() {
        Contacts beforeContact = app.db().contacts();
        Groups beforeGroup = app.db().groups();
        ContactData forGroup = beforeContact.iterator().next();
        GroupData forContact = beforeGroup.iterator().next();
        Groups beforeGroups = app.db().groups();
        app.goTo().home();
        app.contact().ContactAddToGroup(forGroup.getId(), forContact.getName());
        app.goTo().home();
        Contacts afterContact = app.db().contacts();
        assertThat(afterContact.size(), equalTo(beforeContact.size()));
        Groups afterInGrous = app.db().groups();
        assertThat((afterInGrous), equalTo(new Groups(beforeGroups.withOut(forContact))));
    }
}



