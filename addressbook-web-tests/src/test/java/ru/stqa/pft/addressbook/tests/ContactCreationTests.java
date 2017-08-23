package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends  TestBase {


  @Test(enabled = true)
  public void testContactCreation() {

    app.goTo().HomePage();
    Contacts before = app.contact().all();
    File photo=new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().
            withLast_name("Ivanov").
            withFirst_name("Ivan").
            withPhoto(photo).
            withGroup("test2");
    app.contact().create(contact);
    app.goTo().HomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    System.out.println(app.contact().all());




    assertThat(after, equalTo(
            before.withAdded( contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));



  }


  @Test(enabled = false)

  public void testCurrentDir(){
    File currentDir=new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo=new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
