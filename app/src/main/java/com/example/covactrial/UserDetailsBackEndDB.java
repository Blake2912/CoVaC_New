package com.example.covactrial;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
    1. Make insertions and deletions in the database (DONE)
    2. Start making entities to get the following variables stored in the database
        a. Name (DONE)
        b. Year of Birth (We don't require the whole DOB, the year will do the job.) (DONE)
        c. Phone Number (DONE)
        d. Govt ID Number (DONE)
        e. First Dose (DONE)
        f. Second Dose (DONE)
        g. Vaccine Type (DONE)
        h. Hospital Details (DONE)
        i. Password (DONE)
 */

@Entity(tableName = "User_Details")
public class UserDetailsBackEndDB {

    @PrimaryKey(autoGenerate = true)
    Integer uid;

    @ColumnInfo(name="Name")
    String name;

    @ColumnInfo(name="Phone_number")
    String PhoneNumber;

    // DOB ****
    @ColumnInfo(name="DOB_Year")
    int Year_DOB;
    // **** DOB

    @ColumnInfo(name="GovtID")
    String Govt_ID;

    @ColumnInfo(name="Password")
    String Password;

    @ColumnInfo(name="Vaccine_Type")
    String VaccineType;

    // First_Dose ****
    @ColumnInfo(name="First_Dose_Date")
    String first_Dose_Date;
    // **** First_Dose

    // Second_Dose ****
    @ColumnInfo(name="Second_Dose_Date")
    String second_Dose_Date;
    // **** Second_Dose

    @ColumnInfo(name="Hospital_Details")
    String Hospital_Name;

    @ColumnInfo(name="Pin_code")
    String PinCode;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getYear_DOB() {
        return Year_DOB;
    }

    public void setYear_DOB(int year_DOB) {
        Year_DOB = year_DOB;
    }

    public String getGovt_ID() {
        return Govt_ID;
    }

    public void setGovt_ID(String govt_ID) {
        Govt_ID = govt_ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getVaccineType() {
        return VaccineType;
    }

    public void setVaccineType(String vaccineType) {
        VaccineType = vaccineType;
    }

    public String getHospital_Name() {
        return Hospital_Name;
    }

    public void setHospital_Name(String hospital_Name) {
        Hospital_Name = hospital_Name;
    }

    public String getFirst_Dose_Date() {
        return first_Dose_Date;
    }

    public void setFirst_Dose_Date(String first_Dose_Date) {
        this.first_Dose_Date = first_Dose_Date;
    }

    public String getSecond_Dose_Date() {
        return second_Dose_Date;
    }

    public void setSecond_Dose_Date(String second_Dose_Date) {
        this.second_Dose_Date = second_Dose_Date;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String pinCode) {
        PinCode = pinCode;
    }

}
