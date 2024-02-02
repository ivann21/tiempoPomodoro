package com.example.tiempopomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.tiempopomodoro.database.AppDatabase
import com.example.tiempopomodoro.databinding.ActivityRegisterCreateBinding
import com.example.tiempopomodoro.model.Register

class CreateRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterCreateBinding

    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_create)
        binding = ActivityRegisterCreateBinding.inflate(layoutInflater)
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
                this, RegisterActivity::class.java
            )

            startActivity(createBookIntent)

        }
    }
}