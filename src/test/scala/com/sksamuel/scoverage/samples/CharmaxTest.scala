package com.sksamuel.scoverage.samples

import org.scalatest._, freespec._, matchers.should._

class CharmaxTest extends AnyFreeSpec with Matchers {

  "a char max" - {
    "should not crash the XML writer" in {
      Charmax.foo('5') shouldBe true
    }
  }
}
