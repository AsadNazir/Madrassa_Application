package com.example.madrassaapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewHistory extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<Student> SList;
    ArrayList<DailyTask> DList;
    RecyclerView.LayoutManager layoutManager;
    DBHandler Db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_history);

            recyclerView = findViewById(R.id.HistoryRecyclerView);

            //Getting Recycler View
            //Making Db Connection
            DBHandler Db = new DBHandler(this);

            //Getting the list
            SList=  Db.getAllStudents();

            //Getting the intent
            Intent I = getIntent();

            //getting Id
            int id = I.getIntExtra("id",-1);


            //throw an error
            if(id==-1) {
                Toast.makeText(this, "This is id is -1", Toast.LENGTH_LONG).show();
                throw new Exception();
            }

            //Getting history list
            DList = Db.getStudentRecord(id);

            //Throw an error
            if(DList==null) {
                Toast.makeText(this, "This is null list" + id, Toast.LENGTH_LONG).show();
                throw new Exception();
            }


            //Sir ka recycler view ka code samjh mei to wasa hi nhi aya but likh dia
            //---------------------------------------------------------
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(ViewHistory.this);

            recyclerView.setLayoutManager(layoutManager);

            adapter = new RecyclerHistoryView(DList) ;
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

        catch(Exception E)
        {
            E.printStackTrace();
        }

    }
}