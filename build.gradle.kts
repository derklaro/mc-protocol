/*
 * This file is part of mc-protocol-generator, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2023 Pasqual K. and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

plugins {
  id("java")
  id("checkstyle")
  id("application")
  id("com.diffplug.spotless") version "6.13.0"
  id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.derklaro"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://maven.fabricmc.net/")
}

dependencies {
  val markdown4j = "1.0"
  implementation("fun.mingshan", "markdown4j", markdown4j)

  val guava = "31.1-jre"
  implementation("com.google.guava", "guava", guava)

  val slf4j = "2.0.6"
  implementation("org.slf4j", "slf4j-api", slf4j)

  val gson = "2.10.1"
  implementation("com.google.code.gson", "gson", gson)

  val enigma = "2.2.0"
  implementation("cuchaz", "enigma", enigma)

  val argparse4j = "0.9.0"
  implementation("net.sourceforge.argparse4j", "argparse4j", argparse4j)

  val reflexion = "1.8.0"
  implementation("dev.derklaro.reflexion", "reflexion", reflexion)

  val fastutil = "8.5.11" // needed internally for minecraft, do not remove
  implementation("it.unimi.dsi", "fastutil", fastutil)

  val netty = "4.1.87.Final"
  runtimeOnly("io.netty", "netty-buffer", netty)

  val lombok = "1.18.24"
  compileOnly("org.projectlombok", "lombok", lombok)
  annotationProcessor("org.projectlombok", "lombok", lombok)
}

tasks.withType<JavaCompile>().configureEach {
  sourceCompatibility = JavaVersion.VERSION_17.toString()
  targetCompatibility = JavaVersion.VERSION_17.toString()
  // options
  options.encoding = "UTF-8"
  options.isIncremental = true
}

java {
  sourceSets["main"].java {
    srcDir("src/bridge/java")
  }
}

checkstyle {
  maxErrors = 0
  maxWarnings = 0
  configFile = rootProject.file("checkstyle.xml")
}

extensions.configure<CheckstyleExtension> {
  toolVersion = "10.6.0"
}

spotless {
  java {
    licenseHeaderFile(rootProject.file("license_header.txt"))
  }
}

application {
  mainClass.set("dev.derklaro.protocolgenerator.GeneratorEntrypoint")
}
