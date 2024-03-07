package tech.vodafone.githuprepoviewer.domain.utils

class NetworkException(override val message: String?,val code:Int?=null) : Throwable(message)