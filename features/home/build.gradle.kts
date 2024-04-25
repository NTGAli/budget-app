plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    alias(libs.plugins.roborazzi)
}

android {
    namespace = "com.ntg.budgetapp.feature.foryou"
}

dependencies {
    implementation(libs.accompanist.permissions)
    implementation(project(":core:data"))
//    implementation(projects.core.domain)


}
