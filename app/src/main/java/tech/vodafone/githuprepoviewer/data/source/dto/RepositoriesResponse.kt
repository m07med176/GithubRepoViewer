package tech.vodafone.githuprepoviewer.data.source.dto

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import tech.vodafone.githuprepoviewer.domain.utils.DomainMapping
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity

@Keep
class RepositoriesResponse : ArrayList<RepositoriesResponseModel>(),
    DomainMapping<List<ReposEntity>> {
    override fun toDomainModel() = map {
        ReposEntity(
            name = it.name,
            description = it.description,
            owner = it.owner?.login,
            starCount = it.id
        )
    }
}

fun ReposEntity.toDTO(): RepositoriesResponseModel {
    return RepositoriesResponseModel(
        id = this.id?:0,
        name = this.name,
        description = this.description,
        owner = Owner(login = this.owner, id = this.ownerId?:0),
    )
}

fun RepositoriesResponseModel.toDomainModel(): ReposEntity {
    return ReposEntity(
        name = this.name,
        description = this.description,
        owner = this.owner?.login,
        starCount = this.id
    )
}

@Keep
@Entity(tableName = "cash_table")
data class RepositoriesResponseModel(

    // Ids
    @SerializedName("id")
    val id: Int,

    // Names
    @SerializedName("full_name")
    val fullName: String? = null,

    @PrimaryKey
    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String? = null,

    // Objects
    @SerializedName("owner")
    val owner: Owner? = null,

    )

