package com.example.maximus.grizzfit;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Zach on 3/25/2018.
 */

@Database(entities = {FoodLog.class}, version = 1)
public abstract class LogDatabase extends RoomDatabase{
    public abstract LogDao logDao();
}
