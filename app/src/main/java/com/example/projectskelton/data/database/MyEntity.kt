package com.example.projectskelton.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyEntityTable")
class MyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int
) {
}