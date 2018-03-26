package com.example.maximus.grizzfit;

import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Zach on 3/25/2018.
 */

public abstract class logDatabase extends RoomDatabase{
    public abstract LogDao logDao();
}
