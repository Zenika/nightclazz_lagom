organization in ThisBuild := "sample.helloworld"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.11.7"

lagomCassandraEnabled in ThisBuild := false

lazy val addApi = project("add-api")
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies += lagomJavadslApi,
    libraryDependencies += lagomJavadslImmutables
  )

lazy val addImpl = project("add-impl")
  .enablePlugins(LagomJava)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomJavadslPersistence,
      lagomJavadslTestKit
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(addApi)

lazy val divApi = project("div-api")
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies += lagomJavadslApi,
    libraryDependencies += lagomJavadslImmutables
  )

lazy val divImpl = project("div-impl")
  .enablePlugins(LagomJava)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomJavadslTestKit
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(divApi)

lazy val minApi = project("min-api")
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies += lagomJavadslApi,
    libraryDependencies += lagomJavadslImmutables
  )

lazy val minImpl = project("min-impl")
  .enablePlugins(LagomJava)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomJavadslTestKit
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(minApi)

lazy val multApi = project("mult-api")
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies += lagomJavadslApi,
    libraryDependencies += lagomJavadslImmutables
  )

lazy val multImpl = project("mult-impl")
  .enablePlugins(LagomJava)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomJavadslTestKit
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(multApi)

lazy val dispatcherApi = project("dispatcher-api")
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies += lagomJavadslApi,
    libraryDependencies += lagomJavadslImmutables
  )

lazy val dispatcherImpl = project("dispatcher-impl")
  .enablePlugins(LagomJava)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomJavadslTestKit
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(dispatcherApi)

/*lazy val frontEnd = project("front-end")
  .enablePlugins( LagomPlay)
  .settings(
    version := "1.0-SNAPSHOT"

  )*/


def project(id: String) = Project(id, base = file(id))
  .settings(eclipseSettings: _*)
  .settings(javacOptions in compile ++= Seq("-encoding", "UTF-8", "-source", "1.8", "-target", "1.8", "-Xlint:unchecked", "-Xlint:deprecation"))
  .settings(jacksonParameterNamesJavacSettings: _*) // applying it to every project even if not strictly needed.


// See https://github.com/FasterXML/jackson-module-parameter-names
lazy val jacksonParameterNamesJavacSettings = Seq(
  javacOptions in compile += "-parameters"
)


