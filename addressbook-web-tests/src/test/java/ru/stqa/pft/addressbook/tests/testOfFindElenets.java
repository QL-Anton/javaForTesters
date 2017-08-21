package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

/**
 * Created by Антон on 19.08.2017.
 */
public class testOfFindElenets  extends  TestBase{


  @Test(enabled = true)
  public void testFindElements() {

    app.goTo().HomePage();
    ContactData contact = new ContactData().
            withLast_name("Ivanov").
            withFirst_name("Ivan").
            withAddress("Lenina").
            withE_mail("testovyi@mail.ru").
         withEmail2("testmail2@mail.ru").
            withEmail3("testmail3@mailmjnnnnnnnn.ru").
            withMobile_phone("+7-919-23324234324").
            withWorkPhone("3243289543-5").
            withHomePhone("325345345").
            withGroup("test2");
    app.contact().create(contact);
    app.contact().goToMainPage();
    Contacts after = app.contact().all();
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());

    ContactData contactInfoFromDetalied = app.contact().infoFromDetaliedForm(contact);

    System.out.println(contactInfoFromDetalied);
    System.out.println(contact);

    System.out.println(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());


  }

}
