package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

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



      Contacts before=app.contact().all();
      ContactData modifyContact=before.iterator().next();

      int index=before.size()-1;

      ContactData contact=new ContactData().withId(modifyContact.getId()).
              withLast_name("Ivanov").
              withFirst_name("Ivan").
              withAddress("Lenina").
              withE_mail("testovyi@mail.ru").
              withMobile_phone("+7-919-23324234324");


      app.contact().modify( contact);

      Contacts after=app.contact().all();
      Assert.assertEquals(after.size(),before.size());


      assertThat(after, equalTo(before.withOut(modifyContact).withAdded(contact)));

    }




}
