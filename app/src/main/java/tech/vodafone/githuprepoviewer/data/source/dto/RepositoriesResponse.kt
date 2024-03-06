package tech.vodafone.githuprepoviewer.data.source.dto

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import tech.vodafone.githuprepoviewer.data.source.local.room.ConverterModel

@Keep
class RepositoriesResponse : ArrayList<RepositoriesResponseModel>()

@Keep
@Entity(tableName = "cash_table")
data class RepositoriesResponseModel(

    // Ids
    @SerializedName("id")
    @PrimaryKey
    val id: Int,

    // Names
    @SerializedName("full_name")
    val fullName: String?=null,

    @SerializedName("name")
    val name: String?=null,

    @SerializedName("description")
    val description: String?=null,

    // Objects
    @SerializedName("owner")
    val owner: Owner?=null,

)

