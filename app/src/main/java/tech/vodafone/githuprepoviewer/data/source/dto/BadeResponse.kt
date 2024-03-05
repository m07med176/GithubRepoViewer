package tech.vodafone.githuprepoviewer.data.source.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BadeResponse(
    @SerializedName("documentation_url")
    val documentationUrl: String? = null,
    @SerializedName("message")
    val message: String? = null
)