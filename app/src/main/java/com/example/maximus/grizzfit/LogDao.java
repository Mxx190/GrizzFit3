package com.example.maximus.grizzfit;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Zach on 3/25/2018.
 */

@Dao
public interface LogDao {

    @Query("SELECT * FROM FoodLog")
    List<FoodLog> getAll();

    @Insert
    void insertAll(FoodLog log);

    @Delete
    void delete(FoodLog log);
}
