package com.example.gen.androidarchprac.Pojo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AccountDAO  {
    @Query("SELECT * FROM account")
    public List<Account> loadAccounts();

    @Insert
    public void addAccount(Account account);
}
