package cc.databus.spark

object ListOp extends App {
  val l = List(1,2,3)
  val s = l match {
    case list @ List(1, _*) => s"a start value is 1 list :$list"
    case list : List[_] => s"a start value not 1 list"
  }

  println(s)
}
