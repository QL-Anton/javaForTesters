package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends  TestBase {

    
    @Test (enabled=true)
    public void testContactCreation() {

      app.goTo().HomePage();
      Set<ContactData> before=app.contact().all();
       ContactData contact=new ContactData().
               withLast_name("Ivanov").
               withFirst_name("Ivan").
               withAddress("Lenina").
               withE_mail("testovyi@mail.ru").
               withMobile_phone("+7-919-23324234324").
               withGroup("test2");
       app.contact().create(contact);
      app.goTo().HomePage();
      Set<ContactData> after=app.contact().all();
      Assert.assertEquals(after.size(), before.size()+1);
      System.out.println(app.contact().all());

     contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
      before.add(contact);
      Assert.assertEquals(after,before);

    }


}
