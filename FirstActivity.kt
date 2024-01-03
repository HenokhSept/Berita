package com.example.fp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btnLogin = findViewById<AppCompatButton>(R.id.btnLogin)
        val btnRegister = findViewById<AppCompatButton>(R.id.btnRegister)

        btnLogin.setOnClickListener{
             intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnRegister.setOnClickListener{
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}