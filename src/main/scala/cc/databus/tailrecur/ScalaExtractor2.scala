package cc.databus.tailrecur

object ScalaExtractor2 {
  def main(args: Array[String]): Unit = {
    val x = ScalaExtractor2(10)
    println(x)
    x match
    {
      case ScalaExtractor2(num) => println(x + " 是 " + num + "的两倍")
      case _ => println("无法计算")
    }
  }

  def apply(x: Int) = x * 2

  def unapply(x: Int) = if (x % 2 == 0) Some(x / 2) else None
}
