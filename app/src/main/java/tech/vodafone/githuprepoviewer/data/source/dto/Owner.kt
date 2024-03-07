package tech.vodafone.githuprepoviewer.data.source.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import tech.vodafone.githuprepoviewer.data.source.local.room.ConverterModel

@Keep
data class Owner(

    // Ids
    @SerializedName("id")
    val id: Int? = null,

    // Names
    @SerializedName("login")
    val login: String? = null,

    @SerializedName("type")
    val type: String?=null,

    // Booleans
    @SerializedName("site_admin")
    val siteAdmin: Boolean? =null,

    // URls
    @SerializedName("avatar_url")
    val avatarUrl: String? =null,


): ConverterModel