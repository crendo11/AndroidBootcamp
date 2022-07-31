package com.example.imdb_project.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val email: String,
    val name: String,
    val lastname: String,
    val password: String,
)
