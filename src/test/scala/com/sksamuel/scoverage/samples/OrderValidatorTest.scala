package com.sksamuel.scoverage.samples

import subpackage1.exceptions.OrderException
import subpackage2.validators.OrderValidator
import org.scalatest._, flatspec._

/** @author Stephen Samuel */
class OrderValidatorTest extends AnyFlatSpec with OneInstancePerTest {

  "an order validator" should "throw exception" in {
    val e = intercept[OrderException] {
      new OrderValidator("CreditSuisse").validate
    }
    assert(e != null)
  }
}
