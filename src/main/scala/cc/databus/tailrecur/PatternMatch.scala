package cc.databus.tailrecur

import scala.util.matching.Regex

object PatternMatch {
  def main(args: Array[String]): Unit = {
    val pattern = "scala".r
    val str = "Scala scala is interesting"
    println(pattern.findFirstIn(str).get)

    val pattern2 = "(S|s)cala".r
    val str2 = "Scala is scalable language"
    println(pattern2.findAllIn(str2).mkString(","))

    // replace
    val pattern3 = new Regex("(S|s)cala")
    println(pattern3.replaceFirstIn(str2, "Java"))

    val pattern4 = "[Ss]cala".r
    println(pattern4 findFirstIn str2)

  }
}
