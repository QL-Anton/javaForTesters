package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Антон on 19.08.2017.
 */
public class ContactPhoneTests extends TestBase {

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
              withWorkPhone("2345435")

      );
    }
    app.goTo().HomePage();
  }

  @Test
   public void testContactPhones() {
    app.contact().goToMainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditor = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditor)));


  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome_phone(),contact.getMobile_phone(),contact.getWork_phone())
    .stream().
                    filter((s)->! s.equals("")).
                    map(ContactPhoneTests::cleaned).
            collect(Collectors.joining("\n"));



  }



  public static  String cleaned(String phone){
      return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
  }



