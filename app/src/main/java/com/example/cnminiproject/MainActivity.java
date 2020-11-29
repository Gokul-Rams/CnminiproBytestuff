package com.example.cnminiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvcontent1,tvcontent2,tvmembers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Byte Stuffing in Framing");

        tvcontent1 = findViewById(R.id.tvcontent1);
        tvcontent2 = findViewById(R.id.tvcontent2);
        tvmembers = findViewById(R.id.tvmembers);

        String temp="Purpose of Byte Stuffing\n" +
                "\n" +
                "In Data Link layer, the stream of bits from physical layer are divided into data frames. The data frames can be of fixed length or variable length. In variable – length framing, the size of each frame to be transmitted may be different. So, a pattern of bits is used as a delimiter to mark the end of one frame and the beginning of the next frame. However, if the pattern occurs in the message, then mechanisms needs to be incorporated so that this situation is avoided.\n" +
                "\n" +
                "The two common approaches are −\n" +
                "\n" +
                "    Byte – Stuffing − A byte is stuffed in the message to differentiate from the delimiter. This is also called character-oriented framing.\n" +
                "\n" +
                "    Bit – Stuffing − A pattern of bits of arbitrary length is stuffed in the message to differentiate from the delimiter. This is also called bit – oriented framing.\n" +
                "\n" +
                "Frame in a Character – Oriented Framing\n" +
                "\n" +
                "In character – oriented protocols, the message is coded as 8-bit characters, using codes like ASCII codes.\n" +
                "\n" +
                "A frame has the following parts −\n" +
                "\n" +
                "    Frame Header − It contains the source and the destination addresses of the frame.\n" +
                "\n" +
                "    Payload field − It contains the message to be delivered.\n" +
                "\n" +
                "    Trailer − It contains the error detection and error correction bits.\n" +
                "\n" +
                "    Flags − 1- byte (8-bits) flag at the beginning and at end of the frame. It is a protocol – dependent special character, signalling the start and end of the frame.";
        tvcontent1.setText(temp);

        temp="Byte Stuffing Mechanism\n" +
                "\n" +
                "If the pattern of the flag byte is present in the message byte, there should be a strategy so that the receiver does not consider the pattern as the end of the frame. In character – oriented protocol, the mechanism adopted is byte stuffing.\n" +
                "\n" +
                "In byte stuffing, a special byte called the escape character (ESC) is stuffed before every byte in the message with the same pattern as the flag byte. If the ESC sequence is found in the message byte, then another ESC byte is stuffed before it.";
        tvcontent2.setText(temp);

        temp = "ErajaGanapathi\n" +
                "Akshy Kumar Bhiva Mota\n" +
                "Arwin prakadis R S\n" +
                "Gokul S\n" +
                "Gokul R";

        tvmembers.setText(temp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.openstuffbytemenu){
            Intent intent = new Intent(MainActivity.this,getdataActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}