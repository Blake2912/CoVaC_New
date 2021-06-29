package com.example.covactrial;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


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
    void insert(UserDetailsBackEndDB userDetailsBackEndDB);

    @Delete
    void delete(UserDetailsBackEndDB userDetailsBackEndDB);

    @Update
    void update(UserDetailsBackEndDB userDetailsBackEndDB);

    @Query("SELECT * FROM User_Details WHERE Phone_number LIKE :phone_number AND Password LIKE :password LIMIT 1")
    UserDetailsBackEndDB login(String phone_number, String password);

    @Query("SELECT * FROM User_details WHERE Phone_number LIKE :phone_number AND Password LIKE :password LIMIT 1")
    UserDetailsBackEndDB findName(String phone_number, String password);

}


