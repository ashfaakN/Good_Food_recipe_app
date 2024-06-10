package com.example.goodfoodrecipeapp

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.SharedPreferences
import android.widget.EditText

class activity_login : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)

        val signInButton: Button = findViewById(R.id.buttonSignIn)
        signInButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.editTextName).text.toString()
            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
            val password = findViewById<EditText>(R.id.editTextPassword).text.toString()


            val editor = sharedPreferences.edit()
            editor.putString("USER_NAME", name)
            editor.putString("USER_EMAIL", email)
            editor.putString("USER_PASSWORD", password)
            editor.apply()

            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }
    }
}