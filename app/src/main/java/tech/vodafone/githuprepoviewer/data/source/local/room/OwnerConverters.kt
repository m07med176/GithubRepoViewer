package tech.vodafone.githuprepoviewer.data.source.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import tech.vodafone.githuprepoviewer.data.source.dto.Owner
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

interface ConverterModel

fun ConverterModel.toJson(): String = Gson().toJson(this)

inline fun <reified T : ConverterModel> String.fromJson(): T = Gson().fromJson(this, T::class.java)

class CashConverters {
    @TypeConverter
    fun fromStringToOwnerModel(content: String?): Owner? {
        return content?.let { it.fromJson<Owner>() }
    }

    @TypeConverter
    fun fromOwnerModelToString(content: Owner?): String? {
        return content?.let { it.toJson() }
    }
}