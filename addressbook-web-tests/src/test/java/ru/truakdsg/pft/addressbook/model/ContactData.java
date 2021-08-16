package ru.truakdsg.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String nickname;
  private String company;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String email;
  private String email2;

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, address);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            '}';
  }
}

