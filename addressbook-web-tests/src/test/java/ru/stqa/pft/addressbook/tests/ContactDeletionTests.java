package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @Test (enabled=false)
  public void testContactDeletion() {
    app.getContactHelper().goToMainPage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("erer", "sdfdsf", "sdfdsf", "78787", "sdfsadf@dsf", "test1"));

    }

    app.getNavigationHelper().gotoHomePage();


    List<ContactData> before=app.getContactHelper().getContactList();

    app.getContactHelper().setContact(before.size()-1);
    app.getContactHelper().initContactModification(before.size()-1);
    app.getContactHelper().deleteSelectedContact();

    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after=app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size()-1);

      Assert.assertEquals(before,after);



  }


}

