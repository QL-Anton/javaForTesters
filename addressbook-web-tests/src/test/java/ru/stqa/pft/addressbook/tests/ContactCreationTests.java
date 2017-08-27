package ru.stqa.pft.addressbook.tests;



import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list=new ArrayList<Object[]>();
    try(BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));){
      String xml="";
      String line= reader.readLine();
      while (line!=null){
        xml +=line;
        line= reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts= (List<ContactData>)xstream.fromXML(xml);
      return  contacts.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    List<Object[]> list=new ArrayList<Object[]>();
   try( BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));){
     String json="";
     String line= reader.readLine();
     while (line!=null){
       json +=line;
       line= reader.readLine();
     }
     Gson gson = new Gson();
     List<ContactData> contacts =gson.fromJson(json,new TypeToken<List<ContactData>>(){}.getType()); //List<ContactData>.class -то же самое практически
     return  contacts.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();
   }
  }



  @Test(enabled = true, dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) {

    app.goTo().HomePage();
    Contacts before = app.contact().all();

    app.contact().create(contact);
    app.goTo().HomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));




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
