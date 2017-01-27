name := """solid-enigma"""
version := "0.1"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq (
  "org.apache.spark" %% "spark-core" % "2.1.0",
  "com.holdenkarau" %% "spark-testing-base" % "2.1.0_0.6.0",
  "org.apache.spark" %% "spark-sql" % "2.1.0",
  "org.apache.spark" %% "spark-mllib" % "2.1.0",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)
