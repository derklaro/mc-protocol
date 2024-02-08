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
  id("application")
  id("com.diffplug.spotless") version "6.23.3"
  id("com.github.johnrengelman.shadow") version "8.1.1"
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

  val guava = "33.0.0-jre"
  implementation("com.google.guava", "guava", guava)

  val slf4j = "2.0.9"
  implementation("org.slf4j", "slf4j-api", slf4j)

  val logback = "1.4.14"
  runtimeOnly("ch.qos.logback", "logback-classic", logback)

  val jackson = "2.16.1"
  implementation("com.fasterxml.jackson.core", "jackson-databind", jackson)
  implementation("com.fasterxml.jackson.datatype", "jackson-datatype-jsr310", jackson)

  val enigma = "2.3.3"
  implementation("cuchaz", "enigma", enigma)

  val argparse4j = "0.9.0"
  implementation("net.sourceforge.argparse4j", "argparse4j", argparse4j)

  val reflexion = "1.8.0"
  implementation("dev.derklaro.reflexion", "reflexion", reflexion)

  val fastutil = "8.5.13" // needed internally for minecraft, do not remove
  runtimeOnly("it.unimi.dsi", "fastutil", fastutil)

  val joml = "1.10.5" // needed internally for minecraft, do not remove
  runtimeOnly("org.joml", "joml", joml)

  val netty = "4.1.104.Final" // needed internally for minecraft, do not remove
  runtimeOnly("io.netty", "netty-buffer", netty)
  runtimeOnly("io.netty", "netty-handler", netty)

  val lombok = "1.18.30"
  compileOnly("org.projectlombok", "lombok", lombok)
  annotationProcessor("org.projectlombok", "lombok", lombok)
}

tasks.withType<JavaCompile>().configureEach {
  sourceCompatibility = JavaVersion.VERSION_21.toString()
  targetCompatibility = JavaVersion.VERSION_21.toString()

  options.encoding = "UTF-8"
  options.isIncremental = true
}

java {
  sourceSets["main"].java {
    srcDir("src/bridge/java")
  }
}

tasks.shadowJar {
  archiveFileName.set("protocol-generator.jar")
}

spotless {
  java {
    licenseHeaderFile(rootProject.file("license_header.txt"))
  }
}

application {
  mainClass.set("dev.derklaro.protocolgenerator.GeneratorEntrypoint")
}
