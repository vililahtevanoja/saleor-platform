import Dependencies._

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "fi.rockydragons",
      scalaVersion := "2.12.12",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "Saleor Load Testing Suite",
    libraryDependencies ++= gatling
  )
