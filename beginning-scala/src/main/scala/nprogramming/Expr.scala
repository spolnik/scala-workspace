package nprogramming

sealed trait Expr

case class Add(left: Expr, right: Expr) extends Expr
case class Mul(left: Expr, right: Expr) extends Expr
case class Val(value: Int) extends Expr
case class Var(name: String) extends Expr

object Calc {

  def eval(expr: Expr, vars: Map[String, Int] = Map()): Int = expr match {
    case Add(left, right) => eval(left, vars) + eval(right, vars)
    case Mul(left, right) => eval(left, vars) * eval(right, vars)
    case Val(v) => v
    case Var(name) => vars(name)
  }

  def buildCalc(expr: Expr): Map[String,Int] => Int = expr match {
    case Add(left, right) =>
      val lf = buildCalc(left)
      val rf = buildCalc(right)
      m => lf(m) + rf(m)
    case Mul(left, right) =>
      val lf = buildCalc(left)
      val rf = buildCalc(right)
      m => lf(m) * rf(m)
    case Val(v) => m => v
    case Var(name) => m => m(name)
  }
}

object MyApp extends App {
  println(
    Calc.eval(
      Add(Val(1), Val(2))
    )
  )

  println(
    Calc.eval(
      Mul(Var("a"), Add(Var("b"), Val(3))),
      Map("a" -> 3, "b" -> 2)
    )
  )
}


