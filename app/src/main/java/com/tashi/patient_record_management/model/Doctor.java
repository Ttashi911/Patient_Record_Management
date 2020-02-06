package com.tashi.patient_record_management.model;

public class Doctor {
    String Name,Graduate,Specialist,Address,Number;


    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Name='" + Name + '\'' +
                ", Graduate='" + Graduate + '\'' +
                ", Specialist='" + Specialist + '\'' +
                ", Address='" + Address + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGraduate() {
        return Graduate;
    }

    public void setGraduate(String graduate) {
        Graduate = graduate;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(String specialist) {
        Specialist = specialist;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
