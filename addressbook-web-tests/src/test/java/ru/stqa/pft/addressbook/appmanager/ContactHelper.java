package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

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
    type(By.name("work)"), contactData.getWork_phone());
    type(By.name("home"), contactData.getHome_phone());

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



  public ContactData infoFromEditForm(ContactData contact){
    initContactModification(contact.getId());
    String firstname=wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname=wd.findElement(By.name("lastname")).getAttribute("value");
    String home=wd.findElement(By.name("home")).getAttribute("value");
    String mobile=wd.findElement(By.name("mobile")).getAttribute("value");
    String work=wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).
            withFirst_name(firstname).
            withLast_name(lastname).
            withHomePhone(home).
            withMobile_phone(mobile).
            withWorkPhone(work);
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements=wd.findElements(By.name("entry"));
    for (WebElement element:elements) {
      List<WebElement> cells=element.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();

      String[] phones = cells.get(5).getText().split("\n");



      int id=Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact=new ContactData().withFirst_name(firstname).withLast_name(lastname).withId(id).
              withHomePhone(phones[0]).withMobile_phone(phones[1]).withWorkPhone(phones[2]);
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
