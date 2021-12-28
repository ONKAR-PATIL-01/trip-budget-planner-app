package com.example.tripplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

public class database extends AppCompatActivity {
    private DBHandler d;
    private TextView t11;
    StringBuffer sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        t11 = findViewById(R.id.tv11);
        d = new DBHandler(this);
        Cursor res = d.getall();

        if (res.getCount() == 0) {
            return;
        }
        sb = new StringBuffer();
        sb.append("***SPENDING CONTRIBUTION***");
        sb.append("\n");
        sb.append("\n");
        while (res.moveToNext()) {
            sb.append(res.getString(0)).append("\t  ");
            sb.append("-                 ->");
            sb.append(res.getString(1));


            sb.append("\n");
        }
        t11.setText(sb);


        res = d.getall();
        double sum = 0;
        int cc = res.getCount();
        if (res.getCount() == 0) {
            return;
        }
        sb = new StringBuffer();
        while (res.moveToNext()) {


            sum = sum + Integer.parseInt(res.getString(1));


        }
        sb.append("\n");
        sb.append("---------------------------------------------------\n");
        sb.append("\n");
        sb.append("TOTAL EXPENSES--------->" + sum);

        sb.append("\n");
        t11.append(sb);
       float equal = 0;
        if (cc != 0) {
             equal = (float) (sum / cc);
        }
        sb = new StringBuffer();
        sb.append("\n");
        sb.append("---------------------------------------------------\n");
        sb.append("\n");
        sb.append("EQUAL DISTRIBUTION--------->"+equal);
        sb.append("\n");
        sb.append("\n");
        sb.append("---------------------------------------------------\n");
        t11.append(sb);


         res = d.getall();

        if (res.getCount() == 0) {
            return;
        }
        sb = new StringBuffer();
        sb.append("\n");
        sb.append("\n");
        sb.append("***FINAL BUDGET AFTER EQUAL CONTRIBUTION***");
        sb.append("\n");
        sb.append("\n");
        while (res.moveToNext()) {
            sb.append(res.getString(0)).append("\t  ");
            sb.append("-                 ->");
            sb.append(equal-Integer.parseInt(res.getString(1)));


            sb.append("\n");
        }

        t11.append(sb);

    }
}