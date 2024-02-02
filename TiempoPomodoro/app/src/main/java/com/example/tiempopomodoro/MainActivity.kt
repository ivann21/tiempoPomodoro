package com.example.tiempopomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.tiempopomodoro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)



        binding.joinbutton.setOnClickListener{
            val createBookIntent = Intent(
                this, CreateRegisterActivity::class.java
            )

            startActivity(createBookIntent)
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
        }
        return super.onOptionsItemSelected(item)
    }

}