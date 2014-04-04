import play.Project._

name := "hello-sap-hana"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  "org.webjars" %% "webjars-play" % "2.2.0", 
  "org.webjars" % "bootstrap" % "2.3.1"
)

playScalaSettings
