package de.tobiasroeser.mill.vaadin.worker

import mill.api.Logger

trait MillVaadinConfig {
  def compatTargetDir: os.Path

  def debugEnabled: Boolean = false
  def eagerServerLoad: Boolean = false
  def projectBasePath: os.Path
  def buildFolder: String
  def buildOutputPath: os.Path = compatTargetDir
  def vaadinBuildOutputPath: os.Path = buildOutputPath / "classes"
  def resourcePath: os.Path = projectBasePath / "src" / "main" / "resources"
  def frontendResourcePath: os.Path = resourcePath / "META-INF" / "resources" / "frontend"
  def applicationPropertiesPath: os.Path = resourcePath / "application.properties"
  def sourcePath: os.Path = projectBasePath / "src" / "main" / "java"
  def frontendPath: os.Path = projectBasePath / "frontend"
  def generatedPath: os.Path = compatTargetDir / "frontend"
  def generatedTsPath: os.Path = frontendPath / "generated"
  def npmWorkPath: os.Path = projectBasePath
  def productionMode: Boolean = false
  def classpath: Seq[os.Path]
  def webpackOutPath: os.Path = vaadinBuildOutputPath / "META-INF" / "VAADIN" / "webapp"
  def resourceOutputPath: os.Path = vaadinBuildOutputPath / "META-INF" / "VAADIN"
  def pnpmEnabled: Boolean = false

  override def toString(): String = Map(
    "debugEnabled" -> productionMode,
    "eagerServerLoad" -> eagerServerLoad,
    "projectBasePath" -> projectBasePath,
    "buildFolder" -> buildFolder,
    "vaadinBuildOutputPath" -> vaadinBuildOutputPath,
    "resourcePath" -> resourcePath,
    "frontendResourcePath" -> frontendResourcePath,
    "applicationPropertiesPath" -> applicationPropertiesPath,
    "sourcePath" -> sourcePath,
    "frontendPath" -> frontendPath,
    "generatedPath" -> generatedPath,
    "generatedTsPath" -> generatedTsPath,
    "npmWorkPath" -> npmWorkPath,
    "productionMode" -> productionMode,
    "classpath" -> classpath,
    "webpackOutPath" -> webpackOutPath,
    "resourceOutputPath" -> resourceOutputPath
  ).mkString(getClass.getSimpleName + "(\n  ", ",\n  ", "\n)")
}
