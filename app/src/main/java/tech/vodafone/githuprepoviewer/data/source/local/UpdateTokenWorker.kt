package tech.vodafone.githuprepoviewer.data.source.local

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class UpdateTokenWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val newToken = inputData.getString("WorkerConstants.FCM_TOKEN")
//        val bearerToken = inputData.getString(WorkerConstants.BEARER_TOKEN)
        return try {
            newToken?.let {
//                provideRetrofitClient(context = applicationContext).updateFcmToken(
//                    bearerToken ?: "",
//                    hashMapOf("device_token" to newToken, "type" to "android")
//                )
                Result.success()
            } ?: Result.failure()
        } catch (e: Exception) {
            Result.failure()
        }
    }

}