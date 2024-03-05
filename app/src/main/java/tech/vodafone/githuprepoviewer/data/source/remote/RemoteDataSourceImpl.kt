package tech.vodafone.githuprepoviewer.data.source.remote

import retrofit2.Response
import tech.vodafone.githuprepoviewer.data.source.remote.retrofit.CallApi

class RemoteDataSourceImpl(
    private val api: CallApi
) : RemoteDataSource {
    override suspend fun getWeatherDetails(cityName: String): Response<Any> {
        TODO("Not yet implemented")
    }


}