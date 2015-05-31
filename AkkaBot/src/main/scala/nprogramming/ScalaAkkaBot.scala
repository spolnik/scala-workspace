package nprogramming

import akka.actor.Actor
import nprogramming.ScalaAkkaBot.{Stop, Move, Direction, FORWARD}

class ScalaAkkaBot extends Actor {
  var moving: Boolean = false
  var direction: Direction = FORWARD

  override def receive = {
    case Move(newDirection) =>
      moving = true
      direction = newDirection
      println(self.path + "is now moving " + direction)
    case Stop =>
      moving = false
      println("I stopped moving")
    case msg => unhandled(msg)
  }
}

object ScalaAkkaBot {

  sealed abstract class Direction

  case class Move(direction: Direction)

  case class RobotState(direction: Direction, moving: Boolean)

  case object FORWARD extends Direction

  case object BACKWARDS extends Direction

  case object RIGHT extends Direction

  case object LEFT extends Direction

  case object Stop

  case object GetRobotState

}