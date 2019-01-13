package cc.databus.util

object NumberUtils {
  def gcp(n: Int, b: Int): Int = if (b == 0) n else gcp(b, n % b)

  def main(args: Array[String]): Unit = {
    println(gcp(3, 2))
  }
}
