package com.sksamuel.scoverage.samples

/** @author Stephen Samuel */

import org.scalatest._, flatspec._

/**
 * Tests for the DefaultArgumentsObject class
 */
class DefaultArgumentsObjectTest extends AnyFlatSpec with OneInstancePerTest {

  "DefaultArgumentsObject" should "execute the default block if no arg is given" in {
    val result = DefaultArgumentsObject.makeGreeting()
    assert(result === "Hello, world")
  }
}
