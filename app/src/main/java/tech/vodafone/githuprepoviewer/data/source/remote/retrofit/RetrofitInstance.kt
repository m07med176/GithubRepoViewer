package tech.vodafone.githuprepoviewer.data.source.remote.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.vodafone.githuprepoviewer.BuildConfig
import tech.vodafone.githuprepoviewer.data.source.remote.retrofit.adapters.NetworkResponseAdapterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance{
    private const val TIMEOUT = 30L

    private val retrofit: Retrofit by lazy {
        // TODO i have Base url in Local properties for security issues and can be vary between debugging and releasing
        val baseUrl = BuildConfig.BASE_URL
        Retrofit.Builder()
            .baseUrl(baseUrl)
            // TODO i have added NetworkResponseAdapterFactory to custom handle response and its exceptions
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(interceptorManager())
            .build()
    }

    val api: CallApi by lazy {
        retrofit.create(CallApi::class.java)
    }

    private fun interceptorManager(): OkHttpClient {
        // Logging Retrofit
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            // TODO i have added Logging Interceptor to fetch status of calling api
            .addInterceptor(interceptor)
            // TODO i have added time out for reading , Connecting and writing
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor{chain ->
                // TODO i have added main header parameter for all api requests
                val newRequest = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("type", "android")
                    .addHeader("Accept-Language",  "en")
                chain.proceed(newRequest.build())
            }
            .build()
    }

}