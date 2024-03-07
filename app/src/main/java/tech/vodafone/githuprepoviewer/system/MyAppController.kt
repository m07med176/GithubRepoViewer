package tech.vodafone.githuprepoviewer.system

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import tech.vodafone.githuprepoviewer.data.source.local.worker.WorkerManager

@HiltAndroidApp
class MyAppController:Application(){
    override fun onCreate() {
        super.onCreate()
        WorkerManager.keepWorkerRunning(applicationContext)
    }
}