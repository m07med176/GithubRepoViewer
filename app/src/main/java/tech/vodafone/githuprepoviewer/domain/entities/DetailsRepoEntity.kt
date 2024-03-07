package tech.vodafone.githuprepoviewer.domain.entities



data class DetailsRepoEntity(
    val name: String? = null,
    val owner: String? = null,
    val subscribersCount: Int? = null,
    val watchersCount: Int? = null,
    val avatar:String?=null,
    val fullName:String?=null,
    val createdAt:String?=null,
    val description:String?=null,
)