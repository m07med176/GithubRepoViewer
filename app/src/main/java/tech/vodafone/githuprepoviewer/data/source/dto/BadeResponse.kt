package tech.vodafone.githuprepoviewer.data.source.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BadeResponse(
    @SerializedName("documentation_url")
    val documentationUrl: String?,
    @SerializedName("message")
    val message: String?
)