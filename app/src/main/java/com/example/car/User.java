package com.example.car;

public class User {
    String Name,Email,PhoneNumber,Insurance,PickupDate,ReturnDate,PickupTime,ReturnTime,TotalCost;

    public User() {
    }

    public User(String name, String email, String phoneNumber, String insurance, String pickupDate, String returnDate, String pickupTime, String returnTime, String totalCost) {
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        Insurance = insurance;
        PickupDate = pickupDate;
        ReturnDate = returnDate;
        PickupTime = pickupTime;
        ReturnTime = returnTime;
        TotalCost = totalCost;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getInsurance() {
        return Insurance;
    }

    public void setInsurance(String insurance) {
        Insurance = insurance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPickupDate() {
        return PickupDate;
    }

    public void setPickupDate(String pickupDate) {
        PickupDate = pickupDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public String getPickupTime() {
        return PickupTime;
    }

    public void setPickupTime(String pickupTime) {
        PickupTime = pickupTime;
    }

    public String getReturnTime() {
        return ReturnTime;
    }

    public void setReturnTime(String returnTime) {
        ReturnTime = returnTime;
    }

    public String getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(String totalCost) {
        TotalCost = totalCost;
    }
}
