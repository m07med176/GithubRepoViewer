package tech.vodafone.githuprepoviewer.domain.utils



interface DomainMapping<out D>{
    fun toDomainModel():D
}


