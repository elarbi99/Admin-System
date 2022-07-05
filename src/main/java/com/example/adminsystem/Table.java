package com.example.adminsystem;

import javafx.beans.property.SimpleStringProperty;

public class Table {
    private SimpleStringProperty id;
    private SimpleStringProperty fName;
    private SimpleStringProperty lName;
    private SimpleStringProperty phone;
    private SimpleStringProperty phone2;
    private SimpleStringProperty doh;
    private SimpleStringProperty position;
    private SimpleStringProperty emergencyContact;
    private SimpleStringProperty emergencyContactPhone;
    private SimpleStringProperty emergencyContactPhone2;
    private SimpleStringProperty emergencyContact2;
    private SimpleStringProperty payRate;
    private SimpleStringProperty email;

    public Table(String id,String fName,String lName,String position,String doh,String email,String phone,
                 String phone2, String emergencyContact, String emergencyContactPhone, String emergencyContact2, String emergencyContactPhone2, String payRate) {
        this.id = new SimpleStringProperty(id);
        this.fName = new SimpleStringProperty(fName);
        this.lName = new SimpleStringProperty(lName);
        this.position = new SimpleStringProperty(position);
        this.doh = new SimpleStringProperty(doh);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.phone2 = new SimpleStringProperty(phone2);
        this.emergencyContact =new SimpleStringProperty(emergencyContact);
        this.emergencyContactPhone =new SimpleStringProperty(emergencyContactPhone);
        this.emergencyContact2 =new SimpleStringProperty(emergencyContact2);
        this.emergencyContactPhone2 =new SimpleStringProperty(emergencyContactPhone2);
        this.payRate =new SimpleStringProperty(payRate);
    }

    public String getId() {
        return id.get();
    }

    public String getEmail() {
        return email.get();
    }

    ///public String getTitle() {
        //return title;
    //}

    public void setId(String id) {
        this.id.set(id);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getfName() {
        return fName.get();
    }

    public SimpleStringProperty fNameProperty() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName.set(fName);
    }

    public String getlName() {
        return lName.get();
    }

    public SimpleStringProperty lNameProperty() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName.set(lName);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getPhone2() {
        return phone2.get();
    }

    public SimpleStringProperty phone2Property() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2.set(phone2);
    }

    public String getDoh() {
        return doh.get();
    }

    public SimpleStringProperty dohProperty() {
        return doh;
    }

    public void setDoh(String doh) {
        this.doh.set(doh);
    }

    public String getEmergencyContact() {
        return emergencyContact.get();
    }

    public SimpleStringProperty emergencyContactProperty() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact.set(emergencyContact);
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone.get();
    }

    public SimpleStringProperty emergencyContactPhoneProperty() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone.set(emergencyContactPhone);
    }

    public String getEmergencyContactPhone2() {
        return emergencyContactPhone2.get();
    }

    public SimpleStringProperty emergencyContactPhone2Property() {
        return emergencyContactPhone2;
    }

    public void setEmergencyContactPhone2(String emergencyContactPhone2) {
        this.emergencyContactPhone2.set(emergencyContactPhone2);
    }

    public String getEmergencyContact2() {
        return emergencyContact2.get();
    }

    public SimpleStringProperty emergencyContact2Property() {
        return emergencyContact2;
    }

    public void setEmergencyContact2(String emergencyContact2) {
        this.emergencyContact2.set(emergencyContact2);
    }


    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getPayRate() {
        return payRate.get();
    }

    public SimpleStringProperty payRateProperty() {
        return payRate;
    }

    public void setPayRate(String payRate) {
        this.payRate.set(payRate);
    }
}
