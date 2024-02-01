package com.example.tiempopomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiempopomodoro.databinding.ActivityMain2Binding

class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.joinbutton.setOnClickListener{
            val createBookIntent = Intent(
                this, CreateRegisterActivity::class.java
            )

            startActivity(createBookIntent)
        }


    }

}