package ru.stqa.pft.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends GroupHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }
        public void selectContact () {
            click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td/input"));
        }

        public void deleteSelectContact () {
            click(By.xpath("//div[2]/input"));
        }

        public void editContact () {
            click(By.xpath("//tr[6]/td[8]/a/img"));
        }

        public void submitContactModification () {
            click(By.xpath("//input[22]"));
        }


    public void createContact(ContactData contact, boolean b) {
        fillContactForm(contact,b);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return  isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[3]/td/input"));
    }
}
