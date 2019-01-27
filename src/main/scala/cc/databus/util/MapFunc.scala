package cc.databus.util

object MapFunc extends App {
  val map1 = Map(
    "Vincent" -> List("Java", "Scala"),
    "Raye" ->List("Scala", "C++"))
  val map2 = Map(
    "Edward" -> List("Python", "Java"),
    "Toni" -> List("Go", "Bash"),
    "Vincent" -> List("Go", "Scala", "JavaScript"))
  val map3 = Map("Test" -> List("Nothing"), "Check" -> List)

  println(map1 ++ map2)
}
