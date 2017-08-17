package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Антон on 09.07.2017.
 */
public class ContactHelper extends  HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));

  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getFirst_name());
    type(By.name("lastname"), contactData.getLast_name());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile_phone());
    type(By.name("email"), contactData.getE_mail());

    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent (By.name("new_group")));
    }


    }


  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactModification(int id) {

    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }

  public void setContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void goToMainPage() {
    click(By.id("logo"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }


  public void submitModificationContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contactData) {
   goToMainPage();
    initContactCreation();
    fillContactForm( contactData, true);
    submitContactCreation();
  }

  public void modify( ContactData contact) {
 setContactById(contact.getId());
    initContactModification(contact.getId());
  fillContactForm(contact, false);
 submitModificationContact();
goToMainPage();
  }

  public void delete(int index, int idDeletedContact) {
   setContact(index);
   initContactModification(idDeletedContact);
   deleteSelectedContact();
    goToMainPage();
  }


  public boolean isThereAContact() {
  return  isElementPresent(By.name("selected[]"));

  }


  public int getContactCount() {
  return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements=wd.findElements(By.name("entry"));
    for (WebElement element:elements) {
      List<WebElement> cells=element.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      int id=Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact=new ContactData().withFirst_name(firstname).withLast_name(lastname).withId(id);
      contacts.add(contact);

    }
    return contacts;
  }

  public void delete(ContactData contact, int idDeletedContact) {
    setContactById(contact.getId());
    initContactModification(idDeletedContact);
    deleteSelectedContact();
    goToMainPage();
  }

  private void setContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id + "']")).click();
  }
}
