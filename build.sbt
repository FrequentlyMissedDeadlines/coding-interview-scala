ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "Scala Coding Interview"
  )

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.12"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % "test"

enablePlugins(JmhPlugin)