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
import static ru.stqa.pft.addressbook.test.TestBase.app;

public class ContactsAddGroupTests {
    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();

        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }
    @Test
    public void testContactsAddGroup() {

        Contacts beforeContact = app.db().contacts();
        Groups beforeGroup = app.db().groups();


    }
}



//
//        ContactData forGroup = beforeContact.iterator().next();
//        GroupData forContact = beforeGroup.iterator().next();
//
//
//
//
//        Groups beforeGroups = app.db().groups();
//        app.goTo().home();
//        app.contact().ContactAddToGroup(forGroup.getId(), forContact.getName());
//        app.goTo().home();
//        Contacts afterContact = app.db().contacts();
//        assertThat(afterContact.size(), equalTo(beforeContact.size())); // проверка на совпадение колич-ва контактов
//        Groups afterInGrous = app.db().groups(); // после добавления контакта в группы
//        // проверка на соответствие
//        assertThat((afterInGrous), equalTo(new Groups(beforeGroups.withAdded(forContact))));
//
//    }
//    }
//
