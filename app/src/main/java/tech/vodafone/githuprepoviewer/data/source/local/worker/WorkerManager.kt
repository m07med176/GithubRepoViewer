package tech.vodafone.githuprepoviewer.data.source.local.worker

import android.content.Context
import androidx.work.*
import tech.vodafone.githuprepoviewer.data.source.local.LocalConfig
import java.util.*
import java.util.concurrent.TimeUnit

object WorkerManager {

    fun keepWorkerRunning(context: Context) {
        if (checkIfWorkerRunning(context))
            initializeWorker(context)
    }

    private fun checkIfWorkerRunning(context: Context): Boolean {
        val worker = WorkManager.getInstance(context)
            .getWorkInfoById(UUID(LocalConfig.WORKER_ID, 0))
        return worker.isCancelled
    }

    private fun initializeWorker(context: Context) {
        val data = Data.Builder()
        data.putLong("id", LocalConfig.WORKER_ID)

        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .build()

        val periodicWokrRequest = PeriodicWorkRequest.Builder(
            RemoveCashWorker::class.java, 24, TimeUnit.HOURS
        )
            .setConstraints(constraints)
            .setInputData(data.build())
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "${LocalConfig.WORKER_ID}",
            ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
            periodicWokrRequest
        )

    }
}
