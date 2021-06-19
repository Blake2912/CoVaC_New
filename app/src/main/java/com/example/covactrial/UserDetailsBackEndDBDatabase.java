package com.example.covactrial;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserDetailsBackEndDB.class}, version = 1)
public abstract class UserDetailsBackEndDBDatabase extends RoomDatabase {
    public abstract UserDetailsBackEndDBDao userDetailsDao();
    // Using Singleton as suggested by google this will help us access the database n no of times and from anywhere in the database.
    private static volatile UserDetailsBackEndDBDatabase INSTANCE;
    static UserDetailsBackEndDBDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (UserDetailsBackEndDBDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDetailsBackEndDBDatabase.class,"UserDetails_Database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
