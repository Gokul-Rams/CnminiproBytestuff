package com.example.cnminiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class FrameddataActivity extends AppCompatActivity {

    String flag;
    String mes;
    RecyclerView frame;
    ArrayList<String> meslits;
    Boolean binaryflag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameddata);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Byte stuffed data");

        flag = getIntent().getStringExtra("flag");
        mes = getIntent().getStringExtra("mes");
        binaryflag = getIntent().getBooleanExtra("binaryflag",true);

        frame = findViewById(R.id.recyclerframeddata);

        meslits = new ArrayList<>();


        char[] flagarr = flag.toCharArray();
        char[] arr = mes.toCharArray();
        if(!binaryflag)
        {
            meslits.add(flag);
            meslits.add("header");
        }
        else {
            meslits.add(flag + " - " + Integer.toBinaryString(flagarr[0]));
            meslits.add("header");
        }
        for(int i=0;i<arr.length;i++)
        {
            if(!binaryflag) {
                if (arr[i] == flagarr[0]) {
                    meslits.add("ESC");
                    meslits.add("" + arr[i]);
                }else if(arr[i] == '|')
                {
                    meslits.add("ESC");
                    meslits.add("ESC(|)");
                }
                else {
                    meslits.add("" + arr[i]);
                }
            }
            else {
                if (arr[i] == flagarr[0]) {
                    meslits.add("ESC");
                    meslits.add("" + arr[i] + " - " + Integer.toBinaryString(arr[i]));
                }else if(arr[i] == '|')
                {
                    meslits.add("ESC");
                    meslits.add("ESC(|)");
                }
                else {
                    meslits.add("" + arr[i] + " - " +Integer.toBinaryString(arr[i]));
                }
            }
        }
        if(!binaryflag)
        {
            meslits.add("trailer");
            meslits.add(flag);
        }
        else {
            meslits.add("trailer");
            meslits.add(flag + " - " + Integer.toBinaryString(flagarr[0]));
        }


        recycleradapter adap = new recycleradapter(meslits,"#",this);

        frame.setAdapter(adap);
        frame.setLayoutManager(new LinearLayoutManager(this));
    }
}