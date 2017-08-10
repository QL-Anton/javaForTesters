package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends  TestBase {

    
    @Test
    public void testContactCreation() {

      app.getNavigationHelper().gotoHomePage();

      List<ContactData> before=app.getContactHelper().getContactList();
       ContactData contact=new ContactData("very_cool_Jhon","sdfdsf","sdfdsf","78787","sdfsadf@dsf","test1");
       app.getContactHelper().createContact(contact);

      app.getNavigationHelper().gotoHomePage();
      List<ContactData> after=app.getContactHelper().getContactList();

      Assert.assertEquals(after.size(), before.size()+1);
      System.out.println(app.getContactHelper().getContactList());



      int max=0;
      for (ContactData c:after){
        if (c.getId()>max){
          max=c.getId();
        }
      }



      int max1=after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
      

contact.setId(max1);
      before.add(contact);



      Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));

    }


}
