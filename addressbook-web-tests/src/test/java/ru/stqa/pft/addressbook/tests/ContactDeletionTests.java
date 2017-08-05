package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
  FirefoxDriver wd;


  @Test
  public void testContactDeletion() {
    app.getContactHelper().goToMainPage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("erer", "sdfdsf", "sdfdsf", "78787", "sdfsadf@dsf", "test1"));

    }
    app.getNavigationHelper().gotoHomePage();

    app.getContactHelper().setContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().deleteSelectedContact();

  }


}

