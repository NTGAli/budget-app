plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.hilt)
}

android {
    namespace = "com.ntg.datastore_test"
}

dependencies {
    implementation(libs.hilt.android.testing)
    implementation(project(":core:common"))
    implementation(project(":core:datastore"))
}
