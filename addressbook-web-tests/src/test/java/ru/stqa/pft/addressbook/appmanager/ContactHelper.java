package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Антон on 09.07.2017.
 */
public class ContactHelper extends  HelperBase {
  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));

  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirst_name());
    type(By.name("lastname"), contactData.getLast_name());
    type(By.name("address"), contactData.getMobile_phone());
    type(By.name("mobile"), contactData.getMobile_phone());
    type(By.name("email"), contactData.getE_mail());

  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


  public void setContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
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

}
