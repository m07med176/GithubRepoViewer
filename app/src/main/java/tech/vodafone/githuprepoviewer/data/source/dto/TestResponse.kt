package tech.vodafone.githuprepoviewer.data.source.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RepositoryDetailsResponse(
    @SerializedName("allow_forking")
    val allowForking: Boolean? = null,

    @SerializedName("archive_url")
    val archiveUrl: String? = null,

    val archived: Boolean? = null,

    @SerializedName("assignees_url")
    val assigneesUrl: String? = null,

    @SerializedName("blobs_url")
    val blobsUrl: String? = null,
    @SerializedName("branches_url")
    val branchesUrl: String? = null,
    @SerializedName("clone_url")
    val cloneUrl: String? = null,
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String? = null,
    @SerializedName("comments_url")
    val commentsUrl: String? = null,
    @SerializedName("commits_url")
    val commitsUrl: String? = null,
    @SerializedName("compare_url")
    val compareUrl: String? = null,
    @SerializedName("contents_url")
    val contentsUrl: String? = null,
    @SerializedName("contributors_url")
    val contributorsUrl: String? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("default_branch")
    val defaultBranch: String? = null,
    @SerializedName("deployments_url")
    val deploymentsUrl: String? = null,
    val description: String? = null,
    val disabled: Boolean? = null,
    @SerializedName("downloads_url")
    val downloadsUrl: String? = null,
    @SerializedName("events_url")
    val eventsUrl: String? = null,
    val fork: Boolean? = null,
    val forks: Int? = null,
    @SerializedName("forks_count")
    val forksCount: Int? = null,
    @SerializedName("forks_url")
    val forksUrl: String? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String? = null,
    @SerializedName("git_refs_url")
    val gitRefsUrl: String? = null,
    @SerializedName("git_tags_url")
    val gitTagsUrl: String? = null,
    @SerializedName("git_url")
    val gitUrl: String? = null,
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
    val homepage: String? = null,
    @SerializedName("hooks_url")
    val hooksUrl: String? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = null,
    val id: Int? = null,
    @SerializedName("is_template")
    val isTemplate: Boolean? = null,
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String? = null,
    @SerializedName("issue_events_url")
    val issueEventsUrl: String? = null,
    @SerializedName("issues_url")
    val issuesUrl: String? = null,
    @SerializedName("keys_url")
    val keysUrl: String? = null,
    @SerializedName("labels_url")
    val labelsUrl: String? = null,
    val language: String? = null,
    @SerializedName("languages_url")
    val languagesUrl: String? = null,
    val license: License? = null,
    @SerializedName("merges_url")
    val mergesUrl: String? = null,
    @SerializedName("milestones_url")
    val milestonesUrl: String? = null,
    @SerializedName("mirror_url")
    val mirrorUrl: Any? = null,
    val name: String? = null,
    @SerializedName("network_count")
    val networkCount: Int? = null,
    @SerializedName("node_id")
    val nodeId: String? = null,
    @SerializedName("notifications_url")
    val notificationsUrl: String? = null,
    @SerializedName("open_issues")
    val openIssues: Int? = null,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int? = null,
    val owner: Owner? = null,
    val parent: Parent? = null,
    val `private`: Boolean? = null,
    @SerializedName("pulls_url")
    val pullsUrl: String? = null,
    @SerializedName("pushed_at")
    val pushedAt: String? = null,
    @SerializedName("releases_url")
    val releasesUrl: String? = null,
    val size: Int? = null,
    val source: Source? = null,
    @SerializedName("ssh_url")
    val sshUrl: String? = null,
    @SerializedName("stargazers_count")
    val stargazersCount: Int? = null,
    @SerializedName("stargazers_url")
    val stargazersUrl: String? = null,
    @SerializedName("statuses_url")
    val statusesUrl: String? = null,
    @SerializedName("subscribers_count")
    val subscribersCount: Int? = null,
    @SerializedName("subscribers_url")
    val subscribersUrl: String? = null,
    @SerializedName("subscription_url")
    val subscriptionUrl: String? = null,
    @SerializedName("svn_url")
    val svnUrl: String? = null,
    @SerializedName("tags_url")
    val tagsUrl: String? = null,
    @SerializedName("teams_url")
    val teamsUrl: String? = null,
    @SerializedName("temp_clone_token")
    val tempCloneToken: Any? = null,
    val topics: List<Any?>? = null,
    @SerializedName("trees_url")
    val treesUrl: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    val url: String? = null,
    val visibility: String? = null,
    val watchers: Int? = null,
    @SerializedName("watchers_count")
    val watchersCount: Int? = null,
    @SerializedName("web_commit_signoff_required")
    val webCommitSignoffRequired: Boolean? = null
) {
    @Keep
    data class License(
        val key: String? = null,
        val name: String? = null,
        @SerializedName("node_id")
        val nodeId: String? = null,
        @SerializedName("spdx_id")
        val spdxId: String? = null,
        val url: String? = null
    )

    @Keep
    data class Owner(
        @SerializedName("avatar_url")
        val avatarUrl: String? = null,
        @SerializedName("events_url")
        val eventsUrl: String? = null,
        @SerializedName("followers_url")
        val followersUrl: String? = null,
        @SerializedName("following_url")
        val followingUrl: String? = null,
        @SerializedName("gists_url")
        val gistsUrl: String? = null,
        @SerializedName("gravatar_id")
        val gravatarId: String? = null,
        @SerializedName("html_url")
        val htmlUrl: String? = null,
        val id: Int? = null,
        val login: String? = null,
        @SerializedName("node_id")
        val nodeId: String? = null,
        @SerializedName("organizations_url")
        val organizationsUrl: String? = null,
        @SerializedName("received_events_url")
        val receivedEventsUrl: String? = null,
        @SerializedName("repos_url")
        val reposUrl: String? = null,
        @SerializedName("site_admin")
        val siteAdmin: Boolean? = null,
        @SerializedName("starred_url")
        val starredUrl: String? = null,
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String? = null,
        val type: String? = null,
        val url: String? = null
    )

    @Keep
    data class Parent(
        @SerializedName("allow_forking")
        val allowForking: Boolean? = null,
        @SerializedName("archive_url")
        val archiveUrl: String? = null,
        val archived: Boolean? = null,
        @SerializedName("assignees_url")
        val assigneesUrl: String? = null,
        @SerializedName("blobs_url")
        val blobsUrl: String? = null,
        @SerializedName("branches_url")
        val branchesUrl: String? = null,
        @SerializedName("clone_url")
        val cloneUrl: String? = null,
        @SerializedName("collaborators_url")
        val collaboratorsUrl: String? = null,
        @SerializedName("comments_url")
        val commentsUrl: String? = null,
        @SerializedName("commits_url")
        val commitsUrl: String? = null,
        @SerializedName("compare_url")
        val compareUrl: String? = null,
        @SerializedName("contents_url")
        val contentsUrl: String? = null,
        @SerializedName("contributors_url")
        val contributorsUrl: String? = null,
        @SerializedName("created_at")
        val createdAt: String? = null,
        @SerializedName("default_branch")
        val defaultBranch: String? = null,
        @SerializedName("deployments_url")
        val deploymentsUrl: String? = null,
        val description: String? = null,
        val disabled: Boolean? = null,
        @SerializedName("downloads_url")
        val downloadsUrl: String? = null,
        @SerializedName("events_url")
        val eventsUrl: String? = null,
        val fork: Boolean? = null,
        val forks: Int? = null,
        @SerializedName("forks_count")
        val forksCount: Int? = null,
        @SerializedName("forks_url")
        val forksUrl: String? = null,
        @SerializedName("full_name")
        val fullName: String? = null,
        @SerializedName("git_commits_url")
        val gitCommitsUrl: String? = null,
        @SerializedName("git_refs_url")
        val gitRefsUrl: String? = null,
        @SerializedName("git_tags_url")
        val gitTagsUrl: String? = null,
        @SerializedName("git_url")
        val gitUrl: String? = null,
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
        val homepage: String? = null,
        @SerializedName("hooks_url")
        val hooksUrl: String? = null,
        @SerializedName("html_url")
        val htmlUrl: String? = null,
        val id: Int? = null,
        @SerializedName("is_template")
        val isTemplate: Boolean? = null,
        @SerializedName("issue_comment_url")
        val issueCommentUrl: String? = null,
        @SerializedName("issue_events_url")
        val issueEventsUrl: String? = null,
        @SerializedName("issues_url")
        val issuesUrl: String? = null,
        @SerializedName("keys_url")
        val keysUrl: String? = null,
        @SerializedName("labels_url")
        val labelsUrl: String? = null,
        val language: String? = null,
        @SerializedName("languages_url")
        val languagesUrl: String? = null,
        val license: License? = null,
        @SerializedName("merges_url")
        val mergesUrl: String? = null,
        @SerializedName("milestones_url")
        val milestonesUrl: String? = null,
        @SerializedName("mirror_url")
        val mirrorUrl: Any? = null,
        val name: String? = null,
        @SerializedName("node_id")
        val nodeId: String? = null,
        @SerializedName("notifications_url")
        val notificationsUrl: String? = null,
        @SerializedName("open_issues")
        val openIssues: Int? = null,
        @SerializedName("open_issues_count")
        val openIssuesCount: Int? = null,
        val owner: Owner? = null,
        val `private`: Boolean? = null,
        @SerializedName("pulls_url")
        val pullsUrl: String? = null,
        @SerializedName("pushed_at")
        val pushedAt: String? = null,
        @SerializedName("releases_url")
        val releasesUrl: String? = null,
        val size: Int? = null,
        @SerializedName("ssh_url")
        val sshUrl: String? = null,
        @SerializedName("stargazers_count")
        val stargazersCount: Int? = null,
        @SerializedName("stargazers_url")
        val stargazersUrl: String? = null,
        @SerializedName("statuses_url")
        val statusesUrl: String? = null,
        @SerializedName("subscribers_url")
        val subscribersUrl: String? = null,
        @SerializedName("subscription_url")
        val subscriptionUrl: String? = null,
        @SerializedName("svn_url")
        val svnUrl: String? = null,
        @SerializedName("tags_url")
        val tagsUrl: String? = null,
        @SerializedName("teams_url")
        val teamsUrl: String? = null,
        val topics: List<Any?>? = null,
        @SerializedName("trees_url")
        val treesUrl: String? = null,
        @SerializedName("updated_at")
        val updatedAt: String? = null,
        val url: String? = null,
        val visibility: String? = null,
        val watchers: Int? = null,
        @SerializedName("watchers_count")
        val watchersCount: Int? = null,
        @SerializedName("web_commit_signoff_required")
        val webCommitSignoffRequired: Boolean? = null
    ) {
        @Keep
        data class License(
            val key: String? = null,
            val name: String? = null,
            @SerializedName("node_id")
            val nodeId: String? = null,
            @SerializedName("spdx_id")
            val spdxId: String? = null,
            val url: String? = null
        )

        @Keep
        data class Owner(
            @SerializedName("avatar_url")
            val avatarUrl: String? = null,
            @SerializedName("events_url")
            val eventsUrl: String? = null,
            @SerializedName("followers_url")
            val followersUrl: String? = null,
            @SerializedName("following_url")
            val followingUrl: String? = null,
            @SerializedName("gists_url")
            val gistsUrl: String? = null,
            @SerializedName("gravatar_id")
            val gravatarId: String? = null,
            @SerializedName("html_url")
            val htmlUrl: String? = null,
            val id: Int? = null,
            val login: String? = null,
            @SerializedName("node_id")
            val nodeId: String? = null,
            @SerializedName("organizations_url")
            val organizationsUrl: String? = null,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String? = null,
            @SerializedName("repos_url")
            val reposUrl: String? = null,
            @SerializedName("site_admin")
            val siteAdmin: Boolean? = null,
            @SerializedName("starred_url")
            val starredUrl: String? = null,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String? = null,
            val type: String? = null,
            val url: String? = null
        )
    }

    @Keep
    data class Source(
        @SerializedName("allow_forking")
        val allowForking: Boolean? = null,
        @SerializedName("archive_url")
        val archiveUrl: String? = null,
        val archived: Boolean? = null,
        @SerializedName("assignees_url")
        val assigneesUrl: String? = null,
        @SerializedName("blobs_url")
        val blobsUrl: String? = null,
        @SerializedName("branches_url")
        val branchesUrl: String? = null,
        @SerializedName("clone_url")
        val cloneUrl: String? = null,
        @SerializedName("collaborators_url")
        val collaboratorsUrl: String? = null,
        @SerializedName("comments_url")
        val commentsUrl: String? = null,
        @SerializedName("commits_url")
        val commitsUrl: String? = null,
        @SerializedName("compare_url")
        val compareUrl: String? = null,
        @SerializedName("contents_url")
        val contentsUrl: String? = null,
        @SerializedName("contributors_url")
        val contributorsUrl: String? = null,
        @SerializedName("created_at")
        val createdAt: String? = null,
        @SerializedName("default_branch")
        val defaultBranch: String? = null,
        @SerializedName("deployments_url")
        val deploymentsUrl: String? = null,
        val description: String? = null,
        val disabled: Boolean? = null,
        @SerializedName("downloads_url")
        val downloadsUrl: String? = null,
        @SerializedName("events_url")
        val eventsUrl: String? = null,
        val fork: Boolean? = null,
        val forks: Int? = null,
        @SerializedName("forks_count")
        val forksCount: Int? = null,
        @SerializedName("forks_url")
        val forksUrl: String? = null,
        @SerializedName("full_name")
        val fullName: String? = null,
        @SerializedName("git_commits_url")
        val gitCommitsUrl: String? = null,
        @SerializedName("git_refs_url")
        val gitRefsUrl: String? = null,
        @SerializedName("git_tags_url")
        val gitTagsUrl: String? = null,
        @SerializedName("git_url")
        val gitUrl: String? = null,
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
        val homepage: String? = null,
        @SerializedName("hooks_url")
        val hooksUrl: String? = null,
        @SerializedName("html_url")
        val htmlUrl: String? = null,
        val id: Int? = null,
        @SerializedName("is_template")
        val isTemplate: Boolean? = null,
        @SerializedName("issue_comment_url")
        val issueCommentUrl: String? = null,
        @SerializedName("issue_events_url")
        val issueEventsUrl: String? = null,
        @SerializedName("issues_url")
        val issuesUrl: String? = null,
        @SerializedName("keys_url")
        val keysUrl: String? = null,
        @SerializedName("labels_url")
        val labelsUrl: String? = null,
        val language: String? = null,
        @SerializedName("languages_url")
        val languagesUrl: String? = null,
        val license: License? = null,
        @SerializedName("merges_url")
        val mergesUrl: String? = null,
        @SerializedName("milestones_url")
        val milestonesUrl: String? = null,
        @SerializedName("mirror_url")
        val mirrorUrl: Any? = null,
        val name: String? = null,
        @SerializedName("node_id")
        val nodeId: String? = null,
        @SerializedName("notifications_url")
        val notificationsUrl: String? = null,
        @SerializedName("open_issues")
        val openIssues: Int? = null,
        @SerializedName("open_issues_count")
        val openIssuesCount: Int? = null,
        val owner: Owner? = null,
        val `private`: Boolean? = null,
        @SerializedName("pulls_url")
        val pullsUrl: String? = null,
        @SerializedName("pushed_at")
        val pushedAt: String? = null,
        @SerializedName("releases_url")
        val releasesUrl: String? = null,
        val size: Int? = null,
        @SerializedName("ssh_url")
        val sshUrl: String? = null,
        @SerializedName("stargazers_count")
        val stargazersCount: Int? = null,
        @SerializedName("stargazers_url")
        val stargazersUrl: String? = null,
        @SerializedName("statuses_url")
        val statusesUrl: String? = null,
        @SerializedName("subscribers_url")
        val subscribersUrl: String? = null,
        @SerializedName("subscription_url")
        val subscriptionUrl: String? = null,
        @SerializedName("svn_url")
        val svnUrl: String? = null,
        @SerializedName("tags_url")
        val tagsUrl: String? = null,
        @SerializedName("teams_url")
        val teamsUrl: String? = null,
        val topics: List<Any?>? = null,
        @SerializedName("trees_url")
        val treesUrl: String? = null,
        @SerializedName("updated_at")
        val updatedAt: String? = null,
        val url: String? = null,
        val visibility: String? = null,
        val watchers: Int? = null,
        @SerializedName("watchers_count")
        val watchersCount: Int? = null,
        @SerializedName("web_commit_signoff_required")
        val webCommitSignoffRequired: Boolean? = null
    ) {
        @Keep
        data class License(
            val key: String? = null,
            val name: String? = null,
            @SerializedName("node_id")
            val nodeId: String? = null,
            @SerializedName("spdx_id")
            val spdxId: String? = null,
            val url: String? = null
        )

        @Keep
        data class Owner(
            @SerializedName("avatar_url")
            val avatarUrl: String? = null,
            @SerializedName("events_url")
            val eventsUrl: String? = null,
            @SerializedName("followers_url")
            val followersUrl: String? = null,
            @SerializedName("following_url")
            val followingUrl: String? = null,
            @SerializedName("gists_url")
            val gistsUrl: String? = null,
            @SerializedName("gravatar_id")
            val gravatarId: String? = null,
            @SerializedName("html_url")
            val htmlUrl: String? = null,
            val id: Int? = null,
            val login: String? = null,
            @SerializedName("node_id")
            val nodeId: String? = null,
            @SerializedName("organizations_url")
            val organizationsUrl: String? = null,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String? = null,
            @SerializedName("repos_url")
            val reposUrl: String? = null,
            @SerializedName("site_admin")
            val siteAdmin: Boolean? = null,
            @SerializedName("starred_url")
            val starredUrl: String? = null,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String? = null,
            val type: String? = null,
            val url: String? = null
        )
    }
}