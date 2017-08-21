package ru.stqa.pft.addressbook.model;

public class ContactData {
  private  String first_name;
  private  String last_name;
  private  String address;
  private  String e_mail;
  private  String group;
  private int  id=Integer.MAX_VALUE;
  private String  mobile_phone;
  private String  home_phone;
  private String  work_phone;
  private String allPhones;
  private  String email2;
  private  String email3;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
    return last_name != null ? last_name.equals(that.last_name) : that.last_name == null;
  }

  @Override
  public int hashCode() {
    int result = first_name != null ? first_name.hashCode() : 0;
    result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
    result = 31 * result + id;
    return result;
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

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


}