package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends  TestBase {

    
    @Test (enabled=false)
    public void testContactCreation() {

      app.goTo().gotoHomePage();

      List<ContactData> before=app.getContactHelper().getContactList();
       ContactData contact=new ContactData("very_cool_Jhon","sdfdsf","sdfdsf","78787","sdfsadf@dsf","test1");
       app.getContactHelper().createContact(contact);

      app.goTo().gotoHomePage();
      List<ContactData> after=app.getContactHelper().getContactList();

      Assert.assertEquals(after.size(), before.size()+1);
      System.out.println(app.getContactHelper().getContactList());








      


      before.add(contact);

      Comparator<? super ContactData> ById=(c1,c2)->Integer.compare(c1.getId(),c2.getId());
      before.sort(ById);
      after.sort(ById);

      Assert.assertEquals(after,before);

    }


}
