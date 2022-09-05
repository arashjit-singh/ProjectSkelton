package com.example.projectskelton.data.repository

import androidx.room.Database
import com.example.projectskelton.data.database.MyDao
import com.example.projectskelton.data.remote.ApiService
import com.example.projectskelton.domain.model.RandomJokeModel
import com.example.projectskelton.domain.repository.MyRepository
import com.example.projectskelton.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val db: Database,
    private val dao: MyDao
) : MyRepository {
    override suspend fun getRandomJoke(fetchFromRemote: Boolean): Flow<Resource<RandomJokeModel>> {
        return flow {
            //start showing progress bar
            emit(Resource.Loading(true))
            //search for data in local db
            if (!fetchFromRemote) {
                emit(Resource.Loading(false))
                /*emit(
                    Resource.Success(
                        data = localJoke.toJokeModel()
                    )
                )*/
                return@flow
            }

            val randomJoke = try {
                api.getJokeCategories()
            } catch (e: IOException) {
                //eg something wrong with parsing
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                //eg like wrong URL
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            randomJoke?.let { joke ->
                //Insert joke in local db
//                dao.clearJokeDb()
                emit(Resource.Loading(false))
            }
        }


    }

}