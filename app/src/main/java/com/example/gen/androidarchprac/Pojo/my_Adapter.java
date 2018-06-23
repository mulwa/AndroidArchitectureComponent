package com.example.gen.androidarchprac.Pojo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gen.androidarchprac.R;

import java.util.List;

public class my_Adapter extends RecyclerView.Adapter<my_Adapter.myViewHolder> {
    List<Account> accounts;

    public my_Adapter(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_custom_row,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.m_name.setText(account.getName());
        holder.m_password.setText(account.getPassword());

    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        public TextView m_name, m_password;

        public myViewHolder(View itemView) {
            super(itemView);
            m_name = itemView.findViewById(R.id.tv_name);
            m_password = itemView.findViewById(R.id.tv_password);
        }
    }
}
