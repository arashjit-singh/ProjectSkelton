package com.example.projectskelton.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyEntity::class], version = 1)
abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun provideDao(): MyDao
}