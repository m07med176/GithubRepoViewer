package tech.vodafone.githuprepoviewer.data.source.local

object LocalConfig {
    //  Room cash
    const val DB_NAME = "room.db"
    const val DB_VERSION = 2
    private const val MAX_AGE = 7
    const val  MAX_AGE_MILLI = MAX_AGE * 24 * 60 * 60 * 1000
    const val WORKER_ID:Long = 2554
}