package com.example.maximus.grizzfit;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Zach on 3/25/2018.
 */

@Database(entities = {FoodLog.class}, version = 1, exportSchema = false)
public abstract class LogDatabase extends RoomDatabase{
    public abstract LogDao logDao();
    private static LogDatabase INSTANCE;

    public static LogDatabase getLogDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LogDatabase.class, "log-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
