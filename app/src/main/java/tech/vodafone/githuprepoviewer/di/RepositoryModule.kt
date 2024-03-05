//package tech.vodafone.githuprepoviewer.di
//
//
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ViewModelComponent
//import dagger.hilt.android.scopes.ViewModelScoped
//import tech.vodafone.githuprepoviewer.data.repository.Repository
//import tech.vodafone.githuprepoviewer.data.repository.RepositoryImpl
//
//@Module
//@InstallIn(ViewModelComponent::class)
//abstract class RepositoryModule {
//
//    @Binds
//    @ViewModelScoped
//    abstract fun bindRepository(repository: RepositoryImpl): Repository
//
//}