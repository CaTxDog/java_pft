package ru.truakdsg.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.truakdsg.pft.addressbook.model.ContactData;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static ru.truakdsg.pft.addressbook.appmanager.HelperBase.generateRandomInt;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    new JCommander(generator, args);
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContact(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format "+format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;\n"
                , contact.getFirstname()
                , contact.getLastname()
                , contact.getNickname()
                , contact.getPhoto()
                , contact.getCompany()
                , contact.getAddress()
                , contact.getHomePhone()
                , contact.getMobilePhone()
                , contact.getWorkPhone()
                , contact.getEmail()
                , contact.getEmail2()
                , contact.getEmail3()));
      }
    }
  }

  private List<ContactData> generateContact(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i=0; i<count; i++){
      contacts.add(new ContactData()
              .withFirstname("Sergey " + generateRandomInt(50))
              .withLastname("Test " + generateRandomInt(50))
              .withNickname("NewBie " + generateRandomInt(50))
              .withPhoto(new File("src\\test\\resources\\stru.png"))
              .withCompany("Raif")
              .withAddress("Omsk")
              .withHomePhone("+7" + generateRandomInt(Integer.MAX_VALUE))
              .withMobilePhone("+7" + generateRandomInt(Integer.MAX_VALUE))
              .withWorkPhone("+7" + generateRandomInt(Integer.MAX_VALUE))
              .withEmail("Email_1@test.com")
              .withEmail2("Email_2@test1.com")
              .withEmail3("Email_3@test1.com"));
    }
    return contacts;
  }
}

