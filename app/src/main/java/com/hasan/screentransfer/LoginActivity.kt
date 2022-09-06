package com.hasan.screentransfer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hasan.screentransfer.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var userName: String? = null
    private var password: String? = null
    private var sharedUserName: String? = null
    private var sharedPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createSharedPreferences()
    }

    fun login(view: View) {

        userName = binding.userNameInput.text?.toString()
        password = binding.passwordNameInput.text?.toString()

        if (userName == sharedUserName && password == sharedPassword && sharedUserName!!.isNotEmpty() && sharedPassword!!.isNotEmpty()) {
            Toast.makeText(
                this@LoginActivity,
                "Giriş Başarılı",
                Toast.LENGTH_LONG).show()
        } else if (userName!!.isEmpty() || password!!.isEmpty()) {
            Toast.makeText(
                this@LoginActivity,
                "Lütfen Alanları Doldurunuz",
                Toast.LENGTH_LONG)
                .show()
        } else if (userName != sharedUserName && password != sharedPassword) {
            Toast.makeText(
                this@LoginActivity,
                "Username veya Password Hatalı,Yeni Kullanıcı Oluşturunuz",
                Toast.LENGTH_LONG
            ).show()

        }
    }

    fun backButton1(view: View) {
        val intent = Intent(this@LoginActivity, GetStartedActivity::class.java)
        startActivity(intent)
    }

    fun newAccount(view: View) {
        val intent = Intent(this@LoginActivity, CreateActivity::class.java)
        startActivity(intent)
    }


    fun createSharedPreferences() {
        sharedPreferences = getSharedPreferences("SINGUP", Context.MODE_PRIVATE)
        sharedUserName = sharedPreferences.getString("USERNAME", "")
        sharedPassword = sharedPreferences.getString("PASSWORD", "")
    }
}