package com.example.gen.androidarchprac;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gen.androidarchprac.Pojo.Account;
import com.example.gen.androidarchprac.Pojo.appDatabase;
import com.example.gen.androidarchprac.Pojo.my_Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView m_recyler_v;
    private my_Adapter m_adapter;
    private List<Account> accountList = new ArrayList<>();
    private appDatabase appDatabase;
    private final String dbName = "account_db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appDatabase = Room.databaseBuilder(this,appDatabase.class,dbName)
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();

        m_adapter = new my_Adapter(accountList);
//        setting recyclerview
        m_recyler_v = findViewById(R.id.recyler_view);
        m_recyler_v.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        m_recyler_v.setAdapter(m_adapter);

        loadTestData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),add_account.class));
            }
        });
    }
    private  void loadTestData(){
        List<Account> accounts = appDatabase.accountDAO().loadAccounts();

        Log.d(TAG,accounts.toString());
        if(accounts.isEmpty()){
            Toast.makeText(getApplicationContext(),"please add some account data",Toast.LENGTH_SHORT).show();
        }
        for(Account account: accounts){
            Log.d(TAG,account.getName()+""+ account.getPassword());
            accountList.add(account);
        }
        m_adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
