package com.example.gen.androidarchprac.Pojo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Account.class},version = 1, exportSchema = false)
public abstract class appDatabase extends RoomDatabase {
    public abstract AccountDAO accountDAO();
}
