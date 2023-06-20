package com.example.madrassaapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

public class RecyclerHistoryView extends RecyclerView.Adapter<RecyclerHistoryView.MyVH> {

    List<DailyTask> DList;
    public RecyclerHistoryView (List<DailyTask> l)
    {
        DList=l;
    }


    @NonNull
    @Override
    public RecyclerHistoryView.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_single_item, parent,false);

        final MyVH viewHolder = new MyVH(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.D=DList.get(position);

        holder.Sabqi.setText(Integer.toString(holder.D.getSabaqi()));
        holder.Manzil.setText(Integer.toString(holder.D.getMazil()));
        holder.Para.setText(Integer.toString(holder.D.getPara()));
        holder.StartingVerse.setText(Integer.toString(holder.D.getStartingVerse()));
        holder.Endingverse.setText(Integer.toString(holder.D.getEndingVerse()));
        holder.date.setText(holder.D.getD().toString());
    }



    @Override
    public int getItemCount() {
        return DList.size();
    }


    //This is my ViewHolder
    public class MyVH extends RecyclerView.ViewHolder
    {
        TextView Para;
        TextView StartingVerse, Endingverse, Surah;
        TextView Sabqi;
        TextView Manzil;
        TextView date;
        Button EnterStudentRecord, ViewStudentRecord;
        int id;
        DailyTask D;


        public MyVH(@NonNull View itemView) {
            super(itemView);

            Para = itemView.findViewById(R.id.textViewParaNo);
            StartingVerse=itemView.findViewById(R.id.textViewStartingVerse);
            Endingverse=itemView.findViewById(R.id.textViewEndingVerse);
            Sabqi=itemView.findViewById(R.id.textViewSabqiParaNo);
            Manzil=itemView.findViewById(R.id.textViewManzilParaNo);
            date=itemView.findViewById(R.id.textViewDate);

        }
    }

};
