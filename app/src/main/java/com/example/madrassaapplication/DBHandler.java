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


    //getting all students
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query("students", null, null, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                int studentIdIndex = cursor.getColumnIndex("student_id");
                int nameIndex = cursor.getColumnIndex("name");
                int classIndex = cursor.getColumnIndex("class");
                int ageIndex = cursor.getColumnIndex("age");

                do {
                    int studentId = cursor.getInt(studentIdIndex);
                    String name = cursor.getString(nameIndex);
                    int studentClass = cursor.getInt(classIndex);
                    int age = cursor.getInt(ageIndex);

                    Student student = new Student(name, studentClass,studentId, age);
                    studentList.add(student);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return studentList;
    }



    //getting students by name
    public ArrayList<Student> getStudentByName(String name) {
        ArrayList<Student> matchingStudents = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            String selection = "name=?";
            String[] selectionArgs = {name};

            cursor = db.query("students", null, selection, selectionArgs, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                int studentIdIndex = cursor.getColumnIndex("student_id");
                int nameIndex = cursor.getColumnIndex("name");
                int classIndex = cursor.getColumnIndex("class");
                int ageIndex = cursor.getColumnIndex("age");

                do {
                    int studentId = cursor.getInt(studentIdIndex);
                    String studentName = cursor.getString(nameIndex);
                    int studentClass = cursor.getInt(classIndex);
                    int age = cursor.getInt(ageIndex);

                    Student student = new Student(name, studentClass,studentId, age);
                    matchingStudents.add(student);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return matchingStudents;
    }





};
