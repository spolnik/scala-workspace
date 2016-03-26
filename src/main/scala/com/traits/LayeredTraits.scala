package com.traits

import java.io.PrintWriter
import java.util.Date

trait Logger {
  def log(message: String) { }
  def info(message: String) { log(s"INFO: $message")}
  def warn(message: String) { log(s"WARN: $message")}
  def severe(message: String) { log(s"SEVERE: $message")}
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
  val maxLength = 20

  override def log(message: String): Unit = {
    super.log(
      if (message.length <= maxLength)
        message
      else
        s"${message.substring(0, maxLength - 3)}..."
    )
  }
}

trait FileLogger extends Logger {
  val filename: String
  val out = new PrintWriter(filename)
  out.println(s"# ${new Date().toString}")

  override def log(message: String): Unit = { out.println(message); out.flush() }
}

class Account {
  var balance = 0.0
}

class SavingAccount extends Account with Logger {

  def credit(amount: Double) = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    if (amount > balance)
      warn("Insufficient funds")
    else {
      info(s"Withdrew $amount$$.")
      balance -= amount
      balance
    }
  }
}

object SavingAccountWithLogger extends App {

  def processAccount(account: SavingAccount) = {
    account.withdraw(3.3)
    println(account.credit(4.4))
    println(account.withdraw(3.3))
  }

  processAccount(new SavingAccount)
  processAccount(new SavingAccount with ConsoleLogger)
  processAccount(new SavingAccount with ConsoleLogger with TimestampLogger with ShortLogger)
  processAccount(new SavingAccount with ConsoleLogger with ShortLogger with TimestampLogger)
  processAccount(new { val filename = "app.log"} with SavingAccount with FileLogger with TimestampLogger)
}