package cc.databus.tailrecur

import scala.annotation.tailrec

object TailRecursion {

  /**
    * This is a tail recursion because the final action is calling gcp itself
    */
  @tailrec
  def gcp(a: Int, b: Int): Int = if (b == 0) a else gcp(b, a % b)

  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

  def main(args: Array[String]): Unit = {
    println(gcp(4, 15))
    println(factorial(5))
  }
}
