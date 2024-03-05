package tech.vodafone.githuprepoviewer.data.source.remote.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.vodafone.githuprepoviewer.data.source.remote.retrofit.adapters.NetworkResponseAdapterFactory
import java.util.concurrent.TimeUnit

/*
        val okHttpClient = OkHttpClient.Builder()

            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("type", "android")
                    .addHeader("Accept-Language", dataStore.appLanguage() ?: "en")
                    .addHeader("lang", dataStore.appLanguage() ?: "en")
                runBlocking {
                    newRequest.addHeader("Authorization", dataStore.getBearerToken() ?: "")
                }
                val mChain = chain.proceed(newRequest.build())

                if (mChain.code == 401) {
                    if (loginStatus) {
                        dataStore.logout()
                        val intent = Intent(
                            context,
                            SplashActivity::class.java
                        )
                        intent.flags =
                            Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        ContextCompat.startActivity(context, intent, null)
                    } else {
                        //TOOD:
                        // handle guest user
                    }
                }
                mChain
            }.build()


        return Retrofit.Builder()
            .client(okHttpClient)

 */
class RetrofitInstance() {
    private val retrofit: Retrofit by lazy {
//        val baseUrl = BuildConfig.BASE_URL
        Retrofit.Builder()
            .baseUrl("baseUrl")
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(cashAndLoggerManager())
            .build()
    }

    val api: CallApi by lazy {
        retrofit.create(CallApi::class.java)
    }

    private fun cashAndLoggerManager(): OkHttpClient {
        // Logging Retrofit
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
//            .addInterceptor{chain ->
//                val newRequest = chain.request().newBuilder()
//                    .addHeader("Accept", "application/json")
//                    .addHeader("Content-Type", "application/json")
//                    .addHeader("type", "android")
//                    .addHeader("Accept-Language",  "en")
//                val mChain = chain.proceed(newRequest.build())
//
//            }
            .build()
    }

}