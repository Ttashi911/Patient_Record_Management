package com.tashi.patient_record_management.model;

public class Patient {
    String Name,Address,Treatment,Medication,Number,Blood_type;
    String Image;

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Name='" + Name + '\'' +
                ", Image='" + Image + '\'' +
                ", Address='" + Address + '\'' +
                ", Treatment='" + Treatment + '\'' +
                ", Medication='" + Medication + '\'' +
                ", Number='" + Number + '\'' +
                ", Blood_type='" + Blood_type + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTreatment() {
        return Treatment;
    }

    public void setTreatment(String treatment) {
        Treatment = treatment;
    }

    public String getMedication() {
        return Medication;
    }

    public void setMedication(String medication) {
        Medication = medication;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getBlood_type() {
        return Blood_type;
    }

    public void setBlood_type(String blood_type) {
        Blood_type = blood_type;
    }
}


