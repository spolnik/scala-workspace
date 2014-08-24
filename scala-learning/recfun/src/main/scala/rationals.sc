object rationals {
  val a = new Rational(1,2)
  val b = new Rational(1,4)
  a + b

  val x = new Rational(1,3)
  val y = new Rational(5,7)
  val z = new Rational(3,2)

  x - y - z
  y + y
  x < y
  y < x
  val max = x max y max z
  new Rational(1,0)
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def + (that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def - (that: Rational) =
    this + -that

  def unary_- =
    new Rational(-numer, denom)

  def < (that: Rational) =
    numer * that.denom < that.numer * denom

  def max(that: Rational) =
    if (this < that) that else this

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)
}