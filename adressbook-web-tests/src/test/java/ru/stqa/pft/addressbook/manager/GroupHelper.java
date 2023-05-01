package ru.stqa.pft.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.ContactData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void deleteSelectGroups() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroups() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void selectContact() {
        click(By.id("4"));
    }

    public void deleteSelectContact() {
        click(By.xpath("//div[2]/input"));
    }

    public void editContact() {
        click(By.xpath("//tr[6]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[22]"));
    }
}
