package com.example.firebase;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

//import com.google.firebase.database.core.Context;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> studentList;
    String Choice;
    Context context;

    public StudentAdapter(List<Student> studentList, String Choice) {

        this.studentList = studentList;
        this.Choice = Choice;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_admin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        if(Choice.equals("Student")){
            holder.snameTextView.setText(student.getName());
            holder.hostelTextView.setText(student.getHostel());
            holder.roomTextView.setText(student.getRoom());
        }
        if(Choice.equals("Employee")){
            holder.snameTextView.setText(student.getEName());
            holder.hostelTextView.setText(student.geteHostel());
            holder.roomTextView.setText(student.geteType());
        }



    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView snameTextView, hostelTextView, roomTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            snameTextView = itemView.findViewById(R.id.studname);
            hostelTextView = itemView.findViewById(R.id.hostel);
            roomTextView = itemView.findViewById(R.id.Roomno);
        }
    }
}
