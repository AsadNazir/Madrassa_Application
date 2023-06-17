package com.example.madrassaapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerStudentView extends RecyclerView.Adapter<RecyclerStudentView.MyVH> {

    List<Student> SList;
     public RecyclerStudentView (List<Student> l)
    {
        SList=l;
    }


    @NonNull
    @Override
    public RecyclerStudentView.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_single_item, parent,false);

        final MyVH viewHolder = new MyVH(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    // Retrieve the clicked item from the list
                    //Friends clickedFriend = friendsList.get(position);

                    // Perform your desired action here
                    Toast.makeText(view.getContext(), "Clicked: " + position, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
            holder.S=SList.get(position);

            Integer.toString(holder.S.getStudentClass());
            holder.Class.setText(Integer.toString(holder.S.getStudentClass()));
            holder.name.setText(holder.S.getName());
            holder.age.setText(Integer.toString(holder.S.getAge()));

    }



    @Override
    public int getItemCount() {
        return SList.size();
    }


    //This is my ViewHolder
    public class MyVH extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView Class;
        TextView age;
        int id;
        Student S;


        public MyVH(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.textViewFriendName);
            Class = itemView.findViewById(R.id.textViewClass);
            age=itemView.findViewById(R.id.textViewAge);
        }
    }

};
