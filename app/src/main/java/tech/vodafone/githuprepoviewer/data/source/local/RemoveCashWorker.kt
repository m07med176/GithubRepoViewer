package tech.vodafone.githuprepoviewer.data.source.local

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import tech.vodafone.githuprepoviewer.data.source.local.room.RoomDB

class RemoveCashWorker(private val _context:Context,workerParams: WorkerParameters):
    CoroutineWorker(_context,workerParams){
    @SuppressLint("RestrictedApi")
    override suspend fun doWork(): Result {

        if (!isStopped){
            val differentTime = System.currentTimeMillis() - LocalConstant.MAX_AGE_MILLI
            RoomDB.invoke(_context).cashDao().deleteCash(differentTime)
        }

        return Result.Success()
    }
}