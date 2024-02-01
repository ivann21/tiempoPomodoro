package com.example.tiempopomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.tiempopomodoro.databinding.ActivityMainBinding
import com.example.tiempopomodoro.database.AppDatabase
import com.example.tiempopomodoro.model.Register

class CreateRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()


        binding.sendButton.setOnClickListener{
            val number = binding.numberRegisterEditText.text.toString()
            val nombre = binding.nameRegisterEditText.text.toString()
            val description = binding.descriptionRegisterEditText.text.toString()
            val tiempo = binding.editTextTime.text.toString()

            val register = Register(
                number = number,
                nombre = nombre,
                description = description,
                tiempo = tiempo
            )

            db
                .RegisterDao()
                .save(register)


            val createBookIntent = Intent(
                this, MainActivity::class.java
            )

            startActivity(createBookIntent)

        }
    }
}