package tech.vodafone.githuprepoviewer.domain.entities

// repository's name, owner, description, and star count
data class ReposEntity(
    val id:Int?=null,
    val ownerId:Int?=null,
    val name: String,
    val description: String?=null,
    val owner: String?=null,
    val starCount: Int?=null
)