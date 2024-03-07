package tech.vodafone.githuprepoviewer.data.source.remote.retrofit.adapters

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import tech.vodafone.githuprepoviewer.domain.utils.NetworkResponse
import java.lang.reflect.Type

class NetworkResponseAdapter<S : Any, E : Any>(
    private val successType: Type,
    private val errorBodyConverter: Converter<ResponseBody, E>
) : CallAdapter<S, Call<NetworkResponse<S, E>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<S>): Call<NetworkResponse<S, E>> {
        return NetworkResponseCall(call, errorBodyConverter)
    }
}
