package com.kkalfas.lorempicsum.app.di

import android.content.Context
import com.kkalfas.lorempicsum.network.domain.KtorClientAdapter
import com.kkalfas.lorempicsum.network.domain.NetworkHandler
import com.kkalfas.lorempicsum.photo.data.PhotoApi
import com.kkalfas.lorempicsum.photo.domain.PhotoService
import com.kkalfas.lorempicsum.profile.data.UserApi
import com.kkalfas.lorempicsum.profile.domain.UserService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.engine.android.Android
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Singleton
    @Binds
    abstract fun providePhotoService(api: PhotoApi): PhotoService

    @Singleton
    @Binds
    abstract fun provideUserService(api: UserApi): UserService

    companion object {
        @Singleton
        @Provides
        fun provideKtorClient(): KtorClientAdapter = KtorClientAdapter.Impl(Android.create())

        @Singleton
        @Provides
        fun provideNetworkHandler(@ApplicationContext context: Context) = NetworkHandler(context)
    }
}
