package com.example.goodfoodrecipeapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class activity_profile : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("USER_NAME", "")
        val email = sharedPreferences.getString("USER_EMAIL", "")
        val password = sharedPreferences.getString("USER_PASSWORD", "")

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val emailTextView: TextView = findViewById(R.id.emailTextView)
        val passwordTextView: TextView = findViewById(R.id.passwordTextView)

        nameTextView.text = "Name: $name"
        emailTextView.text = "Email: $email"
        passwordTextView.text = "Password: $password"

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}
