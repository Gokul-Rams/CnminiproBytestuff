package com.example.cnminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class getdataActivity extends AppCompatActivity {

    Spinner falgsymbol;
    EditText etdata;
    ExtendedFloatingActionButton donebtn;
    CheckBox cbshowbinary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Data to be byte stuffed");

        falgsymbol = findViewById(R.id.spinnerflag);
        etdata = findViewById(R.id.etdata);
        donebtn = findViewById(R.id.nextbtn);
        cbshowbinary = findViewById(R.id.cbshowbinary);

        ArrayList<String> flaglist = new ArrayList<>();
        flaglist.addAll(Arrays.asList(new String[]{"#", "$", "%", "@", "!"}));

        final ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,flaglist);
        falgsymbol.setAdapter(adap);

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getdataActivity.this,FrameddataActivity.class);
                intent.putExtra("flag",falgsymbol.getSelectedItem().toString());
                intent.putExtra("mes",etdata.getText().toString());
                intent.putExtra("binaryflag",cbshowbinary.isChecked());
                startActivity(intent);
            }
        });
    }
}