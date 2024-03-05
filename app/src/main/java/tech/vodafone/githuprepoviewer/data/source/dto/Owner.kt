package tech.vodafone.githuprepoviewer.data.source.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Owner(

    // Ids
    @SerializedName("id")
    val id: Int?,

    @SerializedName("gravatar_id")
    val gravatarId: String?,

    @SerializedName("node_id")
    val nodeId: String?,

    // Names
    @SerializedName("login")
    val login: String?,

    @SerializedName("type")
    val type: String?,

    // Booleans
    @SerializedName("site_admin")
    val siteAdmin: Boolean?,

    // Urls
    @SerializedName("avatar_url")
    val avatarUrl: String?,

    @SerializedName("events_url")
    val eventsUrl: String?,

    @SerializedName("followers_url")
    val followersUrl: String?,

    @SerializedName("following_url")
    val followingUrl: String?,

    @SerializedName("gists_url")
    val gistsUrl: String?,

    @SerializedName("html_url")
    val htmlUrl: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("starred_url")
    val starredUrl: String?,

    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String?,

    @SerializedName("organizations_url")
    val organizationsUrl: String?,

    @SerializedName("received_events_url")
    val receivedEventsUrl: String?,

    @SerializedName("repos_url")
    val reposUrl: String?,
)