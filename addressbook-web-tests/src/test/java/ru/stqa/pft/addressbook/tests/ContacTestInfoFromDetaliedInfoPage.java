package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

/**
 * Created by Антон on 19.08.2017.
 */
public class ContacTestInfoFromDetaliedInfoPage extends TestBase {


  @Test(enabled = true)
  public void testContacInfoFromDetaliedInfoPage() {

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
    int maxID=after.stream().mapToInt((c) -> c.getId()).max().getAsInt();
    contact.withId(maxID);
    app.goTo().HomePage();
    ContactData contactInfoFromEditor = app.contact().infoFromEditForm(contact);

    ContactData contactInfoFromDetalied = app.contact().infoFromDetaliedForm(contact);
    MatcherAssert.assertThat(contactInfoFromDetalied, CoreMatchers.equalTo(contactInfoFromEditor));


    System.out.println(contactInfoFromDetalied);
    System.out.println(contactInfoFromEditor);




  }

}
