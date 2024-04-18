package com.example.assiment_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button Java;
    Button linux;
    Button data_structure;
    Button digital;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


//------------------------------------------------------------------
            Java=(Button)findViewById(R.id.button2);
            Intent intent=new Intent(MainActivity.this, Mainmathematics.class);
Java.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
startActivity(intent);
    }
});
//-------------------------------------------------------------------
        linux=(Button)findViewById(R.id.button3);
        Intent intent1=new Intent(MainActivity.this, Mainsciences.class);
        linux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
//----------------------------------------------------------------------
        data_structure=(Button)findViewById(R.id.button4);
        Intent intent2=new Intent(MainActivity.this, Mainchemistry.class);
        data_structure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
 //-----------------------------------------------------------------------
        digital=(Button)findViewById(R.id.button5);
        Intent intent3=new Intent(MainActivity.this, Mainphysics.class);
        digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });


    }
}
