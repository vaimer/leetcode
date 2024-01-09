plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    // Tests
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}