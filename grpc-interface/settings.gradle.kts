
rootProject.name = "grpc-interface"

pluginManagement {
    val kotlinVersion: String by settings
    val protobufPluginVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "com.google.protobuf" -> useVersion(protobufPluginVersion)
            }
        }
    }
}
