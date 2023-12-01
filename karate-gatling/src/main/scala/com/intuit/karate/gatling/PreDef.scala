/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://karatelabs.github.io/karate
*    Release: https://github.com/karatelabs/karate/releases/tag/v1.3.1
*    Source File: PreDef.scala
*    
*    Copyrights:
*      copyright 2017 intuit inc
*      copyright 2020 pthomas3
*      copyright 2011-2020 the bootstrap authors (https://github.com/twbs/bootstrap/graphs/contributors)
*    
*    Licenses:
*      MIT License
*      SPDXId: MIT
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
package com.intuit.karate.gatling

import io.gatling.core.session.Session

object PreDef {
  def karateProtocol(uriPatterns: (String, Seq[MethodPause])*) = new KarateProtocol(uriPatterns.toMap)
  def karateFeature(name: String, tags: String *) = new KarateFeatureActionBuilder(name, tags)
  def karateSet(key: String, valueSupplier: Session => AnyRef ) = new KarateSetActionBuilder(key, valueSupplier)
  def pauseFor(list: (String, Int)*) = list.map(mp => MethodPause(mp._1, mp._2))
}
