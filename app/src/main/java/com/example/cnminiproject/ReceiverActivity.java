package com.example.cnminiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ReceiverActivity extends AppCompatActivity {

    String flag;
    String mes;
    RecyclerView reciverrecyler;
    ArrayList<String> meslits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        flag = getIntent().getStringExtra("flag");
        mes = getIntent().getStringExtra("mes");

        meslits = new ArrayList<>();

        reciverrecyler = findViewById(R.id.receiverrecycler);

        char[] flagarr = flag.toCharArray();
        char[] arr = mes.toCharArray();
        meslits.add(flag);
        meslits.add("header");
        for(int i=0;i<arr.length;i++)
        {
            meslits.add("" + arr[i]);
        }
        meslits.add("trailer");
        meslits.add(flag);


        recycleradapter adap = new recycleradapter(meslits,flag,this);

        reciverrecyler.setAdapter(adap);
        reciverrecyler.setLayoutManager(new LinearLayoutManager(this));
    }
}