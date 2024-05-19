package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class View_Student extends AppCompatActivity {

    TextView sname,hostel,room;
    Button view_stud_profile;
    DatabaseReference rootDB;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_stud_for_admin);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rootDB = FirebaseDatabase.getInstance().getReference();
        String choice = getIntent().getStringExtra("Choice");


        if(choice.equals("View_Student")) {
            List<Student> studentList = new ArrayList<>(); // Populate this list with student data

            studentAdapter = new StudentAdapter(studentList,"Student");
            recyclerView.setAdapter(studentAdapter);

            rootDB.child("Student").addValueEventListener(new ValueEventListener() {
                //     addListenerForSingleValueEvent
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    studentList.clear(); // Clear the list before adding new data
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {


                        String name = userSnapshot.child("sname").getValue(String.class);

                        String room = userSnapshot.child("room").getValue(String.class);
                        String hostel = userSnapshot.child("hostel").getValue(String.class);
                        studentList.add(new Student(name, room, hostel, null, null, null));
                    }
                    studentAdapter.notifyDataSetChanged(); // Notify the adapter that the data has changed
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle errors
                }

            });

        }

        if(choice.equals("View_Employees")){

            List<Student> studentList = new ArrayList<>(); // Populate this list with student data

            studentAdapter = new StudentAdapter(studentList,"Employee");
            recyclerView.setAdapter(studentAdapter);
            int i=0,j=0;


            rootDB.child("Employees").addValueEventListener(new ValueEventListener() {
                //     addListenerForSingleValueEvent
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String H[] = {"H1","H2","H3","H4"};
                    String T[] = {"Mess","Security","Warden"};
                    studentList.clear(); // Clear the list before adding new data

                    for (String h : H) {
                        for (String t : T) {
                            DataSnapshot userSnapshot = dataSnapshot.child(h).child(t);
                            if (userSnapshot.child("ename").exists()) {
                                String ename = userSnapshot.child("ename").getValue(String.class);
                                String ehostel = h;
                                String type = t;
                                studentList.add(new Student(null, null, null, ename, ehostel, type));
//                                break;
                            }
                        }
                    }

//                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
//                        String ename = userSnapshot.child("ename").getValue(String.class);
//                        String etype = userSnapshot.getRef().getParent().getKey();
//                        String ehostel = userSnapshot.getRef().getParent().getKey();
//
//                        studentList.add(new Student(null, null, null,ename,ehostel, etype ));
//                    }

                    studentAdapter.notifyDataSetChanged(); // Notify the adapter that the data has changed
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle errors
                }

            });


        }

    }
}