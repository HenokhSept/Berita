package com.example.fp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
//import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnLogin = findViewById<AppCompatButton>(R.id.btnLogin)
        val btnLogin1 = findViewById<TextView>(R.id.btnlogin1)


        btnBack.setOnClickListener{
            intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnLogin1.setOnClickListener{
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}