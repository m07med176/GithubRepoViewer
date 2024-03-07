package tech.vodafone.githuprepoviewer.data.source.local.worker

import android.annotation.SuppressLint
import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import tech.vodafone.githuprepoviewer.data.source.local.room.RoomDB

@HiltWorker
class RemoveCashWorker@AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted val params: WorkerParameters,
) :
    CoroutineWorker(context,params){
    @SuppressLint("RestrictedApi")
    override suspend fun doWork(): Result {

        if (!isStopped){
            RoomDB.invoke(context).cashDao().deleteCash()
        }

        return Result.Success()
    }
}