import sbt._
import Keys._
import Defaults._
import com.typesafe.sbtscalariform.ScalariformPlugin

object PluginBuild extends Build {
  
  // Plugins included here are exported to projects that use this plugin because
  // they are dependencies of the plugin itself and not associated with the 
  // build definition as plugins usually are.
  
  lazy val main = Project("sbt-frontend-build", file("."))
    .settings(ScalariformPlugin.settings: _*)
    .settings(
      name := "sbt-frontend-build",
      organization := "com.gu",
      sbtPlugin := true,
      
      resolvers += Resolver.url("sbt-plugin-releases", 
          new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns),

      resolvers ++= Seq(
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
        "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
      ),
      
      addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.7.4"),
      addSbtPlugin("play" % "sbt-plugin" % "2.0"),
      addSbtPlugin("com.typesafe.sbtscalariform" % "sbtscalariform" % "0.3.1"),
      addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.0.0"),
      addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.0.0")
    )
    .dependsOn(uri("git://github.com/guardian/sbt-version-info-plugin.git#2.1"))

}