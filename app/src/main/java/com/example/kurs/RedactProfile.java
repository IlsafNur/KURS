package com.example.kurs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RedactProfile extends AppCompatActivity {

    private EditText aboutMeEditText, ageEditText, cityEditText, workEditText, phoneEditText, emailEditText;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redact_profile);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        aboutMeEditText = findViewById(R.id.about_me);
        ageEditText = findViewById(R.id.age);
        cityEditText = findViewById(R.id.city);
        workEditText = findViewById(R.id.work);
        phoneEditText = findViewById(R.id.phone);
        emailEditText = findViewById(R.id.email);

        Button saveButton = findViewById(R.id.login_btn);
        saveButton.setOnClickListener(v -> {
            String aboutMe = aboutMeEditText.getText().toString();
            int age = Integer.parseInt(ageEditText.getText().toString());
            String city = cityEditText.getText().toString();
            String work = workEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            String email = emailEditText.getText().toString();

            // Сохранение данных в Firebase
            databaseReference.child("about_me").setValue(aboutMe);
            databaseReference.child("age").setValue(age);
            databaseReference.child("city").setValue(city);
            databaseReference.child("work").setValue(work);
            databaseReference.child("phone").setValue(phone);
            databaseReference.child("email").setValue(email);

            Intent intent = new Intent(RedactProfile.this, Profile.class);
            startActivity(intent);
        });

        Button exitButton = findViewById(R.id.exit);
        exitButton.setOnClickListener(v -> {
            Intent intent = new Intent(RedactProfile.this, Profile.class);
            startActivity(intent);
        });
    }
}