package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.openqa.selenium.OutputType.*;

public class ContactModificationTests extends TestBase {

    
    @Test
    public void testContactModification() {

      app.getNavigationHelper().gotoHomePage();

      if(! app.getContactHelper().isThereAContact()){
        app.getContactHelper().createContact(new ContactData("erer","sdfdsf","sdfdsf","78787","sdfsadf@dsf","test1"));
      }
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().setContact();
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("testfn_mod", "testln_mod", "testad_mod", "91799992", "test@test.test",null), false);
      app.getContactHelper().submitModificationContact();
      app.getNavigationHelper().gotoHomePage();
    }
    

    



}
