plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.compose)
    alias(libs.plugins.nowinandroid.android.hilt)
}

android {
    namespace = "com.ntg.budgetapp.core.analytics"

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    implementation(libs.androidx.compose.runtime)

    prodImplementation(platform(libs.firebase.bom))
    prodImplementation(libs.firebase.analytics)
}
