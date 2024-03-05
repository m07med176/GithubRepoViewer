package tech.vodafone.githuprepoviewer.data.source.remote

import retrofit2.Response

interface RemoteDataSource{
    suspend fun getWeatherDetails(
        cityName: String,
    ): Response<Any>


}