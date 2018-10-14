import org.jetbrains.dokka.gradle.DokkaTask
import org.gradle.language.jvm.tasks.ProcessResources
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val v_forgelin = "1.7.3"
val v_jei = "4.11.0.206"
val v_mantle = "1.3.2.25"
val v_minecraft_root = "1.12"
val v_minecraft = "$v_minecraft_root.2"
val v_tinkers = "2.10.1.87"


buildscript {
    repositories {
        jcenter()
        maven("http://files.minecraftforge.net/maven")
    }
    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:2.3-SNAPSHOT")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.0")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:0.9.17")
    }
}

plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.2.60"
    //id("kotlin") version "1.2.60"
    id("net.minecraftforge.gradle.forge") version "2.0.2"
    id("org.jetbrains.dokka") version "0.9.17"
}

version = "1.2.2"
group = "com.ejektaflex.pewter"

base {
    archivesBaseName = "Pewter"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

minecraft {
    version = "1.12.2-14.23.4.2765"
    runDir = "run"
    mappings = "snapshot_20171003"
}

repositories {
    jcenter()
    // Forgelin
    maven("http://maven.shadowfacts.net/")
    // Maven for JEI
    maven("http://dvs1.progwml6.com/files/maven")
    // CurseForge Maven
    maven("https://minecraft.curseforge.com/api/maven/")
    // MMD Maven
    maven("https://maven.mcmoddev.com/")
}

dependencies {
    compile("net.shadowfacts:Forgelin:$v_forgelin")
    compile("slimeknights.mantle:Mantle:$v_minecraft_root-$v_mantle")
    compile("slimeknights:TConstruct:$v_minecraft-$v_tinkers")
    compile("constructs-armory:conarm:1.12.2:1.1.2")
    deobfProvided("mezz.jei:jei_$v_minecraft:$v_jei:api")
    runtime("mezz.jei:jei_$v_minecraft:$v_jei")
    compileOnly(files("libonly/Botania+r1.10-356.jar"))
    compileOnly("angry-pixel-the-betweenlands-mod:TheBetweenlands:3.3.12:universal")
    compileOnly("com.azanor:Thaumcraft:1.12.2-6.1.BETA24")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<ProcessResources> {
    from(sourceSets["main"].resources.srcDirs) {
        include("mcmod.info")
        expand(mapOf("version" to project.version, "mcversion" to project.minecraft.version))
    }
    from(sourceSets["main"].resources.srcDirs) {
        exclude("mcmod.info")
    }
}

tasks.withType<DokkaTask> {
    outputFormat = "jekyll"
    outputDirectory = "../ModDocs/docs/"
    // No closure-specific methods for Dokka until this:
    // https://github.com/Kotlin/dokka/pull/358
}

tasks.withType<Jar> {
    from(sourceSets["main"].output)
    from(sourceSets["api"].output)
}

tasks.withType<Jar> {
    classifier = "api"
    from(sourceSets["api"].output)
    from(sourceSets["api"].allJava)
}