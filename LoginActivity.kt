package com.example.fp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.lazday.kotlinroommvvm.activity.Main


//batas
//import com.example.fp.api.BaseRetrofit
//import com.example.fp.response.login.LoginResponse
//import com.example.fp.utils.SessionManager
//import com.google.android.material.textfield.TextInputEditText
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//batas

class LoginActivity : AppCompatActivity() {
//    companion object{
//        lateinit var sessionManager: SessionManager
//        private lateinit var context: Context
//    }
//
//    private val api by lazy { BaseRetrofit().endPoint }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnLogin = findViewById<AppCompatButton>(R.id.btnLogin)
        val btnRegister = findViewById<TextView>(R.id.btnRegister)

        btnBack.setOnClickListener{
            intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            intent = Intent(this, Main::class.java)
            startActivity(intent)
        }

        btnRegister.setOnClickListener{
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

//batas

//        sessionManager = SessionManager(this)
//        val loginStatus = sessionManager.getBoolean("LOGIN_STATUS")
//        if (loginStatus){
//            val moveIntent = Intent(this@LoginActivity,MainActivity::class.java)
//            startActivity(moveIntent)
//            finish()
//        }
//
//        val btnLogin = findViewById(R.id.btnLogin) as AppCompatButton
//        val txtEmail = findViewById(R.id.txtEmail) as EditText
//        val txtPassword = findViewById(R.id.txtPassword) as EditText
//
//        btnLogin.setOnClickListener{
//
//            api.login(txtEmail.text.toString(),txtPassword.text.toString()).enqueue(object :
//                Callback<LoginResponse> {
//                override fun onResponse(
//                    call: Call<LoginResponse>,
//                    response: Response<LoginResponse>
//                ) {
//                    Log.e("LoginData",response.toString())
//                    val correct = response.body()!!.success
//
//                    if(correct){
//                        val token = response.body()!!.data.token
//
//                        sessionManager.saveString("TOKEN","Bearer"+token)
//                        sessionManager.saveBoolean("LOGIN_STATUS",true)
//
//                        val moveIntent = Intent(this@LoginActivity,MainActivity::class.java)
//                        startActivity(moveIntent)
//                        finish()
//
//                    }else{
//                        Toast.makeText(applicationContext, "User dan Password salah",Toast.LENGTH_LONG).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                    Log.e("LoginError",t.toString())
//                }
//
//            })
//        }

        //batas
    }
}