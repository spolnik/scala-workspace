package com.traits

trait Logger {
  def log(message: String) { }
}

trait ConsoleLogger extends Logger {
  override def log(message: String) = println(message)
}

trait TimestampLogger extends Logger {
  override def log(message: String): Unit = {
    super.log(s"${new java.util.Date()} $message")
  }
}

trait ShortLogger extends Logger {
  val maxLength = 15

  override def log(message: String): Unit = {
    super.log(
      if (message.length <= maxLength)
        message
      else
        s"${message.substring(0, maxLength - 3)}..."
    )
  }
}

class SavingAccount extends Logger {
  var balance = 0.0

  def credit(amount: Double) = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    if (amount > balance)
      log("Insufficient funds")
    else {
      log(s"Withdrew $amount$$.")
      balance -= amount
      balance
    }
  }
}

object SavingAccountWithLogger extends App {
  val account = new SavingAccount
  println(account.withdraw(3.3))
  println(account.credit(4.4))
  println(account.withdraw(3.3))
}

object SavingAccountWithConsoleLogger extends App {
  val account = new SavingAccount with ConsoleLogger
  println(account.withdraw(3.3))
  println(account.credit(4.4))
  println(account.withdraw(3.3))
}

object SavingAccountWithConsoleLoggerWithTimestampLoggerWithShortLogger extends App {
  val account = new SavingAccount with ConsoleLogger with TimestampLogger with ShortLogger
  println(account.withdraw(3.3))
  println(account.credit(4.4))
  println(account.withdraw(3.3))
}

object SavingAccountWithConsoleLoggerWithShortLoggerWithTimestampLogger extends App {
  val account = new SavingAccount with ConsoleLogger with ShortLogger with TimestampLogger
  println(account.withdraw(3.3))
  println(account.credit(4.4))
  println(account.withdraw(3.3))
}