package com.example.foodhub.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.memoryCacheSettings
import com.google.firebase.firestore.persistentCacheSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Module contains all the firebase component's instance
@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    //Firestore object with offline cache settings
    @Singleton
    @Provides
    fun provideFirestore(): FirebaseFirestore {
        val settings = FirebaseFirestoreSettings.Builder()
            .setLocalCacheSettings(memoryCacheSettings { })
            .setLocalCacheSettings(persistentCacheSettings { })
            .build()
        return FirebaseFirestore.getInstance()
            .apply {
                firestoreSettings = settings
            }
    }

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

}