package com.example.tripplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "MYDATABASE";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "trip";



    private static final String NAME_COL = "name";


    private static final String AMOUNT_COL = "amount";



    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
               + NAME_COL + " TEXT,"
                + AMOUNT_COL + " INTEGERr)";
        db.execSQL(query);
    }

    public void addNewCourse(String Name, Integer AMOUNT) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, Name);
        values.put(AMOUNT_COL, AMOUNT);


        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void fresh_table ()
    {
        SQLiteDatabase db=this.getWritableDatabase();
       db.delete(TABLE_NAME,null,null);
        db.close();
    }
    public Cursor getall()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res =db.rawQuery(" select * from "+TABLE_NAME,null);
        return res;


    }


}
