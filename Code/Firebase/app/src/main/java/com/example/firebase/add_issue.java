package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class add_issue extends AppCompatActivity {

    EditText issue;
    Button post;
    private DatabaseReference rootDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_issue);


        String Email = getIntent().getStringExtra("Email");
        String Password = getIntent().getStringExtra("Password");
        Toast.makeText(add_issue.this, "Email ,"+Email+" and Pass , "+Password, Toast.LENGTH_LONG).show();

        issue = findViewById(R.id.issue_text);
        post = findViewById(R.id.postbutton);
        rootDB = FirebaseDatabase.getInstance().getReference();

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Issue = String.valueOf(issue.getText());


                rootDB.child("Student").addValueEventListener(new ValueEventListener() {
                    //     addListenerForSingleValueEvent
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        boolean isLoginValid = false;
                        String Name =" ";
                        String Room = " ";
                        String Hostel = " ";
                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            String savedEmail = userSnapshot.child("semail").getValue(String.class);
                            String savedPassword = userSnapshot.child("spass").getValue(String.class);
                            if (savedEmail != null && savedPassword != null
                                    && savedEmail.equals(Email) && savedPassword.equals(Password)) {

                                        Name = userSnapshot.child("sname").getValue(String.class);
                                        Room = userSnapshot.child("room").getValue(String.class);
                                        Hostel = userSnapshot.child("hostel").getValue(String.class);

                                isLoginValid = true;
                                break;
                            }
                        }


                        if (isLoginValid) {

                            String issuekey = rootDB.child("Issues").push().getKey();
                            DatabaseReference issueRef = rootDB.child("Issues").child(issuekey);

                            issueRef.child("sname").setValue(Name);
                            issueRef.child("sroom").setValue(Room);
                            issueRef.child("shostel").setValue(Hostel);
                            issueRef.child("sissue").setValue(Issue);


                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(add_issue.this, "Complaint Registered.",
                                    Toast.LENGTH_SHORT).show();

                            Intent in = new Intent(getApplicationContext(), Student_dashboard.class);
                            in.putExtra("Email",Email);
                            in.putExtra("Password",Password);
                            startActivity(in);
                            finish();




                        } else {
                            Toast.makeText(add_issue.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                        }

                    }

                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        //Log.w(TAG, "Failed to read value.", error.toException());

                        Toast.makeText(add_issue.this, "Database error occurred", Toast.LENGTH_SHORT).show();
                    }
                });






            }
        });


    }
}