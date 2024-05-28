import net.minecraftforge.gradle.common.util.RunConfig
import wtf.gofancy.fancygradle.script.extensions.deobf

buildscript {}
plugins {
    `java-library`
    `maven-publish`
    idea
    id("net.minecraftforge.gradle") version "5.1.+"
    id("de.undercouch.download") version "5.0.1"
    id("wtf.gofancy.fancygradle") version "1.1.+"
}

evaluationDependsOnChildren()
java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

val versionMcMajor: String by project
val versionMc: String by project
val versionForge: String by project
val mappingsChannel: String by project
val mappingsVersion: String by project
val versionThis: String by project
val versionJEI: String by project
val versionBaubles: String by project
val versionThaumcraft: String by project
val versionAugmentation: String by project
val versionWonders: String by project
val versionGuideAPI: String by project
val versionPotatoes: String by project
val versionHammerLib: String by project
val versionThaumAdds: String by project
val versionPatchouli: String by project
val versionBotania: String by project
val versionBotanicAdditions: String by project
val versionExtraBotany: String by project
val versionNaturalPledge: String by project
val versionAstralSorcery: String by project
val versionCraftTweaker: String by project
val versionMTLib: String by project
val versionMoreTweaker: String by project
val versionBewitchment: String by project
val versionEmbers: String by project
val versionSoot: String by project
val versionForestry: String by project
val versionMagicBees: String by project
val versionTwilight: String by project
val versionMantle: String by project
val versionTConstruct: String by project
val versionAE2: String by project
val versionRS: String by project
val versionMysticalLib: String by project
val versionArcArc: String by project
val versionCTM: String by project
val versionXercaPaint: String by project
val versionLLibrary: String by project
val versionIceAndFire: String by project
val versionAether: String by project
val versionAetherLostContent: String by project
val versionAetherContinuation: String by project
val versionAetherAdditions: String by project

version = versionThis
group = "leppa.planarartifice"
setProperty("archivesBaseName", "planarartifice")

minecraft {
    mappings(mappingsChannel, mappingsVersion)

    runs {
        val config = Action<RunConfig> {
            properties(
                mapOf(
                    "forge.logging.markers" to "SCAN,REGISTRIES,REGISTRYDUMP,COREMODLOG",
                    "forge.logging.console.level" to "debug",
                    "fml.coreMods.load" to "leppa.planarartifice.core.PlanarArtificeCore"
                )
            )
            workingDirectory = project.file("run").canonicalPath
            source(sourceSets["main"])
        }

        create("client", config)
        create("server", config)
    }
}

fancyGradle {
    patches {
        resources
        coremods
        asm
    }
}

repositories {
    maven {
        name = "Cursemaven"
        url = uri("https://www.cursemaven.com")
        content {
            includeGroup("curse.maven")
        }
    }
    maven {
        name = "Progwml6 maven"
        url = uri("https://dvs1.progwml6.com/files/maven")
    }
    maven {
        name = "thiakil"
        url = uri("https://maven.thiakil.com")
    }
}

dependencies {
    minecraft(group = "net.minecraftforge", name = "forge", version = "${versionMc}-${versionForge}")
    implementation(fg.deobf(group = "mezz.jei", name = "jei_${versionMc}", version = versionJEI))
    implementation(group = "com.azanor.baubles", name = "Baubles", version = "${versionMcMajor}-${versionBaubles}")
    implementation(fg.deobf(group = "curse.maven", name = "thaumcraft-223628", version = versionThaumcraft))
    implementation(group = "curse.maven", name = "thaumicaugmentation-319441", version = versionAugmentation)
    implementation(group = "curse.maven", name = "thaumic-wonders-316704", version = versionWonders)
    implementation(group = "curse.maven", name = "guide-api-228832", version = versionGuideAPI)
    implementation(group = "curse.maven", name = "thaumic-potatoes-2-270721", version = versionPotatoes)
    implementation(fg.deobf(group = "curse.maven", name = "hammer-lib-247401", version = versionHammerLib))
    implementation(fg.deobf(group = "curse.maven", name = "thaumic-additions-232564", version = versionThaumAdds))
    implementation(group = "curse.maven", name = "patchouli-306770", version = versionPatchouli)
    implementation(group = "curse.maven", name = "botania-225643", version = versionBotania)
    implementation(group = "curse.maven", name = "botanic-additions-310637", version = versionBotanicAdditions)
    implementation(group = "curse.maven", name = "extrabotany-299086", version = versionExtraBotany)
    implementation(group = "curse.maven", name = "natural-pledge-247704", version = versionNaturalPledge)
    implementation(group = "curse.maven", name = "astral-sorcery-241721", version = versionAstralSorcery)
    implementation(group = "curse.maven", name = "crafttweaker-239197", version = versionCraftTweaker)
    implementation(group = "curse.maven", name = "mtlib-253211", version = versionMTLib)
    implementation(group = "curse.maven", name = "moretweaker-336569", version = versionMoreTweaker)
    implementation(group = "curse.maven", name = "bewitchment-285439", version = versionBewitchment)
    implementation(group = "curse.maven", name = "embers-rekindled-300777", version = versionEmbers)
    implementation(group = "curse.maven", name = "soot-281528", version = versionSoot)
    implementation(group = "curse.maven", name = "forestry-59751", version = versionForestry)
    implementation(group = "curse.maven", name = "magic-bees-65764", version = versionMagicBees)
    implementation(group = "curse.maven", name = "the-twilight-forest-227639", version = versionTwilight)
    implementation(fg.deobf(group = "slimeknights.mantle", name = "Mantle", version = "${versionMcMajor}-${versionMantle}"))
    implementation(fg.deobf(group = "slimeknights", name = "TConstruct", version = "${versionMc}-${versionTConstruct}"))
    implementation(group = "curse.maven", name = "applied-energistics-2-223794", version = versionAE2)
    implementation(group = "curse.maven", name = "refined-storage-243076", version = versionRS)
    implementation(group = "curse.maven", name = "mysticallib-277064", version = versionMysticalLib)
    implementation(group = "curse.maven", name = "arcane-archives-311357", version = versionArcArc)
    implementation(group = "curse.maven", name = "ctm-267602", version = versionCTM)
    implementation(group = "curse.maven", name = "joy-of-painting-350727", version = versionXercaPaint)
    implementation(group = "curse.maven", name = "llibrary-243298", version = versionLLibrary)
    implementation(group = "curse.maven", name = "ice-and-fire-dragons-264231", version = versionIceAndFire)
    implementation(group = "curse.maven", name = "aether-255308", version = versionAether)
    implementation(group = "curse.maven", name = "aether-lost-content-318602", version = versionAetherLostContent)
    implementation(group = "curse.maven", name = "aether-addon-294269", version = versionAetherContinuation)
    implementation(group = "curse.maven", name = "aether-additions-351809", version = versionAetherAdditions)
}

tasks {
    named<ProcessResources>("processResources") { 
        // this will ensure that this task is redone when the versions change.
        inputs.property("version", project.version)
        inputs.property("mcversion", versionMc)
    
        filesMatching("mcmod.info") {
            // replace version and mcversion
            expand(
                    "version" to project.version,
                    "mcversion" to versionMc
            )
        }
    }

    withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:deprecation")
    }
}

tasks.withType<Jar>() {
    manifest {
        attributes["FMLCorePlugin"] = "leppa.planarartifice.core.PlanarArtificeCore"
        attributes["FMLCorePluginContainsFMLMod"] = "true"
    }
}