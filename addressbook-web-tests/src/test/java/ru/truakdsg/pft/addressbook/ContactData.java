package ru.truakdsg.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String email;
  private final String email2;

  public ContactData(String firstname, String lastname, String nickname, String company, String address, String homePhone, String mobilePhone, String email, String email2) {
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
