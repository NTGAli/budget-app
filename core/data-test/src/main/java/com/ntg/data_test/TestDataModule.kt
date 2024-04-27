
package com.ntg.data_test

import com.ntg.data.di.DataModule
import com.ntg.data.repository.NewsRepository
import com.ntg.data.repository.UserDataRepository
import com.ntg.data_test.repository.FakeUserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class],
)
internal interface TestDataModule {
    @Binds
    fun bindsUserDataRepository(
        userDataRepository: FakeUserDataRepository,
    ): UserDataRepository


}
