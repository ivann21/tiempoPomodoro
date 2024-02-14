package com.example.tiempopomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.room.Room
import com.example.tiempopomodoro.database.AppDatabase
import com.example.tiempopomodoro.databinding.ActivityEditRegisterBinding
import com.example.tiempopomodoro.model.Register

class editRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditRegisterBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)

        db = Room.databaseBuilder(this, AppDatabase::class.java, AppDatabase.DATABASE_NAME).allowMainThreadQueries().build()
        val number = intent.getStringExtra("number")
        val register = db.RegisterDao().getRegisterByNumber(number)
        if (register != null) {
            val editTextNumber = binding.numberRegisterEditText2
            val editTextNombre = binding.nameRegisterEditText2
            val editTextDescripcion = binding.descriptionRegisterEditText2
            val editTextTiempo = binding.editTextTime2

            editTextNumber.setText(register.number)
            editTextNombre.setText(register.nombre)
            editTextDescripcion.setText(register.description)
            editTextTiempo.setText(register.tiempo)
        }
        binding.editButton.setOnClickListener {
            val number = binding.numberRegisterEditText2.text.toString()
            val nombre = binding.nameRegisterEditText2.text.toString()
            val descripcion = binding.descriptionRegisterEditText2.text.toString()
            val tiempo = binding.editTextTime2.text.toString()

            val register = Register(number, nombre, descripcion, tiempo)
            db.RegisterDao().update(register)

            val createRegisterIntent = Intent(
                this, RegisterActivity::class.java
            )

            startActivity(createRegisterIntent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.añadirMenuItem -> {
                val intent = Intent(
                    this, CreateRegisterActivity::class.java
                )
                startActivity(intent)
            }
            R.id.inicioMenuItem -> {
                val intent = Intent(
                    this, MainActivity::class.java
                )
                startActivity(intent)
            }
            R.id.viewMenuItem -> {
                val intent = Intent(
                    this, RegisterActivity::class.java
                )
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}