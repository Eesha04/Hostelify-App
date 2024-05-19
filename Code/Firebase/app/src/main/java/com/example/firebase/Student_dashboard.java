package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Student_dashboard extends AppCompatActivity {

    ImageView attend,mess,laund,night,issue;
    ImageView bars;
    private RelativeLayout popupLayout;
    Button admin,notice,logout,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        bars = findViewById(R.id.three_bars);
        popupLayout = findViewById(R.id.popupLayout);
        admin = findViewById(R.id.navigateToPage1Button);
        notice = findViewById(R.id.navigateToPage2Button);
        logout = findViewById(R.id.logout);
        back = findViewById(R.id.back);

        attend = findViewById(R.id.attendance);
        mess   = findViewById(R.id.mess);
        laund  = findViewById(R.id.Laundry);
        night  = findViewById(R.id.night);
        issue  = findViewById(R.id.issue);

        String Email = getIntent().getStringExtra("Email");
        String Password = getIntent().getStringExtra("Password");
        Toast.makeText(Student_dashboard.this, "Email ,"+Email+" and Pass , "+Password, Toast.LENGTH_LONG).show();


        bars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupLayout.getVisibility() == View.VISIBLE) {
                    popupLayout.setVisibility(View.GONE); // Close the popup
                } else {
                    popupLayout.setVisibility(View.VISIBLE); // Open the popup
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupLayout.setVisibility(View.GONE);

            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Start.class);
                startActivity(i);
                finish();
            }
        });

        //---------------------------------------------------------------------------------------------------


        attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Stud_ViewAttendance.class);
                i.putExtra("Email",Email);
                i.putExtra("Password",Password);
                startActivity(i);
                finish();
            }
        });

        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), StudMess_dashboard.class);
                i.putExtra("Email",Email);
                i.putExtra("Password",Password);
                startActivity(i);
                finish();
            }
        });

        laund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Add_Laundry.class);
                i.putExtra("Email",Email);
                i.putExtra("Password",Password);
                startActivity(i);
                finish();
            }
        });

        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Add_Nightout.class);
                i.putExtra("Email",Email);
                i.putExtra("Password",Password);
                startActivity(i);
                finish();
            }
        });

        issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),add_issue.class);
                i.putExtra("Email",Email);
                i.putExtra("Password",Password);
                startActivity(i);
                finish();
            }
        });



    }
}