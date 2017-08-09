package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    
    @Test
    public void testContactModification() {

      app.getNavigationHelper().gotoHomePage();

      if(! app.getContactHelper().isThereAContact()){
        app.getContactHelper().createContact(new ContactData("erer","sdfdsf","sdfdsf","78787","sdfsadf@dsf","test1"));
      }
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> before=app.getContactHelper().getContactList();
      app.getContactHelper().setContact(before.size()-1);
      app.getContactHelper().initContactModification();
      ContactData contact=new ContactData("testfn_mod", "testln_mod", "testad_mod", "91799992", "test@test.test",null,before.get(before.size()-1).getId());
      app.getContactHelper().fillContactForm(contact, false);
      app.getContactHelper().submitModificationContact();
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> after=app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(),before.size());

      before.remove((before.size()-1));
      before.add(contact);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
    

    



}
