package cc.databus.util

object CaseFunc extends App {

  println(caseFunc("hello"))
  println(caseFunc("wold"))

  def caseFunc(str: String): Any = {
    str match {
      case "hello" => str + "_world"
      case _ =>
    }
  }
}

