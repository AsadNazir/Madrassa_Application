package com.example.madrassaapplication;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {

    private final String createStudentsTable = "CREATE TABLE IF NOT EXISTS students (\n" +
            "    student_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    name TEXT,\n" +
            "    class INTEGER,\n" +
            "    age INTEGER\n" +
            ");";
    private static final String DATABASE_NAME = "students.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createStudentsTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + "students";
        db.execSQL(sql);
        onCreate(db);
    }


    public boolean insertNewStudent(String name, int studentClass, int age) {
        
        try {


            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("class", studentClass);
            values.put("age", age);

            db.insert("students", null, values);

            db.close();
        }
        catch(Exception E)
        {
            return false;
        }

        return true;
        
    }

    



};
