package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    FirefoxDriver wd;
    

    @Test
    public void testContactDeletion() {
        app.getContactHelper().goToMainPage();
  app.getContactHelper().setContact();
  app.getContactHelper().deleteSelectedContact();

    }
    

    }

