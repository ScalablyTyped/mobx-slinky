/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

scalaVersion := "2.13.2"
name := "slinky-mobx"
version := "0.1"

/* javascript / typescript deps */
Compile / npmDependencies ++= Seq(
  "@types/react" -> "16.9.34",
  "@types/react-dom" -> "16.9.6",
  "mobx" -> "5.15.4",
  "mobx-react" -> "6.2.2",
)

Test / npmDependencies ++= Seq(
  "react" -> "16.13.1",
  "react-dom" -> "16.13.1",
)

/* disabled because it somehow triggers many warnings */
scalaJSLinkerConfig ~= (_.withSourceMap(false))

// because npm is slow
useYarn := true

stExperimentalEnableImplicitOps := true

// say we want custom code for slinky
stFlavour := Flavour.Slinky

// focus only on these libraries
stMinimize := Selection.AllExcept("mobx", "mobx-react")

// shade into another package
stOutputPackage := "com.olvind.mobx.facade"

// Testing? let's do it manually - run Test/fastOptJS::startWebpackDevServer and go to http://localhost:8080
Test / scalaJSUseMainModuleInitializer := true
Test / scalaJSUseTestModuleInitializer := false

publishMavenStyle := true
homepage := Some(new URL("https://github.com/ScalablyTyped/mobx-slinky"))
startYear := Some(2020)
pomExtra := (
  <scm>
    <connection>scm:git:github.com:/ScalablyTyped/mobx-slinky</connection>
    <developerConnection>scm:git:git@github.com:ScalablyTyped/mobx-slinky.git</developerConnection>
    <url>github.com:ScalablyTyped/mobx-slinky.git</url>
  </scm>
    <developers>
      <developer>
        <id>oyvindberg</id>
        <name>Øyvind Raddum Berg</name>
      </developer>
    </developers>
  )
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "libs"
