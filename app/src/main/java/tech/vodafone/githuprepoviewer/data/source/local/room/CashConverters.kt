package tech.vodafone.githuprepoviewer.data.source.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseItem

class CashConverters {
    @TypeConverter
    fun fromStringToCashRepository(weather: String?): RepositoriesResponseItem? {
        return weather?.let { Gson().fromJson(it, RepositoriesResponseItem::class.java) }
    }

    @TypeConverter
    fun fromCashRepositoryToString(weather: RepositoriesResponseItem?): String? {
        return weather?.let { Gson().toJson(it) }
    }
}