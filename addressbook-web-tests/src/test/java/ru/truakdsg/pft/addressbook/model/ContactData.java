package ru.truakdsg.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String email;
  private final String email2;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address);
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

  public ContactData(String id, String firstname, String lastname, String nickname, String company, String address, String homePhone, String mobilePhone, String email, String email2) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.email = email;
    this.email2 = email2;
  }

  public ContactData(String firstname, String lastname, String nickname, String company, String address, String homePhone, String mobilePhone, String email, String email2) {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.email = email;
    this.email2 = email2;
  }

  public String getId() {
    return id;
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

}
