package com.raja.demomvvmjava;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@androidx.room.Dao
public interface UserDao {

    @Insert
    void insert(User model);

    @Update
    void update(User model);

    @Delete
    void delete(User model);

    @Query("DELETE FROM user_table")
    void deleteAllCourses();

    @Query("DELETE FROM user_table " + " WHERE id = :ID")
    void deleteID(int ID);

    @Query("SELECT * FROM user_table ORDER BY name ASC")
    LiveData<List<User>> getAllUsers();

}
