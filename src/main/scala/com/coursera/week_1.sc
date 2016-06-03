
object session {

  def and(x: Boolean, y: => Boolean) = if (x) y else false
  and(true, false)
  and(true, true)
  and(false, true)
  and(false, false)

  def or(x: Boolean, y: => Boolean) = if (x) true else y
  or(true, true)
  or(true, false)
  or(false, true)
  or(false, false)

  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.0001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(2)
  sqrt(4)
  sqrt(0.1e-6)
  sqrt(0.1e-60)

  sqrt(0.001)
  sqrt(0.1e-20)
  sqrt(1.0e20)
  sqrt(1.0e50)
}