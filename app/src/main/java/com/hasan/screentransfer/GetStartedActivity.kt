package com.hasan.screentransfer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hasan.screentransfer.databinding.ActivityGetstartedBinding

class GetStartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetstartedBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetstartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createSharedPreferences()
    }

    fun joinNowClick(view: View) {
        val intent = Intent(this@GetStartedActivity, LoginActivity::class.java)
        startActivity(intent)
    }


    private fun createSharedPreferences(){
        sharedPreferences = this.getSharedPreferences("SINGUP", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("EMAIL","hasan@gmail").apply()
        sharedPreferences.edit().putString("USERNAME","hasan").apply()
        sharedPreferences.edit().putString("PASSWORD","123456").apply()


    }

}