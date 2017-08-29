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
      app.contact().create(new ContactData().withLast_name("sdfsdfsdaf").
              withFirst_name("dsafdsaf").
              withAddress("vreverg").
              withE_mail("dsafadsf@sdfg").
              withMobile_phone("23434534").
              withHomePhone("234324").withWorkPhone("324324324").
              withGroup("test2")
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

