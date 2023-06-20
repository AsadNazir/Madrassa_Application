package com.example.madrassaapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class ViewHistory extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DailyTask> Dlist;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_history);

            //Sir ka recycler view ka code samjh mei to wasa hi nhi aya but likh dia
            //---------------------------------------------------------
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(ViewHistory.this);

            recyclerView.setLayoutManager(layoutManager);

            adapter = new RecyclerHistoryView(Dlist) ;
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

        catch(Exception E)
        {
            E.printStackTrace();
        }

    }
}