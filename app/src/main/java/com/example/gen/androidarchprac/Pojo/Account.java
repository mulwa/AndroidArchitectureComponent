package com.example.gen.androidarchprac.Pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "account")
public class Account {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "account_name")
    public String name;
    @ColumnInfo(name = "password")
    public String password;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
