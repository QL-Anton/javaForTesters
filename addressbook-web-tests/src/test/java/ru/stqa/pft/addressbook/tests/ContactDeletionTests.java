package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if( app.db().contacts().size()==0){
      app.contact().create(new ContactData().
              withLast_name("Ivanov").
              withFirst_name("Ivan").
              withAddress("Lenina").
              withE_mail("testovyi@mail.ru").
              withMobile_phone("+7-919-23324234324").
              withHomePhone("945435").
              withWorkPhone("324324").
              withEmail3("sdfsf").
              withEmail2("fghrgfh4")
      );
    }
    app.goTo().HomePage();
  }


  @Test (enabled=true)
  public void testContactDeletion() {
    Contacts before=app.db().contacts();
    ContactData deletedContact=before.iterator().next();


    app.goTo().HomePage();
    app.contact().delete(deletedContact, deletedContact.getId());
    Contacts after=app.db().contacts();
    Assert.assertEquals(after.size(), before.size()-1);


    assertThat(after, equalTo(before.withOut(deletedContact)));




  }



}

