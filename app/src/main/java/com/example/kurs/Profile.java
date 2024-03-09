package com.example.kurs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {
    private TextView aboutMeTextView, ageTextView, cityTextView, workTextView, phoneTextView, emailTextView;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        aboutMeTextView = findViewById(R.id.me);
        ageTextView = findViewById(R.id.age);
        cityTextView = findViewById(R.id.city);
        workTextView = findViewById(R.id.work);
        phoneTextView = findViewById(R.id.phone);
        emailTextView = findViewById(R.id.email);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String aboutMe = dataSnapshot.child("me").getValue(String.class);
                int age = dataSnapshot.child("age").getValue(Integer.class);
                String city = dataSnapshot.child("city").getValue(String.class);
                String work = dataSnapshot.child("work").getValue(String.class);
                String phone = dataSnapshot.child("phone").getValue(String.class);
                String email = dataSnapshot.child("email").getValue(String.class);

                aboutMeTextView.setText(aboutMe);
                ageTextView.setText(String.valueOf(age));
                cityTextView.setText(city);
                workTextView.setText(work);
                phoneTextView.setText(phone);
                emailTextView.setText(email);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Обработка ошибок
            }
        });
    }
}