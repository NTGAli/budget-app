dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}

plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    alias(libs.plugins.roborazzi)
}

android {
    namespace = "com.ntg.insert_transaction"
}

dependencies {
    implementation(libs.accompanist.permissions)
    implementation(project(":core:data"))
//    implementation(projects.core.domain)

    testImplementation(libs.robolectric)
    testDemoImplementation(libs.roborazzi)
}
