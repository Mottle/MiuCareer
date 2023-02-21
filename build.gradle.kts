val javaVersion = 17
val kspigotVersion = "1.19.1"

plugins {
    kotlin("jvm") version "1.8.0"
    id("io.papermc.paperweight.userdev") version "1.5.1"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
    id("xyz.jpenilla.run-paper") version "2.0.1"
}

group = "moe.liar"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // PaperMC Dependency
    paperDevBundle("1.19.3-R0.1-SNAPSHOT")

    // KSpigot dependency
    implementation("net.axay", "kspigot", kspigotVersion)
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf(
                "-Xjdk-release=$javaVersion",
            )
            jvmTarget = "$javaVersion"
        }
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(javaVersion)
    }
    assemble {
        dependsOn(reobfJar)
    }
}

bukkit {
    name = "MiuCareer"
    apiVersion = "1.19"
    authors = listOf(
        "Liar",
    )
    main = "$group.miucareer.MiuCareer"
    version = getVersion().toString()
    libraries = listOf(
        "net.axay:kspigot:$kspigotVersion",
    )
}
