package cn.bright.mars.controller.rest

import akka.actor._

/**
  * Description:
  *
  * @author bright
  * @date 2018/1/31
  */
class Kenny extends Actor {

  override def preStart(): Unit = {
    println("kenny: preStart")
  }

  override def postStop(): Unit = {
    println("kenny: postStop")
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("kenny: preRestart")
    println(s"Message: ${
      message.getOrElse(
        ' ')
    }")
    println(s"REASON: ${reason.getMessage}")
    super.preRestart(reason, message)
  }

  override def postRestart(reason: Throwable): Unit = {
    println("kenny: postRestart")
    println(s"REASON: ${reason.getMessage}")
    super.postRestart(reason)
  }

  override def receive: Receive = {
    case ForceRestart => throw new Exception("Boom!")
    case _ => println("Kenny received a message!")
  }
}

case object ForceRestart

object LifecycleDemo extends App {
  val system = ActorSystem("LifecycleDemo")
  val kenny = system.actorOf(Props[Kenny], name = "kenny")

  println("sending kenny a simple String message")
  kenny ! "hello"
  Thread.sleep(1000)

  println("make kenny restart")
  kenny ! ForceRestart
  Thread.sleep(1000)

  println("stopping kenny")
  system.stop(kenny)

  println("shutting down system")
  system.shutdown()
}

