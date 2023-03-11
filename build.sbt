ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "PacmanDoodle",
    version := "0.0.1",
    libraryDependencies ++= Seq(
      "org.creativescala" %% "doodle" % "0.17.0"
    )
  )
