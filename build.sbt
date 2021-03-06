import scalariform.formatter.preferences._

scalaVersion := "2.10.5"

sonatypeProfileName := "jp.co.septeni-original"

organization := "jp.co.septeni-original"

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := {
  _ => false
}

pomExtra := {
  <url>https://github.com/septeni-original/sbt-dao-generator</url>
    <licenses>
      <license>
        <name>The MIT License</name>
        <url>http://opensource.org/licenses/MIT</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:septeni-original/sbt-dao-generator.git</url>
      <connection>scm:git:github.com/septeni-original/sbt-dao-generator</connection>
      <developerConnection>scm:git:git@github.com:septeni-original/sbt-dao-generator.git</developerConnection>
    </scm>
    <developers>
      <developer>
        <id>kimutyam</id>
        <name>Akihiro Kimura</name>
      </developer>
      <developer>
        <id>j5ik2o</id>
        <name>Junichi Kato</name>
      </developer>
    </developers>
}

name := "sbt-dao-generator"

sbtPlugin := true

resolvers ++= Seq(
  "Sonatype OSS Snapshot Repository" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype OSS Release Repository" at "https://oss.sonatype.org/content/repositories/releases/",
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Seasar Repository" at "http://maven.seasar.org/maven2/"
)

libraryDependencies ++= Seq(
  "com.spotify" % "docker-client" % "2.7.7",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "org.slf4j" % "slf4j-api" % "1.7.12",
  "org.freemarker" % "freemarker" % "2.3.22",
  "org.seasar.util" % "s2util" % "0.0.1",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.h2database" % "h2" % "1.4.187" % "test"
)

scalariformSettings

ScalariformKeys.preferences :=
  ScalariformKeys.preferences.value
    .setPreference(AlignParameters, true)
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentClassDeclaration, true)
    .setPreference(PreserveDanglingCloseParenthesis, true)
    .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)

credentials <<= Def.task {
  val ivyCredentials = (baseDirectory in LocalRootProject).value / ".credentials"
  val result = Credentials(ivyCredentials) :: Nil
  result
}
