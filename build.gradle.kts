// Gradleが内部で利用しているAntというビルドツールのクラス
// GradleにはAntライブラリが最初から含まれています。
import org.apache.tools.ant.filters.ReplaceTokens

plugins {
  base
}

tasks.register<Copy>("generateDescriptions") {
  group = "Theme park"
  description = "Generates ride descriptions including token substitution"
  from("descriptions")
  into(layout.buildDirectory.dir("descriptions"))
  filter<ReplaceTokens>("tokens" to mapOf("THEME_PARK_NAME" to "Grelephant's Wonder World"))
}

tasks.register<Zip>("zipDescriptions") {
  from(layout.buildDirectory.dir("descriptions"))
  destinationDirectory.set(layout.buildDirectory)
  archiveFileName.set("theme-park-ride.zip")
}
