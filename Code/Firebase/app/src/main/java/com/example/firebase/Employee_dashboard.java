package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.os.Bundle;

public class Employee_dashboard extends AppCompatActivity {
    ImageView warden,security,mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        warden   = findViewById(R.id.Warden);
        security = findViewById(R.id.Security);
        mess     = findViewById(R.id.Mess);

        warden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Login_warden.class);
                startActivity(i);
                finish();

            }
        });

        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Login_security.class);
                startActivity(i);
                finish();

            }
        });

        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Login_mess.class);
                startActivity(i);
                finish();

            }
        });

    }
}