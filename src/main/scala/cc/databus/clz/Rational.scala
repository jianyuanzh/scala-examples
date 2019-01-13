package cc.databus.clz

import cc.databus.util.NumberUtils

class Rational(n: Int, d: Int) {
  require(d != 0, "分母不为0")
  private val mGcp = NumberUtils.gcp(n, d)

  val number: Int = n / mGcp
  val denom: Int = d / mGcp

  def this(n: Int) = this(n, 1)

  override def toString: String = number + "/" + denom
  def add(that: Rational): Rational =
    new Rational(
      number * that.denom + that.number * denom,
      denom * that.denom
    )

  def +(that: Rational): Rational = this.add(that)

  def *(that: Rational): Rational = new Rational(number * that.number, denom * that.denom)
}

object Rational {
  def main(args: Array[String]): Unit = {
    val ra = new Rational(1, 2)
    println(ra)

    val add = new Rational(1,2)
    val result = ra.add(add)
    println(result)

    println(new Rational(2))

    println(ra + add)
    println(ra * add)

    // * 优先级高于+
    println(ra + add * add) // should be 3/4
    println((ra + add) * add) // should be 1/2
  }
}