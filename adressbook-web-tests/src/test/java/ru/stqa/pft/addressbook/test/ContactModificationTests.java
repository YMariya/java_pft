package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase{
    @Test

    public void testContactModification() {

        app.getNavigationHelper().gotoHome();
        app.getGroupHelper().editContact();
        app.getGroupHelper().fillContactForm(new ContactData("firstname","lastname","address","email"));
        app.getGroupHelper().submitContactModification();
        app.getGroupHelper().returnToHomePage();

    }


}
