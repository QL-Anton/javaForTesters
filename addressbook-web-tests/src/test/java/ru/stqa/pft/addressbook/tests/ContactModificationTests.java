package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
      app.goTo().HomePage();
      if( app.contact().all().size()==0){
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



      Set<ContactData> before=app.contact().all();
      ContactData modifyContact=before.iterator().next();

      int index=before.size()-1;

      ContactData contact=new ContactData().withId(modifyContact.getId()).
              withLast_name("Ivanov").
              withFirst_name("Ivan").
              withAddress("Lenina").
              withE_mail("testovyi@mail.ru").
              withMobile_phone("+7-919-23324234324");


      app.contact().modify( contact);

      Set<ContactData> after=app.contact().all();
      Assert.assertEquals(after.size(),before.size());

      before.remove(modifyContact);
      before.add(contact);



      Assert.assertEquals(before, after);

    }




}
