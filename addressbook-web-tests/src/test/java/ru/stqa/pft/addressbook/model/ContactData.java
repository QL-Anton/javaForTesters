package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.io.File;

@Entity
@XStreamAlias("contact")
@Table(name="addressbook")
public class ContactData {
  @Expose
  @Column(name="firstname")
  private  String first_name;
  @Expose
  @Column(name="lastname")
  private  String last_name;
  @Expose
  @Column(name="address")
  @Type(type="text")
  private  String address;
  @Expose
  @Column(name="email")
  @Type(type="text")
  private  String e_mail;
  @Expose
  @Transient
  private  String group;

  @XStreamOmitField
  @Id

  @Column(name="id")
  private int  id=Integer.MAX_VALUE;
  @Expose
  @Column(name="mobile")
  @Type(type="text")
  private String  mobile_phone;
  @Expose
  @Column(name="home")
  @Type(type="text")
  private String  home_phone;
  @Expose
  @Column(name="work")
  @Type(type="text")
  private String  work_phone;
  @Expose
  @Transient
  private String allPhones;
  @Expose
  @Column(name="email2")
  @Type(type="text")
  private  String email2;
  @Expose
  @Column(name="email3")
  @Type(type="text")
  private  String email3;
  @Expose
  @Transient
  private String allEmails;

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return  this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }




  public String getAllPhones() {
    return allPhones;
  }



  public ContactData withHomePhone(String home_phone) {
    this.home_phone = home_phone;
    return this;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public String getWork_phone() {
    return work_phone;
  }

  public ContactData withWorkPhone(String work_phone) {
    this.work_phone = work_phone;
    return this;
  }

  public ContactData withLast_name(String last_name) {
    this.last_name = last_name;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobile_phone(String mobile_phone) {
    this.mobile_phone = mobile_phone;
    return this;
  }

  public ContactData withE_mail(String e_mail) {
    this.e_mail = e_mail;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;

  }

  public ContactData withFirst_name(String first_name) {

    this.first_name = first_name;

    return this;
  }



  public ContactData withId(int id) {
    this.id = id;
    return this;
  }


  public int getId() {
    return id;
  }


  public String getFirst_name() {
    return first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile_phone() {
    return mobile_phone;
  }

  public String getE_mail() {
    return e_mail;
  }

  public String getGroup() {
    return group;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "first_name='" + first_name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", address='" + address + '\'' +
            ", e_mail='" + e_mail + '\'' +
            ", group='" + group + '\'' +
            ", id=" + id +
            ", mobile_phone='" + mobile_phone + '\'' +
            ", home_phone='" + home_phone + '\'' +
            ", work_phone='" + work_phone + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", allEmails='" + allEmails + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
    if (last_name != null ? !last_name.equals(that.last_name) : that.last_name != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (e_mail != null ? !e_mail.equals(that.e_mail) : that.e_mail != null) return false;
    if (group != null ? !group.equals(that.group) : that.group != null) return false;
    if (mobile_phone != null ? !mobile_phone.equals(that.mobile_phone) : that.mobile_phone != null) return false;
    if (home_phone != null ? !home_phone.equals(that.home_phone) : that.home_phone != null) return false;
    if (work_phone != null ? !work_phone.equals(that.work_phone) : that.work_phone != null) return false;
    if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    return allEmails != null ? allEmails.equals(that.allEmails) : that.allEmails == null;
  }

  @Override
  public int hashCode() {
    int result = first_name != null ? first_name.hashCode() : 0;
    result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (e_mail != null ? e_mail.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    result = 31 * result + id;
    result = 31 * result + (mobile_phone != null ? mobile_phone.hashCode() : 0);
    result = 31 * result + (home_phone != null ? home_phone.hashCode() : 0);
    result = 31 * result + (work_phone != null ? work_phone.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
    return result;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


}