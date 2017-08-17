package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;



import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends  TestBase {


  @Test(enabled = true)
  public void testContactCreation() {

    app.goTo().HomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().
            withLast_name("Ivanov").
            withFirst_name("Ivan").
            withAddress("Lenina").
            withE_mail("testovyi@mail.ru").
            withMobile_phone("+7-919-23324234324").
            withGroup("test2");
    app.contact().create(contact);
    app.goTo().HomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    System.out.println(app.contact().all());

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());


    assertThat(after, equalTo(
            before.withAdded( contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
}
