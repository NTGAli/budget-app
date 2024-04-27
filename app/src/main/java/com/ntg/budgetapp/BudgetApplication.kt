package com.ntg.budgetapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BudgetApplication : Application() {
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
