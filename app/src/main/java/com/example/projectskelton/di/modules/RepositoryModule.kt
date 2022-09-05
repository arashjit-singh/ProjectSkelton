package com.example.projectskelton.di.modules

import com.example.projectskelton.data.repository.MyRepositoryImpl
import com.example.projectskelton.domain.repository.MyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: MyRepositoryImpl
    ): MyRepository

}