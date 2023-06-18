package com.example.madrassaapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.madrassaapplication.R.id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ViewStudentActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Student> Slist = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        try {

        setContentView(R.layout.activity_view_student);

//        //recyclerView = findViewById(R.id.StudentViewRecycler);
//        Student S1 = new Student("Asad", 6,18);
//        Student S2 = new Student("Asad2", 7,18);
//        Student S3 = new Student("Asad3", 7,18);
//        Student S4 = new Student("Asad4", 4,18);
//
//        Slist.addAll(Arrays.asList(new Student[]{S1,S2,S3,S4,S4,S1,S2,S3,S4,S1,S2,S3,S1,S1,S1}));

            DBHandler Db = new DBHandler(this);
            Slist=Db.getAllStudents();


            recyclerView = findViewById(R.id.StudentViewRecycler);


            recyclerView.setHasFixedSize(true);

            //LinearLayoutManager GridLayoutManager
            layoutManager = new LinearLayoutManager(ViewStudentActivity.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new RecyclerStudentView(Slist) ;
            recyclerView.setAdapter(adapter);

        }
        catch (Exception E)
        {
            E.printStackTrace();
        }




    }
}