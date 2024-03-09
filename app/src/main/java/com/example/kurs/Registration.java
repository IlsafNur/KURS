package com.example.kurs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registration extends AppCompatActivity {

    private EditText emailEditText, loginEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        emailEditText = findViewById(R.id.email_et);
        loginEditText = findViewById(R.id.login_et);
        passwordEditText = findViewById(R.id.pass_et);

        Button registerButton = findViewById(R.id.login_btn);
        registerButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String login = loginEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Здесь можно добавить логику проверки данных и их сохранения

            // После успешной регистрации можно совершить переход на другую активность
            Intent intent = new Intent(Registration.this, MainActivity.class);
            startActivity(intent);
        });

        TextView redirectLogin = findViewById(R.id.go_to_register);
        redirectLogin.setOnClickListener(v -> {
            Intent intent = new Intent(Registration.this, Authorization.class);
            startActivity(intent);
        });
    }
}