package com.example.tripplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText t1,t2;
    private Button b1,b2;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.tv1);
        t2=findViewById(R.id.tv2);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        dbHandler = new DBHandler(MainActivity.this);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,database.class));
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.addNewCourse(t1.getText().toString(), Integer.valueOf(t2.getText().toString()));
                t1.setText(null);
                t2.setText(null);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        dbHandler.fresh_table();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHandler.fresh_table();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dbHandler.fresh_table();
    }
}