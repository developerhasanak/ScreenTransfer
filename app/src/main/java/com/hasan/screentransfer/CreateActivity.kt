package com.hasan.screentransfer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hasan.screentransfer.databinding.ActivityCreateBinding

class CreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var emailAddress: String
    private lateinit var userName: String
    private lateinit var password: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createSharedPreferences()
    }

    fun backButton2(view: View) {
        val intent = Intent(this@CreateActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    fun signUp(view: View) {
        emailAddress = binding.emailInput.text.toString()
        userName = binding.userNameInput.text.toString()
        password = binding.passwordInput.text.toString()

        if (emailAddress.isNotEmpty() && userName.isNotEmpty() && password.isNotEmpty()) {
            sharedPreferences.edit().putString("EMAIL", emailAddress).apply()
            sharedPreferences.edit().putString("USERNAME", userName).apply()
            sharedPreferences.edit().putString("PASSWORD", password).apply()

            Toast.makeText(
                this@CreateActivity,
                "Kullanıcı Oluşturuldu\n\nEmail:$emailAddress,\nUsername:$userName,\nPassword:$password",
                Toast.LENGTH_LONG
            ).show()
            val intent = Intent(this@CreateActivity, LoginActivity::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

            binding.userNameInput.text?.clear()
            binding.emailInput.text?.clear()
            binding.passwordInput.text?.clear()

        } else if(emailAddress.isEmpty()) {
            Toast.makeText(this,
                "Lütfen Email Adresinizi Girin!",
                Toast.LENGTH_SHORT).show()
        }else if(userName.isEmpty()){
            Toast.makeText(this,
                "Lütfen Kullanıcı Adınızı Girin!",
                Toast.LENGTH_SHORT).show()
        }else if(password.isEmpty()){
            Toast.makeText(this,
                "Lütfen Şifrenizi Girin!",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun createSharedPreferences() {
        sharedPreferences = this.getSharedPreferences("SINGUP", Context.MODE_PRIVATE)
    }
}
