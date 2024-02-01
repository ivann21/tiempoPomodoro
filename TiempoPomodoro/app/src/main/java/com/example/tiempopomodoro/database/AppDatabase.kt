package com.example.tiempopomodoro.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tiempopomodoro.database.dao.RegisterDao
import com.example.tiempopomodoro.model.Register

@Database(entities = [Register::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "Task"
    }
    abstract fun RegisterDao(): RegisterDao


}