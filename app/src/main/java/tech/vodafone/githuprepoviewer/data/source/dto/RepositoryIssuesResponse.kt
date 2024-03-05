package tech.vodafone.githuprepoviewer.data.source.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class RepositoryIssuesResponse : ArrayList<RepositoryIssuesResponseItem>()

@Keep
data class RepositoryIssuesResponseItem(
    // Ids
    @SerializedName("id")
    val id: Long?,

    @SerializedName("node_id")
    val nodeId: String?,

    // Names
    @SerializedName("title")
    val title: String?,

    @SerializedName("assignee")
    val assignee: String?,

    @SerializedName("author_association")
    val authorAssociation: String?,

    // NotCategorized
    @SerializedName("active_lock_reason")
    val activeLockReason: Any?,

    @SerializedName("body")
    val body: String?,

    @SerializedName("milestone")
    val milestone: Any?,

    @SerializedName("performed_via_github_app")
    val performedViaGithubApp: Any?,

    @SerializedName("state")
    val state: String?,

    @SerializedName("state_reason")
    val stateReason: Any?,

    // Numbers
    @SerializedName("number")
    val number: Int?,


    @SerializedName("comments")
    val comments: Int?,

    // Booleans
    @SerializedName("draft")
    val draft: Boolean?,


    @SerializedName("locked")
    val locked: Boolean?,

    // Collections
    @SerializedName("assignees")
    val assignees: List<Any?>?,

    @SerializedName("labels")
    val labels: List<Any?>?,

    // Urls
    @SerializedName("url")
    val url: String?,

    @SerializedName("timeline_url")
    val timelineUrl: String?,

    @SerializedName("labels_url")
    val labelsUrl: String?,

    @SerializedName("repository_url")
    val repositoryUrl: String?,

    @SerializedName("events_url")
    val eventsUrl: String?,

    @SerializedName("html_url")
    val htmlUrl: String?,

    @SerializedName("comments_url")
    val commentsUrl: String?,

    // Timestamp
    @SerializedName("updated_at")
    val updatedAt: String?,

    @SerializedName("closed_at")
    val closedAt: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    // Objects
    @SerializedName("user")
    val user: User?,

    @SerializedName("reactions")
    val reactions: Reactions?,

    @SerializedName("pull_request")
    val pullRequest: PullRequest?,

){

    @Keep
    data class User(
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
        @SerializedName("gravatar_id")
        val gravatarId: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("login")
        val login: String?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("organizations_url")
        val organizationsUrl: String?,
        @SerializedName("received_events_url")
        val receivedEventsUrl: String?,
        @SerializedName("repos_url")
        val reposUrl: String?,
        @SerializedName("site_admin")
        val siteAdmin: Boolean?,
        @SerializedName("starred_url")
        val starredUrl: String?,
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String?,
        @SerializedName("type")
        val type: String?,
        @SerializedName("url")
        val url: String?



    )



    @Keep
    data class PullRequest(
        @SerializedName("diff_url")
        val diffUrl: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("merged_at")
        val mergedAt: Any?,
        @SerializedName("patch_url")
        val patchUrl: String?,
        @SerializedName("url")
        val url: String?
    )




    @Keep
    data class Reactions(
        @SerializedName("confused")
        val confused: Int?,
        @SerializedName("eyes")
        val eyes: Int?,
        @SerializedName("heart")
        val heart: Int?,
        @SerializedName("hooray")
        val hooray: Int?,
        @SerializedName("laugh")
        val laugh: Int?,
        @SerializedName("rocket")
        val rocket: Int?,
        @SerializedName("total_count")
        val totalCount: Int?,
        @SerializedName("url")
        val url: String?,
    )
}

