package com.example.projectskelton.domain.repository

import com.example.projectskelton.domain.model.RandomJokeModel
import com.example.projectskelton.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface MyRepository {
    suspend fun getRandomJoke(fetchFromRemote: Boolean): Flow<Resource<RandomJokeModel>>
}