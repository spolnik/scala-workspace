package nprogramming

import akka.actor.{Props, ActorSystem}

object ScalaBotMain extends App {
  val system = ActorSystem("helloakka")

  val akkaBot = system.actorOf(Props[ScalaAkkaBot], "akkaBot")

  println("ScalaBotMain Actor System was created")

  akkaBot ! ScalaAkkaBot.Move(ScalaAkkaBot.FORWARD)
  akkaBot ! ScalaAkkaBot.Move(ScalaAkkaBot.BACKWARDS)
  akkaBot ! ScalaAkkaBot.Stop
}
