package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


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
  public void testContactDeletion() {
    List<ContactData> before=app.contact().list();
    int index=before.size()-1;

    int indexModContact=before.get(index).getId();
    app.contact().delete(index, indexModContact);
    List<ContactData> after=app.contact().list();
    Assert.assertEquals(after.size(), before.size()-1);

     before.remove(index);
    Assert.assertEquals(before,after);



  }



}

