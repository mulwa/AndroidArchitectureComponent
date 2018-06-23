package com.example.gen.androidarchprac;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gen.androidarchprac.Pojo.Account;
import com.example.gen.androidarchprac.Pojo.appDatabase;

public class add_account extends AppCompatActivity {
    private EditText name,password;
    private Button save;
    public appDatabase appDatabase;
    private final String dbName = "account_db";
    private String TAG = "logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        appDatabase = Room.databaseBuilder(this,appDatabase.class,dbName)
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();

        name = findViewById(R.id.ed_name);
        password = findViewById(R.id.ed_password);
        save = findViewById(R.id.btn_submit);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeData();

            }
        });
    }
    private void storeData(){
        Log.d(TAG,"adding content");
        Account account = new Account(name.getText().toString().trim(), password.getText().toString().trim());

        appDatabase.accountDAO().addAccount(account);
        Toast.makeText(getApplicationContext(),"Storing Data Done",Toast.LENGTH_LONG).show();


    }
}
