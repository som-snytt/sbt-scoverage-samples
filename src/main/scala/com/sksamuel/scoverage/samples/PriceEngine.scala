package com.sksamuel.scoverage.samples

import akka.actor.{Cancellable, Actor}
import scala.annotation.nowarn
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

/**
 * Produces quotes on a regular basis for all instruments and
 * broadcasts to the event stream.
 *
 * @author Stephen Samuel */
class PriceEngine(generator: QuoteGenerator) extends Actor {

  var cancellable: Cancellable = _

  @nowarn
  def receive = {
    case StartService =>
      stop()
      cancellable = context.system.scheduler.schedule(100 milliseconds, 100 milliseconds) {
        val quote = generator.generate
        context.system.eventStream.publish(quote)
      }
    case StopService =>
      stop()
  }

  def stop(): Unit = {
    if (cancellable != null)
      cancellable.cancel()
  }

  override def preStart(): Unit = {
    self ! StartService
  }
}
