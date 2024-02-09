package com.example.tiempopomodoro.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tiempopomodoro.model.Register
@Dao
interface RegisterDao {
    @Query("SELECT * FROM register")
    fun list(): List<Register>

    @Query("DELETE FROM register WHERE number=:number")
    fun delete(number: String): Int

    @Query("SELECT * FROM register WHERE number=:number")
    fun getRegisterByNumber(number: String?): Register?
    @Insert
    fun save(register: Register)
}