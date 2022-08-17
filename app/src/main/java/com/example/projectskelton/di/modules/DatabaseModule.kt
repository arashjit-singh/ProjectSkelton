package com.example.projectskelton.di.modules

import android.content.Context
import androidx.room.Room
import com.example.projectskelton.data.database.MyRoomDatabase
import com.example.projectskelton.domain.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseBuilder(@ApplicationContext context: Context): MyRoomDatabase {
        return Room.databaseBuilder(
            context, MyRoomDatabase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    /* @Singleton
     @Provides
     fun provideJokeDao(db: MyRoomDatabase): JokeDao {
         return db.provideRandomDao()
     }*/


}