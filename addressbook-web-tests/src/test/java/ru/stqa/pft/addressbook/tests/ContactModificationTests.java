package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    
    @Test (enabled=false)
    public void testContactModification() {

      app.goTo().gotoHomePage();

      if(! app.getContactHelper().isThereAContact()){
        app.getContactHelper().createContact(new ContactData("erer","sdfdsf","sdfdsf","78787","sdfsadf@dsf","test1"));
      }
      app.goTo().gotoHomePage();
      List<ContactData> before=app.getContactHelper().getContactList();
      app.getContactHelper().setContact(before.size()-1);
      app.getContactHelper().initContactModification(before.get(before.size()-1).getId());
      ContactData contact=new ContactData("testfn_mod", "testln_mod", "testad_mod", "91799992", "test@test.test",null,before.get(before.size()-1).getId());
      app.getContactHelper().fillContactForm(contact, false);
      app.getContactHelper().submitModificationContact();
      app.goTo().gotoHomePage();
      List<ContactData> after=app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(),before.size());

      before.remove(before.size()-1);
      before.add(contact);


      Comparator<? super ContactData> ById=(c1,c2)->Integer.compare(c1.getId(),c2.getId());
      before.sort(ById);
      after.sort(ById);
      Assert.assertEquals(before, after);

    }
    

    



}
