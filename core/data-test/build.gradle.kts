plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.hilt)
}

android {
    namespace = "com.ntg.data.test"
}

dependencies {
    api(project(":core:data"))

    implementation(libs.hilt.android.testing)
}
