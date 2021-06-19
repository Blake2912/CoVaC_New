package com.example.covactrial;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


/* TODO::
    1. Make insertions and deletions in the database (DONE)
    2. Start making queries to get the following variables stored in the database
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

@Dao
public interface UserDetailsBackEndDBDao {
    @Insert
    void insert(UserDetailsBackEndDB user);

    @Delete
    void delete(UserDetailsBackEndDB user);

    @Query("SELECT * FROM User_Details WHERE Name LIKE :name LIMIT 1")
    UserDetailsBackEndDB findByName(String name);

    @Query("SELECT * FROM User_Details WHERE Phone_number LIKE :phone_number LIMIT 1")
    UserDetailsBackEndDB findPhoneNumber(int phone_number);

    @Query("SELECT * FROM User_Details WHERE DOB_Year LIKE :year_of_birth LIMIT 1")
    UserDetailsBackEndDB findYearOfBirth(int year_of_birth);

    @Query("SELECT * FROM User_Details WHERE GovtID LIKE :govtID_number LIMIT 1")
    UserDetailsBackEndDB findGovtID(int govtID_number);

    @Query("SELECT * FROM User_Details WHERE First_Dose_Date LIKE :first_dose_date AND First_Dose_Month LIKE :first_dose_month AND First_Dose_Year LIKE :first_dose_year LIMIT 1")
    UserDetailsBackEndDB findFirstDoseDate(int first_dose_date,int first_dose_month, int first_dose_year);

    @Query("SELECT * FROM User_Details WHERE Second_Dose_Date LIKE :second_dose_date AND Second_Dose_Month LIKE :second_dose_month AND Second_Dose_Year LIKE :second_dose_year LIMIT 1")
    UserDetailsBackEndDB findSecondDoseDate(int second_dose_date,int second_dose_month, int second_dose_year);

    @Query("SELECT * FROM User_Details WHERE Vaccine_Type LIKE :vaccine_type LIMIT 1")
    UserDetailsBackEndDB findVaccineType(String vaccine_type);

    @Query("SELECT * FROM User_Details WHERE Hospital_Details LIKE :hospital_name LIMIT 1")
    UserDetailsBackEndDB findHospitalName(String hospital_name);

    @Query("SELECT * FROM User_Details WHERE Password LIKE :password LIMIT 1")
    UserDetailsBackEndDB findPassword(String password);

}


