object rationals {
  val x = new Rational(1, 3)                      //> x  : Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3

  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  x + y                                           //> res2: Rational = 22/21

  val z = new Rational(3, 2)                      //> z  : Rational = 3/2

  x - y - z                                       //> res3: Rational = -79/42
  y + y                                           //> res4: Rational = 10/7

  x < y                                           //> res5: Boolean = true

  x max y                                         //> res6: Rational = 5/7

  val strange = new Rational(1, 1)                //> strange  : Rational = 1/1
  strange + strange                               //> res7: Rational = 2/1

  new Rational(2)                                 //> res8: Rational = 2/1


}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)

  def numer = x /g
  def denom = y /g

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def + (that: Rational) =
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)

  def unary_- : Rational = new Rational(-numer, denom)

  def - (that: Rational) = this + -that

  override def toString = numer + "/" + denom
}