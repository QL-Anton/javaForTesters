package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Антон on 19.08.2017.
 */
public class ContactPhonesEmailsAndAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();

    if( app.contact().all().size()==0){
      app.contact().create(new ContactData().withLast_name("sdfsdfsdaf").
              withFirst_name("dsafdsaf").
              withAddress("vreverg").
              withE_mail("dsafadsf@sdfg").
              withMobile_phone("23434534").
              withHomePhone("435324").
              withWorkPhone("2345435").
              withGroup("test")

      );
    }
    app.goTo().HomePage();
  }

  @Test
   public void testContactPhonesEmailsAndAddress() {
    app.contact().goToMainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditor = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditor)));
    assertThat(contact.getAllEmails(),equalTo(mergeEmails(contactInfoFromEditor)));
    assertThat(contact.getAddress(),equalTo(contactInfoFromEditor.getAddress()));

  }

  private String mergeEmails(ContactData contactInfoFromEditor) {
    return Arrays.asList(contactInfoFromEditor.getE_mail(),contactInfoFromEditor.getEmail2(),contactInfoFromEditor.getEmail3())
            .stream().
                    filter((s)->! s.equals("")).
                    collect(Collectors.joining("\n"));



  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome_phone(),contact.getMobile_phone(),contact.getWork_phone())
    .stream().
                    filter((s)->! s.equals("")).
                    map(ContactPhonesEmailsAndAddressTests::cleaned).
            collect(Collectors.joining("\n"));



  }



  public static  String cleaned(String phone){
      return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
  }



