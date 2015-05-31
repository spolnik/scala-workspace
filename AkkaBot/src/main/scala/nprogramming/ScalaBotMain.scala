package nprogramming

import akka.actor.{Props, ActorSystem}

object ScalaBotMain extends App {
  val system = ActorSystem("akkabot")

  val akkaBot = system.actorOf(Props[ScalaBotMaster], "akkaBotMaster")

  println("ScalaBotMain Actor System was created")

  akkaBot ! ScalaBotMaster.StartChildBots
}
