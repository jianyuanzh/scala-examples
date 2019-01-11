package cc.databus.tailrecur

object ScalaMatcher3 {
  def match_array(arr: Any) = arr match {
    case Array(0) => println("Array： 0")
    case Array(x, y) => println("Array: x=" + x + ", y=" + y)
    case Array(0, _*) => println("Array: 0-----")
    case _ => println("other")
  }

  def main(args: Array[String]): Unit = {
    match_array(Array(0))
    match_array(Array(10))
    match_array(Array(3,4))
    match_array(Array(0,2,3,4))
    match_array(Array())


    // with pattern
    val pattern = "(\\d+) (\\w+)".r
    "1234 abc" match {
      case pattern(number, chars) => println(number + "" + chars)
    }

  }
}
