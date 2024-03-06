package tech.vodafone.githuprepoviewer.data.source.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

//@Keep
//data class RepositoryDetailsResponse(
//    // Ids
//    @SerializedName("id")
//    val id: Int?,
//    @SerializedName("node_id")
//    val nodeId: String?,
//
//    // Names
//    @SerializedName("name")
//    val name: String?,
//
//    @SerializedName("default_branch")
//    val defaultBranch: String?,
//
//    @SerializedName("description")
//    val description: String?,
//
//    @SerializedName("full_name")
//    val fullName: String?,
//
//    @SerializedName("homepage")
//    val homepage: String?,
//
//    @SerializedName("language")
//    val language: String?,
//
//    @SerializedName("license")
//    val license: String?,
//
//    @SerializedName("visibility")
//    val visibility: String?,
//
//    // Collections
//    @SerializedName("topics")
//    val topics: List<Any?>?,
//
//    // Objects
//    @SerializedName("owner")
//    val owner: Owner?,
//
//    // Tokens
//    @SerializedName("temp_clone_token")
//    val tempCloneToken: String?,
//
//    // Timestamp
//    @SerializedName("updated_at")
//    val updatedAt: String?,
//
//    @SerializedName("pushed_at")
//    val pushedAt: String?,
//
//    @SerializedName("created_at")
//    val createdAt: String?,
//
//    // Urls
//    @SerializedName("deployments_url")
//    val deploymentsUrl: String?,
//
//    @SerializedName("archive_url")
//    val archiveUrl: String?,
//
//    @SerializedName("assignees_url")
//    val assigneesUrl: String?,
//
//    @SerializedName("blobs_url")
//    val blobsUrl: String?,
//
//    @SerializedName("branches_url")
//    val branchesUrl: String?,
//
//    @SerializedName("clone_url")
//    val cloneUrl: String?,
//
//    @SerializedName("collaborators_url")
//    val collaboratorsUrl: String?,
//
//    @SerializedName("comments_url")
//    val commentsUrl: String?,
//
//    @SerializedName("commits_url")
//    val commitsUrl: String?,
//
//    @SerializedName("compare_url")
//    val compareUrl: String?,
//
//    @SerializedName("contents_url")
//    val contentsUrl: String?,
//
//    @SerializedName("contributors_url")
//    val contributorsUrl: String?,
//
//    @SerializedName("downloads_url")
//    val downloadsUrl: String?,
//
//    @SerializedName("events_url")
//    val eventsUrl: String?,
//
//    @SerializedName("forks_url")
//    val forksUrl: String?,
//
//    @SerializedName("git_commits_url")
//    val gitCommitsUrl: String?,
//
//    @SerializedName("git_refs_url")
//    val gitRefsUrl: String?,
//
//    @SerializedName("git_tags_url")
//    val gitTagsUrl: String?,
//
//    @SerializedName("git_url")
//    val gitUrl: String?,
//
//    @SerializedName("languages_url")
//    val languagesUrl: String?,
//
//    @SerializedName("hooks_url")
//    val hooksUrl: String?,
//
//    @SerializedName("html_url")
//    val htmlUrl: String?,
//
//    @SerializedName("issue_comment_url")
//    val issueCommentUrl: String?,
//
//    @SerializedName("issue_events_url")
//    val issueEventsUrl: String?,
//
//    @SerializedName("issues_url")
//    val issuesUrl: String?,
//
//    @SerializedName("keys_url")
//    val keysUrl: String?,
//
//    @SerializedName("labels_url")
//    val labelsUrl: String?,
//
//    @SerializedName("merges_url")
//    val mergesUrl: String?,
//
//    @SerializedName("milestones_url")
//    val milestonesUrl: String?,
//
//    @SerializedName("mirror_url")
//    val mirrorUrl: String?,
//
//
//    @SerializedName("notifications_url")
//    val notificationsUrl: String?,
//
//    @SerializedName("releases_url")
//    val releasesUrl: String?,
//
//    @SerializedName("ssh_url")
//    val sshUrl: String?,
//
//    @SerializedName("stargazers_url")
//    val stargazersUrl: String?,
//
//    @SerializedName("statuses_url")
//    val statusesUrl: String?,
//
//    @SerializedName("pulls_url")
//    val pullsUrl: String?,
//
//    @SerializedName("url")
//    val url: String?,
//
//    @SerializedName("trees_url")
//    val treesUrl: String?,
//
//    @SerializedName("subscribers_url")
//    val subscribersUrl: String?,
//
//    @SerializedName("subscription_url")
//    val subscriptionUrl: String?,
//
//    @SerializedName("svn_url")
//    val svnUrl: String?,
//
//    @SerializedName("tags_url")
//    val tagsUrl: String?,
//
//    @SerializedName("teams_url")
//    val teamsUrl: String?,
//
//    // Numbers
//    @SerializedName("network_count")
//    val networkCount: Int?,
//
//    @SerializedName("open_issues")
//    val openIssues: Int?,
//
//    @SerializedName("open_issues_count")
//    val openIssuesCount: Int?,
//
//    @SerializedName("forks")
//    val forks: Int?,
//
//    @SerializedName("forks_count")
//    val forksCount: Int?,
//
//    @SerializedName("watchers")
//    val watchers: Int?,
//
//    @SerializedName("watchers_count")
//    val watchersCount: Int?,
//
//    @SerializedName("subscribers_count")
//    val subscribersCount: Int?,
//
//    @SerializedName("stargazers_count")
//    val stargazersCount: Int?,
//
//    @SerializedName("size")
//    val size: Int?,
//
//    // Check Boolean
//    @SerializedName("allow_forking")
//    val allowForking: Boolean?,
//
//    @SerializedName("disabled")
//    val disabled: Boolean?,
//
//    @SerializedName("fork")
//    val fork: Boolean?,
//
//    @SerializedName("archived")
//    val archived: Boolean?,
//
//    @SerializedName("private")
//    val private: Boolean?,
//
//    @SerializedName("web_commit_signoff_required")
//    val webCommitSignoffRequired: Boolean?,
//
//    @SerializedName("has_discussions")
//    val hasDiscussions: Boolean?,
//
//    @SerializedName("has_downloads")
//    val hasDownloads: Boolean?,
//
//    @SerializedName("has_issues")
//    val hasIssues: Boolean?,
//
//    @SerializedName("has_pages")
//    val hasPages: Boolean?,
//
//    @SerializedName("has_projects")
//    val hasProjects: Boolean?,
//
//    @SerializedName("has_wiki")
//    val hasWiki: Boolean?,
//
//    @SerializedName("is_template")
//    val isTemplate: Boolean?,
//)