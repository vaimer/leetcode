plugins {
    kotlin("jvm") version "1.9.21"
}

allprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType(JavaCompile::class).all {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).all {
        kotlinOptions.jvmTarget = "21"
    }

    tasks.withType(Test::class).configureEach {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }
}
