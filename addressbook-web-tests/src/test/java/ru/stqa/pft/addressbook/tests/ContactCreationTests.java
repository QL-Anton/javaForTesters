package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends  TestBase {

    
    @Test (enabled=true)
    public void testContactCreation() {

      app.goTo().HomePage();
      List<ContactData> before=app.contact().list();
       ContactData contact=new ContactData().
               withLast_name("Ivanov").
               withFirst_name("Ivan").
               withAddress("Lenina").
               withE_mail("testovyi@mail.ru").
               withMobile_phone("+7-919-23324234324").
               withGroup("test2");
       app.contact().create(contact);
      app.goTo().HomePage();
      List<ContactData> after=app.contact().list();
      Assert.assertEquals(after.size(), before.size()+1);
      System.out.println(app.contact().list());

      before.add(contact);

      Comparator<? super ContactData> ById=(c1,c2)->Integer.compare(c1.getId(),c2.getId());
      before.sort(ById);
      after.sort(ById);

      Assert.assertEquals(after,before);

    }


}
