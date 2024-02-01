package com.example.tiempopomodoro.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "register")
data class Register(
    @PrimaryKey val number: String,
    @ColumnInfo("nombre") val nombre: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("tiempo") val tiempo: String
)
