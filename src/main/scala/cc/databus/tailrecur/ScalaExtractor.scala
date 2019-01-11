package cc.databus.tailrecur

object ScalaExtractor {

  def main(args: Array[String]): Unit = {
    println("Apply: " + apply("vincent", "databus.cc"))
    println("Unapply: " + unapply("vincent@logicmonitor.com"))
    println("Unapply: " + unapply("Vincent Zhang"))
  }

  def apply(user: String, domain: String): String = {
    user + "@" + domain
  }

  def unapply(arg: String): Option[(String, String)] = {
    val parts = arg split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1))
    }
    else {
      None
    }
  }
}
