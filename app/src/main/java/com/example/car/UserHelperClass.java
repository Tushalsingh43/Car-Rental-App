package com.example.car;

public class UserHelperClass {

    String firstName,lastname,email,license,expiryd,dateofbirth,phoneNumber,street,city,postalCode,password;

    public UserHelperClass() {
    }

    public UserHelperClass(String firstName, String lastname, String email, String license, String expiryd, String dateofbirth, String phoneNumber, String street, String city, String postalCode, String password) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.license = license;
        this.expiryd = expiryd;
        this.dateofbirth = dateofbirth;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getExpiryd() {
        return expiryd;
    }

    public void setExpiryd(String expiryd) {
        this.expiryd = expiryd;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
