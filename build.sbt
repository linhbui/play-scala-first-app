name := """play-scala-tutorial-one"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.webjars"    %%   "webjars-play"          % "2.3.0-2",
  "org.webjars"    %    "bootstrap"             % "3.1.1-2",
  "org.webjars"    %    "bootswatch-cerulean"   % "3.3.1+2",
  "org.webjars"    %    "html5shiv"             % "3.7.0",
  "org.webjars"    %    "respond"               % "1.4.2",
  "net.sf.barcode4j" %  "barcode4j"             % "2.0"
)
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
