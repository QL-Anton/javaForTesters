package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
      app.goTo().HomePage();
      if( app.contact().list().size()==0){
        app.contact().create(new ContactData().withLast_name("sdfsdfsdaf").
                withFirst_name("dsafdsaf").
                withAddress("vreverg").
                withE_mail("dsafadsf@sdfg").
                withMobile_phone("23434534")
        );
      }
      app.goTo().HomePage();
  }



    @Test (enabled=true)
    public void testContactModification() {



      List<ContactData> before=app.contact().list();
      int index=before.size()-1;
      ContactData contact=new ContactData().withId(before.get(index).getId()).
              withLast_name("Ivanov").
              withFirst_name("Ivan").
              withAddress("Lenina").
              withE_mail("testovyi@mail.ru").
              withMobile_phone("+7-919-23324234324");

      int indexModContact=before.get(index).getId();
      app.contact().modify(index, contact, indexModContact);

      List<ContactData> after=app.contact().list();
      Assert.assertEquals(after.size(),before.size());

      before.remove(index);
      before.add(contact);


      Comparator<? super ContactData> ById=(c1,c2)->Integer.compare(c1.getId(),c2.getId());
      before.sort(ById);
      after.sort(ById);
      Assert.assertEquals(before, after);

    }




}
