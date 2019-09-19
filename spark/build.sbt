import sbtassembly.PathList

name := "spark"

version := "0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq (
  "org.apache.shiro" % "shiro-core" % "1.3.2",
  "org.apache.shiro" % "shiro-web" % "1.3.2",
  "org.apache.shiro" % "shiro-ehcache" % "1.4.0-RC2",
  "org.scalaj" % "scalaj-http_2.12" % "2.4.1",
  "com.alibaba" % "fastjson" % "1.2.58",
  "org.eclipse.jetty" % "jetty-plus" % "9.2.13.v20150730" ,
  "org.eclipse.jetty" % "jetty-webapp" % "9.2.13.v20150730" ,
  "io.netty" % "netty-all" % "5.0.0.Alpha2",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "org.scalikejdbc" %% "scalikejdbc" % "2.5.2",
  "org.projectlombok" % "lombok" % "1.18.8"
)

lazy val app = (project in file(".")).settings(
    name := "fat-jar-test"
  ).enablePlugins()

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs@_*) => MergeStrategy.first
  //        case PathList("com", "fasterxml", xs @ _*) => MergeStrategy.filterDistinctLines
  case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
  case n if n.startsWith("reference.conf") => MergeStrategy.concat
  case n if n.endsWith(".conf") => MergeStrategy.concat
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case PathList("org", "slf4j", xs@_*) => MergeStrategy.last
  case PathList(ps@_*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.last
  case PathList(ps@_*) if ps.last endsWith "ILoggerFactory.class" => MergeStrategy.last
  case x => MergeStrategy.first
}