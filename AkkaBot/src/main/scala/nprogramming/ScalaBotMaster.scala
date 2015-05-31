package nprogramming

import akka.actor.{Props, Actor}
import nprogramming.ScalaAkkaBot.{Move, FORWARD}
import nprogramming.ScalaBotMaster.StartChildBots

class ScalaBotMaster extends Actor {

  for (index <- 1 to 10) {
    context.actorOf(Props[ScalaAkkaBot])
  }

  override def receive: Receive = {
    case StartChildBots =>
      context.children.foreach { child =>
        println(s"child=$child")
        child ! Move(FORWARD)
      }
      println("Master has started children bots.")
    case akka.actor.Terminated(ref) =>
      println("Child has stopped...starting a new one ")
      val child = context.actorOf(Props[ScalaAkkaBot])
      context.watch(child)
  }
}

object ScalaBotMaster {

  case object StartChildBots

}