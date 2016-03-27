package com.currying

object until_loop extends App {

  var x = 10
  until (x == 0) {
    x -= 1
    println(x)
  }

  def until(condition: => Boolean)(block: => Unit): Unit = {
      if (!condition) {
        block
        until(condition)(block)
      }
  }
}
