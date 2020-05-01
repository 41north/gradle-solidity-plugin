/*
 * Copyright (c) 2020 41North.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
  `java-gradle-plugin`
  `kotlin-dsl`
  `maven-publish`
  id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
  id("org.jlleitschuh.gradle.ktlint-idea") version "9.2.1"
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
  id("com.github.ben-manes.versions") version "0.28.0"
  id("com.gradle.plugin-publish") version "0.11.0"
}

apply(plugin = "io.spring.dependency-management")
apply(from = "${project.rootDir}/gradle/versions.gradle")

group = "dev.north.fortyone.gradle"
version = "0.1.1"

repositories {
  mavenLocal()
  jcenter()
  maven(url = "https://dl.bintray.com/hyperledger-org/besu-repo/")
}

gradlePlugin {
  (plugins) {
    register("solidityPlugin") {
      id = "dev.north.fortyone.solidity"
      displayName = "Gradle Solidity plugin"
      description = "Gradle plugin aimed for easing compilation of Solidity sources with docker"
      implementationClass = "dev.north.fortyone.gradle.solidity.SolidityPlugin"
    }
  }
}

pluginBundle {
  website = "https://github.com/41north/gradle-solidity-plugin"
  vcsUrl = "https://github.com/41north/gradle-solidity-plugin"
  tags = listOf("solidity", "kotlin-dsl", "docker")
}

dependencies {
  gradleApi()
  implementation("org.web3j:core")
  implementation("org.web3j:abi")
  implementation("org.web3j:utils")
}

publishing {
  repositories {
    maven(url = "build/repository")
  }
}
