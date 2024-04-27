package com.ntg.budgetapp.di

import android.app.Activity
import android.util.Log
import android.view.Window
import com.ntg.data.repository.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object StatsModule {

//    @Binds
//    fun bindsUserDataRepository(
//        userDataRepository: FakeUserDataRepository,
//    ): UserDataRepository
//
}
