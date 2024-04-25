plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.compose)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.ntg.budgetapp.core.ui"
}

dependencies {
    api(libs.androidx.metrics)
    api(project(":core:analytics"))
    api(project(":core:designsystem"))
    api(project(":core:model"))

    implementation("androidx.compose.material3:material3")

    implementation(libs.androidx.browser)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(project(":app"))

}
