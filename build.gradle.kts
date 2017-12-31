import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.10"
    id("nebula.release") version "6.1.1"
}

group = "com.bnorm.rskotlin"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.21")
}

kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

task<Wrapper>("wrapper") {
    gradleVersion = "4.4"
    distributionType = Wrapper.DistributionType.ALL
}
