object rationals {
  val a = new Rational(1,2)
  val b = new Rational(1,4)
  a.add(b)

  val x = new Rational(1,3)
  val y = new Rational(5,7)
  val z = new Rational(3,2)

  x.sub(y).sub(z)
  y.add(y)
  x.less(y)
  y.less(x)
  x.max(y).max(z)
  new Rational(1,0)
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def sub(that: Rational) =
    add(that.neg)

  def neg =
    new Rational(-numer, denom)

  def less(that: Rational) =
    numer * that.denom < that.numer * denom

  def max(that: Rational) =
    if (this.less(that)) that else this

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)
}