plugins {
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // or 21 if you have it
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // --- Spring Boot starters ---
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")


    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")


    // --- Database ---
    runtimeOnly("com.h2database:h2") // in-memory DB for quick testing

    // --- Testing ---
    testImplementation("org.springframework.boot:spring-boot-starter-test")


}

tasks.test {
    useJUnitPlatform()
}
