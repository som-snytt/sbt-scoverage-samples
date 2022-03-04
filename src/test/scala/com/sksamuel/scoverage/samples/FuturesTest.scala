package com.sksamuel.scoverage.samples

import scala.concurrent.Await
import scala.concurrent.duration._
import org.scalatest._, funsuite._, matchers.must._

/** @author Stephen Samuel */
class FuturesTest extends AnyFunSuite with Matchers {

  lazy val futures = new Futures
  val timeout = 10.seconds

  import scala.concurrent.ExecutionContext.Implicits.global
  implicit val name = "sammy"

  test("futures happy path") {
    val person = new Person("sammy")
    Await.result(futures.insert(person), timeout).success mustEqual true
    Await.result(futures.insert(person), timeout).status mustEqual 421
  }

}

case class Person(name: String)
