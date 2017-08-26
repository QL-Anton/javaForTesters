package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 26.08.2017.
 */
public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {

      jCommander.usage();
      return;
    }
    generator.run();
  }


  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format");
    }

  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();

  }

  //Запись в файл
  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirst_name(), contact.getLast_name(), contact.getAddress(),
              contact.getGroup(), contact.getMobile_phone(), contact.getHome_phone(), contact.getHome_phone(),
              contact.getWork_phone(), contact.getE_mail(), contact.getEmail2(), contact.getEmail3()));
    }

    writer.close();
  }


  //генератор данных-контактов
  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts=new ArrayList<ContactData>();
    for(int i=0; i<count; i++){
      contacts.add(new ContactData().
              withFirst_name(String.format("test First name %s",i)).
              withLast_name(String.format("test Last name %s",i)).
              withAddress(String.format("test address %s", i)).
              withGroup(String.format("test2")).
              withMobile_phone(String.format("8-917-243-54-%s",i)).
              withHomePhone(String.format("8-917-567-65-%s",i)).
              withWorkPhone(String.format("8-919-354-45-%s",i)).
              withE_mail(String.format("test mail1_%s@ya.ru",i)).
              withEmail2(String.format("test mail2_%s@ya.ru",i)).
              withEmail3(String.format("test mail3_%s@ya.ru",i)));
    }
    return contacts;
  }


}
