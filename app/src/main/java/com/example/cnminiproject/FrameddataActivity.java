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
        meslits.addAll(Arrays.asList(new String[]{"#","header", "a", "b", "ESC", "#", "d", "c","ESC","ESC","trailer", "#"}));

        recycleradapter adap = new recycleradapter(meslits,"#",this);

        frame.setAdapter(adap);
        frame.setLayoutManager(new LinearLayoutManager(this));
    }
}