package com.example.tiempopomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.tiempopomodoro.database.AppDatabase
import com.example.tiempopomodoro.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.recyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)

        binding.recyclerView.adapter = RegisterAdapter(
            db.RegisterDao().list(), this, db
        )

        binding.addRegisterButton.setOnClickListener {
            val createRegisterIntent = Intent(
                this, CreateRegisterActivity::class.java
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
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onResume() {
        super.onResume()

        val adapter = binding.recyclerView.adapter as RegisterAdapter

        adapter.registers = db.RegisterDao().list()

        adapter.notifyDataSetChanged()
    }
}