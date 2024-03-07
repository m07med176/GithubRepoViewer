package tech.vodafone.githuprepoviewer.data.source.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import tech.vodafone.githuprepoviewer.domain.utils.DomainMapping
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity

@Keep
data class RepositoryDetailsResponse(

    // IDs
    val id: Int? = null,

    @SerializedName("node_id")
    val nodeId: String? = null,


    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    val description: String? = null,
    val language: String? = null,
    val name: String? = null,
    @SerializedName("pushed_at")
    val pushedAt: String? = null,

    @SerializedName("default_branch")
    val defaultBranch: String? = null,

    val homepage: String? = null,



    val owner: Owner? = null,


    @SerializedName("updated_at")
    val updatedAt: String? = null,
    val url: String? = null,
    val visibility: String? = null,

    // Numbers
    val forks: Int? = null,
    @SerializedName("forks_count")
    val forksCount: Int? = null,

    @SerializedName("network_count")
    val networkCount: Int? = null,
    @SerializedName("open_issues")
    val openIssues: Int? = null,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int? = null,
    val watchers: Int? = null,
    @SerializedName("watchers_count")
    val watchersCount: Int? = null,
    val size: Int? = null,
    @SerializedName("stargazers_count")
    val stargazersCount: Int? = null,
    @SerializedName("subscribers_count")
    val subscribersCount: Int? = null,

    // Booleans
    @SerializedName("allow_forking")
    val allowForking: Boolean? = null,
    val disabled: Boolean? = null,
    val fork: Boolean? = null,
    @SerializedName("is_template")
    val isTemplate: Boolean? = null,
    val private: Boolean? = null,
    @SerializedName("web_commit_signoff_required")
    val webCommitSignoffRequired: Boolean? = null,
    @SerializedName("has_discussions")
    val hasDiscussions: Boolean? = null,
    @SerializedName("has_downloads")
    val hasDownloads: Boolean? = null,
    @SerializedName("has_issues")
    val hasIssues: Boolean? = null,
    @SerializedName("has_pages")
    val hasPages: Boolean? = null,
    @SerializedName("has_projects")
    val hasProjects: Boolean? = null,
    @SerializedName("has_wiki")
    val hasWiki: Boolean? = null,
): DomainMapping<DetailsRepoEntity> {
    override fun toDomainModel() = run {
        DetailsRepoEntity(
            name = name,
            owner = fullName,
            subscribersCount = subscribersCount,
            watchersCount = watchers,
            fullName = fullName,
            description = description,
            createdAt = createdAt,
            avatar = owner?.avatarUrl
        )
    }
}