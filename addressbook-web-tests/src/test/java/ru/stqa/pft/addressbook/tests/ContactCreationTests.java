package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends  TestBase {

    
    @Test
    public void testContactCreation() {

      app.getNavigationHelper().gotoHomePage();

      List<ContactData> before=app.getContactHelper().getContactList();

       app.getContactHelper().createContact(new ContactData("erer","sdfdsf","sdfdsf","78787","sdfsadf@dsf","test1"));

      app.getNavigationHelper().gotoHomePage();
      List<ContactData> after=app.getContactHelper().getContactList();

      Assert.assertEquals(after.size(), before.size()+1);
      System.out.println(app.getContactHelper().getContactList());
    }


}
