package com.kkalfas.lorempicsum.app.di

import com.kkalfas.lorempicsum.photo.data.PhotoRepositoryImpl
import com.kkalfas.lorempicsum.photo.domain.PhotoRepository
import com.kkalfas.lorempicsum.profile.data.UserRepositoryImpl
import com.kkalfas.lorempicsum.profile.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun providePhotoRepository(repository: PhotoRepositoryImpl): PhotoRepository

    @Singleton
    @Binds
    abstract fun provideUserRepository(repository: UserRepositoryImpl): UserRepository
}
