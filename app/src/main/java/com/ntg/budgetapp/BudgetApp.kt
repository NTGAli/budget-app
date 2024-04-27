package com.ntg.budgetapp

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.ntg.budgetapp.core.util.ProfileVerifierLogger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BudgetApp : Application() {
//    @Inject
//    lateinit var imageLoader: dagger.Lazy<ImageLoader>
//
//    @Inject
//    lateinit var profileVerifierLogger: ProfileVerifierLogger

    override fun onCreate() {
        super.onCreate()
        // Initialize Sync; the system responsible for keeping data in the app up to date.
//        Sync.initialize(context = this)
//        profileVerifierLogger()
    }


//    override fun newImageLoader(): ImageLoader = imageLoader.get()
}
