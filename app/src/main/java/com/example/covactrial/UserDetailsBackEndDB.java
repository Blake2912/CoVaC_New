package com.example.covactrial;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "User_Details")
public class UserDetailsBackEndDB {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @NonNull
    @ColumnInfo(name="Name")
    public String name;

    @NonNull
    @ColumnInfo(name="Phone_number")
    public long PhoneNumber;

    // DOB ****
    @ColumnInfo(name="DOB_Year")
    public int Year_DOB;
    // **** DOB

    @ColumnInfo(name="GovtID")
    public int Govt_ID;

    @NonNull
    @ColumnInfo(name="Password")
    public String Password;

    @ColumnInfo(name="Vaccine_Type")
    public String VaccineType;

    // First_Dose ****
    @ColumnInfo(name="First_Dose_Date")
    public int Day_First_Dose;
    @ColumnInfo(name="First_Dose_Month")
    public int Month_First_Dose;
    @ColumnInfo(name="First_Dose_Year")
    public int Year_First_Dose;
    // **** First_Dose

    // Second_Dose ****
    @ColumnInfo(name="Second_Dose_Date")
    public int Day_Second_Dose;
    @ColumnInfo(name="Second_Dose_Month")
    public int Month_Second_Dose;
    @ColumnInfo(name="Second_Dose_Year")
    public int Year_Second_Dose;
    // **** Second_Dose

    @ColumnInfo(name="Hospital_Details")
    public String Hospital_Name;

    public UserDetailsBackEndDB(){

    }
}
